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
    private View bpC;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private TbCyberVideoView fDL;
    private TextView fcd;
    private TbImageView.a fcf;
    private Runnable fch;
    private TbCyberVideoView.a fcj;
    private LinearLayout hkU;
    private a hmf;
    private TbImageView hmg;
    private TBLottieAnimationView hmh;
    private FrameLayout hmi;
    private Animation hmj;
    private AudioAnimationView hmk;
    private View hml;
    private TextView hmm;
    private View hmn;
    private TextView hmo;
    private View.OnClickListener hmp;
    private TextView hmq;
    private Runnable hmr;
    private Runnable hms;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmg != null) {
                    AlaVideoContainer.this.hmg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmp != null) {
                            AlaVideoContainer.this.hmp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDL != null) {
                    AlaVideoContainer.this.fDL.setLooping(true);
                    AlaVideoContainer.this.fDL.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmk.start();
                AlaVideoContainer.this.hmi.setVisibility(8);
                AlaVideoContainer.this.hmg.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmr, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hms);
            }
        };
        this.hmr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpC != null) {
                    AlaVideoContainer.this.bpC.startAnimation(AlaVideoContainer.this.hmj);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mS().post(AlaVideoContainer.this.hms);
                return false;
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.hms = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hml.setVisibility(0);
                AlaVideoContainer.this.hmi.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fch, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmg != null) {
                    AlaVideoContainer.this.hmg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmp != null) {
                            AlaVideoContainer.this.hmp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDL != null) {
                    AlaVideoContainer.this.fDL.setLooping(true);
                    AlaVideoContainer.this.fDL.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmk.start();
                AlaVideoContainer.this.hmi.setVisibility(8);
                AlaVideoContainer.this.hmg.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmr, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hms);
            }
        };
        this.hmr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpC != null) {
                    AlaVideoContainer.this.bpC.startAnimation(AlaVideoContainer.this.hmj);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mS().post(AlaVideoContainer.this.hms);
                return false;
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.hms = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hml.setVisibility(0);
                AlaVideoContainer.this.hmi.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fch, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hmg != null) {
                    AlaVideoContainer.this.hmg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hmp != null) {
                            AlaVideoContainer.this.hmp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fDL != null) {
                    AlaVideoContainer.this.fDL.setLooping(true);
                    AlaVideoContainer.this.fDL.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hmk.start();
                AlaVideoContainer.this.hmi.setVisibility(8);
                AlaVideoContainer.this.hmg.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.hmr, IMConnection.RETRY_DELAY_TIMES);
                e.mS().removeCallbacks(AlaVideoContainer.this.hms);
            }
        };
        this.hmr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bpC != null) {
                    AlaVideoContainer.this.bpC.startAnimation(AlaVideoContainer.this.hmj);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mS().post(AlaVideoContainer.this.hms);
                return false;
            }
        };
        this.fch = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bFM();
            }
        };
        this.hms = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hml.setVisibility(0);
                AlaVideoContainer.this.hmi.setVisibility(8);
                e.mS().postDelayed(AlaVideoContainer.this.fch, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fDL = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.fDL.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.fDL.getLayoutParams();
        layoutParams.height = (this.fDL.getWidth() * 9) / 16;
        this.fDL.setLayoutParams(layoutParams);
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        this.fDL.setOnErrorListener(this.dLI);
        this.hmg = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.hmg.setDefaultErrorResource(0);
        this.hmg.setDrawCorner(true);
        this.hmg.setPlaceHolder(3);
        this.hmg.setEvent(this.fcf);
        this.hmg.setGifIconSupport(false);
        TbImageView tbImageView = this.hmg;
        TbImageView tbImageView2 = this.hmg;
        tbImageView.setConrers(15);
        this.hmg.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.hmg.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hmg.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.hmg.setBorderSurroundContent(true);
        this.hmg.setDrawBorder(true);
        this.bpC = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.hmh = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.hmh.loop(true);
        this.hmi = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.hmj = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.hmk = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.hmk.setCertainColumnCount(4);
        this.hmk.setColumnColor(R.color.cp_cont_a);
        this.hml = inflate.findViewById(R.id.layout_error);
        this.hmm = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.hmn = inflate.findViewById(R.id.layout_live_end);
        this.hmo = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hkU = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.hmq = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.hmf = new a(this);
        this.fcd = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.hmh, R.raw.ala_play);
            ap.setViewTextColor(this.hmm, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hml, R.color.black_alpha80);
            ap.setBackgroundColor(this.fDL, R.color.black_alpha100);
            ap.setViewTextColor(this.hmo, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hmn, R.color.black_alpha80);
            ap.setViewTextColor(this.fcd, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.hmf;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fcd != null) {
            this.fcd.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.hmg.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hmg.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.hmq.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.hmq.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hkU.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.fDL;
    }

    public void bFM() {
        this.hmg.setVisibility(0);
        this.hmh.setVisibility(0);
        this.hmi.setVisibility(8);
        if (this.bpC != null) {
            this.bpC.clearAnimation();
        }
        this.hmk.st();
        this.hml.setVisibility(8);
        this.hmn.setVisibility(8);
        e.mS().removeCallbacks(this.hmr);
        e.mS().removeCallbacks(this.fch);
        e.mS().removeCallbacks(this.hms);
    }

    public void setVideoStatsData(o oVar) {
        this.fDL.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.hmp = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cci();
    }

    public void startPlayAnimation() {
        if (this.hmh != null) {
            this.hmh.playAnimation();
        }
    }

    public void cci() {
        if (this.hmh != null) {
            this.hmh.cancelAnimation();
        }
    }
}
