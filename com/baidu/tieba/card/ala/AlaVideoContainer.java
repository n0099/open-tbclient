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
    private g.f aWe;
    private g.b aWf;
    private TbImageView.a bKT;
    private Runnable bKU;
    private QuickVideoView.b bKW;
    private TextView bKv;
    private AlaPlayAnimationView bKx;
    private a bMN;
    private QuickVideoView bMO;
    private TbImageView bMP;
    private View bMQ;
    private ImageView bMR;
    private FrameLayout bMS;
    private Animation bMT;
    private AudioAnimationView bMU;
    private View bMV;
    private TextView bMW;
    private View bMX;
    private TextView bMY;
    private n bMZ;
    private LinearLayout bMt;
    private View.OnClickListener bNa;
    private TextView bNb;
    private int bNc;
    private Runnable bNd;
    private Runnable bNe;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bNc = -1;
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMP != null) {
                    AlaVideoContainer.this.bMP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bNa != null) {
                            AlaVideoContainer.this.bNa.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aWe = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMU.start();
                AlaVideoContainer.this.bMS.setVisibility(8);
                AlaVideoContainer.this.bMP.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bNd, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bNe);
            }
        };
        this.bNd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMQ != null) {
                    AlaVideoContainer.this.bMQ.startAnimation(AlaVideoContainer.this.bMT);
                }
            }
        };
        this.bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XS();
            }
        };
        this.aWf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bNe);
                return false;
            }
        };
        this.bKU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XS();
            }
        };
        this.bNe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMV.setVisibility(0);
                AlaVideoContainer.this.bMS.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNc = -1;
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMP != null) {
                    AlaVideoContainer.this.bMP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bNa != null) {
                            AlaVideoContainer.this.bNa.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aWe = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMU.start();
                AlaVideoContainer.this.bMS.setVisibility(8);
                AlaVideoContainer.this.bMP.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bNd, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bNe);
            }
        };
        this.bNd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMQ != null) {
                    AlaVideoContainer.this.bMQ.startAnimation(AlaVideoContainer.this.bMT);
                }
            }
        };
        this.bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XS();
            }
        };
        this.aWf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bNe);
                return false;
            }
        };
        this.bKU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XS();
            }
        };
        this.bNe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMV.setVisibility(0);
                AlaVideoContainer.this.bMS.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNc = -1;
        this.bKT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.bMP != null) {
                    AlaVideoContainer.this.bMP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bNa != null) {
                            AlaVideoContainer.this.bNa.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aWe = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bMU.start();
                AlaVideoContainer.this.bMS.setVisibility(8);
                AlaVideoContainer.this.bMP.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bNd, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bNe);
            }
        };
        this.bNd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bMQ != null) {
                    AlaVideoContainer.this.bMQ.startAnimation(AlaVideoContainer.this.bMT);
                }
            }
        };
        this.bKW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.XS();
            }
        };
        this.aWf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.bNe);
                return false;
            }
        };
        this.bKU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.XS();
            }
        };
        this.bNe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMV.setVisibility(0);
                AlaVideoContainer.this.bMS.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bKU, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bMO = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bMO.getLayoutParams();
        layoutParams.height = (this.bMO.getWidth() * 9) / 16;
        this.bMO.setLayoutParams(layoutParams);
        this.bMZ = new n(getContext());
        this.bMZ.bes();
        this.bMO.setBusiness(this.bMZ);
        this.bMO.setOnPreparedListener(this.aWe);
        this.bMO.setOnSurfaceDestroyedListener(this.bKW);
        this.bMO.setOnErrorListener(this.aWf);
        this.bMP = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bMP.setDefaultErrorResource(0);
        this.bMP.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMP.setEvent(this.bKT);
        this.bMP.setGifIconSupport(false);
        this.bMQ = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bMR = (ImageView) inflate.findViewById(d.h.img_play);
        this.bKx = (AlaPlayAnimationView) inflate.findViewById(d.h.ala_play);
        this.bMS = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bMT = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bMU = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bMU.setCertainColumnCount(4);
        this.bMU.setColumnColor(d.e.cp_cont_i);
        this.bMV = inflate.findViewById(d.h.layout_error);
        this.bMW = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bMX = inflate.findViewById(d.h.layout_live_end);
        this.bMY = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bMt = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bNb = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bMN = new a(this);
        this.bKv = (TextView) inflate.findViewById(d.h.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bNc > 0) {
            aj.c(this.bMR, this.bNc);
        } else {
            aj.c(this.bMR, d.g.btn_icon_play_live_on_n);
        }
        aj.i(this.bMW, d.e.cp_cont_i);
        aj.k(this.bMV, d.e.black_alpha80);
        aj.k(this.bMO, d.e.cp_bg_line_k);
        aj.i(this.bMY, d.e.cp_cont_i);
        aj.k(this.bMX, d.e.black_alpha80);
        aj.i(this.bKv, d.e.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bMN;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bKv != null) {
            this.bKv.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bMP.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bMP.c(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.bNb.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bNb.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bMt.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bMO;
    }

    public void XS() {
        this.bMP.setVisibility(0);
        this.bMR.setVisibility(0);
        this.bMS.setVisibility(8);
        if (this.bMQ != null) {
            this.bMQ.clearAnimation();
        }
        this.bMU.bxW();
        this.bMV.setVisibility(8);
        this.bMX.setVisibility(8);
        e.fP().removeCallbacks(this.bNd);
        e.fP().removeCallbacks(this.bKU);
        e.fP().removeCallbacks(this.bNe);
    }

    public void setVideoStatsData(x xVar) {
        if (this.bMZ != null) {
            this.bMZ.setVideoStatsData(xVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bNa = onClickListener;
    }

    public void XT() {
        if (this.bKx != null) {
            this.bKx.XT();
        }
    }
}
