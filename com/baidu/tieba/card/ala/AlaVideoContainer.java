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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes15.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bjX;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private Runnable eRB;
    private TbCyberVideoView.a eRD;
    private TextView eRx;
    private TbImageView.a eRz;
    private TbCyberVideoView fsr;
    private LinearLayout gYb;
    private a gZm;
    private TbImageView gZn;
    private TBLottieAnimationView gZo;
    private FrameLayout gZp;
    private Animation gZq;
    private AudioAnimationView gZr;
    private View gZs;
    private TextView gZt;
    private View gZu;
    private TextView gZv;
    private View.OnClickListener gZw;
    private TextView gZx;
    private Runnable gZy;
    private Runnable gZz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gZn != null) {
                    AlaVideoContainer.this.gZn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gZw != null) {
                            AlaVideoContainer.this.gZw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fsr != null) {
                    AlaVideoContainer.this.fsr.setLooping(true);
                    AlaVideoContainer.this.fsr.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gZr.start();
                AlaVideoContainer.this.gZp.setVisibility(8);
                AlaVideoContainer.this.gZn.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gZy, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gZz);
            }
        };
        this.gZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjX != null) {
                    AlaVideoContainer.this.bjX.startAnimation(AlaVideoContainer.this.gZq);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.lt().post(AlaVideoContainer.this.gZz);
                return false;
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.gZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gZs.setVisibility(0);
                AlaVideoContainer.this.gZp.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eRB, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gZn != null) {
                    AlaVideoContainer.this.gZn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gZw != null) {
                            AlaVideoContainer.this.gZw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fsr != null) {
                    AlaVideoContainer.this.fsr.setLooping(true);
                    AlaVideoContainer.this.fsr.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gZr.start();
                AlaVideoContainer.this.gZp.setVisibility(8);
                AlaVideoContainer.this.gZn.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gZy, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gZz);
            }
        };
        this.gZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjX != null) {
                    AlaVideoContainer.this.bjX.startAnimation(AlaVideoContainer.this.gZq);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.lt().post(AlaVideoContainer.this.gZz);
                return false;
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.gZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gZs.setVisibility(0);
                AlaVideoContainer.this.gZp.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eRB, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eRz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gZn != null) {
                    AlaVideoContainer.this.gZn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gZw != null) {
                            AlaVideoContainer.this.gZw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fsr != null) {
                    AlaVideoContainer.this.fsr.setLooping(true);
                    AlaVideoContainer.this.fsr.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gZr.start();
                AlaVideoContainer.this.gZp.setVisibility(8);
                AlaVideoContainer.this.gZn.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gZy, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gZz);
            }
        };
        this.gZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjX != null) {
                    AlaVideoContainer.this.bjX.startAnimation(AlaVideoContainer.this.gZq);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.lt().post(AlaVideoContainer.this.gZz);
                return false;
            }
        };
        this.eRB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bwN();
            }
        };
        this.gZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gZs.setVisibility(0);
                AlaVideoContainer.this.gZp.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eRB, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fsr = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.fsr.getLayoutParams();
        layoutParams.height = (this.fsr.getWidth() * 9) / 16;
        this.fsr.setLayoutParams(layoutParams);
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        this.fsr.setOnErrorListener(this.dCy);
        this.gZn = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.gZn.setDefaultErrorResource(0);
        this.gZn.setDrawCorner(true);
        this.gZn.setPlaceHolder(3);
        this.gZn.setEvent(this.eRz);
        this.gZn.setGifIconSupport(false);
        TbImageView tbImageView = this.gZn;
        TbImageView tbImageView2 = this.gZn;
        tbImageView.setConrers(15);
        this.gZn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.gZn.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gZn.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.gZn.setBorderSurroundContent(true);
        this.gZn.setDrawBorder(true);
        this.bjX = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.gZo = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.gZo.loop(true);
        this.gZp = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.gZq = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.gZr = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.gZr.setCertainColumnCount(4);
        this.gZr.setColumnColor(R.color.cp_cont_a);
        this.gZs = inflate.findViewById(R.id.layout_error);
        this.gZt = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.gZu = inflate.findViewById(R.id.layout_live_end);
        this.gZv = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gYb = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.gZx = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.gZm = new a(this);
        this.eRx = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ao.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ao.a(this.gZo, R.raw.ala_play);
            ao.setViewTextColor(this.gZt, R.color.cp_cont_a);
            ao.setBackgroundColor(this.gZs, R.color.black_alpha80);
            ao.setBackgroundColor(this.fsr, R.color.black_alpha100);
            ao.setViewTextColor(this.gZv, R.color.cp_cont_a);
            ao.setBackgroundColor(this.gZu, R.color.black_alpha80);
            ao.setViewTextColor(this.eRx, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.gZm;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.eRx != null) {
            this.eRx.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.gZn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gZn.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.gZx.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.gZx.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gYb.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.fsr;
    }

    public void bwN() {
        this.gZn.setVisibility(0);
        this.gZo.setVisibility(0);
        this.gZp.setVisibility(8);
        if (this.bjX != null) {
            this.bjX.clearAnimation();
        }
        this.gZr.qU();
        this.gZs.setVisibility(8);
        this.gZu.setVisibility(8);
        e.lt().removeCallbacks(this.gZy);
        e.lt().removeCallbacks(this.eRB);
        e.lt().removeCallbacks(this.gZz);
    }

    public void setVideoStatsData(o oVar) {
        this.fsr.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.gZw = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bRW();
    }

    public void startPlayAnimation() {
        if (this.gZo != null) {
            this.gZo.playAnimation();
        }
    }

    public void bRW() {
        if (this.gZo != null) {
            this.gZo.cancelAnimation();
        }
    }
}
