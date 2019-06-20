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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.data.ChannelInfo;
/* loaded from: classes6.dex */
public class f {
    private ImageView cbX;
    private TextView eEJ;
    private HeadImageView eEK;
    private TextView eEL;
    private ChannelHomeSubOrAddVideoView eEM;
    private ChannelHomeDescView eEN;
    private LinearLayout eEO;
    private TextView eEP;
    private b eEQ;
    private ViewStub eER;
    private TbImageView eEt;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eEQ = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eEK = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eEK.setIsRound(false);
        this.eEK.setRadius(0);
        this.eEK.setDrawBorder(true);
        this.eEK.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eEK.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEQ != null) {
                    f.this.eEQ.a(20, view, null, -1);
                }
            }
        });
        this.eEt = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eEt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEQ != null) {
                    f.this.eEQ.a(19, view, null, -1);
                }
            }
        });
        this.eEt.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eEt.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eEJ = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEQ != null) {
                    f.this.eEQ.a(21, view, null, -1);
                }
            }
        });
        this.eEL = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eEO = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cbX = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eEN = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eEM = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eEP = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aUW() {
        return this.mRootView;
    }

    public void iE(boolean z) {
        this.eEN.a(z, this.eEQ);
        this.eEM.a(z, this.eEQ);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aYC() != null) {
            ChannelInfo aYC = dVar.aYC();
            if (!dVar.isHost() && !aYC.isSubscribe()) {
                aYP();
            }
            this.eEJ.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, ap.aG(aYC.getFansCount())));
            this.eEt.startLoad(TextUtils.isEmpty(aYC.getChannelSmallCover()) ? aYC.getChannelCover() : aYC.getChannelSmallCover(), 10, this.eEt.getWidth(), this.eEt.getHeight(), false);
            this.eEK.startLoad(aYC.getChannelAvatar(), 10, this.eEK.getWidth(), this.eEK.getHeight(), false);
            this.eEL.setText(aYC.getChannelName());
            this.eEN.ao(dVar);
            this.eEM.ao(dVar);
            f(dVar);
        }
    }

    private void aYP() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eER == null) {
                this.eER = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eER.inflate();
                this.eER.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eER.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eEM.onChangeSkinType(i);
        this.eEK.setBorderColor(al.getColor(R.color.cp_bg_line_a_alpha80));
        al.k(this.cbX, R.drawable.icon_weiba);
    }

    public int aYQ() {
        return this.eEO.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eEM.ao(dVar);
        this.eEJ.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, ap.aG(dVar.aYC().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eEt.startLoad(channelInfo.getChannelSmallCover(), 10, this.eEt.getWidth(), this.eEt.getHeight(), false);
            this.eEK.startLoad(channelInfo.getChannelAvatar(), 10, this.eEK.getWidth(), this.eEK.getHeight(), false);
            this.eEL.setText(channelInfo.getChannelName());
            this.eEN.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aYB() || dVar.aYC() == null) {
            this.eEP.setVisibility(8);
            return;
        }
        this.eEP.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.aYC().getVideoCount())));
        this.eEP.setVisibility(0);
    }
}
