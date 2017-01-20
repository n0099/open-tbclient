package com.baidu.tieba.card.a;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.aj;
import com.baidu.tieba.play.v;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class a {
    private TbPageContext<?> Fp;
    private QuickVideoView aMY;
    private TbImageView aMZ;
    private View aNa;
    private TextView aNb;
    private ImageView aNc;
    private FrameLayout aNe;
    private Animation aNf;
    private AudioAnimationView aNg;
    private View aNh;
    private TextView aNi;
    private aj aNj;
    private j bnP;
    private View bnQ;
    private TextView bnR;
    private View bnS;
    private View mView;
    private TbImageView.a aNp = new b(this);
    private View.OnClickListener mOnClickListener = new c(this);
    private v.d aKH = new d(this);
    private Runnable aNq = new e(this);
    private QuickVideoView.b aNr = new f(this);
    private v.b aKI = new g(this);
    private Runnable aNs = new h(this);
    private Runnable aNt = new i(this);

    public a(TbPageContext<?> tbPageContext, View view) {
        this.Fp = tbPageContext;
        this.mView = view.findViewById(r.h.video_container);
        this.mView.setOnClickListener(this.mOnClickListener);
        this.aMY = (QuickVideoView) view.findViewById(r.h.video_view);
        ViewGroup.LayoutParams layoutParams = this.aMY.getLayoutParams();
        layoutParams.height = this.aMY.getWidth();
        this.aMY.setLayoutParams(layoutParams);
        this.aNj = new aj(this.Fp.getPageActivity());
        this.aNj.aYm();
        this.aMY.setBusiness(this.aNj);
        this.aMY.setOnPreparedListener(this.aKH);
        this.aMY.setOnSurfaceDestroyedListener(this.aNr);
        this.aMY.setOnErrorListener(this.aKI);
        this.aMZ = (TbImageView) view.findViewById(r.h.img_thumbnail);
        this.aMZ.setDefaultErrorResource(0);
        this.aMZ.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.aMZ.setEvent(this.aNp);
        this.aNa = view.findViewById(r.h.layout_title);
        this.aNb = (TextView) view.findViewById(r.h.tv_title);
        this.aNc = (ImageView) view.findViewById(r.h.img_play);
        this.aNe = (FrameLayout) view.findViewById(r.h.layout_loading);
        this.aNf = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), r.a.video_title_fade_out);
        this.aNg = (AudioAnimationView) view.findViewById(r.h.playing_indicator);
        this.aNg.setCertainColumnCount(4);
        this.aNg.setColumnColor(r.e.cp_cont_i);
        this.aNh = view.findViewById(r.h.layout_error);
        this.aNi = (TextView) view.findViewById(r.h.video_error_tips);
        this.bnQ = view.findViewById(r.h.layout_live_end);
        this.bnR = (TextView) view.findViewById(r.h.video_live_end_tips);
        this.bnS = view.findViewById(r.h.bottom_divider);
        this.bnP = new j(this);
    }

    public void onChangeSkinType(int i) {
        ap.i((View) this.aNb, r.e.cp_cont_g);
        ap.c(this.aNc, r.g.btn_icon_play_video_n);
        ap.i((View) this.aNi, r.e.cp_cont_i);
        ap.k(this.aNh, r.e.black_alpha80);
        ap.k(this.aMY, r.e.cp_bg_line_k);
        ap.i((View) this.bnR, r.e.cp_cont_i);
        ap.k(this.bnQ, r.e.black_alpha80);
    }

    public View getView() {
        return this.mView;
    }

    public void cO(boolean z) {
        if (z) {
            this.bnS.setVisibility(0);
        } else {
            this.bnS.setVisibility(8);
        }
    }

    public j Ry() {
        return this.bnP;
    }

    public void setTitle(String str) {
        this.aNb.setText(str);
    }

    public void gI(String str) {
        this.aMZ.setDefaultBgResource(r.g.pic_bg_video_frs);
        this.aMZ.c(str, 10, false);
    }

    public QuickVideoView Kb() {
        return this.aMY;
    }

    public void Kc() {
        this.aMZ.setVisibility(0);
        this.aNc.setVisibility(0);
        this.aNe.setVisibility(8);
        this.aNa.clearAnimation();
        this.aNg.blL();
        this.aNh.setVisibility(8);
        this.bnQ.setVisibility(8);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNq);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNs);
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aNt);
    }
}
