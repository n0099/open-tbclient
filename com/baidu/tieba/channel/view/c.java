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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private NoNetworkView bvB;
    private TextView cFA;
    private TextView cFB;
    private HeadImageView cFC;
    private TextView cFD;
    private TextView cFE;
    private EditText cFF;
    private TextView cFG;
    private ChannelEditActivity cFx;
    private TbImageView cFy;
    private ImageView cFz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cFH = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cFx = channelEditActivity;
        this.cFx.setIsAddSwipeBackLayout(true);
        this.cFx.setSwipeBackEnabled(true);
        this.cFx.setUseStyleImmersiveSticky(true);
        this.mContext = this.cFx.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cFx.setContentView(f.h.channel_edit_layout);
        this.mRootView = this.cFx.findViewById(f.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cFz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFz.setOnClickListener(this);
        this.cFA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(f.j.channel_navigation_bar_save));
        this.cFA.setTextSize(0, this.mContext.getResources().getDimension(f.e.ds28));
        this.cFA.setOnClickListener(this);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.channel_edit_no_network_view);
        this.cFy = (TbImageView) this.mRootView.findViewById(f.g.channel_edit_top_bg);
        this.cFy.setDefaultErrorResource(f.C0146f.bg_avatar_weiba_head);
        this.cFy.setDefaultBgResource(f.C0146f.bg_avatar_weiba_head);
        this.cFy.setOnClickListener(this);
        this.cFB = (TextView) this.mRootView.findViewById(f.g.channel_edit_channel_cover);
        this.cFB.setOnClickListener(this);
        this.cFC = (HeadImageView) this.mRootView.findViewById(f.g.channel_show_channel_img);
        this.cFC.setIsRound(false);
        this.cFC.setRadius(0);
        this.cFC.setDrawBorder(true);
        this.cFC.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(f.e.ds1));
        this.cFC.setBorderColor(this.mContext.getResources().getColor(f.d.white_alpha40));
        this.cFC.setDefaultErrorResource(f.C0146f.avatar_channel_poto_defaul160);
        this.cFC.setOnClickListener(this);
        this.cFD = (TextView) this.mRootView.findViewById(f.g.channel_edit_channel_avatar);
        this.cFD.setOnClickListener(this);
        this.cFE = (TextView) this.mRootView.findViewById(f.g.channel_edit_channel_name);
        this.cFF = (EditText) this.mRootView.findViewById(f.g.channel_edit_channel_desc);
        this.cFG = (TextView) this.mRootView.findViewById(f.g.channel_desc_text_number);
        this.cFF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cFx.ajG().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cFF.getText() != null) {
                    c.this.cFG.setText(c.this.mContext.getResources().getString(f.j.channel_desc_text_num, Integer.valueOf(c.this.cFF.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cFF.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cFF;
                            if (i > c.this.cFF.getText().length()) {
                                i = c.this.cFF.getText().length();
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
        if (view == this.cFB || view == this.cFy) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.cFD || view == this.cFC) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.cFz) {
            if (ChannelEditActivity.isChanged) {
                this.cFH = new com.baidu.tbadk.core.dialog.a(this.cFx.getActivity());
                this.cFH.dB(com.baidu.adp.lib.voice.h.getString(f.j.channel_save_info));
                this.cFH.a(this.mContext.getString(f.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFx.ajF();
                    }
                });
                this.cFH.b(this.mContext.getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cFx.finish();
                    }
                });
                this.cFH.b(this.cFx.getPageContext());
                this.cFH.xe();
                return;
            }
            this.cFx.finish();
        } else if (view == this.cFA) {
            this.cFx.ajF();
        }
    }

    public String getDescription() {
        return this.cFF.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFy.startLoad(channelInfo.getChannelCover(), 10, this.cFy.getWidth(), this.cFy.getHeight(), false);
            this.cFC.startLoad(channelInfo.getChannelAvatar(), 10, this.cFC.getWidth(), this.cFC.getHeight(), false);
            this.cFE.setText(channelInfo.getChannelName());
            this.cFF.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cFx.getLayoutMode().setNightMode(i == 1);
        this.cFx.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cFx.getPageContext(), i);
        this.bvB.onChangeSkinType(this.cFx.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.a(this.cFz, f.C0146f.icon_return_bg, f.C0146f.icon_return_bg);
        am.c(this.cFA, f.d.cp_cont_g, 1);
        this.cFC.setBorderColor(am.getColor(f.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
