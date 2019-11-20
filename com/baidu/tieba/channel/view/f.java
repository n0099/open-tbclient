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
    private ImageView crx;
    private TbImageView eSU;
    private TextView eTk;
    private HeadImageView eTl;
    private TextView eTm;
    private ChannelHomeSubOrAddVideoView eTn;
    private ChannelHomeDescView eTo;
    private LinearLayout eTp;
    private TextView eTq;
    private b eTr;
    private ViewStub eTs;
    private Context mContext;
    private View mRootView;

    public f(Context context, b bVar) {
        this.mContext = context;
        this.eTr = bVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.channel_home_header_layout, (ViewGroup) null);
        this.eTl = (HeadImageView) this.mRootView.findViewById(R.id.channel_home_header_channel_img);
        this.eTl.setIsRound(false);
        this.eTl.setRadius(0);
        this.eTl.setDrawBorder(true);
        this.eTl.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1));
        this.eTl.setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
        this.eTl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eTr != null) {
                    f.this.eTr.a(20, view, null, -1);
                }
            }
        });
        this.eSU = (TbImageView) this.mRootView.findViewById(R.id.channel_home_top_bg);
        this.eSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eTr != null) {
                    f.this.eTr.a(19, view, null, -1);
                }
            }
        });
        this.eSU.setDefaultErrorResource(R.drawable.bg_avatar_weiba_head);
        this.eSU.setDefaultBgResource(R.drawable.bg_avatar_weiba_head);
        this.eTk = (TextView) this.mRootView.findViewById(R.id.channel_home_top_right_textview);
        this.eTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eTr != null) {
                    f.this.eTr.a(21, view, null, -1);
                }
            }
        });
        this.eTm = (TextView) this.mRootView.findViewById(R.id.channel_home_header_channel_name);
        this.eTp = (LinearLayout) this.mRootView.findViewById(R.id.channel_home_channel_name_layout);
        this.crx = (ImageView) this.mRootView.findViewById(R.id.channel_home_channel_icon);
        this.eTo = (ChannelHomeDescView) this.mRootView.findViewById(R.id.channel_home_header_channel_desc);
        this.eTn = (ChannelHomeSubOrAddVideoView) this.mRootView.findViewById(R.id.channel_home_header_botton_btn);
        this.eTq = (TextView) this.mRootView.findViewById(R.id.channel_home_header_video_count);
    }

    public View aMv() {
        return this.mRootView;
    }

    public void iT(boolean z) {
        this.eTo.a(z, this.eTr);
        this.eTn.a(z, this.eTr);
    }

    public void d(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbj() != null) {
            ChannelInfo bbj = dVar.bbj();
            if (!dVar.isHost() && !bbj.isSubscribe()) {
                bbx();
            }
            this.eTk.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.numberUniformFormat(bbj.getFansCount())));
            this.eSU.a(TextUtils.isEmpty(bbj.getChannelSmallCover()) ? bbj.getChannelCover() : bbj.getChannelSmallCover(), 10, this.eSU.getWidth(), this.eSU.getHeight(), false);
            this.eTl.a(bbj.getChannelAvatar(), 10, this.eTl.getWidth(), this.eTl.getHeight(), false);
            this.eTm.setText(bbj.getChannelName());
            this.eTo.al(dVar);
            this.eTn.al(dVar);
            f(dVar);
        }
    }

    private void bbx() {
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("is_channel_tips_have_show", false)) {
            if (this.eTs == null) {
                this.eTs = (ViewStub) this.mRootView.findViewById(R.id.channel_home_header_tips);
                this.eTs.inflate();
                this.eTs.postDelayed(new Runnable() { // from class: com.baidu.tieba.channel.view.f.4
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.eTs.setVisibility(8);
                    }
                }, 5000L);
            }
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("is_channel_tips_have_show", true);
        }
    }

    public void onChangeSkinType(int i) {
        this.eTn.onChangeSkinType(i);
        this.eTl.setBorderColor(am.getColor(R.color.cp_bg_line_c_alpha80));
        am.setBackgroundResource(this.crx, R.drawable.icon_weiba);
    }

    public int bby() {
        return this.eTp.getBottom();
    }

    public void e(com.baidu.tieba.channel.data.d dVar) {
        this.eTn.al(dVar);
        this.eTk.setText(this.mContext.getResources().getString(R.string.channel_subscribe_num, aq.numberUniformFormat(dVar.bbj().getFansCount())));
    }

    public void e(ChannelInfo channelInfo) {
        if (channelInfo != null) {
            this.eSU.a(channelInfo.getChannelSmallCover(), 10, this.eSU.getWidth(), this.eSU.getHeight(), false);
            this.eTl.a(channelInfo.getChannelAvatar(), 10, this.eTl.getWidth(), this.eTl.getHeight(), false);
            this.eTm.setText(channelInfo.getChannelName());
            this.eTo.d(channelInfo);
        }
    }

    public void f(com.baidu.tieba.channel.data.d dVar) {
        if (dVar == null || dVar.bbi() || dVar.bbj() == null) {
            this.eTq.setVisibility(8);
            return;
        }
        this.eTq.setText(this.mContext.getResources().getString(R.string.channel_home_video_count, Integer.valueOf(dVar.bbj().getVideoCount())));
        this.eTq.setVisibility(0);
    }
}
