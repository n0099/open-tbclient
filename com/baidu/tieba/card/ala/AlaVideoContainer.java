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
/* loaded from: classes15.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bpF;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private TbCyberVideoView fDP;
    private TextView fch;
    private TbImageView.a fcj;
    private Runnable fcl;
    private TbCyberVideoView.a fcn;
    private LinearLayout hkY;
    private a hmj;
    private TbImageView hmk;
    private TBLottieAnimationView hml;
    private FrameLayout hmm;
    private Animation hmn;
    private AudioAnimationView hmo;
    private View hmp;
    private TextView hmq;
    private View hmr;
    private TextView hms;
    private View.OnClickListener hmt;
    private TextView hmu;
    private Runnable hmv;
    private Runnable hmw;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmk != null) {
                    AlaVideoContainer.this.hmk.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmt != null) {
                            AlaVideoContainer.this.hmt.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDP != null) {
                    AlaVideoContainer.this.fDP.setLooping(true);
                    AlaVideoContainer.this.fDP.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmo.start();
                AlaVideoContainer.this.hmm.setVisibility(8);
                AlaVideoContainer.this.hmk.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmv, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hmw);
            }
        };
        this.hmv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpF != null) {
                    AlaVideoContainer.this.bpF.startAnimation(AlaVideoContainer.this.hmn);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mS().post(AlaVideoContainer.this.hmw);
                return false;
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.hmw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hmp.setVisibility(0);
                AlaVideoContainer.this.hmm.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fcl, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmk != null) {
                    AlaVideoContainer.this.hmk.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmt != null) {
                            AlaVideoContainer.this.hmt.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDP != null) {
                    AlaVideoContainer.this.fDP.setLooping(true);
                    AlaVideoContainer.this.fDP.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmo.start();
                AlaVideoContainer.this.hmm.setVisibility(8);
                AlaVideoContainer.this.hmk.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmv, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hmw);
            }
        };
        this.hmv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpF != null) {
                    AlaVideoContainer.this.bpF.startAnimation(AlaVideoContainer.this.hmn);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mS().post(AlaVideoContainer.this.hmw);
                return false;
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.hmw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hmp.setVisibility(0);
                AlaVideoContainer.this.hmm.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fcl, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmk != null) {
                    AlaVideoContainer.this.hmk.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmt != null) {
                            AlaVideoContainer.this.hmt.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDP != null) {
                    AlaVideoContainer.this.fDP.setLooping(true);
                    AlaVideoContainer.this.fDP.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmo.start();
                AlaVideoContainer.this.hmm.setVisibility(8);
                AlaVideoContainer.this.hmk.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmv, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hmw);
            }
        };
        this.hmv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpF != null) {
                    AlaVideoContainer.this.bpF.startAnimation(AlaVideoContainer.this.hmn);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mS().post(AlaVideoContainer.this.hmw);
                return false;
            }
        };
        this.fcl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFN();
            }
        };
        this.hmw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hmp.setVisibility(0);
                AlaVideoContainer.this.hmm.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fcl, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fDP = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.fDP.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.fDP.getLayoutParams();
        layoutParams.height = (this.fDP.getWidth() * 9) / 16;
        this.fDP.setLayoutParams(layoutParams);
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        this.fDP.setOnErrorListener(this.dLM);
        this.hmk = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.hmk.setDefaultErrorResource(0);
        this.hmk.setDrawCorner(true);
        this.hmk.setPlaceHolder(3);
        this.hmk.setEvent(this.fcj);
        this.hmk.setGifIconSupport(false);
        TbImageView tbImageView = this.hmk;
        TbImageView tbImageView2 = this.hmk;
        tbImageView.setConrers(15);
        this.hmk.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.hmk.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hmk.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.hmk.setBorderSurroundContent(true);
        this.hmk.setDrawBorder(true);
        this.bpF = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.hml = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.hml.loop(true);
        this.hmm = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.hmn = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.hmo = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.hmo.setCertainColumnCount(4);
        this.hmo.setColumnColor(R.color.cp_cont_a);
        this.hmp = inflate.findViewById(R.id.layout_error);
        this.hmq = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.hmr = inflate.findViewById(R.id.layout_live_end);
        this.hms = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hkY = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.hmu = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.hmj = new a(this);
        this.fch = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.hml, R.raw.ala_play);
            ap.setViewTextColor(this.hmq, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hmp, R.color.black_alpha80);
            ap.setBackgroundColor(this.fDP, R.color.black_alpha100);
            ap.setViewTextColor(this.hms, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hmr, R.color.black_alpha80);
            ap.setViewTextColor(this.fch, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.hmj;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fch != null) {
            this.fch.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.hmk.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hmk.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.hmu.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.hmu.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hkY.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.fDP;
    }

    public void bFN() {
        this.hmk.setVisibility(0);
        this.hml.setVisibility(0);
        this.hmm.setVisibility(8);
        if (this.bpF != null) {
            this.bpF.clearAnimation();
        }
        this.hmo.st();
        this.hmp.setVisibility(8);
        this.hmr.setVisibility(8);
        e.mS().removeCallbacks(this.hmv);
        e.mS().removeCallbacks(this.fcl);
        e.mS().removeCallbacks(this.hmw);
    }

    public void setVideoStatsData(o oVar) {
        this.fDP.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.hmt = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ccj();
    }

    public void startPlayAnimation() {
        if (this.hml != null) {
            this.hml.playAnimation();
        }
    }

    public void ccj() {
        if (this.hml != null) {
            this.hml.cancelAnimation();
        }
    }
}
