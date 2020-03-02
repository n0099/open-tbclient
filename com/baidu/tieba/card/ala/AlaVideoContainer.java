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
    private View aCY;
    private TextView dMd;
    private TbImageView.a dMf;
    private g.b dMg;
    private Runnable dMi;
    private QuickVideoView.b dMk;
    private g.f dVd;
    private QuickVideoView ekX;
    private LinearLayout fKV;
    private a fLZ;
    private TbImageView fMa;
    private TBLottieAnimationView fMb;
    private FrameLayout fMc;
    private Animation fMd;
    private AudioAnimationView fMe;
    private View fMf;
    private TextView fMg;
    private View fMh;
    private TextView fMi;
    private n fMj;
    private View.OnClickListener fMk;
    private TextView fMl;
    private Runnable fMm;
    private Runnable fMn;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMa != null) {
                    AlaVideoContainer.this.fMa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMk != null) {
                            AlaVideoContainer.this.fMk.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMe.start();
                AlaVideoContainer.this.fMc.setVisibility(8);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMm, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMn);
            }
        };
        this.fMm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCY != null) {
                    AlaVideoContainer.this.aCY.startAnimation(AlaVideoContainer.this.fMd);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bco();
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMn);
                return false;
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bco();
            }
        };
        this.fMn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMf.setVisibility(0);
                AlaVideoContainer.this.fMc.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMi, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMa != null) {
                    AlaVideoContainer.this.fMa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMk != null) {
                            AlaVideoContainer.this.fMk.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMe.start();
                AlaVideoContainer.this.fMc.setVisibility(8);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMm, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMn);
            }
        };
        this.fMm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCY != null) {
                    AlaVideoContainer.this.aCY.startAnimation(AlaVideoContainer.this.fMd);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bco();
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMn);
                return false;
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bco();
            }
        };
        this.fMn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMf.setVisibility(0);
                AlaVideoContainer.this.fMc.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMi, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dMf = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMa != null) {
                    AlaVideoContainer.this.fMa.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMk != null) {
                            AlaVideoContainer.this.fMk.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMe.start();
                AlaVideoContainer.this.fMc.setVisibility(8);
                AlaVideoContainer.this.fMa.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMm, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMn);
            }
        };
        this.fMm = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCY != null) {
                    AlaVideoContainer.this.aCY.startAnimation(AlaVideoContainer.this.fMd);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bco();
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gx().post(AlaVideoContainer.this.fMn);
                return false;
            }
        };
        this.dMi = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bco();
            }
        };
        this.fMn = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMf.setVisibility(0);
                AlaVideoContainer.this.fMc.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMi, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.ekX = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.ekX.getLayoutParams();
        layoutParams.height = (this.ekX.getWidth() * 9) / 16;
        this.ekX.setLayoutParams(layoutParams);
        this.fMj = new n(getContext());
        this.fMj.cyY();
        this.ekX.setBusiness(this.fMj);
        this.ekX.setOnPreparedListener(this.dVd);
        this.ekX.setOnSurfaceDestroyedListener(this.dMk);
        this.ekX.setOnErrorListener(this.dMg);
        this.fMa = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fMa.setDefaultErrorResource(0);
        this.fMa.setDrawCorner(true);
        this.fMa.setPlaceHolder(3);
        this.fMa.setEvent(this.dMf);
        this.fMa.setGifIconSupport(false);
        TbImageView tbImageView = this.fMa;
        TbImageView tbImageView2 = this.fMa;
        tbImageView.setConrers(15);
        this.fMa.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fMa.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMa.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fMa.setBorderSurroundContent(true);
        this.fMa.setDrawBorder(true);
        this.aCY = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fMb = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fMb.loop(true);
        this.fMc = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fMd = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fMe = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fMe.setCertainColumnCount(4);
        this.fMe.setColumnColor(R.color.cp_cont_a);
        this.fMf = inflate.findViewById(R.id.layout_error);
        this.fMg = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fMh = inflate.findViewById(R.id.layout_live_end);
        this.fMi = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fKV = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fMl = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fLZ = new a(this);
        this.dMd = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fMb, R.raw.ala_play);
            am.setViewTextColor(this.fMg, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMf, R.color.black_alpha80);
            am.setBackgroundColor(this.ekX, R.color.black_alpha100);
            am.setViewTextColor(this.fMi, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMh, R.color.black_alpha80);
            am.setViewTextColor(this.dMd, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fLZ;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dMd != null) {
            this.dMd.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fMa.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fMa.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fMl.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fMl.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fKV.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.ekX;
    }

    public void bco() {
        this.fMa.setVisibility(0);
        this.fMb.setVisibility(0);
        this.fMc.setVisibility(8);
        if (this.aCY != null) {
            this.aCY.clearAnimation();
        }
        this.fMe.lS();
        this.fMf.setVisibility(8);
        this.fMh.setVisibility(8);
        e.gx().removeCallbacks(this.fMm);
        e.gx().removeCallbacks(this.dMi);
        e.gx().removeCallbacks(this.fMn);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fMj != null) {
            this.fMj.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fMk = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvp();
    }

    public void startPlayAnimation() {
        if (this.fMb != null) {
            this.fMb.playAnimation();
        }
    }

    public void bvp() {
        if (this.fMb != null) {
            this.fMb.cancelAnimation();
        }
    }
}
