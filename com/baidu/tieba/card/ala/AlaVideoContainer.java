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
    private g.InterfaceC0124g aWj;
    private g.b aWk;
    private TbImageView.a bSB;
    private Runnable bSC;
    private QuickVideoView.b bSE;
    private TextView bSc;
    private AlaPlayAnimationView bSe;
    private LinearLayout bTY;
    private View bUA;
    private TextView bUB;
    private View bUC;
    private TextView bUD;
    private n bUE;
    private View.OnClickListener bUF;
    private TextView bUG;
    private int bUH;
    private Runnable bUI;
    private Runnable bUJ;
    private a bUs;
    private QuickVideoView bUt;
    private TbImageView bUu;
    private View bUv;
    private ImageView bUw;
    private FrameLayout bUx;
    private Animation bUy;
    private AudioAnimationView bUz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bUH = -1;
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUu != null) {
                    AlaVideoContainer.this.bUu.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUF != null) {
                            AlaVideoContainer.this.bUF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUz.start();
                AlaVideoContainer.this.bUx.setVisibility(8);
                AlaVideoContainer.this.bUu.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUI, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUJ);
            }
        };
        this.bUI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUv != null) {
                    AlaVideoContainer.this.bUv.startAnimation(AlaVideoContainer.this.bUy);
                }
            }
        };
        this.bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aak();
            }
        };
        this.aWk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bUJ);
                return false;
            }
        };
        this.bSC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aak();
            }
        };
        this.bUJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUA.setVisibility(0);
                AlaVideoContainer.this.bUx.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSC, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUH = -1;
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUu != null) {
                    AlaVideoContainer.this.bUu.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUF != null) {
                            AlaVideoContainer.this.bUF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUz.start();
                AlaVideoContainer.this.bUx.setVisibility(8);
                AlaVideoContainer.this.bUu.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUI, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUJ);
            }
        };
        this.bUI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUv != null) {
                    AlaVideoContainer.this.bUv.startAnimation(AlaVideoContainer.this.bUy);
                }
            }
        };
        this.bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aak();
            }
        };
        this.aWk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bUJ);
                return false;
            }
        };
        this.bSC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aak();
            }
        };
        this.bUJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUA.setVisibility(0);
                AlaVideoContainer.this.bUx.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSC, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUH = -1;
        this.bSB = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUu != null) {
                    AlaVideoContainer.this.bUu.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUF != null) {
                            AlaVideoContainer.this.bUF.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWj = new g.InterfaceC0124g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0124g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUz.start();
                AlaVideoContainer.this.bUx.setVisibility(8);
                AlaVideoContainer.this.bUu.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUI, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUJ);
            }
        };
        this.bUI = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUv != null) {
                    AlaVideoContainer.this.bUv.startAnimation(AlaVideoContainer.this.bUy);
                }
            }
        };
        this.bSE = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aak();
            }
        };
        this.aWk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.bUJ);
                return false;
            }
        };
        this.bSC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aak();
            }
        };
        this.bUJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUA.setVisibility(0);
                AlaVideoContainer.this.bUx.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSC, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bUt = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bUt.getLayoutParams();
        layoutParams.height = (this.bUt.getWidth() * 9) / 16;
        this.bUt.setLayoutParams(layoutParams);
        this.bUE = new n(getContext());
        this.bUE.bhF();
        this.bUt.setBusiness(this.bUE);
        this.bUt.setOnPreparedListener(this.aWj);
        this.bUt.setOnSurfaceDestroyedListener(this.bSE);
        this.bUt.setOnErrorListener(this.aWk);
        this.bUu = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.bUu.setDefaultErrorResource(0);
        this.bUu.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bUu.setEvent(this.bSB);
        this.bUu.setGifIconSupport(false);
        this.bUv = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.bUw = (ImageView) inflate.findViewById(d.g.img_play);
        this.bSe = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.bUx = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.bUy = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bUz = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.bUz.setCertainColumnCount(4);
        this.bUz.setColumnColor(d.C0080d.cp_cont_i);
        this.bUA = inflate.findViewById(d.g.layout_error);
        this.bUB = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.bUC = inflate.findViewById(d.g.layout_live_end);
        this.bUD = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.bTY = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.bUG = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.bUs = new a(this);
        this.bSc = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.C0080d.cp_cont_i);
        }
        if (this.bUH > 0) {
            aj.c(this.bUw, this.bUH);
        } else {
            aj.c(this.bUw, d.f.btn_icon_play_live_on_n);
        }
        aj.i(this.bUB, d.C0080d.cp_cont_i);
        aj.k(this.bUA, d.C0080d.black_alpha80);
        aj.k(this.bUt, d.C0080d.cp_bg_line_k);
        aj.i(this.bUD, d.C0080d.cp_cont_i);
        aj.k(this.bUC, d.C0080d.black_alpha80);
        aj.i(this.bSc, d.C0080d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bUs;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bSc != null) {
            this.bSc.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bUu.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bUu.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.bUG.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bUG.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bTY.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bUt;
    }

    public void aak() {
        this.bUu.setVisibility(0);
        this.bUw.setVisibility(0);
        this.bUx.setVisibility(8);
        if (this.bUv != null) {
            this.bUv.clearAnimation();
        }
        this.bUz.bBs();
        this.bUA.setVisibility(8);
        this.bUC.setVisibility(8);
        e.fP().removeCallbacks(this.bUI);
        e.fP().removeCallbacks(this.bSC);
        e.fP().removeCallbacks(this.bUJ);
    }

    public void setVideoStatsData(x xVar) {
        if (this.bUE != null) {
            this.bUE.setVideoStatsData(xVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bUF = onClickListener;
    }

    public void aal() {
        if (this.bSe != null) {
            this.bSe.aal();
        }
    }
}
