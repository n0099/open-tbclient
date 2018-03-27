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
import com.baidu.tieba.play.aa;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private g.f bPt;
    private g.b bPu;
    private TbImageView.a cWF;
    private Runnable cWG;
    private TextView cWh;
    private AlaPlayAnimationView cWj;
    private LinearLayout cYm;
    private a cZj;
    private TbImageView cZk;
    private View cZl;
    private ImageView cZm;
    private FrameLayout cZn;
    private Animation cZo;
    private AudioAnimationView cZp;
    private View cZq;
    private TextView cZr;
    private View cZs;
    private TextView cZt;
    private n cZu;
    private View.OnClickListener cZv;
    private TextView cZw;
    private int cZx;
    private Runnable cZy;
    private Runnable cZz;
    private QuickVideoView caP;
    private QuickVideoView.b caY;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cZx = -1;
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZk != null) {
                    AlaVideoContainer.this.cZk.setDefaultBgResource(0);
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
                    if (j.oJ()) {
                        if (AlaVideoContainer.this.cZv != null) {
                            AlaVideoContainer.this.cZv.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZp.start();
                AlaVideoContainer.this.cZn.setVisibility(8);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZy, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZz);
            }
        };
        this.cZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZl != null) {
                    AlaVideoContainer.this.cZl.startAnimation(AlaVideoContainer.this.cZo);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZz);
                return false;
            }
        };
        this.cWG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZq.setVisibility(0);
                AlaVideoContainer.this.cZn.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZx = -1;
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZk != null) {
                    AlaVideoContainer.this.cZk.setDefaultBgResource(0);
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
                    if (j.oJ()) {
                        if (AlaVideoContainer.this.cZv != null) {
                            AlaVideoContainer.this.cZv.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZp.start();
                AlaVideoContainer.this.cZn.setVisibility(8);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZy, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZz);
            }
        };
        this.cZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZl != null) {
                    AlaVideoContainer.this.cZl.startAnimation(AlaVideoContainer.this.cZo);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZz);
                return false;
            }
        };
        this.cWG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZq.setVisibility(0);
                AlaVideoContainer.this.cZn.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWG, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZx = -1;
        this.cWF = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZk != null) {
                    AlaVideoContainer.this.cZk.setDefaultBgResource(0);
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
                    if (j.oJ()) {
                        if (AlaVideoContainer.this.cZv != null) {
                            AlaVideoContainer.this.cZv.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZp.start();
                AlaVideoContainer.this.cZn.setVisibility(8);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZy, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZz);
            }
        };
        this.cZy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZl != null) {
                    AlaVideoContainer.this.cZl.startAnimation(AlaVideoContainer.this.cZo);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ns().post(AlaVideoContainer.this.cZz);
                return false;
            }
        };
        this.cWG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZq.setVisibility(0);
                AlaVideoContainer.this.cZn.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWG, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.caP = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.caP.getLayoutParams();
        layoutParams.height = (this.caP.getWidth() * 9) / 16;
        this.caP.setLayoutParams(layoutParams);
        this.cZu = new n(getContext());
        this.cZu.bly();
        this.caP.setBusiness(this.cZu);
        this.caP.setOnPreparedListener(this.bPt);
        this.caP.setOnSurfaceDestroyedListener(this.caY);
        this.caP.setOnErrorListener(this.bPu);
        this.cZk = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cZk.setDefaultErrorResource(0);
        this.cZk.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZk.setEvent(this.cWF);
        this.cZk.setGifIconSupport(false);
        this.cZl = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cZm = (ImageView) inflate.findViewById(d.g.img_play);
        this.cWj = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cZn = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cZo = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cZp = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cZp.setCertainColumnCount(4);
        this.cZp.setColumnColor(d.C0141d.cp_cont_i);
        this.cZq = inflate.findViewById(d.g.layout_error);
        this.cZr = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cZs = inflate.findViewById(d.g.layout_live_end);
        this.cZt = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cYm = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cZw = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cZj = new a(this);
        this.cWh = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0141d.cp_cont_i);
        }
        if (this.cZx > 0) {
            aj.c(this.cZm, this.cZx);
        } else {
            aj.c(this.cZm, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cZr, d.C0141d.cp_cont_i);
        aj.t(this.cZq, d.C0141d.black_alpha80);
        aj.t(this.caP, d.C0141d.cp_bg_line_k);
        aj.r(this.cZt, d.C0141d.cp_cont_i);
        aj.t(this.cZs, d.C0141d.black_alpha80);
        aj.r(this.cWh, d.C0141d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cZj;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cWh != null) {
            this.cWh.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cZk.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZk.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cZw.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cZw.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cYm.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.caP;
    }

    public void WW() {
        this.cZk.setVisibility(0);
        this.cZm.setVisibility(0);
        this.cZn.setVisibility(8);
        if (this.cZl != null) {
            this.cZl.clearAnimation();
        }
        this.cZp.tn();
        this.cZq.setVisibility(8);
        this.cZs.setVisibility(8);
        e.ns().removeCallbacks(this.cZy);
        e.ns().removeCallbacks(this.cWG);
        e.ns().removeCallbacks(this.cZz);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZu != null) {
            this.cZu.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cZv = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cWj != null) {
            this.cWj.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cWj != null) {
            this.cWj.setAutoStartPlay(z);
        }
    }
}
