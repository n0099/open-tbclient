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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private ImageView aqo;
    private TextView cwP;
    private HeadImageView cwQ;
    private TextView cwR;
    private ChannelHomeSubOrAddVideoView cwS;
    private ChannelHomeDescView cwT;
    private LinearLayout cwU;
    private TextView cwV;
    private b cwW;
    private ViewStub cwX;
    private TbImageView cwz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cwW = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_layout, (ViewGroup) null);
        this.cwQ = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cwQ.setIsRound(false);
        this.cwQ.setRadius(0);
        this.cwQ.setDrawBorder(true);
        this.cwQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cwQ.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cwW != null) {
                    f.this.cwW.a(20, view2, null, -1);
                }
            }
        });
        this.cwz = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cwW != null) {
                    f.this.cwW.a(19, view2, null, -1);
                }
            }
        });
        this.cwz.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cwz.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cwP = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cwW != null) {
                    f.this.cwW.a(21, view2, null, -1);
                }
            }
        });
        this.cwR = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cwU = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.aqo = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cwT = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cwS = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cwV = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View acD() {
        return this.mRootView;
    }

    public void eC(boolean z) {
        this.cwT.a(z, this.cwW);
        this.cwS.a(z, this.cwW);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            ChannelInfo agj = dVar.agj();
            if (!dVar.isHost() && !agj.isSubscribe()) {
                agx();
            }
            this.cwP.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(agj.getFansCount())));
            this.cwz.startLoad(TextUtils.isEmpty(agj.getChannelSmallCover()) ? agj.getChannelCover() : agj.getChannelSmallCover(), 10, this.cwz.getWidth(), this.cwz.getHeight(), false);
            this.cwQ.startLoad(agj.getChannelAvatar(), 10, this.cwQ.getWidth(), this.cwQ.getHeight(), false);
            this.cwR.setText(agj.getChannelName());
            this.cwT.O(dVar);
            this.cwS.O(dVar);
            f(dVar);
        }
    }

    private void agx() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cwX == null) {
                this.cwX = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cwX.inflate();
                this.cwX.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cwX.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cwS.onChangeSkinType(i);
        this.cwQ.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
        ak.i(this.aqo, d.f.icon_weiba);
    }

    public int agy() {
        return this.cwU.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cwS.O(dVar);
        this.cwP.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(dVar.agj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cwz.startLoad(channelInfo.getChannelSmallCover(), 10, this.cwz.getWidth(), this.cwz.getHeight(), false);
            this.cwQ.startLoad(channelInfo.getChannelAvatar(), 10, this.cwQ.getWidth(), this.cwQ.getHeight(), false);
            this.cwR.setText(channelInfo.getChannelName());
            this.cwT.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.agi() || dVar.agj() == null) {
            this.cwV.setVisibility(8);
            return;
        }
        this.cwV.setText(this.mContext.getResources().getString(d.k.channel_home_video_count, Integer.valueOf(dVar.agj().getVideoCount())));
        this.cwV.setVisibility(0);
    }
}
