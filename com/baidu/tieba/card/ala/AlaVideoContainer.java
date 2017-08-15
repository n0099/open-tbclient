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
    private f.d aUN;
    private f.b aUO;
    private TbImageView.a bEM;
    private Runnable bHM;
    private QuickVideoView.b bHO;
    private a bJA;
    private QuickVideoView bJB;
    private TbImageView bJC;
    private View bJD;
    private ImageView bJE;
    private FrameLayout bJF;
    private Animation bJG;
    private AudioAnimationView bJH;
    private View bJI;
    private TextView bJJ;
    private View bJK;
    private TextView bJL;
    private m bJM;
    private View.OnClickListener bJN;
    private int bJO;
    private Runnable bJP;
    private Runnable bJQ;
    private LinearLayout bJm;
    private TextView bJn;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bJO = -1;
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJC != null) {
                    AlaVideoContainer.this.bJC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bJN != null) {
                            AlaVideoContainer.this.bJN.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUN = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJH.start();
                AlaVideoContainer.this.bJF.setVisibility(8);
                AlaVideoContainer.this.bJC.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJP, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJQ);
            }
        };
        this.bJP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.startAnimation(AlaVideoContainer.this.bJG);
                }
            }
        };
        this.bHO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WY();
            }
        };
        this.aUO = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJQ);
                return false;
            }
        };
        this.bHM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WY();
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJI.setVisibility(0);
                AlaVideoContainer.this.bJF.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHM, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJO = -1;
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJC != null) {
                    AlaVideoContainer.this.bJC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bJN != null) {
                            AlaVideoContainer.this.bJN.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUN = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJH.start();
                AlaVideoContainer.this.bJF.setVisibility(8);
                AlaVideoContainer.this.bJC.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJP, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJQ);
            }
        };
        this.bJP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.startAnimation(AlaVideoContainer.this.bJG);
                }
            }
        };
        this.bHO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WY();
            }
        };
        this.aUO = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJQ);
                return false;
            }
        };
        this.bHM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WY();
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJI.setVisibility(0);
                AlaVideoContainer.this.bJF.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHM, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJO = -1;
        this.bEM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bJC != null) {
                    AlaVideoContainer.this.bJC.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bJN != null) {
                            AlaVideoContainer.this.bJN.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUN = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bJH.start();
                AlaVideoContainer.this.bJF.setVisibility(8);
                AlaVideoContainer.this.bJC.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJP, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJQ);
            }
        };
        this.bJP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bJD != null) {
                    AlaVideoContainer.this.bJD.startAnimation(AlaVideoContainer.this.bJG);
                }
            }
        };
        this.bHO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WY();
            }
        };
        this.aUO = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.ga().post(AlaVideoContainer.this.bJQ);
                return false;
            }
        };
        this.bHM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WY();
            }
        };
        this.bJQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bJI.setVisibility(0);
                AlaVideoContainer.this.bJF.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHM, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bJB = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bJB.getLayoutParams();
        layoutParams.height = (this.bJB.getWidth() * 9) / 16;
        this.bJB.setLayoutParams(layoutParams);
        this.bJM = new m(getContext());
        this.bJM.bgt();
        this.bJB.setBusiness(this.bJM);
        this.bJB.setOnPreparedListener(this.aUN);
        this.bJB.setOnSurfaceDestroyedListener(this.bHO);
        this.bJB.setOnErrorListener(this.aUO);
        this.bJC = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bJC.setDefaultErrorResource(0);
        this.bJC.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bJC.setEvent(this.bEM);
        this.bJC.setGifIconSupport(false);
        this.bJD = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bJE = (ImageView) inflate.findViewById(d.h.img_play);
        this.bJF = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bJG = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bJH = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bJH.setCertainColumnCount(4);
        this.bJH.setColumnColor(d.e.cp_cont_i);
        this.bJI = inflate.findViewById(d.h.layout_error);
        this.bJJ = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bJK = inflate.findViewById(d.h.layout_live_end);
        this.bJL = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bJm = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bJn = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bJA = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ai.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bJO > 0) {
            ai.c(this.bJE, this.bJO);
        } else {
            ai.c(this.bJE, d.g.btn_icon_play_live);
        }
        ai.i(this.bJJ, d.e.cp_cont_i);
        ai.k(this.bJI, d.e.black_alpha80);
        ai.k(this.bJB, d.e.cp_bg_line_k);
        ai.i(this.bJL, d.e.cp_cont_i);
        ai.k(this.bJK, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bJA;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bJC.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bJC.c(str, 10, false);
    }

    public void aa(int i, int i2) {
        this.bJO = i;
        this.bJE.setImageResource(i);
        this.bJE.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bJn.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bJn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bJm.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bJB;
    }

    public void WY() {
        this.bJC.setVisibility(0);
        this.bJE.setVisibility(0);
        this.bJF.setVisibility(8);
        if (this.bJD != null) {
            this.bJD.clearAnimation();
        }
        this.bJH.bxk();
        this.bJI.setVisibility(8);
        this.bJK.setVisibility(8);
        e.ga().removeCallbacks(this.bJP);
        e.ga().removeCallbacks(this.bHM);
        e.ga().removeCallbacks(this.bJQ);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJM != null) {
            this.bJM.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bJN = onClickListener;
    }
}
