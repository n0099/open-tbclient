package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.v;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private QuickVideoView aSL;
    private TbImageView aSM;
    private View aSN;
    private TextView aSO;
    private ImageView aSP;
    private FrameLayout aSR;
    private Animation aSS;
    private AudioAnimationView aST;
    private View aSU;
    private TextView aSV;
    private aj aSW;
    private TbPageContext<?> aaI;
    private j buL;
    private View buM;
    private TextView buN;
    private View buO;
    private View mView;
    private TbImageView.a aTc = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aQs = new d(this);
    private Runnable aTd = new e(this);
    private QuickVideoView.b aTe = new f(this);
    private v.b aQt = new g(this);
    private Runnable aTf = new h(this);
    private Runnable aTg = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aaI = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.aSL = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.aSL.getLayoutParams();
        layoutParams.height = this.aSL.getWidth();
        this.aSL.setLayoutParams(layoutParams);
        this.aSW = new aj(this.aaI.getPageActivity());
        this.aSW.aXR();
        this.aSL.setBusiness(this.aSW);
        this.aSL.setOnPreparedListener(this.aQs);
        this.aSL.setOnSurfaceDestroyedListener(this.aTe);
        this.aSL.setOnErrorListener(this.aQt);
        this.aSM = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.aSM.setDefaultErrorResource(0);
        this.aSM.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aSM.setEvent(this.aTc);
        this.aSN = view.findViewById(w.h.layout_title);
        this.aSO = (TextView) view.findViewById(w.h.tv_title);
        this.aSP = (ImageView) view.findViewById(w.h.img_play);
        this.aSR = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.aSS = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.aST = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.aST.setCertainColumnCount(4);
        this.aST.setColumnColor(w.e.cp_cont_i);
        this.aSU = view.findViewById(w.h.layout_error);
        this.aSV = (TextView) view.findViewById(w.h.video_error_tips);
        this.buM = view.findViewById(w.h.layout_live_end);
        this.buN = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.buO = view.findViewById(w.h.bottom_divider);
        this.buL = new j(this);
    }

    public void onChangeSkinType(int i) {
        aq.i((View) this.aSO, w.e.cp_cont_g);
        aq.c(this.aSP, w.g.btn_icon_play_video_n);
        aq.i((View) this.aSV, w.e.cp_cont_i);
        aq.k(this.aSU, w.e.black_alpha80);
        aq.k(this.aSL, w.e.cp_bg_line_k);
        aq.i((View) this.buN, w.e.cp_cont_i);
        aq.k(this.buM, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public void cO(boolean z) {
        if (z) {
            this.buO.setVisibility(0);
        } else {
            this.buO.setVisibility(8);
        }
    }

    public j Sw() {
        return this.buL;
    }

    public void setTitle(String str) {
        this.aSO.setText(str);
    }

    public void gx(String str) {
        this.aSM.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aSM.c(str, 10, false);
    }

    public QuickVideoView KG() {
        return this.aSL;
    }

    public void KH() {
        this.aSM.setVisibility(0);
        this.aSP.setVisibility(0);
        this.aSR.setVisibility(8);
        this.aSN.clearAnimation();
        this.aST.blA();
        this.aSU.setVisibility(8);
        this.buM.setVisibility(8);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTd);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTf);
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.aTg);
    }
}
