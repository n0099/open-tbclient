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
    private ImageView aLz;
    private b dfA;
    private ViewStub dfB;
    private TbImageView dfd;
    private TextView dft;
    private HeadImageView dfu;
    private TextView dfv;
    private ChannelHomeSubOrAddVideoView dfw;
    private ChannelHomeDescView dfx;
    private LinearLayout dfy;
    private TextView dfz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.dfA = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.dfu = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.dfu.setIsRound(false);
        this.dfu.setRadius(0);
        this.dfu.setDrawBorder(true);
        this.dfu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.dfu.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.dfu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfA != null) {
                    f.this.dfA.a(20, view, null, -1);
                }
            }
        });
        this.dfd = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.dfd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfA != null) {
                    f.this.dfA.a(19, view, null, -1);
                }
            }
        });
        this.dfd.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dfd.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dft = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.dft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfA != null) {
                    f.this.dfA.a(21, view, null, -1);
                }
            }
        });
        this.dfv = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.dfy = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aLz = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.dfx = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.dfw = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.dfz = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View anZ() {
        return this.mRootView;
    }

    public void fH(boolean z) {
        this.dfx.a(z, this.dfA);
        this.dfw.a(z, this.dfA);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.arB() != null) {
            ChannelInfo arB = dVar.arB();
            if (!dVar.isHost() && !arB.isSubscribe()) {
                arO();
            }
            this.dft.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(arB.getFansCount())));
            this.dfd.startLoad(TextUtils.isEmpty(arB.getChannelSmallCover()) ? arB.getChannelCover() : arB.getChannelSmallCover(), 10, this.dfd.getWidth(), this.dfd.getHeight(), false);
            this.dfu.startLoad(arB.getChannelAvatar(), 10, this.dfu.getWidth(), this.dfu.getHeight(), false);
            this.dfv.setText(arB.getChannelName());
            this.dfx.Z(dVar);
            this.dfw.Z(dVar);
            f(dVar);
        }
    }

    private void arO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.dfB == null) {
                this.dfB = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.dfB.inflate();
                this.dfB.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.dfB.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.dfw.onChangeSkinType(i);
        this.dfu.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aLz, e.f.icon_weiba);
    }

    public int arP() {
        return this.dfy.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dfw.Z(dVar);
        this.dft.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(dVar.arB().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dfd.startLoad(channelInfo.getChannelSmallCover(), 10, this.dfd.getWidth(), this.dfd.getHeight(), false);
            this.dfu.startLoad(channelInfo.getChannelAvatar(), 10, this.dfu.getWidth(), this.dfu.getHeight(), false);
            this.dfv.setText(channelInfo.getChannelName());
            this.dfx.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.arA() || dVar.arB() == null) {
            this.dfz.setVisibility(8);
            return;
        }
        this.dfz.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.arB().getVideoCount())));
        this.dfz.setVisibility(0);
    }
}
