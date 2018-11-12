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
    private ImageView aHu;
    private TbImageView cUO;
    private TextView cVe;
    private HeadImageView cVf;
    private TextView cVg;
    private ChannelHomeSubOrAddVideoView cVh;
    private ChannelHomeDescView cVi;
    private LinearLayout cVj;
    private TextView cVk;
    private b cVl;
    private ViewStub cVm;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cVl = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.cVf = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.cVf.setIsRound(false);
        this.cVf.setRadius(0);
        this.cVf.setDrawBorder(true);
        this.cVf.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds1));
        this.cVf.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cVf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cVl != null) {
                    f.this.cVl.a(20, view, null, -1);
                }
            }
        });
        this.cUO = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.cUO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cVl != null) {
                    f.this.cVl.a(19, view, null, -1);
                }
            }
        });
        this.cUO.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cUO.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cVe = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.cVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cVl != null) {
                    f.this.cVl.a(21, view, null, -1);
                }
            }
        });
        this.cVg = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.cVj = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aHu = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.cVi = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.cVh = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.cVk = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View alT() {
        return this.mRootView;
    }

    public void fB(boolean z) {
        this.cVi.a(z, this.cVl);
        this.cVh.a(z, this.cVl);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aoB() != null) {
            ChannelInfo aoB = dVar.aoB();
            if (!dVar.isHost() && !aoB.isSubscribe()) {
                aoO();
            }
            this.cVe.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.I(aoB.getFansCount())));
            this.cUO.startLoad(TextUtils.isEmpty(aoB.getChannelSmallCover()) ? aoB.getChannelCover() : aoB.getChannelSmallCover(), 10, this.cUO.getWidth(), this.cUO.getHeight(), false);
            this.cVf.startLoad(aoB.getChannelAvatar(), 10, this.cVf.getWidth(), this.cVf.getHeight(), false);
            this.cVg.setText(aoB.getChannelName());
            this.cVi.Z(dVar);
            this.cVh.Z(dVar);
            f(dVar);
        }
    }

    private void aoO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cVm == null) {
                this.cVm = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.cVm.inflate();
                this.cVm.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cVm.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cVh.onChangeSkinType(i);
        this.cVf.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aHu, e.f.icon_weiba);
    }

    public int aoP() {
        return this.cVj.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cVh.Z(dVar);
        this.cVe.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.I(dVar.aoB().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cUO.startLoad(channelInfo.getChannelSmallCover(), 10, this.cUO.getWidth(), this.cUO.getHeight(), false);
            this.cVf.startLoad(channelInfo.getChannelAvatar(), 10, this.cVf.getWidth(), this.cVf.getHeight(), false);
            this.cVg.setText(channelInfo.getChannelName());
            this.cVi.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aoA() || dVar.aoB() == null) {
            this.cVk.setVisibility(8);
            return;
        }
        this.cVk.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.aoB().getVideoCount())));
        this.cVk.setVisibility(0);
    }
}
