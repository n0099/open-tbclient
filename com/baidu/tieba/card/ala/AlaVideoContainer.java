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
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bMl;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private TextView fUc;
    private TbImageView.b fUe;
    private Runnable fUg;
    private TbCyberVideoView.a fUi;
    private TbCyberVideoView gzX;
    private LinearLayout iyj;
    private TBLottieAnimationView izA;
    private FrameLayout izB;
    private Animation izC;
    private AudioAnimationView izD;
    private View izE;
    private TextView izF;
    private View izG;
    private TextView izH;
    private View.OnClickListener izI;
    private TextView izJ;
    private Runnable izK;
    private Runnable izL;
    private a izy;
    private TbImageView izz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.izz != null) {
                    AlaVideoContainer.this.izz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.izI != null) {
                            AlaVideoContainer.this.izI.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gzX != null) {
                    AlaVideoContainer.this.gzX.setLooping(true);
                    AlaVideoContainer.this.gzX.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izD.start();
                AlaVideoContainer.this.izB.setVisibility(8);
                AlaVideoContainer.this.izz.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izK, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izL);
            }
        };
        this.izK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izC);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.izL);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.izL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izE.setVisibility(0);
                AlaVideoContainer.this.izB.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fUg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.izz != null) {
                    AlaVideoContainer.this.izz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.izI != null) {
                            AlaVideoContainer.this.izI.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gzX != null) {
                    AlaVideoContainer.this.gzX.setLooping(true);
                    AlaVideoContainer.this.gzX.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izD.start();
                AlaVideoContainer.this.izB.setVisibility(8);
                AlaVideoContainer.this.izz.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izK, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izL);
            }
        };
        this.izK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izC);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.izL);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.izL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izE.setVisibility(0);
                AlaVideoContainer.this.izB.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fUg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fUe = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.izz != null) {
                    AlaVideoContainer.this.izz.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.izI != null) {
                            AlaVideoContainer.this.izI.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gzX != null) {
                    AlaVideoContainer.this.gzX.setLooping(true);
                    AlaVideoContainer.this.gzX.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izD.start();
                AlaVideoContainer.this.izB.setVisibility(8);
                AlaVideoContainer.this.izz.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izK, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izL);
            }
        };
        this.izK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izC);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mA().post(AlaVideoContainer.this.izL);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRl();
            }
        };
        this.izL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izE.setVisibility(0);
                AlaVideoContainer.this.izB.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fUg, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gzX = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gzX.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gzX.getLayoutParams();
        layoutParams.height = (this.gzX.getWidth() * 9) / 16;
        this.gzX.setLayoutParams(layoutParams);
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        this.gzX.setOnErrorListener(this.eAB);
        this.izz = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.izz.setDrawCorner(true);
        this.izz.setPlaceHolder(3);
        this.izz.setEvent(this.fUe);
        this.izz.setGifIconSupport(false);
        TbImageView tbImageView = this.izz;
        TbImageView tbImageView2 = this.izz;
        tbImageView.setConrers(15);
        this.izz.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.izz.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.izz.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.izz.setBorderSurroundContent(true);
        this.izz.setDrawBorder(true);
        this.bMl = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.izA = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.izA.loop(true);
        this.izB = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.izC = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.izD = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.izD.setCertainColumnCount(4);
        this.izD.setColumnColor(R.color.CAM_X0302);
        this.izE = inflate.findViewById(R.id.layout_error);
        this.izF = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.izG = inflate.findViewById(R.id.layout_live_end);
        this.izH = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.iyj = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.izJ = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.izy = new a(this);
        this.fUc = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.izA, R.raw.ala_play);
            ap.setViewTextColor(this.izF, R.color.CAM_X0101);
            ap.setBackgroundColor(this.izE, R.color.black_alpha80);
            ap.setBackgroundColor(this.gzX, R.color.black_alpha100);
            ap.setViewTextColor(this.izH, R.color.CAM_X0101);
            ap.setBackgroundColor(this.izG, R.color.black_alpha80);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.izy;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fUc != null) {
            this.fUc.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.izz.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.izz.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.izJ.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.izJ.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.iyj.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gzX;
    }

    public void bRl() {
        this.izz.setVisibility(0);
        this.izA.setVisibility(0);
        this.izB.setVisibility(8);
        if (this.bMl != null) {
            this.bMl.clearAnimation();
        }
        this.izD.rZ();
        this.izE.setVisibility(8);
        this.izG.setVisibility(8);
        e.mA().removeCallbacks(this.izK);
        e.mA().removeCallbacks(this.fUg);
        e.mA().removeCallbacks(this.izL);
    }

    public void setVideoStatsData(o oVar) {
        this.gzX.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.izI = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        csG();
    }

    public void startPlayAnimation() {
        if (this.izA != null) {
            this.izA.playAnimation();
        }
    }

    public void csG() {
        if (this.izA != null) {
            this.izA.cancelAnimation();
        }
    }
}
