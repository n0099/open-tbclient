package com.baidu.tieba.frs.utils;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<FrsActivity> Gf;
    private Animation bNJ;

    public b(TbPageContext<FrsActivity> tbPageContext) {
        this.Gf = tbPageContext;
        this.bNJ = AnimationUtils.loadAnimation(this.Gf.getPageActivity(), r.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.Gf.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.Gf.getPageActivity()).inflate(r.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(r.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(r.g.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                ar.k(button, r.f.frs_star_btn_like);
                ar.c(textView, r.f.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(r.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, ar.getColor(r.d.common_color_10245));
                ar.k(button, r.f.bg_frs_header_button_selector);
                ar.c(textView, r.d.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.x(false);
            gVar.af(r.g.love).ae(0).y(true);
            gVar.a(new c(this, inflate));
            com.baidu.adp.lib.guide.d dQ = gVar.dQ();
            dQ.j(this.Gf.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.Gf.getOrignalPage(), inflate, this.bNJ, new d(this, dQ));
        }
    }
}
