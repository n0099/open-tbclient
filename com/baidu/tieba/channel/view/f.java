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
    private ImageView aKW;
    private TextView deG;
    private HeadImageView deH;
    private TextView deI;
    private ChannelHomeSubOrAddVideoView deJ;
    private ChannelHomeDescView deK;
    private LinearLayout deL;
    private TextView deM;
    private b deN;
    private ViewStub deO;
    private TbImageView dep;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.deN = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.deH = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.deH.setIsRound(false);
        this.deH.setRadius(0);
        this.deH.setDrawBorder(true);
        this.deH.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.deH.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.deH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.deN != null) {
                    f.this.deN.a(20, view, null, -1);
                }
            }
        });
        this.dep = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.dep.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.deN != null) {
                    f.this.deN.a(19, view, null, -1);
                }
            }
        });
        this.dep.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dep.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.deG = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.deG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.deN != null) {
                    f.this.deN.a(21, view, null, -1);
                }
            }
        });
        this.deI = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.deL = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aKW = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.deK = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.deJ = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.deM = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View anC() {
        return this.mRootView;
    }

    public void fE(boolean z) {
        this.deK.a(z, this.deN);
        this.deJ.a(z, this.deN);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ard() != null) {
            ChannelInfo ard = dVar.ard();
            if (!dVar.isHost() && !ard.isSubscribe()) {
                arq();
            }
            this.deG.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(ard.getFansCount())));
            this.dep.startLoad(TextUtils.isEmpty(ard.getChannelSmallCover()) ? ard.getChannelCover() : ard.getChannelSmallCover(), 10, this.dep.getWidth(), this.dep.getHeight(), false);
            this.deH.startLoad(ard.getChannelAvatar(), 10, this.deH.getWidth(), this.deH.getHeight(), false);
            this.deI.setText(ard.getChannelName());
            this.deK.Z(dVar);
            this.deJ.Z(dVar);
            f(dVar);
        }
    }

    private void arq() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.deO == null) {
                this.deO = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.deO.inflate();
                this.deO.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.deO.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.deJ.onChangeSkinType(i);
        this.deH.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aKW, e.f.icon_weiba);
    }

    public int arr() {
        return this.deL.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.deJ.Z(dVar);
        this.deG.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(dVar.ard().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dep.startLoad(channelInfo.getChannelSmallCover(), 10, this.dep.getWidth(), this.dep.getHeight(), false);
            this.deH.startLoad(channelInfo.getChannelAvatar(), 10, this.deH.getWidth(), this.deH.getHeight(), false);
            this.deI.setText(channelInfo.getChannelName());
            this.deK.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.arc() || dVar.ard() == null) {
            this.deM.setVisibility(8);
            return;
        }
        this.deM.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.ard().getVideoCount())));
        this.deM.setVisibility(0);
    }
}
