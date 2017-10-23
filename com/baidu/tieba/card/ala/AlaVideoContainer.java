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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private g.f aVR;
    private g.b aVS;
    private TbImageView.a bKH;
    private Runnable bKI;
    private QuickVideoView.b bKK;
    private TextView bKj;
    private AlaPlayAnimationView bKl;
    private a bMB;
    private QuickVideoView bMC;
    private TbImageView bMD;
    private View bME;
    private ImageView bMF;
    private FrameLayout bMG;
    private Animation bMH;
    private AudioAnimationView bMI;
    private View bMJ;
    private TextView bMK;
    private View bML;
    private TextView bMM;
    private n bMN;
    private View.OnClickListener bMO;
    private TextView bMP;
    private int bMQ;
    private Runnable bMR;
    private Runnable bMS;
    private LinearLayout bMh;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bMQ = -1;
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMD != null) {
                    AlaVideoContainer.this.bMD.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.bMO != null) {
                            AlaVideoContainer.this.bMO.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aVR = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMI.start();
                AlaVideoContainer.this.bMG.setVisibility(8);
                AlaVideoContainer.this.bMD.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bMR, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bMS);
            }
        };
        this.bMR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bME != null) {
                    AlaVideoContainer.this.bME.startAnimation(AlaVideoContainer.this.bMH);
                }
            }
        };
        this.bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XO();
            }
        };
        this.aVS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bMS);
                return false;
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XO();
            }
        };
        this.bMS = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMJ.setVisibility(0);
                AlaVideoContainer.this.bMG.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKI, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMQ = -1;
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMD != null) {
                    AlaVideoContainer.this.bMD.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.bMO != null) {
                            AlaVideoContainer.this.bMO.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aVR = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMI.start();
                AlaVideoContainer.this.bMG.setVisibility(8);
                AlaVideoContainer.this.bMD.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bMR, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bMS);
            }
        };
        this.bMR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bME != null) {
                    AlaVideoContainer.this.bME.startAnimation(AlaVideoContainer.this.bMH);
                }
            }
        };
        this.bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XO();
            }
        };
        this.aVS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bMS);
                return false;
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XO();
            }
        };
        this.bMS = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMJ.setVisibility(0);
                AlaVideoContainer.this.bMG.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKI, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMQ = -1;
        this.bKH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMD != null) {
                    AlaVideoContainer.this.bMD.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.bMO != null) {
                            AlaVideoContainer.this.bMO.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aVR = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMI.start();
                AlaVideoContainer.this.bMG.setVisibility(8);
                AlaVideoContainer.this.bMD.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bMR, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bMS);
            }
        };
        this.bMR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bME != null) {
                    AlaVideoContainer.this.bME.startAnimation(AlaVideoContainer.this.bMH);
                }
            }
        };
        this.bKK = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XO();
            }
        };
        this.aVS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.bMS);
                return false;
            }
        };
        this.bKI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XO();
            }
        };
        this.bMS = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMJ.setVisibility(0);
                AlaVideoContainer.this.bMG.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKI, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bMC = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bMC.getLayoutParams();
        layoutParams.height = (this.bMC.getWidth() * 9) / 16;
        this.bMC.setLayoutParams(layoutParams);
        this.bMN = new n(getContext());
        this.bMN.bem();
        this.bMC.setBusiness(this.bMN);
        this.bMC.setOnPreparedListener(this.aVR);
        this.bMC.setOnSurfaceDestroyedListener(this.bKK);
        this.bMC.setOnErrorListener(this.aVS);
        this.bMD = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bMD.setDefaultErrorResource(0);
        this.bMD.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMD.setEvent(this.bKH);
        this.bMD.setGifIconSupport(false);
        this.bME = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bMF = (ImageView) inflate.findViewById(d.h.img_play);
        this.bKl = (AlaPlayAnimationView) inflate.findViewById(d.h.ala_play);
        this.bMG = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bMH = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bMI = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bMI.setCertainColumnCount(4);
        this.bMI.setColumnColor(d.e.cp_cont_i);
        this.bMJ = inflate.findViewById(d.h.layout_error);
        this.bMK = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bML = inflate.findViewById(d.h.layout_live_end);
        this.bMM = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bMh = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bMP = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bMB = new a(this);
        this.bKj = (TextView) inflate.findViewById(d.h.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bMQ > 0) {
            aj.c(this.bMF, this.bMQ);
        } else {
            aj.c(this.bMF, d.g.btn_icon_play_live_on_n);
        }
        aj.i(this.bMK, d.e.cp_cont_i);
        aj.k(this.bMJ, d.e.black_alpha80);
        aj.k(this.bMC, d.e.cp_bg_line_k);
        aj.i(this.bMM, d.e.cp_cont_i);
        aj.k(this.bML, d.e.black_alpha80);
        aj.i(this.bKj, d.e.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bMB;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bKj != null) {
            this.bKj.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bMD.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMD.c(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.bMP.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bMP.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bMh.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bMC;
    }

    public void XO() {
        this.bMD.setVisibility(0);
        this.bMF.setVisibility(0);
        this.bMG.setVisibility(8);
        if (this.bME != null) {
            this.bME.clearAnimation();
        }
        this.bMI.bxN();
        this.bMJ.setVisibility(8);
        this.bML.setVisibility(8);
        e.fP().removeCallbacks(this.bMR);
        e.fP().removeCallbacks(this.bKI);
        e.fP().removeCallbacks(this.bMS);
    }

    public void setVideoStatsData(x xVar) {
        if (this.bMN != null) {
            this.bMN.setVideoStatsData(xVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bMO = onClickListener;
    }

    public void XP() {
        if (this.bKl != null) {
            this.bKl.XP();
        }
    }
}
