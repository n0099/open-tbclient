package com.baidu.tieba.card.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private f.d aUO;
    private f.b aUP;
    private TbImageView.a bEN;
    private Runnable bHN;
    private QuickVideoView.b bHP;
    private a bJB;
    private QuickVideoView bJC;
    private TbImageView bJD;
    private View bJE;
    private ImageView bJF;
    private FrameLayout bJG;
    private Animation bJH;
    private AudioAnimationView bJI;
    private View bJJ;
    private TextView bJK;
    private View bJL;
    private TextView bJM;
    private m bJN;
    private View.OnClickListener bJO;
    private int bJP;
    private Runnable bJQ;
    private Runnable bJR;
    private LinearLayout bJn;
    private TextView bJo;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bJP = -1;
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJO != null) {
                            AlaVideoContainer.this.bJO.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUO = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJI.start();
                AlaVideoContainer.this.bJG.setVisibility(8);
                AlaVideoContainer.this.bJD.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJQ, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJR);
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJE != null) {
                    AlaVideoContainer.this.bJE.startAnimation(AlaVideoContainer.this.bJH);
                }
            }
        };
        this.bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.aUP = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJR);
                return false;
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bJR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJJ.setVisibility(0);
                AlaVideoContainer.this.bJG.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHN, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJP = -1;
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJO != null) {
                            AlaVideoContainer.this.bJO.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUO = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJI.start();
                AlaVideoContainer.this.bJG.setVisibility(8);
                AlaVideoContainer.this.bJD.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJQ, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJR);
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJE != null) {
                    AlaVideoContainer.this.bJE.startAnimation(AlaVideoContainer.this.bJH);
                }
            }
        };
        this.bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.aUP = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJR);
                return false;
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bJR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJJ.setVisibility(0);
                AlaVideoContainer.this.bJG.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHN, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJP = -1;
        this.bEN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJO != null) {
                            AlaVideoContainer.this.bJO.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUO = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJI.start();
                AlaVideoContainer.this.bJG.setVisibility(8);
                AlaVideoContainer.this.bJD.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJQ, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJR);
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJE != null) {
                    AlaVideoContainer.this.bJE.startAnimation(AlaVideoContainer.this.bJH);
                }
            }
        };
        this.bHP = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.aUP = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.ga().post(AlaVideoContainer.this.bJR);
                return false;
            }
        };
        this.bHN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bJR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJJ.setVisibility(0);
                AlaVideoContainer.this.bJG.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHN, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bJC = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bJC.getLayoutParams();
        layoutParams.height = (this.bJC.getWidth() * 9) / 16;
        this.bJC.setLayoutParams(layoutParams);
        this.bJN = new m(getContext());
        this.bJN.bgo();
        this.bJC.setBusiness(this.bJN);
        this.bJC.setOnPreparedListener(this.aUO);
        this.bJC.setOnSurfaceDestroyedListener(this.bHP);
        this.bJC.setOnErrorListener(this.aUP);
        this.bJD = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bJD.setDefaultErrorResource(0);
        this.bJD.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bJD.setEvent(this.bEN);
        this.bJD.setGifIconSupport(false);
        this.bJE = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bJF = (ImageView) inflate.findViewById(d.h.img_play);
        this.bJG = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bJH = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bJI = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bJI.setCertainColumnCount(4);
        this.bJI.setColumnColor(d.e.cp_cont_i);
        this.bJJ = inflate.findViewById(d.h.layout_error);
        this.bJK = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bJL = inflate.findViewById(d.h.layout_live_end);
        this.bJM = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bJn = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bJo = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bJB = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ai.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bJP > 0) {
            ai.c(this.bJF, this.bJP);
        } else {
            ai.c(this.bJF, d.g.btn_icon_play_live);
        }
        ai.i(this.bJK, d.e.cp_cont_i);
        ai.k(this.bJJ, d.e.black_alpha80);
        ai.k(this.bJC, d.e.cp_bg_line_k);
        ai.i(this.bJM, d.e.cp_cont_i);
        ai.k(this.bJL, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bJB;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bJD.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bJD.c(str, 10, false);
    }

    public void aa(int i, int i2) {
        this.bJP = i;
        this.bJF.setImageResource(i);
        this.bJF.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bJo.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bJo.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bJn.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bJC;
    }

    public void WV() {
        this.bJD.setVisibility(0);
        this.bJF.setVisibility(0);
        this.bJG.setVisibility(8);
        if (this.bJE != null) {
            this.bJE.clearAnimation();
        }
        this.bJI.bxd();
        this.bJJ.setVisibility(8);
        this.bJL.setVisibility(8);
        e.ga().removeCallbacks(this.bJQ);
        e.ga().removeCallbacks(this.bHN);
        e.ga().removeCallbacks(this.bJR);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJN != null) {
            this.bJN.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bJO = onClickListener;
    }
}
