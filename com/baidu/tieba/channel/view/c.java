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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
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
    private NoNetworkView dvR;
    private ChannelEditActivity eST;
    private TbImageView eSU;
    private ImageView eSV;
    private TextView eSW;
    private TextView eSX;
    private HeadImageView eSY;
    private TextView eSZ;
    private TextView eTa;
    private EditText eTb;
    private TextView eTc;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eTd = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eST = channelEditActivity;
        this.eST.setIsAddSwipeBackLayout(true);
        this.eST.setSwipeBackEnabled(true);
        this.eST.setUseStyleImmersiveSticky(true);
        this.mContext = this.eST.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eST.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eST.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eSV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eSV.setOnClickListener(this);
        this.eSW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eSW.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eSW.setOnClickListener(this);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eSU = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eSU.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eSU.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eSU.setOnClickListener(this);
        this.eSX = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eSX.setOnClickListener(this);
        this.eSY = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eSY.setIsRound(false);
        this.eSY.setRadius(0);
        this.eSY.setDrawBorder(true);
        this.eSY.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eSY.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eSY.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eSY.setOnClickListener(this);
        this.eSZ = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eSZ.setOnClickListener(this);
        this.eTa = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eTb = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eTc = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eTb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eST.bbb().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eTb.getText() != null) {
                    c.this.eTc.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eTb.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eTb.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eTb;
                            if (i > c.this.eTb.getText().length()) {
                                i = c.this.eTb.getText().length();
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
        if (view == this.eSX || view == this.eSU) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CHANNEL_COVER);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        } else if (view == this.eSZ || view == this.eSY) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(RequestResponseCode.REQUEST_CHANNEL_AVATAR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig2));
        } else if (view == this.eSV) {
            if (ChannelEditActivity.isChanged) {
                this.eTd = new com.baidu.tbadk.core.dialog.a(this.eST.getActivity());
                this.eTd.nn(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eTd.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eST.bba();
                    }
                });
                this.eTd.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eST.finish();
                    }
                });
                this.eTd.b(this.eST.getPageContext());
                this.eTd.akM();
                return;
            }
            this.eST.finish();
        } else if (view == this.eSW) {
            this.eST.bba();
        }
    }

    public String getDescription() {
        return this.eTb.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eSU.a(channelInfo.getChannelCover(), 10, this.eSU.getWidth(), this.eSU.getHeight(), false);
            this.eSY.a(channelInfo.getChannelAvatar(), 10, this.eSY.getWidth(), this.eSY.getHeight(), false);
            this.eTa.setText(channelInfo.getChannelName());
            this.eTb.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eST.getLayoutMode().setNightMode(i == 1);
        this.eST.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eST.getPageContext(), i);
        this.dvR.onChangeSkinType(this.eST.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.eSW, R.color.cp_cont_g, 1);
        this.eSY.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
