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
    private NoNetworkView dlX;
    private EditText eEA;
    private TextView eEB;
    private ChannelEditActivity eEs;
    private TbImageView eEt;
    private ImageView eEu;
    private TextView eEv;
    private TextView eEw;
    private HeadImageView eEx;
    private TextView eEy;
    private TextView eEz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eEC = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eEs = channelEditActivity;
        this.eEs.setIsAddSwipeBackLayout(true);
        this.eEs.setSwipeBackEnabled(true);
        this.eEs.setUseStyleImmersiveSticky(true);
        this.mContext = this.eEs.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eEs.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eEs.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eEu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eEu.setOnClickListener(this);
        this.eEv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eEv.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eEv.setOnClickListener(this);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eEt = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eEt.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eEt.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eEt.setOnClickListener(this);
        this.eEw = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eEw.setOnClickListener(this);
        this.eEx = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eEx.setIsRound(false);
        this.eEx.setRadius(0);
        this.eEx.setDrawBorder(true);
        this.eEx.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eEx.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eEx.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eEx.setOnClickListener(this);
        this.eEy = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eEy.setOnClickListener(this);
        this.eEz = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eEA = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eEB = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eEA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eEs.aYw().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eEA.getText() != null) {
                    c.this.eEB.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eEA.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eEA.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eEA;
                            if (i > c.this.eEA.getText().length()) {
                                i = c.this.eEA.getText().length();
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
        if (view == this.eEw || view == this.eEt) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eEy || view == this.eEx) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eEu) {
            if (ChannelEditActivity.isChanged) {
                this.eEC = new com.baidu.tbadk.core.dialog.a(this.eEs.getActivity());
                this.eEC.mD(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eEC.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eEs.aYv();
                    }
                });
                this.eEC.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eEs.finish();
                    }
                });
                this.eEC.b(this.eEs.getPageContext());
                this.eEC.afG();
                return;
            }
            this.eEs.finish();
        } else if (view == this.eEv) {
            this.eEs.aYv();
        }
    }

    public String getDescription() {
        return this.eEA.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eEt.startLoad(channelInfo.getChannelCover(), 10, this.eEt.getWidth(), this.eEt.getHeight(), false);
            this.eEx.startLoad(channelInfo.getChannelAvatar(), 10, this.eEx.getWidth(), this.eEx.getHeight(), false);
            this.eEz.setText(channelInfo.getChannelName());
            this.eEA.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eEs.getLayoutMode().setNightMode(i == 1);
        this.eEs.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eEs.getPageContext(), i);
        this.dlX.onChangeSkinType(this.eEs.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.eEu, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        al.f(this.eEv, R.color.cp_cont_g, 1);
        this.eEx.setBorderColor(al.getColor(R.color.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
