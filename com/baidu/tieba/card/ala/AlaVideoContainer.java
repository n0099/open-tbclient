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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes2.dex */
public class AlaVideoContainer extends LinearLayout {
    private QuickVideoView bBg;
    private Runnable bgA;
    private QuickVideoView.b bgC;
    private TextView bgv;
    private TbImageView.a bgx;
    private g.b bgy;
    private g.f bpy;
    private AlaPlayAnimationView cEn;
    private LinearLayout cFX;
    private a cHe;
    private TbImageView cHf;
    private View cHg;
    private ImageView cHh;
    private FrameLayout cHi;
    private Animation cHj;
    private AudioAnimationView cHk;
    private View cHl;
    private TextView cHm;
    private View cHn;
    private TextView cHo;
    private n cHp;
    private View.OnClickListener cHq;
    private TextView cHr;
    private int cHs;
    private Runnable cHt;
    private Runnable cHu;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cHs = -1;
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && AlaVideoContainer.this.cHf != null) {
                    AlaVideoContainer.this.cHf.setDefaultBgResource(0);
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
                    if (j.kK()) {
                        if (AlaVideoContainer.this.cHq != null) {
                            AlaVideoContainer.this.cHq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bpy = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cHk.start();
                AlaVideoContainer.this.cHi.setVisibility(8);
                AlaVideoContainer.this.cHf.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.cHt, 3000L);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(AlaVideoContainer.this.cHu);
            }
        };
        this.cHt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cHg != null) {
                    AlaVideoContainer.this.cHg.startAnimation(AlaVideoContainer.this.cHj);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jt().post(AlaVideoContainer.this.cHu);
                return false;
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.cHu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cHl.setVisibility(0);
                AlaVideoContainer.this.cHi.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.bgA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cHs = -1;
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && AlaVideoContainer.this.cHf != null) {
                    AlaVideoContainer.this.cHf.setDefaultBgResource(0);
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
                    if (j.kK()) {
                        if (AlaVideoContainer.this.cHq != null) {
                            AlaVideoContainer.this.cHq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bpy = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cHk.start();
                AlaVideoContainer.this.cHi.setVisibility(8);
                AlaVideoContainer.this.cHf.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.cHt, 3000L);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(AlaVideoContainer.this.cHu);
            }
        };
        this.cHt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cHg != null) {
                    AlaVideoContainer.this.cHg.startAnimation(AlaVideoContainer.this.cHj);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                com.baidu.adp.lib.g.e.jt().post(AlaVideoContainer.this.cHu);
                return false;
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.cHu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cHl.setVisibility(0);
                AlaVideoContainer.this.cHi.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.bgA, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cHs = -1;
        this.bgx = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z && AlaVideoContainer.this.cHf != null) {
                    AlaVideoContainer.this.cHf.setDefaultBgResource(0);
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
                    if (j.kK()) {
                        if (AlaVideoContainer.this.cHq != null) {
                            AlaVideoContainer.this.cHq.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(e.j.no_network_guide));
                }
            }
        };
        this.bpy = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cHk.start();
                AlaVideoContainer.this.cHi.setVisibility(8);
                AlaVideoContainer.this.cHf.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.cHt, 3000L);
                com.baidu.adp.lib.g.e.jt().removeCallbacks(AlaVideoContainer.this.cHu);
            }
        };
        this.cHt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cHg != null) {
                    AlaVideoContainer.this.cHg.startAnimation(AlaVideoContainer.this.cHj);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                com.baidu.adp.lib.g.e.jt().post(AlaVideoContainer.this.cHu);
                return false;
            }
        };
        this.bgA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Vl();
            }
        };
        this.cHu = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cHl.setVisibility(0);
                AlaVideoContainer.this.cHi.setVisibility(8);
                com.baidu.adp.lib.g.e.jt().postDelayed(AlaVideoContainer.this.bgA, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(e.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bBg = (QuickVideoView) inflate.findViewById(e.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bBg.getLayoutParams();
        layoutParams.height = (this.bBg.getWidth() * 9) / 16;
        this.bBg.setLayoutParams(layoutParams);
        this.cHp = new n(getContext());
        this.cHp.bnc();
        this.bBg.setBusiness(this.cHp);
        this.bBg.setOnPreparedListener(this.bpy);
        this.bBg.setOnSurfaceDestroyedListener(this.bgC);
        this.bBg.setOnErrorListener(this.bgy);
        this.cHf = (TbImageView) inflate.findViewById(e.g.img_thumbnail);
        this.cHf.setDefaultErrorResource(0);
        this.cHf.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cHf.setEvent(this.bgx);
        this.cHf.setGifIconSupport(false);
        this.cHg = inflate.findViewById(e.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(e.g.tv_title);
        this.cHh = (ImageView) inflate.findViewById(e.g.img_play);
        this.cEn = (AlaPlayAnimationView) inflate.findViewById(e.g.ala_play);
        this.cHi = (FrameLayout) inflate.findViewById(e.g.layout_loading);
        this.cHj = AnimationUtils.loadAnimation(getContext(), e.a.video_title_fade_out);
        this.cHk = (AudioAnimationView) inflate.findViewById(e.g.playing_indicator);
        this.cHk.setCertainColumnCount(4);
        this.cHk.setColumnColor(e.d.cp_cont_i);
        this.cHl = inflate.findViewById(e.g.layout_error);
        this.cHm = (TextView) inflate.findViewById(e.g.video_error_tips);
        this.cHn = inflate.findViewById(e.g.layout_live_end);
        this.cHo = (TextView) inflate.findViewById(e.g.video_live_end_tips);
        this.cFX = (LinearLayout) inflate.findViewById(e.g.llAlaLivingLogLayout);
        this.cHr = (TextView) inflate.findViewById(e.g.tvAlaLivingLogView);
        this.cHe = new a(this);
        this.bgv = (TextView) inflate.findViewById(e.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, e.d.cp_cont_i);
        }
        if (this.cHs > 0) {
            al.c(this.cHh, this.cHs);
        } else {
            al.c(this.cHh, e.f.btn_icon_play_live_on_n);
        }
        al.h(this.cHm, e.d.cp_cont_i);
        al.j(this.cHl, e.d.black_alpha80);
        al.j(this.bBg, e.d.cp_bg_line_k);
        al.h(this.cHo, e.d.cp_cont_i);
        al.j(this.cHn, e.d.black_alpha80);
        al.h(this.bgv, e.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cHe;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bgv != null) {
            this.bgv.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cHf.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.cHf.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cHs = i;
        this.cHh.setImageResource(i);
        this.cHh.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cHr.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cHr.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cFX.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bBg;
    }

    public void Vl() {
        this.cHf.setVisibility(0);
        this.cHh.setVisibility(0);
        this.cHi.setVisibility(8);
        if (this.cHg != null) {
            this.cHg.clearAnimation();
        }
        this.cHk.pP();
        this.cHl.setVisibility(8);
        this.cHn.setVisibility(8);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cHt);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.bgA);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.cHu);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cHp != null) {
            this.cHp.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cHq = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cEn != null) {
            this.cEn.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cEn != null) {
            this.cEn.setAutoStartPlay(z);
        }
    }
}
