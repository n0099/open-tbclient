package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private View aSv;
    private ViewEventCenter bgJ;
    private TextView bxg;
    private TextView bxh;
    private TextView bxi;
    private ImageView bxj;
    private View bxk;
    private TextView bxl;
    private TextView bxm;
    private TextView bxn;
    private ImageView bxo;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bgJ = viewEventCenter;
        this.aSv = view.findViewById(u.g.left_container);
        this.bxg = (TextView) this.aSv.findViewById(u.g.sign);
        this.bxh = (TextView) this.aSv.findViewById(u.g.name);
        this.bxi = (TextView) this.aSv.findViewById(u.g.grade);
        this.bxj = (ImageView) this.aSv.findViewById(u.g.add);
        this.bxk = view.findViewById(u.g.right_container);
        this.bxl = (TextView) this.bxk.findViewById(u.g.sign);
        this.bxm = (TextView) this.bxk.findViewById(u.g.name);
        this.bxn = (TextView) this.bxk.findViewById(u.g.grade);
        this.bxo = (ImageView) this.bxk.findViewById(u.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.Sm(), true);
            a(aVar.Sn(), false);
            b(aVar.Sm(), true);
            b(aVar.Sn(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.x xVar, boolean z) {
        if (xVar != null) {
            View view = z ? this.aSv : this.bxk;
            TextView textView = z ? this.bxg : this.bxl;
            TextView textView2 = z ? this.bxh : this.bxm;
            TextView textView3 = z ? this.bxi : this.bxn;
            ImageView imageView = z ? this.bxj : this.bxo;
            switch (xVar.getType()) {
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
                    textView2.setText(xVar.getName());
                    if (xVar.beC() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (xVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    av.k(textView3, BitmapHelper.getGradeResourceIdNew(xVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.x xVar, boolean z) {
        View view;
        if (z) {
            view = this.aSv;
        } else {
            view = this.bxk;
        }
        view.setOnClickListener(new p(this, xVar));
        view.setOnLongClickListener(new q(this, xVar));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.aSv.setBackgroundDrawable(av.getDrawable(u.f.home_like_item_bg));
        this.bxk.setBackgroundDrawable(av.getDrawable(u.f.home_like_item_bg));
        if (getData() != null && getData().Sm() != null) {
            av.k(this.bxi, BitmapHelper.getGradeResourceIdNew(getData().Sm().getLevel()));
        }
        if (getData() != null && getData().Sn() != null) {
            av.k(this.bxn, BitmapHelper.getGradeResourceIdNew(getData().Sn().getLevel()));
            return true;
        }
        return true;
    }
}
