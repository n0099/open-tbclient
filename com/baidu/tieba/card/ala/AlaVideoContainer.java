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
/* loaded from: classes5.dex */
public class AlaVideoContainer extends LinearLayout {
    private View axY;
    private TextView dHO;
    private TbImageView.a dHQ;
    private g.b dHR;
    private Runnable dHT;
    private QuickVideoView.b dHV;
    private g.f dQO;
    private QuickVideoView egI;
    private LinearLayout fFm;
    private n fGA;
    private View.OnClickListener fGB;
    private TextView fGC;
    private Runnable fGD;
    private Runnable fGE;
    private a fGq;
    private TbImageView fGr;
    private TBLottieAnimationView fGs;
    private FrameLayout fGt;
    private Animation fGu;
    private AudioAnimationView fGv;
    private View fGw;
    private TextView fGx;
    private View fGy;
    private TextView fGz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fGr != null) {
                    AlaVideoContainer.this.fGr.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fGB != null) {
                            AlaVideoContainer.this.fGB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fGv.start();
                AlaVideoContainer.this.fGt.setVisibility(8);
                AlaVideoContainer.this.fGr.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.fGD, 3000L);
                e.gy().removeCallbacks(AlaVideoContainer.this.fGE);
            }
        };
        this.fGD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.axY != null) {
                    AlaVideoContainer.this.axY.startAnimation(AlaVideoContainer.this.fGu);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gy().post(AlaVideoContainer.this.fGE);
                return false;
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.fGE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fGw.setVisibility(0);
                AlaVideoContainer.this.fGt.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.dHT, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fGr != null) {
                    AlaVideoContainer.this.fGr.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fGB != null) {
                            AlaVideoContainer.this.fGB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fGv.start();
                AlaVideoContainer.this.fGt.setVisibility(8);
                AlaVideoContainer.this.fGr.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.fGD, 3000L);
                e.gy().removeCallbacks(AlaVideoContainer.this.fGE);
            }
        };
        this.fGD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.axY != null) {
                    AlaVideoContainer.this.axY.startAnimation(AlaVideoContainer.this.fGu);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gy().post(AlaVideoContainer.this.fGE);
                return false;
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.fGE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fGw.setVisibility(0);
                AlaVideoContainer.this.fGt.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.dHT, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dHQ = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fGr != null) {
                    AlaVideoContainer.this.fGr.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fGB != null) {
                            AlaVideoContainer.this.fGB.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fGv.start();
                AlaVideoContainer.this.fGt.setVisibility(8);
                AlaVideoContainer.this.fGr.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.fGD, 3000L);
                e.gy().removeCallbacks(AlaVideoContainer.this.fGE);
            }
        };
        this.fGD = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.axY != null) {
                    AlaVideoContainer.this.axY.startAnimation(AlaVideoContainer.this.fGu);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gy().post(AlaVideoContainer.this.fGE);
                return false;
            }
        };
        this.dHT = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aZB();
            }
        };
        this.fGE = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fGw.setVisibility(0);
                AlaVideoContainer.this.fGt.setVisibility(8);
                e.gy().postDelayed(AlaVideoContainer.this.dHT, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.egI = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.egI.getLayoutParams();
        layoutParams.height = (this.egI.getWidth() * 9) / 16;
        this.egI.setLayoutParams(layoutParams);
        this.fGA = new n(getContext());
        this.fGA.cwt();
        this.egI.setBusiness(this.fGA);
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        this.egI.setOnErrorListener(this.dHR);
        this.fGr = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fGr.setDefaultErrorResource(0);
        this.fGr.setDrawCorner(true);
        this.fGr.setPlaceHolder(3);
        this.fGr.setEvent(this.dHQ);
        this.fGr.setGifIconSupport(false);
        TbImageView tbImageView = this.fGr;
        TbImageView tbImageView2 = this.fGr;
        tbImageView.setConrers(15);
        this.fGr.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fGr.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fGr.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fGr.setBorderSurroundContent(true);
        this.fGr.setDrawBorder(true);
        this.axY = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fGs = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fGs.loop(true);
        this.fGt = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fGu = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fGv = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fGv.setCertainColumnCount(4);
        this.fGv.setColumnColor(R.color.cp_cont_a);
        this.fGw = inflate.findViewById(R.id.layout_error);
        this.fGx = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fGy = inflate.findViewById(R.id.layout_live_end);
        this.fGz = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fFm = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fGC = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fGq = new a(this);
        this.dHO = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fGs, R.raw.ala_play);
            am.setViewTextColor(this.fGx, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fGw, R.color.black_alpha80);
            am.setBackgroundColor(this.egI, R.color.black_alpha100);
            am.setViewTextColor(this.fGz, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fGy, R.color.black_alpha80);
            am.setViewTextColor(this.dHO, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fGq;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dHO != null) {
            this.dHO.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fGr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fGr.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fGC.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fGC.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fFm.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.egI;
    }

    public void aZB() {
        this.fGr.setVisibility(0);
        this.fGs.setVisibility(0);
        this.fGt.setVisibility(8);
        if (this.axY != null) {
            this.axY.clearAnimation();
        }
        this.fGv.lD();
        this.fGw.setVisibility(8);
        this.fGy.setVisibility(8);
        e.gy().removeCallbacks(this.fGD);
        e.gy().removeCallbacks(this.dHT);
        e.gy().removeCallbacks(this.fGE);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fGA != null) {
            this.fGA.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fGB = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsH();
    }

    public void startPlayAnimation() {
        if (this.fGs != null) {
            this.fGs.playAnimation();
        }
    }

    public void bsH() {
        if (this.fGs != null) {
            this.fGs.cancelAnimation();
        }
    }
}
