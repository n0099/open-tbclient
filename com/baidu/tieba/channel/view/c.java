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
import com.baidu.tbadk.core.util.am;
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
    private NoNetworkView dnM;
    private HeadImageView eJA;
    private TextView eJB;
    private TextView eJC;
    private EditText eJD;
    private TextView eJE;
    private ChannelEditActivity eJv;
    private TbImageView eJw;
    private ImageView eJx;
    private TextView eJy;
    private TextView eJz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eJF = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eJv = channelEditActivity;
        this.eJv.setIsAddSwipeBackLayout(true);
        this.eJv.setSwipeBackEnabled(true);
        this.eJv.setUseStyleImmersiveSticky(true);
        this.mContext = this.eJv.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eJv.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eJv.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eJx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eJx.setOnClickListener(this);
        this.eJy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eJy.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eJy.setOnClickListener(this);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eJw = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eJw.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eJw.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eJw.setOnClickListener(this);
        this.eJz = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eJz.setOnClickListener(this);
        this.eJA = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eJA.setIsRound(false);
        this.eJA.setRadius(0);
        this.eJA.setDrawBorder(true);
        this.eJA.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eJA.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eJA.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eJA.setOnClickListener(this);
        this.eJB = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eJB.setOnClickListener(this);
        this.eJC = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eJD = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eJE = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eJD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eJv.bax().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eJD.getText() != null) {
                    c.this.eJE.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eJD.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eJD.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eJD;
                            if (i > c.this.eJD.getText().length()) {
                                i = c.this.eJD.getText().length();
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
        if (view == this.eJz || view == this.eJw) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eJB || view == this.eJA) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eJx) {
            if (ChannelEditActivity.isChanged) {
                this.eJF = new com.baidu.tbadk.core.dialog.a(this.eJv.getActivity());
                this.eJF.mO(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eJF.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eJv.baw();
                    }
                });
                this.eJF.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eJv.finish();
                    }
                });
                this.eJF.b(this.eJv.getPageContext());
                this.eJF.agK();
                return;
            }
            this.eJv.finish();
        } else if (view == this.eJy) {
            this.eJv.baw();
        }
    }

    public String getDescription() {
        return this.eJD.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eJw.startLoad(channelInfo.getChannelCover(), 10, this.eJw.getWidth(), this.eJw.getHeight(), false);
            this.eJA.startLoad(channelInfo.getChannelAvatar(), 10, this.eJA.getWidth(), this.eJA.getHeight(), false);
            this.eJC.setText(channelInfo.getChannelName());
            this.eJD.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eJv.getLayoutMode().setNightMode(i == 1);
        this.eJv.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eJv.getPageContext(), i);
        this.dnM.onChangeSkinType(this.eJv.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.a(this.eJx, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        am.f(this.eJy, R.color.cp_cont_g, 1);
        this.eJA.setBorderColor(am.getColor(R.color.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
