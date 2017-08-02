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
    private f.d aTA;
    private f.b aTB;
    private TbImageView.a bCT;
    private Runnable bFT;
    private QuickVideoView.b bFV;
    private a bHH;
    private QuickVideoView bHI;
    private TbImageView bHJ;
    private View bHK;
    private ImageView bHL;
    private FrameLayout bHM;
    private Animation bHN;
    private AudioAnimationView bHO;
    private View bHP;
    private TextView bHQ;
    private View bHR;
    private TextView bHS;
    private m bHT;
    private View.OnClickListener bHU;
    private int bHV;
    private Runnable bHW;
    private Runnable bHX;
    private LinearLayout bHt;
    private TextView bHu;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.bHV = -1;
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bHJ != null) {
                    AlaVideoContainer.this.bHJ.setDefaultBgResource(0);
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
                    if (i.hh()) {
                        if (AlaVideoContainer.this.bHU != null) {
                            AlaVideoContainer.this.bHU.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aTA = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bHO.start();
                AlaVideoContainer.this.bHM.setVisibility(8);
                AlaVideoContainer.this.bHJ.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bHW, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bHX);
            }
        };
        this.bHW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bHK != null) {
                    AlaVideoContainer.this.bHK.startAnimation(AlaVideoContainer.this.bHN);
                }
            }
        };
        this.bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.aTB = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bHX);
                return false;
            }
        };
        this.bFT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.bHX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHP.setVisibility(0);
                AlaVideoContainer.this.bHM.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bFT, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHV = -1;
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bHJ != null) {
                    AlaVideoContainer.this.bHJ.setDefaultBgResource(0);
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
                    if (i.hh()) {
                        if (AlaVideoContainer.this.bHU != null) {
                            AlaVideoContainer.this.bHU.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aTA = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bHO.start();
                AlaVideoContainer.this.bHM.setVisibility(8);
                AlaVideoContainer.this.bHJ.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bHW, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bHX);
            }
        };
        this.bHW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bHK != null) {
                    AlaVideoContainer.this.bHK.startAnimation(AlaVideoContainer.this.bHN);
                }
            }
        };
        this.bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.aTB = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.bHX);
                return false;
            }
        };
        this.bFT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.bHX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHP.setVisibility(0);
                AlaVideoContainer.this.bHM.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bFT, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHV = -1;
        this.bCT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void t(String str, boolean z) {
                if (z && AlaVideoContainer.this.bHJ != null) {
                    AlaVideoContainer.this.bHJ.setDefaultBgResource(0);
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
                    if (i.hh()) {
                        if (AlaVideoContainer.this.bHU != null) {
                            AlaVideoContainer.this.bHU.onClick(view);
                            return;
                        }
                        return;
                    }
                    k.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.l.no_network_guide));
                }
            }
        };
        this.aTA = new f.d() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.f.d
            public void onPrepared(f fVar) {
                if (fVar != null) {
                    fVar.setLooping(true);
                    fVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.bHO.start();
                AlaVideoContainer.this.bHM.setVisibility(8);
                AlaVideoContainer.this.bHJ.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bHW, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.bHX);
            }
        };
        this.bHW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bHK != null) {
                    AlaVideoContainer.this.bHK.startAnimation(AlaVideoContainer.this.bHN);
                }
            }
        };
        this.bFV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.aTB = new f.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.f.b
            public boolean onError(f fVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.bHX);
                return false;
            }
        };
        this.bFT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wx();
            }
        };
        this.bHX = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHP.setVisibility(0);
                AlaVideoContainer.this.bHM.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.bFT, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.j.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bHI = (QuickVideoView) inflate.findViewById(d.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.bHI.getLayoutParams();
        layoutParams.height = (this.bHI.getWidth() * 9) / 16;
        this.bHI.setLayoutParams(layoutParams);
        this.bHT = new m(getContext());
        this.bHT.bfD();
        this.bHI.setBusiness(this.bHT);
        this.bHI.setOnPreparedListener(this.aTA);
        this.bHI.setOnSurfaceDestroyedListener(this.bFV);
        this.bHI.setOnErrorListener(this.aTB);
        this.bHJ = (TbImageView) inflate.findViewById(d.h.img_thumbnail);
        this.bHJ.setDefaultErrorResource(0);
        this.bHJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHJ.setEvent(this.bCT);
        this.bHJ.setGifIconSupport(false);
        this.bHK = inflate.findViewById(d.h.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.h.tv_title);
        this.bHL = (ImageView) inflate.findViewById(d.h.img_play);
        this.bHM = (FrameLayout) inflate.findViewById(d.h.layout_loading);
        this.bHN = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.bHO = (AudioAnimationView) inflate.findViewById(d.h.playing_indicator);
        this.bHO.setCertainColumnCount(4);
        this.bHO.setColumnColor(d.e.cp_cont_i);
        this.bHP = inflate.findViewById(d.h.layout_error);
        this.bHQ = (TextView) inflate.findViewById(d.h.video_error_tips);
        this.bHR = inflate.findViewById(d.h.layout_live_end);
        this.bHS = (TextView) inflate.findViewById(d.h.video_live_end_tips);
        this.bHt = (LinearLayout) inflate.findViewById(d.h.llAlaLivingLogLayout);
        this.bHu = (TextView) inflate.findViewById(d.h.tvAlaLivingLogView);
        this.bHH = new a(this);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ai.i(this.mTitle, d.e.cp_cont_i);
        }
        if (this.bHV > 0) {
            ai.c(this.bHL, this.bHV);
        } else {
            ai.c(this.bHL, d.g.btn_icon_play_live);
        }
        ai.i(this.bHQ, d.e.cp_cont_i);
        ai.k(this.bHP, d.e.black_alpha80);
        ai.k(this.bHI, d.e.cp_bg_line_k);
        ai.i(this.bHS, d.e.cp_cont_i);
        ai.k(this.bHR, d.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.bHH;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.bHJ.setDefaultBgResource(d.g.pic_bg_video_frs);
        this.bHJ.c(str, 10, false);
    }

    public void Z(int i, int i2) {
        this.bHV = i;
        this.bHL.setImageResource(i);
        this.bHL.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.bHu.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.bHu.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.bHt.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bHI;
    }

    public void Wx() {
        this.bHJ.setVisibility(0);
        this.bHL.setVisibility(0);
        this.bHM.setVisibility(8);
        if (this.bHK != null) {
            this.bHK.clearAnimation();
        }
        this.bHO.bwv();
        this.bHP.setVisibility(8);
        this.bHR.setVisibility(8);
        e.fP().removeCallbacks(this.bHW);
        e.fP().removeCallbacks(this.bFT);
        e.fP().removeCallbacks(this.bHX);
    }

    public void setVideoStatsData(w wVar) {
        if (this.bHT != null) {
            this.bHT.setVideoStatsData(wVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.bHU = onClickListener;
    }
}
