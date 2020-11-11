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
    private View bFb;
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private TextView fFC;
    private TbImageView.a fFE;
    private Runnable fFG;
    private TbCyberVideoView.a fFI;
    private TbCyberVideoView gjd;
    private LinearLayout hZp;
    private a iaA;
    private TbImageView iaB;
    private TBLottieAnimationView iaC;
    private FrameLayout iaD;
    private Animation iaE;
    private AudioAnimationView iaF;
    private View iaG;
    private TextView iaH;
    private View iaI;
    private TextView iaJ;
    private View.OnClickListener iaK;
    private TextView iaL;
    private Runnable iaM;
    private Runnable iaN;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iaB != null) {
                    AlaVideoContainer.this.iaB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iaK != null) {
                            AlaVideoContainer.this.iaK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gjd != null) {
                    AlaVideoContainer.this.gjd.setLooping(true);
                    AlaVideoContainer.this.gjd.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iaF.start();
                AlaVideoContainer.this.iaD.setVisibility(8);
                AlaVideoContainer.this.iaB.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iaM, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.iaN);
            }
        };
        this.iaM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bFb != null) {
                    AlaVideoContainer.this.bFb.startAnimation(AlaVideoContainer.this.iaE);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.iaN);
                return false;
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.iaN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iaG.setVisibility(0);
                AlaVideoContainer.this.iaD.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iaB != null) {
                    AlaVideoContainer.this.iaB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iaK != null) {
                            AlaVideoContainer.this.iaK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gjd != null) {
                    AlaVideoContainer.this.gjd.setLooping(true);
                    AlaVideoContainer.this.gjd.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iaF.start();
                AlaVideoContainer.this.iaD.setVisibility(8);
                AlaVideoContainer.this.iaB.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iaM, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.iaN);
            }
        };
        this.iaM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bFb != null) {
                    AlaVideoContainer.this.bFb.startAnimation(AlaVideoContainer.this.iaE);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.iaN);
                return false;
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.iaN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iaG.setVisibility(0);
                AlaVideoContainer.this.iaD.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fFE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iaB != null) {
                    AlaVideoContainer.this.iaB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iaK != null) {
                            AlaVideoContainer.this.iaK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gjd != null) {
                    AlaVideoContainer.this.gjd.setLooping(true);
                    AlaVideoContainer.this.gjd.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iaF.start();
                AlaVideoContainer.this.iaD.setVisibility(8);
                AlaVideoContainer.this.iaB.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iaM, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.iaN);
            }
        };
        this.iaM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bFb != null) {
                    AlaVideoContainer.this.bFb.startAnimation(AlaVideoContainer.this.iaE);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.iaN);
                return false;
            }
        };
        this.fFG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOR();
            }
        };
        this.iaN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iaG.setVisibility(0);
                AlaVideoContainer.this.iaD.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFG, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gjd = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gjd.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gjd.getLayoutParams();
        layoutParams.height = (this.gjd.getWidth() * 9) / 16;
        this.gjd.setLayoutParams(layoutParams);
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        this.gjd.setOnErrorListener(this.eoh);
        this.iaB = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.iaB.setDefaultErrorResource(0);
        this.iaB.setDrawCorner(true);
        this.iaB.setPlaceHolder(3);
        this.iaB.setEvent(this.fFE);
        this.iaB.setGifIconSupport(false);
        TbImageView tbImageView = this.iaB;
        TbImageView tbImageView2 = this.iaB;
        tbImageView.setConrers(15);
        this.iaB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iaB.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iaB.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.iaB.setBorderSurroundContent(true);
        this.iaB.setDrawBorder(true);
        this.bFb = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.iaC = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.iaC.loop(true);
        this.iaD = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.iaE = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.iaF = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.iaF.setCertainColumnCount(4);
        this.iaF.setColumnColor(R.color.cp_cont_a);
        this.iaG = inflate.findViewById(R.id.layout_error);
        this.iaH = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.iaI = inflate.findViewById(R.id.layout_live_end);
        this.iaJ = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hZp = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.iaL = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.iaA = new a(this);
        this.fFC = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.iaC, R.raw.ala_play);
            ap.setViewTextColor(this.iaH, R.color.cp_cont_a);
            ap.setBackgroundColor(this.iaG, R.color.black_alpha80);
            ap.setBackgroundColor(this.gjd, R.color.black_alpha100);
            ap.setViewTextColor(this.iaJ, R.color.cp_cont_a);
            ap.setBackgroundColor(this.iaI, R.color.black_alpha80);
            ap.setViewTextColor(this.fFC, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.iaA;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fFC != null) {
            this.fFC.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.iaB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.iaB.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.iaL.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.iaL.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hZp.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gjd;
    }

    public void bOR() {
        this.iaB.setVisibility(0);
        this.iaC.setVisibility(0);
        this.iaD.setVisibility(8);
        if (this.bFb != null) {
            this.bFb.clearAnimation();
        }
        this.iaF.sy();
        this.iaG.setVisibility(8);
        this.iaI.setVisibility(8);
        e.mY().removeCallbacks(this.iaM);
        e.mY().removeCallbacks(this.fFG);
        e.mY().removeCallbacks(this.iaN);
    }

    public void setVideoStatsData(o oVar) {
        this.gjd.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.iaK = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        coC();
    }

    public void startPlayAnimation() {
        if (this.iaC != null) {
            this.iaC.playAnimation();
        }
    }

    public void coC() {
        if (this.iaC != null) {
            this.iaC.cancelAnimation();
        }
    }
}
