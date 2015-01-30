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
public class ba {
    private Animation aEt;
    private TbPageContext<FrsActivity> mContext;

    public ba(TbPageContext<FrsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.aEt = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), com.baidu.tieba.q.frs_like);
    }

    public void v(View view) {
        if (!this.mContext.getPageActivity().isFinishing()) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.frs_like_cover, null);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.w.btn_love);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.frs_like_shadow));
            com.baidu.tbadk.core.util.bc.i((View) button, com.baidu.tieba.v.frs_btn_like);
            com.baidu.tbadk.core.util.bc.b(textView, com.baidu.tieba.t.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.O(com.baidu.tieba.w.love).N(0).v(true);
            gVar.a(new bb(this, inflate));
            com.baidu.adp.lib.guide.d dx = gVar.dx();
            dx.i(this.mContext.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.mContext.getOrignalPage(), inflate, this.aEt, new bc(this, dx));
        }
    }
}
