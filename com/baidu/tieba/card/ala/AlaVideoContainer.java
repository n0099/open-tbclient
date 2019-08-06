package com.baidu.tieba.card.ala;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes3.dex */
public class AlaVideoContainer extends LinearLayout {
    private TextView cJW;
    private TbImageView.a cJY;
    private g.b cJZ;
    private Runnable cKb;
    private QuickVideoView.b cKd;
    private g.f cTx;
    private QuickVideoView dnB;
    private LinearLayout eDY;
    private a eFd;
    private TbImageView eFe;
    private View eFf;
    private TBLottieAnimationView eFg;
    private FrameLayout eFh;
    private Animation eFi;
    private AudioAnimationView eFj;
    private View eFk;
    private TextView eFl;
    private View eFm;
    private TextView eFn;
    private n eFo;
    private View.OnClickListener eFp;
    private TextView eFq;
    private Runnable eFr;
    private Runnable eFs;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eFe != null) {
                    AlaVideoContainer.this.eFe.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFp != null) {
                            AlaVideoContainer.this.eFp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFj.start();
                AlaVideoContainer.this.eFh.setVisibility(8);
                AlaVideoContainer.this.eFe.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFr, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFs);
            }
        };
        this.eFr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eFf != null) {
                    AlaVideoContainer.this.eFf.startAnimation(AlaVideoContainer.this.eFi);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eFs);
                return false;
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.eFs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFk.setVisibility(0);
                AlaVideoContainer.this.eFh.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKb, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eFe != null) {
                    AlaVideoContainer.this.eFe.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFp != null) {
                            AlaVideoContainer.this.eFp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFj.start();
                AlaVideoContainer.this.eFh.setVisibility(8);
                AlaVideoContainer.this.eFe.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFr, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFs);
            }
        };
        this.eFr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eFf != null) {
                    AlaVideoContainer.this.eFf.startAnimation(AlaVideoContainer.this.eFi);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eFs);
                return false;
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.eFs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFk.setVisibility(0);
                AlaVideoContainer.this.eFh.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKb, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cJY = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eFe != null) {
                    AlaVideoContainer.this.eFe.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFp != null) {
                            AlaVideoContainer.this.eFp.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFj.start();
                AlaVideoContainer.this.eFh.setVisibility(8);
                AlaVideoContainer.this.eFe.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFr, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFs);
            }
        };
        this.eFr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eFf != null) {
                    AlaVideoContainer.this.eFf.startAnimation(AlaVideoContainer.this.eFi);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.iK().post(AlaVideoContainer.this.eFs);
                return false;
            }
        };
        this.cKb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJa();
            }
        };
        this.eFs = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFk.setVisibility(0);
                AlaVideoContainer.this.eFh.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKb, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dnB = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dnB.getLayoutParams();
        layoutParams.height = (this.dnB.getWidth() * 9) / 16;
        this.dnB.setLayoutParams(layoutParams);
        this.eFo = new n(getContext());
        this.eFo.ceH();
        this.dnB.setBusiness(this.eFo);
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        this.dnB.setOnErrorListener(this.cJZ);
        this.eFe = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eFe.setDefaultErrorResource(0);
        this.eFe.setDrawCorner(true);
        this.eFe.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.eFe.setEvent(this.cJY);
        this.eFe.setGifIconSupport(false);
        TbImageView tbImageView = this.eFe;
        TbImageView tbImageView2 = this.eFe;
        tbImageView.setConrers(15);
        this.eFe.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eFe.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eFe.setBorderColor(am.getColor(R.color.black_alpha8));
        this.eFe.setBorderSurroundContent(true);
        this.eFe.setDrawBorder(true);
        this.eFf = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eFg = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eFg.y(true);
        this.eFh = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eFi = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eFj = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eFj.setCertainColumnCount(4);
        this.eFj.setColumnColor(R.color.cp_btn_a);
        this.eFk = inflate.findViewById(R.id.layout_error);
        this.eFl = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eFm = inflate.findViewById(R.id.layout_live_end);
        this.eFn = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eDY = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eFq = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.eFd = new a(this);
        this.cJW = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.j(this.mTitle, R.color.cp_btn_a);
            }
            am.a(this.eFg, (int) R.raw.ala_play);
            am.j(this.eFl, R.color.cp_btn_a);
            am.l(this.eFk, R.color.black_alpha80);
            am.l(this.dnB, R.color.cp_bg_line_k);
            am.j(this.eFn, R.color.cp_btn_a);
            am.l(this.eFm, R.color.black_alpha80);
            am.j(this.cJW, R.color.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eFd;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cJW != null) {
            this.cJW.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.eFe.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eFe.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eFq.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eFq.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eDY.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dnB;
    }

    public void aJa() {
        this.eFe.setVisibility(0);
        this.eFg.setVisibility(0);
        this.eFh.setVisibility(8);
        if (this.eFf != null) {
            this.eFf.clearAnimation();
        }
        this.eFj.qr();
        this.eFk.setVisibility(8);
        this.eFm.setVisibility(8);
        e.iK().removeCallbacks(this.eFr);
        e.iK().removeCallbacks(this.cKb);
        e.iK().removeCallbacks(this.eFs);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eFo != null) {
            this.eFo.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eFp = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZY();
    }

    public void startPlayAnimation() {
        if (this.eFg != null) {
            this.eFg.br();
        }
    }

    public void aZY() {
        if (this.eFg != null) {
            this.eFg.cancelAnimation();
        }
    }
}
