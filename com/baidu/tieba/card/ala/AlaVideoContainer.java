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
import com.baidu.tbadk.core.util.ak;
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
    private g.f aZp;
    private g.b aZq;
    private QuickVideoView ble;
    private QuickVideoView.b bln;
    private TbImageView.a cpN;
    private Runnable cpO;
    private TextView cpn;
    private AlaPlayAnimationView cpp;
    private LinearLayout crk;
    private TextView csA;
    private int csB;
    private Runnable csC;
    private Runnable csD;
    private a csn;
    private TbImageView cso;
    private View csp;
    private ImageView csq;
    private FrameLayout csr;
    private Animation css;
    private AudioAnimationView cst;
    private View csu;
    private TextView csv;
    private View csw;
    private TextView csx;
    private n csy;
    private View.OnClickListener csz;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.csB = -1;
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cso != null) {
                    AlaVideoContainer.this.cso.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.gP()) {
                        if (AlaVideoContainer.this.csz != null) {
                            AlaVideoContainer.this.csz.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cst.start();
                AlaVideoContainer.this.csr.setVisibility(8);
                AlaVideoContainer.this.cso.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.csC, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.csD);
            }
        };
        this.csC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.csp != null) {
                    AlaVideoContainer.this.csp.startAnimation(AlaVideoContainer.this.css);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fw().post(AlaVideoContainer.this.csD);
                return false;
            }
        };
        this.cpO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.csD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.csu.setVisibility(0);
                AlaVideoContainer.this.csr.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.cpO, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csB = -1;
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cso != null) {
                    AlaVideoContainer.this.cso.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.gP()) {
                        if (AlaVideoContainer.this.csz != null) {
                            AlaVideoContainer.this.csz.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cst.start();
                AlaVideoContainer.this.csr.setVisibility(8);
                AlaVideoContainer.this.cso.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.csC, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.csD);
            }
        };
        this.csC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.csp != null) {
                    AlaVideoContainer.this.csp.startAnimation(AlaVideoContainer.this.css);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fw().post(AlaVideoContainer.this.csD);
                return false;
            }
        };
        this.cpO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.csD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.csu.setVisibility(0);
                AlaVideoContainer.this.csr.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.cpO, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csB = -1;
        this.cpN = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cso != null) {
                    AlaVideoContainer.this.cso.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2.getId() == AlaVideoContainer.this.mView.getId()) {
                    if (j.gP()) {
                        if (AlaVideoContainer.this.csz != null) {
                            AlaVideoContainer.this.csz.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cst.start();
                AlaVideoContainer.this.csr.setVisibility(8);
                AlaVideoContainer.this.cso.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.csC, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.csD);
            }
        };
        this.csC = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.csp != null) {
                    AlaVideoContainer.this.csp.startAnimation(AlaVideoContainer.this.css);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fw().post(AlaVideoContainer.this.csD);
                return false;
            }
        };
        this.cpO = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pt();
            }
        };
        this.csD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.csu.setVisibility(0);
                AlaVideoContainer.this.csr.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.cpO, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.ble = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.ble.getLayoutParams();
        layoutParams.height = (this.ble.getWidth() * 9) / 16;
        this.ble.setLayoutParams(layoutParams);
        this.csy = new n(getContext());
        this.csy.bgE();
        this.ble.setBusiness(this.csy);
        this.ble.setOnPreparedListener(this.aZp);
        this.ble.setOnSurfaceDestroyedListener(this.bln);
        this.ble.setOnErrorListener(this.aZq);
        this.cso = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cso.setDefaultErrorResource(0);
        this.cso.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cso.setEvent(this.cpN);
        this.cso.setGifIconSupport(false);
        this.csp = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.csq = (ImageView) inflate.findViewById(d.g.img_play);
        this.cpp = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.csr = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.css = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cst = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cst.setCertainColumnCount(4);
        this.cst.setColumnColor(d.C0126d.cp_cont_i);
        this.csu = inflate.findViewById(d.g.layout_error);
        this.csv = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.csw = inflate.findViewById(d.g.layout_live_end);
        this.csx = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.crk = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.csA = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.csn = new a(this);
        this.cpn = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ak.h(this.mTitle, d.C0126d.cp_cont_i);
        }
        if (this.csB > 0) {
            ak.c(this.csq, this.csB);
        } else {
            ak.c(this.csq, d.f.btn_icon_play_live_on_n);
        }
        ak.h(this.csv, d.C0126d.cp_cont_i);
        ak.j(this.csu, d.C0126d.black_alpha80);
        ak.j(this.ble, d.C0126d.cp_bg_line_k);
        ak.h(this.csx, d.C0126d.cp_cont_i);
        ak.j(this.csw, d.C0126d.black_alpha80);
        ak.h(this.cpn, d.C0126d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.csn;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cpn != null) {
            this.cpn.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cso.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cso.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.csB = i;
        this.csq.setImageResource(i);
        this.csq.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.csA.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.csA.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.crk.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.ble;
    }

    public void Pt() {
        this.cso.setVisibility(0);
        this.csq.setVisibility(0);
        this.csr.setVisibility(8);
        if (this.csp != null) {
            this.csp.clearAnimation();
        }
        this.cst.lS();
        this.csu.setVisibility(8);
        this.csw.setVisibility(8);
        e.fw().removeCallbacks(this.csC);
        e.fw().removeCallbacks(this.cpO);
        e.fw().removeCallbacks(this.csD);
    }

    public void setVideoStatsData(y yVar) {
        if (this.csy != null) {
            this.csy.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.csz = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cpp != null) {
            this.cpp.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cpp != null) {
            this.cpp.setAutoStartPlay(z);
        }
    }
}
