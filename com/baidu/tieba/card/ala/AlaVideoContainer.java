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
import com.baidu.tbadk.core.util.al;
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
    private g.b bhA;
    private g.f bhz;
    private QuickVideoView bti;
    private QuickVideoView.b bts;
    private a cAQ;
    private TbImageView cAR;
    private View cAS;
    private ImageView cAT;
    private FrameLayout cAU;
    private Animation cAV;
    private AudioAnimationView cAW;
    private View cAX;
    private TextView cAY;
    private View cAZ;
    private TextView cBa;
    private n cBb;
    private View.OnClickListener cBc;
    private TextView cBd;
    private int cBe;
    private Runnable cBf;
    private Runnable cBg;
    private TextView cxR;
    private AlaPlayAnimationView cxT;
    private TbImageView.a cyq;
    private Runnable cyr;
    private LinearLayout czM;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.cBe = -1;
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cAR != null) {
                    AlaVideoContainer.this.cAR.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBc != null) {
                            AlaVideoContainer.this.cBc.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bhz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cAW.start();
                AlaVideoContainer.this.cAU.setVisibility(8);
                AlaVideoContainer.this.cAR.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cBf, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cBg);
            }
        };
        this.cBf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cAS != null) {
                    AlaVideoContainer.this.cAS.startAnimation(AlaVideoContainer.this.cAV);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.SR();
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.im().post(AlaVideoContainer.this.cBg);
                return false;
            }
        };
        this.cyr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.SR();
            }
        };
        this.cBg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cAX.setVisibility(0);
                AlaVideoContainer.this.cAU.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cBe = -1;
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cAR != null) {
                    AlaVideoContainer.this.cAR.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBc != null) {
                            AlaVideoContainer.this.cBc.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bhz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cAW.start();
                AlaVideoContainer.this.cAU.setVisibility(8);
                AlaVideoContainer.this.cAR.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cBf, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cBg);
            }
        };
        this.cBf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cAS != null) {
                    AlaVideoContainer.this.cAS.startAnimation(AlaVideoContainer.this.cAV);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.SR();
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.im().post(AlaVideoContainer.this.cBg);
                return false;
            }
        };
        this.cyr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.SR();
            }
        };
        this.cBg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cAX.setVisibility(0);
                AlaVideoContainer.this.cAU.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cBe = -1;
        this.cyq = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cAR != null) {
                    AlaVideoContainer.this.cAR.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.cBc != null) {
                            AlaVideoContainer.this.cBc.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.bhz = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.cAW.start();
                AlaVideoContainer.this.cAU.setVisibility(8);
                AlaVideoContainer.this.cAR.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cBf, 3000L);
                e.im().removeCallbacks(AlaVideoContainer.this.cBg);
            }
        };
        this.cBf = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.cAS != null) {
                    AlaVideoContainer.this.cAS.startAnimation(AlaVideoContainer.this.cAV);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.SR();
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.im().post(AlaVideoContainer.this.cBg);
                return false;
            }
        };
        this.cyr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.SR();
            }
        };
        this.cBg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cAX.setVisibility(0);
                AlaVideoContainer.this.cAU.setVisibility(8);
                e.im().postDelayed(AlaVideoContainer.this.cyr, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bti = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bti.getLayoutParams();
        layoutParams.height = (this.bti.getWidth() * 9) / 16;
        this.bti.setLayoutParams(layoutParams);
        this.cBb = new n(getContext());
        this.cBb.blC();
        this.bti.setBusiness(this.cBb);
        this.bti.setOnPreparedListener(this.bhz);
        this.bti.setOnSurfaceDestroyedListener(this.bts);
        this.bti.setOnErrorListener(this.bhA);
        this.cAR = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cAR.setDefaultErrorResource(0);
        this.cAR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAR.setEvent(this.cyq);
        this.cAR.setGifIconSupport(false);
        this.cAS = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.cAT = (ImageView) inflate.findViewById(d.g.img_play);
        this.cxT = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cAU = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.cAV = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.cAW = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.cAW.setCertainColumnCount(4);
        this.cAW.setColumnColor(d.C0141d.cp_cont_i);
        this.cAX = inflate.findViewById(d.g.layout_error);
        this.cAY = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.cAZ = inflate.findViewById(d.g.layout_live_end);
        this.cBa = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.czM = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cBd = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cAQ = new a(this);
        this.cxR = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            al.h(this.mTitle, d.C0141d.cp_cont_i);
        }
        if (this.cBe > 0) {
            al.c(this.cAT, this.cBe);
        } else {
            al.c(this.cAT, d.f.btn_icon_play_live_on_n);
        }
        al.h(this.cAY, d.C0141d.cp_cont_i);
        al.j(this.cAX, d.C0141d.black_alpha80);
        al.j(this.bti, d.C0141d.cp_bg_line_k);
        al.h(this.cBa, d.C0141d.cp_cont_i);
        al.j(this.cAZ, d.C0141d.black_alpha80);
        al.h(this.cxR, d.C0141d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cAQ;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cxR != null) {
            this.cxR.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cAR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cAR.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.cBe = i;
        this.cAT.setImageResource(i);
        this.cAT.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cBd.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cBd.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.czM.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bti;
    }

    public void SR() {
        this.cAR.setVisibility(0);
        this.cAT.setVisibility(0);
        this.cAU.setVisibility(8);
        if (this.cAS != null) {
            this.cAS.clearAnimation();
        }
        this.cAW.oJ();
        this.cAX.setVisibility(8);
        this.cAZ.setVisibility(8);
        e.im().removeCallbacks(this.cBf);
        e.im().removeCallbacks(this.cyr);
        e.im().removeCallbacks(this.cBg);
    }

    public void setVideoStatsData(y yVar) {
        if (this.cBb != null) {
            this.cBb.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.cBc = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cxT != null) {
            this.cxT.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cxT != null) {
            this.cxT.setAutoStartPlay(z);
        }
    }
}
