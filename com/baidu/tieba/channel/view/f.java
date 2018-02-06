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
    private ImageView bfi;
    private TbImageView ddL;
    private TextView deb;
    private HeadImageView dec;
    private TextView ded;
    private ChannelHomeSubOrAddVideoView dee;
    private ChannelHomeDescView def;
    private LinearLayout deg;
    private TextView deh;
    private b dei;
    private ViewStub dej;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.dei = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.dec = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.dec.setIsRound(false);
        this.dec.setRadius(0);
        this.dec.setDrawBorder(true);
        this.dec.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.dec.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.dec.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dei != null) {
                    f.this.dei.a(20, view, null, -1);
                }
            }
        });
        this.ddL = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.ddL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dei != null) {
                    f.this.dei.a(19, view, null, -1);
                }
            }
        });
        this.ddL.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.ddL.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.deb = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.deb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dei != null) {
                    f.this.dei.a(21, view, null, -1);
                }
            }
        });
        this.ded = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.deg = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.bfi = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.def = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.dee = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.deh = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aix() {
        return this.mRootView;
    }

    public void eW(boolean z) {
        this.def.a(z, this.dei);
        this.dee.a(z, this.dei);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            ChannelInfo amj = dVar.amj();
            if (!dVar.isHost() && !amj.isSubscribe()) {
                amx();
            }
            this.deb.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(amj.getFansCount())));
            this.ddL.startLoad(TextUtils.isEmpty(amj.getChannelSmallCover()) ? amj.getChannelCover() : amj.getChannelSmallCover(), 10, this.ddL.getWidth(), this.ddL.getHeight(), false);
            this.dec.startLoad(amj.getChannelAvatar(), 10, this.dec.getWidth(), this.dec.getHeight(), false);
            this.ded.setText(amj.getChannelName());
            this.def.aT(dVar);
            this.dee.aT(dVar);
            f(dVar);
        }
    }

    private void amx() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.dej == null) {
                this.dej = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.dej.inflate();
                this.dej.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.dej.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.dee.onChangeSkinType(i);
        this.dec.setBorderColor(aj.getColor(d.C0140d.cp_bg_line_a_alpha80));
        aj.s(this.bfi, d.f.icon_weiba);
    }

    public int amy() {
        return this.deg.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dee.aT(dVar);
        this.deb.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, am.C(dVar.amj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.ddL.startLoad(channelInfo.getChannelSmallCover(), 10, this.ddL.getWidth(), this.ddL.getHeight(), false);
            this.dec.startLoad(channelInfo.getChannelAvatar(), 10, this.dec.getWidth(), this.dec.getHeight(), false);
            this.ded.setText(channelInfo.getChannelName());
            this.def.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ami() || dVar.amj() == null) {
            this.deh.setVisibility(8);
            return;
        }
        this.deh.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.amj().getVideoCount())));
        this.deh.setVisibility(0);
    }
}
