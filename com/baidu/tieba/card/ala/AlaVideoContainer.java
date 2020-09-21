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
/* loaded from: classes20.dex */
public class AlaVideoContainer extends LinearLayout {
    private View bsO;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private TbCyberVideoView fHb;
    private TextView ffa;
    private TbImageView.a ffc;
    private Runnable ffe;
    private TbCyberVideoView.a ffg;
    private LinearLayout hsb;
    private a htm;
    private TbImageView htn;
    private TBLottieAnimationView hto;
    private FrameLayout htp;
    private Animation htq;
    private AudioAnimationView htr;
    private View hts;
    private TextView htt;
    private View htu;
    private TextView htv;
    private View.OnClickListener htw;
    private TextView htx;
    private Runnable hty;
    private Runnable htz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.htn != null) {
                    AlaVideoContainer.this.htn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.htw != null) {
                            AlaVideoContainer.this.htw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fHb != null) {
                    AlaVideoContainer.this.fHb.setLooping(true);
                    AlaVideoContainer.this.fHb.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.htr.start();
                AlaVideoContainer.this.htp.setVisibility(8);
                AlaVideoContainer.this.htn.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.hty, IMConnection.RETRY_DELAY_TIMES);
                e.mX().removeCallbacks(AlaVideoContainer.this.htz);
            }
        };
        this.hty = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bsO != null) {
                    AlaVideoContainer.this.bsO.startAnimation(AlaVideoContainer.this.htq);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mX().post(AlaVideoContainer.this.htz);
                return false;
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.htz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hts.setVisibility(0);
                AlaVideoContainer.this.htp.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.ffe, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.htn != null) {
                    AlaVideoContainer.this.htn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.htw != null) {
                            AlaVideoContainer.this.htw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fHb != null) {
                    AlaVideoContainer.this.fHb.setLooping(true);
                    AlaVideoContainer.this.fHb.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.htr.start();
                AlaVideoContainer.this.htp.setVisibility(8);
                AlaVideoContainer.this.htn.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.hty, IMConnection.RETRY_DELAY_TIMES);
                e.mX().removeCallbacks(AlaVideoContainer.this.htz);
            }
        };
        this.hty = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bsO != null) {
                    AlaVideoContainer.this.bsO.startAnimation(AlaVideoContainer.this.htq);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                e.mX().post(AlaVideoContainer.this.htz);
                return false;
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.htz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hts.setVisibility(0);
                AlaVideoContainer.this.htp.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.ffe, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ffc = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && AlaVideoContainer.this.htn != null) {
                    AlaVideoContainer.this.htn.setDefaultBgResource(0);
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
                        if (AlaVideoContainer.this.htw != null) {
                            AlaVideoContainer.this.htw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.showLongToast(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (AlaVideoContainer.this.fHb != null) {
                    AlaVideoContainer.this.fHb.setLooping(true);
                    AlaVideoContainer.this.fHb.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.htr.start();
                AlaVideoContainer.this.htp.setVisibility(8);
                AlaVideoContainer.this.htn.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.hty, IMConnection.RETRY_DELAY_TIMES);
                e.mX().removeCallbacks(AlaVideoContainer.this.htz);
            }
        };
        this.hty = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.bsO != null) {
                    AlaVideoContainer.this.bsO.startAnimation(AlaVideoContainer.this.htq);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                e.mX().post(AlaVideoContainer.this.htz);
                return false;
            }
        };
        this.ffe = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.bHd();
            }
        };
        this.htz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.hts.setVisibility(0);
                AlaVideoContainer.this.htp.setVisibility(8);
                e.mX().postDelayed(AlaVideoContainer.this.ffe, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.fHb = (TbCyberVideoView) inflate.findViewById(R.id.video_view);
        this.fHb.setStageType(null);
        ViewGroup.LayoutParams layoutParams = this.fHb.getLayoutParams();
        layoutParams.height = (this.fHb.getWidth() * 9) / 16;
        this.fHb.setLayoutParams(layoutParams);
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        this.fHb.setOnErrorListener(this.dNP);
        this.htn = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.htn.setDefaultErrorResource(0);
        this.htn.setDrawCorner(true);
        this.htn.setPlaceHolder(3);
        this.htn.setEvent(this.ffc);
        this.htn.setGifIconSupport(false);
        TbImageView tbImageView = this.htn;
        TbImageView tbImageView2 = this.htn;
        tbImageView.setConrers(15);
        this.htn.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.htn.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.htn.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.htn.setBorderSurroundContent(true);
        this.htn.setDrawBorder(true);
        this.bsO = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.hto = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.hto.loop(true);
        this.htp = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.htq = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.htr = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.htr.setCertainColumnCount(4);
        this.htr.setColumnColor(R.color.cp_cont_a);
        this.hts = inflate.findViewById(R.id.layout_error);
        this.htt = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.htu = inflate.findViewById(R.id.layout_live_end);
        this.htv = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.hsb = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.htx = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.htm = new a(this);
        this.ffa = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
            }
            ap.a(this.hto, R.raw.ala_play);
            ap.setViewTextColor(this.htt, R.color.cp_cont_a);
            ap.setBackgroundColor(this.hts, R.color.black_alpha80);
            ap.setBackgroundColor(this.fHb, R.color.black_alpha100);
            ap.setViewTextColor(this.htv, R.color.cp_cont_a);
            ap.setBackgroundColor(this.htu, R.color.black_alpha80);
            ap.setViewTextColor(this.ffa, R.color.cp_cont_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.htm;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.ffa != null) {
            this.ffa.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.htn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.htn.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.htx.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.htx.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.hsb.setVisibility(i);
    }

    public TbCyberVideoView getVideoView() {
        return this.fHb;
    }

    public void bHd() {
        this.htn.setVisibility(0);
        this.hto.setVisibility(0);
        this.htp.setVisibility(8);
        if (this.bsO != null) {
            this.bsO.clearAnimation();
        }
        this.htr.sy();
        this.hts.setVisibility(8);
        this.htu.setVisibility(8);
        e.mX().removeCallbacks(this.hty);
        e.mX().removeCallbacks(this.ffe);
        e.mX().removeCallbacks(this.htz);
    }

    public void setVideoStatsData(o oVar) {
        this.fHb.setVideoStatData(oVar);
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.htw = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cfy();
    }

    public void startPlayAnimation() {
        if (this.hto != null) {
            this.hto.playAnimation();
        }
    }

    public void cfy() {
        if (this.hto != null) {
            this.hto.cancelAnimation();
        }
    }
}
