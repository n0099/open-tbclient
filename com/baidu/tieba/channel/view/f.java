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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class f {
    private ImageView cea;
    private LinearLayout eLA;
    private TextView eLB;
    private b eLC;
    private ViewStub eLD;
    private TbImageView eLf;
    private TextView eLv;
    private HeadImageView eLw;
    private TextView eLx;
    private ChannelHomeSubOrAddVideoView eLy;
    private ChannelHomeDescView eLz;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eLC = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eLw = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eLw.setIsRound(false);
        this.eLw.setRadius(0);
        this.eLw.setDrawBorder(true);
        this.eLw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eLw.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eLC != null) {
                    f.this.eLC.a(20, view, null, -1);
                }
            }
        });
        this.eLf = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eLC != null) {
                    f.this.eLC.a(19, view, null, -1);
                }
            }
        });
        this.eLf.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eLf.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eLv = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eLv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eLC != null) {
                    f.this.eLC.a(21, view, null, -1);
                }
            }
        });
        this.eLx = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eLA = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cea = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eLz = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eLy = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eLB = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aXx() {
        return this.mRootView;
    }

    public void iQ(boolean z) {
        this.eLz.a(z, this.eLC);
        this.eLy.a(z, this.eLC);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbh() != null) {
            ChannelInfo bbh = dVar.bbh();
            if (!dVar.isHost() && !bbh.isSubscribe()) {
                bbu();
            }
            this.eLv.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(bbh.getFansCount())));
            this.eLf.startLoad(TextUtils.isEmpty(bbh.getChannelSmallCover()) ? bbh.getChannelCover() : bbh.getChannelSmallCover(), 10, this.eLf.getWidth(), this.eLf.getHeight(), false);
            this.eLw.startLoad(bbh.getChannelAvatar(), 10, this.eLw.getWidth(), this.eLw.getHeight(), false);
            this.eLx.setText(bbh.getChannelName());
            this.eLz.ao(dVar);
            this.eLy.ao(dVar);
            f(dVar);
        }
    }

    private void bbu() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eLD == null) {
                this.eLD = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eLD.inflate();
                this.eLD.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eLD.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eLy.onChangeSkinType(i);
        this.eLw.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
        am.k(this.cea, R.drawable.icon_weiba);
    }

    public int bbv() {
        return this.eLA.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eLy.ao(dVar);
        this.eLv.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(dVar.bbh().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eLf.startLoad(channelInfo.getChannelSmallCover(), 10, this.eLf.getWidth(), this.eLf.getHeight(), false);
            this.eLw.startLoad(channelInfo.getChannelAvatar(), 10, this.eLw.getWidth(), this.eLw.getHeight(), false);
            this.eLx.setText(channelInfo.getChannelName());
            this.eLz.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.bbg() || dVar.bbh() == null) {
            this.eLB.setVisibility(8);
            return;
        }
        this.eLB.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.bbh().getVideoCount())));
        this.eLB.setVisibility(0);
    }
}
