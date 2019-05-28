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
import com.baidu.tbadk.core.util.al;
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
    private QuickVideoView.b cIB;
    private TextView cIu;
    private TbImageView.a cIw;
    private g.b cIx;
    private Runnable cIz;
    private g.f cRT;
    private QuickVideoView dlM;
    private a eAa;
    private TbImageView eAb;
    private View eAc;
    private TBLottieAnimationView eAd;
    private FrameLayout eAe;
    private Animation eAf;
    private AudioAnimationView eAg;
    private View eAh;
    private TextView eAi;
    private View eAj;
    private TextView eAk;
    private n eAl;
    private View.OnClickListener eAm;
    private TextView eAn;
    private Runnable eAo;
    private Runnable eAp;
    private LinearLayout eyU;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.setDefaultBgResource(0);
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
                    if (j.jS()) {
                        if (AlaVideoContainer.this.eAm != null) {
                            AlaVideoContainer.this.eAm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAg.start();
                AlaVideoContainer.this.eAe.setVisibility(8);
                AlaVideoContainer.this.eAb.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAo, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAp);
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAc != null) {
                    AlaVideoContainer.this.eAc.startAnimation(AlaVideoContainer.this.eAf);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iB().post(AlaVideoContainer.this.eAp);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.eAp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAh.setVisibility(0);
                AlaVideoContainer.this.eAe.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.cIz, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.setDefaultBgResource(0);
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
                    if (j.jS()) {
                        if (AlaVideoContainer.this.eAm != null) {
                            AlaVideoContainer.this.eAm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAg.start();
                AlaVideoContainer.this.eAe.setVisibility(8);
                AlaVideoContainer.this.eAb.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAo, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAp);
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAc != null) {
                    AlaVideoContainer.this.eAc.startAnimation(AlaVideoContainer.this.eAf);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iB().post(AlaVideoContainer.this.eAp);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.eAp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAh.setVisibility(0);
                AlaVideoContainer.this.eAe.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.cIz, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cIw = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z && AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.setDefaultBgResource(0);
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
                    if (j.jS()) {
                        if (AlaVideoContainer.this.eAm != null) {
                            AlaVideoContainer.this.eAm.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAg.start();
                AlaVideoContainer.this.eAe.setVisibility(8);
                AlaVideoContainer.this.eAb.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAo, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAp);
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAc != null) {
                    AlaVideoContainer.this.eAc.startAnimation(AlaVideoContainer.this.eAf);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.iB().post(AlaVideoContainer.this.eAp);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHB();
            }
        };
        this.eAp = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAh.setVisibility(0);
                AlaVideoContainer.this.eAe.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.cIz, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dlM = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dlM.getLayoutParams();
        layoutParams.height = (this.dlM.getWidth() * 9) / 16;
        this.dlM.setLayoutParams(layoutParams);
        this.eAl = new n(getContext());
        this.eAl.cby();
        this.dlM.setBusiness(this.eAl);
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        this.dlM.setOnErrorListener(this.cIx);
        this.eAb = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eAb.setDefaultErrorResource(0);
        this.eAb.setDrawCorner(true);
        this.eAb.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.eAb.setEvent(this.cIw);
        this.eAb.setGifIconSupport(false);
        TbImageView tbImageView = this.eAb;
        TbImageView tbImageView2 = this.eAb;
        tbImageView.setConrers(15);
        this.eAb.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eAb.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAb.setBorderColor(al.getColor(R.color.black_alpha8));
        this.eAb.setBorderSurroundContent(true);
        this.eAb.setDrawBorder(true);
        this.eAc = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eAd = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eAd.y(true);
        this.eAe = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eAf = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eAg = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eAg.setCertainColumnCount(4);
        this.eAg.setColumnColor(R.color.cp_btn_a);
        this.eAh = inflate.findViewById(R.id.layout_error);
        this.eAi = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eAj = inflate.findViewById(R.id.layout_live_end);
        this.eAk = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eyU = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eAn = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.eAa = new a(this);
        this.cIu = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, R.color.cp_btn_a);
            }
            al.a(this.eAd, (int) R.raw.ala_play);
            al.j(this.eAi, R.color.cp_btn_a);
            al.l(this.eAh, R.color.black_alpha80);
            al.l(this.dlM, R.color.cp_bg_line_k);
            al.j(this.eAk, R.color.cp_btn_a);
            al.l(this.eAj, R.color.black_alpha80);
            al.j(this.cIu, R.color.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eAa;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cIu != null) {
            this.cIu.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.eAb.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eAb.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eAn.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eAn.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eyU.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dlM;
    }

    public void aHB() {
        this.eAb.setVisibility(0);
        this.eAd.setVisibility(0);
        this.eAe.setVisibility(8);
        if (this.eAc != null) {
            this.eAc.clearAnimation();
        }
        this.eAg.pV();
        this.eAh.setVisibility(8);
        this.eAj.setVisibility(8);
        e.iB().removeCallbacks(this.eAo);
        e.iB().removeCallbacks(this.cIz);
        e.iB().removeCallbacks(this.eAp);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eAl != null) {
            this.eAl.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eAm = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aXY();
    }

    public void startPlayAnimation() {
        if (this.eAd != null) {
            this.eAd.bo();
        }
    }

    public void aXY() {
        if (this.eAd != null) {
            this.eAd.cancelAnimation();
        }
    }
}
