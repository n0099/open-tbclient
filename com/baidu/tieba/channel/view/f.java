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
    private ImageView aKU;
    private TextView dbN;
    private HeadImageView dbO;
    private TextView dbP;
    private ChannelHomeSubOrAddVideoView dbQ;
    private ChannelHomeDescView dbR;
    private LinearLayout dbS;
    private TextView dbT;
    private b dbU;
    private ViewStub dbV;
    private TbImageView dbx;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.dbU = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.dbO = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.dbO.setIsRound(false);
        this.dbO.setRadius(0);
        this.dbO.setDrawBorder(true);
        this.dbO.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1));
        this.dbO.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.dbO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dbU != null) {
                    f.this.dbU.a(20, view, null, -1);
                }
            }
        });
        this.dbx = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.dbx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dbU != null) {
                    f.this.dbU.a(19, view, null, -1);
                }
            }
        });
        this.dbx.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.dbx.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.dbN = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.dbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dbU != null) {
                    f.this.dbU.a(21, view, null, -1);
                }
            }
        });
        this.dbP = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.dbS = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aKU = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.dbR = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.dbQ = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.dbT = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View ana() {
        return this.mRootView;
    }

    public void fC(boolean z) {
        this.dbR.a(z, this.dbU);
        this.dbQ.a(z, this.dbU);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aqo() != null) {
            ChannelInfo aqo = dVar.aqo();
            if (!dVar.isHost() && !aqo.isSubscribe()) {
                aqB();
            }
            this.dbN.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.P(aqo.getFansCount())));
            this.dbx.startLoad(TextUtils.isEmpty(aqo.getChannelSmallCover()) ? aqo.getChannelCover() : aqo.getChannelSmallCover(), 10, this.dbx.getWidth(), this.dbx.getHeight(), false);
            this.dbO.startLoad(aqo.getChannelAvatar(), 10, this.dbO.getWidth(), this.dbO.getHeight(), false);
            this.dbP.setText(aqo.getChannelName());
            this.dbR.Z(dVar);
            this.dbQ.Z(dVar);
            f(dVar);
        }
    }

    private void aqB() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.dbV == null) {
                this.dbV = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.dbV.inflate();
                this.dbV.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.dbV.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.dbQ.onChangeSkinType(i);
        this.dbO.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aKU, e.f.icon_weiba);
    }

    public int aqC() {
        return this.dbS.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.dbQ.Z(dVar);
        this.dbN.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.P(dVar.aqo().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.dbx.startLoad(channelInfo.getChannelSmallCover(), 10, this.dbx.getWidth(), this.dbx.getHeight(), false);
            this.dbO.startLoad(channelInfo.getChannelAvatar(), 10, this.dbO.getWidth(), this.dbO.getHeight(), false);
            this.dbP.setText(channelInfo.getChannelName());
            this.dbR.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aqn() || dVar.aqo() == null) {
            this.dbT.setVisibility(8);
            return;
        }
        this.dbT.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.aqo().getVideoCount())));
        this.dbT.setVisibility(0);
    }
}
