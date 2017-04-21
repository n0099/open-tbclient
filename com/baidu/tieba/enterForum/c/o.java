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
    private ViewEventCenter bHa;
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
        this.bHa = viewEventCenter;
        this.bIu = view.findViewById(w.h.left_container);
        this.bIv = (TextView) this.bIu.findViewById(w.h.sign);
        this.bIw = (TextView) this.bIu.findViewById(w.h.name);
        this.bIx = (TextView) this.bIu.findViewById(w.h.grade);
        this.bIy = (ImageView) this.bIu.findViewById(w.h.add);
        this.bIz = view.findViewById(w.h.right_container);
        this.bIA = (TextView) this.bIz.findViewById(w.h.sign);
        this.bIB = (TextView) this.bIz.findViewById(w.h.name);
        this.bIC = (TextView) this.bIz.findViewById(w.h.grade);
        this.bID = (ImageView) this.bIz.findViewById(w.h.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.Ww(), true);
            a(aVar.Wx(), false);
            b(aVar.Ww(), true);
            b(aVar.Wx(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        if (uVar != null) {
            View view = z ? this.bIu : this.bIz;
            TextView textView = z ? this.bIv : this.bIA;
            TextView textView2 = z ? this.bIw : this.bIB;
            TextView textView3 = z ? this.bIx : this.bIC;
            ImageView imageView = z ? this.bIy : this.bID;
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
                    if (uVar.bix() == 0) {
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
            view = this.bIu;
        } else {
            view = this.bIz;
        }
        view.setOnClickListener(new p(this, uVar));
        view.setOnLongClickListener(new q(this, uVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        this.bIu.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        this.bIz.setBackgroundDrawable(aq.getDrawable(w.g.home_like_item_bg));
        if (getData() != null && getData().Ww() != null) {
            aq.j(this.bIx, BitmapHelper.getGradeResourceIdNew(getData().Ww().getLevel()));
        }
        if (getData() != null && getData().Wx() != null) {
            aq.j(this.bIC, BitmapHelper.getGradeResourceIdNew(getData().Wx().getLevel()));
            return true;
        }
        return true;
    }
}
