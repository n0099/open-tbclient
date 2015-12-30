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
public class bg {
    private Animation bfd;
    private TbPageContext<FrsActivity> mContext;

    public bg(TbPageContext<FrsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.bfd = AnimationUtils.loadAnimation(this.mContext.getPageActivity(), n.a.frs_like);
    }

    public void G(View view) {
        if (!this.mContext.getPageActivity().isFinishing()) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.frs_like_cover, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(n.g.btn_love);
            TextView textView = (TextView) inflate.findViewById(n.g.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.as.getColor(n.d.frs_like_shadow));
            com.baidu.tbadk.core.util.as.i((View) button, n.f.frs_btn_like);
            com.baidu.tbadk.core.util.as.b(textView, n.d.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.u(false);
            gVar.Q(n.g.love).P(0).v(true);
            gVar.a(new bh(this, inflate));
            com.baidu.adp.lib.guide.d gz = gVar.gz();
            gz.i(this.mContext.getPageActivity());
            com.baidu.tieba.tbadkCore.a.a(this.mContext.getOrignalPage(), inflate, this.bfd, new bi(this, gz));
        }
    }
}
