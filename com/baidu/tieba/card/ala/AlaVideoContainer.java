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
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes3.dex */
public class AlaVideoContainer extends LinearLayout {
    private TextView cAm;
    private TbImageView.a cAo;
    private g.b cAp;
    private Runnable cAr;
    private QuickVideoView.b cAt;
    private g.f cJJ;
    private QuickVideoView dbg;
    private LinearLayout ejf;
    private Runnable ekA;
    private a ekl;
    private TbImageView ekm;
    private View ekn;
    private TBLottieAnimationView eko;
    private FrameLayout ekp;
    private Animation ekq;
    private AudioAnimationView ekr;
    private View eks;
    private TextView ekt;
    private View eku;
    private TextView ekv;
    private n ekw;
    private View.OnClickListener ekx;
    private TextView eky;
    private Runnable ekz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekx != null) {
                            AlaVideoContainer.this.ekx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekr.start();
                AlaVideoContainer.this.ekp.setVisibility(8);
                AlaVideoContainer.this.ekm.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekz, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekA);
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekn != null) {
                    AlaVideoContainer.this.ekn.startAnimation(AlaVideoContainer.this.ekq);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekA);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eks.setVisibility(0);
                AlaVideoContainer.this.ekp.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekx != null) {
                            AlaVideoContainer.this.ekx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekr.start();
                AlaVideoContainer.this.ekp.setVisibility(8);
                AlaVideoContainer.this.ekm.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekz, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekA);
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekn != null) {
                    AlaVideoContainer.this.ekn.startAnimation(AlaVideoContainer.this.ekq);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekA);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eks.setVisibility(0);
                AlaVideoContainer.this.ekp.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cAo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekx != null) {
                            AlaVideoContainer.this.ekx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekr.start();
                AlaVideoContainer.this.ekp.setVisibility(8);
                AlaVideoContainer.this.ekm.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekz, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekA);
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekn != null) {
                    AlaVideoContainer.this.ekn.startAnimation(AlaVideoContainer.this.ekq);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.jH().post(AlaVideoContainer.this.ekA);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eks.setVisibility(0);
                AlaVideoContainer.this.ekp.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAr, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dbg = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.dbg.getLayoutParams();
        layoutParams.height = (this.dbg.getWidth() * 9) / 16;
        this.dbg.setLayoutParams(layoutParams);
        this.ekw = new n(getContext());
        this.ekw.bTu();
        this.dbg.setBusiness(this.ekw);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnErrorListener(this.cAp);
        this.ekm = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.ekm.setDefaultErrorResource(0);
        this.ekm.setDrawCorner(true);
        this.ekm.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.ekm.setEvent(this.cAo);
        this.ekm.setGifIconSupport(false);
        TbImageView tbImageView = this.ekm;
        TbImageView tbImageView2 = this.ekm;
        tbImageView.setConrers(15);
        this.ekm.setRadius(l.h(getContext(), d.e.tbds20));
        this.ekm.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.ekm.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.ekm.setBorderSurroundContent(true);
        this.ekm.setDrawBorder(true);
        this.ekn = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.eko = (TBLottieAnimationView) inflate.findViewById(d.g.img_play);
        this.eko.G(true);
        this.ekp = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.ekq = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.ekr = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.ekr.setCertainColumnCount(4);
        this.ekr.setColumnColor(d.C0277d.cp_btn_a);
        this.eks = inflate.findViewById(d.g.layout_error);
        this.ekt = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.eku = inflate.findViewById(d.g.layout_live_end);
        this.ekv = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ejf = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.eky = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.ekl = new a(this);
        this.cAm = (TextView) inflate.findViewById(d.g.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, d.C0277d.cp_btn_a);
            }
            al.a(this.eko, d.i.ala_play);
            al.j(this.ekt, d.C0277d.cp_btn_a);
            al.l(this.eks, d.C0277d.black_alpha80);
            al.l(this.dbg, d.C0277d.cp_bg_line_k);
            al.j(this.ekv, d.C0277d.cp_btn_a);
            al.l(this.eku, d.C0277d.black_alpha80);
            al.j(this.cAm, d.C0277d.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ekl;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cAm != null) {
            this.cAm.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ekm.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ekm.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eky.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eky.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ejf.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public void aBh() {
        this.ekm.setVisibility(0);
        this.eko.setVisibility(0);
        this.ekp.setVisibility(8);
        if (this.ekn != null) {
            this.ekn.clearAnimation();
        }
        this.ekr.ra();
        this.eks.setVisibility(8);
        this.eku.setVisibility(8);
        e.jH().removeCallbacks(this.ekz);
        e.jH().removeCallbacks(this.cAr);
        e.jH().removeCallbacks(this.ekA);
    }

    public void setVideoStatsData(z zVar) {
        if (this.ekw != null) {
            this.ekw.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ekx = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aQM();
    }

    public void startPlayAnimation() {
        if (this.eko != null) {
            this.eko.cu();
        }
    }

    public void aQM() {
        if (this.eko != null) {
            this.eko.cancelAnimation();
        }
    }
}
