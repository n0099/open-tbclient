package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCS;
    private View aEi;
    private TextView aEj;
    private TextView aEk;
    private TextView aEl;
    private ImageView aEm;
    private View aEn;
    private TextView aEo;
    private TextView aEp;
    private TextView aEq;
    private ImageView aEr;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCS = viewEventCenter;
        this.aEi = view.findViewById(com.baidu.tieba.v.left_container);
        this.aEj = (TextView) this.aEi.findViewById(com.baidu.tieba.v.sign);
        this.aEk = (TextView) this.aEi.findViewById(com.baidu.tieba.v.name);
        this.aEl = (TextView) this.aEi.findViewById(com.baidu.tieba.v.grade);
        this.aEm = (ImageView) this.aEi.findViewById(com.baidu.tieba.v.add);
        this.aEn = view.findViewById(com.baidu.tieba.v.right_container);
        this.aEo = (TextView) this.aEn.findViewById(com.baidu.tieba.v.sign);
        this.aEp = (TextView) this.aEn.findViewById(com.baidu.tieba.v.name);
        this.aEq = (TextView) this.aEn.findViewById(com.baidu.tieba.v.grade);
        this.aEr = (ImageView) this.aEn.findViewById(com.baidu.tieba.v.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.enterForum.b.a aVar) {
        super.A(aVar);
        if (aVar != null) {
            a(aVar.Gs(), true);
            a(aVar.Gt(), false);
            b(aVar.Gs(), true);
            b(aVar.Gt(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        if (aeVar != null) {
            View view = z ? this.aEi : this.aEn;
            TextView textView = z ? this.aEj : this.aEo;
            TextView textView2 = z ? this.aEk : this.aEp;
            TextView textView3 = z ? this.aEl : this.aEq;
            ImageView imageView = z ? this.aEm : this.aEr;
            switch (aeVar.getType()) {
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
                    textView2.setText(aeVar.getName());
                    if (aeVar.ald() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (aeVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    ba.i((View) textView3, com.baidu.tbadk.core.util.c.bQ(aeVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        View view;
        if (z) {
            view = this.aEi;
        } else {
            view = this.aEn;
        }
        view.setOnClickListener(new o(this, aeVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.aEi.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.home_like_item_bg));
        this.aEn.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.home_like_item_bg));
        if (this.aEl.getVisibility() == 0 && getData() != null && getData().Gs() != null) {
            ba.i((View) this.aEl, com.baidu.tbadk.core.util.c.bQ(getData().Gs().getLevel()));
        }
        if (this.aEq.getVisibility() == 0 && getData() != null && getData().Gt() != null) {
            ba.i((View) this.aEq, com.baidu.tbadk.core.util.c.bQ(getData().Gt().getLevel()));
            return true;
        }
        return true;
    }
}
