package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aCK;
    private View aEa;
    private TextView aEb;
    private TextView aEc;
    private TextView aEd;
    private ImageView aEe;
    private View aEf;
    private TextView aEg;
    private TextView aEh;
    private TextView aEi;
    private ImageView aEj;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCK = viewEventCenter;
        this.aEa = view.findViewById(com.baidu.tieba.v.left_container);
        this.aEb = (TextView) this.aEa.findViewById(com.baidu.tieba.v.sign);
        this.aEc = (TextView) this.aEa.findViewById(com.baidu.tieba.v.name);
        this.aEd = (TextView) this.aEa.findViewById(com.baidu.tieba.v.grade);
        this.aEe = (ImageView) this.aEa.findViewById(com.baidu.tieba.v.add);
        this.aEf = view.findViewById(com.baidu.tieba.v.right_container);
        this.aEg = (TextView) this.aEf.findViewById(com.baidu.tieba.v.sign);
        this.aEh = (TextView) this.aEf.findViewById(com.baidu.tieba.v.name);
        this.aEi = (TextView) this.aEf.findViewById(com.baidu.tieba.v.grade);
        this.aEj = (ImageView) this.aEf.findViewById(com.baidu.tieba.v.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(com.baidu.tieba.enterForum.b.a aVar) {
        super.A(aVar);
        if (aVar != null) {
            a(aVar.Gm(), true);
            a(aVar.Gn(), false);
            b(aVar.Gm(), true);
            b(aVar.Gn(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        if (aeVar != null) {
            View view = z ? this.aEa : this.aEf;
            TextView textView = z ? this.aEb : this.aEg;
            TextView textView2 = z ? this.aEc : this.aEh;
            TextView textView3 = z ? this.aEd : this.aEi;
            ImageView imageView = z ? this.aEe : this.aEj;
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
                    if (aeVar.akO() == 0) {
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
            view = this.aEa;
        } else {
            view = this.aEf;
        }
        view.setOnClickListener(new o(this, aeVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.aEa.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.home_like_item_bg));
        this.aEf.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.home_like_item_bg));
        if (this.aEd.getVisibility() == 0 && getData() != null && getData().Gm() != null) {
            ba.i((View) this.aEd, com.baidu.tbadk.core.util.c.bQ(getData().Gm().getLevel()));
        }
        if (this.aEi.getVisibility() == 0 && getData() != null && getData().Gn() != null) {
            ba.i((View) this.aEi, com.baidu.tbadk.core.util.c.bQ(getData().Gn().getLevel()));
            return true;
        }
        return true;
    }
}
