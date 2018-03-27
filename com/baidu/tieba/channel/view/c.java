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
import com.baidu.tbadk.core.util.aj;
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
    private NoNetworkView cba;
    private ChannelEditActivity ddB;
    private TbImageView ddC;
    private ImageView ddD;
    private TextView ddE;
    private TextView ddF;
    private HeadImageView ddG;
    private TextView ddH;
    private TextView ddI;
    private EditText ddJ;
    private TextView ddK;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a ddL = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.ddB = channelEditActivity;
        this.ddB.setIsAddSwipeBackLayout(true);
        this.ddB.setSwipeBackEnabled(true);
        this.ddB.setUseStyleImmersiveSticky(true);
        this.mContext = this.ddB.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.ddB.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.ddB.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.ddD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.ddD.setOnClickListener(this);
        this.ddE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.ddE.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.ddE.setOnClickListener(this);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.ddC = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.ddC.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddC.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.ddC.setOnClickListener(this);
        this.ddF = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.ddF.setOnClickListener(this);
        this.ddG = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.ddG.setIsRound(false);
        this.ddG.setRadius(0);
        this.ddG.setDrawBorder(true);
        this.ddG.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.ddG.setBorderColor(this.mContext.getResources().getColor(d.C0141d.white_alpha40));
        this.ddG.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.ddG.setOnClickListener(this);
        this.ddH = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.ddH.setOnClickListener(this);
        this.ddI = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.ddJ = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.ddK = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.ddJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.ddB.amc().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.ddJ.getText() != null) {
                    c.this.ddK.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.ddJ.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.ddJ.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.ddJ;
                            if (i > c.this.ddJ.getText().length()) {
                                i = c.this.ddJ.getText().length();
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
        if (view == this.ddF || view == this.ddC) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.ddH || view == this.ddG) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.ddD) {
            if (ChannelEditActivity.isChanged) {
                this.ddL = new com.baidu.tbadk.core.dialog.a(this.ddB.getActivity());
                this.ddL.dk(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.ddL.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddB.amb();
                    }
                });
                this.ddL.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddB.finish();
                    }
                });
                this.ddL.b(this.ddB.getPageContext());
                this.ddL.AV();
                return;
            }
            this.ddB.finish();
        } else if (view == this.ddE) {
            this.ddB.amb();
        }
    }

    public String getDescription() {
        return this.ddJ.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddC.startLoad(channelInfo.getChannelCover(), 10, this.ddC.getWidth(), this.ddC.getHeight(), false);
            this.ddG.startLoad(channelInfo.getChannelAvatar(), 10, this.ddG.getWidth(), this.ddG.getHeight(), false);
            this.ddI.setText(channelInfo.getChannelName());
            this.ddJ.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.ddB.getLayoutMode().aQ(i == 1);
        this.ddB.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ddB.getPageContext(), i);
        this.cba.onChangeSkinType(this.ddB.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        aj.a(this.ddD, d.f.icon_return_bg, d.f.icon_return_bg);
        aj.e(this.ddE, d.C0141d.cp_cont_g, 1);
        this.ddG.setBorderColor(aj.getColor(d.C0141d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
