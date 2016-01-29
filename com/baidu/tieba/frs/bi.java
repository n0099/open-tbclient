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
public class bi {
    private TbPageContext<FrsActivity> MR;
    private Animation bhB;

    public bi(TbPageContext<FrsActivity> tbPageContext) {
        this.MR = tbPageContext;
        this.bhB = AnimationUtils.loadAnimation(this.MR.getPageActivity(), t.a.frs_like);
    }

    public void U(View view) {
        if (!this.MR.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(t.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(t.g.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.ar.getColor(t.d.frs_like_shadow));
            com.baidu.tbadk.core.util.ar.k(button, t.f.frs_btn_like);
            com.baidu.tbadk.core.util.ar.b(textView, t.d.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.ab(t.g.love).aa(0).v(true);
            gVar.a(new bj(this, inflate));
            com.baidu.adp.lib.guide.d gH = gVar.gH();
            gH.i(this.MR.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.MR.getOrignalPage(), inflate, this.bhB, new bk(this, gH));
        }
    }
}
