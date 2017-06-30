package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bSq;
    private View bUB;
    private TextView bUC;
    private ImageView bUD;
    private ImageView bUE;
    private View bUF;
    private TextView bUG;
    private ImageView bUH;
    private ImageView bUI;
    private ImageView bUJ;
    private ImageView bUK;

    public i(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bSq = viewEventCenter;
        this.bUB = view.findViewById(w.h.left_container);
        this.bUC = (TextView) this.bUB.findViewById(w.h.name);
        this.bUD = (ImageView) this.bUB.findViewById(w.h.sign);
        this.bUE = (ImageView) this.bUB.findViewById(w.h.grade);
        this.bUF = view.findViewById(w.h.right_container);
        this.bUG = (TextView) this.bUF.findViewById(w.h.name);
        this.bUH = (ImageView) this.bUF.findViewById(w.h.sign);
        this.bUI = (ImageView) this.bUF.findViewById(w.h.grade);
        this.bUJ = (ImageView) view.findViewById(w.h.divide_line_middle);
        this.bUK = (ImageView) view.findViewById(w.h.divide_line);
        int g = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.bUE.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = g;
        }
        int g2 = com.baidu.adp.lib.util.k.g(tbPageContext.getPageActivity(), w.f.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.bUG.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = g2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.aaq(), true);
            a(aVar.aar(), false);
            b(aVar.aaq(), true);
            b(aVar.aar(), false);
            as.k(this.bUJ, w.e.cp_bg_line_c);
            as.k(this.bUK, w.e.cp_bg_line_c);
            as.j(this.bUD, w.g.icon_sign);
            as.j(this.bUH, w.g.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.bUB : this.bUF;
            TextView textView = z ? this.bUC : this.bUG;
            ImageView imageView = z ? this.bUD : this.bUH;
            ImageView imageView2 = z ? this.bUE : this.bUI;
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(w.l.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    as.i(textView, w.e.cp_link_tip_a);
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
                        imageView.setVisibility(gVar.aay() == 0 ? 8 : 0);
                        if (gVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            as.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(gVar.getLevel()));
                        }
                    } else if (eVar instanceof com.baidu.tieba.enterForum.b.j) {
                        textView.setText(((com.baidu.tieba.enterForum.b.j) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                    }
                    as.i(textView, w.e.cp_cont_b);
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.bUB;
        } else {
            view = this.bUF;
        }
        view.setOnClickListener(new j(this, eVar));
        view.setOnLongClickListener(new k(this, eVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.m.a.a(tbPageContext, getRootView());
        return true;
    }
}
