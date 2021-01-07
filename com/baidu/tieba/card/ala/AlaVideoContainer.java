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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bNn;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private TbCyberVideoView.a fWA;
    private TextView fWu;
    private TbImageView.b fWw;
    private Runnable fWy;
    private TbCyberVideoView gBU;
    private LinearLayout ixi;
    private AudioAnimationView iyA;
    private View iyB;
    private TextView iyC;
    private View iyD;
    private TextView iyE;
    private View.OnClickListener iyF;
    private TextView iyG;
    private Runnable iyH;
    private Runnable iyI;
    private a iyv;
    private TbImageView iyw;
    private TBLottieAnimationView iyx;
    private FrameLayout iyy;
    private Animation iyz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iyw != null) {
                    AlaVideoContainer.this.iyw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iyF != null) {
                            AlaVideoContainer.this.iyF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iyA.start();
                AlaVideoContainer.this.iyy.setVisibility(8);
                AlaVideoContainer.this.iyw.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iyH, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iyI);
            }
        };
        this.iyH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.iyz);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mB().post(AlaVideoContainer.this.iyI);
                return false;
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.iyI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iyB.setVisibility(0);
                AlaVideoContainer.this.iyy.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fWy, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iyw != null) {
                    AlaVideoContainer.this.iyw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iyF != null) {
                            AlaVideoContainer.this.iyF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iyA.start();
                AlaVideoContainer.this.iyy.setVisibility(8);
                AlaVideoContainer.this.iyw.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iyH, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iyI);
            }
        };
        this.iyH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.iyz);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mB().post(AlaVideoContainer.this.iyI);
                return false;
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.iyI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iyB.setVisibility(0);
                AlaVideoContainer.this.iyy.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fWy, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fWw = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.iyw != null) {
                    AlaVideoContainer.this.iyw.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iyF != null) {
                            AlaVideoContainer.this.iyF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gBU != null) {
                    AlaVideoContainer.this.gBU.setLooping(true);
                    AlaVideoContainer.this.gBU.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.iyA.start();
                AlaVideoContainer.this.iyy.setVisibility(8);
                AlaVideoContainer.this.iyw.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iyH, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iyI);
            }
        };
        this.iyH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.iyz);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mB().post(AlaVideoContainer.this.iyI);
                return false;
            }
        };
        this.fWy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUz();
            }
        };
        this.iyI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.iyB.setVisibility(0);
                AlaVideoContainer.this.iyy.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fWy, 2000L);
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
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        this.gBU.setOnErrorListener(this.eDg);
        this.iyw = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.iyw.setDrawCorner(true);
        this.iyw.setPlaceHolder(3);
        this.iyw.setEvent(this.fWw);
        this.iyw.setGifIconSupport(false);
        TbImageView tbImageView = this.iyw;
        TbImageView tbImageView2 = this.iyw;
        tbImageView.setConrers(15);
        this.iyw.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.iyw.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iyw.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.iyw.setBorderSurroundContent(true);
        this.iyw.setDrawBorder(true);
        this.bNn = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.iyx = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.iyx.loop(true);
        this.iyy = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.iyz = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.iyA = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.iyA.setCertainColumnCount(4);
        this.iyA.setColumnColor(R.color.CAM_X0302);
        this.iyB = inflate.findViewById(R.id.layout_error);
        this.iyC = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.iyD = inflate.findViewById(R.id.layout_live_end);
        this.iyE = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.ixi = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.iyG = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.iyv = new a(this);
        this.fWu = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ao.a(this.iyx, R.raw.ala_play);
            ao.setViewTextColor(this.iyC, R.color.CAM_X0101);
            ao.setBackgroundColor(this.iyB, R.color.black_alpha80);
            ao.setBackgroundColor(this.gBU, R.color.black_alpha100);
            ao.setViewTextColor(this.iyE, R.color.CAM_X0101);
            ao.setBackgroundColor(this.iyD, R.color.black_alpha80);
            ao.setViewTextColor(this.fWu, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.iyv;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fWu != null) {
            this.fWu.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.iyw.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.iyw.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.iyG.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.iyG.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ixi.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gBU;
    }

    public void bUz() {
        this.iyw.setVisibility(0);
        this.iyx.setVisibility(0);
        this.iyy.setVisibility(8);
        if (this.bNn != null) {
            this.bNn.clearAnimation();
        }
        this.iyA.sc();
        this.iyB.setVisibility(8);
        this.iyD.setVisibility(8);
        e.mB().removeCallbacks(this.iyH);
        e.mB().removeCallbacks(this.fWy);
        e.mB().removeCallbacks(this.iyI);
    }

    public void setVideoStatsData(o oVar) {
        this.gBU.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.iyF = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cvm();
    }

    public void startPlayAnimation() {
        if (this.iyx != null) {
            this.iyx.playAnimation();
        }
    }

    public void cvm() {
        if (this.iyx != null) {
            this.iyx.cancelAnimation();
        }
    }
}
