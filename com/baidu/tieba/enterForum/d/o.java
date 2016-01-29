package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aWA;
    private View aYI;
    private TextView aYJ;
    private TextView aYK;
    private TextView aYL;
    private ImageView aYM;
    private View aYN;
    private TextView aYO;
    private TextView aYP;
    private TextView aYQ;
    private ImageView aYR;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aWA = viewEventCenter;
        this.aYI = view.findViewById(t.g.left_container);
        this.aYJ = (TextView) this.aYI.findViewById(t.g.sign);
        this.aYK = (TextView) this.aYI.findViewById(t.g.name);
        this.aYL = (TextView) this.aYI.findViewById(t.g.grade);
        this.aYM = (ImageView) this.aYI.findViewById(t.g.add);
        this.aYN = view.findViewById(t.g.right_container);
        this.aYO = (TextView) this.aYN.findViewById(t.g.sign);
        this.aYP = (TextView) this.aYN.findViewById(t.g.name);
        this.aYQ = (TextView) this.aYN.findViewById(t.g.grade);
        this.aYR = (ImageView) this.aYN.findViewById(t.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.LE(), true);
            a(aVar.LF(), false);
            b(aVar.LE(), true);
            b(aVar.LF(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.aYI : this.aYN;
            TextView textView = z ? this.aYJ : this.aYO;
            TextView textView2 = z ? this.aYK : this.aYP;
            TextView textView3 = z ? this.aYL : this.aYQ;
            ImageView imageView = z ? this.aYM : this.aYR;
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
                    if (vVar.aLD() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (vVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    ar.k(textView3, BitmapHelper.getGradeResourceIdNew(vVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        View view;
        if (z) {
            view = this.aYI;
        } else {
            view = this.aYN;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this, vVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.aYI.setBackgroundDrawable(ar.getDrawable(t.f.home_like_item_bg));
        this.aYN.setBackgroundDrawable(ar.getDrawable(t.f.home_like_item_bg));
        if (getData() != null && getData().LE() != null) {
            ar.k(this.aYL, BitmapHelper.getGradeResourceIdNew(getData().LE().getLevel()));
        }
        if (getData() != null && getData().LF() != null) {
            ar.k(this.aYQ, BitmapHelper.getGradeResourceIdNew(getData().LF().getLevel()));
            return true;
        }
        return true;
    }
}
