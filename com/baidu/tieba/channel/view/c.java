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
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private NoNetworkView buT;
    private ChannelEditActivity cCU;
    private TbImageView cCV;
    private ImageView cCW;
    private TextView cCX;
    private TextView cCY;
    private HeadImageView cCZ;
    private TextView cDa;
    private TextView cDb;
    private EditText cDc;
    private TextView cDd;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cDe = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cCU = channelEditActivity;
        this.cCU.setIsAddSwipeBackLayout(true);
        this.cCU.setSwipeBackEnabled(true);
        this.cCU.setUseStyleImmersiveSticky(true);
        this.mContext = this.cCU.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cCU.setContentView(d.i.channel_edit_layout);
        this.mRootView = this.cCU.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cCW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cCW.setOnClickListener(this);
        this.cCX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.k.channel_navigation_bar_save));
        this.cCX.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cCX.setOnClickListener(this);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cCV = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cCV.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cCV.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cCV.setOnClickListener(this);
        this.cCY = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cCY.setOnClickListener(this);
        this.cCZ = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cCZ.setIsRound(false);
        this.cCZ.setRadius(0);
        this.cCZ.setDrawBorder(true);
        this.cCZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cCZ.setBorderColor(this.mContext.getResources().getColor(d.C0142d.white_alpha40));
        this.cCZ.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cCZ.setOnClickListener(this);
        this.cDa = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cDa.setOnClickListener(this);
        this.cDb = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cDc = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cDd = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cDc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cCU.aje().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cDc.getText() != null) {
                    c.this.cDd.setText(c.this.mContext.getResources().getString(d.k.channel_desc_text_num, Integer.valueOf(c.this.cDc.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cDc.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cDc;
                            if (i > c.this.cDc.getText().length()) {
                                i = c.this.cDc.getText().length();
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
        if (view == this.cCY || view == this.cCV) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cDa || view == this.cCZ) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cCW) {
            if (ChannelEditActivity.isChanged) {
                this.cDe = new com.baidu.tbadk.core.dialog.a(this.cCU.getActivity());
                this.cDe.dE(com.baidu.adp.lib.voice.h.getString(d.k.channel_save_info));
                this.cDe.a(this.mContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cCU.ajd();
                    }
                });
                this.cDe.b(this.mContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cCU.finish();
                    }
                });
                this.cDe.b(this.cCU.getPageContext());
                this.cDe.xn();
                return;
            }
            this.cCU.finish();
        } else if (view == this.cCX) {
            this.cCU.ajd();
        }
    }

    public String getDescription() {
        return this.cDc.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cCV.startLoad(channelInfo.getChannelCover(), 10, this.cCV.getWidth(), this.cCV.getHeight(), false);
            this.cCZ.startLoad(channelInfo.getChannelAvatar(), 10, this.cCZ.getWidth(), this.cCZ.getHeight(), false);
            this.cDb.setText(channelInfo.getChannelName());
            this.cDc.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cCU.getLayoutMode().setNightMode(i == 1);
        this.cCU.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cCU.getPageContext(), i);
        this.buT.onChangeSkinType(this.cCU.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.a(this.cCW, d.f.icon_return_bg, d.f.icon_return_bg);
        am.c(this.cCX, d.C0142d.cp_cont_g, 1);
        this.cCZ.setBorderColor(am.getColor(d.C0142d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
