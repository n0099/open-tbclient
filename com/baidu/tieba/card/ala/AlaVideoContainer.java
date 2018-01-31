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
    private g.f bNv;
    private g.b bNw;
    private QuickVideoView bYP;
    private QuickVideoView.b bYW;
    private TextView cTH;
    private AlaPlayAnimationView cTJ;
    private TbImageView.a cUf;
    private Runnable cUg;
    private LinearLayout cVK;
    private a cWF;
    private TbImageView cWG;
    private View cWH;
    private ImageView cWI;
    private FrameLayout cWJ;
    private Animation cWK;
    private AudioAnimationView cWL;
    private View cWM;
    private TextView cWN;
    private View cWO;
    private TextView cWP;
    private n cWQ;
    private View.OnClickListener cWR;
    private TextView cWS;
    private int cWT;
    private Runnable cWU;
    private Runnable cWV;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cWT = -1;
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWG != null) {
                    AlaVideoContainer.this.cWG.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWR != null) {
                            AlaVideoContainer.this.cWR.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNv = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWL.start();
                AlaVideoContainer.this.cWJ.setVisibility(8);
                AlaVideoContainer.this.cWG.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWU, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cWV);
            }
        };
        this.cWU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWH != null) {
                    AlaVideoContainer.this.cWH.startAnimation(AlaVideoContainer.this.cWK);
                }
            }
        };
        this.bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.bNw = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cWV);
                return false;
            }
        };
        this.cUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.cWV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWM.setVisibility(0);
                AlaVideoContainer.this.cWJ.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cUg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWT = -1;
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWG != null) {
                    AlaVideoContainer.this.cWG.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWR != null) {
                            AlaVideoContainer.this.cWR.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNv = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWL.start();
                AlaVideoContainer.this.cWJ.setVisibility(8);
                AlaVideoContainer.this.cWG.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWU, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cWV);
            }
        };
        this.cWU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWH != null) {
                    AlaVideoContainer.this.cWH.startAnimation(AlaVideoContainer.this.cWK);
                }
            }
        };
        this.bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.bNw = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ns().post(AlaVideoContainer.this.cWV);
                return false;
            }
        };
        this.cUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.cWV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWM.setVisibility(0);
                AlaVideoContainer.this.cWJ.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cUg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWT = -1;
        this.cUf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWG != null) {
                    AlaVideoContainer.this.cWG.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWR != null) {
                            AlaVideoContainer.this.cWR.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNv = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWL.start();
                AlaVideoContainer.this.cWJ.setVisibility(8);
                AlaVideoContainer.this.cWG.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cWU, 3000L);
                e.ns().removeCallbacks(AlaVideoContainer.this.cWV);
            }
        };
        this.cWU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWH != null) {
                    AlaVideoContainer.this.cWH.startAnimation(AlaVideoContainer.this.cWK);
                }
            }
        };
        this.bYW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.bNw = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ns().post(AlaVideoContainer.this.cWV);
                return false;
            }
        };
        this.cUg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wf();
            }
        };
        this.cWV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWM.setVisibility(0);
                AlaVideoContainer.this.cWJ.setVisibility(8);
                e.ns().postDelayed(AlaVideoContainer.this.cUg, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bYP = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bYP.getLayoutParams();
        layoutParams.height = (this.bYP.getWidth() * 9) / 16;
        this.bYP.setLayoutParams(layoutParams);
        this.cWQ = new n(getContext());
        this.cWQ.bkl();
        this.bYP.setBusiness(this.cWQ);
        this.bYP.setOnPreparedListener(this.bNv);
        this.bYP.setOnSurfaceDestroyedListener(this.bYW);
        this.bYP.setOnErrorListener(this.bNw);
        this.cWG = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cWG.setDefaultErrorResource(0);
        this.cWG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWG.setEvent(this.cUf);
        this.cWG.setGifIconSupport(false);
        this.cWH = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cWI = (ImageView) inflate.findViewById(d.g.img_play);
        this.cTJ = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cWJ = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cWK = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cWL = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cWL.setCertainColumnCount(4);
        this.cWL.setColumnColor(d.C0108d.cp_cont_i);
        this.cWM = inflate.findViewById(d.g.layout_error);
        this.cWN = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cWO = inflate.findViewById(d.g.layout_live_end);
        this.cWP = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cVK = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cWS = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cWF = new a(this);
        this.cTH = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0108d.cp_cont_i);
        }
        if (this.cWT > 0) {
            aj.c(this.cWI, this.cWT);
        } else {
            aj.c(this.cWI, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cWN, d.C0108d.cp_cont_i);
        aj.t(this.cWM, d.C0108d.black_alpha80);
        aj.t(this.bYP, d.C0108d.cp_bg_line_k);
        aj.r(this.cWP, d.C0108d.cp_cont_i);
        aj.t(this.cWO, d.C0108d.black_alpha80);
        aj.r(this.cTH, d.C0108d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cWF;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cTH != null) {
            this.cTH.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cWG.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWG.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cWS.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cWS.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cVK.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bYP;
    }

    public void Wf() {
        this.cWG.setVisibility(0);
        this.cWI.setVisibility(0);
        this.cWJ.setVisibility(8);
        if (this.cWH != null) {
            this.cWH.clearAnimation();
        }
        this.cWL.to();
        this.cWM.setVisibility(8);
        this.cWO.setVisibility(8);
        e.ns().removeCallbacks(this.cWU);
        e.ns().removeCallbacks(this.cUg);
        e.ns().removeCallbacks(this.cWV);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cWQ != null) {
            this.cWQ.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cWR = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cTJ != null) {
            this.cTJ.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cTJ != null) {
            this.cTJ.setAutoStartPlay(z);
        }
    }
}
