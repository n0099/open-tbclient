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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private NoNetworkView dpy;
    private ChannelEditActivity eLe;
    private TbImageView eLf;
    private ImageView eLg;
    private TextView eLh;
    private TextView eLi;
    private HeadImageView eLj;
    private TextView eLk;
    private TextView eLl;
    private EditText eLm;
    private TextView eLn;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eLo = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eLe = channelEditActivity;
        this.eLe.setIsAddSwipeBackLayout(true);
        this.eLe.setSwipeBackEnabled(true);
        this.eLe.setUseStyleImmersiveSticky(true);
        this.mContext = this.eLe.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eLe.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eLe.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eLg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eLg.setOnClickListener(this);
        this.eLh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eLh.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eLh.setOnClickListener(this);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eLf = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eLf.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eLf.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eLf.setOnClickListener(this);
        this.eLi = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eLi.setOnClickListener(this);
        this.eLj = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eLj.setIsRound(false);
        this.eLj.setRadius(0);
        this.eLj.setDrawBorder(true);
        this.eLj.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eLj.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eLj.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eLj.setOnClickListener(this);
        this.eLk = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eLk.setOnClickListener(this);
        this.eLl = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eLm = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eLn = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eLm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eLe.bbb().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eLm.getText() != null) {
                    c.this.eLn.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eLm.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eLm.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eLm;
                            if (i > c.this.eLm.getText().length()) {
                                i = c.this.eLm.getText().length();
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
        if (view == this.eLi || view == this.eLf) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eLk || view == this.eLj) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eLg) {
            if (ChannelEditActivity.isChanged) {
                this.eLo = new com.baidu.tbadk.core.dialog.a(this.eLe.getActivity());
                this.eLo.mQ(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eLo.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eLe.bba();
                    }
                });
                this.eLo.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eLe.finish();
                    }
                });
                this.eLo.b(this.eLe.getPageContext());
                this.eLo.agO();
                return;
            }
            this.eLe.finish();
        } else if (view == this.eLh) {
            this.eLe.bba();
        }
    }

    public String getDescription() {
        return this.eLm.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eLf.startLoad(channelInfo.getChannelCover(), 10, this.eLf.getWidth(), this.eLf.getHeight(), false);
            this.eLj.startLoad(channelInfo.getChannelAvatar(), 10, this.eLj.getWidth(), this.eLj.getHeight(), false);
            this.eLl.setText(channelInfo.getChannelName());
            this.eLm.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eLe.getLayoutMode().setNightMode(i == 1);
        this.eLe.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eLe.getPageContext(), i);
        this.dpy.onChangeSkinType(this.eLe.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        am.f(this.eLh, R.color.cp_cont_g, 1);
        this.eLj.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
