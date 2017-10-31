package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cjC;
    private TextView clA;
    private ImageView clB;
    private ImageView clC;
    private View clD;
    private TextView clE;
    private ImageView clF;
    private ImageView clG;
    private ImageView clH;
    private ImageView clI;
    private View clz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cjC = viewEventCenter;
        this.clz = view.findViewById(d.g.left_container);
        this.clA = (TextView) this.clz.findViewById(d.g.name);
        this.clB = (ImageView) this.clz.findViewById(d.g.sign);
        this.clC = (ImageView) this.clz.findViewById(d.g.grade);
        this.clD = view.findViewById(d.g.right_container);
        this.clE = (TextView) this.clD.findViewById(d.g.name);
        this.clF = (ImageView) this.clD.findViewById(d.g.sign);
        this.clG = (ImageView) this.clD.findViewById(d.g.grade);
        this.clH = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.clI = (ImageView) view.findViewById(d.g.divide_line);
        int f = l.f(tbPageContext.getPageActivity(), d.e.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.clC.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = f;
        }
        int f2 = l.f(tbPageContext.getPageActivity(), d.e.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.clE.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = f2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(com.baidu.tieba.enterForum.data.a aVar) {
        super.D(aVar);
        if (aVar != null) {
            a(aVar.aeF(), true);
            a(aVar.aeG(), false);
            b(aVar.aeF(), true);
            b(aVar.aeG(), false);
            aj.k(this.clH, d.C0080d.cp_bg_line_c);
            aj.k(this.clI, d.C0080d.cp_bg_line_c);
            aj.j(this.clB, d.f.icon_sign);
            aj.j(this.clF, d.f.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.clz : this.clD;
            TextView textView = z ? this.clA : this.clE;
            ImageView imageView = z ? this.clB : this.clF;
            ImageView imageView2 = z ? this.clC : this.clG;
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.i(textView, d.C0080d.cp_link_tip_a);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof com.baidu.tieba.enterForum.data.f) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) eVar;
                        textView.setText(fVar.getName());
                        imageView.setVisibility(fVar.aeL() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            aj.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                    }
                    aj.i(textView, d.C0080d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.clz;
        } else {
            view = this.clD;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cjC != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.b.c.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (c.this.cjC != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.cjC.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
