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
    private TextView cAj;
    private TbImageView.a cAl;
    private g.b cAm;
    private Runnable cAo;
    private QuickVideoView.b cAq;
    private g.f cJG;
    private QuickVideoView dbc;
    private LinearLayout ejs;
    private View ekA;
    private TBLottieAnimationView ekB;
    private FrameLayout ekC;
    private Animation ekD;
    private AudioAnimationView ekE;
    private View ekF;
    private TextView ekG;
    private View ekH;
    private TextView ekI;
    private n ekJ;
    private View.OnClickListener ekK;
    private TextView ekL;
    private Runnable ekM;
    private Runnable ekN;
    private a eky;
    private TbImageView ekz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekz != null) {
                    AlaVideoContainer.this.ekz.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekK != null) {
                            AlaVideoContainer.this.ekK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekE.start();
                AlaVideoContainer.this.ekC.setVisibility(8);
                AlaVideoContainer.this.ekz.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekM, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekN);
            }
        };
        this.ekM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekA != null) {
                    AlaVideoContainer.this.ekA.startAnimation(AlaVideoContainer.this.ekD);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekN);
                return false;
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.ekN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekF.setVisibility(0);
                AlaVideoContainer.this.ekC.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAo, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekz != null) {
                    AlaVideoContainer.this.ekz.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekK != null) {
                            AlaVideoContainer.this.ekK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekE.start();
                AlaVideoContainer.this.ekC.setVisibility(8);
                AlaVideoContainer.this.ekz.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekM, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekN);
            }
        };
        this.ekM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekA != null) {
                    AlaVideoContainer.this.ekA.startAnimation(AlaVideoContainer.this.ekD);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekN);
                return false;
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.ekN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekF.setVisibility(0);
                AlaVideoContainer.this.ekC.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAo, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cAl = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekz != null) {
                    AlaVideoContainer.this.ekz.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekK != null) {
                            AlaVideoContainer.this.ekK.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJG = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekE.start();
                AlaVideoContainer.this.ekC.setVisibility(8);
                AlaVideoContainer.this.ekz.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekM, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekN);
            }
        };
        this.ekM = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekA != null) {
                    AlaVideoContainer.this.ekA.startAnimation(AlaVideoContainer.this.ekD);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.jH().post(AlaVideoContainer.this.ekN);
                return false;
            }
        };
        this.cAo = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBk();
            }
        };
        this.ekN = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekF.setVisibility(0);
                AlaVideoContainer.this.ekC.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAo, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dbc = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.dbc.getLayoutParams();
        layoutParams.height = (this.dbc.getWidth() * 9) / 16;
        this.dbc.setLayoutParams(layoutParams);
        this.ekJ = new n(getContext());
        this.ekJ.bTy();
        this.dbc.setBusiness(this.ekJ);
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        this.dbc.setOnErrorListener(this.cAm);
        this.ekz = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.ekz.setDefaultErrorResource(0);
        this.ekz.setDrawCorner(true);
        this.ekz.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.ekz.setEvent(this.cAl);
        this.ekz.setGifIconSupport(false);
        TbImageView tbImageView = this.ekz;
        TbImageView tbImageView2 = this.ekz;
        tbImageView.setConrers(15);
        this.ekz.setRadius(l.h(getContext(), d.e.tbds20));
        this.ekz.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.ekz.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.ekz.setBorderSurroundContent(true);
        this.ekz.setDrawBorder(true);
        this.ekA = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.ekB = (TBLottieAnimationView) inflate.findViewById(d.g.img_play);
        this.ekB.G(true);
        this.ekC = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.ekD = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.ekE = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.ekE.setCertainColumnCount(4);
        this.ekE.setColumnColor(d.C0277d.cp_btn_a);
        this.ekF = inflate.findViewById(d.g.layout_error);
        this.ekG = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.ekH = inflate.findViewById(d.g.layout_live_end);
        this.ekI = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ejs = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.ekL = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.eky = new a(this);
        this.cAj = (TextView) inflate.findViewById(d.g.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, d.C0277d.cp_btn_a);
            }
            al.a(this.ekB, d.i.ala_play);
            al.j(this.ekG, d.C0277d.cp_btn_a);
            al.l(this.ekF, d.C0277d.black_alpha80);
            al.l(this.dbc, d.C0277d.cp_bg_line_k);
            al.j(this.ekI, d.C0277d.cp_btn_a);
            al.l(this.ekH, d.C0277d.black_alpha80);
            al.j(this.cAj, d.C0277d.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eky;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cAj != null) {
            this.cAj.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ekz.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ekz.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.ekL.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.ekL.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ejs.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dbc;
    }

    public void aBk() {
        this.ekz.setVisibility(0);
        this.ekB.setVisibility(0);
        this.ekC.setVisibility(8);
        if (this.ekA != null) {
            this.ekA.clearAnimation();
        }
        this.ekE.ra();
        this.ekF.setVisibility(8);
        this.ekH.setVisibility(8);
        e.jH().removeCallbacks(this.ekM);
        e.jH().removeCallbacks(this.cAo);
        e.jH().removeCallbacks(this.ekN);
    }

    public void setVideoStatsData(z zVar) {
        if (this.ekJ != null) {
            this.ekJ.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ekK = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aQO();
    }

    public void startPlayAnimation() {
        if (this.ekB != null) {
            this.ekB.cu();
        }
    }

    public void aQO() {
        if (this.ekB != null) {
            this.ekB.cancelAnimation();
        }
    }
}
