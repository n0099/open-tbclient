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
import com.baidu.adp.lib.f.e;
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
import com.baidu.tieba.play.y;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes8.dex */
public class AlaVideoContainer extends LinearLayout {
    private View ber;
    private TextView eBs;
    private TbImageView.a eBu;
    private g.b eBv;
    private Runnable eBx;
    private QuickVideoView.b eBz;
    private g.f eKx;
    private QuickVideoView fbX;
    private LinearLayout gFD;
    private a gGH;
    private TbImageView gGI;
    private TBLottieAnimationView gGJ;
    private FrameLayout gGK;
    private Animation gGL;
    private AudioAnimationView gGM;
    private View gGN;
    private TextView gGO;
    private View gGP;
    private TextView gGQ;
    private n gGR;
    private View.OnClickListener gGS;
    private TextView gGT;
    private Runnable gGU;
    private Runnable gGV;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGI != null) {
                    AlaVideoContainer.this.gGI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGS != null) {
                            AlaVideoContainer.this.gGS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGM.start();
                AlaVideoContainer.this.gGK.setVisibility(8);
                AlaVideoContainer.this.gGI.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGU, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGV);
            }
        };
        this.gGU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGL);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ld().post(AlaVideoContainer.this.gGV);
                return false;
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.gGV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGN.setVisibility(0);
                AlaVideoContainer.this.gGK.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBx, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGI != null) {
                    AlaVideoContainer.this.gGI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGS != null) {
                            AlaVideoContainer.this.gGS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGM.start();
                AlaVideoContainer.this.gGK.setVisibility(8);
                AlaVideoContainer.this.gGI.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGU, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGV);
            }
        };
        this.gGU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGL);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ld().post(AlaVideoContainer.this.gGV);
                return false;
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.gGV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGN.setVisibility(0);
                AlaVideoContainer.this.gGK.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBx, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eBu = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGI != null) {
                    AlaVideoContainer.this.gGI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGS != null) {
                            AlaVideoContainer.this.gGS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGM.start();
                AlaVideoContainer.this.gGK.setVisibility(8);
                AlaVideoContainer.this.gGI.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGU, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGV);
            }
        };
        this.gGU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGL);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ld().post(AlaVideoContainer.this.gGV);
                return false;
            }
        };
        this.eBx = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqG();
            }
        };
        this.gGV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGN.setVisibility(0);
                AlaVideoContainer.this.gGK.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBx, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fbX = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.fbX.getLayoutParams();
        layoutParams.height = (this.fbX.getWidth() * 9) / 16;
        this.fbX.setLayoutParams(layoutParams);
        this.gGR = new n(getContext());
        this.gGR.cRk();
        this.fbX.setBusiness(this.gGR);
        this.fbX.setOnPreparedListener(this.eKx);
        this.fbX.setOnSurfaceDestroyedListener(this.eBz);
        this.fbX.setOnErrorListener(this.eBv);
        this.gGI = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.gGI.setDefaultErrorResource(0);
        this.gGI.setDrawCorner(true);
        this.gGI.setPlaceHolder(3);
        this.gGI.setEvent(this.eBu);
        this.gGI.setGifIconSupport(false);
        TbImageView tbImageView = this.gGI;
        TbImageView tbImageView2 = this.gGI;
        tbImageView.setConrers(15);
        this.gGI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.gGI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gGI.setBorderColor(am.getColor(R.color.cp_border_a));
        this.gGI.setBorderSurroundContent(true);
        this.gGI.setDrawBorder(true);
        this.ber = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.gGJ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.gGJ.loop(true);
        this.gGK = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.gGL = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.gGM = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.gGM.setCertainColumnCount(4);
        this.gGM.setColumnColor(R.color.cp_cont_a);
        this.gGN = inflate.findViewById(R.id.layout_error);
        this.gGO = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.gGP = inflate.findViewById(R.id.layout_live_end);
        this.gGQ = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gFD = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.gGT = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.gGH = new a(this);
        this.eBs = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.gGJ, (int) R.raw.ala_play);
            am.setViewTextColor(this.gGO, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.gGN, R.color.black_alpha80);
            am.setBackgroundColor(this.fbX, R.color.black_alpha100);
            am.setViewTextColor(this.gGQ, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.gGP, R.color.black_alpha80);
            am.setViewTextColor(this.eBs, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.gGH;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.eBs != null) {
            this.eBs.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.gGI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gGI.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.gGT.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.gGT.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gFD.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.fbX;
    }

    public void bqG() {
        this.gGI.setVisibility(0);
        this.gGJ.setVisibility(0);
        this.gGK.setVisibility(8);
        if (this.ber != null) {
            this.ber.clearAnimation();
        }
        this.gGM.qA();
        this.gGN.setVisibility(8);
        this.gGP.setVisibility(8);
        e.ld().removeCallbacks(this.gGU);
        e.ld().removeCallbacks(this.eBx);
        e.ld().removeCallbacks(this.gGV);
    }

    public void setVideoStatsData(y yVar) {
        if (this.gGR != null) {
            this.gGR.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.gGS = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLA();
    }

    public void startPlayAnimation() {
        if (this.gGJ != null) {
            this.gGJ.playAnimation();
        }
    }

    public void bLA() {
        if (this.gGJ != null) {
            this.gGJ.cancelAnimation();
        }
    }
}
