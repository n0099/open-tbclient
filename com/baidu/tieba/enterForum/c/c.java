package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.b.j;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bYx;
    private View caI;
    private TextView caJ;
    private ImageView caK;
    private ImageView caL;
    private View caM;
    private TextView caN;
    private ImageView caO;
    private ImageView caP;
    private ImageView caQ;
    private ImageView caR;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bYx = viewEventCenter;
        this.caI = view.findViewById(d.h.left_container);
        this.caJ = (TextView) this.caI.findViewById(d.h.name);
        this.caK = (ImageView) this.caI.findViewById(d.h.sign);
        this.caL = (ImageView) this.caI.findViewById(d.h.grade);
        this.caM = view.findViewById(d.h.right_container);
        this.caN = (TextView) this.caM.findViewById(d.h.name);
        this.caO = (ImageView) this.caM.findViewById(d.h.sign);
        this.caP = (ImageView) this.caM.findViewById(d.h.grade);
        this.caQ = (ImageView) view.findViewById(d.h.divide_line_middle);
        this.caR = (ImageView) view.findViewById(d.h.divide_line);
        int g = k.g(tbPageContext.getPageActivity(), d.f.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.caL.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = g;
        }
        int g2 = k.g(tbPageContext.getPageActivity(), d.f.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.caN.getLayoutParams();
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
            a(aVar.abz(), true);
            a(aVar.abA(), false);
            b(aVar.abz(), true);
            b(aVar.abA(), false);
            ai.k(this.caQ, d.e.cp_bg_line_c);
            ai.k(this.caR, d.e.cp_bg_line_c);
            ai.j(this.caK, d.g.icon_sign);
            ai.j(this.caO, d.g.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.caI : this.caM;
            TextView textView = z ? this.caJ : this.caN;
            ImageView imageView = z ? this.caK : this.caO;
            ImageView imageView2 = z ? this.caL : this.caP;
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.l.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    ai.i(textView, d.e.cp_link_tip_a);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof g) {
                        g gVar = (g) eVar;
                        textView.setText(gVar.getName());
                        imageView.setVisibility(gVar.abH() == 0 ? 8 : 0);
                        if (gVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            ai.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(gVar.getLevel()));
                        }
                    } else if (eVar instanceof j) {
                        textView.setText(((j) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                    }
                    ai.i(textView, d.e.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.caI;
        } else {
            view = this.caM;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.bYx != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        case 2:
                        default:
                            return;
                        case 3:
                            c.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(5, eVar, null, null));
                            return;
                    }
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.c.c.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (c.this.bYx != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.bYx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new i(c.this.position), null, null));
                        case 3:
                            return true;
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
