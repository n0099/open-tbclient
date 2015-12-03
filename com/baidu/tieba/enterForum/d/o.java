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
    private ViewEventCenter aQB;
    private TextView aSA;
    private ImageView aSB;
    private View aSs;
    private TextView aSt;
    private TextView aSu;
    private TextView aSv;
    private ImageView aSw;
    private View aSx;
    private TextView aSy;
    private TextView aSz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aQB = viewEventCenter;
        this.aSs = view.findViewById(n.f.left_container);
        this.aSt = (TextView) this.aSs.findViewById(n.f.sign);
        this.aSu = (TextView) this.aSs.findViewById(n.f.name);
        this.aSv = (TextView) this.aSs.findViewById(n.f.grade);
        this.aSw = (ImageView) this.aSs.findViewById(n.f.add);
        this.aSx = view.findViewById(n.f.right_container);
        this.aSy = (TextView) this.aSx.findViewById(n.f.sign);
        this.aSz = (TextView) this.aSx.findViewById(n.f.name);
        this.aSA = (TextView) this.aSx.findViewById(n.f.grade);
        this.aSB = (ImageView) this.aSx.findViewById(n.f.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.Jz(), true);
            a(aVar.JA(), false);
            b(aVar.Jz(), true);
            b(aVar.JA(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.aSs : this.aSx;
            TextView textView = z ? this.aSt : this.aSy;
            TextView textView2 = z ? this.aSu : this.aSz;
            TextView textView3 = z ? this.aSv : this.aSA;
            ImageView imageView = z ? this.aSw : this.aSB;
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
                    if (wVar.aCp() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (wVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    as.i((View) textView3, com.baidu.tbadk.core.util.c.cp(wVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        View view;
        if (z) {
            view = this.aSs;
        } else {
            view = this.aSx;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.aSs.setBackgroundDrawable(as.getDrawable(n.e.home_like_item_bg));
        this.aSx.setBackgroundDrawable(as.getDrawable(n.e.home_like_item_bg));
        if (getData() != null && getData().Jz() != null) {
            as.i((View) this.aSv, com.baidu.tbadk.core.util.c.cp(getData().Jz().getLevel()));
        }
        if (getData() != null && getData().JA() != null) {
            as.i((View) this.aSA, com.baidu.tbadk.core.util.c.cp(getData().JA().getLevel()));
            return true;
        }
        return true;
    }
}
