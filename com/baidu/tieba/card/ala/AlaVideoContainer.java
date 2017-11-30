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
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AlaPlayAnimationView;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class AlaVideoContainer extends LinearLayout {
    private g.f aZn;
    private g.b aZo;
    private TextView bZY;
    private QuickVideoView blk;
    private QuickVideoView.b blr;
    private AlaPlayAnimationView caa;
    private TbImageView.a cav;
    private Runnable caw;
    private a ccN;
    private TbImageView ccO;
    private View ccP;
    private ImageView ccQ;
    private FrameLayout ccR;
    private Animation ccS;
    private AudioAnimationView ccT;
    private View ccU;
    private TextView ccV;
    private View ccW;
    private TextView ccX;
    private n ccY;
    private View.OnClickListener ccZ;
    private LinearLayout ccb;
    private TextView cda;
    private int cdb;
    private Runnable cdc;
    private Runnable cdd;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cdb = -1;
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.ccO != null) {
                    AlaVideoContainer.this.ccO.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.ccZ != null) {
                            AlaVideoContainer.this.ccZ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ccT.start();
                AlaVideoContainer.this.ccR.setVisibility(8);
                AlaVideoContainer.this.ccO.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdc, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdd);
            }
        };
        this.cdc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ccP != null) {
                    AlaVideoContainer.this.ccP.startAnimation(AlaVideoContainer.this.ccS);
                }
            }
        };
        this.blr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdd);
                return false;
            }
        };
        this.caw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ccU.setVisibility(0);
                AlaVideoContainer.this.ccR.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caw, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdb = -1;
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.ccO != null) {
                    AlaVideoContainer.this.ccO.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.ccZ != null) {
                            AlaVideoContainer.this.ccZ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ccT.start();
                AlaVideoContainer.this.ccR.setVisibility(8);
                AlaVideoContainer.this.ccO.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdc, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdd);
            }
        };
        this.cdc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ccP != null) {
                    AlaVideoContainer.this.ccP.startAnimation(AlaVideoContainer.this.ccS);
                }
            }
        };
        this.blr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fP().post(AlaVideoContainer.this.cdd);
                return false;
            }
        };
        this.caw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ccU.setVisibility(0);
                AlaVideoContainer.this.ccR.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caw, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdb = -1;
        this.cav = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z && AlaVideoContainer.this.ccO != null) {
                    AlaVideoContainer.this.ccO.setDefaultBgResource(0);
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
                    if (j.hh()) {
                        if (AlaVideoContainer.this.ccZ != null) {
                            AlaVideoContainer.this.ccZ.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.F(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.aZn = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ccT.start();
                AlaVideoContainer.this.ccR.setVisibility(8);
                AlaVideoContainer.this.ccO.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.cdc, 3000L);
                e.fP().removeCallbacks(AlaVideoContainer.this.cdd);
            }
        };
        this.cdc = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ccP != null) {
                    AlaVideoContainer.this.ccP.startAnimation(AlaVideoContainer.this.ccS);
                }
            }
        };
        this.blr = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.aZo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fP().post(AlaVideoContainer.this.cdd);
                return false;
            }
        };
        this.caw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.OQ();
            }
        };
        this.cdd = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ccU.setVisibility(0);
                AlaVideoContainer.this.ccR.setVisibility(8);
                e.fP().postDelayed(AlaVideoContainer.this.caw, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.blk = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.blk.getLayoutParams();
        layoutParams.height = (this.blk.getWidth() * 9) / 16;
        this.blk.setLayoutParams(layoutParams);
        this.ccY = new n(getContext());
        this.ccY.bjp();
        this.blk.setBusiness(this.ccY);
        this.blk.setOnPreparedListener(this.aZn);
        this.blk.setOnSurfaceDestroyedListener(this.blr);
        this.blk.setOnErrorListener(this.aZo);
        this.ccO = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.ccO.setDefaultErrorResource(0);
        this.ccO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ccO.setEvent(this.cav);
        this.ccO.setGifIconSupport(false);
        this.ccP = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.ccQ = (ImageView) inflate.findViewById(d.g.img_play);
        this.caa = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.ccR = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.ccS = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.ccT = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.ccT.setCertainColumnCount(4);
        this.ccT.setColumnColor(d.C0082d.cp_cont_i);
        this.ccU = inflate.findViewById(d.g.layout_error);
        this.ccV = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.ccW = inflate.findViewById(d.g.layout_live_end);
        this.ccX = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ccb = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cda = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.ccN = new a(this);
        this.bZY = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            aj.i(this.mTitle, d.C0082d.cp_cont_i);
        }
        if (this.cdb > 0) {
            aj.c(this.ccQ, this.cdb);
        } else {
            aj.c(this.ccQ, d.f.btn_icon_play_live_on_n);
        }
        aj.i(this.ccV, d.C0082d.cp_cont_i);
        aj.k(this.ccU, d.C0082d.black_alpha80);
        aj.k(this.blk, d.C0082d.cp_bg_line_k);
        aj.i(this.ccX, d.C0082d.cp_cont_i);
        aj.k(this.ccW, d.C0082d.black_alpha80);
        aj.i(this.bZY, d.C0082d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ccN;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bZY != null) {
            this.bZY.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ccO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ccO.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.cda.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cda.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ccb.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.blk;
    }

    public void OQ() {
        this.ccO.setVisibility(0);
        this.ccQ.setVisibility(0);
        this.ccR.setVisibility(8);
        if (this.ccP != null) {
            this.ccP.clearAnimation();
        }
        this.ccT.lK();
        this.ccU.setVisibility(8);
        this.ccW.setVisibility(8);
        e.fP().removeCallbacks(this.cdc);
        e.fP().removeCallbacks(this.caw);
        e.fP().removeCallbacks(this.cdd);
    }

    public void setVideoStatsData(y yVar) {
        if (this.ccY != null) {
            this.ccY.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ccZ = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.caa != null) {
            this.caa.startPlayAnimation();
        }
    }
}
