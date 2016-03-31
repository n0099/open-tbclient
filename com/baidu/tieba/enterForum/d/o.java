package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bbj;
    private TextView bdA;
    private ImageView bdB;
    private View bds;
    private TextView bdt;
    private TextView bdu;
    private TextView bdv;
    private ImageView bdw;
    private View bdx;
    private TextView bdy;
    private TextView bdz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bbj = viewEventCenter;
        this.bds = view.findViewById(t.g.left_container);
        this.bdt = (TextView) this.bds.findViewById(t.g.sign);
        this.bdu = (TextView) this.bds.findViewById(t.g.name);
        this.bdv = (TextView) this.bds.findViewById(t.g.grade);
        this.bdw = (ImageView) this.bds.findViewById(t.g.add);
        this.bdx = view.findViewById(t.g.right_container);
        this.bdy = (TextView) this.bdx.findViewById(t.g.sign);
        this.bdz = (TextView) this.bdx.findViewById(t.g.name);
        this.bdA = (TextView) this.bdx.findViewById(t.g.grade);
        this.bdB = (ImageView) this.bdx.findViewById(t.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.Ns(), true);
            a(aVar.Nt(), false);
            b(aVar.Ns(), true);
            b(aVar.Nt(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.bds : this.bdx;
            TextView textView = z ? this.bdt : this.bdy;
            TextView textView2 = z ? this.bdu : this.bdz;
            TextView textView3 = z ? this.bdv : this.bdA;
            ImageView imageView = z ? this.bdw : this.bdB;
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
                    if (vVar.aSw() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (vVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    at.k(textView3, BitmapHelper.getGradeResourceIdNew(vVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        View view;
        if (z) {
            view = this.bds;
        } else {
            view = this.bdx;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this, vVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.bds.setBackgroundDrawable(at.getDrawable(t.f.home_like_item_bg));
        this.bdx.setBackgroundDrawable(at.getDrawable(t.f.home_like_item_bg));
        if (getData() != null && getData().Ns() != null) {
            at.k(this.bdv, BitmapHelper.getGradeResourceIdNew(getData().Ns().getLevel()));
        }
        if (getData() != null && getData().Nt() != null) {
            at.k(this.bdA, BitmapHelper.getGradeResourceIdNew(getData().Nt().getLevel()));
            return true;
        }
        return true;
    }
}
