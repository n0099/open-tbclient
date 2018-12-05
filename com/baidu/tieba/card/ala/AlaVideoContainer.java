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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes6.dex */
public class AlaVideoContainer extends LinearLayout {
    private QuickVideoView bOn;
    private TextView boT;
    private TbImageView.a boV;
    private g.b boW;
    private Runnable boY;
    private QuickVideoView.b bpa;
    private g.f bxJ;
    private AlaPlayAnimationView cUu;
    private LinearLayout cWe;
    private Runnable cXA;
    private Runnable cXB;
    private a cXl;
    private TbImageView cXm;
    private View cXn;
    private ImageView cXo;
    private FrameLayout cXp;
    private Animation cXq;
    private AudioAnimationView cXr;
    private View cXs;
    private TextView cXt;
    private View cXu;
    private TextView cXv;
    private n cXw;
    private View.OnClickListener cXx;
    private TextView cXy;
    private int cXz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cXz = -1;
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.cXm != null) {
                    AlaVideoContainer.this.cXm.setDefaultBgResource(0);
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
                    if (j.kV()) {
                        if (AlaVideoContainer.this.cXx != null) {
                            AlaVideoContainer.this.cXx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cXr.start();
                AlaVideoContainer.this.cXp.setVisibility(8);
                AlaVideoContainer.this.cXm.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cXA, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cXB);
            }
        };
        this.cXA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cXn != null) {
                    AlaVideoContainer.this.cXn.startAnimation(AlaVideoContainer.this.cXq);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cXB);
                return false;
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.cXB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cXs.setVisibility(0);
                AlaVideoContainer.this.cXp.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.boY, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cXz = -1;
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.cXm != null) {
                    AlaVideoContainer.this.cXm.setDefaultBgResource(0);
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
                    if (j.kV()) {
                        if (AlaVideoContainer.this.cXx != null) {
                            AlaVideoContainer.this.cXx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cXr.start();
                AlaVideoContainer.this.cXp.setVisibility(8);
                AlaVideoContainer.this.cXm.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cXA, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cXB);
            }
        };
        this.cXA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cXn != null) {
                    AlaVideoContainer.this.cXn.startAnimation(AlaVideoContainer.this.cXq);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cXB);
                return false;
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.cXB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cXs.setVisibility(0);
                AlaVideoContainer.this.cXp.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.boY, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXz = -1;
        this.boV = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.cXm != null) {
                    AlaVideoContainer.this.cXm.setDefaultBgResource(0);
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
                    if (j.kV()) {
                        if (AlaVideoContainer.this.cXx != null) {
                            AlaVideoContainer.this.cXx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cXr.start();
                AlaVideoContainer.this.cXp.setVisibility(8);
                AlaVideoContainer.this.cXm.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cXA, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cXB);
            }
        };
        this.cXA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cXn != null) {
                    AlaVideoContainer.this.cXn.startAnimation(AlaVideoContainer.this.cXq);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cXB);
                return false;
            }
        };
        this.boY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaj();
            }
        };
        this.cXB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cXs.setVisibility(0);
                AlaVideoContainer.this.cXp.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.boY, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bOn = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bOn.getLayoutParams();
        layoutParams.height = (this.bOn.getWidth() * 9) / 16;
        this.bOn.setLayoutParams(layoutParams);
        this.cXw = new n(getContext());
        this.cXw.brG();
        this.bOn.setBusiness(this.cXw);
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        this.bOn.setOnErrorListener(this.boW);
        this.cXm = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.cXm.setDefaultErrorResource(0);
        this.cXm.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cXm.setEvent(this.boV);
        this.cXm.setGifIconSupport(false);
        this.cXn = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.cXo = (ImageView) inflate.findViewById(e.g.img_play);
        this.cUu = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.cXp = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.cXq = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.cXr = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.cXr.setCertainColumnCount(4);
        this.cXr.setColumnColor(e.d.cp_cont_i);
        this.cXs = inflate.findViewById(e.g.layout_error);
        this.cXt = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.cXu = inflate.findViewById(e.g.layout_live_end);
        this.cXv = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cWe = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.cXy = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.cXl = new a(this);
        this.boT = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.cXz > 0) {
            al.c(this.cXo, this.cXz);
        } else {
            al.c(this.cXo, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.cXt, e.d.cp_cont_i);
        al.j(this.cXs, e.d.black_alpha80);
        al.j(this.bOn, e.d.cp_bg_line_k);
        al.h(this.cXv, e.d.cp_cont_i);
        al.j(this.cXu, e.d.black_alpha80);
        al.h(this.boT, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cXl;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.boT != null) {
            this.boT.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cXm.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cXm.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cXz = i;
        this.cXo.setImageResource(i);
        this.cXo.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cXy.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cXy.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cWe.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bOn;
    }

    public void aaj() {
        this.cXm.setVisibility(0);
        this.cXo.setVisibility(0);
        this.cXp.setVisibility(8);
        if (this.cXn != null) {
            this.cXn.clearAnimation();
        }
        this.cXr.pT();
        this.cXs.setVisibility(8);
        this.cXu.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXA);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.boY);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cXB);
    }

    public void setVideoStatsData(z zVar) {
        if (this.cXw != null) {
            this.cXw.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cXx = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cUu != null) {
            this.cUu.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cUu != null) {
            this.cUu.setAutoStartPlay(z);
        }
    }
}
