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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private ImageView ayZ;
    private TbImageView cFB;
    private TextView cFR;
    private HeadImageView cFS;
    private TextView cFT;
    private ChannelHomeSubOrAddVideoView cFU;
    private ChannelHomeDescView cFV;
    private LinearLayout cFW;
    private TextView cFX;
    private b cFY;
    private ViewStub cFZ;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cFY = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.channel_home_header_layout, (ViewGroup) null);
        this.cFS = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cFS.setIsRound(false);
        this.cFS.setRadius(0);
        this.cFS.setDrawBorder(true);
        this.cFS.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cFS.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cFS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFY != null) {
                    f.this.cFY.a(20, view, null, -1);
                }
            }
        });
        this.cFB = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFY != null) {
                    f.this.cFY.a(19, view, null, -1);
                }
            }
        });
        this.cFB.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cFB.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cFR = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFY != null) {
                    f.this.cFY.a(21, view, null, -1);
                }
            }
        });
        this.cFT = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cFW = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.ayZ = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cFV = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cFU = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cFX = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View ahb() {
        return this.mRootView;
    }

    public void eH(boolean z) {
        this.cFV.a(z, this.cFY);
        this.cFU.a(z, this.cFY);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajJ() != null) {
            ChannelInfo ajJ = dVar.ajJ();
            if (!dVar.isHost() && !ajJ.isSubscribe()) {
                ajX();
            }
            this.cFR.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.A(ajJ.getFansCount())));
            this.cFB.startLoad(TextUtils.isEmpty(ajJ.getChannelSmallCover()) ? ajJ.getChannelCover() : ajJ.getChannelSmallCover(), 10, this.cFB.getWidth(), this.cFB.getHeight(), false);
            this.cFS.startLoad(ajJ.getChannelAvatar(), 10, this.cFS.getWidth(), this.cFS.getHeight(), false);
            this.cFT.setText(ajJ.getChannelName());
            this.cFV.T(dVar);
            this.cFU.T(dVar);
            f(dVar);
        }
    }

    private void ajX() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cFZ == null) {
                this.cFZ = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cFZ.inflate();
                this.cFZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cFZ.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cFU.onChangeSkinType(i);
        this.cFS.setBorderColor(am.getColor(d.C0140d.cp_bg_line_a_alpha80));
        am.i(this.ayZ, d.f.icon_weiba);
    }

    public int ajY() {
        return this.cFW.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cFU.T(dVar);
        this.cFR.setText(this.mContext.getResources().getString(d.j.channel_subscribe_num, ap.A(dVar.ajJ().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFB.startLoad(channelInfo.getChannelSmallCover(), 10, this.cFB.getWidth(), this.cFB.getHeight(), false);
            this.cFS.startLoad(channelInfo.getChannelAvatar(), 10, this.cFS.getWidth(), this.cFS.getHeight(), false);
            this.cFT.setText(channelInfo.getChannelName());
            this.cFV.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ajI() || dVar.ajJ() == null) {
            this.cFX.setVisibility(8);
            return;
        }
        this.cFX.setText(this.mContext.getResources().getString(d.j.channel_home_video_count, Integer.valueOf(dVar.ajJ().getVideoCount())));
        this.cFX.setVisibility(0);
    }
}
