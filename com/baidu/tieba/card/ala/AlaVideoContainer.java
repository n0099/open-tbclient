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
    private TextView bcQ;
    private TbImageView.a bcT;
    private g.b bcU;
    private Runnable bcW;
    private QuickVideoView.b bcY;
    private g.f bjc;
    private QuickVideoView buJ;
    private AlaPlayAnimationView cvY;
    private LinearLayout cxF;
    private a cyK;
    private TbImageView cyL;
    private View cyM;
    private ImageView cyN;
    private FrameLayout cyO;
    private Animation cyP;
    private AudioAnimationView cyQ;
    private View cyR;
    private TextView cyS;
    private View cyT;
    private TextView cyU;
    private n cyV;
    private View.OnClickListener cyW;
    private TextView cyX;
    private int cyY;
    private Runnable cyZ;
    private Runnable cza;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cyY = -1;
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cyL != null) {
                    AlaVideoContainer.this.cyL.setDefaultBgResource(0);
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
                    if (j.jD()) {
                        if (AlaVideoContainer.this.cyW != null) {
                            AlaVideoContainer.this.cyW.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bjc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cyQ.start();
                AlaVideoContainer.this.cyO.setVisibility(8);
                AlaVideoContainer.this.cyL.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyZ, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cza);
            }
        };
        this.cyZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cyM != null) {
                    AlaVideoContainer.this.cyM.startAnimation(AlaVideoContainer.this.cyP);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.im().post(AlaVideoContainer.this.cza);
                return false;
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.cza = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cyR.setVisibility(0);
                AlaVideoContainer.this.cyO.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.bcW, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cyY = -1;
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cyL != null) {
                    AlaVideoContainer.this.cyL.setDefaultBgResource(0);
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
                    if (j.jD()) {
                        if (AlaVideoContainer.this.cyW != null) {
                            AlaVideoContainer.this.cyW.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bjc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cyQ.start();
                AlaVideoContainer.this.cyO.setVisibility(8);
                AlaVideoContainer.this.cyL.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyZ, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cza);
            }
        };
        this.cyZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cyM != null) {
                    AlaVideoContainer.this.cyM.startAnimation(AlaVideoContainer.this.cyP);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.im().post(AlaVideoContainer.this.cza);
                return false;
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.cza = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cyR.setVisibility(0);
                AlaVideoContainer.this.cyO.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.bcW, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyY = -1;
        this.bcT = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cyL != null) {
                    AlaVideoContainer.this.cyL.setDefaultBgResource(0);
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
                    if (j.jD()) {
                        if (AlaVideoContainer.this.cyW != null) {
                            AlaVideoContainer.this.cyW.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bjc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cyQ.start();
                AlaVideoContainer.this.cyO.setVisibility(8);
                AlaVideoContainer.this.cyL.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyZ, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cza);
            }
        };
        this.cyZ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cyM != null) {
                    AlaVideoContainer.this.cyM.startAnimation(AlaVideoContainer.this.cyP);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.im().post(AlaVideoContainer.this.cza);
                return false;
            }
        };
        this.bcW = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Tn();
            }
        };
        this.cza = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cyR.setVisibility(0);
                AlaVideoContainer.this.cyO.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.bcW, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.buJ = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.buJ.getLayoutParams();
        layoutParams.height = (this.buJ.getWidth() * 9) / 16;
        this.buJ.setLayoutParams(layoutParams);
        this.cyV = new n(getContext());
        this.cyV.bmg();
        this.buJ.setBusiness(this.cyV);
        this.buJ.setOnPreparedListener(this.bjc);
        this.buJ.setOnSurfaceDestroyedListener(this.bcY);
        this.buJ.setOnErrorListener(this.bcU);
        this.cyL = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cyL.setDefaultErrorResource(0);
        this.cyL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cyL.setEvent(this.bcT);
        this.cyL.setGifIconSupport(false);
        this.cyM = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cyN = (ImageView) inflate.findViewById(d.g.img_play);
        this.cvY = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cyO = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cyP = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cyQ = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cyQ.setCertainColumnCount(4);
        this.cyQ.setColumnColor(d.C0142d.cp_cont_i);
        this.cyR = inflate.findViewById(d.g.layout_error);
        this.cyS = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cyT = inflate.findViewById(d.g.layout_live_end);
        this.cyU = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cxF = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cyX = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cyK = new a(this);
        this.bcQ = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            am.h(this.mTitle, d.C0142d.cp_cont_i);
        }
        if (this.cyY > 0) {
            am.c(this.cyN, this.cyY);
        } else {
            am.c(this.cyN, d.f.btn_icon_play_live_on_n);
        }
        am.h(this.cyS, d.C0142d.cp_cont_i);
        am.j(this.cyR, d.C0142d.black_alpha80);
        am.j(this.buJ, d.C0142d.cp_bg_line_k);
        am.h(this.cyU, d.C0142d.cp_cont_i);
        am.j(this.cyT, d.C0142d.black_alpha80);
        am.h(this.bcQ, d.C0142d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cyK;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.bcQ != null) {
            this.bcQ.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cyL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cyL.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cyY = i;
        this.cyN.setImageResource(i);
        this.cyN.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cyX.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cyX.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cxF.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.buJ;
    }

    public void Tn() {
        this.cyL.setVisibility(0);
        this.cyN.setVisibility(0);
        this.cyO.setVisibility(8);
        if (this.cyM != null) {
            this.cyM.clearAnimation();
        }
        this.cyQ.oJ();
        this.cyR.setVisibility(8);
        this.cyT.setVisibility(8);
        e.im().removeCallbacks(this.cyZ);
        e.im().removeCallbacks(this.bcW);
        e.im().removeCallbacks(this.cza);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cyV != null) {
            this.cyV.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cyW = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cvY != null) {
            this.cvY.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cvY != null) {
            this.cvY.setAutoStartPlay(z);
        }
    }
}
