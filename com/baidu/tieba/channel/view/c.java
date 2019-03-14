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
    private NoNetworkView dbm;
    private ChannelEditActivity eoX;
    private TbImageView eoY;
    private ImageView eoZ;
    private TextView epa;
    private TextView epb;
    private HeadImageView epc;
    private TextView epd;
    private TextView epe;
    private EditText epf;
    private TextView epg;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eph = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eoX = channelEditActivity;
        this.eoX.setIsAddSwipeBackLayout(true);
        this.eoX.setSwipeBackEnabled(true);
        this.eoX.setUseStyleImmersiveSticky(true);
        this.mContext = this.eoX.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eoX.setContentView(d.h.channel_edit_layout);
        this.mRootView = this.eoX.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eoZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eoZ.setOnClickListener(this);
        this.epa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.j.channel_navigation_bar_save));
        this.epa.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.epa.setOnClickListener(this);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.eoY = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.eoY.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoY.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.eoY.setOnClickListener(this);
        this.epb = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.epb.setOnClickListener(this);
        this.epc = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.epc.setIsRound(false);
        this.epc.setRadius(0);
        this.epc.setDrawBorder(true);
        this.epc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.epc.setBorderColor(this.mContext.getResources().getColor(d.C0277d.white_alpha40));
        this.epc.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.epc.setOnClickListener(this);
        this.epd = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.epd.setOnClickListener(this);
        this.epe = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.epf = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.epg = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.epf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eoX.aRm().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.epf.getText() != null) {
                    c.this.epg.setText(c.this.mContext.getResources().getString(d.j.channel_desc_text_num, Integer.valueOf(c.this.epf.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.epf.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.epf;
                            if (i > c.this.epf.getText().length()) {
                                i = c.this.epf.getText().length();
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
        if (view == this.epb || view == this.eoY) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.epd || view == this.epc) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eoZ) {
            if (ChannelEditActivity.isChanged) {
                this.eph = new com.baidu.tbadk.core.dialog.a(this.eoX.getActivity());
                this.eph.ly(com.baidu.adp.lib.voice.h.getString(d.j.channel_save_info));
                this.eph.a(this.mContext.getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoX.aRl();
                    }
                });
                this.eph.b(this.mContext.getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eoX.finish();
                    }
                });
                this.eph.b(this.eoX.getPageContext());
                this.eph.aaZ();
                return;
            }
            this.eoX.finish();
        } else if (view == this.epa) {
            this.eoX.aRl();
        }
    }

    public String getDescription() {
        return this.epf.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoY.startLoad(channelInfo.getChannelCover(), 10, this.eoY.getWidth(), this.eoY.getHeight(), false);
            this.epc.startLoad(channelInfo.getChannelAvatar(), 10, this.epc.getWidth(), this.epc.getHeight(), false);
            this.epe.setText(channelInfo.getChannelName());
            this.epf.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eoX.getLayoutMode().setNightMode(i == 1);
        this.eoX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eoX.getPageContext(), i);
        this.dbm.onChangeSkinType(this.eoX.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.eoZ, d.f.icon_return_bg, d.f.icon_return_bg);
        al.d(this.epa, d.C0277d.cp_cont_g, 1);
        this.epc.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
