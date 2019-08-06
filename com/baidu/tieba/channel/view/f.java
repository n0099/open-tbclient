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
    private ImageView cdh;
    private TextView eJM;
    private HeadImageView eJN;
    private TextView eJO;
    private ChannelHomeSubOrAddVideoView eJP;
    private ChannelHomeDescView eJQ;
    private LinearLayout eJR;
    private TextView eJS;
    private b eJT;
    private ViewStub eJU;
    private TbImageView eJw;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eJT = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eJN = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eJN.setIsRound(false);
        this.eJN.setRadius(0);
        this.eJN.setDrawBorder(true);
        this.eJN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eJN.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJT != null) {
                    f.this.eJT.a(20, view, null, -1);
                }
            }
        });
        this.eJw = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eJw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJT != null) {
                    f.this.eJT.a(19, view, null, -1);
                }
            }
        });
        this.eJw.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eJw.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eJM = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eJM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eJT != null) {
                    f.this.eJT.a(21, view, null, -1);
                }
            }
        });
        this.eJO = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eJR = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cdh = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eJQ = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eJP = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eJS = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aWT() {
        return this.mRootView;
    }

    public void iN(boolean z) {
        this.eJQ.a(z, this.eJT);
        this.eJP.a(z, this.eJT);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baD() != null) {
            ChannelInfo baD = dVar.baD();
            if (!dVar.isHost() && !baD.isSubscribe()) {
                baQ();
            }
            this.eJM.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(baD.getFansCount())));
            this.eJw.startLoad(TextUtils.isEmpty(baD.getChannelSmallCover()) ? baD.getChannelCover() : baD.getChannelSmallCover(), 10, this.eJw.getWidth(), this.eJw.getHeight(), false);
            this.eJN.startLoad(baD.getChannelAvatar(), 10, this.eJN.getWidth(), this.eJN.getHeight(), false);
            this.eJO.setText(baD.getChannelName());
            this.eJQ.ao(dVar);
            this.eJP.ao(dVar);
            f(dVar);
        }
    }

    private void baQ() {
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eJU == null) {
                this.eJU = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eJU.inflate();
                this.eJU.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eJU.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eJP.onChangeSkinType(i);
        this.eJN.setBorderColor(am.getColor(R.color.cp_bg_line_a_alpha80));
        am.k(this.cdh, R.drawable.icon_weiba);
    }

    public int baR() {
        return this.eJR.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eJP.ao(dVar);
        this.eJM.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.aH(dVar.baD().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eJw.startLoad(channelInfo.getChannelSmallCover(), 10, this.eJw.getWidth(), this.eJw.getHeight(), false);
            this.eJN.startLoad(channelInfo.getChannelAvatar(), 10, this.eJN.getWidth(), this.eJN.getHeight(), false);
            this.eJO.setText(channelInfo.getChannelName());
            this.eJQ.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.baC() || dVar.baD() == null) {
            this.eJS.setVisibility(8);
            return;
        }
        this.eJS.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.baD().getVideoCount())));
        this.eJS.setVisibility(0);
    }
}
