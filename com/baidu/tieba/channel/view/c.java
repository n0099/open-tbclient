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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private NoNetworkView blp;
    private ImageView cwA;
    private TextView cwB;
    private TextView cwC;
    private HeadImageView cwD;
    private TextView cwE;
    private TextView cwF;
    private EditText cwG;
    private TextView cwH;
    private ChannelEditActivity cwy;
    private TbImageView cwz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cwI = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cwy = channelEditActivity;
        this.cwy.setIsAddSwipeBackLayout(true);
        this.cwy.setSwipeBackEnabled(true);
        this.cwy.setUseStyleImmersiveSticky(true);
        this.mContext = this.cwy.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cwy.setContentView(d.i.channel_edit_layout);
        this.mRootView = this.cwy.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cwA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cwA.setOnClickListener(this);
        this.cwB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.k.channel_navigation_bar_save));
        this.cwB.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cwB.setOnClickListener(this);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cwz = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cwz.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cwz.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cwz.setOnClickListener(this);
        this.cwC = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cwC.setOnClickListener(this);
        this.cwD = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cwD.setIsRound(false);
        this.cwD.setRadius(0);
        this.cwD.setDrawBorder(true);
        this.cwD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cwD.setBorderColor(this.mContext.getResources().getColor(d.C0126d.white_alpha40));
        this.cwD.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cwD.setOnClickListener(this);
        this.cwE = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cwE.setOnClickListener(this);
        this.cwF = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cwG = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cwH = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cwG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cwy.agc().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cwG.getText() != null) {
                    c.this.cwH.setText(c.this.mContext.getResources().getString(d.k.channel_desc_text_num, Integer.valueOf(c.this.cwG.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cwG.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cwG;
                            if (i > c.this.cwG.getText().length()) {
                                i = c.this.cwG.getText().length();
                            }
                            editText.setSelection(i);
                        }
                    }
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cwC || view2 == this.cwz) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view2 == this.cwE || view2 == this.cwD) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view2 == this.cwA) {
            if (ChannelEditActivity.isChanged) {
                this.cwI = new com.baidu.tbadk.core.dialog.a(this.cwy.getActivity());
                this.cwI.dc(com.baidu.adp.lib.voice.h.getString(d.k.channel_save_info));
                this.cwI.a(this.mContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cwy.agb();
                    }
                });
                this.cwI.b(this.mContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cwy.finish();
                    }
                });
                this.cwI.b(this.cwy.getPageContext());
                this.cwI.tC();
                return;
            }
            this.cwy.finish();
        } else if (view2 == this.cwB) {
            this.cwy.agb();
        }
    }

    public String getDescription() {
        return this.cwG.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cwz.startLoad(channelInfo.getChannelCover(), 10, this.cwz.getWidth(), this.cwz.getHeight(), false);
            this.cwD.startLoad(channelInfo.getChannelAvatar(), 10, this.cwD.getWidth(), this.cwD.getHeight(), false);
            this.cwF.setText(channelInfo.getChannelName());
            this.cwG.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cwy.getLayoutMode().setNightMode(i == 1);
        this.cwy.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cwy.getPageContext(), i);
        this.blp.onChangeSkinType(this.cwy.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ak.a(this.cwA, d.f.icon_return_bg, d.f.icon_return_bg);
        ak.c(this.cwB, d.C0126d.cp_cont_g, 1);
        this.cwD.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
