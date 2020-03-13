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
    private View aCZ;
    private TextView dMq;
    private TbImageView.a dMs;
    private g.b dMt;
    private Runnable dMv;
    private QuickVideoView.b dMx;
    private g.f dVq;
    private QuickVideoView elk;
    private LinearLayout fLi;
    private Runnable fMA;
    private a fMm;
    private TbImageView fMn;
    private TBLottieAnimationView fMo;
    private FrameLayout fMp;
    private Animation fMq;
    private AudioAnimationView fMr;
    private View fMs;
    private TextView fMt;
    private View fMu;
    private TextView fMv;
    private n fMw;
    private View.OnClickListener fMx;
    private TextView fMy;
    private Runnable fMz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMn != null) {
                    AlaVideoContainer.this.fMn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMx != null) {
                            AlaVideoContainer.this.fMx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMr.start();
                AlaVideoContainer.this.fMp.setVisibility(8);
                AlaVideoContainer.this.fMn.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMz, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMA);
            }
        };
        this.fMz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCZ != null) {
                    AlaVideoContainer.this.aCZ.startAnimation(AlaVideoContainer.this.fMq);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMA);
                return false;
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.fMA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMs.setVisibility(0);
                AlaVideoContainer.this.fMp.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMv, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMn != null) {
                    AlaVideoContainer.this.fMn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMx != null) {
                            AlaVideoContainer.this.fMx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMr.start();
                AlaVideoContainer.this.fMp.setVisibility(8);
                AlaVideoContainer.this.fMn.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMz, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMA);
            }
        };
        this.fMz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCZ != null) {
                    AlaVideoContainer.this.aCZ.startAnimation(AlaVideoContainer.this.fMq);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.gx().post(AlaVideoContainer.this.fMA);
                return false;
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.fMA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMs.setVisibility(0);
                AlaVideoContainer.this.fMp.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMv, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.dMs = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.fMn != null) {
                    AlaVideoContainer.this.fMn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.fMx != null) {
                            AlaVideoContainer.this.fMx.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dVq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.fMr.start();
                AlaVideoContainer.this.fMp.setVisibility(8);
                AlaVideoContainer.this.fMn.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.fMz, 3000L);
                e.gx().removeCallbacks(AlaVideoContainer.this.fMA);
            }
        };
        this.fMz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.aCZ != null) {
                    AlaVideoContainer.this.aCZ.startAnimation(AlaVideoContainer.this.fMq);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.dMt = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.gx().post(AlaVideoContainer.this.fMA);
                return false;
            }
        };
        this.dMv = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bcp();
            }
        };
        this.fMA = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.fMs.setVisibility(0);
                AlaVideoContainer.this.fMp.setVisibility(8);
                e.gx().postDelayed(AlaVideoContainer.this.dMv, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.elk = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.elk.getLayoutParams();
        layoutParams.height = (this.elk.getWidth() * 9) / 16;
        this.elk.setLayoutParams(layoutParams);
        this.fMw = new n(getContext());
        this.fMw.cyZ();
        this.elk.setBusiness(this.fMw);
        this.elk.setOnPreparedListener(this.dVq);
        this.elk.setOnSurfaceDestroyedListener(this.dMx);
        this.elk.setOnErrorListener(this.dMt);
        this.fMn = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.fMn.setDefaultErrorResource(0);
        this.fMn.setDrawCorner(true);
        this.fMn.setPlaceHolder(3);
        this.fMn.setEvent(this.dMs);
        this.fMn.setGifIconSupport(false);
        TbImageView tbImageView = this.fMn;
        TbImageView tbImageView2 = this.fMn;
        tbImageView.setConrers(15);
        this.fMn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.fMn.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fMn.setBorderColor(am.getColor(R.color.cp_border_a));
        this.fMn.setBorderSurroundContent(true);
        this.fMn.setDrawBorder(true);
        this.aCZ = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.fMo = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.fMo.loop(true);
        this.fMp = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.fMq = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.fMr = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.fMr.setCertainColumnCount(4);
        this.fMr.setColumnColor(R.color.cp_cont_a);
        this.fMs = inflate.findViewById(R.id.layout_error);
        this.fMt = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.fMu = inflate.findViewById(R.id.layout_live_end);
        this.fMv = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.fLi = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.fMy = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.fMm = new a(this);
        this.dMq = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            am.a(this.fMo, R.raw.ala_play);
            am.setViewTextColor(this.fMt, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMs, R.color.black_alpha80);
            am.setBackgroundColor(this.elk, R.color.black_alpha100);
            am.setViewTextColor(this.fMv, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fMu, R.color.black_alpha80);
            am.setViewTextColor(this.dMq, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.fMm;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.dMq != null) {
            this.dMq.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.fMn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.fMn.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.fMy.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.fMy.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.fLi.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.elk;
    }

    public void bcp() {
        this.fMn.setVisibility(0);
        this.fMo.setVisibility(0);
        this.fMp.setVisibility(8);
        if (this.aCZ != null) {
            this.aCZ.clearAnimation();
        }
        this.fMr.lS();
        this.fMs.setVisibility(8);
        this.fMu.setVisibility(8);
        e.gx().removeCallbacks(this.fMz);
        e.gx().removeCallbacks(this.dMv);
        e.gx().removeCallbacks(this.fMA);
    }

    public void setVideoStatsData(y yVar) {
        if (this.fMw != null) {
            this.fMw.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.fMx = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bvq();
    }

    public void startPlayAnimation() {
        if (this.fMo != null) {
            this.fMo.playAnimation();
        }
    }

    public void bvq() {
        if (this.fMo != null) {
            this.fMo.cancelAnimation();
        }
    }
}
