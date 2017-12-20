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
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private g.f aZp;
    private g.b aZq;
    private QuickVideoView bll;
    private QuickVideoView.b bls;
    private Runnable caA;
    private TextView cac;
    private AlaPlayAnimationView cae;
    private TbImageView.a caz;
    private LinearLayout ccf;
    private a cdb;
    private TbImageView cdc;
    private View cdd;
    private ImageView cde;
    private FrameLayout cdf;
    private Animation cdg;
    private AudioAnimationView cdh;
    private View cdi;
    private TextView cdj;
    private View cdk;
    private TextView cdl;
    private n cdm;
    private View.OnClickListener cdn;
    private TextView cdo;
    private int cdp;
    private Runnable cdq;
    private Runnable cdr;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cdp = -1;
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdc != null) {
                    AlaVideoContainer.this.cdc.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdn != null) {
                            AlaVideoContainer.this.cdn.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdh.start();
                AlaVideoContainer.this.cdf.setVisibility(8);
                AlaVideoContainer.this.cdc.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdq, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdr);
            }
        };
        this.cdq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdd != null) {
                    AlaVideoContainer.this.cdd.startAnimation(AlaVideoContainer.this.cdg);
                }
            }
        };
        this.bls = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdr);
                return false;
            }
        };
        this.caA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdi.setVisibility(0);
                AlaVideoContainer.this.cdf.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdp = -1;
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdc != null) {
                    AlaVideoContainer.this.cdc.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdn != null) {
                            AlaVideoContainer.this.cdn.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdh.start();
                AlaVideoContainer.this.cdf.setVisibility(8);
                AlaVideoContainer.this.cdc.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdq, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdr);
            }
        };
        this.cdq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdd != null) {
                    AlaVideoContainer.this.cdd.startAnimation(AlaVideoContainer.this.cdg);
                }
            }
        };
        this.bls = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdr);
                return false;
            }
        };
        this.caA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdi.setVisibility(0);
                AlaVideoContainer.this.cdf.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdp = -1;
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdc != null) {
                    AlaVideoContainer.this.cdc.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdn != null) {
                            AlaVideoContainer.this.cdn.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdh.start();
                AlaVideoContainer.this.cdf.setVisibility(8);
                AlaVideoContainer.this.cdc.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdq, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdr);
            }
        };
        this.cdq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdd != null) {
                    AlaVideoContainer.this.cdd.startAnimation(AlaVideoContainer.this.cdg);
                }
            }
        };
        this.bls = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.cdr);
                return false;
            }
        };
        this.caA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdi.setVisibility(0);
                AlaVideoContainer.this.cdf.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caA, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bll = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bll.getLayoutParams();
        layoutParams.height = (this.bll.getWidth() * 9) / 16;
        this.bll.setLayoutParams(layoutParams);
        this.cdm = new n(getContext());
        this.cdm.bjw();
        this.bll.setBusiness(this.cdm);
        this.bll.setOnPreparedListener(this.aZp);
        this.bll.setOnSurfaceDestroyedListener(this.bls);
        this.bll.setOnErrorListener(this.aZq);
        this.cdc = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cdc.setDefaultErrorResource(0);
        this.cdc.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cdc.setEvent(this.caz);
        this.cdc.setGifIconSupport(false);
        this.cdd = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cde = (ImageView) inflate.findViewById(d.g.img_play);
        this.cae = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cdf = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cdg = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cdh = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cdh.setCertainColumnCount(4);
        this.cdh.setColumnColor(d.C0096d.cp_cont_i);
        this.cdi = inflate.findViewById(d.g.layout_error);
        this.cdj = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cdk = inflate.findViewById(d.g.layout_live_end);
        this.cdl = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ccf = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cdo = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cdb = new a(this);
        this.cac = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.C0096d.cp_cont_i);
        }
        if (this.cdp > 0) {
            aj.c(this.cde, this.cdp);
        } else {
            aj.c(this.cde, d.f.btn_icon_play_live_on_n);
        }
        aj.i(this.cdj, d.C0096d.cp_cont_i);
        aj.k(this.cdi, d.C0096d.black_alpha80);
        aj.k(this.bll, d.C0096d.cp_bg_line_k);
        aj.i(this.cdl, d.C0096d.cp_cont_i);
        aj.k(this.cdk, d.C0096d.black_alpha80);
        aj.i(this.cac, d.C0096d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cdb;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cac != null) {
            this.cac.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cdc.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cdc.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cdo.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cdo.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ccf.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bll;
    }

    public void OQ() {
        this.cdc.setVisibility(0);
        this.cde.setVisibility(0);
        this.cdf.setVisibility(8);
        if (this.cdd != null) {
            this.cdd.clearAnimation();
        }
        this.cdh.lK();
        this.cdi.setVisibility(8);
        this.cdk.setVisibility(8);
        e.fP().removeCallbacks(this.cdq);
        e.fP().removeCallbacks(this.caA);
        e.fP().removeCallbacks(this.cdr);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cdm != null) {
            this.cdm.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cdn = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cae != null) {
            this.cae.startPlayAnimation();
        }
    }
}
