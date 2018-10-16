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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private ImageView aGE;
    private TbImageView cTI;
    private TextView cTY;
    private HeadImageView cTZ;
    private TextView cUa;
    private ChannelHomeSubOrAddVideoView cUb;
    private ChannelHomeDescView cUc;
    private LinearLayout cUd;
    private TextView cUe;
    private b cUf;
    private ViewStub cUg;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cUf = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.cTZ = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.cTZ.setIsRound(false);
        this.cTZ.setRadius(0);
        this.cTZ.setDrawBorder(true);
        this.cTZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds1));
        this.cTZ.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cTZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cUf != null) {
                    f.this.cUf.a(20, view, null, -1);
                }
            }
        });
        this.cTI = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.cTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cUf != null) {
                    f.this.cUf.a(19, view, null, -1);
                }
            }
        });
        this.cTI.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cTI.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cTY = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.cTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cUf != null) {
                    f.this.cUf.a(21, view, null, -1);
                }
            }
        });
        this.cUa = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.cUd = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aGE = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.cUc = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.cUb = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.cUe = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View amt() {
        return this.mRootView;
    }

    public void fq(boolean z) {
        this.cUc.a(z, this.cUf);
        this.cUb.a(z, this.cUf);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aoZ() != null) {
            ChannelInfo aoZ = dVar.aoZ();
            if (!dVar.isHost() && !aoZ.isSubscribe()) {
                apn();
            }
            this.cTY.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.G(aoZ.getFansCount())));
            this.cTI.startLoad(TextUtils.isEmpty(aoZ.getChannelSmallCover()) ? aoZ.getChannelCover() : aoZ.getChannelSmallCover(), 10, this.cTI.getWidth(), this.cTI.getHeight(), false);
            this.cTZ.startLoad(aoZ.getChannelAvatar(), 10, this.cTZ.getWidth(), this.cTZ.getHeight(), false);
            this.cUa.setText(aoZ.getChannelName());
            this.cUc.aa(dVar);
            this.cUb.aa(dVar);
            f(dVar);
        }
    }

    private void apn() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cUg == null) {
                this.cUg = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.cUg.inflate();
                this.cUg.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cUg.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cUb.onChangeSkinType(i);
        this.cTZ.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aGE, e.f.icon_weiba);
    }

    public int apo() {
        return this.cUd.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cUb.aa(dVar);
        this.cTY.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.G(dVar.aoZ().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cTI.startLoad(channelInfo.getChannelSmallCover(), 10, this.cTI.getWidth(), this.cTI.getHeight(), false);
            this.cTZ.startLoad(channelInfo.getChannelAvatar(), 10, this.cTZ.getWidth(), this.cTZ.getHeight(), false);
            this.cUa.setText(channelInfo.getChannelName());
            this.cUc.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aoY() || dVar.aoZ() == null) {
            this.cUe.setVisibility(8);
            return;
        }
        this.cUe.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.aoZ().getVideoCount())));
        this.cUe.setVisibility(0);
    }
}
