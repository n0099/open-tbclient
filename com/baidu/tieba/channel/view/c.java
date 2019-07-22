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
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelEditActivity;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    private NoNetworkView dnF;
    private ChannelEditActivity eJo;
    private TbImageView eJp;
    private ImageView eJq;
    private TextView eJr;
    private TextView eJs;
    private HeadImageView eJt;
    private TextView eJu;
    private TextView eJv;
    private EditText eJw;
    private TextView eJx;
    private Context mContext;
    private NavigationBar mNavigationBar;
    private View mRootView;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private com.baidu.tbadk.core.dialog.a eJy = null;

    public c(ChannelEditActivity channelEditActivity) {
        this.eJo = channelEditActivity;
        this.eJo.setIsAddSwipeBackLayout(true);
        this.eJo.setSwipeBackEnabled(true);
        this.eJo.setUseStyleImmersiveSticky(true);
        this.mContext = this.eJo.getPageContext().getPageActivity();
        initViews();
    }

    public void initViews() {
        this.eJo.setContentView(R.layout.channel_edit_layout);
        this.mRootView = this.eJo.findViewById(R.id.channel_edit_rootview);
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.channel_edit_navigation_bar);
        this.mNavigationBar.showBottomLine(false);
        this.mNavigationBar.getBarBgView().setVisibility(8);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.eJq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eJq.setOnClickListener(this);
        this.eJr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.adp.lib.voice.h.getString(R.string.channel_navigation_bar_save));
        this.eJr.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
        this.eJr.setOnClickListener(this);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.channel_edit_no_network_view);
        this.eJp = (TbImageView) this.mRootView.findViewById(R.id.channel_edit_top_bg);
        this.eJp.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eJp.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eJp.setOnClickListener(this);
        this.eJs = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_cover);
        this.eJs.setOnClickListener(this);
        this.eJt = (HeadImageView) this.mRootView.findViewById(R.id.channel_show_channel_img);
        this.eJt.setIsRound(false);
        this.eJt.setRadius(0);
        this.eJt.setDrawBorder(true);
        this.eJt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eJt.setBorderColor(this.mContext.getResources().getColor(R.color.white_alpha40));
        this.eJt.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eJt.setOnClickListener(this);
        this.eJu = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_avatar);
        this.eJu.setOnClickListener(this);
        this.eJv = (TextView) this.mRootView.findViewById(R.id.channel_edit_channel_name);
        this.eJw = (EditText) this.mRootView.findViewById(R.id.channel_edit_channel_desc);
        this.eJx = (TextView) this.mRootView.findViewById(R.id.channel_desc_text_number);
        this.eJw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.channel.view.c.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String replaceAll = editable.toString().replaceAll("\\s*", "");
                BdLog.d(editable.toString());
                if (!replaceAll.equals(c.this.eJo.bav().getDescription())) {
                    ChannelEditActivity.isChanged = true;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.eJw.getText() != null) {
                    c.this.eJx.setText(c.this.mContext.getResources().getString(R.string.channel_desc_text_num, Integer.valueOf(c.this.eJw.getText().length())));
                    if (charSequence != null) {
                        String charSequence2 = charSequence.toString();
                        if (charSequence2.contains("\n")) {
                            c.this.eJw.setText(charSequence2.replaceAll("\\n", ""));
                            EditText editText = c.this.eJw;
                            if (i > c.this.eJw.getText().length()) {
                                i = c.this.eJw.getText().length();
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
        if (view == this.eJs || view == this.eJp) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig.setRequestCode(25007);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
        } else if (view == this.eJu || view == this.eJt) {
            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(this.mContext, this.writeImagesInfo.toJsonString());
            albumActivityConfig2.setRequestCode(25006);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
        } else if (view == this.eJq) {
            if (ChannelEditActivity.isChanged) {
                this.eJy = new com.baidu.tbadk.core.dialog.a(this.eJo.getActivity());
                this.eJy.mO(com.baidu.adp.lib.voice.h.getString(R.string.channel_save_info));
                this.eJy.a(this.mContext.getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.channel.view.c.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eJo.bau();
                    }
                });
                this.eJy.b(this.mContext.getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.channel.view.c.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                        aVar.dismiss();
                        c.this.eJo.finish();
                    }
                });
                this.eJy.b(this.eJo.getPageContext());
                this.eJy.agI();
                return;
            }
            this.eJo.finish();
        } else if (view == this.eJr) {
            this.eJo.bau();
        }
    }

    public String getDescription() {
        return this.eJw.getText().toString();
    }

    public void c(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eJp.startLoad(channelInfo.getChannelCover(), 10, this.eJp.getWidth(), this.eJp.getHeight(), false);
            this.eJt.startLoad(channelInfo.getChannelAvatar(), 10, this.eJt.getWidth(), this.eJt.getHeight(), false);
            this.eJv.setText(channelInfo.getChannelName());
            this.eJw.setText(channelInfo.getDescription());
        }
    }

    public void onChangeSkinType(int i) {
        this.eJo.getLayoutMode().setNightMode(i == 1);
        this.eJo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eJo.getPageContext(), i);
        this.dnF.onChangeSkinType(this.eJo.getPageContext(), i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.a(this.eJq, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        am.f(this.eJr, R.color.cp_cont_g, 1);
        this.eJt.setBorderColor(am.getColor(R.color.cp_bg_line_a_alpha80));
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }
}
