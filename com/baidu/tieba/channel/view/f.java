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
    private ImageView bTZ;
    private TbImageView eoY;
    private TextView epo;
    private HeadImageView epp;
    private TextView epq;
    private ChannelHomeSubOrAddVideoView epr;
    private ChannelHomeDescView eps;
    private LinearLayout ept;
    private TextView epu;
    private b epv;
    private ViewStub epw;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.epv = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.epp = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.epp.setIsRound(false);
        this.epp.setRadius(0);
        this.epp.setDrawBorder(true);
        this.epp.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.epp.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.epp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epv != null) {
                    f.this.epv.a(20, view, null, -1);
                }
            }
        });
        this.eoY = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.eoY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epv != null) {
                    f.this.epv.a(19, view, null, -1);
                }
            }
        });
        this.eoY.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.eoY.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.epo = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.epo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epv != null) {
                    f.this.epv.a(21, view, null, -1);
                }
            }
        });
        this.epq = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.ept = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.bTZ = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.eps = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.epr = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.epu = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aOM() {
        return this.mRootView;
    }

    public void hZ(boolean z) {
        this.eps.a(z, this.epv);
        this.epr.a(z, this.epv);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRs() != null) {
            ChannelInfo aRs = dVar.aRs();
            if (!dVar.isHost() && !aRs.isSubscribe()) {
                aRF();
            }
            this.epo.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(aRs.getFansCount())));
            this.eoY.startLoad(TextUtils.isEmpty(aRs.getChannelSmallCover()) ? aRs.getChannelCover() : aRs.getChannelSmallCover(), 10, this.eoY.getWidth(), this.eoY.getHeight(), false);
            this.epp.startLoad(aRs.getChannelAvatar(), 10, this.epp.getWidth(), this.epp.getHeight(), false);
            this.epq.setText(aRs.getChannelName());
            this.eps.aq(dVar);
            this.epr.aq(dVar);
            f(dVar);
        }
    }

    private void aRF() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.epw == null) {
                this.epw = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.epw.inflate();
                this.epw.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.epw.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.epr.onChangeSkinType(i);
        this.epp.setBorderColor(al.getColor(d.C0277d.cp_bg_line_a_alpha80));
        al.k(this.bTZ, d.f.icon_weiba);
    }

    public int aRG() {
        return this.ept.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.epr.aq(dVar);
        this.epo.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.as(dVar.aRs().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eoY.startLoad(channelInfo.getChannelSmallCover(), 10, this.eoY.getWidth(), this.eoY.getHeight(), false);
            this.epp.startLoad(channelInfo.getChannelAvatar(), 10, this.epp.getWidth(), this.epp.getHeight(), false);
            this.epq.setText(channelInfo.getChannelName());
            this.eps.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aRr() || dVar.aRs() == null) {
            this.epu.setVisibility(8);
            return;
        }
        this.epu.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.aRs().getVideoCount())));
        this.epu.setVisibility(0);
    }
}
