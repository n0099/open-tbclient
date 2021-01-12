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
    private View bIB;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private TextView fRN;
    private TbImageView.b fRP;
    private Runnable fRR;
    private TbCyberVideoView.a fRT;
    private TbCyberVideoView gxn;
    private LinearLayout isB;
    private a itO;
    private TbImageView itP;
    private TBLottieAnimationView itQ;
    private FrameLayout itR;
    private Animation itS;
    private AudioAnimationView itT;
    private View itU;
    private TextView itV;
    private View itW;
    private TextView itX;
    private View.OnClickListener itY;
    private TextView itZ;
    private Runnable iua;
    private Runnable iub;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.itP != null) {
                    AlaVideoContainer.this.itP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.itY != null) {
                            AlaVideoContainer.this.itY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gxn != null) {
                    AlaVideoContainer.this.gxn.setLooping(true);
                    AlaVideoContainer.this.gxn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.itT.start();
                AlaVideoContainer.this.itR.setVisibility(8);
                AlaVideoContainer.this.itP.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iua, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iub);
            }
        };
        this.iua = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIB != null) {
                    AlaVideoContainer.this.bIB.startAnimation(AlaVideoContainer.this.itS);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mB().post(AlaVideoContainer.this.iub);
                return false;
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.iub = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.itU.setVisibility(0);
                AlaVideoContainer.this.itR.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fRR, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.itP != null) {
                    AlaVideoContainer.this.itP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.itY != null) {
                            AlaVideoContainer.this.itY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gxn != null) {
                    AlaVideoContainer.this.gxn.setLooping(true);
                    AlaVideoContainer.this.gxn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.itT.start();
                AlaVideoContainer.this.itR.setVisibility(8);
                AlaVideoContainer.this.itP.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iua, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iub);
            }
        };
        this.iua = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIB != null) {
                    AlaVideoContainer.this.bIB.startAnimation(AlaVideoContainer.this.itS);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mB().post(AlaVideoContainer.this.iub);
                return false;
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.iub = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.itU.setVisibility(0);
                AlaVideoContainer.this.itR.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fRR, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fRP = new TbImageView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.itP != null) {
                    AlaVideoContainer.this.itP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.itY != null) {
                            AlaVideoContainer.this.itY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gxn != null) {
                    AlaVideoContainer.this.gxn.setLooping(true);
                    AlaVideoContainer.this.gxn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.itT.start();
                AlaVideoContainer.this.itR.setVisibility(8);
                AlaVideoContainer.this.itP.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.iua, IMConnection.RETRY_DELAY_TIMES);
                e.mB().removeCallbacks(AlaVideoContainer.this.iub);
            }
        };
        this.iua = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIB != null) {
                    AlaVideoContainer.this.bIB.startAnimation(AlaVideoContainer.this.itS);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mB().post(AlaVideoContainer.this.iub);
                return false;
            }
        };
        this.fRR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bQH();
            }
        };
        this.iub = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.itU.setVisibility(0);
                AlaVideoContainer.this.itR.setVisibility(8);
                e.mB().postDelayed(AlaVideoContainer.this.fRR, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gxn = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gxn.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gxn.getLayoutParams();
        layoutParams.height = (this.gxn.getWidth() * 9) / 16;
        this.gxn.setLayoutParams(layoutParams);
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        this.gxn.setOnErrorListener(this.eyu);
        this.itP = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.itP.setDrawCorner(true);
        this.itP.setPlaceHolder(3);
        this.itP.setEvent(this.fRP);
        this.itP.setGifIconSupport(false);
        TbImageView tbImageView = this.itP;
        TbImageView tbImageView2 = this.itP;
        tbImageView.setConrers(15);
        this.itP.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.itP.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.itP.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.itP.setBorderSurroundContent(true);
        this.itP.setDrawBorder(true);
        this.bIB = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.itQ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.itQ.loop(true);
        this.itR = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.itS = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.itT = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.itT.setCertainColumnCount(4);
        this.itT.setColumnColor(R.color.CAM_X0302);
        this.itU = inflate.findViewById(R.id.layout_error);
        this.itV = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.itW = inflate.findViewById(R.id.layout_live_end);
        this.itX = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.isB = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.itZ = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.itO = new a(this);
        this.fRN = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ao.a(this.itQ, R.raw.ala_play);
            ao.setViewTextColor(this.itV, R.color.CAM_X0101);
            ao.setBackgroundColor(this.itU, R.color.black_alpha80);
            ao.setBackgroundColor(this.gxn, R.color.black_alpha100);
            ao.setViewTextColor(this.itX, R.color.CAM_X0101);
            ao.setBackgroundColor(this.itW, R.color.black_alpha80);
            ao.setViewTextColor(this.fRN, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.itO;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fRN != null) {
            this.fRN.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.itP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.itP.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.itZ.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.itZ.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.isB.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gxn;
    }

    public void bQH() {
        this.itP.setVisibility(0);
        this.itQ.setVisibility(0);
        this.itR.setVisibility(8);
        if (this.bIB != null) {
            this.bIB.clearAnimation();
        }
        this.itT.sc();
        this.itU.setVisibility(8);
        this.itW.setVisibility(8);
        e.mB().removeCallbacks(this.iua);
        e.mB().removeCallbacks(this.fRR);
        e.mB().removeCallbacks(this.iub);
    }

    public void setVideoStatsData(o oVar) {
        this.gxn.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.itY = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cru();
    }

    public void startPlayAnimation() {
        if (this.itQ != null) {
            this.itQ.playAnimation();
        }
    }

    public void cru() {
        if (this.itQ != null) {
            this.itQ.cancelAnimation();
        }
    }
}
