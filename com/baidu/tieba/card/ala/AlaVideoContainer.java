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
    private g.f bPD;
    private g.b bPE;
    private TbImageView.a cWO;
    private Runnable cWP;
    private TextView cWq;
    private AlaPlayAnimationView cWs;
    private LinearLayout cYv;
    private TextView cZA;
    private View cZB;
    private TextView cZC;
    private n cZD;
    private View.OnClickListener cZE;
    private TextView cZF;
    private int cZG;
    private Runnable cZH;
    private Runnable cZI;
    private a cZs;
    private TbImageView cZt;
    private View cZu;
    private ImageView cZv;
    private FrameLayout cZw;
    private Animation cZx;
    private AudioAnimationView cZy;
    private View cZz;
    private QuickVideoView caY;
    private QuickVideoView.b cbh;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cZG = -1;
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZt != null) {
                    AlaVideoContainer.this.cZt.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZE != null) {
                            AlaVideoContainer.this.cZE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPD = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZy.start();
                AlaVideoContainer.this.cZw.setVisibility(8);
                AlaVideoContainer.this.cZt.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZH, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZI);
            }
        };
        this.cZH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZu != null) {
                    AlaVideoContainer.this.cZu.startAnimation(AlaVideoContainer.this.cZx);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZI);
                return false;
            }
        };
        this.cWP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZz.setVisibility(0);
                AlaVideoContainer.this.cZw.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWP, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZG = -1;
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZt != null) {
                    AlaVideoContainer.this.cZt.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZE != null) {
                            AlaVideoContainer.this.cZE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPD = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZy.start();
                AlaVideoContainer.this.cZw.setVisibility(8);
                AlaVideoContainer.this.cZt.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZH, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZI);
            }
        };
        this.cZH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZu != null) {
                    AlaVideoContainer.this.cZu.startAnimation(AlaVideoContainer.this.cZx);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cZI);
                return false;
            }
        };
        this.cWP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZz.setVisibility(0);
                AlaVideoContainer.this.cZw.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWP, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZG = -1;
        this.cWO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cZt != null) {
                    AlaVideoContainer.this.cZt.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cZE != null) {
                            AlaVideoContainer.this.cZE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bPD = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cZy.start();
                AlaVideoContainer.this.cZw.setVisibility(8);
                AlaVideoContainer.this.cZt.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cZH, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cZI);
            }
        };
        this.cZH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cZu != null) {
                    AlaVideoContainer.this.cZu.startAnimation(AlaVideoContainer.this.cZx);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WW();
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ns().post(AlaVideoContainer.this.cZI);
                return false;
            }
        };
        this.cWP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WW();
            }
        };
        this.cZI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cZz.setVisibility(0);
                AlaVideoContainer.this.cZw.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWP, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.caY = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.caY.getLayoutParams();
        layoutParams.height = (this.caY.getWidth() * 9) / 16;
        this.caY.setLayoutParams(layoutParams);
        this.cZD = new n(getContext());
        this.cZD.bly();
        this.caY.setBusiness(this.cZD);
        this.caY.setOnPreparedListener(this.bPD);
        this.caY.setOnSurfaceDestroyedListener(this.cbh);
        this.caY.setOnErrorListener(this.bPE);
        this.cZt = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cZt.setDefaultErrorResource(0);
        this.cZt.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZt.setEvent(this.cWO);
        this.cZt.setGifIconSupport(false);
        this.cZu = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cZv = (ImageView) inflate.findViewById(d.g.img_play);
        this.cWs = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cZw = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cZx = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cZy = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cZy.setCertainColumnCount(4);
        this.cZy.setColumnColor(d.C0140d.cp_cont_i);
        this.cZz = inflate.findViewById(d.g.layout_error);
        this.cZA = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cZB = inflate.findViewById(d.g.layout_live_end);
        this.cZC = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cYv = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cZF = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cZs = new a(this);
        this.cWq = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0140d.cp_cont_i);
        }
        if (this.cZG > 0) {
            aj.c(this.cZv, this.cZG);
        } else {
            aj.c(this.cZv, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cZA, d.C0140d.cp_cont_i);
        aj.t(this.cZz, d.C0140d.black_alpha80);
        aj.t(this.caY, d.C0140d.cp_bg_line_k);
        aj.r(this.cZC, d.C0140d.cp_cont_i);
        aj.t(this.cZB, d.C0140d.black_alpha80);
        aj.r(this.cWq, d.C0140d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cZs;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cWq != null) {
            this.cWq.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cZt.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cZt.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cZF.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cZF.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cYv.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.caY;
    }

    public void WW() {
        this.cZt.setVisibility(0);
        this.cZv.setVisibility(0);
        this.cZw.setVisibility(8);
        if (this.cZu != null) {
            this.cZu.clearAnimation();
        }
        this.cZy.tn();
        this.cZz.setVisibility(8);
        this.cZB.setVisibility(8);
        e.ns().removeCallbacks(this.cZH);
        e.ns().removeCallbacks(this.cWP);
        e.ns().removeCallbacks(this.cZI);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cZD != null) {
            this.cZD.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cZE = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cWs != null) {
            this.cWs.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cWs != null) {
            this.cWs.setAutoStartPlay(z);
        }
    }
}
