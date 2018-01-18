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
    private g.f bNn;
    private g.b bNo;
    private QuickVideoView bYH;
    private QuickVideoView.b bYO;
    private TbImageView.a cTK;
    private Runnable cTL;
    private TextView cTm;
    private AlaPlayAnimationView cTo;
    private LinearLayout cVp;
    private Runnable cWA;
    private a cWk;
    private TbImageView cWl;
    private View cWm;
    private ImageView cWn;
    private FrameLayout cWo;
    private Animation cWp;
    private AudioAnimationView cWq;
    private View cWr;
    private TextView cWs;
    private View cWt;
    private TextView cWu;
    private n cWv;
    private View.OnClickListener cWw;
    private TextView cWx;
    private int cWy;
    private Runnable cWz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cWy = -1;
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWl != null) {
                    AlaVideoContainer.this.cWl.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWw != null) {
                            AlaVideoContainer.this.cWw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWq.start();
                AlaVideoContainer.this.cWo.setVisibility(8);
                AlaVideoContainer.this.cWl.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cWz, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cWA);
            }
        };
        this.cWz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWm != null) {
                    AlaVideoContainer.this.cWm.startAnimation(AlaVideoContainer.this.cWp);
                }
            }
        };
        this.bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.bNo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.nr().post(AlaVideoContainer.this.cWA);
                return false;
            }
        };
        this.cTL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.cWA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWr.setVisibility(0);
                AlaVideoContainer.this.cWo.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cTL, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cWy = -1;
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWl != null) {
                    AlaVideoContainer.this.cWl.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWw != null) {
                            AlaVideoContainer.this.cWw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWq.start();
                AlaVideoContainer.this.cWo.setVisibility(8);
                AlaVideoContainer.this.cWl.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cWz, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cWA);
            }
        };
        this.cWz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWm != null) {
                    AlaVideoContainer.this.cWm.startAnimation(AlaVideoContainer.this.cWp);
                }
            }
        };
        this.bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.bNo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.nr().post(AlaVideoContainer.this.cWA);
                return false;
            }
        };
        this.cTL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.cWA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWr.setVisibility(0);
                AlaVideoContainer.this.cWo.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cTL, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cWy = -1;
        this.cTK = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.cWl != null) {
                    AlaVideoContainer.this.cWl.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cWw != null) {
                            AlaVideoContainer.this.cWw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.J(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.bNn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cWq.start();
                AlaVideoContainer.this.cWo.setVisibility(8);
                AlaVideoContainer.this.cWl.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cWz, 3000L);
                e.nr().removeCallbacks(AlaVideoContainer.this.cWA);
            }
        };
        this.cWz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cWm != null) {
                    AlaVideoContainer.this.cWm.startAnimation(AlaVideoContainer.this.cWp);
                }
            }
        };
        this.bYO = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.bNo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.nr().post(AlaVideoContainer.this.cWA);
                return false;
            }
        };
        this.cTL = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Wd();
            }
        };
        this.cWA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cWr.setVisibility(0);
                AlaVideoContainer.this.cWo.setVisibility(8);
                e.nr().postDelayed(AlaVideoContainer.this.cTL, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bYH = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bYH.getLayoutParams();
        layoutParams.height = (this.bYH.getWidth() * 9) / 16;
        this.bYH.setLayoutParams(layoutParams);
        this.cWv = new n(getContext());
        this.cWv.bkk();
        this.bYH.setBusiness(this.cWv);
        this.bYH.setOnPreparedListener(this.bNn);
        this.bYH.setOnSurfaceDestroyedListener(this.bYO);
        this.bYH.setOnErrorListener(this.bNo);
        this.cWl = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cWl.setDefaultErrorResource(0);
        this.cWl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWl.setEvent(this.cTK);
        this.cWl.setGifIconSupport(false);
        this.cWm = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cWn = (ImageView) inflate.findViewById(d.g.img_play);
        this.cTo = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cWo = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cWp = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cWq = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cWq.setCertainColumnCount(4);
        this.cWq.setColumnColor(d.C0107d.cp_cont_i);
        this.cWr = inflate.findViewById(d.g.layout_error);
        this.cWs = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cWt = inflate.findViewById(d.g.layout_live_end);
        this.cWu = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cVp = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cWx = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cWk = new a(this);
        this.cTm = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.r(this.mTitle, d.C0107d.cp_cont_i);
        }
        if (this.cWy > 0) {
            aj.c(this.cWn, this.cWy);
        } else {
            aj.c(this.cWn, d.f.btn_icon_play_live_on_n);
        }
        aj.r(this.cWs, d.C0107d.cp_cont_i);
        aj.t(this.cWr, d.C0107d.black_alpha80);
        aj.t(this.bYH, d.C0107d.cp_bg_line_k);
        aj.r(this.cWu, d.C0107d.cp_cont_i);
        aj.t(this.cWt, d.C0107d.black_alpha80);
        aj.r(this.cTm, d.C0107d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cWk;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cTm != null) {
            this.cTm.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cWl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cWl.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cWx.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cWx.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cVp.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bYH;
    }

    public void Wd() {
        this.cWl.setVisibility(0);
        this.cWn.setVisibility(0);
        this.cWo.setVisibility(8);
        if (this.cWm != null) {
            this.cWm.clearAnimation();
        }
        this.cWq.tn();
        this.cWr.setVisibility(8);
        this.cWt.setVisibility(8);
        e.nr().removeCallbacks(this.cWz);
        e.nr().removeCallbacks(this.cTL);
        e.nr().removeCallbacks(this.cWA);
    }

    public void setVideoStatsData(aa aaVar) {
        if (this.cWv != null) {
            this.cWv.setVideoStatsData(aaVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cWw = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cTo != null) {
            this.cTo.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cTo != null) {
            this.cTo.setAutoStartPlay(z);
        }
    }
}
