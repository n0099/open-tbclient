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
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private NoNetworkView dbr;
    private ChannelEditActivity eoK;
    private TbImageView eoL;
    private ImageView eoM;
    private TextView eoN;
    private TextView eoO;
    private HeadImageView eoP;
    private TextView eoQ;
    private TextView eoR;
    private EditText eoS;
    private TextView eoT;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eoU = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eoK = channelEditActivity;
        this.eoK.setIsAddSwipeBackLayout(true);
        this.eoK.setSwipeBackEnabled(true);
        this.eoK.setUseStyleImmersiveSticky(true);
        this.mContext = this.eoK.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eoK.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.eoK.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eoM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eoM.setOnClickListener(this);
        this.eoN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.eoN.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.eoN.setOnClickListener(this);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.eoL = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.eoL.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoL.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.eoL.setOnClickListener(this);
        this.eoO = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.eoO.setOnClickListener(this);
        this.eoP = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.eoP.setIsRound(false);
        this.eoP.setRadius(0);
        this.eoP.setDrawBorder(true);
        this.eoP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.eoP.setBorderColor(this.mContext.getResources().getColor(d.C0277d.white_alpha40));
        this.eoP.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.eoP.setOnClickListener(this);
        this.eoQ = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.eoQ.setOnClickListener(this);
        this.eoR = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.eoS = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.eoT = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.eoS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eoK.aRk().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eoS.getText() != null) {
                    c.this.eoT.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.eoS.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eoS.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eoS;
                            if (i > c.this.eoS.getText().length()) {
                                i = c.this.eoS.getText().length();
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
        if (view == this.eoO || view == this.eoL) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eoQ || view == this.eoP) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eoM) {
            if (ChannelEditActivity.isChanged) {
                this.eoU = new com.baidu.tbadk.core.dialog.a(this.eoK.getActivity());
                this.eoU.lz(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.eoU.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoK.aRj();
                    }
                });
                this.eoU.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoK.finish();
                    }
                });
                this.eoU.b(this.eoK.getPageContext());
                this.eoU.aaW();
                return;
            }
            this.eoK.finish();
        } else if (view == this.eoN) {
            this.eoK.aRj();
        }
    }

    public String getDescription() {
        return this.eoS.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoL.startLoad(channelInfo.getChannelCover(), 10, this.eoL.getWidth(), this.eoL.getHeight(), false);
            this.eoP.startLoad(channelInfo.getChannelAvatar(), 10, this.eoP.getWidth(), this.eoP.getHeight(), false);
            this.eoR.setText(channelInfo.getChannelName());
            this.eoS.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eoK.getLayoutMode().setNightMode(i == 1);
        this.eoK.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eoK.getPageContext(), i);
        this.dbr.onChangeSkinType(this.eoK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.eoM, d.f.icon_return_bg, d.f.icon_return_bg);
        al.d(this.eoN, d.C0277d.cp_cont_g, 1);
        this.eoP.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
