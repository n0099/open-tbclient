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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.z;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes3.dex */
public class AlaVideoContainer extends LinearLayout {
    private TextView cAl;
    private TbImageView.a cAn;
    private g.b cAo;
    private Runnable cAq;
    private QuickVideoView.b cAs;
    private g.f cJI;
    private QuickVideoView dbf;
    private LinearLayout eje;
    private a ekk;
    private TbImageView ekl;
    private View ekm;
    private TBLottieAnimationView ekn;
    private FrameLayout eko;
    private Animation ekp;
    private AudioAnimationView ekq;
    private View ekr;
    private TextView eks;
    private View ekt;
    private TextView eku;
    private n ekv;
    private View.OnClickListener ekw;
    private TextView ekx;
    private Runnable eky;
    private Runnable ekz;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;
    private TextView mTitle;
    private View mView;

    public AlaVideoContainer(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekl != null) {
                    AlaVideoContainer.this.ekl.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekw != null) {
                            AlaVideoContainer.this.ekw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekq.start();
                AlaVideoContainer.this.eko.setVisibility(8);
                AlaVideoContainer.this.ekl.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.eky, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekz);
            }
        };
        this.eky = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.startAnimation(AlaVideoContainer.this.ekp);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekz);
                return false;
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekr.setVisibility(0);
                AlaVideoContainer.this.eko.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAq, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekl != null) {
                    AlaVideoContainer.this.ekl.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekw != null) {
                            AlaVideoContainer.this.ekw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekq.start();
                AlaVideoContainer.this.eko.setVisibility(8);
                AlaVideoContainer.this.ekl.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.eky, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekz);
            }
        };
        this.eky = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.startAnimation(AlaVideoContainer.this.ekp);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                e.jH().post(AlaVideoContainer.this.ekz);
                return false;
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekr.setVisibility(0);
                AlaVideoContainer.this.eko.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAq, 2000L);
            }
        };
        init();
    }

    public AlaVideoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.cAn = new TbImageView.a() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z && AlaVideoContainer.this.ekl != null) {
                    AlaVideoContainer.this.ekl.setDefaultBgResource(0);
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
                    if (j.kY()) {
                        if (AlaVideoContainer.this.ekw != null) {
                            AlaVideoContainer.this.ekw.onClick(view);
                            return;
                        }
                        return;
                    }
                    l.S(AlaVideoContainer.this.getContext(), AlaVideoContainer.this.getContext().getString(d.j.no_network_guide));
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    gVar.setLooping(true);
                    gVar.setVolume(0.0f, 0.0f);
                }
                AlaVideoContainer.this.ekq.start();
                AlaVideoContainer.this.eko.setVisibility(8);
                AlaVideoContainer.this.ekl.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.eky, 3000L);
                e.jH().removeCallbacks(AlaVideoContainer.this.ekz);
            }
        };
        this.eky = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (AlaVideoContainer.this.ekm != null) {
                    AlaVideoContainer.this.ekm.startAnimation(AlaVideoContainer.this.ekp);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.5
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                e.jH().post(AlaVideoContainer.this.ekz);
                return false;
            }
        };
        this.cAq = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.7
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.aBh();
            }
        };
        this.ekz = new Runnable() { // from class: com.baidu.tieba.card.ala.AlaVideoContainer.8
            @Override // java.lang.Runnable
            public void run() {
                AlaVideoContainer.this.ekr.setVisibility(0);
                AlaVideoContainer.this.eko.setVisibility(8);
                e.jH().postDelayed(AlaVideoContainer.this.cAq, 2000L);
            }
        };
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ala_video_card_item_new, (ViewGroup) this, true);
        this.mView = inflate.findViewById(d.g.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.dbf = (QuickVideoView) inflate.findViewById(d.g.video_view);
        ViewGroup.LayoutParams layoutParams = this.dbf.getLayoutParams();
        layoutParams.height = (this.dbf.getWidth() * 9) / 16;
        this.dbf.setLayoutParams(layoutParams);
        this.ekv = new n(getContext());
        this.ekv.bTu();
        this.dbf.setBusiness(this.ekv);
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        this.dbf.setOnErrorListener(this.cAo);
        this.ekl = (TbImageView) inflate.findViewById(d.g.img_thumbnail);
        this.ekl.setDefaultErrorResource(0);
        this.ekl.setDrawCorner(true);
        this.ekl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        this.ekl.setEvent(this.cAn);
        this.ekl.setGifIconSupport(false);
        TbImageView tbImageView = this.ekl;
        TbImageView tbImageView2 = this.ekl;
        tbImageView.setConrers(15);
        this.ekl.setRadius(l.h(getContext(), d.e.tbds20));
        this.ekl.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        this.ekl.setBorderColor(al.getColor(d.C0277d.black_alpha8));
        this.ekl.setBorderSurroundContent(true);
        this.ekl.setDrawBorder(true);
        this.ekm = inflate.findViewById(d.g.layout_title);
        this.mTitle = (TextView) inflate.findViewById(d.g.tv_title);
        this.ekn = (TBLottieAnimationView) inflate.findViewById(d.g.img_play);
        this.ekn.G(true);
        this.eko = (FrameLayout) inflate.findViewById(d.g.layout_loading);
        this.ekp = AnimationUtils.loadAnimation(getContext(), d.a.video_title_fade_out);
        this.ekq = (AudioAnimationView) inflate.findViewById(d.g.playing_indicator);
        this.ekq.setCertainColumnCount(4);
        this.ekq.setColumnColor(d.C0277d.cp_btn_a);
        this.ekr = inflate.findViewById(d.g.layout_error);
        this.eks = (TextView) inflate.findViewById(d.g.video_error_tips);
        this.ekt = inflate.findViewById(d.g.layout_live_end);
        this.eku = (TextView) inflate.findViewById(d.g.video_live_end_tips);
        this.eje = (LinearLayout) inflate.findViewById(d.g.llAlaLivingLogLayout);
        this.ekx = (TextView) inflate.findViewById(d.g.tvAlaLivingLogView);
        this.ekk = new a(this);
        this.cAl = (TextView) inflate.findViewById(d.g.play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.mTitle != null) {
                al.j(this.mTitle, d.C0277d.cp_btn_a);
            }
            al.a(this.ekn, d.i.ala_play);
            al.j(this.eks, d.C0277d.cp_btn_a);
            al.l(this.ekr, d.C0277d.black_alpha80);
            al.l(this.dbf, d.C0277d.cp_bg_line_k);
            al.j(this.eku, d.C0277d.cp_btn_a);
            al.l(this.ekt, d.C0277d.black_alpha80);
            al.j(this.cAl, d.C0277d.cp_btn_a);
        }
    }

    public View getView() {
        return this.mView;
    }

    public a getController() {
        return this.ekk;
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setPlayCount(String str) {
        if (this.cAl != null) {
            this.cAl.setText(str);
        }
    }

    public void setVideoThumbnail(String str) {
        this.ekl.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ekl.startLoad(str, 10, false);
    }

    public void setLivingLogText(int i) {
        this.ekx.setText(i);
    }

    public void setLivingLogLeftDrawable(int i) {
        this.ekx.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }

    public void setLigvingLogLayoutVisible(int i) {
        this.eje.setVisibility(i);
    }

    public QuickVideoView getVideoView() {
        return this.dbf;
    }

    public void aBh() {
        this.ekl.setVisibility(0);
        this.ekn.setVisibility(0);
        this.eko.setVisibility(8);
        if (this.ekm != null) {
            this.ekm.clearAnimation();
        }
        this.ekq.ra();
        this.ekr.setVisibility(8);
        this.ekt.setVisibility(8);
        e.jH().removeCallbacks(this.eky);
        e.jH().removeCallbacks(this.cAq);
        e.jH().removeCallbacks(this.ekz);
    }

    public void setVideoStatsData(z zVar) {
        if (this.ekv != null) {
            this.ekv.setVideoStatsData(zVar);
        }
    }

    public void setOnVideoClickListener(View.OnClickListener onClickListener) {
        this.ekw = onClickListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startPlayAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aQM();
    }

    public void startPlayAnimation() {
        if (this.ekn != null) {
            this.ekn.cu();
        }
    }

    public void aQM() {
        if (this.ekn != null) {
            this.ekn.cancelAnimation();
        }
    }
}
