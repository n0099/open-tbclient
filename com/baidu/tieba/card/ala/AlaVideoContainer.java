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
    private View aWZ;
    private QuickVideoView ePf;
    private TextView emC;
    private TbImageView.a emE;
    private g.b emF;
    private Runnable emH;
    private QuickVideoView.b emJ;
    private g.f evK;
    private LinearLayout gqD;
    private a grH;
    private TbImageView grI;
    private TBLottieAnimationView grJ;
    private FrameLayout grK;
    private Animation grL;
    private AudioAnimationView grM;
    private View grN;
    private TextView grO;
    private View grP;
    private TextView grQ;
    private n grR;
    private View.OnClickListener grS;
    private TextView grT;
    private Runnable grU;
    private Runnable grV;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grI != null) {
                    AlaVideoContainer.this.grI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grS != null) {
                            AlaVideoContainer.this.grS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grM.start();
                AlaVideoContainer.this.grK.setVisibility(8);
                AlaVideoContainer.this.grI.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grU, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grV);
            }
        };
        this.grU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWZ != null) {
                    AlaVideoContainer.this.aWZ.startAnimation(AlaVideoContainer.this.grL);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bli();
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lb().post(AlaVideoContainer.this.grV);
                return false;
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bli();
            }
        };
        this.grV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grN.setVisibility(0);
                AlaVideoContainer.this.grK.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grI != null) {
                    AlaVideoContainer.this.grI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grS != null) {
                            AlaVideoContainer.this.grS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grM.start();
                AlaVideoContainer.this.grK.setVisibility(8);
                AlaVideoContainer.this.grI.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grU, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grV);
            }
        };
        this.grU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWZ != null) {
                    AlaVideoContainer.this.aWZ.startAnimation(AlaVideoContainer.this.grL);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bli();
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lb().post(AlaVideoContainer.this.grV);
                return false;
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bli();
            }
        };
        this.grV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grN.setVisibility(0);
                AlaVideoContainer.this.grK.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.emE = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.grI != null) {
                    AlaVideoContainer.this.grI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.grS != null) {
                            AlaVideoContainer.this.grS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.grM.start();
                AlaVideoContainer.this.grK.setVisibility(8);
                AlaVideoContainer.this.grI.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.grU, 3000L);
                e.lb().removeCallbacks(AlaVideoContainer.this.grV);
            }
        };
        this.grU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aWZ != null) {
                    AlaVideoContainer.this.aWZ.startAnimation(AlaVideoContainer.this.grL);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bli();
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.lb().post(AlaVideoContainer.this.grV);
                return false;
            }
        };
        this.emH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bli();
            }
        };
        this.grV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.grN.setVisibility(0);
                AlaVideoContainer.this.grK.setVisibility(8);
                e.lb().postDelayed(AlaVideoContainer.this.emH, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.ePf = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.ePf.getLayoutParams();
        layoutParams.height = (this.ePf.getWidth() * 9) / 16;
        this.ePf.setLayoutParams(layoutParams);
        this.grR = new n(getContext());
        this.grR.cJV();
        this.ePf.setBusiness(this.grR);
        this.ePf.setOnPreparedListener(this.evK);
        this.ePf.setOnSurfaceDestroyedListener(this.emJ);
        this.ePf.setOnErrorListener(this.emF);
        this.grI = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.grI.setDefaultErrorResource(0);
        this.grI.setDrawCorner(true);
        this.grI.setPlaceHolder(3);
        this.grI.setEvent(this.emE);
        this.grI.setGifIconSupport(false);
        TbImageView tbImageView = this.grI;
        TbImageView tbImageView2 = this.grI;
        tbImageView.setConrers(15);
        this.grI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.grI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.grI.setBorderColor(am.getColor(R.color.cp_border_a));
        this.grI.setBorderSurroundContent(true);
        this.grI.setDrawBorder(true);
        this.aWZ = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.grJ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.grJ.loop(true);
        this.grK = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.grL = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.grM = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.grM.setCertainColumnCount(4);
        this.grM.setColumnColor(R.color.cp_cont_a);
        this.grN = inflate.findViewById(R.id.layout_error);
        this.grO = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.grP = inflate.findViewById(R.id.layout_live_end);
        this.grQ = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gqD = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.grT = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.grH = new a(this);
        this.emC = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.grJ, R.raw.ala_play);
            am.setViewTextColor(this.grO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.grN, R.color.black_alpha80);
            am.setBackgroundColor(this.ePf, R.color.black_alpha100);
            am.setViewTextColor(this.grQ, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.grP, R.color.black_alpha80);
            am.setViewTextColor(this.emC, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.grH;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.emC != null) {
            this.emC.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.grI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.grI.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.grT.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.grT.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gqD.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.ePf;
    }

    public void bli() {
        this.grI.setVisibility(0);
        this.grJ.setVisibility(0);
        this.grK.setVisibility(8);
        if (this.aWZ != null) {
            this.aWZ.clearAnimation();
        }
        this.grM.qu();
        this.grN.setVisibility(8);
        this.grP.setVisibility(8);
        e.lb().removeCallbacks(this.grU);
        e.lb().removeCallbacks(this.emH);
        e.lb().removeCallbacks(this.grV);
    }

    public void setVideoStatsData(y yVar) {
        if (this.grR != null) {
            this.grR.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.grS = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bFf();
    }

    public void startPlayAnimation() {
        if (this.grJ != null) {
            this.grJ.playAnimation();
        }
    }

    public void bFf() {
        if (this.grJ != null) {
            this.grJ.cancelAnimation();
        }
    }
}
