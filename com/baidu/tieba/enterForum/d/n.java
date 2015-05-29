package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aET;
    private View aGl;
    private TextView aGm;
    private TextView aGn;
    private TextView aGo;
    private ImageView aGp;
    private View aGq;
    private TextView aGr;
    private TextView aGs;
    private TextView aGt;
    private ImageView aGu;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aET = viewEventCenter;
        this.aGl = view.findViewById(com.baidu.tieba.q.left_container);
        this.aGm = (TextView) this.aGl.findViewById(com.baidu.tieba.q.sign);
        this.aGn = (TextView) this.aGl.findViewById(com.baidu.tieba.q.name);
        this.aGo = (TextView) this.aGl.findViewById(com.baidu.tieba.q.grade);
        this.aGp = (ImageView) this.aGl.findViewById(com.baidu.tieba.q.add);
        this.aGq = view.findViewById(com.baidu.tieba.q.right_container);
        this.aGr = (TextView) this.aGq.findViewById(com.baidu.tieba.q.sign);
        this.aGs = (TextView) this.aGq.findViewById(com.baidu.tieba.q.name);
        this.aGt = (TextView) this.aGq.findViewById(com.baidu.tieba.q.grade);
        this.aGu = (ImageView) this.aGq.findViewById(com.baidu.tieba.q.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.enterForum.b.a aVar) {
        super.z(aVar);
        if (aVar != null) {
            a(aVar.Hw(), true);
            a(aVar.Hx(), false);
            b(aVar.Hw(), true);
            b(aVar.Hx(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        if (aeVar != null) {
            View view = z ? this.aGl : this.aGq;
            TextView textView = z ? this.aGm : this.aGr;
            TextView textView2 = z ? this.aGn : this.aGs;
            TextView textView3 = z ? this.aGo : this.aGt;
            ImageView imageView = z ? this.aGp : this.aGu;
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
                    if (aeVar.amO() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (aeVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    ay.i((View) textView3, com.baidu.tbadk.core.util.c.bT(aeVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        View view;
        if (z) {
            view = this.aGl;
        } else {
            view = this.aGq;
        }
        view.setOnClickListener(new o(this, aeVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.aGl.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.home_like_item_bg));
        this.aGq.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.home_like_item_bg));
        if (this.aGo.getVisibility() == 0 && getData() != null && getData().Hw() != null) {
            ay.i((View) this.aGo, com.baidu.tbadk.core.util.c.bT(getData().Hw().getLevel()));
        }
        if (this.aGt.getVisibility() == 0 && getData() != null && getData().Hx() != null) {
            ay.i((View) this.aGt, com.baidu.tbadk.core.util.c.bT(getData().Hx().getLevel()));
            return true;
        }
        return true;
    }
}
