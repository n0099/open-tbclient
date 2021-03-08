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
    private View bNL;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private TextView fVC;
    private TbImageView.b fVE;
    private Runnable fVG;
    private TbCyberVideoView.a fVI;
    private TbCyberVideoView gBU;
    private LinearLayout iAg;
    private AudioAnimationView iBA;
    private View iBB;
    private TextView iBC;
    private View iBD;
    private TextView iBE;
    private View.OnClickListener iBF;
    private TextView iBG;
    private Runnable iBH;
    private Runnable iBI;
    private a iBv;
    private TbImageView iBw;
    private TBLottieAnimationView iBx;
    private FrameLayout iBy;
    private Animation iBz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iBw != null) {
                    AlaVideoContainer.this.iBw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iBF != null) {
                            AlaVideoContainer.this.iBF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iBA.start();
                AlaVideoContainer.this.iBy.setVisibility(8);
                AlaVideoContainer.this.iBw.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.iBH, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.iBI);
            }
        };
        this.iBH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNL != null) {
                    AlaVideoContainer.this.bNL.startAnimation(AlaVideoContainer.this.iBz);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.iBI);
                return false;
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.iBI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iBB.setVisibility(0);
                AlaVideoContainer.this.iBy.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fVG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iBw != null) {
                    AlaVideoContainer.this.iBw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iBF != null) {
                            AlaVideoContainer.this.iBF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iBA.start();
                AlaVideoContainer.this.iBy.setVisibility(8);
                AlaVideoContainer.this.iBw.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.iBH, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.iBI);
            }
        };
        this.iBH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNL != null) {
                    AlaVideoContainer.this.bNL.startAnimation(AlaVideoContainer.this.iBz);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.iBI);
                return false;
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.iBI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iBB.setVisibility(0);
                AlaVideoContainer.this.iBy.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fVG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fVE = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iBw != null) {
                    AlaVideoContainer.this.iBw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iBF != null) {
                            AlaVideoContainer.this.iBF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iBA.start();
                AlaVideoContainer.this.iBy.setVisibility(8);
                AlaVideoContainer.this.iBw.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.iBH, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.iBI);
            }
        };
        this.iBH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNL != null) {
                    AlaVideoContainer.this.bNL.startAnimation(AlaVideoContainer.this.iBz);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mA().post(AlaVideoContainer.this.iBI);
                return false;
            }
        };
        this.fVG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRy();
            }
        };
        this.iBI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iBB.setVisibility(0);
                AlaVideoContainer.this.iBy.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fVG, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gBU = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gBU.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gBU.getLayoutParams();
        layoutParams.height = (this.gBU.getWidth() * 9) / 16;
        this.gBU.setLayoutParams(layoutParams);
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        this.gBU.setOnErrorListener(this.eCc);
        this.iBw = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.iBw.setDrawCorner(true);
        this.iBw.setPlaceHolder(3);
        this.iBw.setEvent(this.fVE);
        this.iBw.setGifIconSupport(false);
        TbImageView tbImageView = this.iBw;
        TbImageView tbImageView2 = this.iBw;
        tbImageView.setConrers(15);
        this.iBw.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iBw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBw.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.iBw.setBorderSurroundContent(true);
        this.iBw.setDrawBorder(true);
        this.bNL = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.iBx = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.iBx.loop(true);
        this.iBy = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.iBz = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.iBA = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.iBA.setCertainColumnCount(4);
        this.iBA.setColumnColor(R.color.CAM_X0302);
        this.iBB = inflate.findViewById(R.id.layout_error);
        this.iBC = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.iBD = inflate.findViewById(R.id.layout_live_end);
        this.iBE = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.iAg = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.iBG = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.iBv = new a(this);
        this.fVC = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.iBx, R.raw.ala_play);
            ap.setViewTextColor(this.iBC, R.color.CAM_X0101);
            ap.setBackgroundColor(this.iBB, R.color.black_alpha80);
            ap.setBackgroundColor(this.gBU, R.color.black_alpha100);
            ap.setViewTextColor(this.iBE, R.color.CAM_X0101);
            ap.setBackgroundColor(this.iBD, R.color.black_alpha80);
            ap.setViewTextColor(this.fVC, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.iBv;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fVC != null) {
            this.fVC.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.iBw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.iBw.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.iBG.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.iBG.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.iAg.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public void bRy() {
        this.iBw.setVisibility(0);
        this.iBx.setVisibility(0);
        this.iBy.setVisibility(8);
        if (this.bNL != null) {
            this.bNL.clearAnimation();
        }
        this.iBA.rZ();
        this.iBB.setVisibility(8);
        this.iBD.setVisibility(8);
        e.mA().removeCallbacks(this.iBH);
        e.mA().removeCallbacks(this.fVG);
        e.mA().removeCallbacks(this.iBI);
    }

    public void setVideoStatsData(o oVar) {
        this.gBU.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.iBF = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        csT();
    }

    public void startPlayAnimation() {
        if (this.iBx != null) {
            this.iBx.playAnimation();
        }
    }

    public void csT() {
        if (this.iBx != null) {
            this.iBx.cancelAnimation();
        }
    }
}
