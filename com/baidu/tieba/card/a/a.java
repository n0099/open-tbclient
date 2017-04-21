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
    private QuickVideoView aTd;
    private TbImageView aTe;
    private View aTf;
    private ImageView aTg;
    private FrameLayout aTi;
    private Animation aTj;
    private AudioAnimationView aTk;
    private View aTl;
    private TextView aTm;
    private aj aTn;
    private TbPageContext<?> aaY;
    private j bwU;
    private View bwV;
    private TextView bwW;
    private View bwX;
    private TextView mTitle;
    private View mView;
    private TbImageView.a aTt = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aQK = new d(this);
    private Runnable aTu = new e(this);
    private QuickVideoView.b aTv = new f(this);
    private v.b aQL = new g(this);
    private Runnable aTw = new h(this);
    private Runnable aTx = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.aaY = tbPageContext;
        this.mView = view.findViewById(w.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.aTd = (QuickVideoView) view.findViewById(w.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.aTd.getLayoutParams();
        layoutParams.height = this.aTd.getWidth();
        this.aTd.setLayoutParams(layoutParams);
        this.aTn = new aj(this.aaY.getPageActivity());
        this.aTn.aZb();
        this.aTd.setBusiness(this.aTn);
        this.aTd.setOnPreparedListener(this.aQK);
        this.aTd.setOnSurfaceDestroyedListener(this.aTv);
        this.aTd.setOnErrorListener(this.aQL);
        this.aTe = (TbImageView) view.findViewById(w.h.img_thumbnail);
        this.aTe.setDefaultErrorResource(0);
        this.aTe.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTe.setEvent(this.aTt);
        this.aTf = view.findViewById(w.h.layout_title);
        this.mTitle = (TextView) view.findViewById(w.h.tv_title);
        this.aTg = (ImageView) view.findViewById(w.h.img_play);
        this.aTi = (FrameLayout) view.findViewById(w.h.layout_loading);
        this.aTj = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), w.a.video_title_fade_out);
        this.aTk = (AudioAnimationView) view.findViewById(w.h.playing_indicator);
        this.aTk.setCertainColumnCount(4);
        this.aTk.setColumnColor(w.e.cp_cont_i);
        this.aTl = view.findViewById(w.h.layout_error);
        this.aTm = (TextView) view.findViewById(w.h.video_error_tips);
        this.bwV = view.findViewById(w.h.layout_live_end);
        this.bwW = (TextView) view.findViewById(w.h.video_live_end_tips);
        this.bwX = view.findViewById(w.h.bottom_divider);
        this.bwU = new j(this);
    }

    public void onChangeSkinType(int i) {
        aq.i(this.mTitle, w.e.cp_cont_g);
        aq.c(this.aTg, w.g.btn_icon_play_video_n);
        aq.i(this.aTm, w.e.cp_cont_i);
        aq.k(this.aTl, w.e.black_alpha80);
        aq.k(this.aTd, w.e.cp_bg_line_k);
        aq.i(this.bwW, w.e.cp_cont_i);
        aq.k(this.bwV, w.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public void da(boolean z) {
        if (z) {
            this.bwX.setVisibility(0);
        } else {
            this.bwX.setVisibility(8);
        }
    }

    public j TW() {
        return this.bwU;
    }

    public void setTitle(String str) {
        this.mTitle.setText(str);
    }

    public void gD(String str) {
        this.aTe.setDefaultBgResource(w.g.pic_bg_video_frs);
        this.aTe.c(str, 10, false);
    }

    public QuickVideoView Lg() {
        return this.aTd;
    }

    public void Lh() {
        this.aTe.setVisibility(0);
        this.aTg.setVisibility(0);
        this.aTi.setVisibility(8);
        this.aTf.clearAnimation();
        this.aTk.bnl();
        this.aTl.setVisibility(8);
        this.bwV.setVisibility(8);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTu);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTw);
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aTx);
    }
}
