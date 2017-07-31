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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private TbPageContext<BaseFragmentActivity> acp;
    private Animation cwH;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext) {
        this.acp = tbPageContext;
        this.cwH = AnimationUtils.loadAnimation(this.acp.getPageActivity(), d.a.frs_like);
    }

    public void c(View view, String str) {
        if (!this.acp.getPageActivity().isFinishing()) {
            final View inflate = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(d.h.btn_love);
            TextView textView = (TextView) inflate.findViewById(d.h.tv_love);
            if ("frs_page".equals(str)) {
                textView.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_like_selector), (Drawable) null, (Drawable) null, (Drawable) null);
                ai.j(button, d.g.frs_star_btn_like);
                ai.c(textView, d.g.frs_text_color_selector, 1);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_sml_like), (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setShadowLayer(0.0f, 0.0f, 0.0f, ai.getColor(d.e.common_color_10245));
                ai.j(button, d.g.bg_frs_header_button_selector);
                ai.c(textView, d.e.cp_cont_g, 1);
            }
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
            dVar.y(false);
            dVar.ah(d.h.love).ag(0).z(true);
            dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.f.b.1
                @Override // com.baidu.adp.lib.guide.b
                public View a(LayoutInflater layoutInflater) {
                    return inflate;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fi() {
                    return 5;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int fj() {
                    return 32;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getXOffset() {
                    return 0;
                }

                @Override // com.baidu.adp.lib.guide.b
                public int getYOffset() {
                    return 0;
                }
            });
            final com.baidu.adp.lib.guide.c fk = dVar.fk();
            fk.j(this.acp.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.acp.getOrignalPage(), inflate, this.cwH, new com.baidu.adp.lib.g.d() { // from class: com.baidu.tieba.frs.f.b.2
                @Override // com.baidu.adp.lib.g.d
                public void b(Animation animation) {
                    fk.dismiss();
                }
            });
        }
    }
}
