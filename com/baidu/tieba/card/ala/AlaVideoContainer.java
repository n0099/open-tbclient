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
    private QuickVideoView bOq;
    private TextView boW;
    private TbImageView.a boY;
    private g.b boZ;
    private Runnable bpb;
    private QuickVideoView.b bpd;
    private g.f bxM;
    private AlaPlayAnimationView cXk;
    private LinearLayout cYU;
    private a dab;
    private TbImageView dac;
    private View dad;
    private ImageView dae;
    private FrameLayout daf;
    private Animation dag;
    private AudioAnimationView dah;
    private View dai;
    private TextView daj;
    private View dak;
    private TextView dal;
    private n dam;
    private View.OnClickListener dan;
    private TextView dao;
    private int dap;
    private Runnable daq;
    private Runnable dar;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.dap = -1;
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.dac != null) {
                    AlaVideoContainer.this.dac.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dan != null) {
                            AlaVideoContainer.this.dan.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.dah.start();
                AlaVideoContainer.this.daf.setVisibility(8);
                AlaVideoContainer.this.dac.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.daq, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dar);
            }
        };
        this.daq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.dad != null) {
                    AlaVideoContainer.this.dad.startAnimation(AlaVideoContainer.this.dag);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aal();
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dar);
                return false;
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aal();
            }
        };
        this.dar = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.dai.setVisibility(0);
                AlaVideoContainer.this.daf.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpb, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dap = -1;
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.dac != null) {
                    AlaVideoContainer.this.dac.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dan != null) {
                            AlaVideoContainer.this.dan.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.dah.start();
                AlaVideoContainer.this.daf.setVisibility(8);
                AlaVideoContainer.this.dac.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.daq, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dar);
            }
        };
        this.daq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.dad != null) {
                    AlaVideoContainer.this.dad.startAnimation(AlaVideoContainer.this.dag);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aal();
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dar);
                return false;
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aal();
            }
        };
        this.dar = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.dai.setVisibility(0);
                AlaVideoContainer.this.daf.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpb, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dap = -1;
        this.boY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z && AlaVideoContainer.this.dac != null) {
                    AlaVideoContainer.this.dac.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.dan != null) {
                            AlaVideoContainer.this.dan.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.dah.start();
                AlaVideoContainer.this.daf.setVisibility(8);
                AlaVideoContainer.this.dac.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.daq, 3000L);
                com.baidu.adp.lib.g.e.jG().removeCallbacks(AlaVideoContainer.this.dar);
            }
        };
        this.daq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.dad != null) {
                    AlaVideoContainer.this.dad.startAnimation(AlaVideoContainer.this.dag);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aal();
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jG().post(AlaVideoContainer.this.dar);
                return false;
            }
        };
        this.bpb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aal();
            }
        };
        this.dar = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.dai.setVisibility(0);
                AlaVideoContainer.this.daf.setVisibility(8);
                com.baidu.adp.lib.g.e.jG().postDelayed(AlaVideoContainer.this.bpb, SystemScreenshotManager.DELAY_TIME);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bOq = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bOq.getLayoutParams();
        layoutParams.height = (this.bOq.getWidth() * 9) / 16;
        this.bOq.setLayoutParams(layoutParams);
        this.dam = new n(getContext());
        this.dam.bsr();
        this.bOq.setBusiness(this.dam);
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        this.bOq.setOnErrorListener(this.boZ);
        this.dac = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.dac.setDefaultErrorResource(0);
        this.dac.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.dac.setEvent(this.boY);
        this.dac.setGifIconSupport(false);
        this.dad = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.dae = (ImageView) inflate.findViewById(e.g.img_play);
        this.cXk = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.daf = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.dag = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.dah = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.dah.setCertainColumnCount(4);
        this.dah.setColumnColor(e.d.cp_cont_i);
        this.dai = inflate.findViewById(e.g.layout_error);
        this.daj = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.dak = inflate.findViewById(e.g.layout_live_end);
        this.dal = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cYU = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.dao = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.dab = new a(this);
        this.boW = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.dap > 0) {
            al.c(this.dae, this.dap);
        } else {
            al.c(this.dae, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.daj, e.d.cp_cont_i);
        al.j(this.dai, e.d.black_alpha80);
        al.j(this.bOq, e.d.cp_bg_line_k);
        al.h(this.dal, e.d.cp_cont_i);
        al.j(this.dak, e.d.black_alpha80);
        al.h(this.boW, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.dab;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.boW != null) {
            this.boW.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.dac.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.dac.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.dap = i;
        this.dae.setImageResource(i);
        this.dae.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.dao.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.dao.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cYU.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bOq;
    }

    public void aal() {
        this.dac.setVisibility(0);
        this.dae.setVisibility(0);
        this.daf.setVisibility(8);
        if (this.dad != null) {
            this.dad.clearAnimation();
        }
        this.dah.pT();
        this.dai.setVisibility(8);
        this.dak.setVisibility(8);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.daq);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.bpb);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dar);
    }

    public void setVideoStatsData(z zVar) {
        if (this.dam != null) {
            this.dam.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.dan = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cXk != null) {
            this.cXk.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cXk != null) {
            this.cXk.setAutoStartPlay(z);
        }
    }
}
