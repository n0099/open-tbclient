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
    private NoNetworkView caX;
    private ImageView ddA;
    private TextView ddB;
    private TextView ddC;
    private HeadImageView ddD;
    private TextView ddE;
    private TextView ddF;
    private EditText ddG;
    private TextView ddH;
    private ChannelEditActivity ddy;
    private TbImageView ddz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a ddI = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.ddy = channelEditActivity;
        this.ddy.setIsAddSwipeBackLayout(true);
        this.ddy.setSwipeBackEnabled(true);
        this.ddy.setUseStyleImmersiveSticky(true);
        this.mContext = this.ddy.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.ddy.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.ddy.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.ddA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.ddA.setOnClickListener(this);
        this.ddB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.ddB.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.ddB.setOnClickListener(this);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.ddz = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.ddz.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddz.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.ddz.setOnClickListener(this);
        this.ddC = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.ddC.setOnClickListener(this);
        this.ddD = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.ddD.setIsRound(false);
        this.ddD.setRadius(0);
        this.ddD.setDrawBorder(true);
        this.ddD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.ddD.setBorderColor(this.mContext.getResources().getColor(d.C0141d.white_alpha40));
        this.ddD.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.ddD.setOnClickListener(this);
        this.ddE = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.ddE.setOnClickListener(this);
        this.ddF = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.ddG = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.ddH = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.ddG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.ddy.amb().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.ddG.getText() != null) {
                    c.this.ddH.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.ddG.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.ddG.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.ddG;
                            if (i > c.this.ddG.getText().length()) {
                                i = c.this.ddG.getText().length();
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
        if (view == this.ddC || view == this.ddz) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.ddE || view == this.ddD) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.ddA) {
            if (ChannelEditActivity.isChanged) {
                this.ddI = new com.baidu.tbadk.core.dialog.a(this.ddy.getActivity());
                this.ddI.dk(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.ddI.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddy.ama();
                    }
                });
                this.ddI.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddy.finish();
                    }
                });
                this.ddI.b(this.ddy.getPageContext());
                this.ddI.AU();
                return;
            }
            this.ddy.finish();
        } else if (view == this.ddB) {
            this.ddy.ama();
        }
    }

    public String getDescription() {
        return this.ddG.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddz.startLoad(channelInfo.getChannelCover(), 10, this.ddz.getWidth(), this.ddz.getHeight(), false);
            this.ddD.startLoad(channelInfo.getChannelAvatar(), 10, this.ddD.getWidth(), this.ddD.getHeight(), false);
            this.ddF.setText(channelInfo.getChannelName());
            this.ddG.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.ddy.getLayoutMode().aQ(i == 1);
        this.ddy.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ddy.getPageContext(), i);
        this.caX.onChangeSkinType(this.ddy.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        aj.a(this.ddA, d.f.icon_return_bg, d.f.icon_return_bg);
        aj.e(this.ddB, d.C0141d.cp_cont_g, 1);
        this.ddD.setBorderColor(aj.getColor(d.C0141d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
