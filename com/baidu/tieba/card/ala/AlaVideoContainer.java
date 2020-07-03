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
import com.baidu.tbadk.core.util.an;
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
    private View bjD;
    private TextView eLb;
    private TbImageView.a eLd;
    private g.b eLe;
    private Runnable eLg;
    private QuickVideoView.b eLi;
    private g.f eUJ;
    private QuickVideoView fnh;
    private LinearLayout gSw;
    private a gTH;
    private TbImageView gTI;
    private TBLottieAnimationView gTJ;
    private FrameLayout gTK;
    private Animation gTL;
    private AudioAnimationView gTM;
    private View gTN;
    private TextView gTO;
    private View gTP;
    private TextView gTQ;
    private n gTR;
    private View.OnClickListener gTS;
    private TextView gTT;
    private Runnable gTU;
    private Runnable gTV;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gTI != null) {
                    AlaVideoContainer.this.gTI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gTS != null) {
                            AlaVideoContainer.this.gTS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gTM.start();
                AlaVideoContainer.this.gTK.setVisibility(8);
                AlaVideoContainer.this.gTI.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gTU, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gTV);
            }
        };
        this.gTU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjD != null) {
                    AlaVideoContainer.this.bjD.startAnimation(AlaVideoContainer.this.gTL);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.btD();
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lt().post(AlaVideoContainer.this.gTV);
                return false;
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.btD();
            }
        };
        this.gTV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gTN.setVisibility(0);
                AlaVideoContainer.this.gTK.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eLg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gTI != null) {
                    AlaVideoContainer.this.gTI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gTS != null) {
                            AlaVideoContainer.this.gTS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gTM.start();
                AlaVideoContainer.this.gTK.setVisibility(8);
                AlaVideoContainer.this.gTI.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gTU, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gTV);
            }
        };
        this.gTU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjD != null) {
                    AlaVideoContainer.this.bjD.startAnimation(AlaVideoContainer.this.gTL);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.btD();
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.lt().post(AlaVideoContainer.this.gTV);
                return false;
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.btD();
            }
        };
        this.gTV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gTN.setVisibility(0);
                AlaVideoContainer.this.gTK.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eLg, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eLd = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.gTI != null) {
                    AlaVideoContainer.this.gTI.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.gTS != null) {
                            AlaVideoContainer.this.gTS.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.gTM.start();
                AlaVideoContainer.this.gTK.setVisibility(8);
                AlaVideoContainer.this.gTI.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.gTU, 3000L);
                e.lt().removeCallbacks(AlaVideoContainer.this.gTV);
            }
        };
        this.gTU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bjD != null) {
                    AlaVideoContainer.this.bjD.startAnimation(AlaVideoContainer.this.gTL);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.btD();
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.lt().post(AlaVideoContainer.this.gTV);
                return false;
            }
        };
        this.eLg = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.btD();
            }
        };
        this.gTV = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.gTN.setVisibility(0);
                AlaVideoContainer.this.gTK.setVisibility(8);
                e.lt().postDelayed(AlaVideoContainer.this.eLg, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fnh = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.fnh.getLayoutParams();
        layoutParams.height = (this.fnh.getWidth() * 9) / 16;
        this.fnh.setLayoutParams(layoutParams);
        this.gTR = new n(getContext());
        this.gTR.cVB();
        this.fnh.setBusiness(this.gTR);
        this.fnh.setOnPreparedListener(this.eUJ);
        this.fnh.setOnSurfaceDestroyedListener(this.eLi);
        this.fnh.setOnErrorListener(this.eLe);
        this.gTI = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.gTI.setDefaultErrorResource(0);
        this.gTI.setDrawCorner(true);
        this.gTI.setPlaceHolder(3);
        this.gTI.setEvent(this.eLd);
        this.gTI.setGifIconSupport(false);
        TbImageView tbImageView = this.gTI;
        TbImageView tbImageView2 = this.gTI;
        tbImageView.setConrers(15);
        this.gTI.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.gTI.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gTI.setBorderColor(an.getColor(R.color.cp_border_a));
        this.gTI.setBorderSurroundContent(true);
        this.gTI.setDrawBorder(true);
        this.bjD = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.gTJ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.gTJ.loop(true);
        this.gTK = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.gTL = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.gTM = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.gTM.setCertainColumnCount(4);
        this.gTM.setColumnColor(R.color.cp_cont_a);
        this.gTN = inflate.findViewById(R.id.layout_error);
        this.gTO = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.gTP = inflate.findViewById(R.id.layout_live_end);
        this.gTQ = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.gSw = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.gTT = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.gTH = new a(this);
        this.eLb = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
            }
            an.a(this.gTJ, (int) R.raw.ala_play);
            an.setViewTextColor(this.gTO, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.gTN, R.color.black_alpha80);
            an.setBackgroundColor(this.fnh, R.color.black_alpha100);
            an.setViewTextColor(this.gTQ, (int) R.color.cp_cont_a);
            an.setBackgroundColor(this.gTP, R.color.black_alpha80);
            an.setViewTextColor(this.eLb, (int) R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.gTH;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.eLb != null) {
            this.eLb.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.gTI.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gTI.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.gTT.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.gTT.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.gSw.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.fnh;
    }

    public void btD() {
        this.gTI.setVisibility(0);
        this.gTJ.setVisibility(0);
        this.gTK.setVisibility(8);
        if (this.bjD != null) {
            this.bjD.clearAnimation();
        }
        this.gTM.qR();
        this.gTN.setVisibility(8);
        this.gTP.setVisibility(8);
        e.lt().removeCallbacks(this.gTU);
        e.lt().removeCallbacks(this.eLg);
        e.lt().removeCallbacks(this.gTV);
    }

    public void setVideoStatsData(y yVar) {
        if (this.gTR != null) {
            this.gTR.setVideoStatsData(yVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.gTS = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bOK();
    }

    public void startPlayAnimation() {
        if (this.gTJ != null) {
            this.gTJ.playAnimation();
        }
    }

    public void bOK() {
        if (this.gTJ != null) {
            this.gTJ.cancelAnimation();
        }
    }
}
