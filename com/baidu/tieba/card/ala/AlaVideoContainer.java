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
    private View aCX;
    private TextView dMc;
    private TbImageView.a dMe;
    private g.b dMf;
    private Runnable dMh;
    private QuickVideoView.b dMj;
    private g.f dVc;
    private QuickVideoView ekW;
    private LinearLayout fKT;
    private a fLX;
    private TbImageView fLY;
    private TBLottieAnimationView fLZ;
    private FrameLayout fMa;
    private Animation fMb;
    private AudioAnimationView fMc;
    private View fMd;
    private TextView fMe;
    private View fMf;
    private TextView fMg;
    private n fMh;
    private View.OnClickListener fMi;
    private TextView fMj;
    private Runnable fMk;
    private Runnable fMl;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fLY != null) {
                    AlaVideoContainer.this.fLY.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMi != null) {
                            AlaVideoContainer.this.fMi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMc.start();
                AlaVideoContainer.this.fMa.setVisibility(8);
                AlaVideoContainer.this.fLY.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMk, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMl);
            }
        };
        this.fMk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCX != null) {
                    AlaVideoContainer.this.aCX.startAnimation(AlaVideoContainer.this.fMb);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMl);
                return false;
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.fMl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMd.setVisibility(0);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMh, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fLY != null) {
                    AlaVideoContainer.this.fLY.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMi != null) {
                            AlaVideoContainer.this.fMi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMc.start();
                AlaVideoContainer.this.fMa.setVisibility(8);
                AlaVideoContainer.this.fLY.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMk, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMl);
            }
        };
        this.fMk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCX != null) {
                    AlaVideoContainer.this.aCX.startAnimation(AlaVideoContainer.this.fMb);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMl);
                return false;
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.fMl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMd.setVisibility(0);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMh, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dMe = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fLY != null) {
                    AlaVideoContainer.this.fLY.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMi != null) {
                            AlaVideoContainer.this.fMi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMc.start();
                AlaVideoContainer.this.fMa.setVisibility(8);
                AlaVideoContainer.this.fLY.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMk, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMl);
            }
        };
        this.fMk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCX != null) {
                    AlaVideoContainer.this.aCX.startAnimation(AlaVideoContainer.this.fMb);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gx().post(AlaVideoContainer.this.fMl);
                return false;
            }
        };
        this.dMh = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcm();
            }
        };
        this.fMl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMd.setVisibility(0);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMh, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.ekW = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.ekW.getLayoutParams();
        layoutParams.height = (this.ekW.getWidth() * 9) / 16;
        this.ekW.setLayoutParams(layoutParams);
        this.fMh = new n(getContext());
        this.fMh.cyW();
        this.ekW.setBusiness(this.fMh);
        this.ekW.setOnPreparedListener(this.dVc);
        this.ekW.setOnSurfaceDestroyedListener(this.dMj);
        this.ekW.setOnErrorListener(this.dMf);
        this.fLY = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fLY.setDefaultErrorResource(0);
        this.fLY.setDrawCorner(true);
        this.fLY.setPlaceHolder(3);
        this.fLY.setEvent(this.dMe);
        this.fLY.setGifIconSupport(false);
        TbImageView tbImageView = this.fLY;
        TbImageView tbImageView2 = this.fLY;
        tbImageView.setConrers(15);
        this.fLY.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fLY.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fLY.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fLY.setBorderSurroundContent(true);
        this.fLY.setDrawBorder(true);
        this.aCX = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fLZ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fLZ.loop(true);
        this.fMa = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fMb = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fMc = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fMc.setCertainColumnCount(4);
        this.fMc.setColumnColor(R.color.cp_cont_a);
        this.fMd = inflate.findViewById(R.id.layout_error);
        this.fMe = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fMf = inflate.findViewById(R.id.layout_live_end);
        this.fMg = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fKT = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fMj = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fLX = new a(this);
        this.dMc = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fLZ, R.raw.ala_play);
            am.setViewTextColor(this.fMe, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMd, R.color.black_alpha80);
            am.setBackgroundColor(this.ekW, R.color.black_alpha100);
            am.setViewTextColor(this.fMg, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMf, R.color.black_alpha80);
            am.setViewTextColor(this.dMc, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fLX;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dMc != null) {
            this.dMc.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fLY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fLY.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fMj.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fMj.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fKT.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.ekW;
    }

    public void bcm() {
        this.fLY.setVisibility(0);
        this.fLZ.setVisibility(0);
        this.fMa.setVisibility(8);
        if (this.aCX != null) {
            this.aCX.clearAnimation();
        }
        this.fMc.lS();
        this.fMd.setVisibility(8);
        this.fMf.setVisibility(8);
        e.gx().removeCallbacks(this.fMk);
        e.gx().removeCallbacks(this.dMh);
        e.gx().removeCallbacks(this.fMl);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fMh != null) {
            this.fMh.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fMi = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvn();
    }

    public void startPlayAnimation() {
        if (this.fLZ != null) {
            this.fLZ.playAnimation();
        }
    }

    public void bvn() {
        if (this.fLZ != null) {
            this.fLZ.cancelAnimation();
        }
    }
}
