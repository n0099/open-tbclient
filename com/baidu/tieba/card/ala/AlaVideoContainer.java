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
    private g.f aZt;
    private g.b aZu;
    private QuickVideoView blp;
    private QuickVideoView.b blw;
    private TbImageView.a caD;
    private Runnable caE;
    private TextView cag;
    private AlaPlayAnimationView cai;
    private LinearLayout ccj;
    private a cdf;
    private TbImageView cdg;
    private View cdh;
    private ImageView cdi;
    private FrameLayout cdj;
    private Animation cdk;
    private AudioAnimationView cdl;
    private View cdm;
    private TextView cdn;
    private View cdo;
    private TextView cdp;
    private n cdq;
    private View.OnClickListener cdr;
    private TextView cds;
    private int cdt;
    private Runnable cdu;
    private Runnable cdv;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cdt = -1;
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdg != null) {
                    AlaVideoContainer.this.cdg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdr != null) {
                            AlaVideoContainer.this.cdr.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdl.start();
                AlaVideoContainer.this.cdj.setVisibility(8);
                AlaVideoContainer.this.cdg.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdu, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdv);
            }
        };
        this.cdu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdh != null) {
                    AlaVideoContainer.this.cdh.startAnimation(AlaVideoContainer.this.cdk);
                }
            }
        };
        this.blw = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdv);
                return false;
            }
        };
        this.caE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdm.setVisibility(0);
                AlaVideoContainer.this.cdj.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caE, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdt = -1;
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdg != null) {
                    AlaVideoContainer.this.cdg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdr != null) {
                            AlaVideoContainer.this.cdr.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdl.start();
                AlaVideoContainer.this.cdj.setVisibility(8);
                AlaVideoContainer.this.cdg.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdu, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdv);
            }
        };
        this.cdu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdh != null) {
                    AlaVideoContainer.this.cdh.startAnimation(AlaVideoContainer.this.cdk);
                }
            }
        };
        this.blw = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdv);
                return false;
            }
        };
        this.caE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdm.setVisibility(0);
                AlaVideoContainer.this.cdj.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caE, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdt = -1;
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cdg != null) {
                    AlaVideoContainer.this.cdg.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cdr != null) {
                            AlaVideoContainer.this.cdr.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cdl.start();
                AlaVideoContainer.this.cdj.setVisibility(8);
                AlaVideoContainer.this.cdg.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdu, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdv);
            }
        };
        this.cdu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cdh != null) {
                    AlaVideoContainer.this.cdh.startAnimation(AlaVideoContainer.this.cdk);
                }
            }
        };
        this.blw = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.cdv);
                return false;
            }
        };
        this.caE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cdm.setVisibility(0);
                AlaVideoContainer.this.cdj.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caE, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.blp = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.blp.getLayoutParams();
        layoutParams.height = (this.blp.getWidth() * 9) / 16;
        this.blp.setLayoutParams(layoutParams);
        this.cdq = new n(getContext());
        this.cdq.bjx();
        this.blp.setBusiness(this.cdq);
        this.blp.setOnPreparedListener(this.aZt);
        this.blp.setOnSurfaceDestroyedListener(this.blw);
        this.blp.setOnErrorListener(this.aZu);
        this.cdg = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cdg.setDefaultErrorResource(0);
        this.cdg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cdg.setEvent(this.caD);
        this.cdg.setGifIconSupport(false);
        this.cdh = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cdi = (ImageView) inflate.findViewById(d.g.img_play);
        this.cai = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cdj = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cdk = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cdl = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cdl.setCertainColumnCount(4);
        this.cdl.setColumnColor(d.C0095d.cp_cont_i);
        this.cdm = inflate.findViewById(d.g.layout_error);
        this.cdn = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cdo = inflate.findViewById(d.g.layout_live_end);
        this.cdp = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ccj = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cds = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cdf = new a(this);
        this.cag = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.C0095d.cp_cont_i);
        }
        if (this.cdt > 0) {
            aj.c(this.cdi, this.cdt);
        } else {
            aj.c(this.cdi, d.f.btn_icon_play_live_on_n);
        }
        aj.i(this.cdn, d.C0095d.cp_cont_i);
        aj.k(this.cdm, d.C0095d.black_alpha80);
        aj.k(this.blp, d.C0095d.cp_bg_line_k);
        aj.i(this.cdp, d.C0095d.cp_cont_i);
        aj.k(this.cdo, d.C0095d.black_alpha80);
        aj.i(this.cag, d.C0095d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cdf;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cag != null) {
            this.cag.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cdg.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cdg.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cds.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cds.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ccj.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.blp;
    }

    public void OQ() {
        this.cdg.setVisibility(0);
        this.cdi.setVisibility(0);
        this.cdj.setVisibility(8);
        if (this.cdh != null) {
            this.cdh.clearAnimation();
        }
        this.cdl.lK();
        this.cdm.setVisibility(8);
        this.cdo.setVisibility(8);
        e.fP().removeCallbacks(this.cdu);
        e.fP().removeCallbacks(this.caE);
        e.fP().removeCallbacks(this.cdv);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cdq != null) {
            this.cdq.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cdr = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cai != null) {
            this.cai.startPlayAnimation();
        }
    }
}
