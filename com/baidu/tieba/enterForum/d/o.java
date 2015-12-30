package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aUs;
    private TextView aWA;
    private TextView aWB;
    private TextView aWC;
    private ImageView aWD;
    private View aWu;
    private TextView aWv;
    private TextView aWw;
    private TextView aWx;
    private ImageView aWy;
    private View aWz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aUs = viewEventCenter;
        this.aWu = view.findViewById(n.g.left_container);
        this.aWv = (TextView) this.aWu.findViewById(n.g.sign);
        this.aWw = (TextView) this.aWu.findViewById(n.g.name);
        this.aWx = (TextView) this.aWu.findViewById(n.g.grade);
        this.aWy = (ImageView) this.aWu.findViewById(n.g.add);
        this.aWz = view.findViewById(n.g.right_container);
        this.aWA = (TextView) this.aWz.findViewById(n.g.sign);
        this.aWB = (TextView) this.aWz.findViewById(n.g.name);
        this.aWC = (TextView) this.aWz.findViewById(n.g.grade);
        this.aWD = (ImageView) this.aWz.findViewById(n.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.JQ(), true);
            a(aVar.JR(), false);
            b(aVar.JQ(), true);
            b(aVar.JR(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.aWu : this.aWz;
            TextView textView = z ? this.aWv : this.aWA;
            TextView textView2 = z ? this.aWw : this.aWB;
            TextView textView3 = z ? this.aWx : this.aWC;
            ImageView imageView = z ? this.aWy : this.aWD;
            switch (wVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    imageView.setVisibility(0);
                    textView2.setVisibility(8);
                    textView.setVisibility(8);
                    textView3.setVisibility(8);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    imageView.setVisibility(8);
                    textView2.setVisibility(0);
                    textView2.setText(wVar.getName());
                    if (wVar.aEx() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (wVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    as.i((View) textView3, com.baidu.tbadk.core.util.c.ci(wVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        View view;
        if (z) {
            view = this.aWu;
        } else {
            view = this.aWz;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.aWu.setBackgroundDrawable(as.getDrawable(n.f.home_like_item_bg));
        this.aWz.setBackgroundDrawable(as.getDrawable(n.f.home_like_item_bg));
        if (getData() != null && getData().JQ() != null) {
            as.i((View) this.aWx, com.baidu.tbadk.core.util.c.ci(getData().JQ().getLevel()));
        }
        if (getData() != null && getData().JR() != null) {
            as.i((View) this.aWC, com.baidu.tbadk.core.util.c.ci(getData().JR().getLevel()));
            return true;
        }
        return true;
    }
}
