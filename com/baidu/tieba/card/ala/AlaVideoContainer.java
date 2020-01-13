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
/* loaded from: classes6.dex */
public class AlaVideoContainer extends LinearLayout {
    private View ayH;
    private TextView dHX;
    private TbImageView.a dHZ;
    private g.b dIa;
    private Runnable dIc;
    private QuickVideoView.b dIe;
    private g.f dQX;
    private QuickVideoView egS;
    private LinearLayout fIw;
    private a fJA;
    private TbImageView fJB;
    private TBLottieAnimationView fJC;
    private FrameLayout fJD;
    private Animation fJE;
    private AudioAnimationView fJF;
    private View fJG;
    private TextView fJH;
    private View fJI;
    private TextView fJJ;
    private n fJK;
    private View.OnClickListener fJL;
    private TextView fJM;
    private Runnable fJN;
    private Runnable fJO;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fJB != null) {
                    AlaVideoContainer.this.fJB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fJL != null) {
                            AlaVideoContainer.this.fJL.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fJF.start();
                AlaVideoContainer.this.fJD.setVisibility(8);
                AlaVideoContainer.this.fJB.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fJN, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fJO);
            }
        };
        this.fJN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ayH != null) {
                    AlaVideoContainer.this.ayH.startAnimation(AlaVideoContainer.this.fJE);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fJO);
                return false;
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.fJO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fJG.setVisibility(0);
                AlaVideoContainer.this.fJD.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dIc, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fJB != null) {
                    AlaVideoContainer.this.fJB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fJL != null) {
                            AlaVideoContainer.this.fJL.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fJF.start();
                AlaVideoContainer.this.fJD.setVisibility(8);
                AlaVideoContainer.this.fJB.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fJN, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fJO);
            }
        };
        this.fJN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ayH != null) {
                    AlaVideoContainer.this.ayH.startAnimation(AlaVideoContainer.this.fJE);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fJO);
                return false;
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.fJO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fJG.setVisibility(0);
                AlaVideoContainer.this.fJD.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dIc, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dHZ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fJB != null) {
                    AlaVideoContainer.this.fJB.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fJL != null) {
                            AlaVideoContainer.this.fJL.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fJF.start();
                AlaVideoContainer.this.fJD.setVisibility(8);
                AlaVideoContainer.this.fJB.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fJN, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fJO);
            }
        };
        this.fJN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ayH != null) {
                    AlaVideoContainer.this.ayH.startAnimation(AlaVideoContainer.this.fJE);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gx().post(AlaVideoContainer.this.fJO);
                return false;
            }
        };
        this.dIc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZW();
            }
        };
        this.fJO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fJG.setVisibility(0);
                AlaVideoContainer.this.fJD.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dIc, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.egS = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.egS.getLayoutParams();
        layoutParams.height = (this.egS.getWidth() * 9) / 16;
        this.egS.setLayoutParams(layoutParams);
        this.fJK = new n(getContext());
        this.fJK.cxA();
        this.egS.setBusiness(this.fJK);
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        this.egS.setOnErrorListener(this.dIa);
        this.fJB = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fJB.setDefaultErrorResource(0);
        this.fJB.setDrawCorner(true);
        this.fJB.setPlaceHolder(3);
        this.fJB.setEvent(this.dHZ);
        this.fJB.setGifIconSupport(false);
        TbImageView tbImageView = this.fJB;
        TbImageView tbImageView2 = this.fJB;
        tbImageView.setConrers(15);
        this.fJB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fJB.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fJB.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fJB.setBorderSurroundContent(true);
        this.fJB.setDrawBorder(true);
        this.ayH = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fJC = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fJC.loop(true);
        this.fJD = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fJE = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fJF = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fJF.setCertainColumnCount(4);
        this.fJF.setColumnColor(R.color.cp_cont_a);
        this.fJG = inflate.findViewById(R.id.layout_error);
        this.fJH = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fJI = inflate.findViewById(R.id.layout_live_end);
        this.fJJ = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fIw = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fJM = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fJA = new a(this);
        this.dHX = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fJC, R.raw.ala_play);
            am.setViewTextColor(this.fJH, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fJG, R.color.black_alpha80);
            am.setBackgroundColor(this.egS, R.color.black_alpha100);
            am.setViewTextColor(this.fJJ, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fJI, R.color.black_alpha80);
            am.setViewTextColor(this.dHX, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fJA;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dHX != null) {
            this.dHX.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fJB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fJB.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fJM.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fJM.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fIw.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.egS;
    }

    public void aZW() {
        this.fJB.setVisibility(0);
        this.fJC.setVisibility(0);
        this.fJD.setVisibility(8);
        if (this.ayH != null) {
            this.ayH.clearAnimation();
        }
        this.fJF.lD();
        this.fJG.setVisibility(8);
        this.fJI.setVisibility(8);
        e.gx().removeCallbacks(this.fJN);
        e.gx().removeCallbacks(this.dIc);
        e.gx().removeCallbacks(this.fJO);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fJK != null) {
            this.fJK.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fJL = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btJ();
    }

    public void startPlayAnimation() {
        if (this.fJC != null) {
            this.fJC.playAnimation();
        }
    }

    public void btJ() {
        if (this.fJC != null) {
            this.fJC.cancelAnimation();
        }
    }
}
