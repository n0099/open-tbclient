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
    private LinearLayout ejw;
    private a ekC;
    private TbImageView ekD;
    private View ekE;
    private TBLottieAnimationView ekF;
    private FrameLayout ekG;
    private Animation ekH;
    private AudioAnimationView ekI;
    private View ekJ;
    private TextView ekK;
    private View ekL;
    private TextView ekM;
    private n ekN;
    private View.OnClickListener ekO;
    private TextView ekP;
    private Runnable ekQ;
    private Runnable ekR;
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
                if (z && AlaVideoContainer.this.ekD != null) {
                    AlaVideoContainer.this.ekD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekO != null) {
                            AlaVideoContainer.this.ekO.onClick(view);
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
                AlaVideoContainer.this.ekI.start();
                AlaVideoContainer.this.ekG.setVisibility(8);
                AlaVideoContainer.this.ekD.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekQ, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekR);
            }
        };
        this.ekQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekE != null) {
                    AlaVideoContainer.this.ekE.startAnimation(AlaVideoContainer.this.ekH);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekR);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.ekR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekJ.setVisibility(0);
                AlaVideoContainer.this.ekG.setVisibility(8);
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
                if (z && AlaVideoContainer.this.ekD != null) {
                    AlaVideoContainer.this.ekD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekO != null) {
                            AlaVideoContainer.this.ekO.onClick(view);
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
                AlaVideoContainer.this.ekI.start();
                AlaVideoContainer.this.ekG.setVisibility(8);
                AlaVideoContainer.this.ekD.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekQ, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekR);
            }
        };
        this.ekQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekE != null) {
                    AlaVideoContainer.this.ekE.startAnimation(AlaVideoContainer.this.ekH);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekR);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.ekR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekJ.setVisibility(0);
                AlaVideoContainer.this.ekG.setVisibility(8);
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
                if (z && AlaVideoContainer.this.ekD != null) {
                    AlaVideoContainer.this.ekD.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.ekO != null) {
                            AlaVideoContainer.this.ekO.onClick(view);
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
                AlaVideoContainer.this.ekI.start();
                AlaVideoContainer.this.ekG.setVisibility(8);
                AlaVideoContainer.this.ekD.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.ekQ, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekR);
            }
        };
        this.ekQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekE != null) {
                    AlaVideoContainer.this.ekE.startAnimation(AlaVideoContainer.this.ekH);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.jH().post(AlaVideoContainer.this.ekR);
                return false;
            }
        };
        this.cAr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBl();
            }
        };
        this.ekR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekJ.setVisibility(0);
                AlaVideoContainer.this.ekG.setVisibility(8);
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
        this.ekN = new n(getContext());
        this.ekN.bTw();
        this.dbg.setBusiness(this.ekN);
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.dbg.setOnErrorListener(this.cAp);
        this.ekD = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.ekD.setDefaultErrorResource(0);
        this.ekD.setDrawCorner(true);
        this.ekD.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.ekD.setEvent(this.cAo);
        this.ekD.setGifIconSupport(false);
        TbImageView tbImageView = this.ekD;
        TbImageView tbImageView2 = this.ekD;
        tbImageView.setConrers(15);
        this.ekD.setRadius(l.h(getContext(), d.e.tbds20));
        this.ekD.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.ekD.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        this.ekD.setBorderSurroundContent(true);
        this.ekD.setDrawBorder(true);
        this.ekE = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.ekF = (TBLottieAnimationView) inflate.findViewById(d.g.img_play);
        this.ekF.G(true);
        this.ekG = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.ekH = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.ekI = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.ekI.setCertainColumnCount(4);
        this.ekI.setColumnColor(d.C0236d.cp_btn_a);
        this.ekJ = inflate.findViewById(d.g.layout_error);
        this.ekK = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.ekL = inflate.findViewById(d.g.layout_live_end);
        this.ekM = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.ejw = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.ekP = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.ekC = new a(this);
        this.cAm = (TextView) inflate.findViewById(d.g.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, d.C0236d.cp_btn_a);
            }
            al.a(this.ekF, d.i.ala_play);
            al.j(this.ekK, d.C0236d.cp_btn_a);
            al.l(this.ekJ, d.C0236d.black_alpha80);
            al.l(this.dbg, d.C0236d.cp_bg_line_k);
            al.j(this.ekM, d.C0236d.cp_btn_a);
            al.l(this.ekL, d.C0236d.black_alpha80);
            al.j(this.cAm, d.C0236d.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ekC;
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
        this.ekD.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ekD.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.ekP.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.ekP.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.ejw.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dbg;
    }

    public void aBl() {
        this.ekD.setVisibility(0);
        this.ekF.setVisibility(0);
        this.ekG.setVisibility(8);
        if (this.ekE != null) {
            this.ekE.clearAnimation();
        }
        this.ekI.ra();
        this.ekJ.setVisibility(8);
        this.ekL.setVisibility(8);
        e.jH().removeCallbacks(this.ekQ);
        e.jH().removeCallbacks(this.cAr);
        e.jH().removeCallbacks(this.ekR);
    }

    public void setVideoStatsData(z zVar) {
        if (this.ekN != null) {
            this.ekN.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ekO = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aQP();
    }

    public void startPlayAnimation() {
        if (this.ekF != null) {
            this.ekF.cu();
        }
    }

    public void aQP() {
        if (this.ekF != null) {
            this.ekF.cancelAnimation();
        }
    }
}
