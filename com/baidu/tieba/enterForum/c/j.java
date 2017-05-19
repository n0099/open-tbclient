package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bGb;
    private View bHS;
    private TextView bHT;
    private ImageView bHU;
    private ImageView bHV;
    private View bHW;
    private TextView bHX;
    private ImageView bHY;
    private ImageView bHZ;
    private ImageView bIa;
    private ImageView bIb;

    public j(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bGb = viewEventCenter;
        this.bHS = view.findViewById(w.h.left_container);
        this.bHT = (TextView) this.bHS.findViewById(w.h.name);
        this.bHU = (ImageView) this.bHS.findViewById(w.h.sign);
        this.bHV = (ImageView) this.bHS.findViewById(w.h.grade);
        this.bHW = view.findViewById(w.h.right_container);
        this.bHX = (TextView) this.bHW.findViewById(w.h.name);
        this.bHY = (ImageView) this.bHW.findViewById(w.h.sign);
        this.bHZ = (ImageView) this.bHW.findViewById(w.h.grade);
        this.bIa = (ImageView) view.findViewById(w.h.divide_line_middle);
        this.bIb = (ImageView) view.findViewById(w.h.divide_line);
        int g = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bHV.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = g;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.VR(), true);
            a(aVar.VS(), false);
            b(aVar.VR(), true);
            b(aVar.VS(), false);
            aq.k(this.bIa, w.e.cp_bg_line_c);
            aq.k(this.bIb, w.e.cp_bg_line_c);
            aq.j(this.bHU, w.g.icon_sign);
            aq.j(this.bHY, w.g.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.bHS : this.bHW;
            TextView textView = z ? this.bHT : this.bHX;
            ImageView imageView = z ? this.bHU : this.bHY;
            ImageView imageView2 = z ? this.bHV : this.bHZ;
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(w.l.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aq.i(textView, w.e.cp_link_tip_a);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof com.baidu.tieba.enterForum.b.g) {
                        com.baidu.tieba.enterForum.b.g gVar = (com.baidu.tieba.enterForum.b.g) eVar;
                        textView.setText(gVar.getName());
                        imageView.setVisibility(gVar.VY() == 0 ? 8 : 0);
                        if (gVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            aq.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(gVar.getLevel()));
                        }
                    } else if (eVar instanceof com.baidu.tieba.enterForum.b.j) {
                        textView.setText(((com.baidu.tieba.enterForum.b.j) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                    }
                    aq.i(textView, w.e.cp_cont_b);
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.bHS;
        } else {
            view = this.bHW;
        }
        view.setOnClickListener(new k(this, eVar));
        view.setOnLongClickListener(new l(this, eVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
