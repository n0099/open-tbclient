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
    private ImageView aBY;
    private TextView cLF;
    private HeadImageView cLG;
    private TextView cLH;
    private ChannelHomeSubOrAddVideoView cLI;
    private ChannelHomeDescView cLJ;
    private LinearLayout cLK;
    private TextView cLL;
    private b cLM;
    private ViewStub cLN;
    private TbImageView cLp;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.cLM = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.channel_home_header_layout, (ViewGroup) null);
        this.cLG = (HeadImageView) this.mRootView.findViewById(e.g.channel_home_header_channel_img);
        this.cLG.setIsRound(false);
        this.cLG.setRadius(0);
        this.cLG.setDrawBorder(true);
        this.cLG.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds1));
        this.cLG.setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
        this.cLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cLM != null) {
                    f.this.cLM.a(20, view, null, -1);
                }
            }
        });
        this.cLp = (TbImageView) this.mRootView.findViewById(e.g.channel_home_top_bg);
        this.cLp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cLM != null) {
                    f.this.cLM.a(19, view, null, -1);
                }
            }
        });
        this.cLp.setDefaultErrorResource(e.f.bg_avatar_weiba_head);
        this.cLp.setDefaultBgResource(e.f.bg_avatar_weiba_head);
        this.cLF = (TextView) this.mRootView.findViewById(e.g.channel_home_top_right_textview);
        this.cLF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cLM != null) {
                    f.this.cLM.a(21, view, null, -1);
                }
            }
        });
        this.cLH = (TextView) this.mRootView.findViewById(e.g.channel_home_header_channel_name);
        this.cLK = (LinearLayout) this.mRootView.findViewById(e.g.channel_home_channel_name_layout);
        this.aBY = (ImageView) this.mRootView.findViewById(e.g.channel_home_channel_icon);
        this.cLJ = (ChannelHomeDescView) this.mRootView.findViewById(e.g.channel_home_header_channel_desc);
        this.cLI = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(e.g.channel_home_header_botton_btn);
        this.cLL = (TextView) this.mRootView.findViewById(e.g.channel_home_header_video_count);
    }

    public View aiP() {
        return this.mRootView;
    }

    public void eY(boolean z) {
        this.cLJ.a(z, this.cLM);
        this.cLI.a(z, this.cLM);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.alx() != null) {
            ChannelInfo alx = dVar.alx();
            if (!dVar.isHost() && !alx.isSubscribe()) {
                alK();
            }
            this.cLF.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.E(alx.getFansCount())));
            this.cLp.startLoad(TextUtils.isEmpty(alx.getChannelSmallCover()) ? alx.getChannelCover() : alx.getChannelSmallCover(), 10, this.cLp.getWidth(), this.cLp.getHeight(), false);
            this.cLG.startLoad(alx.getChannelAvatar(), 10, this.cLG.getWidth(), this.cLG.getHeight(), false);
            this.cLH.setText(alx.getChannelName());
            this.cLJ.W(dVar);
            this.cLI.W(dVar);
            f(dVar);
        }
    }

    private void alK() {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("is_channel_tips_have_show", false)) {
            if (this.cLN == null) {
                this.cLN = (ViewStub) this.mRootView.findViewById(e.g.channel_home_header_tips);
                this.cLN.inflate();
                this.cLN.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.cLN.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.cLI.onChangeSkinType(i);
        this.cLG.setBorderColor(al.getColor(e.d.cp_bg_line_a_alpha80));
        al.i(this.aBY, e.f.icon_weiba);
    }

    public int alL() {
        return this.cLK.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.cLI.W(dVar);
        this.cLF.setText(this.mContext.getResources().getString(e.j.channel_subscribe_num, ao.E(dVar.alx().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.cLp.startLoad(channelInfo.getChannelSmallCover(), 10, this.cLp.getWidth(), this.cLp.getHeight(), false);
            this.cLG.startLoad(channelInfo.getChannelAvatar(), 10, this.cLG.getWidth(), this.cLG.getHeight(), false);
            this.cLH.setText(channelInfo.getChannelName());
            this.cLJ.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.alw() || dVar.alx() == null) {
            this.cLL.setVisibility(8);
            return;
        }
        this.cLL.setText(this.mContext.getResources().getString(e.j.channel_home_video_count, Integer.valueOf(dVar.alx().getVideoCount())));
        this.cLL.setVisibility(0);
    }
}
