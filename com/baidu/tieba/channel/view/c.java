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
    private NoNetworkView cbj;
    private ChannelEditActivity ddK;
    private TbImageView ddL;
    private ImageView ddM;
    private TextView ddN;
    private TextView ddO;
    private HeadImageView ddP;
    private TextView ddQ;
    private TextView ddR;
    private EditText ddS;
    private TextView ddT;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a ddU = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.ddK = channelEditActivity;
        this.ddK.setIsAddSwipeBackLayout(true);
        this.ddK.setSwipeBackEnabled(true);
        this.ddK.setUseStyleImmersiveSticky(true);
        this.mContext = this.ddK.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.ddK.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.ddK.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.ddM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.ddM.setOnClickListener(this);
        this.ddN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.ddN.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.ddN.setOnClickListener(this);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.ddL = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.ddL.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddL.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.ddL.setOnClickListener(this);
        this.ddO = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.ddO.setOnClickListener(this);
        this.ddP = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.ddP.setIsRound(false);
        this.ddP.setRadius(0);
        this.ddP.setDrawBorder(true);
        this.ddP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.ddP.setBorderColor(this.mContext.getResources().getColor(d.C0140d.white_alpha40));
        this.ddP.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.ddP.setOnClickListener(this);
        this.ddQ = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.ddQ.setOnClickListener(this);
        this.ddR = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.ddS = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.ddT = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.ddS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.ddK.amc().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.ddS.getText() != null) {
                    c.this.ddT.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.ddS.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.ddS.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.ddS;
                            if (i > c.this.ddS.getText().length()) {
                                i = c.this.ddS.getText().length();
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
        if (view == this.ddO || view == this.ddL) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.ddQ || view == this.ddP) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.ddM) {
            if (ChannelEditActivity.isChanged) {
                this.ddU = new com.baidu.tbadk.core.dialog.a(this.ddK.getActivity());
                this.ddU.dk(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.ddU.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddK.amb();
                    }
                });
                this.ddU.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.ddK.finish();
                    }
                });
                this.ddU.b(this.ddK.getPageContext());
                this.ddU.AU();
                return;
            }
            this.ddK.finish();
        } else if (view == this.ddN) {
            this.ddK.amb();
        }
    }

    public String getDescription() {
        return this.ddS.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddL.startLoad(channelInfo.getChannelCover(), 10, this.ddL.getWidth(), this.ddL.getHeight(), false);
            this.ddP.startLoad(channelInfo.getChannelAvatar(), 10, this.ddP.getWidth(), this.ddP.getHeight(), false);
            this.ddR.setText(channelInfo.getChannelName());
            this.ddS.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.ddK.getLayoutMode().aQ(i == 1);
        this.ddK.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ddK.getPageContext(), i);
        this.cbj.onChangeSkinType(this.ddK.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        aj.a(this.ddM, d.f.icon_return_bg, d.f.icon_return_bg);
        aj.e(this.ddN, d.C0140d.cp_cont_g, 1);
        this.ddP.setBorderColor(aj.getColor(d.C0140d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
