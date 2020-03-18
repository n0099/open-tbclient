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
    private View aDn;
    private TextView dMG;
    private TbImageView.a dMI;
    private g.b dMJ;
    private Runnable dML;
    private QuickVideoView.b dMN;
    private g.f dVG;
    private QuickVideoView elA;
    private LinearLayout fLQ;
    private a fMU;
    private TbImageView fMV;
    private TBLottieAnimationView fMW;
    private FrameLayout fMX;
    private Animation fMY;
    private AudioAnimationView fMZ;
    private View fNa;
    private TextView fNb;
    private View fNc;
    private TextView fNd;
    private n fNe;
    private View.OnClickListener fNf;
    private TextView fNg;
    private Runnable fNh;
    private Runnable fNi;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMV != null) {
                    AlaVideoContainer.this.fMV.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fNf != null) {
                            AlaVideoContainer.this.fNf.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMZ.start();
                AlaVideoContainer.this.fMX.setVisibility(8);
                AlaVideoContainer.this.fMV.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fNh, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fNi);
            }
        };
        this.fNh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aDn != null) {
                    AlaVideoContainer.this.aDn.startAnimation(AlaVideoContainer.this.fMY);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bct();
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fNi);
                return false;
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bct();
            }
        };
        this.fNi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fNa.setVisibility(0);
                AlaVideoContainer.this.fMX.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dML, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMV != null) {
                    AlaVideoContainer.this.fMV.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fNf != null) {
                            AlaVideoContainer.this.fNf.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMZ.start();
                AlaVideoContainer.this.fMX.setVisibility(8);
                AlaVideoContainer.this.fMV.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fNh, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fNi);
            }
        };
        this.fNh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aDn != null) {
                    AlaVideoContainer.this.aDn.startAnimation(AlaVideoContainer.this.fMY);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bct();
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fNi);
                return false;
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bct();
            }
        };
        this.fNi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fNa.setVisibility(0);
                AlaVideoContainer.this.fMX.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dML, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dMI = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMV != null) {
                    AlaVideoContainer.this.fMV.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fNf != null) {
                            AlaVideoContainer.this.fNf.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMZ.start();
                AlaVideoContainer.this.fMX.setVisibility(8);
                AlaVideoContainer.this.fMV.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fNh, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fNi);
            }
        };
        this.fNh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aDn != null) {
                    AlaVideoContainer.this.aDn.startAnimation(AlaVideoContainer.this.fMY);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bct();
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gx().post(AlaVideoContainer.this.fNi);
                return false;
            }
        };
        this.dML = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bct();
            }
        };
        this.fNi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fNa.setVisibility(0);
                AlaVideoContainer.this.fMX.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dML, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.elA = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.elA.getLayoutParams();
        layoutParams.height = (this.elA.getWidth() * 9) / 16;
        this.elA.setLayoutParams(layoutParams);
        this.fNe = new n(getContext());
        this.fNe.czs();
        this.elA.setBusiness(this.fNe);
        this.elA.setOnPreparedListener(this.dVG);
        this.elA.setOnSurfaceDestroyedListener(this.dMN);
        this.elA.setOnErrorListener(this.dMJ);
        this.fMV = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fMV.setDefaultErrorResource(0);
        this.fMV.setDrawCorner(true);
        this.fMV.setPlaceHolder(3);
        this.fMV.setEvent(this.dMI);
        this.fMV.setGifIconSupport(false);
        TbImageView tbImageView = this.fMV;
        TbImageView tbImageView2 = this.fMV;
        tbImageView.setConrers(15);
        this.fMV.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fMV.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMV.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fMV.setBorderSurroundContent(true);
        this.fMV.setDrawBorder(true);
        this.aDn = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fMW = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fMW.loop(true);
        this.fMX = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fMY = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fMZ = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fMZ.setCertainColumnCount(4);
        this.fMZ.setColumnColor(R.color.cp_cont_a);
        this.fNa = inflate.findViewById(R.id.layout_error);
        this.fNb = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fNc = inflate.findViewById(R.id.layout_live_end);
        this.fNd = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fLQ = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fNg = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fMU = new a(this);
        this.dMG = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fMW, R.raw.ala_play);
            am.setViewTextColor(this.fNb, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fNa, R.color.black_alpha80);
            am.setBackgroundColor(this.elA, R.color.black_alpha100);
            am.setViewTextColor(this.fNd, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fNc, R.color.black_alpha80);
            am.setViewTextColor(this.dMG, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fMU;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dMG != null) {
            this.dMG.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fMV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fMV.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fNg.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fNg.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fLQ.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.elA;
    }

    public void bct() {
        this.fMV.setVisibility(0);
        this.fMW.setVisibility(0);
        this.fMX.setVisibility(8);
        if (this.aDn != null) {
            this.aDn.clearAnimation();
        }
        this.fMZ.lS();
        this.fNa.setVisibility(8);
        this.fNc.setVisibility(8);
        e.gx().removeCallbacks(this.fNh);
        e.gx().removeCallbacks(this.dML);
        e.gx().removeCallbacks(this.fNi);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fNe != null) {
            this.fNe.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fNf = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvv();
    }

    public void startPlayAnimation() {
        if (this.fMW != null) {
            this.fMW.playAnimation();
        }
    }

    public void bvv() {
        if (this.fMW != null) {
            this.fMW.cancelAnimation();
        }
    }
}
