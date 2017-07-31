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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private f.d aUM;
    private f.b aUN;
    private TbImageView.a bEd;
    private Runnable bHd;
    private QuickVideoView.b bHf;
    private LinearLayout bID;
    private TextView bIE;
    private a bIR;
    private QuickVideoView bIS;
    private TbImageView bIT;
    private View bIU;
    private ImageView bIV;
    private FrameLayout bIW;
    private Animation bIX;
    private AudioAnimationView bIY;
    private View bIZ;
    private TextView bJa;
    private View bJb;
    private TextView bJc;
    private m bJd;
    private View.OnClickListener bJe;
    private int bJf;
    private Runnable bJg;
    private Runnable bJh;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bJf = -1;
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bIT != null) {
                    AlaVideoContainer.this.bIT.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJe != null) {
                            AlaVideoContainer.this.bJe.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUM = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bIY.start();
                AlaVideoContainer.this.bIW.setVisibility(8);
                AlaVideoContainer.this.bIT.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJg, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJh);
            }
        };
        this.bJg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIU != null) {
                    AlaVideoContainer.this.bIU.startAnimation(AlaVideoContainer.this.bIX);
                }
            }
        };
        this.bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WC();
            }
        };
        this.aUN = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJh);
                return false;
            }
        };
        this.bHd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WC();
            }
        };
        this.bJh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bIZ.setVisibility(0);
                AlaVideoContainer.this.bIW.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHd, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJf = -1;
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bIT != null) {
                    AlaVideoContainer.this.bIT.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJe != null) {
                            AlaVideoContainer.this.bJe.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUM = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bIY.start();
                AlaVideoContainer.this.bIW.setVisibility(8);
                AlaVideoContainer.this.bIT.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJg, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJh);
            }
        };
        this.bJg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIU != null) {
                    AlaVideoContainer.this.bIU.startAnimation(AlaVideoContainer.this.bIX);
                }
            }
        };
        this.bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WC();
            }
        };
        this.aUN = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.ga().post(AlaVideoContainer.this.bJh);
                return false;
            }
        };
        this.bHd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WC();
            }
        };
        this.bJh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bIZ.setVisibility(0);
                AlaVideoContainer.this.bIW.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHd, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJf = -1;
        this.bEd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bIT != null) {
                    AlaVideoContainer.this.bIT.setDefaultBgResource(0);
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
                    if (i.hr()) {
                        if (AlaVideoContainer.this.bJe != null) {
                            AlaVideoContainer.this.bJe.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUM = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bIY.start();
                AlaVideoContainer.this.bIW.setVisibility(8);
                AlaVideoContainer.this.bIT.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bJg, 3000L);
                e.ga().removeCallbacks(AlaVideoContainer.this.bJh);
            }
        };
        this.bJg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bIU != null) {
                    AlaVideoContainer.this.bIU.startAnimation(AlaVideoContainer.this.bIX);
                }
            }
        };
        this.bHf = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.WC();
            }
        };
        this.aUN = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.ga().post(AlaVideoContainer.this.bJh);
                return false;
            }
        };
        this.bHd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.WC();
            }
        };
        this.bJh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bIZ.setVisibility(0);
                AlaVideoContainer.this.bIW.setVisibility(8);
                e.ga().postDelayed(AlaVideoContainer.this.bHd, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bIS = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bIS.getLayoutParams();
        layoutParams.height = (this.bIS.getWidth() * 9) / 16;
        this.bIS.setLayoutParams(layoutParams);
        this.bJd = new m(getContext());
        this.bJd.bfN();
        this.bIS.setBusiness(this.bJd);
        this.bIS.setOnPreparedListener(this.aUM);
        this.bIS.setOnSurfaceDestroyedListener(this.bHf);
        this.bIS.setOnErrorListener(this.aUN);
        this.bIT = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bIT.setDefaultErrorResource(0);
        this.bIT.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIT.setEvent(this.bEd);
        this.bIT.setGifIconSupport(false);
        this.bIU = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bIV = (ImageView) inflate.findViewById(d.h.img_play);
        this.bIW = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bIX = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bIY = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bIY.setCertainColumnCount(4);
        this.bIY.setColumnColor(d.e.cp_cont_i);
        this.bIZ = inflate.findViewById(d.h.layout_error);
        this.bJa = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bJb = inflate.findViewById(d.h.layout_live_end);
        this.bJc = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bID = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bIE = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bIR = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ai.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bJf > 0) {
            ai.c(this.bIV, this.bJf);
        } else {
            ai.c(this.bIV, d.g.btn_icon_play_live);
        }
        ai.i(this.bJa, d.e.cp_cont_i);
        ai.k(this.bIZ, d.e.black_alpha80);
        ai.k(this.bIS, d.e.cp_bg_line_k);
        ai.i(this.bJc, d.e.cp_cont_i);
        ai.k(this.bJb, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bIR;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bIT.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bIT.c(str, 10, false);
    }

    public void aa(int i, int i2) {
        this.bJf = i;
        this.bIV.setImageResource(i);
        this.bIV.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bIE.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bIE.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bID.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bIS;
    }

    public void WC() {
        this.bIT.setVisibility(0);
        this.bIV.setVisibility(0);
        this.bIW.setVisibility(8);
        if (this.bIU != null) {
            this.bIU.clearAnimation();
        }
        this.bIY.bwC();
        this.bIZ.setVisibility(8);
        this.bJb.setVisibility(8);
        e.ga().removeCallbacks(this.bJg);
        e.ga().removeCallbacks(this.bHd);
        e.ga().removeCallbacks(this.bJh);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bJd != null) {
            this.bJd.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bJe = onClickListener;
    }
}
