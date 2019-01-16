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
    private QuickVideoView bPb;
    private TextView bpK;
    private TbImageView.a bpM;
    private g.b bpN;
    private Runnable bpP;
    private QuickVideoView.b bpR;
    private g.f byA;
    private AlaPlayAnimationView cXV;
    private LinearLayout cZF;
    private a daO;
    private TbImageView daP;
    private View daQ;
    private ImageView daR;
    private FrameLayout daS;
    private Animation daT;
    private AudioAnimationView daU;
    private View daV;
    private TextView daW;
    private View daX;
    private TextView daY;
    private n daZ;
    private View.OnClickListener dba;
    private TextView dbb;
    private int dbc;
    private Runnable dbd;
    private Runnable dbe;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.dbc = -1;
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daP != null) {
                    AlaVideoContainer.this.daP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dba != null) {
                            AlaVideoContainer.this.dba.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byA = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daU.start();
                AlaVideoContainer.this.daS.setVisibility(8);
                AlaVideoContainer.this.daP.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbd, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbe);
            }
        };
        this.dbd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.startAnimation(AlaVideoContainer.this.daT);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbe);
                return false;
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daV.setVisibility(0);
                AlaVideoContainer.this.daS.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbc = -1;
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daP != null) {
                    AlaVideoContainer.this.daP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dba != null) {
                            AlaVideoContainer.this.dba.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byA = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daU.start();
                AlaVideoContainer.this.daS.setVisibility(8);
                AlaVideoContainer.this.daP.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbd, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbe);
            }
        };
        this.dbd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.startAnimation(AlaVideoContainer.this.daT);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbe);
                return false;
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daV.setVisibility(0);
                AlaVideoContainer.this.daS.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbc = -1;
        this.bpM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daP != null) {
                    AlaVideoContainer.this.daP.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dba != null) {
                            AlaVideoContainer.this.dba.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byA = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daU.start();
                AlaVideoContainer.this.daS.setVisibility(8);
                AlaVideoContainer.this.daP.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbd, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbe);
            }
        };
        this.dbd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.startAnimation(AlaVideoContainer.this.daT);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbe);
                return false;
            }
        };
        this.bpP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daV.setVisibility(0);
                AlaVideoContainer.this.daS.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bPb = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bPb.getLayoutParams();
        layoutParams.height = (this.bPb.getWidth() * 9) / 16;
        this.bPb.setLayoutParams(layoutParams);
        this.daZ = new n(getContext());
        this.daZ.bta();
        this.bPb.setBusiness(this.daZ);
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        this.bPb.setOnErrorListener(this.bpN);
        this.daP = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.daP.setDefaultErrorResource(0);
        this.daP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.daP.setEvent(this.bpM);
        this.daP.setGifIconSupport(false);
        this.daQ = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.daR = (ImageView) inflate.findViewById(e.g.img_play);
        this.cXV = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.daS = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.daT = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.daU = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.daU.setCertainColumnCount(4);
        this.daU.setColumnColor(e.d.cp_cont_i);
        this.daV = inflate.findViewById(e.g.layout_error);
        this.daW = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.daX = inflate.findViewById(e.g.layout_live_end);
        this.daY = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cZF = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.dbb = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.daO = new a(this);
        this.bpK = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.dbc > 0) {
            al.c(this.daR, this.dbc);
        } else {
            al.c(this.daR, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.daW, e.d.cp_cont_i);
        al.j(this.daV, e.d.black_alpha80);
        al.j(this.bPb, e.d.cp_bg_line_k);
        al.h(this.daY, e.d.cp_cont_i);
        al.j(this.daX, e.d.black_alpha80);
        al.h(this.bpK, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.daO;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bpK != null) {
            this.bpK.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.daP.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.daP.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.dbc = i;
        this.daR.setImageResource(i);
        this.daR.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.dbb.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.dbb.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cZF.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bPb;
    }

    public void aaI() {
        this.daP.setVisibility(0);
        this.daR.setVisibility(0);
        this.daS.setVisibility(8);
        if (this.daQ != null) {
            this.daQ.clearAnimation();
        }
        this.daU.pX();
        this.daV.setVisibility(8);
        this.daX.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dbd);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpP);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dbe);
    }

    public void setVideoStatsData(z zVar) {
        if (this.daZ != null) {
            this.daZ.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.dba = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cXV != null) {
            this.cXV.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cXV != null) {
            this.cXV.setAutoStartPlay(z);
        }
    }
}
