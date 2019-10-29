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
    private View aqA;
    private TextView cUm;
    private TbImageView.a cUo;
    private g.b cUp;
    private Runnable cUr;
    private QuickVideoView.b cUt;
    private g.f ddL;
    private QuickVideoView dwx;
    private LinearLayout eOo;
    private TextView ePA;
    private View ePB;
    private TextView ePC;
    private n ePD;
    private View.OnClickListener ePE;
    private TextView ePF;
    private Runnable ePG;
    private Runnable ePH;
    private a ePt;
    private TbImageView ePu;
    private TBLottieAnimationView ePv;
    private FrameLayout ePw;
    private Animation ePx;
    private AudioAnimationView ePy;
    private View ePz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ePu != null) {
                    AlaVideoContainer.this.ePu.setDefaultBgResource(0);
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
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.ePE != null) {
                            AlaVideoContainer.this.ePE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ePy.start();
                AlaVideoContainer.this.ePw.setVisibility(8);
                AlaVideoContainer.this.ePu.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.ePG, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.ePH);
            }
        };
        this.ePG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqA != null) {
                    AlaVideoContainer.this.aqA.startAnimation(AlaVideoContainer.this.ePx);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fZ().post(AlaVideoContainer.this.ePH);
                return false;
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.ePH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ePz.setVisibility(0);
                AlaVideoContainer.this.ePw.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cUr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ePu != null) {
                    AlaVideoContainer.this.ePu.setDefaultBgResource(0);
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
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.ePE != null) {
                            AlaVideoContainer.this.ePE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ePy.start();
                AlaVideoContainer.this.ePw.setVisibility(8);
                AlaVideoContainer.this.ePu.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.ePG, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.ePH);
            }
        };
        this.ePG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqA != null) {
                    AlaVideoContainer.this.aqA.startAnimation(AlaVideoContainer.this.ePx);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.fZ().post(AlaVideoContainer.this.ePH);
                return false;
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.ePH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ePz.setVisibility(0);
                AlaVideoContainer.this.ePw.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cUr, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cUo = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.ePu != null) {
                    AlaVideoContainer.this.ePu.setDefaultBgResource(0);
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
                    if (j.isNetWorkAvailable()) {
                        if (AlaVideoContainer.this.ePE != null) {
                            AlaVideoContainer.this.ePE.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ePy.start();
                AlaVideoContainer.this.ePw.setVisibility(8);
                AlaVideoContainer.this.ePu.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.ePG, 3000L);
                e.fZ().removeCallbacks(AlaVideoContainer.this.ePH);
            }
        };
        this.ePG = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aqA != null) {
                    AlaVideoContainer.this.aqA.startAnimation(AlaVideoContainer.this.ePx);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.fZ().post(AlaVideoContainer.this.ePH);
                return false;
            }
        };
        this.cUr = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aJf();
            }
        };
        this.ePH = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ePz.setVisibility(0);
                AlaVideoContainer.this.ePw.setVisibility(8);
                e.fZ().postDelayed(AlaVideoContainer.this.cUr, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dwx = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dwx.getLayoutParams();
        layoutParams.height = (this.dwx.getWidth() * 9) / 16;
        this.dwx.setLayoutParams(layoutParams);
        this.ePD = new n(getContext());
        this.ePD.ccx();
        this.dwx.setBusiness(this.ePD);
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        this.dwx.setOnErrorListener(this.cUp);
        this.ePu = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.ePu.setDefaultErrorResource(0);
        this.ePu.setDrawCorner(true);
        this.ePu.setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
        this.ePu.setEvent(this.cUo);
        this.ePu.setGifIconSupport(false);
        TbImageView tbImageView = this.ePu;
        TbImageView tbImageView2 = this.ePu;
        tbImageView.setConrers(15);
        this.ePu.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.ePu.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ePu.setBorderColor(am.getColor(R.color.black_alpha8));
        this.ePu.setBorderSurroundContent(true);
        this.ePu.setDrawBorder(true);
        this.aqA = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.ePv = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.ePv.loop(true);
        this.ePw = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.ePx = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.ePy = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.ePy.setCertainColumnCount(4);
        this.ePy.setColumnColor(R.color.cp_cont_a);
        this.ePz = inflate.findViewById(R.id.layout_error);
        this.ePA = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.ePB = inflate.findViewById(R.id.layout_live_end);
        this.ePC = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eOo = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.ePF = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.ePt = new a(this);
        this.cUm = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.ePv, R.raw.ala_play);
            am.setViewTextColor(this.ePA, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.ePz, R.color.black_alpha80);
            am.setBackgroundColor(this.dwx, R.color.black_alpha100);
            am.setViewTextColor(this.ePC, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.ePB, R.color.black_alpha80);
            am.setViewTextColor(this.cUm, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ePt;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cUm != null) {
            this.cUm.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ePu.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ePu.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.ePF.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.ePF.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eOo.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dwx;
    }

    public void aJf() {
        this.ePu.setVisibility(0);
        this.ePv.setVisibility(0);
        this.ePw.setVisibility(8);
        if (this.aqA != null) {
            this.aqA.clearAnimation();
        }
        this.ePy.ll();
        this.ePz.setVisibility(8);
        this.ePB.setVisibility(8);
        e.fZ().removeCallbacks(this.ePG);
        e.fZ().removeCallbacks(this.cUr);
        e.fZ().removeCallbacks(this.ePH);
    }

    public void setVideoStatsData(z zVar) {
        if (this.ePD != null) {
            this.ePD.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ePE = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        baF();
    }

    public void startPlayAnimation() {
        if (this.ePv != null) {
            this.ePv.playAnimation();
        }
    }

    public void baF() {
        if (this.ePv != null) {
            this.ePv.cancelAnimation();
        }
    }
}
