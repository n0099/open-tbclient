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
    private NoNetworkView bvz;
    private ChannelEditActivity cFA;
    private TbImageView cFB;
    private ImageView cFC;
    private TextView cFD;
    private TextView cFE;
    private HeadImageView cFF;
    private TextView cFG;
    private TextView cFH;
    private EditText cFI;
    private TextView cFJ;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cFK = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cFA = channelEditActivity;
        this.cFA.setIsAddSwipeBackLayout(true);
        this.cFA.setSwipeBackEnabled(true);
        this.cFA.setUseStyleImmersiveSticky(true);
        this.mContext = this.cFA.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cFA.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.cFA.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cFC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFC.setOnClickListener(this);
        this.cFD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.cFD.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cFD.setOnClickListener(this);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cFB = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cFB.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cFB.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cFB.setOnClickListener(this);
        this.cFE = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cFE.setOnClickListener(this);
        this.cFF = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cFF.setIsRound(false);
        this.cFF.setRadius(0);
        this.cFF.setDrawBorder(true);
        this.cFF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cFF.setBorderColor(this.mContext.getResources().getColor(d.C0140d.white_alpha40));
        this.cFF.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cFF.setOnClickListener(this);
        this.cFG = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cFG.setOnClickListener(this);
        this.cFH = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cFI = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cFJ = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cFI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cFA.ajD().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cFI.getText() != null) {
                    c.this.cFJ.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.cFI.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cFI.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cFI;
                            if (i > c.this.cFI.getText().length()) {
                                i = c.this.cFI.getText().length();
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
        if (view == this.cFE || view == this.cFB) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cFG || view == this.cFF) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cFC) {
            if (ChannelEditActivity.isChanged) {
                this.cFK = new com.baidu.tbadk.core.dialog.a(this.cFA.getActivity());
                this.cFK.dB(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.cFK.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFA.ajC();
                    }
                });
                this.cFK.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFA.finish();
                    }
                });
                this.cFK.b(this.cFA.getPageContext());
                this.cFK.xf();
                return;
            }
            this.cFA.finish();
        } else if (view == this.cFD) {
            this.cFA.ajC();
        }
    }

    public String getDescription() {
        return this.cFI.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFB.startLoad(channelInfo.getChannelCover(), 10, this.cFB.getWidth(), this.cFB.getHeight(), false);
            this.cFF.startLoad(channelInfo.getChannelAvatar(), 10, this.cFF.getWidth(), this.cFF.getHeight(), false);
            this.cFH.setText(channelInfo.getChannelName());
            this.cFI.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cFA.getLayoutMode().setNightMode(i == 1);
        this.cFA.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cFA.getPageContext(), i);
        this.bvz.onChangeSkinType(this.cFA.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.a(this.cFC, d.f.icon_return_bg, d.f.icon_return_bg);
        am.c(this.cFD, d.C0140d.cp_cont_g, 1);
        this.cFF.setBorderColor(am.getColor(d.C0140d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
