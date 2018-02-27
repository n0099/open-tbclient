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
    private ImageView beV;
    private TextView ddP;
    private HeadImageView ddQ;
    private TextView ddR;
    private ChannelHomeSubOrAddVideoView ddS;
    private ChannelHomeDescView ddT;
    private LinearLayout ddU;
    private TextView ddV;
    private b ddW;
    private ViewStub ddX;
    private TbImageView ddz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.ddW = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.ddQ = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.ddQ.setIsRound(false);
        this.ddQ.setRadius(0);
        this.ddQ.setDrawBorder(true);
        this.ddQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.ddQ.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.ddQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddW != null) {
                    f.this.ddW.a(20, view, null, -1);
                }
            }
        });
        this.ddz = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.ddz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddW != null) {
                    f.this.ddW.a(19, view, null, -1);
                }
            }
        });
        this.ddz.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddz.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.ddP = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.ddP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ddW != null) {
                    f.this.ddW.a(21, view, null, -1);
                }
            }
        });
        this.ddR = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.ddU = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.beV = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.ddT = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.ddS = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.ddV = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aiw() {
        return this.mRootView;
    }

    public void eW(boolean z) {
        this.ddT.a(z, this.ddW);
        this.ddS.a(z, this.ddW);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ami() != null) {
            ChannelInfo ami = dVar.ami();
            if (!dVar.isHost() && !ami.isSubscribe()) {
                amw();
            }
            this.ddP.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(ami.getFansCount())));
            this.ddz.startLoad(TextUtils.isEmpty(ami.getChannelSmallCover()) ? ami.getChannelCover() : ami.getChannelSmallCover(), 10, this.ddz.getWidth(), this.ddz.getHeight(), false);
            this.ddQ.startLoad(ami.getChannelAvatar(), 10, this.ddQ.getWidth(), this.ddQ.getHeight(), false);
            this.ddR.setText(ami.getChannelName());
            this.ddT.aT(dVar);
            this.ddS.aT(dVar);
            f(dVar);
        }
    }

    private void amw() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.ddX == null) {
                this.ddX = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.ddX.inflate();
                this.ddX.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.ddX.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.ddS.onChangeSkinType(i);
        this.ddQ.setBorderColor(aj.getColor(d.C0141d.cp_bg_line_a_alpha80));
        aj.s(this.beV, d.f.icon_weiba);
    }

    public int amx() {
        return this.ddU.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.ddS.aT(dVar);
        this.ddP.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(dVar.ami().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddz.startLoad(channelInfo.getChannelSmallCover(), 10, this.ddz.getWidth(), this.ddz.getHeight(), false);
            this.ddQ.startLoad(channelInfo.getChannelAvatar(), 10, this.ddQ.getWidth(), this.ddQ.getHeight(), false);
            this.ddR.setText(channelInfo.getChannelName());
            this.ddT.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.amh() || dVar.ami() == null) {
            this.ddV.setVisibility(8);
            return;
        }
        this.ddV.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.ami().getVideoCount())));
        this.ddV.setVisibility(0);
    }
}
