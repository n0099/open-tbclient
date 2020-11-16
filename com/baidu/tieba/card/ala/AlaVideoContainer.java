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
/* loaded from: classes20.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bDq;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private TextView fFe;
    private TbImageView.a fFg;
    private Runnable fFi;
    private TbCyberVideoView.a fFk;
    private TbCyberVideoView giK;
    private LinearLayout hZP;
    private a ibc;
    private TbImageView ibd;
    private TBLottieAnimationView ibe;
    private FrameLayout ibf;
    private Animation ibg;
    private AudioAnimationView ibh;
    private View ibi;
    private TextView ibj;
    private View ibk;
    private TextView ibl;
    private View.OnClickListener ibm;
    private TextView ibn;
    private Runnable ibo;
    private Runnable ibp;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ibd != null) {
                    AlaVideoContainer.this.ibd.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ibm != null) {
                            AlaVideoContainer.this.ibm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.giK != null) {
                    AlaVideoContainer.this.giK.setLooping(true);
                    AlaVideoContainer.this.giK.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ibh.start();
                AlaVideoContainer.this.ibf.setVisibility(8);
                AlaVideoContainer.this.ibd.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.ibo, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.ibp);
            }
        };
        this.ibo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bDq != null) {
                    AlaVideoContainer.this.bDq.startAnimation(AlaVideoContainer.this.ibg);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.ibp);
                return false;
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.ibp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ibi.setVisibility(0);
                AlaVideoContainer.this.ibf.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFi, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ibd != null) {
                    AlaVideoContainer.this.ibd.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ibm != null) {
                            AlaVideoContainer.this.ibm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.giK != null) {
                    AlaVideoContainer.this.giK.setLooping(true);
                    AlaVideoContainer.this.giK.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ibh.start();
                AlaVideoContainer.this.ibf.setVisibility(8);
                AlaVideoContainer.this.ibd.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.ibo, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.ibp);
            }
        };
        this.ibo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bDq != null) {
                    AlaVideoContainer.this.bDq.startAnimation(AlaVideoContainer.this.ibg);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.ibp);
                return false;
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.ibp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ibi.setVisibility(0);
                AlaVideoContainer.this.ibf.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFi, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fFg = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ibd != null) {
                    AlaVideoContainer.this.ibd.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ibm != null) {
                            AlaVideoContainer.this.ibm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.giK != null) {
                    AlaVideoContainer.this.giK.setLooping(true);
                    AlaVideoContainer.this.giK.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ibh.start();
                AlaVideoContainer.this.ibf.setVisibility(8);
                AlaVideoContainer.this.ibd.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.ibo, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.ibp);
            }
        };
        this.ibo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bDq != null) {
                    AlaVideoContainer.this.bDq.startAnimation(AlaVideoContainer.this.ibg);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.ibp);
                return false;
            }
        };
        this.fFi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bOk();
            }
        };
        this.ibp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ibi.setVisibility(0);
                AlaVideoContainer.this.ibf.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fFi, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.giK = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.giK.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.giK.getLayoutParams();
        layoutParams.height = (this.giK.getWidth() * 9) / 16;
        this.giK.setLayoutParams(layoutParams);
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        this.giK.setOnErrorListener(this.emx);
        this.ibd = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.ibd.setDefaultErrorResource(0);
        this.ibd.setDrawCorner(true);
        this.ibd.setPlaceHolder(3);
        this.ibd.setEvent(this.fFg);
        this.ibd.setGifIconSupport(false);
        TbImageView tbImageView = this.ibd;
        TbImageView tbImageView2 = this.ibd;
        tbImageView.setConrers(15);
        this.ibd.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.ibd.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ibd.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.ibd.setBorderSurroundContent(true);
        this.ibd.setDrawBorder(true);
        this.bDq = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.ibe = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.ibe.loop(true);
        this.ibf = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.ibg = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.ibh = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.ibh.setCertainColumnCount(4);
        this.ibh.setColumnColor(R.color.CAM_X0302);
        this.ibi = inflate.findViewById(R.id.layout_error);
        this.ibj = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.ibk = inflate.findViewById(R.id.layout_live_end);
        this.ibl = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hZP = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.ibn = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.ibc = new a(this);
        this.fFe = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.ibe, R.raw.ala_play);
            ap.setViewTextColor(this.ibj, R.color.CAM_X0101);
            ap.setBackgroundColor(this.ibi, R.color.black_alpha80);
            ap.setBackgroundColor(this.giK, R.color.black_alpha100);
            ap.setViewTextColor(this.ibl, R.color.CAM_X0101);
            ap.setBackgroundColor(this.ibk, R.color.black_alpha80);
            ap.setViewTextColor(this.fFe, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ibc;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fFe != null) {
            this.fFe.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ibd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ibd.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.ibn.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.ibn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hZP.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.giK;
    }

    public void bOk() {
        this.ibd.setVisibility(0);
        this.ibe.setVisibility(0);
        this.ibf.setVisibility(8);
        if (this.bDq != null) {
            this.bDq.clearAnimation();
        }
        this.ibh.sy();
        this.ibi.setVisibility(8);
        this.ibk.setVisibility(8);
        e.mY().removeCallbacks(this.ibo);
        e.mY().removeCallbacks(this.fFi);
        e.mY().removeCallbacks(this.ibp);
    }

    public void setVideoStatsData(o oVar) {
        this.giK.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ibm = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        coe();
    }

    public void startPlayAnimation() {
        if (this.ibe != null) {
            this.ibe.playAnimation();
        }
    }

    public void coe() {
        if (this.ibe != null) {
            this.ibe.cancelAnimation();
        }
    }
}
