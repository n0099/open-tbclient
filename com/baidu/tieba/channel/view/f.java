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
    private ImageView bUc;
    private TbImageView eoL;
    private TextView epb;
    private HeadImageView epc;
    private TextView epd;
    private ChannelHomeSubOrAddVideoView epe;
    private ChannelHomeDescView epf;
    private LinearLayout epg;
    private TextView eph;
    private b epi;
    private ViewStub epj;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.epi = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.epc = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.epc.setIsRound(false);
        this.epc.setRadius(0);
        this.epc.setDrawBorder(true);
        this.epc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.epc.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.epc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epi != null) {
                    f.this.epi.a(20, view, null, -1);
                }
            }
        });
        this.eoL = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.eoL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epi != null) {
                    f.this.epi.a(19, view, null, -1);
                }
            }
        });
        this.eoL.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoL.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.epb = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.epb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epi != null) {
                    f.this.epi.a(21, view, null, -1);
                }
            }
        });
        this.epd = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.epg = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.bUc = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.epf = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.epe = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.eph = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aOH() {
        return this.mRootView;
    }

    public void hZ(boolean z) {
        this.epf.a(z, this.epi);
        this.epe.a(z, this.epi);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRq() != null) {
            ChannelInfo aRq = dVar.aRq();
            if (!dVar.isHost() && !aRq.isSubscribe()) {
                aRD();
            }
            this.epb.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(aRq.getFansCount())));
            this.eoL.startLoad(TextUtils.isEmpty(aRq.getChannelSmallCover()) ? aRq.getChannelCover() : aRq.getChannelSmallCover(), 10, this.eoL.getWidth(), this.eoL.getHeight(), false);
            this.epc.startLoad(aRq.getChannelAvatar(), 10, this.epc.getWidth(), this.epc.getHeight(), false);
            this.epd.setText(aRq.getChannelName());
            this.epf.am(dVar);
            this.epe.am(dVar);
            f(dVar);
        }
    }

    private void aRD() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.epj == null) {
                this.epj = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.epj.inflate();
                this.epj.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.epj.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.epe.onChangeSkinType(i);
        this.epc.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
        al.k(this.bUc, d.f.icon_weiba);
    }

    public int aRE() {
        return this.epg.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epe.am(dVar);
        this.epb.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(dVar.aRq().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoL.startLoad(channelInfo.getChannelSmallCover(), 10, this.eoL.getWidth(), this.eoL.getHeight(), false);
            this.epc.startLoad(channelInfo.getChannelAvatar(), 10, this.epc.getWidth(), this.epc.getHeight(), false);
            this.epd.setText(channelInfo.getChannelName());
            this.epf.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aRp() || dVar.aRq() == null) {
            this.eph.setVisibility(8);
            return;
        }
        this.eph.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.aRq().getVideoCount())));
        this.eph.setVisibility(0);
    }
}
