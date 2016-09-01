package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aOw;
    private TextView bIA;
    private TextView bIB;
    private TextView bIC;
    private ImageView bID;
    private View bIu;
    private TextView bIv;
    private TextView bIw;
    private TextView bIx;
    private ImageView bIy;
    private View bIz;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOw = viewEventCenter;
        this.bIu = view.findViewById(t.g.left_container);
        this.bIv = (TextView) this.bIu.findViewById(t.g.sign);
        this.bIw = (TextView) this.bIu.findViewById(t.g.name);
        this.bIx = (TextView) this.bIu.findViewById(t.g.grade);
        this.bIy = (ImageView) this.bIu.findViewById(t.g.add);
        this.bIz = view.findViewById(t.g.right_container);
        this.bIA = (TextView) this.bIz.findViewById(t.g.sign);
        this.bIB = (TextView) this.bIz.findViewById(t.g.name);
        this.bIC = (TextView) this.bIz.findViewById(t.g.grade);
        this.bID = (ImageView) this.bIz.findViewById(t.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.WY(), true);
            a(aVar.WZ(), false);
            b(aVar.WY(), true);
            b(aVar.WZ(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.bIu : this.bIz;
            TextView textView = z ? this.bIv : this.bIA;
            TextView textView2 = z ? this.bIw : this.bIB;
            TextView textView3 = z ? this.bIx : this.bIC;
            ImageView imageView = z ? this.bIy : this.bID;
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
                    if (wVar.bii() == 0) {
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
            view = this.bIu;
        } else {
            view = this.bIz;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.j.a.a(tbPageContext, getRootView());
        this.bIu.setBackgroundDrawable(av.getDrawable(t.f.home_like_item_bg));
        this.bIz.setBackgroundDrawable(av.getDrawable(t.f.home_like_item_bg));
        if (getData() != null && getData().WY() != null) {
            av.k(this.bIx, BitmapHelper.getGradeResourceIdNew(getData().WY().getLevel()));
        }
        if (getData() != null && getData().WZ() != null) {
            av.k(this.bIC, BitmapHelper.getGradeResourceIdNew(getData().WZ().getLevel()));
            return true;
        }
        return true;
    }
}
