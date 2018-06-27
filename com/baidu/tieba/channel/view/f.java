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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private ImageView azn;
    private TbImageView cCV;
    private TextView cDl;
    private HeadImageView cDm;
    private TextView cDn;
    private ChannelHomeSubOrAddVideoView cDo;
    private ChannelHomeDescView cDp;
    private LinearLayout cDq;
    private TextView cDr;
    private b cDs;
    private ViewStub cDt;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cDs = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_layout, (ViewGroup) null);
        this.cDm = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cDm.setIsRound(false);
        this.cDm.setRadius(0);
        this.cDm.setDrawBorder(true);
        this.cDm.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cDm.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cDs != null) {
                    f.this.cDs.a(20, view, null, -1);
                }
            }
        });
        this.cCV = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cDs != null) {
                    f.this.cDs.a(19, view, null, -1);
                }
            }
        });
        this.cCV.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cCV.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cDl = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cDs != null) {
                    f.this.cDs.a(21, view, null, -1);
                }
            }
        });
        this.cDn = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cDq = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.azn = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cDp = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cDo = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cDr = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View agG() {
        return this.mRootView;
    }

    public void eG(boolean z) {
        this.cDp.a(z, this.cDs);
        this.cDo.a(z, this.cDs);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajl() != null) {
            ChannelInfo ajl = dVar.ajl();
            if (!dVar.isHost() && !ajl.isSubscribe()) {
                ajz();
            }
            this.cDl.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, ap.z(ajl.getFansCount())));
            this.cCV.startLoad(TextUtils.isEmpty(ajl.getChannelSmallCover()) ? ajl.getChannelCover() : ajl.getChannelSmallCover(), 10, this.cCV.getWidth(), this.cCV.getHeight(), false);
            this.cDm.startLoad(ajl.getChannelAvatar(), 10, this.cDm.getWidth(), this.cDm.getHeight(), false);
            this.cDn.setText(ajl.getChannelName());
            this.cDp.T(dVar);
            this.cDo.T(dVar);
            f(dVar);
        }
    }

    private void ajz() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cDt == null) {
                this.cDt = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cDt.inflate();
                this.cDt.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cDt.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cDo.onChangeSkinType(i);
        this.cDm.setBorderColor(am.getColor(d.C0142d.cp_bg_line_a_alpha80));
        am.i(this.azn, d.f.icon_weiba);
    }

    public int ajA() {
        return this.cDq.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cDo.T(dVar);
        this.cDl.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, ap.z(dVar.ajl().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cCV.startLoad(channelInfo.getChannelSmallCover(), 10, this.cCV.getWidth(), this.cCV.getHeight(), false);
            this.cDm.startLoad(channelInfo.getChannelAvatar(), 10, this.cDm.getWidth(), this.cDm.getHeight(), false);
            this.cDn.setText(channelInfo.getChannelName());
            this.cDp.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ajk() || dVar.ajl() == null) {
            this.cDr.setVisibility(8);
            return;
        }
        this.cDr.setText(this.mContext.getResources().getString(d.k.channel_home_video_count, Integer.valueOf(dVar.ajl().getVideoCount())));
        this.cDr.setVisibility(0);
    }
}
