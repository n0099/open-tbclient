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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.f;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.w;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private f.e aUt;
    private f.b aUu;
    private TbImageView.a bIy;
    private QuickVideoView.b bLA;
    private Runnable bLy;
    private LinearLayout bMW;
    private TextView bMX;
    private Runnable bNA;
    private a bNk;
    private QuickVideoView bNl;
    private TbImageView bNm;
    private View bNn;
    private ImageView bNo;
    private FrameLayout bNp;
    private Animation bNq;
    private AudioAnimationView bNr;
    private View bNs;
    private TextView bNt;
    private View bNu;
    private TextView bNv;
    private m bNw;
    private View.OnClickListener bNx;
    private int bNy;
    private Runnable bNz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bNy = -1;
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bNm != null) {
                    AlaVideoContainer.this.bNm.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bNx != null) {
                            AlaVideoContainer.this.bNx.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUt = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bNr.start();
                AlaVideoContainer.this.bNp.setVisibility(8);
                AlaVideoContainer.this.bNm.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bNz, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bNA);
            }
        };
        this.bNz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.bNq);
                }
            }
        };
        this.bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.aUu = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fQ().post(AlaVideoContainer.this.bNA);
                return false;
            }
        };
        this.bLy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.bNA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bNs.setVisibility(0);
                AlaVideoContainer.this.bNp.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bLy, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNy = -1;
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bNm != null) {
                    AlaVideoContainer.this.bNm.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bNx != null) {
                            AlaVideoContainer.this.bNx.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUt = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bNr.start();
                AlaVideoContainer.this.bNp.setVisibility(8);
                AlaVideoContainer.this.bNm.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bNz, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bNA);
            }
        };
        this.bNz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.bNq);
                }
            }
        };
        this.bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.aUu = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fQ().post(AlaVideoContainer.this.bNA);
                return false;
            }
        };
        this.bLy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.bNA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bNs.setVisibility(0);
                AlaVideoContainer.this.bNp.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bLy, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNy = -1;
        this.bIy = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bNm != null) {
                    AlaVideoContainer.this.bNm.setDefaultBgResource(0);
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
                    if (i.hi()) {
                        if (AlaVideoContainer.this.bNx != null) {
                            AlaVideoContainer.this.bNx.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aUt = new f.e() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.e
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bNr.start();
                AlaVideoContainer.this.bNp.setVisibility(8);
                AlaVideoContainer.this.bNm.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bNz, 3000L);
                e.fQ().removeCallbacks(AlaVideoContainer.this.bNA);
            }
        };
        this.bNz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bNn != null) {
                    AlaVideoContainer.this.bNn.startAnimation(AlaVideoContainer.this.bNq);
                }
            }
        };
        this.bLA = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.aUu = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.fQ().post(AlaVideoContainer.this.bNA);
                return false;
            }
        };
        this.bLy = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Yk();
            }
        };
        this.bNA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bNs.setVisibility(0);
                AlaVideoContainer.this.bNp.setVisibility(8);
                e.fQ().postDelayed(AlaVideoContainer.this.bLy, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bNl = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bNl.getLayoutParams();
        layoutParams.height = (this.bNl.getWidth() * 9) / 16;
        this.bNl.setLayoutParams(layoutParams);
        this.bNw = new m(getContext());
        this.bNw.bfP();
        this.bNl.setBusiness(this.bNw);
        this.bNl.setOnPreparedListener(this.aUt);
        this.bNl.setOnSurfaceDestroyedListener(this.bLA);
        this.bNl.setOnErrorListener(this.aUu);
        this.bNm = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bNm.setDefaultErrorResource(0);
        this.bNm.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bNm.setEvent(this.bIy);
        this.bNm.setGifIconSupport(false);
        this.bNn = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bNo = (ImageView) inflate.findViewById(d.h.img_play);
        this.bNp = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bNq = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bNr = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bNr.setCertainColumnCount(4);
        this.bNr.setColumnColor(d.e.cp_cont_i);
        this.bNs = inflate.findViewById(d.h.layout_error);
        this.bNt = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bNu = inflate.findViewById(d.h.layout_live_end);
        this.bNv = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bMW = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bMX = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bNk = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bNy > 0) {
            aj.c(this.bNo, this.bNy);
        } else {
            aj.c(this.bNo, d.g.btn_icon_play_live);
        }
        aj.i(this.bNt, d.e.cp_cont_i);
        aj.k(this.bNs, d.e.black_alpha80);
        aj.k(this.bNl, d.e.cp_bg_line_k);
        aj.i(this.bNv, d.e.cp_cont_i);
        aj.k(this.bNu, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bNk;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bNm.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bNm.c(str, 10, false);
    }

    public void ad(int i, int i2) {
        this.bNy = i;
        this.bNo.setImageResource(i);
        this.bNo.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bMX.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bMX.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bMW.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bNl;
    }

    public void Yk() {
        this.bNm.setVisibility(0);
        this.bNo.setVisibility(0);
        this.bNp.setVisibility(8);
        if (this.bNn != null) {
            this.bNn.clearAnimation();
        }
        this.bNr.bwE();
        this.bNs.setVisibility(8);
        this.bNu.setVisibility(8);
        e.fQ().removeCallbacks(this.bNz);
        e.fQ().removeCallbacks(this.bLy);
        e.fQ().removeCallbacks(this.bNA);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bNw != null) {
            this.bNw.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bNx = onClickListener;
    }
}
