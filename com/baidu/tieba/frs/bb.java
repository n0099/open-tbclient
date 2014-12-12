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
public class bb {
    private Animation aDs;
    private TbPageContext<FrsActivity> mContext;

    public bb(TbPageContext<FrsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.aDs = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), com.baidu.tieba.q.frs_like);
    }

    public void v(View view) {
        if (!this.mContext.getPageActivity().isFinishing()) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.frs_like_cover, null);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.w.btn_love);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.frs_like_shadow));
            com.baidu.tbadk.core.util.ax.i((View) button, com.baidu.tieba.v.frs_btn_like);
            com.baidu.tbadk.core.util.ax.b(textView, com.baidu.tieba.t.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.J(com.baidu.tieba.w.love).I(0).v(true);
            gVar.a(new bc(this, inflate));
            com.baidu.adp.lib.guide.d dz = gVar.dz();
            dz.i(this.mContext.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.mContext.getOrignalPage(), inflate, this.aDs, new bd(this, dz));
        }
    }
}
