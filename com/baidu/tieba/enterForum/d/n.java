package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMG;
    private View aNZ;
    private TextView aOa;
    private TextView aOb;
    private TextView aOc;
    private ImageView aOd;
    private View aOe;
    private TextView aOf;
    private TextView aOg;
    private TextView aOh;
    private ImageView aOi;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMG = viewEventCenter;
        this.aNZ = view.findViewById(i.f.left_container);
        this.aOa = (TextView) this.aNZ.findViewById(i.f.sign);
        this.aOb = (TextView) this.aNZ.findViewById(i.f.name);
        this.aOc = (TextView) this.aNZ.findViewById(i.f.grade);
        this.aOd = (ImageView) this.aNZ.findViewById(i.f.add);
        this.aOe = view.findViewById(i.f.right_container);
        this.aOf = (TextView) this.aOe.findViewById(i.f.sign);
        this.aOg = (TextView) this.aOe.findViewById(i.f.name);
        this.aOh = (TextView) this.aOe.findViewById(i.f.grade);
        this.aOi = (ImageView) this.aOe.findViewById(i.f.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.Ia(), true);
            a(aVar.Ib(), false);
            b(aVar.Ia(), true);
            b(aVar.Ib(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.aNZ : this.aOe;
            TextView textView = z ? this.aOa : this.aOf;
            TextView textView2 = z ? this.aOb : this.aOg;
            TextView textView3 = z ? this.aOc : this.aOh;
            ImageView imageView = z ? this.aOd : this.aOi;
            switch (vVar.getType()) {
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
                    textView2.setText(vVar.getName());
                    if (vVar.atC() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (vVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    al.h((View) textView3, com.baidu.tbadk.core.util.c.cf(vVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        View view;
        if (z) {
            view = this.aNZ;
        } else {
            view = this.aOe;
        }
        view.setOnClickListener(new o(this, vVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        this.aNZ.setBackgroundDrawable(al.getDrawable(i.e.home_like_item_bg));
        this.aOe.setBackgroundDrawable(al.getDrawable(i.e.home_like_item_bg));
        if (this.aOc.getVisibility() == 0 && getData() != null && getData().Ia() != null) {
            al.h((View) this.aOc, com.baidu.tbadk.core.util.c.cf(getData().Ia().getLevel()));
        }
        if (this.aOh.getVisibility() == 0 && getData() != null && getData().Ib() != null) {
            al.h((View) this.aOh, com.baidu.tbadk.core.util.c.cf(getData().Ib().getLevel()));
            return true;
        }
        return true;
    }
}
