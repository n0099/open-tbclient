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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class f {
    private ImageView bUb;
    private TbImageView eoK;
    private TextView epa;
    private HeadImageView epb;
    private TextView epc;
    private ChannelHomeSubOrAddVideoView epd;
    private ChannelHomeDescView epe;
    private LinearLayout epf;
    private TextView epg;
    private b eph;
    private ViewStub epi;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eph = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.epb = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.epb.setIsRound(false);
        this.epb.setRadius(0);
        this.epb.setDrawBorder(true);
        this.epb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.epb.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.epb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eph != null) {
                    f.this.eph.a(20, view, null, -1);
                }
            }
        });
        this.eoK = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.eoK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eph != null) {
                    f.this.eph.a(19, view, null, -1);
                }
            }
        });
        this.eoK.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoK.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.epa = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.epa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eph != null) {
                    f.this.eph.a(21, view, null, -1);
                }
            }
        });
        this.epc = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.epf = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.bUb = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.epe = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.epd = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.epg = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aOH() {
        return this.mRootView;
    }

    public void hZ(boolean z) {
        this.epe.a(z, this.eph);
        this.epd.a(z, this.eph);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRq() != null) {
            ChannelInfo aRq = dVar.aRq();
            if (!dVar.isHost() && !aRq.isSubscribe()) {
                aRD();
            }
            this.epa.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(aRq.getFansCount())));
            this.eoK.startLoad(TextUtils.isEmpty(aRq.getChannelSmallCover()) ? aRq.getChannelCover() : aRq.getChannelSmallCover(), 10, this.eoK.getWidth(), this.eoK.getHeight(), false);
            this.epb.startLoad(aRq.getChannelAvatar(), 10, this.epb.getWidth(), this.epb.getHeight(), false);
            this.epc.setText(aRq.getChannelName());
            this.epe.am(dVar);
            this.epd.am(dVar);
            f(dVar);
        }
    }

    private void aRD() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.epi == null) {
                this.epi = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.epi.inflate();
                this.epi.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.epi.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.epd.onChangeSkinType(i);
        this.epb.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
        al.k(this.bUb, d.f.icon_weiba);
    }

    public int aRE() {
        return this.epf.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epd.am(dVar);
        this.epa.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(dVar.aRq().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoK.startLoad(channelInfo.getChannelSmallCover(), 10, this.eoK.getWidth(), this.eoK.getHeight(), false);
            this.epb.startLoad(channelInfo.getChannelAvatar(), 10, this.epb.getWidth(), this.epb.getHeight(), false);
            this.epc.setText(channelInfo.getChannelName());
            this.epe.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aRp() || dVar.aRq() == null) {
            this.epg.setVisibility(8);
            return;
        }
        this.epg.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.aRq().getVideoCount())));
        this.epg.setVisibility(0);
    }
}
