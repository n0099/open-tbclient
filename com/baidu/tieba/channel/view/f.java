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
    private TextView cvG;
    private HeadImageView cvH;
    private TextView cvI;
    private ChannelHomeSubOrAddVideoView cvJ;
    private ChannelHomeDescView cvK;
    private LinearLayout cvL;
    private TextView cvM;
    private b cvN;
    private ViewStub cvO;
    private TbImageView cvq;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cvN = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.channel_home_header_layout, (ViewGroup) null);
        this.cvH = (HeadImageView) this.mRootView.findViewById(d.g.channel_home_header_channel_img);
        this.cvH.setIsRound(false);
        this.cvH.setRadius(0);
        this.cvH.setDrawBorder(true);
        this.cvH.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds1));
        this.cvH.setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
        this.cvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvN != null) {
                    f.this.cvN.a(20, view2, null, -1);
                }
            }
        });
        this.cvq = (TbImageView) this.mRootView.findViewById(d.g.channel_home_top_bg);
        this.cvq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvN != null) {
                    f.this.cvN.a(19, view2, null, -1);
                }
            }
        });
        this.cvq.setDefaultErrorResource(d.f.bg_avatar_weiba_head);
        this.cvq.setDefaultBgResource(d.f.bg_avatar_weiba_head);
        this.cvG = (TextView) this.mRootView.findViewById(d.g.channel_home_top_right_textview);
        this.cvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.cvN != null) {
                    f.this.cvN.a(21, view2, null, -1);
                }
            }
        });
        this.cvI = (TextView) this.mRootView.findViewById(d.g.channel_home_header_channel_name);
        this.cvL = (LinearLayout) this.mRootView.findViewById(d.g.channel_home_channel_name_layout);
        this.aqo = (ImageView) this.mRootView.findViewById(d.g.channel_home_channel_icon);
        this.cvK = (ChannelHomeDescView) this.mRootView.findViewById(d.g.channel_home_header_channel_desc);
        this.cvJ = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(d.g.channel_home_header_botton_btn);
        this.cvM = (TextView) this.mRootView.findViewById(d.g.channel_home_header_video_count);
    }

    public View acD() {
        return this.mRootView;
    }

    public void eB(boolean z) {
        this.cvK.a(z, this.cvN);
        this.cvJ.a(z, this.cvN);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            ChannelInfo agj = dVar.agj();
            if (!dVar.isHost() && !agj.isSubscribe()) {
                agx();
            }
            this.cvG.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(agj.getFansCount())));
            this.cvq.startLoad(TextUtils.isEmpty(agj.getChannelSmallCover()) ? agj.getChannelCover() : agj.getChannelSmallCover(), 10, this.cvq.getWidth(), this.cvq.getHeight(), false);
            this.cvH.startLoad(agj.getChannelAvatar(), 10, this.cvH.getWidth(), this.cvH.getHeight(), false);
            this.cvI.setText(agj.getChannelName());
            this.cvK.O(dVar);
            this.cvJ.O(dVar);
            f(dVar);
        }
    }

    private void agx() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cvO == null) {
                this.cvO = (ViewStub) this.mRootView.findViewById(d.g.channel_home_header_tips);
                this.cvO.inflate();
                this.cvO.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cvO.setVisibility(8);
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cvJ.onChangeSkinType(i);
        this.cvH.setBorderColor(ak.getColor(d.C0126d.cp_bg_line_a_alpha80));
        ak.i(this.aqo, d.f.icon_weiba);
    }

    public int agy() {
        return this.cvL.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cvJ.O(dVar);
        this.cvG.setText(this.mContext.getResources().getString(d.k.channel_subscribe_num, an.v(dVar.agj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cvq.startLoad(channelInfo.getChannelSmallCover(), 10, this.cvq.getWidth(), this.cvq.getHeight(), false);
            this.cvH.startLoad(channelInfo.getChannelAvatar(), 10, this.cvH.getWidth(), this.cvH.getHeight(), false);
            this.cvI.setText(channelInfo.getChannelName());
            this.cvK.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.agi() || dVar.agj() == null) {
            this.cvM.setVisibility(8);
            return;
        }
        this.cvM.setText(this.mContext.getResources().getString(d.k.channel_home_video_count, Integer.valueOf(dVar.agj().getVideoCount())));
        this.cvM.setVisibility(0);
    }
}
