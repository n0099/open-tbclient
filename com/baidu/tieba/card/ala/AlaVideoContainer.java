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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes2.dex */
public class AlaVideoContainer extends LinearLayout {
    private TextView bcZ;
    private TbImageView.a bdc;
    private g.b bdd;
    private Runnable bdf;
    private QuickVideoView.b bdh;
    private g.f bjH;
    private QuickVideoView bvp;
    private LinearLayout cAi;
    private n cBA;
    private View.OnClickListener cBB;
    private TextView cBC;
    private int cBD;
    private Runnable cBE;
    private Runnable cBF;
    private a cBp;
    private TbImageView cBq;
    private View cBr;
    private ImageView cBs;
    private FrameLayout cBt;
    private Animation cBu;
    private AudioAnimationView cBv;
    private View cBw;
    private TextView cBx;
    private View cBy;
    private TextView cBz;
    private AlaPlayAnimationView cyA;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cBD = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBq != null) {
                    AlaVideoContainer.this.cBq.setDefaultBgResource(0);
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
                    if (j.jE()) {
                        if (AlaVideoContainer.this.cBB != null) {
                            AlaVideoContainer.this.cBB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bjH = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBv.start();
                AlaVideoContainer.this.cBt.setVisibility(8);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBE, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBF);
            }
        };
        this.cBE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBr != null) {
                    AlaVideoContainer.this.cBr.startAnimation(AlaVideoContainer.this.cBu);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.in().post(AlaVideoContainer.this.cBF);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.cBF = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBw.setVisibility(0);
                AlaVideoContainer.this.cBt.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBD = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBq != null) {
                    AlaVideoContainer.this.cBq.setDefaultBgResource(0);
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
                    if (j.jE()) {
                        if (AlaVideoContainer.this.cBB != null) {
                            AlaVideoContainer.this.cBB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bjH = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBv.start();
                AlaVideoContainer.this.cBt.setVisibility(8);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBE, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBF);
            }
        };
        this.cBE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBr != null) {
                    AlaVideoContainer.this.cBr.startAnimation(AlaVideoContainer.this.cBu);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.in().post(AlaVideoContainer.this.cBF);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.cBF = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBw.setVisibility(0);
                AlaVideoContainer.this.cBt.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cBD = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBq != null) {
                    AlaVideoContainer.this.cBq.setDefaultBgResource(0);
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
                    if (j.jE()) {
                        if (AlaVideoContainer.this.cBB != null) {
                            AlaVideoContainer.this.cBB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bjH = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBv.start();
                AlaVideoContainer.this.cBt.setVisibility(8);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBE, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBF);
            }
        };
        this.cBE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBr != null) {
                    AlaVideoContainer.this.cBr.startAnimation(AlaVideoContainer.this.cBu);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.in().post(AlaVideoContainer.this.cBF);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tv();
            }
        };
        this.cBF = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBw.setVisibility(0);
                AlaVideoContainer.this.cBt.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bvp = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bvp.getLayoutParams();
        layoutParams.height = (this.bvp.getWidth() * 9) / 16;
        this.bvp.setLayoutParams(layoutParams);
        this.cBA = new n(getContext());
        this.cBA.bkz();
        this.bvp.setBusiness(this.cBA);
        this.bvp.setOnPreparedListener(this.bjH);
        this.bvp.setOnSurfaceDestroyedListener(this.bdh);
        this.bvp.setOnErrorListener(this.bdd);
        this.cBq = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cBq.setDefaultErrorResource(0);
        this.cBq.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cBq.setEvent(this.bdc);
        this.cBq.setGifIconSupport(false);
        this.cBr = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cBs = (ImageView) inflate.findViewById(d.g.img_play);
        this.cyA = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cBt = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cBu = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cBv = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cBv.setCertainColumnCount(4);
        this.cBv.setColumnColor(d.C0140d.cp_cont_i);
        this.cBw = inflate.findViewById(d.g.layout_error);
        this.cBx = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cBy = inflate.findViewById(d.g.layout_live_end);
        this.cBz = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cAi = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cBC = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cBp = new a(this);
        this.bcZ = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            am.h(this.mTitle, d.C0140d.cp_cont_i);
        }
        if (this.cBD > 0) {
            am.c(this.cBs, this.cBD);
        } else {
            am.c(this.cBs, d.f.btn_icon_play_live_on_n);
        }
        am.h(this.cBx, d.C0140d.cp_cont_i);
        am.j(this.cBw, d.C0140d.black_alpha80);
        am.j(this.bvp, d.C0140d.cp_bg_line_k);
        am.h(this.cBz, d.C0140d.cp_cont_i);
        am.j(this.cBy, d.C0140d.black_alpha80);
        am.h(this.bcZ, d.C0140d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cBp;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bcZ != null) {
            this.bcZ.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cBq.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cBq.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cBD = i;
        this.cBs.setImageResource(i);
        this.cBs.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cBC.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cBC.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cAi.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bvp;
    }

    public void Tv() {
        this.cBq.setVisibility(0);
        this.cBs.setVisibility(0);
        this.cBt.setVisibility(8);
        if (this.cBr != null) {
            this.cBr.clearAnimation();
        }
        this.cBv.oM();
        this.cBw.setVisibility(8);
        this.cBy.setVisibility(8);
        e.in().removeCallbacks(this.cBE);
        e.in().removeCallbacks(this.bdf);
        e.in().removeCallbacks(this.cBF);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cBA != null) {
            this.cBA.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cBB = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cyA != null) {
            this.cyA.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cyA != null) {
            this.cyA.setAutoStartPlay(z);
        }
    }
}
