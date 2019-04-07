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
    private NoNetworkView dbq;
    private ChannelEditActivity eoJ;
    private TbImageView eoK;
    private ImageView eoL;
    private TextView eoM;
    private TextView eoN;
    private HeadImageView eoO;
    private TextView eoP;
    private TextView eoQ;
    private EditText eoR;
    private TextView eoS;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eoT = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eoJ = channelEditActivity;
        this.eoJ.setIsAddSwipeBackLayout(true);
        this.eoJ.setSwipeBackEnabled(true);
        this.eoJ.setUseStyleImmersiveSticky(true);
        this.mContext = this.eoJ.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eoJ.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.eoJ.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eoL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eoL.setOnClickListener(this);
        this.eoM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.eoM.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.eoM.setOnClickListener(this);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.eoK = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.eoK.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoK.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.eoK.setOnClickListener(this);
        this.eoN = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.eoN.setOnClickListener(this);
        this.eoO = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.eoO.setIsRound(false);
        this.eoO.setRadius(0);
        this.eoO.setDrawBorder(true);
        this.eoO.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.eoO.setBorderColor(this.mContext.getResources().getColor(d.C0277d.white_alpha40));
        this.eoO.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.eoO.setOnClickListener(this);
        this.eoP = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.eoP.setOnClickListener(this);
        this.eoQ = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.eoR = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.eoS = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.eoR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eoJ.aRk().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eoR.getText() != null) {
                    c.this.eoS.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.eoR.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eoR.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eoR;
                            if (i > c.this.eoR.getText().length()) {
                                i = c.this.eoR.getText().length();
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
        if (view == this.eoN || view == this.eoK) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eoP || view == this.eoO) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eoL) {
            if (ChannelEditActivity.isChanged) {
                this.eoT = new com.baidu.tbadk.core.dialog.a(this.eoJ.getActivity());
                this.eoT.lz(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.eoT.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoJ.aRj();
                    }
                });
                this.eoT.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoJ.finish();
                    }
                });
                this.eoT.b(this.eoJ.getPageContext());
                this.eoT.aaW();
                return;
            }
            this.eoJ.finish();
        } else if (view == this.eoM) {
            this.eoJ.aRj();
        }
    }

    public String getDescription() {
        return this.eoR.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoK.startLoad(channelInfo.getChannelCover(), 10, this.eoK.getWidth(), this.eoK.getHeight(), false);
            this.eoO.startLoad(channelInfo.getChannelAvatar(), 10, this.eoO.getWidth(), this.eoO.getHeight(), false);
            this.eoQ.setText(channelInfo.getChannelName());
            this.eoR.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eoJ.getLayoutMode().setNightMode(i == 1);
        this.eoJ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eoJ.getPageContext(), i);
        this.dbq.onChangeSkinType(this.eoJ.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.eoL, d.f.icon_return_bg, d.f.icon_return_bg);
        al.d(this.eoM, d.C0277d.cp_cont_g, 1);
        this.eoO.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
