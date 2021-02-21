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
    private TbCyberVideoView gAl;
    private LinearLayout iyx;
    private a izM;
    private TbImageView izN;
    private TBLottieAnimationView izO;
    private FrameLayout izP;
    private Animation izQ;
    private AudioAnimationView izR;
    private View izS;
    private TextView izT;
    private View izU;
    private TextView izV;
    private View.OnClickListener izW;
    private TextView izX;
    private Runnable izY;
    private Runnable izZ;
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
                if (z && AlaVideoContainer.this.izN != null) {
                    AlaVideoContainer.this.izN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.izW != null) {
                            AlaVideoContainer.this.izW.onClick(view);
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
                if (AlaVideoContainer.this.gAl != null) {
                    AlaVideoContainer.this.gAl.setLooping(true);
                    AlaVideoContainer.this.gAl.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izR.start();
                AlaVideoContainer.this.izP.setVisibility(8);
                AlaVideoContainer.this.izN.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izY, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izZ);
            }
        };
        this.izY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izQ);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.izZ);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.izZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izS.setVisibility(0);
                AlaVideoContainer.this.izP.setVisibility(8);
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
                if (z && AlaVideoContainer.this.izN != null) {
                    AlaVideoContainer.this.izN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.izW != null) {
                            AlaVideoContainer.this.izW.onClick(view);
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
                if (AlaVideoContainer.this.gAl != null) {
                    AlaVideoContainer.this.gAl.setLooping(true);
                    AlaVideoContainer.this.gAl.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izR.start();
                AlaVideoContainer.this.izP.setVisibility(8);
                AlaVideoContainer.this.izN.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izY, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izZ);
            }
        };
        this.izY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izQ);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mA().post(AlaVideoContainer.this.izZ);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.izZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izS.setVisibility(0);
                AlaVideoContainer.this.izP.setVisibility(8);
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
                if (z && AlaVideoContainer.this.izN != null) {
                    AlaVideoContainer.this.izN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.izW != null) {
                            AlaVideoContainer.this.izW.onClick(view);
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
                if (AlaVideoContainer.this.gAl != null) {
                    AlaVideoContainer.this.gAl.setLooping(true);
                    AlaVideoContainer.this.gAl.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.izR.start();
                AlaVideoContainer.this.izP.setVisibility(8);
                AlaVideoContainer.this.izN.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.izY, IMConnection.RETRY_DELAY_TIMES);
                e.mA().removeCallbacks(AlaVideoContainer.this.izZ);
            }
        };
        this.izY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMl != null) {
                    AlaVideoContainer.this.bMl.startAnimation(AlaVideoContainer.this.izQ);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mA().post(AlaVideoContainer.this.izZ);
                return false;
            }
        };
        this.fUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bRs();
            }
        };
        this.izZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.izS.setVisibility(0);
                AlaVideoContainer.this.izP.setVisibility(8);
                e.mA().postDelayed(AlaVideoContainer.this.fUg, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gAl = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gAl.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gAl.getLayoutParams();
        layoutParams.height = (this.gAl.getWidth() * 9) / 16;
        this.gAl.setLayoutParams(layoutParams);
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        this.gAl.setOnErrorListener(this.eAB);
        this.izN = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.izN.setDrawCorner(true);
        this.izN.setPlaceHolder(3);
        this.izN.setEvent(this.fUe);
        this.izN.setGifIconSupport(false);
        TbImageView tbImageView = this.izN;
        TbImageView tbImageView2 = this.izN;
        tbImageView.setConrers(15);
        this.izN.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.izN.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.izN.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.izN.setBorderSurroundContent(true);
        this.izN.setDrawBorder(true);
        this.bMl = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.izO = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.izO.loop(true);
        this.izP = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.izQ = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.izR = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.izR.setCertainColumnCount(4);
        this.izR.setColumnColor(R.color.CAM_X0302);
        this.izS = inflate.findViewById(R.id.layout_error);
        this.izT = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.izU = inflate.findViewById(R.id.layout_live_end);
        this.izV = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.iyx = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.izX = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.izM = new a(this);
        this.fUc = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
            }
            ap.a(this.izO, R.raw.ala_play);
            ap.setViewTextColor(this.izT, R.color.CAM_X0101);
            ap.setBackgroundColor(this.izS, R.color.black_alpha80);
            ap.setBackgroundColor(this.gAl, R.color.black_alpha100);
            ap.setViewTextColor(this.izV, R.color.CAM_X0101);
            ap.setBackgroundColor(this.izU, R.color.black_alpha80);
            ap.setViewTextColor(this.fUc, R.color.CAM_X0101);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.izM;
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
        this.izN.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.izN.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.izX.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.izX.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.iyx.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gAl;
    }

    public void bRs() {
        this.izN.setVisibility(0);
        this.izO.setVisibility(0);
        this.izP.setVisibility(8);
        if (this.bMl != null) {
            this.bMl.clearAnimation();
        }
        this.izR.rZ();
        this.izS.setVisibility(8);
        this.izU.setVisibility(8);
        e.mA().removeCallbacks(this.izY);
        e.mA().removeCallbacks(this.fUg);
        e.mA().removeCallbacks(this.izZ);
    }

    public void setVideoStatsData(o oVar) {
        this.gAl.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.izW = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        csN();
    }

    public void startPlayAnimation() {
        if (this.izO != null) {
            this.izO.playAnimation();
        }
    }

    public void csN() {
        if (this.izO != null) {
            this.izO.cancelAnimation();
        }
    }
}
