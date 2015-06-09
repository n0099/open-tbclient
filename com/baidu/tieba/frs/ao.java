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
    private TbPageContext<FrsActivity> LH;
    private Animation aME;

    public ao(TbPageContext<FrsActivity> tbPageContext) {
        this.LH = tbPageContext;
        this.aME = AnimationUtils.loadAnimation(this.LH.getPageActivity(), com.baidu.tieba.k.frs_like);
    }

    public void w(View view) {
        if (!this.LH.getPageActivity().isFinishing()) {
            View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.frs_like_cover, null);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.q.btn_love);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.frs_like_shadow));
            com.baidu.tbadk.core.util.ay.i((View) button, com.baidu.tieba.p.frs_btn_like);
            com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.N(com.baidu.tieba.q.love).M(0).v(true);
            gVar.a(new ap(this, inflate));
            com.baidu.adp.lib.guide.d gG = gVar.gG();
            gG.i(this.LH.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.LH.getOrignalPage(), inflate, this.aME, new aq(this, gG));
        }
    }
}
