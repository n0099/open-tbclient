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
    private TextView cKM;
    private TbImageView.a cKO;
    private g.b cKP;
    private Runnable cKR;
    private QuickVideoView.b cKT;
    private g.f cUq;
    private QuickVideoView dpn;
    private LinearLayout eFH;
    private a eGM;
    private TbImageView eGN;
    private View eGO;
    private TBLottieAnimationView eGP;
    private FrameLayout eGQ;
    private Animation eGR;
    private AudioAnimationView eGS;
    private View eGT;
    private TextView eGU;
    private View eGV;
    private TextView eGW;
    private n eGX;
    private View.OnClickListener eGY;
    private TextView eGZ;
    private Runnable eHa;
    private Runnable eHb;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eGN != null) {
                    AlaVideoContainer.this.eGN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eGY != null) {
                            AlaVideoContainer.this.eGY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eGS.start();
                AlaVideoContainer.this.eGQ.setVisibility(8);
                AlaVideoContainer.this.eGN.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eHa, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eHb);
            }
        };
        this.eHa = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eGO != null) {
                    AlaVideoContainer.this.eGO.startAnimation(AlaVideoContainer.this.eGR);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eHb);
                return false;
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.eHb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eGT.setVisibility(0);
                AlaVideoContainer.this.eGQ.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKR, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eGN != null) {
                    AlaVideoContainer.this.eGN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eGY != null) {
                            AlaVideoContainer.this.eGY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eGS.start();
                AlaVideoContainer.this.eGQ.setVisibility(8);
                AlaVideoContainer.this.eGN.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eHa, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eHb);
            }
        };
        this.eHa = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eGO != null) {
                    AlaVideoContainer.this.eGO.startAnimation(AlaVideoContainer.this.eGR);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eHb);
                return false;
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.eHb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eGT.setVisibility(0);
                AlaVideoContainer.this.eGQ.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKR, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cKO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eGN != null) {
                    AlaVideoContainer.this.eGN.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.eGY != null) {
                            AlaVideoContainer.this.eGY.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eGS.start();
                AlaVideoContainer.this.eGQ.setVisibility(8);
                AlaVideoContainer.this.eGN.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eHa, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eHb);
            }
        };
        this.eHa = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eGO != null) {
                    AlaVideoContainer.this.eGO.startAnimation(AlaVideoContainer.this.eGR);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.iK().post(AlaVideoContainer.this.eHb);
                return false;
            }
        };
        this.cKR = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJE();
            }
        };
        this.eHb = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eGT.setVisibility(0);
                AlaVideoContainer.this.eGQ.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cKR, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dpn = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dpn.getLayoutParams();
        layoutParams.height = (this.dpn.getWidth() * 9) / 16;
        this.dpn.setLayoutParams(layoutParams);
        this.eGX = new n(getContext());
        this.eGX.cfv();
        this.dpn.setBusiness(this.eGX);
        this.dpn.setOnPreparedListener(this.cUq);
        this.dpn.setOnSurfaceDestroyedListener(this.cKT);
        this.dpn.setOnErrorListener(this.cKP);
        this.eGN = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eGN.setDefaultErrorResource(0);
        this.eGN.setDrawCorner(true);
        this.eGN.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        this.eGN.setEvent(this.cKO);
        this.eGN.setGifIconSupport(false);
        TbImageView tbImageView = this.eGN;
        TbImageView tbImageView2 = this.eGN;
        tbImageView.setConrers(15);
        this.eGN.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eGN.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eGN.setBorderColor(am.getColor(R.color.black_alpha8));
        this.eGN.setBorderSurroundContent(true);
        this.eGN.setDrawBorder(true);
        this.eGO = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eGP = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eGP.y(true);
        this.eGQ = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eGR = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eGS = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eGS.setCertainColumnCount(4);
        this.eGS.setColumnColor(R.color.cp_cont_a);
        this.eGT = inflate.findViewById(R.id.layout_error);
        this.eGU = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eGV = inflate.findViewById(R.id.layout_live_end);
        this.eGW = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eFH = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eGZ = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.eGM = new a(this);
        this.cKM = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.j(this.mTitle, R.color.cp_cont_a);
            }
            am.a(this.eGP, (int) R.raw.ala_play);
            am.j(this.eGU, R.color.cp_cont_a);
            am.l(this.eGT, R.color.black_alpha80);
            am.l(this.dpn, R.color.black_alpha100);
            am.j(this.eGW, R.color.cp_cont_a);
            am.l(this.eGV, R.color.black_alpha80);
            am.j(this.cKM, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eGM;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cKM != null) {
            this.cKM.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.eGN.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eGN.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eGZ.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eGZ.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eFH.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dpn;
    }

    public void aJE() {
        this.eGN.setVisibility(0);
        this.eGP.setVisibility(0);
        this.eGQ.setVisibility(8);
        if (this.eGO != null) {
            this.eGO.clearAnimation();
        }
        this.eGS.qs();
        this.eGT.setVisibility(8);
        this.eGV.setVisibility(8);
        e.iK().removeCallbacks(this.eHa);
        e.iK().removeCallbacks(this.cKR);
        e.iK().removeCallbacks(this.eHb);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eGX != null) {
            this.eGX.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eGY = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        baC();
    }

    public void startPlayAnimation() {
        if (this.eGP != null) {
            this.eGP.br();
        }
    }

    public void baC() {
        if (this.eGP != null) {
            this.eGP.cancelAnimation();
        }
    }
}
