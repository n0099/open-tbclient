package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRj;
    private TextView brA;
    private TextView brB;
    private ImageView brC;
    private View brt;
    private TextView bru;
    private TextView brv;
    private TextView brw;
    private ImageView brx;
    private View bry;
    private TextView brz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRj = viewEventCenter;
        this.brt = view.findViewById(r.g.left_container);
        this.bru = (TextView) this.brt.findViewById(r.g.sign);
        this.brv = (TextView) this.brt.findViewById(r.g.name);
        this.brw = (TextView) this.brt.findViewById(r.g.grade);
        this.brx = (ImageView) this.brt.findViewById(r.g.add);
        this.bry = view.findViewById(r.g.right_container);
        this.brz = (TextView) this.bry.findViewById(r.g.sign);
        this.brA = (TextView) this.bry.findViewById(r.g.name);
        this.brB = (TextView) this.bry.findViewById(r.g.grade);
        this.brC = (ImageView) this.bry.findViewById(r.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.SE(), true);
            a(aVar.SF(), false);
            b(aVar.SE(), true);
            b(aVar.SF(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.brt : this.bry;
            TextView textView = z ? this.bru : this.brz;
            TextView textView2 = z ? this.brv : this.brA;
            TextView textView3 = z ? this.brw : this.brB;
            ImageView imageView = z ? this.brx : this.brC;
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
                    if (vVar.bfi() == 0) {
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
            view = this.brt;
        } else {
            view = this.bry;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this, vVar));
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.brt.setBackgroundDrawable(ar.getDrawable(r.f.home_like_item_bg));
        this.bry.setBackgroundDrawable(ar.getDrawable(r.f.home_like_item_bg));
        if (getData() != null && getData().SE() != null) {
            ar.k(this.brw, BitmapHelper.getGradeResourceIdNew(getData().SE().getLevel()));
        }
        if (getData() != null && getData().SF() != null) {
            ar.k(this.brB, BitmapHelper.getGradeResourceIdNew(getData().SF().getLevel()));
            return true;
        }
        return true;
    }
}
