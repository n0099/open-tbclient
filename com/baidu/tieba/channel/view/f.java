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
    private ImageView cbW;
    private TextView eEI;
    private HeadImageView eEJ;
    private TextView eEK;
    private ChannelHomeSubOrAddVideoView eEL;
    private ChannelHomeDescView eEM;
    private LinearLayout eEN;
    private TextView eEO;
    private b eEP;
    private ViewStub eEQ;
    private TbImageView eEs;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eEP = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eEJ = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eEJ.setIsRound(false);
        this.eEJ.setRadius(0);
        this.eEJ.setDrawBorder(true);
        this.eEJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eEJ.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEP != null) {
                    f.this.eEP.a(20, view, null, -1);
                }
            }
        });
        this.eEs = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eEs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEP != null) {
                    f.this.eEP.a(19, view, null, -1);
                }
            }
        });
        this.eEs.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eEs.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eEI = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eEP != null) {
                    f.this.eEP.a(21, view, null, -1);
                }
            }
        });
        this.eEK = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eEN = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.cbW = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eEM = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eEL = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eEO = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aUT() {
        return this.mRootView;
    }

    public void iE(boolean z) {
        this.eEM.a(z, this.eEP);
        this.eEL.a(z, this.eEP);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aYz() != null) {
            ChannelInfo aYz = dVar.aYz();
            if (!dVar.isHost() && !aYz.isSubscribe()) {
                aYM();
            }
            this.eEI.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, ap.aG(aYz.getFansCount())));
            this.eEs.startLoad(TextUtils.isEmpty(aYz.getChannelSmallCover()) ? aYz.getChannelCover() : aYz.getChannelSmallCover(), 10, this.eEs.getWidth(), this.eEs.getHeight(), false);
            this.eEJ.startLoad(aYz.getChannelAvatar(), 10, this.eEJ.getWidth(), this.eEJ.getHeight(), false);
            this.eEK.setText(aYz.getChannelName());
            this.eEM.ao(dVar);
            this.eEL.ao(dVar);
            f(dVar);
        }
    }

    private void aYM() {
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eEQ == null) {
                this.eEQ = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eEQ.inflate();
                this.eEQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eEQ.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eEL.onChangeSkinType(i);
        this.eEJ.setBorderColor(al.getColor(R.color.cp_bg_line_a_alpha80));
        al.k(this.cbW, R.drawable.icon_weiba);
    }

    public int aYN() {
        return this.eEN.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eEL.ao(dVar);
        this.eEI.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, ap.aG(dVar.aYz().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eEs.startLoad(channelInfo.getChannelSmallCover(), 10, this.eEs.getWidth(), this.eEs.getHeight(), false);
            this.eEJ.startLoad(channelInfo.getChannelAvatar(), 10, this.eEJ.getWidth(), this.eEJ.getHeight(), false);
            this.eEK.setText(channelInfo.getChannelName());
            this.eEM.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.aYy() || dVar.aYz() == null) {
            this.eEO.setVisibility(8);
            return;
        }
        this.eEO.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.aYz().getVideoCount())));
        this.eEO.setVisibility(0);
    }
}
