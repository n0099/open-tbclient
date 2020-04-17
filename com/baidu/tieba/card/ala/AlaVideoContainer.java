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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes8.dex */
public class AlaVideoContainer extends LinearLayout {
    private View aWU;
    private QuickVideoView ePa;
    private g.b emA;
    private Runnable emC;
    private QuickVideoView.b emE;
    private TextView emx;
    private TbImageView.a emz;
    private g.f evF;
    private LinearLayout gqx;
    private a grB;
    private TbImageView grC;
    private TBLottieAnimationView grD;
    private FrameLayout grE;
    private Animation grF;
    private AudioAnimationView grG;
    private View grH;
    private TextView grI;
    private View grJ;
    private TextView grK;
    private n grL;
    private View.OnClickListener grM;
    private TextView grN;
    private Runnable grO;
    private Runnable grP;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grC != null) {
                    AlaVideoContainer.this.grC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grM != null) {
                            AlaVideoContainer.this.grM.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grG.start();
                AlaVideoContainer.this.grE.setVisibility(8);
                AlaVideoContainer.this.grC.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grO, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grP);
            }
        };
        this.grO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWU != null) {
                    AlaVideoContainer.this.aWU.startAnimation(AlaVideoContainer.this.grF);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.blk();
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lb().post(AlaVideoContainer.this.grP);
                return false;
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.blk();
            }
        };
        this.grP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grH.setVisibility(0);
                AlaVideoContainer.this.grE.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emC, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grC != null) {
                    AlaVideoContainer.this.grC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grM != null) {
                            AlaVideoContainer.this.grM.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grG.start();
                AlaVideoContainer.this.grE.setVisibility(8);
                AlaVideoContainer.this.grC.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grO, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grP);
            }
        };
        this.grO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWU != null) {
                    AlaVideoContainer.this.aWU.startAnimation(AlaVideoContainer.this.grF);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.blk();
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lb().post(AlaVideoContainer.this.grP);
                return false;
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.blk();
            }
        };
        this.grP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grH.setVisibility(0);
                AlaVideoContainer.this.grE.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emC, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.emz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grC != null) {
                    AlaVideoContainer.this.grC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grM != null) {
                            AlaVideoContainer.this.grM.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grG.start();
                AlaVideoContainer.this.grE.setVisibility(8);
                AlaVideoContainer.this.grC.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grO, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grP);
            }
        };
        this.grO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWU != null) {
                    AlaVideoContainer.this.aWU.startAnimation(AlaVideoContainer.this.grF);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.blk();
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.lb().post(AlaVideoContainer.this.grP);
                return false;
            }
        };
        this.emC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.blk();
            }
        };
        this.grP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grH.setVisibility(0);
                AlaVideoContainer.this.grE.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emC, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.ePa = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.ePa.getLayoutParams();
        layoutParams.height = (this.ePa.getWidth() * 9) / 16;
        this.ePa.setLayoutParams(layoutParams);
        this.grL = new n(getContext());
        this.grL.cJX();
        this.ePa.setBusiness(this.grL);
        this.ePa.setOnPreparedListener(this.evF);
        this.ePa.setOnSurfaceDestroyedListener(this.emE);
        this.ePa.setOnErrorListener(this.emA);
        this.grC = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.grC.setDefaultErrorResource(0);
        this.grC.setDrawCorner(true);
        this.grC.setPlaceHolder(3);
        this.grC.setEvent(this.emz);
        this.grC.setGifIconSupport(false);
        TbImageView tbImageView = this.grC;
        TbImageView tbImageView2 = this.grC;
        tbImageView.setConrers(15);
        this.grC.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.grC.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.grC.setBorderColor(am.getColor(R.color.cp_border_a));
        this.grC.setBorderSurroundContent(true);
        this.grC.setDrawBorder(true);
        this.aWU = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.grD = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.grD.loop(true);
        this.grE = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.grF = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.grG = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.grG.setCertainColumnCount(4);
        this.grG.setColumnColor(R.color.cp_cont_a);
        this.grH = inflate.findViewById(R.id.layout_error);
        this.grI = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.grJ = inflate.findViewById(R.id.layout_live_end);
        this.grK = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gqx = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.grN = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.grB = new a(this);
        this.emx = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.grD, R.raw.ala_play);
            am.setViewTextColor(this.grI, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.grH, R.color.black_alpha80);
            am.setBackgroundColor(this.ePa, R.color.black_alpha100);
            am.setViewTextColor(this.grK, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.grJ, R.color.black_alpha80);
            am.setViewTextColor(this.emx, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.grB;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.emx != null) {
            this.emx.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.grC.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.grC.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.grN.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.grN.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gqx.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.ePa;
    }

    public void blk() {
        this.grC.setVisibility(0);
        this.grD.setVisibility(0);
        this.grE.setVisibility(8);
        if (this.aWU != null) {
            this.aWU.clearAnimation();
        }
        this.grG.qu();
        this.grH.setVisibility(8);
        this.grJ.setVisibility(8);
        e.lb().removeCallbacks(this.grO);
        e.lb().removeCallbacks(this.emC);
        e.lb().removeCallbacks(this.grP);
    }

    public void setVideoStatsData(y yVar) {
        if (this.grL != null) {
            this.grL.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.grM = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFg();
    }

    public void startPlayAnimation() {
        if (this.grD != null) {
            this.grD.playAnimation();
        }
    }

    public void bFg() {
        if (this.grD != null) {
            this.grD.cancelAnimation();
        }
    }
}
