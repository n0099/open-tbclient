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
    private QuickVideoView bKy;
    private Runnable blA;
    private QuickVideoView.b blC;
    private TextView blv;
    private TbImageView.a blx;
    private g.b bly;
    private g.f bum;
    private AlaPlayAnimationView cNN;
    private LinearLayout cPx;
    private a cQE;
    private TbImageView cQF;
    private View cQG;
    private ImageView cQH;
    private FrameLayout cQI;
    private Animation cQJ;
    private AudioAnimationView cQK;
    private View cQL;
    private TextView cQM;
    private View cQN;
    private TextView cQO;
    private n cQP;
    private View.OnClickListener cQQ;
    private TextView cQR;
    private int cQS;
    private Runnable cQT;
    private Runnable cQU;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cQS = -1;
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cQF != null) {
                    AlaVideoContainer.this.cQF.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cQQ != null) {
                            AlaVideoContainer.this.cQQ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bum = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cQK.start();
                AlaVideoContainer.this.cQI.setVisibility(8);
                AlaVideoContainer.this.cQF.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cQT, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cQU);
            }
        };
        this.cQT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cQG != null) {
                    AlaVideoContainer.this.cQG.startAnimation(AlaVideoContainer.this.cQJ);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cQU);
                return false;
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.cQU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cQL.setVisibility(0);
                AlaVideoContainer.this.cQI.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.blA, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cQS = -1;
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cQF != null) {
                    AlaVideoContainer.this.cQF.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cQQ != null) {
                            AlaVideoContainer.this.cQQ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bum = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cQK.start();
                AlaVideoContainer.this.cQI.setVisibility(8);
                AlaVideoContainer.this.cQF.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cQT, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cQU);
            }
        };
        this.cQT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cQG != null) {
                    AlaVideoContainer.this.cQG.startAnimation(AlaVideoContainer.this.cQJ);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cQU);
                return false;
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.cQU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cQL.setVisibility(0);
                AlaVideoContainer.this.cQI.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.blA, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cQS = -1;
        this.blx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cQF != null) {
                    AlaVideoContainer.this.cQF.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cQQ != null) {
                            AlaVideoContainer.this.cQQ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bum = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cQK.start();
                AlaVideoContainer.this.cQI.setVisibility(8);
                AlaVideoContainer.this.cQF.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.cQT, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.cQU);
            }
        };
        this.cQT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cQG != null) {
                    AlaVideoContainer.this.cQG.startAnimation(AlaVideoContainer.this.cQJ);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.cQU);
                return false;
            }
        };
        this.blA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Zd();
            }
        };
        this.cQU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cQL.setVisibility(0);
                AlaVideoContainer.this.cQI.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.blA, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bKy = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bKy.getLayoutParams();
        layoutParams.height = (this.bKy.getWidth() * 9) / 16;
        this.bKy.setLayoutParams(layoutParams);
        this.cQP = new n(getContext());
        this.cQP.bpN();
        this.bKy.setBusiness(this.cQP);
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        this.bKy.setOnErrorListener(this.bly);
        this.cQF = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.cQF.setDefaultErrorResource(0);
        this.cQF.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cQF.setEvent(this.blx);
        this.cQF.setGifIconSupport(false);
        this.cQG = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.cQH = (ImageView) inflate.findViewById(e.g.img_play);
        this.cNN = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.cQI = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.cQJ = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.cQK = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.cQK.setCertainColumnCount(4);
        this.cQK.setColumnColor(e.d.cp_cont_i);
        this.cQL = inflate.findViewById(e.g.layout_error);
        this.cQM = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.cQN = inflate.findViewById(e.g.layout_live_end);
        this.cQO = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cPx = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.cQR = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.cQE = new a(this);
        this.blv = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.cQS > 0) {
            al.c(this.cQH, this.cQS);
        } else {
            al.c(this.cQH, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.cQM, e.d.cp_cont_i);
        al.j(this.cQL, e.d.black_alpha80);
        al.j(this.bKy, e.d.cp_bg_line_k);
        al.h(this.cQO, e.d.cp_cont_i);
        al.j(this.cQN, e.d.black_alpha80);
        al.h(this.blv, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cQE;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.blv != null) {
            this.blv.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cQF.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cQF.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cQS = i;
        this.cQH.setImageResource(i);
        this.cQH.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cQR.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cQR.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cPx.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bKy;
    }

    public void Zd() {
        this.cQF.setVisibility(0);
        this.cQH.setVisibility(0);
        this.cQI.setVisibility(8);
        if (this.cQG != null) {
            this.cQG.clearAnimation();
        }
        this.cQK.pU();
        this.cQL.setVisibility(8);
        this.cQN.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cQT);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.blA);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.cQU);
    }

    public void setVideoStatsData(z zVar) {
        if (this.cQP != null) {
            this.cQP.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cQQ = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cNN != null) {
            this.cNN.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cNN != null) {
            this.cNN.setAutoStartPlay(z);
        }
    }
}
