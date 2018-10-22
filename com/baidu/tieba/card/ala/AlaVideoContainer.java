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
    private QuickVideoView bJN;
    private TextView bkK;
    private TbImageView.a bkM;
    private g.b bkN;
    private Runnable bkP;
    private QuickVideoView.b bkR;
    private g.f btz;
    private AlaPlayAnimationView cMH;
    private LinearLayout cOr;
    private View cPA;
    private ImageView cPB;
    private FrameLayout cPC;
    private Animation cPD;
    private AudioAnimationView cPE;
    private View cPF;
    private TextView cPG;
    private View cPH;
    private TextView cPI;
    private n cPJ;
    private View.OnClickListener cPK;
    private TextView cPL;
    private int cPM;
    private Runnable cPN;
    private Runnable cPO;
    private a cPy;
    private TbImageView cPz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cPM = -1;
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cPz != null) {
                    AlaVideoContainer.this.cPz.setDefaultBgResource(0);
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
                    if (j.kX()) {
                        if (AlaVideoContainer.this.cPK != null) {
                            AlaVideoContainer.this.cPK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.btz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cPE.start();
                AlaVideoContainer.this.cPC.setVisibility(8);
                AlaVideoContainer.this.cPz.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.cPN, 3000L);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(AlaVideoContainer.this.cPO);
            }
        };
        this.cPN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cPA != null) {
                    AlaVideoContainer.this.cPA.startAnimation(AlaVideoContainer.this.cPD);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.YT();
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jI().post(AlaVideoContainer.this.cPO);
                return false;
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.YT();
            }
        };
        this.cPO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cPF.setVisibility(0);
                AlaVideoContainer.this.cPC.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.bkP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPM = -1;
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cPz != null) {
                    AlaVideoContainer.this.cPz.setDefaultBgResource(0);
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
                    if (j.kX()) {
                        if (AlaVideoContainer.this.cPK != null) {
                            AlaVideoContainer.this.cPK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.btz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cPE.start();
                AlaVideoContainer.this.cPC.setVisibility(8);
                AlaVideoContainer.this.cPz.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.cPN, 3000L);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(AlaVideoContainer.this.cPO);
            }
        };
        this.cPN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cPA != null) {
                    AlaVideoContainer.this.cPA.startAnimation(AlaVideoContainer.this.cPD);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.YT();
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jI().post(AlaVideoContainer.this.cPO);
                return false;
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.YT();
            }
        };
        this.cPO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cPF.setVisibility(0);
                AlaVideoContainer.this.cPC.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.bkP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cPM = -1;
        this.bkM = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && AlaVideoContainer.this.cPz != null) {
                    AlaVideoContainer.this.cPz.setDefaultBgResource(0);
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
                    if (j.kX()) {
                        if (AlaVideoContainer.this.cPK != null) {
                            AlaVideoContainer.this.cPK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.btz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cPE.start();
                AlaVideoContainer.this.cPC.setVisibility(8);
                AlaVideoContainer.this.cPz.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.cPN, 3000L);
                com.baidu.adp.lib.g.e.jI().removeCallbacks(AlaVideoContainer.this.cPO);
            }
        };
        this.cPN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cPA != null) {
                    AlaVideoContainer.this.cPA.startAnimation(AlaVideoContainer.this.cPD);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.YT();
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jI().post(AlaVideoContainer.this.cPO);
                return false;
            }
        };
        this.bkP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.YT();
            }
        };
        this.cPO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cPF.setVisibility(0);
                AlaVideoContainer.this.cPC.setVisibility(8);
                com.baidu.adp.lib.g.e.jI().postDelayed(AlaVideoContainer.this.bkP, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bJN = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bJN.getLayoutParams();
        layoutParams.height = (this.bJN.getWidth() * 9) / 16;
        this.bJN.setLayoutParams(layoutParams);
        this.cPJ = new n(getContext());
        this.cPJ.bqr();
        this.bJN.setBusiness(this.cPJ);
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        this.bJN.setOnErrorListener(this.bkN);
        this.cPz = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.cPz.setDefaultErrorResource(0);
        this.cPz.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cPz.setEvent(this.bkM);
        this.cPz.setGifIconSupport(false);
        this.cPA = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.cPB = (ImageView) inflate.findViewById(e.g.img_play);
        this.cMH = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.cPC = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.cPD = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.cPE = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.cPE.setCertainColumnCount(4);
        this.cPE.setColumnColor(e.d.cp_cont_i);
        this.cPF = inflate.findViewById(e.g.layout_error);
        this.cPG = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.cPH = inflate.findViewById(e.g.layout_live_end);
        this.cPI = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cOr = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.cPL = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.cPy = new a(this);
        this.bkK = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.cPM > 0) {
            al.c(this.cPB, this.cPM);
        } else {
            al.c(this.cPB, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.cPG, e.d.cp_cont_i);
        al.j(this.cPF, e.d.black_alpha80);
        al.j(this.bJN, e.d.cp_bg_line_k);
        al.h(this.cPI, e.d.cp_cont_i);
        al.j(this.cPH, e.d.black_alpha80);
        al.h(this.bkK, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cPy;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bkK != null) {
            this.bkK.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cPz.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cPz.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cPM = i;
        this.cPB.setImageResource(i);
        this.cPB.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cPL.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cPL.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cOr.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bJN;
    }

    public void YT() {
        this.cPz.setVisibility(0);
        this.cPB.setVisibility(0);
        this.cPC.setVisibility(8);
        if (this.cPA != null) {
            this.cPA.clearAnimation();
        }
        this.cPE.pW();
        this.cPF.setVisibility(8);
        this.cPH.setVisibility(8);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cPN);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.bkP);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.cPO);
    }

    public void setVideoStatsData(z zVar) {
        if (this.cPJ != null) {
            this.cPJ.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cPK = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cMH != null) {
            this.cMH.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cMH != null) {
            this.cMH.setAutoStartPlay(z);
        }
    }
}
