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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.a;
/* loaded from: classes.dex */
public class bb {
    private TbPageContext<FrsActivity> Gd;
    private Animation bQF;

    public bb(TbPageContext<FrsActivity> tbPageContext) {
        this.Gd = tbPageContext;
        this.bQF = AnimationUtils.loadAnimation(this.Gd.getPageActivity(), t.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.Gd.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(t.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(t.g.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                com.baidu.tbadk.core.util.av.k(button, t.f.frs_star_btn_like);
                com.baidu.tbadk.core.util.av.c(textView, t.f.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10245));
                com.baidu.tbadk.core.util.av.k(button, t.f.bg_frs_header_button_selector);
                com.baidu.tbadk.core.util.av.c(textView, t.d.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.x(false);
            gVar.ae(t.g.love).ad(0).y(true);
            gVar.a(new bc(this, inflate));
            com.baidu.adp.lib.guide.d dQ = gVar.dQ();
            dQ.j(this.Gd.getPageActivity());
            a.a(this.Gd.getOrignalPage(), inflate, this.bQF, new bd(this, dQ));
        }
    }
}
