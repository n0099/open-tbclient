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
    private View bIy;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    private TextView fMQ;
    private TbImageView.a fMS;
    private Runnable fMU;
    private TbCyberVideoView.a fMW;
    private TbCyberVideoView gqT;
    private LinearLayout ikL;
    private a ilY;
    private TbImageView ilZ;
    private TBLottieAnimationView ima;
    private FrameLayout imb;
    private Animation imc;
    private AudioAnimationView imd;
    private View ime;
    private TextView imf;
    private View imh;
    private TextView imi;
    private View.OnClickListener imj;
    private TextView imk;
    private Runnable iml;
    private Runnable imm;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ilZ != null) {
                    AlaVideoContainer.this.ilZ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.imj != null) {
                            AlaVideoContainer.this.imj.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gqT != null) {
                    AlaVideoContainer.this.gqT.setLooping(true);
                    AlaVideoContainer.this.gqT.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imd.start();
                AlaVideoContainer.this.imb.setVisibility(8);
                AlaVideoContainer.this.ilZ.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iml, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imm);
            }
        };
        this.iml = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.imc);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.imm);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.imm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ime.setVisibility(0);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fMU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ilZ != null) {
                    AlaVideoContainer.this.ilZ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.imj != null) {
                            AlaVideoContainer.this.imj.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gqT != null) {
                    AlaVideoContainer.this.gqT.setLooping(true);
                    AlaVideoContainer.this.gqT.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imd.start();
                AlaVideoContainer.this.imb.setVisibility(8);
                AlaVideoContainer.this.ilZ.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iml, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imm);
            }
        };
        this.iml = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.imc);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.imm);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.imm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ime.setVisibility(0);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fMU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fMS = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ilZ != null) {
                    AlaVideoContainer.this.ilZ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.imj != null) {
                            AlaVideoContainer.this.imj.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gqT != null) {
                    AlaVideoContainer.this.gqT.setLooping(true);
                    AlaVideoContainer.this.gqT.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imd.start();
                AlaVideoContainer.this.imb.setVisibility(8);
                AlaVideoContainer.this.ilZ.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.iml, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imm);
            }
        };
        this.iml = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.imc);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.imm);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRV();
            }
        };
        this.imm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ime.setVisibility(0);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fMU, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gqT = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gqT.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gqT.getLayoutParams();
        layoutParams.height = (this.gqT.getWidth() * 9) / 16;
        this.gqT.setLayoutParams(layoutParams);
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        this.gqT.setOnErrorListener(this.etz);
        this.ilZ = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.ilZ.setDefaultErrorResource(0);
        this.ilZ.setDrawCorner(true);
        this.ilZ.setPlaceHolder(3);
        this.ilZ.setEvent(this.fMS);
        this.ilZ.setGifIconSupport(false);
        TbImageView tbImageView = this.ilZ;
        TbImageView tbImageView2 = this.ilZ;
        tbImageView.setConrers(15);
        this.ilZ.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ilZ.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ilZ.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.ilZ.setBorderSurroundContent(true);
        this.ilZ.setDrawBorder(true);
        this.bIy = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.ima = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.ima.loop(true);
        this.imb = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.imc = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.imd = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.imd.setCertainColumnCount(4);
        this.imd.setColumnColor(R.color.CAM_X0302);
        this.ime = inflate.findViewById(R.id.layout_error);
        this.imf = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.imh = inflate.findViewById(R.id.layout_live_end);
        this.imi = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.ikL = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.imk = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.ilY = new a(this);
        this.fMQ = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.ima, R.raw.ala_play);
            ap.setViewTextColor(this.imf, R.color.CAM_X0101);
            ap.setBackgroundColor(this.ime, R.color.black_alpha80);
            ap.setBackgroundColor(this.gqT, R.color.black_alpha100);
            ap.setViewTextColor(this.imi, R.color.CAM_X0101);
            ap.setBackgroundColor(this.imh, R.color.black_alpha80);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ilY;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fMQ != null) {
            this.fMQ.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ilZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ilZ.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.imk.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.imk.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ikL.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gqT;
    }

    public void bRV() {
        this.ilZ.setVisibility(0);
        this.ima.setVisibility(0);
        this.imb.setVisibility(8);
        if (this.bIy != null) {
            this.bIy.clearAnimation();
        }
        this.imd.sB();
        this.ime.setVisibility(8);
        this.imh.setVisibility(8);
        e.mY().removeCallbacks(this.iml);
        e.mY().removeCallbacks(this.fMU);
        e.mY().removeCallbacks(this.imm);
    }

    public void setVideoStatsData(o oVar) {
        this.gqT.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.imj = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        csr();
    }

    public void startPlayAnimation() {
        if (this.ima != null) {
            this.ima.playAnimation();
        }
    }

    public void csr() {
        if (this.ima != null) {
            this.ima.cancelAnimation();
        }
    }
}
