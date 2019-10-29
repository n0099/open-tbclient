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
    private NoNetworkView dwI;
    private ChannelEditActivity eTK;
    private TbImageView eTL;
    private ImageView eTM;
    private TextView eTN;
    private TextView eTO;
    private HeadImageView eTP;
    private TextView eTQ;
    private TextView eTR;
    private EditText eTS;
    private TextView eTT;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eTU = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eTK = channelEditActivity;
        this.eTK.setIsAddSwipeBackLayout(true);
        this.eTK.setSwipeBackEnabled(true);
        this.eTK.setUseStyleImmersiveSticky(true);
        this.mContext = this.eTK.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eTK.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eTK.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eTM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eTM.setOnClickListener(this);
        this.eTN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eTN.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eTN.setOnClickListener(this);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eTL = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eTL.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eTL.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eTL.setOnClickListener(this);
        this.eTO = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eTO.setOnClickListener(this);
        this.eTP = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eTP.setIsRound(false);
        this.eTP.setRadius(0);
        this.eTP.setDrawBorder(true);
        this.eTP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eTP.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eTP.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eTP.setOnClickListener(this);
        this.eTQ = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eTQ.setOnClickListener(this);
        this.eTR = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eTS = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eTT = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eTS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eTK.bbd().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eTS.getText() != null) {
                    c.this.eTT.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eTS.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eTS.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eTS;
                            if (i > c.this.eTS.getText().length()) {
                                i = c.this.eTS.getText().length();
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
        if (view == this.eTO || view == this.eTL) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CHANNEL_COVER);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        } else if (view == this.eTQ || view == this.eTP) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(RequestResponseCode.REQUEST_CHANNEL_AVATAR);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig2));
        } else if (view == this.eTM) {
            if (ChannelEditActivity.isChanged) {
                this.eTU = new com.baidu.tbadk.core.dialog.a(this.eTK.getActivity());
                this.eTU.nn(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eTU.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eTK.bbc();
                    }
                });
                this.eTU.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eTK.finish();
                    }
                });
                this.eTU.b(this.eTK.getPageContext());
                this.eTU.akO();
                return;
            }
            this.eTK.finish();
        } else if (view == this.eTN) {
            this.eTK.bbc();
        }
    }

    public String getDescription() {
        return this.eTS.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eTL.a(channelInfo.getChannelCover(), 10, this.eTL.getWidth(), this.eTL.getHeight(), false);
            this.eTP.a(channelInfo.getChannelAvatar(), 10, this.eTP.getWidth(), this.eTP.getHeight(), false);
            this.eTR.setText(channelInfo.getChannelName());
            this.eTS.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eTK.getLayoutMode().setNightMode(i == 1);
        this.eTK.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eTK.getPageContext(), i);
        this.dwI.onChangeSkinType(this.eTK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.setViewTextColor(this.eTN, R.color.cp_cont_g, 1);
        this.eTP.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
