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
    private NoNetworkView bKI;
    private ChannelEditActivity cUN;
    private TbImageView cUO;
    private ImageView cUP;
    private TextView cUQ;
    private TextView cUR;
    private HeadImageView cUS;
    private TextView cUT;
    private TextView cUU;
    private EditText cUV;
    private TextView cUW;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cUX = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cUN = channelEditActivity;
        this.cUN.setIsAddSwipeBackLayout(true);
        this.cUN.setSwipeBackEnabled(true);
        this.cUN.setUseStyleImmersiveSticky(true);
        this.mContext = this.cUN.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cUN.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.cUN.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cUP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cUP.setOnClickListener(this);
        this.cUQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.cUQ.setTextSize(0, this.mContext.getResources().getDimension(e.C0200e.ds28));
        this.cUQ.setOnClickListener(this);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.cUO = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.cUO.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cUO.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cUO.setOnClickListener(this);
        this.cUR = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.cUR.setOnClickListener(this);
        this.cUS = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.cUS.setIsRound(false);
        this.cUS.setRadius(0);
        this.cUS.setDrawBorder(true);
        this.cUS.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds1));
        this.cUS.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.cUS.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cUS.setOnClickListener(this);
        this.cUT = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.cUT.setOnClickListener(this);
        this.cUU = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.cUV = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.cUW = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.cUV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cUN.aov().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cUV.getText() != null) {
                    c.this.cUW.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.cUV.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cUV.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cUV;
                            if (i > c.this.cUV.getText().length()) {
                                i = c.this.cUV.getText().length();
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
        if (view == this.cUR || view == this.cUO) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cUT || view == this.cUS) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cUP) {
            if (ChannelEditActivity.isChanged) {
                this.cUX = new com.baidu.tbadk.core.dialog.a(this.cUN.getActivity());
                this.cUX.ej(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.cUX.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cUN.aou();
                    }
                });
                this.cUX.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cUN.finish();
                    }
                });
                this.cUX.b(this.cUN.getPageContext());
                this.cUX.AB();
                return;
            }
            this.cUN.finish();
        } else if (view == this.cUQ) {
            this.cUN.aou();
        }
    }

    public String getDescription() {
        return this.cUV.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cUO.startLoad(channelInfo.getChannelCover(), 10, this.cUO.getWidth(), this.cUO.getHeight(), false);
            this.cUS.startLoad(channelInfo.getChannelAvatar(), 10, this.cUS.getWidth(), this.cUS.getHeight(), false);
            this.cUU.setText(channelInfo.getChannelName());
            this.cUV.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cUN.getLayoutMode().setNightMode(i == 1);
        this.cUN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cUN.getPageContext(), i);
        this.bKI.onChangeSkinType(this.cUN.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.cUP, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.cUQ, e.d.cp_cont_g, 1);
        this.cUS.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
