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
    private NoNetworkView bPm;
    private ChannelEditActivity dfc;
    private TbImageView dfd;
    private ImageView dfe;
    private TextView dff;
    private TextView dfg;
    private HeadImageView dfh;
    private TextView dfi;
    private TextView dfj;
    private EditText dfk;
    private TextView dfl;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a dfm = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.dfc = channelEditActivity;
        this.dfc.setIsAddSwipeBackLayout(true);
        this.dfc.setSwipeBackEnabled(true);
        this.dfc.setUseStyleImmersiveSticky(true);
        this.mContext = this.dfc.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.dfc.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.dfc.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.dfe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.dfe.setOnClickListener(this);
        this.dff = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.dff.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds28));
        this.dff.setOnClickListener(this);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.dfd = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.dfd.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dfd.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dfd.setOnClickListener(this);
        this.dfg = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.dfg.setOnClickListener(this);
        this.dfh = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.dfh.setIsRound(false);
        this.dfh.setRadius(0);
        this.dfh.setDrawBorder(true);
        this.dfh.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.dfh.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.dfh.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.dfh.setOnClickListener(this);
        this.dfi = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.dfi.setOnClickListener(this);
        this.dfj = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.dfk = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.dfl = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.dfk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.dfc.arv().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.dfk.getText() != null) {
                    c.this.dfl.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.dfk.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.dfk.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.dfk;
                            if (i > c.this.dfk.getText().length()) {
                                i = c.this.dfk.getText().length();
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
        if (view == this.dfg || view == this.dfd) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.dfi || view == this.dfh) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.dfe) {
            if (ChannelEditActivity.isChanged) {
                this.dfm = new com.baidu.tbadk.core.dialog.a(this.dfc.getActivity());
                this.dfm.eK(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.dfm.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.dfc.aru();
                    }
                });
                this.dfm.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.dfc.finish();
                    }
                });
                this.dfm.b(this.dfc.getPageContext());
                this.dfm.BS();
                return;
            }
            this.dfc.finish();
        } else if (view == this.dff) {
            this.dfc.aru();
        }
    }

    public String getDescription() {
        return this.dfk.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dfd.startLoad(channelInfo.getChannelCover(), 10, this.dfd.getWidth(), this.dfd.getHeight(), false);
            this.dfh.startLoad(channelInfo.getChannelAvatar(), 10, this.dfh.getWidth(), this.dfh.getHeight(), false);
            this.dfj.setText(channelInfo.getChannelName());
            this.dfk.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.dfc.getLayoutMode().setNightMode(i == 1);
        this.dfc.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dfc.getPageContext(), i);
        this.bPm.onChangeSkinType(this.dfc.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.dfe, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.dff, e.d.cp_cont_g, 1);
        this.dfh.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
