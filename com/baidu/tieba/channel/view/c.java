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
    private EditText cvA;
    private TextView cvB;
    private ChannelEditActivity cvs;
    private TbImageView cvt;
    private ImageView cvu;
    private TextView cvv;
    private TextView cvw;
    private HeadImageView cvx;
    private TextView cvy;
    private TextView cvz;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a cvC = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.cvs = channelEditActivity;
        this.cvs.setIsAddSwipeBackLayout(true);
        this.cvs.setSwipeBackEnabled(true);
        this.cvs.setUseStyleImmersiveSticky(true);
        this.mContext = this.cvs.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.cvs.setContentView(d.i.channel_edit_layout);
        this.mRootView = this.cvs.findViewById(d.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.cvu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cvu.setOnClickListener(this);
        this.cvv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(d.k.channel_navigation_bar_save));
        this.cvv.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
        this.cvv.setOnClickListener(this);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.channel_edit_no_network_view);
        this.cvt = (TbImageView) this.mRootView.findViewById(d.g.channel_edit_top_bg);
        this.cvt.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cvt.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cvt.setOnClickListener(this);
        this.cvw = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_cover);
        this.cvw.setOnClickListener(this);
        this.cvx = (HeadImageView) this.mRootView.findViewById(d.g.channel_show_channel_img);
        this.cvx.setIsRound(false);
        this.cvx.setRadius(0);
        this.cvx.setDrawBorder(true);
        this.cvx.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cvx.setBorderColor(this.mContext.getResources().getColor(d.C0126d.white_alpha40));
        this.cvx.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cvx.setOnClickListener(this);
        this.cvy = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_avatar);
        this.cvy.setOnClickListener(this);
        this.cvz = (TextView) this.mRootView.findViewById(d.g.channel_edit_channel_name);
        this.cvA = (EditText) this.mRootView.findViewById(d.g.channel_edit_channel_desc);
        this.cvB = (TextView) this.mRootView.findViewById(d.g.channel_desc_text_number);
        this.cvA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.cvs.agc().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.cvA.getText() != null) {
                    c.this.cvB.setText(c.this.mContext.getResources().getString(d.k.channel_desc_text_num, Integer.valueOf(c.this.cvA.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.cvA.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.cvA;
                            if (i > c.this.cvA.getText().length()) {
                                i = c.this.cvA.getText().length();
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
        if (view2 == this.cvw || view2 == this.cvt) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view2 == this.cvy || view2 == this.cvx) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view2 == this.cvu) {
            if (ChannelEditActivity.isChanged) {
                this.cvC = new com.baidu.tbadk.core.dialog.a(this.cvs.getActivity());
                this.cvC.dc(com.baidu.adp.lib.voice.h.getString(d.k.channel_save_info));
                this.cvC.a(this.mContext.getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cvs.agb();
                    }
                });
                this.cvC.b(this.mContext.getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.cvs.finish();
                    }
                });
                this.cvC.b(this.cvs.getPageContext());
                this.cvC.tD();
                return;
            }
            this.cvs.finish();
        } else if (view2 == this.cvv) {
            this.cvs.agb();
        }
    }

    public String getDescription() {
        return this.cvA.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cvt.startLoad(channelInfo.getChannelCover(), 10, this.cvt.getWidth(), this.cvt.getHeight(), false);
            this.cvx.startLoad(channelInfo.getChannelAvatar(), 10, this.cvx.getWidth(), this.cvx.getHeight(), false);
            this.cvz.setText(channelInfo.getChannelName());
            this.cvA.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.cvs.getLayoutMode().setNightMode(i == 1);
        this.cvs.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cvs.getPageContext(), i);
        this.bla.onChangeSkinType(this.cvs.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        ak.a(this.cvu, d.f.icon_return_bg, d.f.icon_return_bg);
        ak.c(this.cvv, d.C0126d.cp_cont_g, 1);
        this.cvx.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
