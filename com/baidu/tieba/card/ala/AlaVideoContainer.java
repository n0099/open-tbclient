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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private f.e aUw;
    private f.b aUx;
    private TbImageView.a bHH;
    private Runnable bKH;
    private QuickVideoView.b bKJ;
    private AudioAnimationView bMA;
    private View bMB;
    private TextView bMC;
    private View bMD;
    private TextView bME;
    private m bMF;
    private View.OnClickListener bMG;
    private int bMH;
    private Runnable bMI;
    private Runnable bMJ;
    private LinearLayout bMf;
    private TextView bMg;
    private a bMt;
    private QuickVideoView bMu;
    private TbImageView bMv;
    private View bMw;
    private ImageView bMx;
    private FrameLayout bMy;
    private Animation bMz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bMH = -1;
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMv != null) {
                    AlaVideoContainer.this.bMv.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bMG != null) {
                            AlaVideoContainer.this.bMG.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUw = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMA.start();
                AlaVideoContainer.this.bMy.setVisibility(8);
                AlaVideoContainer.this.bMv.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bMI, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bMJ);
            }
        };
        this.bMI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMw != null) {
                    AlaVideoContainer.this.bMw.startAnimation(AlaVideoContainer.this.bMz);
                }
            }
        };
        this.bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.aUx = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fQ().post(AlaVideoContainer.this.bMJ);
                return false;
            }
        };
        this.bKH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.bMJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMB.setVisibility(0);
                AlaVideoContainer.this.bMy.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bKH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMH = -1;
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMv != null) {
                    AlaVideoContainer.this.bMv.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bMG != null) {
                            AlaVideoContainer.this.bMG.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUw = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMA.start();
                AlaVideoContainer.this.bMy.setVisibility(8);
                AlaVideoContainer.this.bMv.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bMI, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bMJ);
            }
        };
        this.bMI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMw != null) {
                    AlaVideoContainer.this.bMw.startAnimation(AlaVideoContainer.this.bMz);
                }
            }
        };
        this.bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.aUx = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fQ().post(AlaVideoContainer.this.bMJ);
                return false;
            }
        };
        this.bKH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.bMJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMB.setVisibility(0);
                AlaVideoContainer.this.bMy.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bKH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMH = -1;
        this.bHH = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMv != null) {
                    AlaVideoContainer.this.bMv.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bMG != null) {
                            AlaVideoContainer.this.bMG.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUw = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMA.start();
                AlaVideoContainer.this.bMy.setVisibility(8);
                AlaVideoContainer.this.bMv.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bMI, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bMJ);
            }
        };
        this.bMI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMw != null) {
                    AlaVideoContainer.this.bMw.startAnimation(AlaVideoContainer.this.bMz);
                }
            }
        };
        this.bKJ = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.aUx = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.fQ().post(AlaVideoContainer.this.bMJ);
                return false;
            }
        };
        this.bKH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XZ();
            }
        };
        this.bMJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMB.setVisibility(0);
                AlaVideoContainer.this.bMy.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bKH, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bMu = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bMu.getLayoutParams();
        layoutParams.height = (this.bMu.getWidth() * 9) / 16;
        this.bMu.setLayoutParams(layoutParams);
        this.bMF = new m(getContext());
        this.bMF.bfE();
        this.bMu.setBusiness(this.bMF);
        this.bMu.setOnPreparedListener(this.aUw);
        this.bMu.setOnSurfaceDestroyedListener(this.bKJ);
        this.bMu.setOnErrorListener(this.aUx);
        this.bMv = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bMv.setDefaultErrorResource(0);
        this.bMv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMv.setEvent(this.bHH);
        this.bMv.setGifIconSupport(false);
        this.bMw = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bMx = (ImageView) inflate.findViewById(d.h.img_play);
        this.bMy = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bMz = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bMA = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bMA.setCertainColumnCount(4);
        this.bMA.setColumnColor(d.e.cp_cont_i);
        this.bMB = inflate.findViewById(d.h.layout_error);
        this.bMC = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bMD = inflate.findViewById(d.h.layout_live_end);
        this.bME = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bMf = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bMg = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bMt = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bMH > 0) {
            aj.c(this.bMx, this.bMH);
        } else {
            aj.c(this.bMx, d.g.btn_icon_play_live);
        }
        aj.i(this.bMC, d.e.cp_cont_i);
        aj.k(this.bMB, d.e.black_alpha80);
        aj.k(this.bMu, d.e.cp_bg_line_k);
        aj.i(this.bME, d.e.cp_cont_i);
        aj.k(this.bMD, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bMt;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bMv.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMv.c(str, 10, false);
    }

    public void Z(int i, int i2) {
        this.bMH = i;
        this.bMx.setImageResource(i);
        this.bMx.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bMg.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bMg.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bMf.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bMu;
    }

    public void XZ() {
        this.bMv.setVisibility(0);
        this.bMx.setVisibility(0);
        this.bMy.setVisibility(8);
        if (this.bMw != null) {
            this.bMw.clearAnimation();
        }
        this.bMA.bwt();
        this.bMB.setVisibility(8);
        this.bMD.setVisibility(8);
        e.fQ().removeCallbacks(this.bMI);
        e.fQ().removeCallbacks(this.bKH);
        e.fQ().removeCallbacks(this.bMJ);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bMF != null) {
            this.bMF.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bMG = onClickListener;
    }
}
