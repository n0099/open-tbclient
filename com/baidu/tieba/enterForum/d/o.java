package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aPL;
    private ImageView bIA;
    private View bIB;
    private TextView bIC;
    private TextView bID;
    private TextView bIE;
    private ImageView bIF;
    private View bIw;
    private TextView bIx;
    private TextView bIy;
    private TextView bIz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aPL = viewEventCenter;
        this.bIw = view.findViewById(r.g.left_container);
        this.bIx = (TextView) this.bIw.findViewById(r.g.sign);
        this.bIy = (TextView) this.bIw.findViewById(r.g.name);
        this.bIz = (TextView) this.bIw.findViewById(r.g.grade);
        this.bIA = (ImageView) this.bIw.findViewById(r.g.add);
        this.bIB = view.findViewById(r.g.right_container);
        this.bIC = (TextView) this.bIB.findViewById(r.g.sign);
        this.bID = (TextView) this.bIB.findViewById(r.g.name);
        this.bIE = (TextView) this.bIB.findViewById(r.g.grade);
        this.bIF = (ImageView) this.bIB.findViewById(r.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.Xr(), true);
            a(aVar.Xs(), false);
            b(aVar.Xr(), true);
            b(aVar.Xs(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.bIw : this.bIB;
            TextView textView = z ? this.bIx : this.bIC;
            TextView textView2 = z ? this.bIy : this.bID;
            TextView textView3 = z ? this.bIz : this.bIE;
            ImageView imageView = z ? this.bIA : this.bIF;
            switch (wVar.getType()) {
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
                    textView2.setText(wVar.getName());
                    if (wVar.biT() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (wVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    av.k(textView3, BitmapHelper.getGradeResourceIdNew(wVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        View view;
        if (z) {
            view = this.bIw;
        } else {
            view = this.bIB;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.bIw.setBackgroundDrawable(av.getDrawable(r.f.home_like_item_bg));
        this.bIB.setBackgroundDrawable(av.getDrawable(r.f.home_like_item_bg));
        if (getData() != null && getData().Xr() != null) {
            av.k(this.bIz, BitmapHelper.getGradeResourceIdNew(getData().Xr().getLevel()));
        }
        if (getData() != null && getData().Xs() != null) {
            av.k(this.bIE, BitmapHelper.getGradeResourceIdNew(getData().Xs().getLevel()));
            return true;
        }
        return true;
    }
}
