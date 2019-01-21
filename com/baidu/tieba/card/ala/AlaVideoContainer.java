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
    private QuickVideoView bPc;
    private TextView bpL;
    private TbImageView.a bpN;
    private g.b bpO;
    private Runnable bpQ;
    private QuickVideoView.b bpS;
    private g.f byB;
    private AlaPlayAnimationView cXW;
    private LinearLayout cZG;
    private a daP;
    private TbImageView daQ;
    private View daR;
    private ImageView daS;
    private FrameLayout daT;
    private Animation daU;
    private AudioAnimationView daV;
    private View daW;
    private TextView daX;
    private View daY;
    private TextView daZ;
    private n dba;
    private View.OnClickListener dbb;
    private TextView dbc;
    private int dbd;
    private Runnable dbe;
    private Runnable dbf;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.dbd = -1;
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dbb != null) {
                            AlaVideoContainer.this.dbb.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byB = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daV.start();
                AlaVideoContainer.this.daT.setVisibility(8);
                AlaVideoContainer.this.daQ.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbe, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbf);
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daR != null) {
                    AlaVideoContainer.this.daR.startAnimation(AlaVideoContainer.this.daU);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbf);
                return false;
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daW.setVisibility(0);
                AlaVideoContainer.this.daT.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpQ, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbd = -1;
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dbb != null) {
                            AlaVideoContainer.this.dbb.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byB = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daV.start();
                AlaVideoContainer.this.daT.setVisibility(8);
                AlaVideoContainer.this.daQ.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbe, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbf);
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daR != null) {
                    AlaVideoContainer.this.daR.startAnimation(AlaVideoContainer.this.daU);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbf);
                return false;
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daW.setVisibility(0);
                AlaVideoContainer.this.daT.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpQ, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbd = -1;
        this.bpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.daQ != null) {
                    AlaVideoContainer.this.daQ.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dbb != null) {
                            AlaVideoContainer.this.dbb.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.byB = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.daV.start();
                AlaVideoContainer.this.daT.setVisibility(8);
                AlaVideoContainer.this.daQ.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.dbe, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dbf);
            }
        };
        this.dbe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.daR != null) {
                    AlaVideoContainer.this.daR.startAnimation(AlaVideoContainer.this.daU);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dbf);
                return false;
            }
        };
        this.bpQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aaI();
            }
        };
        this.dbf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.daW.setVisibility(0);
                AlaVideoContainer.this.daT.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpQ, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bPc = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bPc.getLayoutParams();
        layoutParams.height = (this.bPc.getWidth() * 9) / 16;
        this.bPc.setLayoutParams(layoutParams);
        this.dba = new n(getContext());
        this.dba.bta();
        this.bPc.setBusiness(this.dba);
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        this.bPc.setOnErrorListener(this.bpO);
        this.daQ = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.daQ.setDefaultErrorResource(0);
        this.daQ.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.daQ.setEvent(this.bpN);
        this.daQ.setGifIconSupport(false);
        this.daR = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.daS = (ImageView) inflate.findViewById(e.g.img_play);
        this.cXW = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.daT = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.daU = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.daV = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.daV.setCertainColumnCount(4);
        this.daV.setColumnColor(e.d.cp_cont_i);
        this.daW = inflate.findViewById(e.g.layout_error);
        this.daX = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.daY = inflate.findViewById(e.g.layout_live_end);
        this.daZ = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cZG = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.dbc = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.daP = new a(this);
        this.bpL = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.dbd > 0) {
            al.c(this.daS, this.dbd);
        } else {
            al.c(this.daS, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.daX, e.d.cp_cont_i);
        al.j(this.daW, e.d.black_alpha80);
        al.j(this.bPc, e.d.cp_bg_line_k);
        al.h(this.daZ, e.d.cp_cont_i);
        al.j(this.daY, e.d.black_alpha80);
        al.h(this.bpL, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.daP;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bpL != null) {
            this.bpL.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.daQ.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.daQ.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.dbd = i;
        this.daS.setImageResource(i);
        this.daS.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.dbc.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.dbc.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cZG.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bPc;
    }

    public void aaI() {
        this.daQ.setVisibility(0);
        this.daS.setVisibility(0);
        this.daT.setVisibility(8);
        if (this.daR != null) {
            this.daR.clearAnimation();
        }
        this.daV.pX();
        this.daW.setVisibility(8);
        this.daY.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dbe);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpQ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dbf);
    }

    public void setVideoStatsData(z zVar) {
        if (this.dba != null) {
            this.dba.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.dbb = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cXW != null) {
            this.cXW.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cXW != null) {
            this.cXW.setAutoStartPlay(z);
        }
    }
}
