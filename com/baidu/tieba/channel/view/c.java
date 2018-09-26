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
    private NoNetworkView bBq;
    private ChannelEditActivity cLo;
    private TbImageView cLp;
    private ImageView cLq;
    private TextView cLr;
    private TextView cLs;
    private HeadImageView cLt;
    private TextView cLu;
    private TextView cLv;
    private EditText cLw;
    private TextView cLx;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cLy = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cLo = channelEditActivity;
        this.cLo.setIsAddSwipeBackLayout(true);
        this.cLo.setSwipeBackEnabled(true);
        this.cLo.setUseStyleImmersiveSticky(true);
        this.mContext = this.cLo.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cLo.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.cLo.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cLq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cLq.setOnClickListener(this);
        this.cLr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.cLr.setTextSize(0, this.mContext.getResources().getDimension(e.C0141e.ds28));
        this.cLr.setOnClickListener(this);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.cLp = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.cLp.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cLp.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cLp.setOnClickListener(this);
        this.cLs = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.cLs.setOnClickListener(this);
        this.cLt = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.cLt.setIsRound(false);
        this.cLt.setRadius(0);
        this.cLt.setDrawBorder(true);
        this.cLt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds1));
        this.cLt.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.cLt.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cLt.setOnClickListener(this);
        this.cLu = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.cLu.setOnClickListener(this);
        this.cLv = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.cLw = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.cLx = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.cLw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cLo.alr().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cLw.getText() != null) {
                    c.this.cLx.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.cLw.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cLw.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cLw;
                            if (i > c.this.cLw.getText().length()) {
                                i = c.this.cLw.getText().length();
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
        if (view == this.cLs || view == this.cLp) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cLu || view == this.cLt) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cLq) {
            if (ChannelEditActivity.isChanged) {
                this.cLy = new com.baidu.tbadk.core.dialog.a(this.cLo.getActivity());
                this.cLy.dT(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.cLy.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cLo.alq();
                    }
                });
                this.cLy.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cLo.finish();
                    }
                });
                this.cLy.b(this.cLo.getPageContext());
                this.cLy.yl();
                return;
            }
            this.cLo.finish();
        } else if (view == this.cLr) {
            this.cLo.alq();
        }
    }

    public String getDescription() {
        return this.cLw.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cLp.startLoad(channelInfo.getChannelCover(), 10, this.cLp.getWidth(), this.cLp.getHeight(), false);
            this.cLt.startLoad(channelInfo.getChannelAvatar(), 10, this.cLt.getWidth(), this.cLt.getHeight(), false);
            this.cLv.setText(channelInfo.getChannelName());
            this.cLw.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cLo.getLayoutMode().setNightMode(i == 1);
        this.cLo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cLo.getPageContext(), i);
        this.bBq.onChangeSkinType(this.cLo.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.cLq, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.cLr, e.d.cp_cont_g, 1);
        this.cLt.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
