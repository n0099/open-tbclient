package com.baidu.tieba.card.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes21.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bwC;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private TbCyberVideoView fTk;
    private TextView fro;
    private TbImageView.a frq;
    private Runnable frt;
    private TbCyberVideoView.a frv;
    private LinearLayout hGV;
    private a hIg;
    private TbImageView hIh;
    private TBLottieAnimationView hIi;
    private FrameLayout hIj;
    private Animation hIk;
    private AudioAnimationView hIl;
    private View hIm;
    private TextView hIn;
    private View hIo;
    private TextView hIp;
    private View.OnClickListener hIq;
    private TextView hIr;
    private Runnable hIs;
    private Runnable hIt;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hIh != null) {
                    AlaVideoContainer.this.hIh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.hIq != null) {
                            AlaVideoContainer.this.hIq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fTk != null) {
                    AlaVideoContainer.this.fTk.setLooping(true);
                    AlaVideoContainer.this.fTk.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hIl.start();
                AlaVideoContainer.this.hIj.setVisibility(8);
                AlaVideoContainer.this.hIh.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hIs, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hIt);
            }
        };
        this.hIs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bwC != null) {
                    AlaVideoContainer.this.bwC.startAnimation(AlaVideoContainer.this.hIk);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.hIt);
                return false;
            }
        };
        this.frt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.hIt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hIm.setVisibility(0);
                AlaVideoContainer.this.hIj.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.frt, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hIh != null) {
                    AlaVideoContainer.this.hIh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.hIq != null) {
                            AlaVideoContainer.this.hIq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fTk != null) {
                    AlaVideoContainer.this.fTk.setLooping(true);
                    AlaVideoContainer.this.fTk.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hIl.start();
                AlaVideoContainer.this.hIj.setVisibility(8);
                AlaVideoContainer.this.hIh.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hIs, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hIt);
            }
        };
        this.hIs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bwC != null) {
                    AlaVideoContainer.this.bwC.startAnimation(AlaVideoContainer.this.hIk);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.hIt);
                return false;
            }
        };
        this.frt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.hIt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hIm.setVisibility(0);
                AlaVideoContainer.this.hIj.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.frt, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.frq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hIh != null) {
                    AlaVideoContainer.this.hIh.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.hIq != null) {
                            AlaVideoContainer.this.hIq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fTk != null) {
                    AlaVideoContainer.this.fTk.setLooping(true);
                    AlaVideoContainer.this.fTk.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hIl.start();
                AlaVideoContainer.this.hIj.setVisibility(8);
                AlaVideoContainer.this.hIh.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hIs, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hIt);
            }
        };
        this.hIs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bwC != null) {
                    AlaVideoContainer.this.bwC.startAnimation(AlaVideoContainer.this.hIk);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.hIt);
                return false;
            }
        };
        this.frt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJP();
            }
        };
        this.hIt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hIm.setVisibility(0);
                AlaVideoContainer.this.hIj.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.frt, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fTk = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.fTk.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.fTk.getLayoutParams();
        layoutParams.height = (this.fTk.getWidth() * 9) / 16;
        this.fTk.setLayoutParams(layoutParams);
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        this.fTk.setOnErrorListener(this.dZQ);
        this.hIh = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.hIh.setDefaultErrorResource(0);
        this.hIh.setDrawCorner(true);
        this.hIh.setPlaceHolder(3);
        this.hIh.setEvent(this.frq);
        this.hIh.setGifIconSupport(false);
        TbImageView tbImageView = this.hIh;
        TbImageView tbImageView2 = this.hIh;
        tbImageView.setConrers(15);
        this.hIh.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.hIh.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hIh.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.hIh.setBorderSurroundContent(true);
        this.hIh.setDrawBorder(true);
        this.bwC = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.hIi = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.hIi.loop(true);
        this.hIj = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.hIk = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.hIl = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.hIl.setCertainColumnCount(4);
        this.hIl.setColumnColor(R.color.cp_cont_a);
        this.hIm = inflate.findViewById(R.id.layout_error);
        this.hIn = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.hIo = inflate.findViewById(R.id.layout_live_end);
        this.hIp = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hGV = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.hIr = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.hIg = new a(this);
        this.fro = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.hIi, R.raw.ala_play);
            ap.setViewTextColor(this.hIn, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hIm, R.color.black_alpha80);
            ap.setBackgroundColor(this.fTk, R.color.black_alpha100);
            ap.setViewTextColor(this.hIp, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hIo, R.color.black_alpha80);
            ap.setViewTextColor(this.fro, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.hIg;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fro != null) {
            this.fro.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.hIh.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hIh.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.hIr.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.hIr.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hGV.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.fTk;
    }

    public void bJP() {
        this.hIh.setVisibility(0);
        this.hIi.setVisibility(0);
        this.hIj.setVisibility(8);
        if (this.bwC != null) {
            this.bwC.clearAnimation();
        }
        this.hIl.sy();
        this.hIm.setVisibility(8);
        this.hIo.setVisibility(8);
        e.mY().removeCallbacks(this.hIs);
        e.mY().removeCallbacks(this.frt);
        e.mY().removeCallbacks(this.hIt);
    }

    public void setVideoStatsData(o oVar) {
        this.fTk.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.hIq = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ciU();
    }

    public void startPlayAnimation() {
        if (this.hIi != null) {
            this.hIi.playAnimation();
        }
    }

    public void ciU() {
        if (this.hIi != null) {
            this.hIi.cancelAnimation();
        }
    }
}
