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
    private QuickVideoView aTb;
    private TbImageView aTc;
    private View aTd;
    private ImageView aTe;
    private FrameLayout aTg;
    private Animation aTh;
    private AudioAnimationView aTi;
    private View aTj;
    private TextView aTk;
    private aj aTl;
    private TbPageContext<?> aaX;
    private j buD;
    private View buE;
    private TextView buF;
    private View buG;
    private TextView mTitle;
    private View mView;
    private TbImageView.a aTr = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aQI = new d(this);
    private Runnable aTs = new e(this);
    private QuickVideoView.b aTt = new f(this);
    private v.b aQJ = new g(this);
    private Runnable aTu = new h(this);
    private Runnable aTv = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aaX = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.aTb = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.aTb.getLayoutParams();
        layoutParams.height = this.aTb.getWidth();
        this.aTb.setLayoutParams(layoutParams);
        this.aTl = new aj(this.aaX.getPageActivity());
        this.aTl.aYa();
        this.aTb.setBusiness(this.aTl);
        this.aTb.setOnPreparedListener(this.aQI);
        this.aTb.setOnSurfaceDestroyedListener(this.aTt);
        this.aTb.setOnErrorListener(this.aQJ);
        this.aTc = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.aTc.setDefaultErrorResource(0);
        this.aTc.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTc.setEvent(this.aTr);
        this.aTd = view.findViewById(w.h.layout_title);
        this.mTitle = (TextView) view.findViewById(w.h.tv_title);
        this.aTe = (ImageView) view.findViewById(w.h.img_play);
        this.aTg = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.aTh = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.aTi = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.aTi.setCertainColumnCount(4);
        this.aTi.setColumnColor(w.e.cp_cont_i);
        this.aTj = view.findViewById(w.h.layout_error);
        this.aTk = (TextView) view.findViewById(w.h.video_error_tips);
        this.buE = view.findViewById(w.h.layout_live_end);
        this.buF = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.buG = view.findViewById(w.h.bottom_divider);
        this.buD = new j(this);
    }

    public void onChangeSkinType(int i) {
        aq.i(this.mTitle, w.e.cp_cont_g);
        aq.c(this.aTe, w.g.btn_icon_play_video_n);
        aq.i(this.aTk, w.e.cp_cont_i);
        aq.k(this.aTj, w.e.black_alpha80);
        aq.k(this.aTb, w.e.cp_bg_line_k);
        aq.i(this.buF, w.e.cp_cont_i);
        aq.k(this.buE, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public void cQ(boolean z) {
        if (z) {
            this.buG.setVisibility(0);
        } else {
            this.buG.setVisibility(8);
        }
    }

    public j SU() {
        return this.buD;
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void gD(String str) {
        this.aTc.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTc.c(str, 10, false);
    }

    public QuickVideoView Lg() {
        return this.aTb;
    }

    public void Lh() {
        this.aTc.setVisibility(0);
        this.aTe.setVisibility(0);
        this.aTg.setVisibility(8);
        this.aTd.clearAnimation();
        this.aTi.bmk();
        this.aTj.setVisibility(8);
        this.buE.setVisibility(8);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTs);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTu);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aTv);
    }
}
