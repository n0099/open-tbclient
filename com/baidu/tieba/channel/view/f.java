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
    private ImageView aLy;
    private ViewStub dfA;
    private TbImageView dfc;
    private TextView dfs;
    private HeadImageView dft;
    private TextView dfu;
    private ChannelHomeSubOrAddVideoView dfv;
    private ChannelHomeDescView dfw;
    private LinearLayout dfx;
    private TextView dfy;
    private b dfz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.dfz = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.dft = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.dft.setIsRound(false);
        this.dft.setRadius(0);
        this.dft.setDrawBorder(true);
        this.dft.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.dft.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.dft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfz != null) {
                    f.this.dfz.a(20, view, null, -1);
                }
            }
        });
        this.dfc = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.dfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfz != null) {
                    f.this.dfz.a(19, view, null, -1);
                }
            }
        });
        this.dfc.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dfc.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dfs = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.dfs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dfz != null) {
                    f.this.dfz.a(21, view, null, -1);
                }
            }
        });
        this.dfu = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.dfx = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aLy = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.dfw = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.dfv = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.dfy = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View anZ() {
        return this.mRootView;
    }

    public void fH(boolean z) {
        this.dfw.a(z, this.dfz);
        this.dfv.a(z, this.dfz);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.arB() != null) {
            ChannelInfo arB = dVar.arB();
            if (!dVar.isHost() && !arB.isSubscribe()) {
                arO();
            }
            this.dfs.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(arB.getFansCount())));
            this.dfc.startLoad(TextUtils.isEmpty(arB.getChannelSmallCover()) ? arB.getChannelCover() : arB.getChannelSmallCover(), 10, this.dfc.getWidth(), this.dfc.getHeight(), false);
            this.dft.startLoad(arB.getChannelAvatar(), 10, this.dft.getWidth(), this.dft.getHeight(), false);
            this.dfu.setText(arB.getChannelName());
            this.dfw.Z(dVar);
            this.dfv.Z(dVar);
            f(dVar);
        }
    }

    private void arO() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.dfA == null) {
                this.dfA = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.dfA.inflate();
                this.dfA.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.dfA.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.dfv.onChangeSkinType(i);
        this.dft.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aLy, e.f.icon_weiba);
    }

    public int arP() {
        return this.dfx.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dfv.Z(dVar);
        this.dfs.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.Q(dVar.arB().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dfc.startLoad(channelInfo.getChannelSmallCover(), 10, this.dfc.getWidth(), this.dfc.getHeight(), false);
            this.dft.startLoad(channelInfo.getChannelAvatar(), 10, this.dft.getWidth(), this.dft.getHeight(), false);
            this.dfu.setText(channelInfo.getChannelName());
            this.dfw.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.arA() || dVar.arB() == null) {
            this.dfy.setVisibility(8);
            return;
        }
        this.dfy.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.arB().getVideoCount())));
        this.dfy.setVisibility(0);
    }
}
