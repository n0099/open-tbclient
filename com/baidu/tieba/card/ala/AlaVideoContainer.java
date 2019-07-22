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
    private TextView cJP;
    private TbImageView.a cJR;
    private g.b cJS;
    private Runnable cJU;
    private QuickVideoView.b cJW;
    private g.f cTq;
    private QuickVideoView dnu;
    private LinearLayout eDR;
    private a eEW;
    private TbImageView eEX;
    private View eEY;
    private TBLottieAnimationView eEZ;
    private FrameLayout eFa;
    private Animation eFb;
    private AudioAnimationView eFc;
    private View eFd;
    private TextView eFe;
    private View eFf;
    private TextView eFg;
    private n eFh;
    private View.OnClickListener eFi;
    private TextView eFj;
    private Runnable eFk;
    private Runnable eFl;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eEX != null) {
                    AlaVideoContainer.this.eEX.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFi != null) {
                            AlaVideoContainer.this.eFi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFc.start();
                AlaVideoContainer.this.eFa.setVisibility(8);
                AlaVideoContainer.this.eEX.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFk, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFl);
            }
        };
        this.eFk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eEY != null) {
                    AlaVideoContainer.this.eEY.startAnimation(AlaVideoContainer.this.eFb);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eFl);
                return false;
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.eFl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFd.setVisibility(0);
                AlaVideoContainer.this.eFa.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cJU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eEX != null) {
                    AlaVideoContainer.this.eEX.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFi != null) {
                            AlaVideoContainer.this.eFi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFc.start();
                AlaVideoContainer.this.eFa.setVisibility(8);
                AlaVideoContainer.this.eEX.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFk, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFl);
            }
        };
        this.eFk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eEY != null) {
                    AlaVideoContainer.this.eEY.startAnimation(AlaVideoContainer.this.eFb);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.iK().post(AlaVideoContainer.this.eFl);
                return false;
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.eFl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFd.setVisibility(0);
                AlaVideoContainer.this.eFa.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cJU, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cJR = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z && AlaVideoContainer.this.eEX != null) {
                    AlaVideoContainer.this.eEX.setDefaultBgResource(0);
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
                    if (j.kc()) {
                        if (AlaVideoContainer.this.eFi != null) {
                            AlaVideoContainer.this.eFi.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.E(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(R.string.no_network_guide));
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.eFc.start();
                AlaVideoContainer.this.eFa.setVisibility(8);
                AlaVideoContainer.this.eEX.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.eFk, 3000L);
                e.iK().removeCallbacks(AlaVideoContainer.this.eFl);
            }
        };
        this.eFk = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.eEY != null) {
                    AlaVideoContainer.this.eEY.startAnimation(AlaVideoContainer.this.eFb);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.iK().post(AlaVideoContainer.this.eFl);
                return false;
            }
        };
        this.cJU = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aIY();
            }
        };
        this.eFl = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.eFd.setVisibility(0);
                AlaVideoContainer.this.eFa.setVisibility(8);
                e.iK().postDelayed(AlaVideoContainer.this.cJU, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(R.id.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dnu = (QuickVideoView) inflate.findViewById(R.id.video_view);
        ViewGroup.LayoutParams layoutParams = this.dnu.getLayoutParams();
        layoutParams.height = (this.dnu.getWidth() * 9) / 16;
        this.dnu.setLayoutParams(layoutParams);
        this.eFh = new n(getContext());
        this.eFh.cep();
        this.dnu.setBusiness(this.eFh);
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        this.dnu.setOnErrorListener(this.cJS);
        this.eEX = (TbImageView) inflate.findViewById(R.id.img_thumbnail);
        this.eEX.setDefaultErrorResource(0);
        this.eEX.setDrawCorner(true);
        this.eEX.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        this.eEX.setEvent(this.cJR);
        this.eEX.setGifIconSupport(false);
        TbImageView tbImageView = this.eEX;
        TbImageView tbImageView2 = this.eEX;
        tbImageView.setConrers(15);
        this.eEX.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.eEX.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eEX.setBorderColor(am.getColor(R.color.black_alpha8));
        this.eEX.setBorderSurroundContent(true);
        this.eEX.setDrawBorder(true);
        this.eEY = inflate.findViewById(R.id.layout_title);
        this.mTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.eEZ = (TBLottieAnimationView) inflate.findViewById(R.id.img_play);
        this.eEZ.y(true);
        this.eFa = (FrameLayout) inflate.findViewById(R.id.layout_loading);
        this.eFb = AnimationUtils.loadAnimation(getContext(), R.anim.video_title_fade_out);
        this.eFc = (AudioAnimationView) inflate.findViewById(R.id.playing_indicator);
        this.eFc.setCertainColumnCount(4);
        this.eFc.setColumnColor(R.color.cp_btn_a);
        this.eFd = inflate.findViewById(R.id.layout_error);
        this.eFe = (TextView) inflate.findViewById(R.id.video_error_tips);
        this.eFf = inflate.findViewById(R.id.layout_live_end);
        this.eFg = (TextView) inflate.findViewById(R.id.video_live_end_tips);
        this.eDR = (LinearLayout) inflate.findViewById(R.id.llAlaLivingLogLayout);
        this.eFj = (TextView) inflate.findViewById(R.id.tvAlaLivingLogView);
        this.eEW = new a(this);
        this.cJP = (TextView) inflate.findViewById(R.id.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                am.j(this.mTitle, R.color.cp_btn_a);
            }
            am.a(this.eEZ, (int) R.raw.ala_play);
            am.j(this.eFe, R.color.cp_btn_a);
            am.l(this.eFd, R.color.black_alpha80);
            am.l(this.dnu, R.color.cp_bg_line_k);
            am.j(this.eFg, R.color.cp_btn_a);
            am.l(this.eFf, R.color.black_alpha80);
            am.j(this.cJP, R.color.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.eEW;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cJP != null) {
            this.cJP.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.eEX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.eEX.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.eFj.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.eFj.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eDR.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dnu;
    }

    public void aIY() {
        this.eEX.setVisibility(0);
        this.eEZ.setVisibility(0);
        this.eFa.setVisibility(8);
        if (this.eEY != null) {
            this.eEY.clearAnimation();
        }
        this.eFc.qr();
        this.eFd.setVisibility(8);
        this.eFf.setVisibility(8);
        e.iK().removeCallbacks(this.eFk);
        e.iK().removeCallbacks(this.cJU);
        e.iK().removeCallbacks(this.eFl);
    }

    public void setVideoStatsData(z zVar) {
        if (this.eFh != null) {
            this.eFh.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.eFi = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZW();
    }

    public void startPlayAnimation() {
        if (this.eEZ != null) {
            this.eEZ.br();
        }
    }

    public void aZW() {
        if (this.eEZ != null) {
            this.eEZ.cancelAnimation();
        }
    }
}
