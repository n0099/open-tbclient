package com.baidu.tieba.channel.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class f {
    private ImageView cso;
    private TbImageView eTL;
    private TextView eUb;
    private HeadImageView eUc;
    private TextView eUd;
    private ChannelHomeSubOrAddVideoView eUe;
    private ChannelHomeDescView eUf;
    private LinearLayout eUg;
    private TextView eUh;
    private b eUi;
    private ViewStub eUj;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eUi = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eUc = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eUc.setIsRound(false);
        this.eUc.setRadius(0);
        this.eUc.setDrawBorder(true);
        this.eUc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eUc.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eUi != null) {
                    f.this.eUi.a(20, view, null, -1);
                }
            }
        });
        this.eTL = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eUi != null) {
                    f.this.eUi.a(19, view, null, -1);
                }
            }
        });
        this.eTL.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eTL.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eUb = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eUi != null) {
                    f.this.eUi.a(21, view, null, -1);
                }
            }
        });
        this.eUd = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eUg = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cso = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eUf = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eUe = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eUh = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aMx() {
        return this.mRootView;
    }

    public void iT(boolean z) {
        this.eUf.a(z, this.eUi);
        this.eUe.a(z, this.eUi);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbl() != null) {
            ChannelInfo bbl = dVar.bbl();
            if (!dVar.isHost() && !bbl.isSubscribe()) {
                bbz();
            }
            this.eUb.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.numberUniformFormat(bbl.getFansCount())));
            this.eTL.a(TextUtils.isEmpty(bbl.getChannelSmallCover()) ? bbl.getChannelCover() : bbl.getChannelSmallCover(), 10, this.eTL.getWidth(), this.eTL.getHeight(), false);
            this.eUc.a(bbl.getChannelAvatar(), 10, this.eUc.getWidth(), this.eUc.getHeight(), false);
            this.eUd.setText(bbl.getChannelName());
            this.eUf.al(dVar);
            this.eUe.al(dVar);
            f(dVar);
        }
    }

    private void bbz() {
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eUj == null) {
                this.eUj = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eUj.inflate();
                this.eUj.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eUj.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eUe.onChangeSkinType(i);
        this.eUc.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
        am.setBackgroundResource(this.cso, R.drawable.icon_weiba);
    }

    public int bbA() {
        return this.eUg.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eUe.al(dVar);
        this.eUb.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.numberUniformFormat(dVar.bbl().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eTL.a(channelInfo.getChannelSmallCover(), 10, this.eTL.getWidth(), this.eTL.getHeight(), false);
            this.eUc.a(channelInfo.getChannelAvatar(), 10, this.eUc.getWidth(), this.eUc.getHeight(), false);
            this.eUd.setText(channelInfo.getChannelName());
            this.eUf.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.bbk() || dVar.bbl() == null) {
            this.eUh.setVisibility(8);
            return;
        }
        this.eUh.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.bbl().getVideoCount())));
        this.eUh.setVisibility(0);
    }
}
