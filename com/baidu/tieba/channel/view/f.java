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
    private ImageView cda;
    private TextView eJF;
    private HeadImageView eJG;
    private TextView eJH;
    private ChannelHomeSubOrAddVideoView eJI;
    private ChannelHomeDescView eJJ;
    private LinearLayout eJK;
    private TextView eJL;
    private b eJM;
    private ViewStub eJN;
    private TbImageView eJp;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eJM = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eJG = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eJG.setIsRound(false);
        this.eJG.setRadius(0);
        this.eJG.setDrawBorder(true);
        this.eJG.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eJG.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJM != null) {
                    f.this.eJM.a(20, view, null, -1);
                }
            }
        });
        this.eJp = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJM != null) {
                    f.this.eJM.a(19, view, null, -1);
                }
            }
        });
        this.eJp.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eJp.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eJF = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJM != null) {
                    f.this.eJM.a(21, view, null, -1);
                }
            }
        });
        this.eJH = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eJK = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cda = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eJJ = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eJI = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eJL = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aWR() {
        return this.mRootView;
    }

    public void iN(boolean z) {
        this.eJJ.a(z, this.eJM);
        this.eJI.a(z, this.eJM);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baB() != null) {
            ChannelInfo baB = dVar.baB();
            if (!dVar.isHost() && !baB.isSubscribe()) {
                baO();
            }
            this.eJF.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(baB.getFansCount())));
            this.eJp.startLoad(TextUtils.isEmpty(baB.getChannelSmallCover()) ? baB.getChannelCover() : baB.getChannelSmallCover(), 10, this.eJp.getWidth(), this.eJp.getHeight(), false);
            this.eJG.startLoad(baB.getChannelAvatar(), 10, this.eJG.getWidth(), this.eJG.getHeight(), false);
            this.eJH.setText(baB.getChannelName());
            this.eJJ.ao(dVar);
            this.eJI.ao(dVar);
            f(dVar);
        }
    }

    private void baO() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eJN == null) {
                this.eJN = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eJN.inflate();
                this.eJN.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eJN.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eJI.onChangeSkinType(i);
        this.eJG.setBorderColor(am.getColor(R.color.cp_bg_line_a_alpha80));
        am.k(this.cda, R.drawable.icon_weiba);
    }

    public int baP() {
        return this.eJK.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eJI.ao(dVar);
        this.eJF.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(dVar.baB().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eJp.startLoad(channelInfo.getChannelSmallCover(), 10, this.eJp.getWidth(), this.eJp.getHeight(), false);
            this.eJG.startLoad(channelInfo.getChannelAvatar(), 10, this.eJG.getWidth(), this.eJG.getHeight(), false);
            this.eJH.setText(channelInfo.getChannelName());
            this.eJJ.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.baA() || dVar.baB() == null) {
            this.eJL.setVisibility(8);
            return;
        }
        this.eJL.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.baB().getVideoCount())));
        this.eJL.setVisibility(0);
    }
}
