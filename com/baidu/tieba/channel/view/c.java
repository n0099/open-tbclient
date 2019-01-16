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
    private NoNetworkView bPl;
    private ChannelEditActivity dfb;
    private TbImageView dfc;
    private ImageView dfd;
    private TextView dfe;
    private TextView dff;
    private HeadImageView dfg;
    private TextView dfh;
    private TextView dfi;
    private EditText dfj;
    private TextView dfk;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a dfl = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.dfb = channelEditActivity;
        this.dfb.setIsAddSwipeBackLayout(true);
        this.dfb.setSwipeBackEnabled(true);
        this.dfb.setUseStyleImmersiveSticky(true);
        this.mContext = this.dfb.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.dfb.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.dfb.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.dfd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.dfd.setOnClickListener(this);
        this.dfe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.dfe.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds28));
        this.dfe.setOnClickListener(this);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.dfc = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.dfc.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dfc.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dfc.setOnClickListener(this);
        this.dff = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.dff.setOnClickListener(this);
        this.dfg = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.dfg.setIsRound(false);
        this.dfg.setRadius(0);
        this.dfg.setDrawBorder(true);
        this.dfg.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.dfg.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.dfg.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.dfg.setOnClickListener(this);
        this.dfh = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.dfh.setOnClickListener(this);
        this.dfi = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.dfj = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.dfk = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.dfj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.dfb.arv().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.dfj.getText() != null) {
                    c.this.dfk.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.dfj.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.dfj.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.dfj;
                            if (i > c.this.dfj.getText().length()) {
                                i = c.this.dfj.getText().length();
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
        if (view == this.dff || view == this.dfc) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.dfh || view == this.dfg) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.dfd) {
            if (ChannelEditActivity.isChanged) {
                this.dfl = new com.baidu.tbadk.core.dialog.a(this.dfb.getActivity());
                this.dfl.eK(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.dfl.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.dfb.aru();
                    }
                });
                this.dfl.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.dfb.finish();
                    }
                });
                this.dfl.b(this.dfb.getPageContext());
                this.dfl.BS();
                return;
            }
            this.dfb.finish();
        } else if (view == this.dfe) {
            this.dfb.aru();
        }
    }

    public String getDescription() {
        return this.dfj.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dfc.startLoad(channelInfo.getChannelCover(), 10, this.dfc.getWidth(), this.dfc.getHeight(), false);
            this.dfg.startLoad(channelInfo.getChannelAvatar(), 10, this.dfg.getWidth(), this.dfg.getHeight(), false);
            this.dfi.setText(channelInfo.getChannelName());
            this.dfj.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.dfb.getLayoutMode().setNightMode(i == 1);
        this.dfb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dfb.getPageContext(), i);
        this.bPl.onChangeSkinType(this.dfb.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.dfd, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.dfe, e.d.cp_cont_g, 1);
        this.dfg.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
