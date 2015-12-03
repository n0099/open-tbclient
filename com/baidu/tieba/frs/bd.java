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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class bd {
    private Animation bbe;
    private TbPageContext<FrsActivity> mContext;

    public bd(TbPageContext<FrsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.bbe = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), n.a.frs_like);
    }

    public void F(View view) {
        if (!this.mContext.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(n.f.btn_love);
            TextView textView = (TextView) inflate.findViewById(n.f.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.as.getColor(n.c.frs_like_shadow));
            com.baidu.tbadk.core.util.as.i((View) button, n.e.frs_btn_like);
            com.baidu.tbadk.core.util.as.b(textView, n.c.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.Q(n.f.love).P(0).v(true);
            gVar.a(new be(this, inflate));
            com.baidu.adp.lib.guide.d gz = gVar.gz();
            gz.i(this.mContext.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.mContext.getOrignalPage(), inflate, this.bbe, new bf(this, gz));
        }
    }
}
