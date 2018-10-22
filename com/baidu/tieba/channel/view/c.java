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
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private NoNetworkView bJX;
    private ChannelEditActivity cTH;
    private TbImageView cTI;
    private ImageView cTJ;
    private TextView cTK;
    private TextView cTL;
    private HeadImageView cTM;
    private TextView cTN;
    private TextView cTO;
    private EditText cTP;
    private TextView cTQ;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cTR = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cTH = channelEditActivity;
        this.cTH.setIsAddSwipeBackLayout(true);
        this.cTH.setSwipeBackEnabled(true);
        this.cTH.setUseStyleImmersiveSticky(true);
        this.mContext = this.cTH.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cTH.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.cTH.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cTJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cTJ.setOnClickListener(this);
        this.cTK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.cTK.setTextSize(0, this.mContext.getResources().getDimension(e.C0175e.ds28));
        this.cTK.setOnClickListener(this);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.cTI = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.cTI.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cTI.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cTI.setOnClickListener(this);
        this.cTL = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.cTL.setOnClickListener(this);
        this.cTM = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.cTM.setIsRound(false);
        this.cTM.setRadius(0);
        this.cTM.setDrawBorder(true);
        this.cTM.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds1));
        this.cTM.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.cTM.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cTM.setOnClickListener(this);
        this.cTN = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.cTN.setOnClickListener(this);
        this.cTO = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.cTP = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.cTQ = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.cTP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cTH.aoU().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cTP.getText() != null) {
                    c.this.cTQ.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.cTP.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cTP.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cTP;
                            if (i > c.this.cTP.getText().length()) {
                                i = c.this.cTP.getText().length();
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
        if (view == this.cTL || view == this.cTI) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cTN || view == this.cTM) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cTJ) {
            if (ChannelEditActivity.isChanged) {
                this.cTR = new com.baidu.tbadk.core.dialog.a(this.cTH.getActivity());
                this.cTR.ej(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.cTR.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cTH.aoT();
                    }
                });
                this.cTR.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cTH.finish();
                    }
                });
                this.cTR.b(this.cTH.getPageContext());
                this.cTR.Au();
                return;
            }
            this.cTH.finish();
        } else if (view == this.cTK) {
            this.cTH.aoT();
        }
    }

    public String getDescription() {
        return this.cTP.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cTI.startLoad(channelInfo.getChannelCover(), 10, this.cTI.getWidth(), this.cTI.getHeight(), false);
            this.cTM.startLoad(channelInfo.getChannelAvatar(), 10, this.cTM.getWidth(), this.cTM.getHeight(), false);
            this.cTO.setText(channelInfo.getChannelName());
            this.cTP.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cTH.getLayoutMode().setNightMode(i == 1);
        this.cTH.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cTH.getPageContext(), i);
        this.bJX.onChangeSkinType(this.cTH.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.cTJ, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.cTK, e.d.cp_cont_g, 1);
        this.cTM.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
