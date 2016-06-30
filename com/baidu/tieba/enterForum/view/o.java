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
    private View aRB;
    private ViewEventCenter bfx;
    private TextView buS;
    private TextView buT;
    private TextView buU;
    private ImageView buV;
    private View buW;
    private TextView buX;
    private TextView buY;
    private TextView buZ;
    private ImageView bva;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bfx = viewEventCenter;
        this.aRB = view.findViewById(u.g.left_container);
        this.buS = (TextView) this.aRB.findViewById(u.g.sign);
        this.buT = (TextView) this.aRB.findViewById(u.g.name);
        this.buU = (TextView) this.aRB.findViewById(u.g.grade);
        this.buV = (ImageView) this.aRB.findViewById(u.g.add);
        this.buW = view.findViewById(u.g.right_container);
        this.buX = (TextView) this.buW.findViewById(u.g.sign);
        this.buY = (TextView) this.buW.findViewById(u.g.name);
        this.buZ = (TextView) this.buW.findViewById(u.g.grade);
        this.bva = (ImageView) this.buW.findViewById(u.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.RF(), true);
            a(aVar.RG(), false);
            b(aVar.RF(), true);
            b(aVar.RG(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.x xVar, boolean z) {
        if (xVar != null) {
            View view = z ? this.aRB : this.buW;
            TextView textView = z ? this.buS : this.buX;
            TextView textView2 = z ? this.buT : this.buY;
            TextView textView3 = z ? this.buU : this.buZ;
            ImageView imageView = z ? this.buV : this.bva;
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
                    if (xVar.bbo() == 0) {
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
            view = this.aRB;
        } else {
            view = this.buW;
        }
        view.setOnClickListener(new p(this, xVar));
        view.setOnLongClickListener(new q(this, xVar));
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.aRB.setBackgroundDrawable(av.getDrawable(u.f.home_like_item_bg));
        this.buW.setBackgroundDrawable(av.getDrawable(u.f.home_like_item_bg));
        if (getData() != null && getData().RF() != null) {
            av.k(this.buU, BitmapHelper.getGradeResourceIdNew(getData().RF().getLevel()));
        }
        if (getData() != null && getData().RG() != null) {
            av.k(this.buZ, BitmapHelper.getGradeResourceIdNew(getData().RG().getLevel()));
            return true;
        }
        return true;
    }
}
