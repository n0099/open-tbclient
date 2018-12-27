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
    private NoNetworkView bOA;
    private ChannelEditActivity deo;
    private TbImageView dep;
    private ImageView deq;
    private TextView der;
    private TextView det;
    private HeadImageView deu;
    private TextView dev;
    private TextView dew;
    private EditText dex;
    private TextView dey;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a dez = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.deo = channelEditActivity;
        this.deo.setIsAddSwipeBackLayout(true);
        this.deo.setSwipeBackEnabled(true);
        this.deo.setUseStyleImmersiveSticky(true);
        this.mContext = this.deo.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.deo.setContentView(e.h.channel_edit_layout);
        this.mRootView = this.deo.findViewById(e.g.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.deq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.deq.setOnClickListener(this);
        this.der = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(e.j.channel_navigation_bar_save));
        this.der.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds28));
        this.der.setOnClickListener(this);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.channel_edit_no_network_view);
        this.dep = (TbImageView) this.mRootView.findViewById(e.g.channel_edit_top_bg);
        this.dep.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dep.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dep.setOnClickListener(this);
        this.det = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_cover);
        this.det.setOnClickListener(this);
        this.deu = (HeadImageView) this.mRootView.findViewById(e.g.channel_show_channel_img);
        this.deu.setIsRound(false);
        this.deu.setRadius(0);
        this.deu.setDrawBorder(true);
        this.deu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.deu.setBorderColor(this.mContext.getResources().getColor(e.d.white_alpha40));
        this.deu.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.deu.setOnClickListener(this);
        this.dev = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_avatar);
        this.dev.setOnClickListener(this);
        this.dew = (TextView) this.mRootView.findViewById(e.g.channel_edit_channel_name);
        this.dex = (EditText) this.mRootView.findViewById(e.g.channel_edit_channel_desc);
        this.dey = (TextView) this.mRootView.findViewById(e.g.channel_desc_text_number);
        this.dex.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.deo.aqX().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.dex.getText() != null) {
                    c.this.dey.setText(c.this.mContext.getResources().getString(e.j.channel_desc_text_num, Integer.valueOf(c.this.dex.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.dex.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.dex;
                            if (i > c.this.dex.getText().length()) {
                                i = c.this.dex.getText().length();
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
        if (view == this.det || view == this.dep) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.dev || view == this.deu) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.deq) {
            if (ChannelEditActivity.isChanged) {
                this.dez = new com.baidu.tbadk.core.dialog.a(this.deo.getActivity());
                this.dez.eB(com.baidu.adp.lib.voice.h.getString(e.j.channel_save_info));
                this.dez.a(this.mContext.getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.deo.aqW();
                    }
                });
                this.dez.b(this.mContext.getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.deo.finish();
                    }
                });
                this.dez.b(this.deo.getPageContext());
                this.dez.BF();
                return;
            }
            this.deo.finish();
        } else if (view == this.der) {
            this.deo.aqW();
        }
    }

    public String getDescription() {
        return this.dex.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dep.startLoad(channelInfo.getChannelCover(), 10, this.dep.getWidth(), this.dep.getHeight(), false);
            this.deu.startLoad(channelInfo.getChannelAvatar(), 10, this.deu.getWidth(), this.deu.getHeight(), false);
            this.dew.setText(channelInfo.getChannelName());
            this.dex.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.deo.getLayoutMode().setNightMode(i == 1);
        this.deo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.deo.getPageContext(), i);
        this.bOA.onChangeSkinType(this.deo.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.a(this.deq, e.f.icon_return_bg, e.f.icon_return_bg);
        al.c(this.der, e.d.cp_cont_g, 1);
        this.deu.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
