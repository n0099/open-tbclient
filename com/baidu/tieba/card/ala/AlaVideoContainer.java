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
    private TbImageView.a coD;
    private Runnable coE;
    private TextView coe;
    private AlaPlayAnimationView cog;
    private LinearLayout cqa;
    private a cre;
    private TbImageView crf;
    private View crg;
    private ImageView crh;
    private FrameLayout cri;
    private Animation crj;
    private AudioAnimationView crk;
    private View crl;
    private TextView crm;
    private View crn;
    private TextView cro;
    private n crp;
    private View.OnClickListener crq;
    private TextView crr;
    private int crs;
    private Runnable crt;
    private Runnable cru;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.crs = -1;
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.crf != null) {
                    AlaVideoContainer.this.crf.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crq != null) {
                            AlaVideoContainer.this.crq.onClick(view2);
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
                AlaVideoContainer.this.crk.start();
                AlaVideoContainer.this.cri.setVisibility(8);
                AlaVideoContainer.this.crf.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crt, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.cru);
            }
        };
        this.crt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crg != null) {
                    AlaVideoContainer.this.crg.startAnimation(AlaVideoContainer.this.crj);
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
                e.fw().post(AlaVideoContainer.this.cru);
                return false;
            }
        };
        this.coE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.cru = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.crl.setVisibility(0);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coE, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crs = -1;
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.crf != null) {
                    AlaVideoContainer.this.crf.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crq != null) {
                            AlaVideoContainer.this.crq.onClick(view2);
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
                AlaVideoContainer.this.crk.start();
                AlaVideoContainer.this.cri.setVisibility(8);
                AlaVideoContainer.this.crf.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crt, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.cru);
            }
        };
        this.crt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crg != null) {
                    AlaVideoContainer.this.crg.startAnimation(AlaVideoContainer.this.crj);
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
                e.fw().post(AlaVideoContainer.this.cru);
                return false;
            }
        };
        this.coE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.cru = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.crl.setVisibility(0);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coE, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crs = -1;
        this.coD = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z && AlaVideoContainer.this.crf != null) {
                    AlaVideoContainer.this.crf.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.crq != null) {
                            AlaVideoContainer.this.crq.onClick(view2);
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
                AlaVideoContainer.this.crk.start();
                AlaVideoContainer.this.cri.setVisibility(8);
                AlaVideoContainer.this.crf.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.crt, 3000L);
                e.fw().removeCallbacks(AlaVideoContainer.this.cru);
            }
        };
        this.crt = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.crg != null) {
                    AlaVideoContainer.this.crg.startAnimation(AlaVideoContainer.this.crj);
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
                e.fw().post(AlaVideoContainer.this.cru);
                return false;
            }
        };
        this.coE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.Pw();
            }
        };
        this.cru = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.crl.setVisibility(0);
                AlaVideoContainer.this.cri.setVisibility(8);
                e.fw().postDelayed(AlaVideoContainer.this.coE, 2000L);
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
        this.crp = new n(getContext());
        this.crp.bgE();
        this.bkP.setBusiness(this.crp);
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        this.bkP.setOnErrorListener(this.aZp);
        this.crf = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.crf.setDefaultErrorResource(0);
        this.crf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.crf.setEvent(this.coD);
        this.crf.setGifIconSupport(false);
        this.crg = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.crh = (ImageView) inflate.findViewById(d.g.img_play);
        this.cog = (AlaPlayAnimationView) inflate.findViewById(d.g.ala_play);
        this.cri = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.crj = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.crk = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.crk.setCertainColumnCount(4);
        this.crk.setColumnColor(d.C0126d.cp_cont_i);
        this.crl = inflate.findViewById(d.g.layout_error);
        this.crm = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.crn = inflate.findViewById(d.g.layout_live_end);
        this.cro = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.cqa = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.crr = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.cre = new a(this);
        this.coe = (TextView) inflate.findViewById(d.g.play_count);
    }

    public void onChangeSkinType(int i) {
        if (this.mTitle != null) {
            ak.h(this.mTitle, d.C0126d.cp_cont_i);
        }
        if (this.crs > 0) {
            ak.c(this.crh, this.crs);
        } else {
            ak.c(this.crh, d.f.btn_icon_play_live_on_n);
        }
        ak.h(this.crm, d.C0126d.cp_cont_i);
        ak.j(this.crl, d.C0126d.black_alpha80);
        ak.j(this.bkP, d.C0126d.cp_bg_line_k);
        ak.h(this.cro, d.C0126d.cp_cont_i);
        ak.j(this.crn, d.C0126d.black_alpha80);
        ak.h(this.coe, d.C0126d.cp_cont_i);
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.cre;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.coe != null) {
            this.coe.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.crf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.crf.startLoad(str, 10, false);
    }

    public void setImgPlay(int i, int i2) {
        this.crs = i;
        this.crh.setImageResource(i);
        this.crh.setVisibility(i2);
    }

    public void setLivingLogText(int i) {
        this.crr.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.crr.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.cqa.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.bkP;
    }

    public void Pw() {
        this.crf.setVisibility(0);
        this.crh.setVisibility(0);
        this.cri.setVisibility(8);
        if (this.crg != null) {
            this.crg.clearAnimation();
        }
        this.crk.lT();
        this.crl.setVisibility(8);
        this.crn.setVisibility(8);
        e.fw().removeCallbacks(this.crt);
        e.fw().removeCallbacks(this.coE);
        e.fw().removeCallbacks(this.cru);
    }

    public void setVideoStatsData(y yVar) {
        if (this.crp != null) {
            this.crp.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.crq = onClickListener;
    }

    public void startPlayAnimation() {
        if (this.cog != null) {
            this.cog.startPlayAnimation();
        }
    }

    public void setAutoStartPlay(boolean z) {
        if (this.cog != null) {
            this.cog.setAutoStartPlay(z);
        }
    }
}
