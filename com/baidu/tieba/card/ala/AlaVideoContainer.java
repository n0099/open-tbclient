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
    private g.f bPq;
    private g.b bPr;
    private TbImageView.a cWC;
    private Runnable cWD;
    private TextView cWe;
    private AlaPlayAnimationView cWg;
    private LinearLayout cYj;
    private a cZg;
    private TbImageView cZh;
    private View cZi;
    private ImageView cZj;
    private FrameLayout cZk;
    private Animation cZl;
    private AudioAnimationView cZm;
    private View cZn;
    private TextView cZo;
    private View cZp;
    private TextView cZq;
    private n cZr;
    private View.OnClickListener cZs;
    private TextView cZt;
    private int cZu;
    private Runnable cZv;
    private Runnable cZw;
    private QuickVideoView caM;
    private QuickVideoView.b caV;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cZu = -1;
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZh != null) {
                    AlaVideoContainer.this.cZh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZs != null) {
                            AlaVideoContainer.this.cZs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZm.start();
                AlaVideoContainer.this.cZk.setVisibility(8);
                AlaVideoContainer.this.cZh.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZv, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZw);
            }
        };
        this.cZv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZi != null) {
                    AlaVideoContainer.this.cZi.startAnimation(AlaVideoContainer.this.cZl);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZw);
                return false;
            }
        };
        this.cWD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.cZw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZn.setVisibility(0);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWD, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZu = -1;
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZh != null) {
                    AlaVideoContainer.this.cZh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZs != null) {
                            AlaVideoContainer.this.cZs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZm.start();
                AlaVideoContainer.this.cZk.setVisibility(8);
                AlaVideoContainer.this.cZh.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZv, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZw);
            }
        };
        this.cZv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZi != null) {
                    AlaVideoContainer.this.cZi.startAnimation(AlaVideoContainer.this.cZl);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZw);
                return false;
            }
        };
        this.cWD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.cZw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZn.setVisibility(0);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWD, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZu = -1;
        this.cWC = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZh != null) {
                    AlaVideoContainer.this.cZh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZs != null) {
                            AlaVideoContainer.this.cZs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZm.start();
                AlaVideoContainer.this.cZk.setVisibility(8);
                AlaVideoContainer.this.cZh.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZv, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZw);
            }
        };
        this.cZv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZi != null) {
                    AlaVideoContainer.this.cZi.startAnimation(AlaVideoContainer.this.cZl);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WV();
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ns().post(AlaVideoContainer.this.cZw);
                return false;
            }
        };
        this.cWD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WV();
            }
        };
        this.cZw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZn.setVisibility(0);
                AlaVideoContainer.this.cZk.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWD, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.caM = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.caM.getLayoutParams();
        layoutParams.height = (this.caM.getWidth() * 9) / 16;
        this.caM.setLayoutParams(layoutParams);
        this.cZr = new n(getContext());
        this.cZr.blx();
        this.caM.setBusiness(this.cZr);
        this.caM.setOnPreparedListener(this.bPq);
        this.caM.setOnSurfaceDestroyedListener(this.caV);
        this.caM.setOnErrorListener(this.bPr);
        this.cZh = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cZh.setDefaultErrorResource(0);
        this.cZh.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZh.setEvent(this.cWC);
        this.cZh.setGifIconSupport(false);
        this.cZi = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cZj = (ImageView) inflate.findViewById(d.g.img_play);
        this.cWg = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cZk = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cZl = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cZm = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cZm.setCertainColumnCount(4);
        this.cZm.setColumnColor(d.C0141d.cp_cont_i);
        this.cZn = inflate.findViewById(d.g.layout_error);
        this.cZo = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cZp = inflate.findViewById(d.g.layout_live_end);
        this.cZq = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cYj = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cZt = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cZg = new a(this);
        this.cWe = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0141d.cp_cont_i);
        }
        if (this.cZu > 0) {
            aj.c(this.cZj, this.cZu);
        } else {
            aj.c(this.cZj, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cZo, d.C0141d.cp_cont_i);
        aj.t(this.cZn, d.C0141d.black_alpha80);
        aj.t(this.caM, d.C0141d.cp_bg_line_k);
        aj.r(this.cZq, d.C0141d.cp_cont_i);
        aj.t(this.cZp, d.C0141d.black_alpha80);
        aj.r(this.cWe, d.C0141d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cZg;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cWe != null) {
            this.cWe.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cZh.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZh.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cZt.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cZt.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cYj.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.caM;
    }

    public void WV() {
        this.cZh.setVisibility(0);
        this.cZj.setVisibility(0);
        this.cZk.setVisibility(8);
        if (this.cZi != null) {
            this.cZi.clearAnimation();
        }
        this.cZm.tn();
        this.cZn.setVisibility(8);
        this.cZp.setVisibility(8);
        e.ns().removeCallbacks(this.cZv);
        e.ns().removeCallbacks(this.cWD);
        e.ns().removeCallbacks(this.cZw);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZr != null) {
            this.cZr.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cZs = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cWg != null) {
            this.cWg.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cWg != null) {
            this.cWg.setAutoStartPlay(z);
        }
    }
}
