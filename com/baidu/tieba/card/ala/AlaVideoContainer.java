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
    private g.f cRS;
    private QuickVideoView dlL;
    private TbImageView eAa;
    private View eAb;
    private TBLottieAnimationView eAc;
    private FrameLayout eAd;
    private Animation eAe;
    private AudioAnimationView eAf;
    private View eAg;
    private TextView eAh;
    private View eAi;
    private TextView eAj;
    private n eAk;
    private View.OnClickListener eAl;
    private TextView eAm;
    private Runnable eAn;
    private Runnable eAo;
    private LinearLayout eyT;
    private a ezZ;
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
                if (z && AlaVideoContainer.this.eAa != null) {
                    AlaVideoContainer.this.eAa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eAl != null) {
                            AlaVideoContainer.this.eAl.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAf.start();
                AlaVideoContainer.this.eAd.setVisibility(8);
                AlaVideoContainer.this.eAa.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAn, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAo);
            }
        };
        this.eAn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.startAnimation(AlaVideoContainer.this.eAe);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iB().post(AlaVideoContainer.this.eAo);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAg.setVisibility(0);
                AlaVideoContainer.this.eAd.setVisibility(8);
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
                if (z && AlaVideoContainer.this.eAa != null) {
                    AlaVideoContainer.this.eAa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eAl != null) {
                            AlaVideoContainer.this.eAl.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAf.start();
                AlaVideoContainer.this.eAd.setVisibility(8);
                AlaVideoContainer.this.eAa.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAn, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAo);
            }
        };
        this.eAn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.startAnimation(AlaVideoContainer.this.eAe);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iB().post(AlaVideoContainer.this.eAo);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAg.setVisibility(0);
                AlaVideoContainer.this.eAd.setVisibility(8);
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
                if (z && AlaVideoContainer.this.eAa != null) {
                    AlaVideoContainer.this.eAa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eAl != null) {
                            AlaVideoContainer.this.eAl.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eAf.start();
                AlaVideoContainer.this.eAd.setVisibility(8);
                AlaVideoContainer.this.eAa.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.eAn, 3000L);
                e.iB().removeCallbacks(AlaVideoContainer.this.eAo);
            }
        };
        this.eAn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eAb != null) {
                    AlaVideoContainer.this.eAb.startAnimation(AlaVideoContainer.this.eAe);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.iB().post(AlaVideoContainer.this.eAo);
                return false;
            }
        };
        this.cIz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aHy();
            }
        };
        this.eAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eAg.setVisibility(0);
                AlaVideoContainer.this.eAd.setVisibility(8);
                e.iB().postDelayed(AlaVideoContainer.this.cIz, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dlL = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dlL.getLayoutParams();
        layoutParams.height = (this.dlL.getWidth() * 9) / 16;
        this.dlL.setLayoutParams(layoutParams);
        this.eAk = new n(getContext());
        this.eAk.cbv();
        this.dlL.setBusiness(this.eAk);
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        this.dlL.setOnErrorListener(this.cIx);
        this.eAa = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eAa.setDefaultErrorResource(0);
        this.eAa.setDrawCorner(true);
        this.eAa.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.eAa.setEvent(this.cIw);
        this.eAa.setGifIconSupport(false);
        TbImageView tbImageView = this.eAa;
        TbImageView tbImageView2 = this.eAa;
        tbImageView.setConrers(15);
        this.eAa.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eAa.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eAa.setBorderColor(al.getColor(R.color.black_alpha8));
        this.eAa.setBorderSurroundContent(true);
        this.eAa.setDrawBorder(true);
        this.eAb = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eAc = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eAc.y(true);
        this.eAd = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eAe = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eAf = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eAf.setCertainColumnCount(4);
        this.eAf.setColumnColor(R.color.cp_btn_a);
        this.eAg = inflate.findViewById(R.id.layout_error);
        this.eAh = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eAi = inflate.findViewById(R.id.layout_live_end);
        this.eAj = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eyT = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eAm = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.ezZ = new a(this);
        this.cIu = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, R.color.cp_btn_a);
            }
            al.a(this.eAc, (int) R.raw.ala_play);
            al.j(this.eAh, R.color.cp_btn_a);
            al.l(this.eAg, R.color.black_alpha80);
            al.l(this.dlL, R.color.cp_bg_line_k);
            al.j(this.eAj, R.color.cp_btn_a);
            al.l(this.eAi, R.color.black_alpha80);
            al.j(this.cIu, R.color.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ezZ;
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
        this.eAa.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eAa.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eAm.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eAm.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eyT.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dlL;
    }

    public void aHy() {
        this.eAa.setVisibility(0);
        this.eAc.setVisibility(0);
        this.eAd.setVisibility(8);
        if (this.eAb != null) {
            this.eAb.clearAnimation();
        }
        this.eAf.pV();
        this.eAg.setVisibility(8);
        this.eAi.setVisibility(8);
        e.iB().removeCallbacks(this.eAn);
        e.iB().removeCallbacks(this.cIz);
        e.iB().removeCallbacks(this.eAo);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eAk != null) {
            this.eAk.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eAl = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aXV();
    }

    public void startPlayAnimation() {
        if (this.eAc != null) {
            this.eAc.bo();
        }
    }

    public void aXV() {
        if (this.eAc != null) {
            this.eAc.cancelAnimation();
        }
    }
}
