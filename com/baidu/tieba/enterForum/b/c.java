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
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter dme;
    private View dof;
    private TextView dog;
    private ImageView doh;
    private ImageView doi;
    private View doj;
    private TextView dok;
    private ImageView dol;
    private ImageView dom;
    private ImageView don;
    private ImageView doo;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dme = viewEventCenter;
        this.dof = view.findViewById(d.g.left_container);
        this.dog = (TextView) this.dof.findViewById(d.g.name);
        this.doh = (ImageView) this.dof.findViewById(d.g.sign);
        this.doi = (ImageView) this.dof.findViewById(d.g.grade);
        this.doj = view.findViewById(d.g.right_container);
        this.dok = (TextView) this.doj.findViewById(d.g.name);
        this.dol = (ImageView) this.doj.findViewById(d.g.sign);
        this.dom = (ImageView) this.doj.findViewById(d.g.grade);
        this.don = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.doo = (ImageView) view.findViewById(d.g.divide_line);
        int s = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.doi.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = s;
        }
        int s2 = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dok.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = s2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(com.baidu.tieba.enterForum.data.a aVar) {
        super.aI(aVar);
        if (aVar != null) {
            a(aVar.apt(), true);
            a(aVar.apu(), false);
            b(aVar.apt(), true);
            b(aVar.apu(), false);
            aj.t(this.don, d.C0108d.cp_bg_line_c);
            aj.t(this.doo, d.C0108d.cp_bg_line_c);
            aj.s(this.doh, d.f.icon_ba_sign_n);
            aj.s(this.dol, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dof : this.doj;
            TextView textView = z ? this.dog : this.dok;
            ImageView imageView = z ? this.doh : this.dol;
            ImageView imageView2 = z ? this.doi : this.dom;
            aj.s(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.r(textView, d.C0108d.cp_link_tip_a);
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
                        imageView.setVisibility(fVar.apz() == 0 ? 8 : 0);
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
                    aj.r(textView, d.C0108d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.dof;
        } else {
            view = this.doj;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dme != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.dme != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.dme.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
