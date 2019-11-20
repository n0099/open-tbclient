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
import com.baidu.adp.lib.g.e;
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
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes3.dex */
public class AlaVideoContainer extends LinearLayout {
    private View aqi;
    private Runnable cTA;
    private QuickVideoView.b cTC;
    private TextView cTv;
    private TbImageView.a cTx;
    private g.b cTy;
    private g.f dcT;
    private QuickVideoView dvG;
    private LinearLayout eNx;
    private a eOC;
    private TbImageView eOD;
    private TBLottieAnimationView eOE;
    private FrameLayout eOF;
    private Animation eOG;
    private AudioAnimationView eOH;
    private View eOI;
    private TextView eOJ;
    private View eOK;
    private TextView eOL;
    private n eOM;
    private View.OnClickListener eON;
    private TextView eOO;
    private Runnable eOP;
    private Runnable eOQ;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.eOD != null) {
                    AlaVideoContainer.this.eOD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eON != null) {
                            AlaVideoContainer.this.eON.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eOH.start();
                AlaVideoContainer.this.eOF.setVisibility(8);
                AlaVideoContainer.this.eOD.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.eOP, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.eOQ);
            }
        };
        this.eOP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqi != null) {
                    AlaVideoContainer.this.aqi.startAnimation(AlaVideoContainer.this.eOG);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fZ().post(AlaVideoContainer.this.eOQ);
                return false;
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.eOQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eOI.setVisibility(0);
                AlaVideoContainer.this.eOF.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cTA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.eOD != null) {
                    AlaVideoContainer.this.eOD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eON != null) {
                            AlaVideoContainer.this.eON.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eOH.start();
                AlaVideoContainer.this.eOF.setVisibility(8);
                AlaVideoContainer.this.eOD.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.eOP, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.eOQ);
            }
        };
        this.eOP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqi != null) {
                    AlaVideoContainer.this.aqi.startAnimation(AlaVideoContainer.this.eOG);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fZ().post(AlaVideoContainer.this.eOQ);
                return false;
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.eOQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eOI.setVisibility(0);
                AlaVideoContainer.this.eOF.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cTA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cTx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.eOD != null) {
                    AlaVideoContainer.this.eOD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eON != null) {
                            AlaVideoContainer.this.eON.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eOH.start();
                AlaVideoContainer.this.eOF.setVisibility(8);
                AlaVideoContainer.this.eOD.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.eOP, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.eOQ);
            }
        };
        this.eOP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqi != null) {
                    AlaVideoContainer.this.aqi.startAnimation(AlaVideoContainer.this.eOG);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fZ().post(AlaVideoContainer.this.eOQ);
                return false;
            }
        };
        this.cTA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJd();
            }
        };
        this.eOQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eOI.setVisibility(0);
                AlaVideoContainer.this.eOF.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cTA, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dvG = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dvG.getLayoutParams();
        layoutParams.height = (this.dvG.getWidth() * 9) / 16;
        this.dvG.setLayoutParams(layoutParams);
        this.eOM = new n(getContext());
        this.eOM.ccv();
        this.dvG.setBusiness(this.eOM);
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        this.dvG.setOnErrorListener(this.cTy);
        this.eOD = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eOD.setDefaultErrorResource(0);
        this.eOD.setDrawCorner(true);
        this.eOD.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        this.eOD.setEvent(this.cTx);
        this.eOD.setGifIconSupport(false);
        TbImageView tbImageView = this.eOD;
        TbImageView tbImageView2 = this.eOD;
        tbImageView.setConrers(15);
        this.eOD.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.eOD.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eOD.setBorderColor(am.getColor(R.color.black_alpha8));
        this.eOD.setBorderSurroundContent(true);
        this.eOD.setDrawBorder(true);
        this.aqi = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eOE = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eOE.loop(true);
        this.eOF = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eOG = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eOH = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eOH.setCertainColumnCount(4);
        this.eOH.setColumnColor(R.color.cp_cont_a);
        this.eOI = inflate.findViewById(R.id.layout_error);
        this.eOJ = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eOK = inflate.findViewById(R.id.layout_live_end);
        this.eOL = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eNx = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eOO = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.eOC = new a(this);
        this.cTv = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.eOE, R.raw.ala_play);
            am.setViewTextColor(this.eOJ, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eOI, R.color.black_alpha80);
            am.setBackgroundColor(this.dvG, R.color.black_alpha100);
            am.setViewTextColor(this.eOL, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.eOK, R.color.black_alpha80);
            am.setViewTextColor(this.cTv, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eOC;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cTv != null) {
            this.cTv.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.eOD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eOD.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eOO.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eOO.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eNx.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dvG;
    }

    public void aJd() {
        this.eOD.setVisibility(0);
        this.eOE.setVisibility(0);
        this.eOF.setVisibility(8);
        if (this.aqi != null) {
            this.aqi.clearAnimation();
        }
        this.eOH.ll();
        this.eOI.setVisibility(8);
        this.eOK.setVisibility(8);
        e.fZ().removeCallbacks(this.eOP);
        e.fZ().removeCallbacks(this.cTA);
        e.fZ().removeCallbacks(this.eOQ);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eOM != null) {
            this.eOM.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eON = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        baD();
    }

    public void startPlayAnimation() {
        if (this.eOE != null) {
            this.eOE.playAnimation();
        }
    }

    public void baD() {
        if (this.eOE != null) {
            this.eOE.cancelAnimation();
        }
    }
}
