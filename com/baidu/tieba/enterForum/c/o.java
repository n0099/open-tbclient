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
    private ViewEventCenter bEQ;
    private View bGk;
    private TextView bGl;
    private TextView bGm;
    private TextView bGn;
    private ImageView bGo;
    private View bGp;
    private TextView bGq;
    private TextView bGr;
    private TextView bGs;
    private ImageView bGt;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bEQ = viewEventCenter;
        this.bGk = view.findViewById(w.h.left_container);
        this.bGl = (TextView) this.bGk.findViewById(w.h.sign);
        this.bGm = (TextView) this.bGk.findViewById(w.h.name);
        this.bGn = (TextView) this.bGk.findViewById(w.h.grade);
        this.bGo = (ImageView) this.bGk.findViewById(w.h.add);
        this.bGp = view.findViewById(w.h.right_container);
        this.bGq = (TextView) this.bGp.findViewById(w.h.sign);
        this.bGr = (TextView) this.bGp.findViewById(w.h.name);
        this.bGs = (TextView) this.bGp.findViewById(w.h.grade);
        this.bGt = (ImageView) this.bGp.findViewById(w.h.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.UX(), true);
            a(aVar.UY(), false);
            b(aVar.UX(), true);
            b(aVar.UY(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        if (uVar != null) {
            View view = z ? this.bGk : this.bGp;
            TextView textView = z ? this.bGl : this.bGq;
            TextView textView2 = z ? this.bGm : this.bGr;
            TextView textView3 = z ? this.bGn : this.bGs;
            ImageView imageView = z ? this.bGo : this.bGt;
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
                    if (uVar.bgL() == 0) {
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
            view = this.bGk;
        } else {
            view = this.bGp;
        }
        view.setOnClickListener(new p(this, uVar));
        view.setOnLongClickListener(new q(this, uVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.bGk.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        this.bGp.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        if (getData() != null && getData().UX() != null) {
            aq.j(this.bGn, BitmapHelper.getGradeResourceIdNew(getData().UX().getLevel()));
        }
        if (getData() != null && getData().UY() != null) {
            aq.j(this.bGs, BitmapHelper.getGradeResourceIdNew(getData().UY().getLevel()));
            return true;
        }
        return true;
    }
}
