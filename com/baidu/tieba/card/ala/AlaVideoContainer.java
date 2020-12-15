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
    private TbCyberVideoView gqV;
    private LinearLayout ikN;
    private a ima;
    private TbImageView imb;
    private TBLottieAnimationView imc;
    private FrameLayout imd;
    private Animation ime;
    private AudioAnimationView imf;
    private View imh;
    private TextView imi;
    private View imj;
    private TextView imk;
    private View.OnClickListener iml;
    private TextView imm;
    private Runnable imn;
    private Runnable imo;
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
                if (z && AlaVideoContainer.this.imb != null) {
                    AlaVideoContainer.this.imb.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iml != null) {
                            AlaVideoContainer.this.iml.onClick(view);
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
                if (AlaVideoContainer.this.gqV != null) {
                    AlaVideoContainer.this.gqV.setLooping(true);
                    AlaVideoContainer.this.gqV.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imf.start();
                AlaVideoContainer.this.imd.setVisibility(8);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.imn, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imo);
            }
        };
        this.imn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.ime);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.imo);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.imo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.imh.setVisibility(0);
                AlaVideoContainer.this.imd.setVisibility(8);
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
                if (z && AlaVideoContainer.this.imb != null) {
                    AlaVideoContainer.this.imb.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iml != null) {
                            AlaVideoContainer.this.iml.onClick(view);
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
                if (AlaVideoContainer.this.gqV != null) {
                    AlaVideoContainer.this.gqV.setLooping(true);
                    AlaVideoContainer.this.gqV.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imf.start();
                AlaVideoContainer.this.imd.setVisibility(8);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.imn, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imo);
            }
        };
        this.imn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.ime);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.imo);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.imo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.imh.setVisibility(0);
                AlaVideoContainer.this.imd.setVisibility(8);
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
                if (z && AlaVideoContainer.this.imb != null) {
                    AlaVideoContainer.this.imb.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.iml != null) {
                            AlaVideoContainer.this.iml.onClick(view);
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
                if (AlaVideoContainer.this.gqV != null) {
                    AlaVideoContainer.this.gqV.setLooping(true);
                    AlaVideoContainer.this.gqV.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.imf.start();
                AlaVideoContainer.this.imd.setVisibility(8);
                AlaVideoContainer.this.imb.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.imn, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.imo);
            }
        };
        this.imn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIy != null) {
                    AlaVideoContainer.this.bIy.startAnimation(AlaVideoContainer.this.ime);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.imo);
                return false;
            }
        };
        this.fMU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRW();
            }
        };
        this.imo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.imh.setVisibility(0);
                AlaVideoContainer.this.imd.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fMU, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gqV = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gqV.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gqV.getLayoutParams();
        layoutParams.height = (this.gqV.getWidth() * 9) / 16;
        this.gqV.setLayoutParams(layoutParams);
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        this.gqV.setOnErrorListener(this.etz);
        this.imb = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.imb.setDefaultErrorResource(0);
        this.imb.setDrawCorner(true);
        this.imb.setPlaceHolder(3);
        this.imb.setEvent(this.fMS);
        this.imb.setGifIconSupport(false);
        TbImageView tbImageView = this.imb;
        TbImageView tbImageView2 = this.imb;
        tbImageView.setConrers(15);
        this.imb.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.imb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.imb.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.imb.setBorderSurroundContent(true);
        this.imb.setDrawBorder(true);
        this.bIy = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.imc = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.imc.loop(true);
        this.imd = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.ime = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.imf = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.imf.setCertainColumnCount(4);
        this.imf.setColumnColor(R.color.CAM_X0302);
        this.imh = inflate.findViewById(R.id.layout_error);
        this.imi = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.imj = inflate.findViewById(R.id.layout_live_end);
        this.imk = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.ikN = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.imm = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.ima = new a(this);
        this.fMQ = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.imc, R.raw.ala_play);
            ap.setViewTextColor(this.imi, R.color.CAM_X0101);
            ap.setBackgroundColor(this.imh, R.color.black_alpha80);
            ap.setBackgroundColor(this.gqV, R.color.black_alpha100);
            ap.setViewTextColor(this.imk, R.color.CAM_X0101);
            ap.setBackgroundColor(this.imj, R.color.black_alpha80);
            ap.setViewTextColor(this.fMQ, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ima;
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
        this.imb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.imb.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.imm.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.imm.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ikN.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gqV;
    }

    public void bRW() {
        this.imb.setVisibility(0);
        this.imc.setVisibility(0);
        this.imd.setVisibility(8);
        if (this.bIy != null) {
            this.bIy.clearAnimation();
        }
        this.imf.sB();
        this.imh.setVisibility(8);
        this.imj.setVisibility(8);
        e.mY().removeCallbacks(this.imn);
        e.mY().removeCallbacks(this.fMU);
        e.mY().removeCallbacks(this.imo);
    }

    public void setVideoStatsData(o oVar) {
        this.gqV.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.iml = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        css();
    }

    public void startPlayAnimation() {
        if (this.imc != null) {
            this.imc.playAnimation();
        }
    }

    public void css() {
        if (this.imc != null) {
            this.imc.cancelAnimation();
        }
    }
}
