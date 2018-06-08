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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private ImageView ayv;
    private ViewStub cFA;
    private TbImageView cFc;
    private TextView cFs;
    private HeadImageView cFt;
    private TextView cFu;
    private ChannelHomeSubOrAddVideoView cFv;
    private ChannelHomeDescView cFw;
    private LinearLayout cFx;
    private TextView cFy;
    private b cFz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cFz = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_layout, (ViewGroup) null);
        this.cFt = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cFt.setIsRound(false);
        this.cFt.setRadius(0);
        this.cFt.setDrawBorder(true);
        this.cFt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cFt.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cFt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFz != null) {
                    f.this.cFz.a(20, view, null, -1);
                }
            }
        });
        this.cFc = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFz != null) {
                    f.this.cFz.a(19, view, null, -1);
                }
            }
        });
        this.cFc.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cFc.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cFs = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cFz != null) {
                    f.this.cFz.a(21, view, null, -1);
                }
            }
        });
        this.cFu = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cFx = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.ayv = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cFw = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cFv = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cFy = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View aga() {
        return this.mRootView;
    }

    public void eG(boolean z) {
        this.cFw.a(z, this.cFz);
        this.cFv.a(z, this.cFz);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajR() != null) {
            ChannelInfo ajR = dVar.ajR();
            if (!dVar.isHost() && !ajR.isSubscribe()) {
                akf();
            }
            this.cFs.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, ao.y(ajR.getFansCount())));
            this.cFc.startLoad(TextUtils.isEmpty(ajR.getChannelSmallCover()) ? ajR.getChannelCover() : ajR.getChannelSmallCover(), 10, this.cFc.getWidth(), this.cFc.getHeight(), false);
            this.cFt.startLoad(ajR.getChannelAvatar(), 10, this.cFt.getWidth(), this.cFt.getHeight(), false);
            this.cFu.setText(ajR.getChannelName());
            this.cFw.R(dVar);
            this.cFv.R(dVar);
            f(dVar);
        }
    }

    private void akf() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cFA == null) {
                this.cFA = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cFA.inflate();
                this.cFA.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cFA.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cFv.onChangeSkinType(i);
        this.cFt.setBorderColor(al.getColor(d.C0141d.cp_bg_line_a_alpha80));
        al.i(this.ayv, d.f.icon_weiba);
    }

    public int akg() {
        return this.cFx.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cFv.R(dVar);
        this.cFs.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, ao.y(dVar.ajR().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cFc.startLoad(channelInfo.getChannelSmallCover(), 10, this.cFc.getWidth(), this.cFc.getHeight(), false);
            this.cFt.startLoad(channelInfo.getChannelAvatar(), 10, this.cFt.getWidth(), this.cFt.getHeight(), false);
            this.cFu.setText(channelInfo.getChannelName());
            this.cFw.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.ajQ() || dVar.ajR() == null) {
            this.cFy.setVisibility(8);
            return;
        }
        this.cFy.setText(this.mContext.getResources().getString(d.k.channel_home_video_count, Integer.valueOf(dVar.ajR().getVideoCount())));
        this.cFy.setVisibility(0);
    }
}
