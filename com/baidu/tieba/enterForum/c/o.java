package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bEJ;
    private View bGd;
    private TextView bGe;
    private TextView bGf;
    private TextView bGg;
    private ImageView bGh;
    private View bGi;
    private TextView bGj;
    private TextView bGk;
    private TextView bGl;
    private ImageView bGm;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bEJ = viewEventCenter;
        this.bGd = view.findViewById(w.h.left_container);
        this.bGe = (TextView) this.bGd.findViewById(w.h.sign);
        this.bGf = (TextView) this.bGd.findViewById(w.h.name);
        this.bGg = (TextView) this.bGd.findViewById(w.h.grade);
        this.bGh = (ImageView) this.bGd.findViewById(w.h.add);
        this.bGi = view.findViewById(w.h.right_container);
        this.bGj = (TextView) this.bGi.findViewById(w.h.sign);
        this.bGk = (TextView) this.bGi.findViewById(w.h.name);
        this.bGl = (TextView) this.bGi.findViewById(w.h.grade);
        this.bGm = (ImageView) this.bGi.findViewById(w.h.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.Vv(), true);
            a(aVar.Vw(), false);
            b(aVar.Vv(), true);
            b(aVar.Vw(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        if (uVar != null) {
            View view = z ? this.bGd : this.bGi;
            TextView textView = z ? this.bGe : this.bGj;
            TextView textView2 = z ? this.bGf : this.bGk;
            TextView textView3 = z ? this.bGg : this.bGl;
            ImageView imageView = z ? this.bGh : this.bGm;
            switch (uVar.getType()) {
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
                    textView2.setText(uVar.getName());
                    if (uVar.bhw() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (uVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    aq.j(textView3, BitmapHelper.getGradeResourceIdNew(uVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        View view;
        if (z) {
            view = this.bGd;
        } else {
            view = this.bGi;
        }
        view.setOnClickListener(new p(this, uVar));
        view.setOnLongClickListener(new q(this, uVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        this.bGd.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        this.bGi.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        if (getData() != null && getData().Vv() != null) {
            aq.j(this.bGg, BitmapHelper.getGradeResourceIdNew(getData().Vv().getLevel()));
        }
        if (getData() != null && getData().Vw() != null) {
            aq.j(this.bGl, BitmapHelper.getGradeResourceIdNew(getData().Vw().getLevel()));
            return true;
        }
        return true;
    }
}
