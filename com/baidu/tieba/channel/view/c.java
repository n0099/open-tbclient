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
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private NoNetworkView btu;
    private ChannelEditActivity cFb;
    private TbImageView cFc;
    private ImageView cFd;
    private TextView cFe;
    private TextView cFf;
    private HeadImageView cFg;
    private TextView cFh;
    private TextView cFi;
    private EditText cFj;
    private TextView cFk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cFl = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cFb = channelEditActivity;
        this.cFb.setIsAddSwipeBackLayout(true);
        this.cFb.setSwipeBackEnabled(true);
        this.cFb.setUseStyleImmersiveSticky(true);
        this.mContext = this.cFb.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cFb.setContentView(d.i.channel_edit_layout);
        this.mRootView = this.cFb.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cFd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFd.setOnClickListener(this);
        this.cFe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.k.channel_navigation_bar_save));
        this.cFe.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cFe.setOnClickListener(this);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cFc = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cFc.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cFc.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cFc.setOnClickListener(this);
        this.cFf = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cFf.setOnClickListener(this);
        this.cFg = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cFg.setIsRound(false);
        this.cFg.setRadius(0);
        this.cFg.setDrawBorder(true);
        this.cFg.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cFg.setBorderColor(this.mContext.getResources().getColor(d.C0141d.white_alpha40));
        this.cFg.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cFg.setOnClickListener(this);
        this.cFh = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cFh.setOnClickListener(this);
        this.cFi = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cFj = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cFk = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cFj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cFb.ajK().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cFj.getText() != null) {
                    c.this.cFk.setText(c.this.mContext.getResources().getString(d.k.channel_desc_text_num, Integer.valueOf(c.this.cFj.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cFj.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cFj;
                            if (i > c.this.cFj.getText().length()) {
                                i = c.this.cFj.getText().length();
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
        if (view == this.cFf || view == this.cFc) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cFh || view == this.cFg) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cFd) {
            if (ChannelEditActivity.isChanged) {
                this.cFl = new com.baidu.tbadk.core.dialog.a(this.cFb.getActivity());
                this.cFl.dB(com.baidu.adp.lib.voice.h.getString(d.k.channel_save_info));
                this.cFl.a(this.mContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFb.ajJ();
                    }
                });
                this.cFl.b(this.mContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFb.finish();
                    }
                });
                this.cFl.b(this.cFb.getPageContext());
                this.cFl.xa();
                return;
            }
            this.cFb.finish();
        } else if (view == this.cFe) {
            this.cFb.ajJ();
        }
    }

    public String getDescription() {
        return this.cFj.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFc.startLoad(channelInfo.getChannelCover(), 10, this.cFc.getWidth(), this.cFc.getHeight(), false);
            this.cFg.startLoad(channelInfo.getChannelAvatar(), 10, this.cFg.getWidth(), this.cFg.getHeight(), false);
            this.cFi.setText(channelInfo.getChannelName());
            this.cFj.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cFb.getLayoutMode().setNightMode(i == 1);
        this.cFb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cFb.getPageContext(), i);
        this.btu.onChangeSkinType(this.cFb.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.cFd, d.f.icon_return_bg, d.f.icon_return_bg);
        al.c(this.cFe, d.C0141d.cp_cont_g, 1);
        this.cFg.setBorderColor(al.getColor(d.C0141d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
