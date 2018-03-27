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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private ImageView beY;
    private TbImageView ddC;
    private TextView ddS;
    private HeadImageView ddT;
    private TextView ddU;
    private ChannelHomeSubOrAddVideoView ddV;
    private ChannelHomeDescView ddW;
    private LinearLayout ddX;
    private TextView ddY;
    private b ddZ;
    private ViewStub dea;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.ddZ = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.ddT = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.ddT.setIsRound(false);
        this.ddT.setRadius(0);
        this.ddT.setDrawBorder(true);
        this.ddT.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.ddT.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.ddT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddZ != null) {
                    f.this.ddZ.a(20, view, null, -1);
                }
            }
        });
        this.ddC = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.ddC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddZ != null) {
                    f.this.ddZ.a(19, view, null, -1);
                }
            }
        });
        this.ddC.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddC.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.ddS = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.ddS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddZ != null) {
                    f.this.ddZ.a(21, view, null, -1);
                }
            }
        });
        this.ddU = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.ddX = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.beY = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.ddW = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.ddV = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.ddY = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aix() {
        return this.mRootView;
    }

    public void eW(boolean z) {
        this.ddW.a(z, this.ddZ);
        this.ddV.a(z, this.ddZ);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            ChannelInfo amj = dVar.amj();
            if (!dVar.isHost() && !amj.isSubscribe()) {
                amx();
            }
            this.ddS.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(amj.getFansCount())));
            this.ddC.startLoad(TextUtils.isEmpty(amj.getChannelSmallCover()) ? amj.getChannelCover() : amj.getChannelSmallCover(), 10, this.ddC.getWidth(), this.ddC.getHeight(), false);
            this.ddT.startLoad(amj.getChannelAvatar(), 10, this.ddT.getWidth(), this.ddT.getHeight(), false);
            this.ddU.setText(amj.getChannelName());
            this.ddW.aT(dVar);
            this.ddV.aT(dVar);
            f(dVar);
        }
    }

    private void amx() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.dea == null) {
                this.dea = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.dea.inflate();
                this.dea.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.dea.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.ddV.onChangeSkinType(i);
        this.ddT.setBorderColor(aj.getColor(d.C0141d.cp_bg_line_a_alpha80));
        aj.s(this.beY, d.f.icon_weiba);
    }

    public int amy() {
        return this.ddX.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.ddV.aT(dVar);
        this.ddS.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(dVar.amj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddC.startLoad(channelInfo.getChannelSmallCover(), 10, this.ddC.getWidth(), this.ddC.getHeight(), false);
            this.ddT.startLoad(channelInfo.getChannelAvatar(), 10, this.ddT.getWidth(), this.ddT.getHeight(), false);
            this.ddU.setText(channelInfo.getChannelName());
            this.ddW.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ami() || dVar.amj() == null) {
            this.ddY.setVisibility(8);
            return;
        }
        this.ddY.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.amj().getVideoCount())));
        this.ddY.setVisibility(0);
    }
}
