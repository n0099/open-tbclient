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
import com.baidu.tieba.f;
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
    private g.f bjN;
    private QuickVideoView bvr;
    private LinearLayout cAf;
    private int cBA;
    private Runnable cBB;
    private Runnable cBC;
    private a cBm;
    private TbImageView cBn;
    private View cBo;
    private ImageView cBp;
    private FrameLayout cBq;
    private Animation cBr;
    private AudioAnimationView cBs;
    private View cBt;
    private TextView cBu;
    private View cBv;
    private TextView cBw;
    private n cBx;
    private View.OnClickListener cBy;
    private TextView cBz;
    private AlaPlayAnimationView cyx;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cBA = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBn != null) {
                    AlaVideoContainer.this.cBn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBy != null) {
                            AlaVideoContainer.this.cBy.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(f.j.no_network_guide));
                }
            }
        };
        this.bjN = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBs.start();
                AlaVideoContainer.this.cBq.setVisibility(8);
                AlaVideoContainer.this.cBn.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBB, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBC);
            }
        };
        this.cBB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBo != null) {
                    AlaVideoContainer.this.cBo.startAnimation(AlaVideoContainer.this.cBr);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.in().post(AlaVideoContainer.this.cBC);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.cBC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBt.setVisibility(0);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBA = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBn != null) {
                    AlaVideoContainer.this.cBn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBy != null) {
                            AlaVideoContainer.this.cBy.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(f.j.no_network_guide));
                }
            }
        };
        this.bjN = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBs.start();
                AlaVideoContainer.this.cBq.setVisibility(8);
                AlaVideoContainer.this.cBn.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBB, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBC);
            }
        };
        this.cBB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBo != null) {
                    AlaVideoContainer.this.cBo.startAnimation(AlaVideoContainer.this.cBr);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.in().post(AlaVideoContainer.this.cBC);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.cBC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBt.setVisibility(0);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cBA = -1;
        this.bdc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z && AlaVideoContainer.this.cBn != null) {
                    AlaVideoContainer.this.cBn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBy != null) {
                            AlaVideoContainer.this.cBy.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(f.j.no_network_guide));
                }
            }
        };
        this.bjN = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cBs.start();
                AlaVideoContainer.this.cBq.setVisibility(8);
                AlaVideoContainer.this.cBn.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.cBB, 3000L);
                e.in().removeCallbacks(AlaVideoContainer.this.cBC);
            }
        };
        this.cBB = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cBo != null) {
                    AlaVideoContainer.this.cBo.startAnimation(AlaVideoContainer.this.cBr);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.in().post(AlaVideoContainer.this.cBC);
                return false;
            }
        };
        this.bdf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Ty();
            }
        };
        this.cBC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cBt.setVisibility(0);
                AlaVideoContainer.this.cBq.setVisibility(8);
                e.in().postDelayed(AlaVideoContainer.this.bdf, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(f.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bvr = (QuickVideoView) inflate.findViewById(f.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bvr.getLayoutParams();
        layoutParams.height = (this.bvr.getWidth() * 9) / 16;
        this.bvr.setLayoutParams(layoutParams);
        this.cBx = new n(getContext());
        this.cBx.bkw();
        this.bvr.setBusiness(this.cBx);
        this.bvr.setOnPreparedListener(this.bjN);
        this.bvr.setOnSurfaceDestroyedListener(this.bdh);
        this.bvr.setOnErrorListener(this.bdd);
        this.cBn = (TbImageView) inflate.findViewById(f.g.img_thumbnail);
        this.cBn.setDefaultErrorResource(0);
        this.cBn.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.cBn.setEvent(this.bdc);
        this.cBn.setGifIconSupport(false);
        this.cBo = inflate.findViewById(f.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(f.g.tv_title);
        this.cBp = (ImageView) inflate.findViewById(f.g.img_play);
        this.cyx = (AlaPlayAnimationView) inflate.findViewById(f.g.ala_play);
        this.cBq = (FrameLayout) inflate.findViewById(f.g.layout_loading);
        this.cBr = AnimationUtils.loadAnimation(getContext(), f.a.video_title_fade_out);
        this.cBs = (AudioAnimationView) inflate.findViewById(f.g.playing_indicator);
        this.cBs.setCertainColumnCount(4);
        this.cBs.setColumnColor(f.d.cp_cont_i);
        this.cBt = inflate.findViewById(f.g.layout_error);
        this.cBu = (TextView) inflate.findViewById(f.g.video_error_tips);
        this.cBv = inflate.findViewById(f.g.layout_live_end);
        this.cBw = (TextView) inflate.findViewById(f.g.video_live_end_tips);
        this.cAf = (LinearLayout) inflate.findViewById(f.g.llAlaLivingLogLayout);
        this.cBz = (TextView) inflate.findViewById(f.g.tvAlaLivingLogView);
        this.cBm = new a(this);
        this.bcZ = (TextView) inflate.findViewById(f.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            am.h(this.mTitle, f.d.cp_cont_i);
        }
        if (this.cBA > 0) {
            am.c(this.cBp, this.cBA);
        } else {
            am.c(this.cBp, f.C0146f.btn_icon_play_live_on_n);
        }
        am.h(this.cBu, f.d.cp_cont_i);
        am.j(this.cBt, f.d.black_alpha80);
        am.j(this.bvr, f.d.cp_bg_line_k);
        am.h(this.cBw, f.d.cp_cont_i);
        am.j(this.cBv, f.d.black_alpha80);
        am.h(this.bcZ, f.d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cBm;
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
        this.cBn.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.cBn.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cBA = i;
        this.cBp.setImageResource(i);
        this.cBp.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cBz.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cBz.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cAf.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bvr;
    }

    public void Ty() {
        this.cBn.setVisibility(0);
        this.cBp.setVisibility(0);
        this.cBq.setVisibility(8);
        if (this.cBo != null) {
            this.cBo.clearAnimation();
        }
        this.cBs.oJ();
        this.cBt.setVisibility(8);
        this.cBv.setVisibility(8);
        e.in().removeCallbacks(this.cBB);
        e.in().removeCallbacks(this.bdf);
        e.in().removeCallbacks(this.cBC);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cBx != null) {
            this.cBx.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cBy = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cyx != null) {
            this.cyx.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cyx != null) {
            this.cyx.setAutoStartPlay(z);
        }
    }
}
