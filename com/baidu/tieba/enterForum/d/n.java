package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.j.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.e.c> {
    private ViewEventCenter aEU;
    private View aGm;
    private TextView aGn;
    private TextView aGo;
    private TextView aGp;
    private ImageView aGq;
    private View aGr;
    private TextView aGs;
    private TextView aGt;
    private TextView aGu;
    private ImageView aGv;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEU = viewEventCenter;
        this.aGm = view.findViewById(com.baidu.tieba.q.left_container);
        this.aGn = (TextView) this.aGm.findViewById(com.baidu.tieba.q.sign);
        this.aGo = (TextView) this.aGm.findViewById(com.baidu.tieba.q.name);
        this.aGp = (TextView) this.aGm.findViewById(com.baidu.tieba.q.grade);
        this.aGq = (ImageView) this.aGm.findViewById(com.baidu.tieba.q.add);
        this.aGr = view.findViewById(com.baidu.tieba.q.right_container);
        this.aGs = (TextView) this.aGr.findViewById(com.baidu.tieba.q.sign);
        this.aGt = (TextView) this.aGr.findViewById(com.baidu.tieba.q.name);
        this.aGu = (TextView) this.aGr.findViewById(com.baidu.tieba.q.grade);
        this.aGv = (ImageView) this.aGr.findViewById(com.baidu.tieba.q.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(com.baidu.tieba.enterForum.b.a aVar) {
        super.z(aVar);
        if (aVar != null) {
            a(aVar.Hx(), true);
            a(aVar.Hy(), false);
            b(aVar.Hx(), true);
            b(aVar.Hy(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.ae aeVar, boolean z) {
        if (aeVar != null) {
            View view = z ? this.aGm : this.aGr;
            TextView textView = z ? this.aGn : this.aGs;
            TextView textView2 = z ? this.aGo : this.aGt;
            TextView textView3 = z ? this.aGp : this.aGu;
            ImageView imageView = z ? this.aGq : this.aGv;
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
                    if (aeVar.amP() == 0) {
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
            view = this.aGm;
        } else {
            view = this.aGr;
        }
        view.setOnClickListener(new o(this, aeVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.aGm.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.home_like_item_bg));
        this.aGr.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.home_like_item_bg));
        if (this.aGp.getVisibility() == 0 && getData() != null && getData().Hx() != null) {
            ay.i((View) this.aGp, com.baidu.tbadk.core.util.c.bT(getData().Hx().getLevel()));
        }
        if (this.aGu.getVisibility() == 0 && getData() != null && getData().Hy() != null) {
            ay.i((View) this.aGu, com.baidu.tbadk.core.util.c.bT(getData().Hy().getLevel()));
            return true;
        }
        return true;
    }
}
