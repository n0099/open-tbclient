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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.o;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes21.dex */
public class AlaVideoContainer extends LinearLayout {
    private View byQ;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private TextView fzM;
    private TbImageView.a fzO;
    private Runnable fzQ;
    private TbCyberVideoView.a fzS;
    private TbCyberVideoView gdn;
    private LinearLayout hTs;
    private a hUD;
    private TbImageView hUE;
    private TBLottieAnimationView hUF;
    private FrameLayout hUG;
    private Animation hUH;
    private AudioAnimationView hUI;
    private View hUJ;
    private TextView hUK;
    private View hUL;
    private TextView hUM;
    private View.OnClickListener hUN;
    private TextView hUO;
    private Runnable hUP;
    private Runnable hUQ;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hUE != null) {
                    AlaVideoContainer.this.hUE.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hUN != null) {
                            AlaVideoContainer.this.hUN.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gdn != null) {
                    AlaVideoContainer.this.gdn.setLooping(true);
                    AlaVideoContainer.this.gdn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hUI.start();
                AlaVideoContainer.this.hUG.setVisibility(8);
                AlaVideoContainer.this.hUE.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hUP, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hUQ);
            }
        };
        this.hUP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.byQ != null) {
                    AlaVideoContainer.this.byQ.startAnimation(AlaVideoContainer.this.hUH);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.hUQ);
                return false;
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.hUQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hUJ.setVisibility(0);
                AlaVideoContainer.this.hUG.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fzQ, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hUE != null) {
                    AlaVideoContainer.this.hUE.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hUN != null) {
                            AlaVideoContainer.this.hUN.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gdn != null) {
                    AlaVideoContainer.this.gdn.setLooping(true);
                    AlaVideoContainer.this.gdn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hUI.start();
                AlaVideoContainer.this.hUG.setVisibility(8);
                AlaVideoContainer.this.hUE.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hUP, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hUQ);
            }
        };
        this.hUP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.byQ != null) {
                    AlaVideoContainer.this.byQ.startAnimation(AlaVideoContainer.this.hUH);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mY().post(AlaVideoContainer.this.hUQ);
                return false;
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.hUQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hUJ.setVisibility(0);
                AlaVideoContainer.this.hUG.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fzQ, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fzO = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.hUE != null) {
                    AlaVideoContainer.this.hUE.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.hUN != null) {
                            AlaVideoContainer.this.hUN.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.gdn != null) {
                    AlaVideoContainer.this.gdn.setLooping(true);
                    AlaVideoContainer.this.gdn.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.hUI.start();
                AlaVideoContainer.this.hUG.setVisibility(8);
                AlaVideoContainer.this.hUE.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.hUP, IMConnection.RETRY_DELAY_TIMES);
                e.mY().removeCallbacks(AlaVideoContainer.this.hUQ);
            }
        };
        this.hUP = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.byQ != null) {
                    AlaVideoContainer.this.byQ.startAnimation(AlaVideoContainer.this.hUH);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mY().post(AlaVideoContainer.this.hUQ);
                return false;
            }
        };
        this.fzQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bMr();
            }
        };
        this.hUQ = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hUJ.setVisibility(0);
                AlaVideoContainer.this.hUG.setVisibility(8);
                e.mY().postDelayed(AlaVideoContainer.this.fzQ, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.gdn = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.gdn.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.gdn.getLayoutParams();
        layoutParams.height = (this.gdn.getWidth() * 9) / 16;
        this.gdn.setLayoutParams(layoutParams);
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        this.gdn.setOnErrorListener(this.ein);
        this.hUE = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.hUE.setDefaultErrorResource(0);
        this.hUE.setDrawCorner(true);
        this.hUE.setPlaceHolder(3);
        this.hUE.setEvent(this.fzO);
        this.hUE.setGifIconSupport(false);
        TbImageView tbImageView = this.hUE;
        TbImageView tbImageView2 = this.hUE;
        tbImageView.setConrers(15);
        this.hUE.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.hUE.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hUE.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.hUE.setBorderSurroundContent(true);
        this.hUE.setDrawBorder(true);
        this.byQ = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.hUF = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.hUF.loop(true);
        this.hUG = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.hUH = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.hUI = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.hUI.setCertainColumnCount(4);
        this.hUI.setColumnColor(R.color.cp_cont_a);
        this.hUJ = inflate.findViewById(R.id.layout_error);
        this.hUK = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.hUL = inflate.findViewById(R.id.layout_live_end);
        this.hUM = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hTs = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.hUO = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.hUD = new a(this);
        this.fzM = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.hUF, R.raw.ala_play);
            ap.setViewTextColor(this.hUK, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hUJ, R.color.black_alpha80);
            ap.setBackgroundColor(this.gdn, R.color.black_alpha100);
            ap.setViewTextColor(this.hUM, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hUL, R.color.black_alpha80);
            ap.setViewTextColor(this.fzM, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.hUD;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.fzM != null) {
            this.fzM.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.hUE.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hUE.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.hUO.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.hUO.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hTs.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.gdn;
    }

    public void bMr() {
        this.hUE.setVisibility(0);
        this.hUF.setVisibility(0);
        this.hUG.setVisibility(8);
        if (this.byQ != null) {
            this.byQ.clearAnimation();
        }
        this.hUI.sy();
        this.hUJ.setVisibility(8);
        this.hUL.setVisibility(8);
        e.mY().removeCallbacks(this.hUP);
        e.mY().removeCallbacks(this.fzQ);
        e.mY().removeCallbacks(this.hUQ);
    }

    public void setVideoStatsData(o oVar) {
        this.gdn.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.hUN = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cmb();
    }

    public void startPlayAnimation() {
        if (this.hUF != null) {
            this.hUF.playAnimation();
        }
    }

    public void cmb() {
        if (this.hUF != null) {
            this.hUF.cancelAnimation();
        }
    }
}
