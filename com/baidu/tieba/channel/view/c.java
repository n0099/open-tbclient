package com.baidu.tieba.channel.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private NoNetworkView dlW;
    private TextView eEA;
    private ChannelEditActivity eEr;
    private TbImageView eEs;
    private ImageView eEt;
    private TextView eEu;
    private TextView eEv;
    private HeadImageView eEw;
    private TextView eEx;
    private TextView eEy;
    private EditText eEz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eEB = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eEr = channelEditActivity;
        this.eEr.setIsAddSwipeBackLayout(true);
        this.eEr.setSwipeBackEnabled(true);
        this.eEr.setUseStyleImmersiveSticky(true);
        this.mContext = this.eEr.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eEr.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eEr.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eEt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eEt.setOnClickListener(this);
        this.eEu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eEu.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eEu.setOnClickListener(this);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eEs = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eEs.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eEs.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eEs.setOnClickListener(this);
        this.eEv = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eEv.setOnClickListener(this);
        this.eEw = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eEw.setIsRound(false);
        this.eEw.setRadius(0);
        this.eEw.setDrawBorder(true);
        this.eEw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eEw.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eEw.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eEw.setOnClickListener(this);
        this.eEx = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eEx.setOnClickListener(this);
        this.eEy = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eEz = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eEA = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eEz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eEr.aYt().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eEz.getText() != null) {
                    c.this.eEA.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eEz.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eEz.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eEz;
                            if (i > c.this.eEz.getText().length()) {
                                i = c.this.eEz.getText().length();
                            }
                            editText.setSelection(i);
                        }
                    }
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eEv || view == this.eEs) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eEx || view == this.eEw) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eEt) {
            if (ChannelEditActivity.isChanged) {
                this.eEB = new com.baidu.tbadk.core.dialog.a(this.eEr.getActivity());
                this.eEB.mE(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eEB.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eEr.aYs();
                    }
                });
                this.eEB.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eEr.finish();
                    }
                });
                this.eEB.b(this.eEr.getPageContext());
                this.eEB.afG();
                return;
            }
            this.eEr.finish();
        } else if (view == this.eEu) {
            this.eEr.aYs();
        }
    }

    public String getDescription() {
        return this.eEz.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eEs.startLoad(channelInfo.getChannelCover(), 10, this.eEs.getWidth(), this.eEs.getHeight(), false);
            this.eEw.startLoad(channelInfo.getChannelAvatar(), 10, this.eEw.getWidth(), this.eEw.getHeight(), false);
            this.eEy.setText(channelInfo.getChannelName());
            this.eEz.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eEr.getLayoutMode().setNightMode(i == 1);
        this.eEr.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eEr.getPageContext(), i);
        this.dlW.onChangeSkinType(this.eEr.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.eEt, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        al.f(this.eEu, R.color.cp_cont_g, 1);
        this.eEw.setBorderColor(al.getColor(R.color.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
