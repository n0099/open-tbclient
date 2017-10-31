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
    private g.InterfaceC0121g aWb;
    private g.b aWc;
    private TextView bRP;
    private AlaPlayAnimationView bRR;
    private TbImageView.a bSo;
    private Runnable bSp;
    private QuickVideoView.b bSr;
    private LinearLayout bTL;
    private a bUf;
    private QuickVideoView bUg;
    private TbImageView bUh;
    private View bUi;
    private ImageView bUj;
    private FrameLayout bUk;
    private Animation bUl;
    private AudioAnimationView bUm;
    private View bUn;
    private TextView bUo;
    private View bUp;
    private TextView bUq;
    private n bUr;
    private View.OnClickListener bUs;
    private TextView bUt;
    private int bUu;
    private Runnable bUv;
    private Runnable bUw;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bUu = -1;
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUh != null) {
                    AlaVideoContainer.this.bUh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUs != null) {
                            AlaVideoContainer.this.bUs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUm.start();
                AlaVideoContainer.this.bUk.setVisibility(8);
                AlaVideoContainer.this.bUh.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUv, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUw);
            }
        };
        this.bUv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUi != null) {
                    AlaVideoContainer.this.bUi.startAnimation(AlaVideoContainer.this.bUl);
                }
            }
        };
        this.bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.aWc = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bUw);
                return false;
            }
        };
        this.bSp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.bUw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUn.setVisibility(0);
                AlaVideoContainer.this.bUk.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSp, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUu = -1;
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUh != null) {
                    AlaVideoContainer.this.bUh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUs != null) {
                            AlaVideoContainer.this.bUs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUm.start();
                AlaVideoContainer.this.bUk.setVisibility(8);
                AlaVideoContainer.this.bUh.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUv, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUw);
            }
        };
        this.bUv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUi != null) {
                    AlaVideoContainer.this.bUi.startAnimation(AlaVideoContainer.this.bUl);
                }
            }
        };
        this.bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.aWc = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bUw);
                return false;
            }
        };
        this.bSp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.bUw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUn.setVisibility(0);
                AlaVideoContainer.this.bUk.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSp, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUu = -1;
        this.bSo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.bUh != null) {
                    AlaVideoContainer.this.bUh.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.bUs != null) {
                            AlaVideoContainer.this.bUs.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aWb = new g.InterfaceC0121g() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.InterfaceC0121g
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bUm.start();
                AlaVideoContainer.this.bUk.setVisibility(8);
                AlaVideoContainer.this.bUh.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bUv, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bUw);
            }
        };
        this.bUv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bUi != null) {
                    AlaVideoContainer.this.bUi.startAnimation(AlaVideoContainer.this.bUl);
                }
            }
        };
        this.bSr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.aWc = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.bUw);
                return false;
            }
        };
        this.bSp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ZY();
            }
        };
        this.bUw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bUn.setVisibility(0);
                AlaVideoContainer.this.bUk.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bSp, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bUg = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bUg.getLayoutParams();
        layoutParams.height = (this.bUg.getWidth() * 9) / 16;
        this.bUg.setLayoutParams(layoutParams);
        this.bUr = new n(getContext());
        this.bUr.bhx();
        this.bUg.setBusiness(this.bUr);
        this.bUg.setOnPreparedListener(this.aWb);
        this.bUg.setOnSurfaceDestroyedListener(this.bSr);
        this.bUg.setOnErrorListener(this.aWc);
        this.bUh = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.bUh.setDefaultErrorResource(0);
        this.bUh.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bUh.setEvent(this.bSo);
        this.bUh.setGifIconSupport(false);
        this.bUi = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.bUj = (ImageView) inflate.findViewById(d.g.img_play);
        this.bRR = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.bUk = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.bUl = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bUm = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.bUm.setCertainColumnCount(4);
        this.bUm.setColumnColor(d.C0080d.cp_cont_i);
        this.bUn = inflate.findViewById(d.g.layout_error);
        this.bUo = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.bUp = inflate.findViewById(d.g.layout_live_end);
        this.bUq = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.bTL = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.bUt = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.bUf = new a(this);
        this.bRP = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.C0080d.cp_cont_i);
        }
        if (this.bUu > 0) {
            aj.c(this.bUj, this.bUu);
        } else {
            aj.c(this.bUj, d.f.btn_icon_play_live_on_n);
        }
        aj.i(this.bUo, d.C0080d.cp_cont_i);
        aj.k(this.bUn, d.C0080d.black_alpha80);
        aj.k(this.bUg, d.C0080d.cp_bg_line_k);
        aj.i(this.bUq, d.C0080d.cp_cont_i);
        aj.k(this.bUp, d.C0080d.black_alpha80);
        aj.i(this.bRP, d.C0080d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bUf;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bRP != null) {
            this.bRP.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bUh.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.bUh.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.bUt.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bUt.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bTL.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bUg;
    }

    public void ZY() {
        this.bUh.setVisibility(0);
        this.bUj.setVisibility(0);
        this.bUk.setVisibility(8);
        if (this.bUi != null) {
            this.bUi.clearAnimation();
        }
        this.bUm.bBg();
        this.bUn.setVisibility(8);
        this.bUp.setVisibility(8);
        e.fP().removeCallbacks(this.bUv);
        e.fP().removeCallbacks(this.bSp);
        e.fP().removeCallbacks(this.bUw);
    }

    public void setVideoStatsData(x xVar) {
        if (this.bUr != null) {
            this.bUr.setVideoStatsData(xVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bUs = onClickListener;
    }

    public void ZZ() {
        if (this.bRR != null) {
            this.bRR.ZZ();
        }
    }
}
