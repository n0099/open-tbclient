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
    private TextView cvJ;
    private HeadImageView cvK;
    private TextView cvL;
    private ChannelHomeSubOrAddVideoView cvM;
    private ChannelHomeDescView cvN;
    private LinearLayout cvO;
    private TextView cvP;
    private b cvQ;
    private ViewStub cvR;
    private TbImageView cvt;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cvQ = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_layout, (ViewGroup) null);
        this.cvK = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cvK.setIsRound(false);
        this.cvK.setRadius(0);
        this.cvK.setDrawBorder(true);
        this.cvK.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cvK.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cvK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvQ != null) {
                    f.this.cvQ.a(20, view2, null, -1);
                }
            }
        });
        this.cvt = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cvt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvQ != null) {
                    f.this.cvQ.a(19, view2, null, -1);
                }
            }
        });
        this.cvt.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cvt.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cvJ = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvQ != null) {
                    f.this.cvQ.a(21, view2, null, -1);
                }
            }
        });
        this.cvL = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cvO = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.aqo = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cvN = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cvM = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cvP = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View acD() {
        return this.mRootView;
    }

    public void eB(boolean z) {
        this.cvN.a(z, this.cvQ);
        this.cvM.a(z, this.cvQ);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            ChannelInfo agj = dVar.agj();
            if (!dVar.isHost() && !agj.isSubscribe()) {
                agx();
            }
            this.cvJ.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(agj.getFansCount())));
            this.cvt.startLoad(TextUtils.isEmpty(agj.getChannelSmallCover()) ? agj.getChannelCover() : agj.getChannelSmallCover(), 10, this.cvt.getWidth(), this.cvt.getHeight(), false);
            this.cvK.startLoad(agj.getChannelAvatar(), 10, this.cvK.getWidth(), this.cvK.getHeight(), false);
            this.cvL.setText(agj.getChannelName());
            this.cvN.O(dVar);
            this.cvM.O(dVar);
            f(dVar);
        }
    }

    private void agx() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cvR == null) {
                this.cvR = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cvR.inflate();
                this.cvR.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cvR.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cvM.onChangeSkinType(i);
        this.cvK.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
        ak.i(this.aqo, d.f.icon_weiba);
    }

    public int agy() {
        return this.cvO.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cvM.O(dVar);
        this.cvJ.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(dVar.agj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cvt.startLoad(channelInfo.getChannelSmallCover(), 10, this.cvt.getWidth(), this.cvt.getHeight(), false);
            this.cvK.startLoad(channelInfo.getChannelAvatar(), 10, this.cvK.getWidth(), this.cvK.getHeight(), false);
            this.cvL.setText(channelInfo.getChannelName());
            this.cvN.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.agi() || dVar.agj() == null) {
            this.cvP.setVisibility(8);
            return;
        }
        this.cvP.setText(this.mContext.getResources().getString(d.k.channel_home_video_count, Integer.valueOf(dVar.agj().getVideoCount())));
        this.cvP.setVisibility(0);
    }
}
