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
import com.baidu.tbadk.core.util.ak;
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
    private NoNetworkView bla;
    private ChannelEditActivity cvp;
    private TbImageView cvq;
    private ImageView cvr;
    private TextView cvs;
    private TextView cvt;
    private HeadImageView cvu;
    private TextView cvv;
    private TextView cvw;
    private EditText cvx;
    private TextView cvy;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cvz = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cvp = channelEditActivity;
        this.cvp.setIsAddSwipeBackLayout(true);
        this.cvp.setSwipeBackEnabled(true);
        this.cvp.setUseStyleImmersiveSticky(true);
        this.mContext = this.cvp.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cvp.setContentView(d.i.channel_edit_layout);
        this.mRootView = this.cvp.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cvr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cvr.setOnClickListener(this);
        this.cvs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.k.channel_navigation_bar_save));
        this.cvs.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cvs.setOnClickListener(this);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cvq = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cvq.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cvq.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cvq.setOnClickListener(this);
        this.cvt = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cvt.setOnClickListener(this);
        this.cvu = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cvu.setIsRound(false);
        this.cvu.setRadius(0);
        this.cvu.setDrawBorder(true);
        this.cvu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cvu.setBorderColor(this.mContext.getResources().getColor(d.C0126d.white_alpha40));
        this.cvu.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cvu.setOnClickListener(this);
        this.cvv = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cvv.setOnClickListener(this);
        this.cvw = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cvx = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cvy = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cvx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cvp.agc().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cvx.getText() != null) {
                    c.this.cvy.setText(c.this.mContext.getResources().getString(d.k.channel_desc_text_num, Integer.valueOf(c.this.cvx.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cvx.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cvx;
                            if (i > c.this.cvx.getText().length()) {
                                i = c.this.cvx.getText().length();
                            }
                            editText.setSelection(i);
                        }
                    }
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cvt || view2 == this.cvq) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view2 == this.cvv || view2 == this.cvu) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view2 == this.cvr) {
            if (ChannelEditActivity.isChanged) {
                this.cvz = new com.baidu.tbadk.core.dialog.a(this.cvp.getActivity());
                this.cvz.dc(com.baidu.adp.lib.voice.h.getString(d.k.channel_save_info));
                this.cvz.a(this.mContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cvp.agb();
                    }
                });
                this.cvz.b(this.mContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cvp.finish();
                    }
                });
                this.cvz.b(this.cvp.getPageContext());
                this.cvz.tD();
                return;
            }
            this.cvp.finish();
        } else if (view2 == this.cvs) {
            this.cvp.agb();
        }
    }

    public String getDescription() {
        return this.cvx.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cvq.startLoad(channelInfo.getChannelCover(), 10, this.cvq.getWidth(), this.cvq.getHeight(), false);
            this.cvu.startLoad(channelInfo.getChannelAvatar(), 10, this.cvu.getWidth(), this.cvu.getHeight(), false);
            this.cvw.setText(channelInfo.getChannelName());
            this.cvx.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cvp.getLayoutMode().setNightMode(i == 1);
        this.cvp.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cvp.getPageContext(), i);
        this.bla.onChangeSkinType(this.cvp.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ak.a(this.cvr, d.f.icon_return_bg, d.f.icon_return_bg);
        ak.c(this.cvs, d.C0126d.cp_cont_g, 1);
        this.cvu.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
