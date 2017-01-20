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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<FrsActivity> Fp;
    private Animation bTX;

    public b(TbPageContext<FrsActivity> tbPageContext) {
        this.Fp = tbPageContext;
        this.bTX = AnimationUtils.loadAnimation(this.Fp.getPageActivity(), r.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.Fp.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.Fp.getPageActivity()).inflate(r.j.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(r.h.btn_love);
            TextView textView = (TextView) inflate.findViewById(r.h.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                ap.j((View) button, r.g.frs_star_btn_like);
                ap.c(textView, r.g.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, ap.getColor(r.e.common_color_10245));
                ap.j((View) button, r.g.bg_frs_header_button_selector);
                ap.c(textView, r.e.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.x(false);
            gVar.af(r.h.love).ae(0).y(true);
            gVar.a(new c(this, inflate));
            com.baidu.adp.lib.guide.d dO = gVar.dO();
            dO.j(this.Fp.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.Fp.getOrignalPage(), inflate, this.bTX, new d(this, dO));
        }
    }
}
