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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f {
    private ImageView ayW;
    private TextView cFO;
    private HeadImageView cFP;
    private TextView cFQ;
    private ChannelHomeSubOrAddVideoView cFR;
    private ChannelHomeDescView cFS;
    private LinearLayout cFT;
    private TextView cFU;
    private b cFV;
    private ViewStub cFW;
    private TbImageView cFy;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cFV = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.channel_home_header_layout, (ViewGroup) null);
        this.cFP = (HeadImageView) this.mRootView.findViewById(f.g.channel_home_header_channel_img);
        this.cFP.setIsRound(false);
        this.cFP.setRadius(0);
        this.cFP.setDrawBorder(true);
        this.cFP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(f.e.ds1));
        this.cFP.setDefaultErrorResource(f.C0146f.avatar_channel_poto_defaul160);
        this.cFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFV != null) {
                    f.this.cFV.a(20, view, null, -1);
                }
            }
        });
        this.cFy = (TbImageView) this.mRootView.findViewById(f.g.channel_home_top_bg);
        this.cFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFV != null) {
                    f.this.cFV.a(19, view, null, -1);
                }
            }
        });
        this.cFy.setDefaultErrorResource(f.C0146f.bg_avatar_weiba_head);
        this.cFy.setDefaultBgResource(f.C0146f.bg_avatar_weiba_head);
        this.cFO = (TextView) this.mRootView.findViewById(f.g.channel_home_top_right_textview);
        this.cFO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFV != null) {
                    f.this.cFV.a(21, view, null, -1);
                }
            }
        });
        this.cFQ = (TextView) this.mRootView.findViewById(f.g.channel_home_header_channel_name);
        this.cFT = (LinearLayout) this.mRootView.findViewById(f.g.channel_home_channel_name_layout);
        this.ayW = (ImageView) this.mRootView.findViewById(f.g.channel_home_channel_icon);
        this.cFS = (ChannelHomeDescView) this.mRootView.findViewById(f.g.channel_home_header_channel_desc);
        this.cFR = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(f.g.channel_home_header_botton_btn);
        this.cFU = (TextView) this.mRootView.findViewById(f.g.channel_home_header_video_count);
    }

    public View ahd() {
        return this.mRootView;
    }

    public void eH(boolean z) {
        this.cFS.a(z, this.cFV);
        this.cFR.a(z, this.cFV);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajM() != null) {
            ChannelInfo ajM = dVar.ajM();
            if (!dVar.isHost() && !ajM.isSubscribe()) {
                ajZ();
            }
            this.cFO.setText(this.mContext.getResources().getString(f.j.channel_subscribe_num, ap.A(ajM.getFansCount())));
            this.cFy.startLoad(TextUtils.isEmpty(ajM.getChannelSmallCover()) ? ajM.getChannelCover() : ajM.getChannelSmallCover(), 10, this.cFy.getWidth(), this.cFy.getHeight(), false);
            this.cFP.startLoad(ajM.getChannelAvatar(), 10, this.cFP.getWidth(), this.cFP.getHeight(), false);
            this.cFQ.setText(ajM.getChannelName());
            this.cFS.T(dVar);
            this.cFR.T(dVar);
            f(dVar);
        }
    }

    private void ajZ() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cFW == null) {
                this.cFW = (ViewStub) this.mRootView.findViewById(f.g.channel_home_header_tips);
                this.cFW.inflate();
                this.cFW.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cFW.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cFR.onChangeSkinType(i);
        this.cFP.setBorderColor(am.getColor(f.d.cp_bg_line_a_alpha80));
        am.i(this.ayW, f.C0146f.icon_weiba);
    }

    public int aka() {
        return this.cFT.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cFR.T(dVar);
        this.cFO.setText(this.mContext.getResources().getString(f.j.channel_subscribe_num, ap.A(dVar.ajM().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFy.startLoad(channelInfo.getChannelSmallCover(), 10, this.cFy.getWidth(), this.cFy.getHeight(), false);
            this.cFP.startLoad(channelInfo.getChannelAvatar(), 10, this.cFP.getWidth(), this.cFP.getHeight(), false);
            this.cFQ.setText(channelInfo.getChannelName());
            this.cFS.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ajL() || dVar.ajM() == null) {
            this.cFU.setVisibility(8);
            return;
        }
        this.cFU.setText(this.mContext.getResources().getString(f.j.channel_home_video_count, Integer.valueOf(dVar.ajM().getVideoCount())));
        this.cFU.setVisibility(0);
    }
}
