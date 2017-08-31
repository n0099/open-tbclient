package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.b.j;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cbt;
    private TextView cdA;
    private ImageView cdB;
    private ImageView cdC;
    private View cdD;
    private TextView cdE;
    private ImageView cdF;
    private ImageView cdG;
    private ImageView cdH;
    private ImageView cdI;
    private View cdz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cbt = viewEventCenter;
        this.cdz = view.findViewById(d.h.left_container);
        this.cdA = (TextView) this.cdz.findViewById(d.h.name);
        this.cdB = (ImageView) this.cdz.findViewById(d.h.sign);
        this.cdC = (ImageView) this.cdz.findViewById(d.h.grade);
        this.cdD = view.findViewById(d.h.right_container);
        this.cdE = (TextView) this.cdD.findViewById(d.h.name);
        this.cdF = (ImageView) this.cdD.findViewById(d.h.sign);
        this.cdG = (ImageView) this.cdD.findViewById(d.h.grade);
        this.cdH = (ImageView) view.findViewById(d.h.divide_line_middle);
        this.cdI = (ImageView) view.findViewById(d.h.divide_line);
        int g = k.g(tbPageContext.getPageActivity(), d.f.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cdC.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = g;
        }
        int g2 = k.g(tbPageContext.getPageActivity(), d.f.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cdE.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = g2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(com.baidu.tieba.enterForum.b.a aVar) {
        super.D(aVar);
        if (aVar != null) {
            a(aVar.acC(), true);
            a(aVar.acD(), false);
            b(aVar.acC(), true);
            b(aVar.acD(), false);
            aj.k(this.cdH, d.e.cp_bg_line_c);
            aj.k(this.cdI, d.e.cp_bg_line_c);
            aj.j(this.cdB, d.g.icon_sign);
            aj.j(this.cdF, d.g.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.cdz : this.cdD;
            TextView textView = z ? this.cdA : this.cdE;
            ImageView imageView = z ? this.cdB : this.cdF;
            ImageView imageView2 = z ? this.cdC : this.cdG;
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.l.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.i(textView, d.e.cp_link_tip_a);
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
                        imageView.setVisibility(gVar.acJ() == 0 ? 8 : 0);
                        if (gVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            aj.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(gVar.getLevel()));
                        }
                    } else if (eVar instanceof j) {
                        textView.setText(((j) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                    }
                    aj.i(textView, d.e.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.cdz;
        } else {
            view = this.cdD;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cbt != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.c.c.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (c.this.cbt != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.cbt.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new i(c.this.position), null, null));
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
