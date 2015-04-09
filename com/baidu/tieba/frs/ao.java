package com.baidu.tieba.frs;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class ao {
    private TbPageContext<FrsActivity> LP;
    private Animation aKw;

    public ao(TbPageContext<FrsActivity> tbPageContext) {
        this.LP = tbPageContext;
        this.aKw = AnimationUtils.loadAnimation(this.LP.getPageActivity(), com.baidu.tieba.p.frs_like);
    }

    public void t(View view) {
        if (!this.LP.getPageActivity().isFinishing()) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.LP.getPageActivity(), com.baidu.tieba.w.frs_like_cover, null);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.v.btn_love);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.frs_like_shadow));
            com.baidu.tbadk.core.util.ba.i((View) button, com.baidu.tieba.u.frs_btn_like);
            com.baidu.tbadk.core.util.ba.b(textView, com.baidu.tieba.s.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.P(com.baidu.tieba.v.love).O(0).v(true);
            gVar.a(new ap(this, inflate));
            com.baidu.adp.lib.guide.d gV = gVar.gV();
            gV.i(this.LP.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.LP.getOrignalPage(), inflate, this.aKw, new aq(this, gV));
        }
    }
}
