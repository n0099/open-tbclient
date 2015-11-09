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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class be {
    private Animation aVP;
    private TbPageContext<FrsActivity> mContext;

    public be(TbPageContext<FrsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.aVP = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), i.a.frs_like);
    }

    public void A(View view) {
        if (!this.mContext.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(i.g.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(i.f.btn_love);
            TextView textView = (TextView) inflate.findViewById(i.f.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.an.getColor(i.c.frs_like_shadow));
            com.baidu.tbadk.core.util.an.i((View) button, i.e.frs_btn_like);
            com.baidu.tbadk.core.util.an.b(textView, i.c.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.P(i.f.love).O(0).v(true);
            gVar.a(new bf(this, inflate));
            com.baidu.adp.lib.guide.d gy = gVar.gy();
            gy.i(this.mContext.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.mContext.getOrignalPage(), inflate, this.aVP, new bg(this, gy));
        }
    }
}
