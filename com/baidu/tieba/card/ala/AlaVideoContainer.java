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
    private g.f aZo;
    private g.b aZp;
    private QuickVideoView bkP;
    private QuickVideoView.b bkY;
    private TbImageView.a coG;
    private Runnable coH;
    private TextView coh;
    private AlaPlayAnimationView coj;
    private LinearLayout cqd;
    private a crh;
    private TbImageView cri;
    private View crj;
    private ImageView crk;
    private FrameLayout crl;
    private Animation crm;
    private AudioAnimationView crn;
    private View cro;
    private TextView crp;
    private View crq;
    private TextView crr;
    private n crs;
    private View.OnClickListener crt;
    private TextView cru;
    private int crv;
    private Runnable crw;
    private Runnable crx;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.crv = -1;
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cri != null) {
                    AlaVideoContainer.this.cri.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crt != null) {
                            AlaVideoContainer.this.crt.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZo = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.crn.start();
                AlaVideoContainer.this.crl.setVisibility(8);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crw, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.crx);
            }
        };
        this.crw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crj != null) {
                    AlaVideoContainer.this.crj.startAnimation(AlaVideoContainer.this.crm);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fw().post(AlaVideoContainer.this.crx);
                return false;
            }
        };
        this.coH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.crx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cro.setVisibility(0);
                AlaVideoContainer.this.crl.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crv = -1;
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cri != null) {
                    AlaVideoContainer.this.cri.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crt != null) {
                            AlaVideoContainer.this.crt.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZo = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.crn.start();
                AlaVideoContainer.this.crl.setVisibility(8);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crw, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.crx);
            }
        };
        this.crw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crj != null) {
                    AlaVideoContainer.this.crj.startAnimation(AlaVideoContainer.this.crm);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fw().post(AlaVideoContainer.this.crx);
                return false;
            }
        };
        this.coH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.crx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cro.setVisibility(0);
                AlaVideoContainer.this.crl.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coH, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crv = -1;
        this.coG = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.cri != null) {
                    AlaVideoContainer.this.cri.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crt != null) {
                            AlaVideoContainer.this.crt.onClick(view2);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.k.no_network_guide));
                }
            }
        };
        this.aZo = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.crn.start();
                AlaVideoContainer.this.crl.setVisibility(8);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crw, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.crx);
            }
        };
        this.crw = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crj != null) {
                    AlaVideoContainer.this.crj.startAnimation(AlaVideoContainer.this.crm);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fw().post(AlaVideoContainer.this.crx);
                return false;
            }
        };
        this.coH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.crx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.cro.setVisibility(0);
                AlaVideoContainer.this.crl.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coH, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.bkP = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.bkP.getLayoutParams();
        layoutParams.height = (this.bkP.getWidth() * 9) / 16;
        this.bkP.setLayoutParams(layoutParams);
        this.crs = new n(getContext());
        this.crs.bgE();
        this.bkP.setBusiness(this.crs);
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        this.bkP.setOnErrorListener(this.aZp);
        this.cri = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.cri.setDefaultErrorResource(0);
        this.cri.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cri.setEvent(this.coG);
        this.cri.setGifIconSupport(false);
        this.crj = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.crk = (ImageView) inflate.findViewById(d.g.img_play);
        this.coj = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.crl = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.crm = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.crn = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.crn.setCertainColumnCount(4);
        this.crn.setColumnColor(d.C0126d.cp_cont_i);
        this.cro = inflate.findViewById(d.g.layout_error);
        this.crp = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.crq = inflate.findViewById(d.g.layout_live_end);
        this.crr = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cqd = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.cru = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.crh = new a(this);
        this.coh = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ak.h(this.mTitle, d.C0126d.cp_cont_i);
        }
        if (this.crv > 0) {
            ak.c(this.crk, this.crv);
        } else {
            ak.c(this.crk, d.f.btn_icon_play_live_on_n);
        }
        ak.h(this.crp, d.C0126d.cp_cont_i);
        ak.j(this.cro, d.C0126d.black_alpha80);
        ak.j(this.bkP, d.C0126d.cp_bg_line_k);
        ak.h(this.crr, d.C0126d.cp_cont_i);
        ak.j(this.crq, d.C0126d.black_alpha80);
        ak.h(this.coh, d.C0126d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.crh;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.coh != null) {
            this.coh.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.cri.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cri.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.crv = i;
        this.crk.setImageResource(i);
        this.crk.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.cru.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.cru.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cqd.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bkP;
    }

    public void Pw() {
        this.cri.setVisibility(0);
        this.crk.setVisibility(0);
        this.crl.setVisibility(8);
        if (this.crj != null) {
            this.crj.clearAnimation();
        }
        this.crn.lT();
        this.cro.setVisibility(8);
        this.crq.setVisibility(8);
        e.fw().removeCallbacks(this.crw);
        e.fw().removeCallbacks(this.coH);
        e.fw().removeCallbacks(this.crx);
    }

    public void setVideoStatsData(y yVar) {
        if (this.crs != null) {
            this.crs.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.crt = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.coj != null) {
            this.coj.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.coj != null) {
            this.coj.setAutoStartPlay(z);
        }
    }
}
