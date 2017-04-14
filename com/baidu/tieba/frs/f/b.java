package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<FrsActivity> aaX;
    private Animation bZK;

    public b(TbPageContext<FrsActivity> tbPageContext) {
        this.aaX = tbPageContext;
        this.bZK = AnimationUtils.loadAnimation(this.aaX.getPageActivity(), w.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.aaX.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(w.h.btn_love);
            TextView textView = (TextView) inflate.findViewById(w.h.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                aq.j(button, w.g.frs_star_btn_like);
                aq.c(textView, w.g.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, aq.getColor(w.e.common_color_10245));
                aq.j(button, w.g.bg_frs_header_button_selector);
                aq.c(textView, w.e.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.y(false);
            gVar.ae(w.h.love).ad(0).z(true);
            gVar.a(new c(this, inflate));
            com.baidu.adp.lib.guide.d fb = gVar.fb();
            fb.j(this.aaX.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.aaX.getOrignalPage(), inflate, this.bZK, new d(this, fb));
        }
    }
}
