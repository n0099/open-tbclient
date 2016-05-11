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
public class bj {
    private TbPageContext<FrsActivity> Do;
    private Animation bhK;

    public bj(TbPageContext<FrsActivity> tbPageContext) {
        this.Do = tbPageContext;
        this.bhK = AnimationUtils.loadAnimation(this.Do.getPageActivity(), t.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.Do.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(t.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(t.g.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                com.baidu.tbadk.core.util.at.k(button, t.f.frs_star_btn_like);
                com.baidu.tbadk.core.util.at.c(textView, t.f.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, com.baidu.tbadk.core.util.at.getColor(t.d.frs_like_shadow));
                com.baidu.tbadk.core.util.at.k(button, t.f.bg_frs_header_button_selector);
                com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.t(false);
            gVar.O(t.g.love).N(0).u(true);
            gVar.a(new bk(this, inflate));
            com.baidu.adp.lib.guide.d cV = gVar.cV();
            cV.d(this.Do.getPageActivity());
            a.a(this.Do.getOrignalPage(), inflate, this.bhK, new bl(this, cV));
        }
    }
}
