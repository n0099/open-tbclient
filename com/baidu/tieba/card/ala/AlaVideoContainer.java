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
    private TextView eBh;
    private TbImageView.a eBj;
    private g.b eBk;
    private Runnable eBm;
    private QuickVideoView.b eBo;
    private g.f eKm;
    private QuickVideoView fbM;
    private LinearLayout gFs;
    private Animation gGA;
    private AudioAnimationView gGB;
    private View gGC;
    private TextView gGD;
    private View gGE;
    private TextView gGF;
    private n gGG;
    private View.OnClickListener gGH;
    private TextView gGI;
    private Runnable gGJ;
    private Runnable gGK;
    private a gGw;
    private TbImageView gGx;
    private TBLottieAnimationView gGy;
    private FrameLayout gGz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGx != null) {
                    AlaVideoContainer.this.gGx.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGH != null) {
                            AlaVideoContainer.this.gGH.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGB.start();
                AlaVideoContainer.this.gGz.setVisibility(8);
                AlaVideoContainer.this.gGx.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGJ, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGK);
            }
        };
        this.gGJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGA);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ld().post(AlaVideoContainer.this.gGK);
                return false;
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.gGK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGC.setVisibility(0);
                AlaVideoContainer.this.gGz.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBm, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGx != null) {
                    AlaVideoContainer.this.gGx.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGH != null) {
                            AlaVideoContainer.this.gGH.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGB.start();
                AlaVideoContainer.this.gGz.setVisibility(8);
                AlaVideoContainer.this.gGx.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGJ, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGK);
            }
        };
        this.gGJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGA);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.ld().post(AlaVideoContainer.this.gGK);
                return false;
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.gGK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGC.setVisibility(0);
                AlaVideoContainer.this.gGz.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBm, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eBj = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gGx != null) {
                    AlaVideoContainer.this.gGx.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gGH != null) {
                            AlaVideoContainer.this.gGH.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gGB.start();
                AlaVideoContainer.this.gGz.setVisibility(8);
                AlaVideoContainer.this.gGx.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.gGJ, 3000L);
                e.ld().removeCallbacks(AlaVideoContainer.this.gGK);
            }
        };
        this.gGJ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ber != null) {
                    AlaVideoContainer.this.ber.startAnimation(AlaVideoContainer.this.gGA);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.ld().post(AlaVideoContainer.this.gGK);
                return false;
            }
        };
        this.eBm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bqE();
            }
        };
        this.gGK = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gGC.setVisibility(0);
                AlaVideoContainer.this.gGz.setVisibility(8);
                e.ld().postDelayed(AlaVideoContainer.this.eBm, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fbM = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.fbM.getLayoutParams();
        layoutParams.height = (this.fbM.getWidth() * 9) / 16;
        this.fbM.setLayoutParams(layoutParams);
        this.gGG = new n(getContext());
        this.gGG.cQU();
        this.fbM.setBusiness(this.gGG);
        this.fbM.setOnPreparedListener(this.eKm);
        this.fbM.setOnSurfaceDestroyedListener(this.eBo);
        this.fbM.setOnErrorListener(this.eBk);
        this.gGx = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.gGx.setDefaultErrorResource(0);
        this.gGx.setDrawCorner(true);
        this.gGx.setPlaceHolder(3);
        this.gGx.setEvent(this.eBj);
        this.gGx.setGifIconSupport(false);
        TbImageView tbImageView = this.gGx;
        TbImageView tbImageView2 = this.gGx;
        tbImageView.setConrers(15);
        this.gGx.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.gGx.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gGx.setBorderColor(am.getColor(R.color.cp_border_a));
        this.gGx.setBorderSurroundContent(true);
        this.gGx.setDrawBorder(true);
        this.ber = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.gGy = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.gGy.loop(true);
        this.gGz = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.gGA = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.gGB = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.gGB.setCertainColumnCount(4);
        this.gGB.setColumnColor(R.color.cp_cont_a);
        this.gGC = inflate.findViewById(R.id.layout_error);
        this.gGD = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.gGE = inflate.findViewById(R.id.layout_live_end);
        this.gGF = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gFs = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.gGI = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.gGw = new a(this);
        this.eBh = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.gGy, (int) R.raw.ala_play);
            am.setViewTextColor(this.gGD, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.gGC, R.color.black_alpha80);
            am.setBackgroundColor(this.fbM, R.color.black_alpha100);
            am.setViewTextColor(this.gGF, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.gGE, R.color.black_alpha80);
            am.setViewTextColor(this.eBh, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.gGw;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.eBh != null) {
            this.eBh.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.gGx.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gGx.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.gGI.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.gGI.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gFs.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.fbM;
    }

    public void bqE() {
        this.gGx.setVisibility(0);
        this.gGy.setVisibility(0);
        this.gGz.setVisibility(8);
        if (this.ber != null) {
            this.ber.clearAnimation();
        }
        this.gGB.qA();
        this.gGC.setVisibility(8);
        this.gGE.setVisibility(8);
        e.ld().removeCallbacks(this.gGJ);
        e.ld().removeCallbacks(this.eBm);
        e.ld().removeCallbacks(this.gGK);
    }

    public void setVideoStatsData(y yVar) {
        if (this.gGG != null) {
            this.gGG.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.gGH = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLy();
    }

    public void startPlayAnimation() {
        if (this.gGy != null) {
            this.gGy.playAnimation();
        }
    }

    public void bLy() {
        if (this.gGy != null) {
            this.gGy.cancelAnimation();
        }
    }
}
