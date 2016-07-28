package com.baidu.tieba.frs;

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
import com.baidu.tieba.tbadkCore.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bb {
    private TbPageContext<FrsActivity> DQ;
    private Animation bFb;

    public bb(TbPageContext<FrsActivity> tbPageContext) {
        this.DQ = tbPageContext;
        this.bFb = AnimationUtils.loadAnimation(this.DQ.getPageActivity(), u.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.DQ.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.DQ.getPageActivity()).inflate(u.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(u.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(u.g.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                com.baidu.tbadk.core.util.av.k(button, u.f.frs_star_btn_like);
                com.baidu.tbadk.core.util.av.c(textView, u.f.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10245));
                com.baidu.tbadk.core.util.av.k(button, u.f.bg_frs_header_button_selector);
                com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.v(false);
            gVar.R(u.g.love).Q(0).w(true);
            gVar.a(new bc(this, inflate));
            com.baidu.adp.lib.guide.d cV = gVar.cV();
            cV.f(this.DQ.getPageActivity());
            a.a(this.DQ.getOrignalPage(), inflate, this.bFb, new bd(this, cV));
        }
    }
}
