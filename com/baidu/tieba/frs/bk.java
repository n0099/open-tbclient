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
/* loaded from: classes.dex */
public class bk {
    private TbPageContext<FrsActivity> MX;
    private Animation bmn;

    public bk(TbPageContext<FrsActivity> tbPageContext) {
        this.MX = tbPageContext;
        this.bmn = AnimationUtils.loadAnimation(this.MX.getPageActivity(), t.a.frs_like);
    }

    public void Y(View view) {
        if (!this.MX.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(t.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(t.g.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.at.getColor(t.d.frs_like_shadow));
            com.baidu.tbadk.core.util.at.k(button, t.f.frs_btn_like);
            com.baidu.tbadk.core.util.at.b(textView, t.d.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.t(false);
            gVar.aa(t.g.love).Z(0).u(true);
            gVar.a(new bl(this, inflate));
            com.baidu.adp.lib.guide.d gH = gVar.gH();
            gH.d(this.MX.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.MX.getOrignalPage(), inflate, this.bmn, new bm(this, gH));
        }
    }
}
