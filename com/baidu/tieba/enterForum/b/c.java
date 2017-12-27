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
    private ViewEventCenter dhh;
    private View dji;
    private TextView djj;
    private ImageView djk;
    private ImageView djl;
    private View djm;
    private TextView djn;
    private ImageView djo;
    private ImageView djp;
    private ImageView djq;
    private ImageView djr;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dhh = viewEventCenter;
        this.dji = view.findViewById(d.g.left_container);
        this.djj = (TextView) this.dji.findViewById(d.g.name);
        this.djk = (ImageView) this.dji.findViewById(d.g.sign);
        this.djl = (ImageView) this.dji.findViewById(d.g.grade);
        this.djm = view.findViewById(d.g.right_container);
        this.djn = (TextView) this.djm.findViewById(d.g.name);
        this.djo = (ImageView) this.djm.findViewById(d.g.sign);
        this.djp = (ImageView) this.djm.findViewById(d.g.grade);
        this.djq = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.djr = (ImageView) view.findViewById(d.g.divide_line);
        int s = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.djl.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = s;
        }
        int s2 = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.djn.getLayoutParams();
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
            a(aVar.aol(), true);
            a(aVar.aom(), false);
            b(aVar.aol(), true);
            b(aVar.aom(), false);
            aj.t(this.djq, d.C0108d.cp_bg_line_c);
            aj.t(this.djr, d.C0108d.cp_bg_line_c);
            aj.s(this.djk, d.f.icon_ba_sign_n);
            aj.s(this.djo, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dji : this.djm;
            TextView textView = z ? this.djj : this.djn;
            ImageView imageView = z ? this.djk : this.djo;
            ImageView imageView2 = z ? this.djl : this.djp;
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
                        imageView.setVisibility(fVar.aor() == 0 ? 8 : 0);
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
            view = this.dji;
        } else {
            view = this.djm;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dhh != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.dhh != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.dhh.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
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
