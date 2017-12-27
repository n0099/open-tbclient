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
    private g.f bNf;
    private g.b bNg;
    private QuickVideoView bYA;
    private QuickVideoView.b bYH;
    private TextView cOL;
    private AlaPlayAnimationView cON;
    private TbImageView.a cPj;
    private Runnable cPk;
    private LinearLayout cQN;
    private a cRI;
    private TbImageView cRJ;
    private View cRK;
    private ImageView cRL;
    private FrameLayout cRM;
    private Animation cRN;
    private AudioAnimationView cRO;
    private View cRP;
    private TextView cRQ;
    private View cRR;
    private TextView cRS;
    private n cRT;
    private View.OnClickListener cRU;
    private TextView cRV;
    private int cRW;
    private Runnable cRX;
    private Runnable cRY;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cRW = -1;
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cRJ != null) {
                    AlaVideoContainer.this.cRJ.setDefaultBgResource(0);
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
                    if (j.oI()) {
                        if (AlaVideoContainer.this.cRU != null) {
                            AlaVideoContainer.this.cRU.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNf = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cRO.start();
                AlaVideoContainer.this.cRM.setVisibility(8);
                AlaVideoContainer.this.cRJ.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cRX, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cRY);
            }
        };
        this.cRX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cRK != null) {
                    AlaVideoContainer.this.cRK.startAnimation(AlaVideoContainer.this.cRN);
                }
            }
        };
        this.bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.bNg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.nr().post(AlaVideoContainer.this.cRY);
                return false;
            }
        };
        this.cPk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.cRY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cRP.setVisibility(0);
                AlaVideoContainer.this.cRM.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cPk, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRW = -1;
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cRJ != null) {
                    AlaVideoContainer.this.cRJ.setDefaultBgResource(0);
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
                    if (j.oI()) {
                        if (AlaVideoContainer.this.cRU != null) {
                            AlaVideoContainer.this.cRU.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNf = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cRO.start();
                AlaVideoContainer.this.cRM.setVisibility(8);
                AlaVideoContainer.this.cRJ.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cRX, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cRY);
            }
        };
        this.cRX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cRK != null) {
                    AlaVideoContainer.this.cRK.startAnimation(AlaVideoContainer.this.cRN);
                }
            }
        };
        this.bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.bNg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.nr().post(AlaVideoContainer.this.cRY);
                return false;
            }
        };
        this.cPk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.cRY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cRP.setVisibility(0);
                AlaVideoContainer.this.cRM.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cPk, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cRW = -1;
        this.cPj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cRJ != null) {
                    AlaVideoContainer.this.cRJ.setDefaultBgResource(0);
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
                    if (j.oI()) {
                        if (AlaVideoContainer.this.cRU != null) {
                            AlaVideoContainer.this.cRU.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNf = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cRO.start();
                AlaVideoContainer.this.cRM.setVisibility(8);
                AlaVideoContainer.this.cRJ.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cRX, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cRY);
            }
        };
        this.cRX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cRK != null) {
                    AlaVideoContainer.this.cRK.startAnimation(AlaVideoContainer.this.cRN);
                }
            }
        };
        this.bYH = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.bNg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.nr().post(AlaVideoContainer.this.cRY);
                return false;
            }
        };
        this.cPk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wp();
            }
        };
        this.cRY = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cRP.setVisibility(0);
                AlaVideoContainer.this.cRM.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cPk, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bYA = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bYA.getLayoutParams();
        layoutParams.height = (this.bYA.getWidth() * 9) / 16;
        this.bYA.setLayoutParams(layoutParams);
        this.cRT = new n(getContext());
        this.cRT.bqR();
        this.bYA.setBusiness(this.cRT);
        this.bYA.setOnPreparedListener(this.bNf);
        this.bYA.setOnSurfaceDestroyedListener(this.bYH);
        this.bYA.setOnErrorListener(this.bNg);
        this.cRJ = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cRJ.setDefaultErrorResource(0);
        this.cRJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cRJ.setEvent(this.cPj);
        this.cRJ.setGifIconSupport(false);
        this.cRK = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cRL = (ImageView) inflate.findViewById(d.g.img_play);
        this.cON = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cRM = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cRN = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cRO = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cRO.setCertainColumnCount(4);
        this.cRO.setColumnColor(d.C0108d.cp_cont_i);
        this.cRP = inflate.findViewById(d.g.layout_error);
        this.cRQ = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cRR = inflate.findViewById(d.g.layout_live_end);
        this.cRS = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cQN = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cRV = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cRI = new a(this);
        this.cOL = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0108d.cp_cont_i);
        }
        if (this.cRW > 0) {
            aj.c(this.cRL, this.cRW);
        } else {
            aj.c(this.cRL, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cRQ, d.C0108d.cp_cont_i);
        aj.t(this.cRP, d.C0108d.black_alpha80);
        aj.t(this.bYA, d.C0108d.cp_bg_line_k);
        aj.r(this.cRS, d.C0108d.cp_cont_i);
        aj.t(this.cRR, d.C0108d.black_alpha80);
        aj.r(this.cOL, d.C0108d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cRI;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cOL != null) {
            this.cOL.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cRJ.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cRJ.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cRV.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cRV.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cQN.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bYA;
    }

    public void Wp() {
        this.cRJ.setVisibility(0);
        this.cRL.setVisibility(0);
        this.cRM.setVisibility(8);
        if (this.cRK != null) {
            this.cRK.clearAnimation();
        }
        this.cRO.tn();
        this.cRP.setVisibility(8);
        this.cRR.setVisibility(8);
        e.nr().removeCallbacks(this.cRX);
        e.nr().removeCallbacks(this.cPk);
        e.nr().removeCallbacks(this.cRY);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cRT != null) {
            this.cRT.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cRU = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cON != null) {
            this.cON.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cON != null) {
            this.cON.setAutoStartPlay(z);
        }
    }
}
