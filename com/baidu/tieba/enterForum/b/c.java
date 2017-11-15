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
    private ViewEventCenter cjP;
    private View clS;
    private TextView clT;
    private ImageView clU;
    private ImageView clV;
    private View clW;
    private TextView clX;
    private ImageView clY;
    private ImageView clZ;
    private ImageView cma;
    private ImageView cmb;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cjP = viewEventCenter;
        this.clS = view.findViewById(d.g.left_container);
        this.clT = (TextView) this.clS.findViewById(d.g.name);
        this.clU = (ImageView) this.clS.findViewById(d.g.sign);
        this.clV = (ImageView) this.clS.findViewById(d.g.grade);
        this.clW = view.findViewById(d.g.right_container);
        this.clX = (TextView) this.clW.findViewById(d.g.name);
        this.clY = (ImageView) this.clW.findViewById(d.g.sign);
        this.clZ = (ImageView) this.clW.findViewById(d.g.grade);
        this.cma = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.cmb = (ImageView) view.findViewById(d.g.divide_line);
        int f = l.f(tbPageContext.getPageActivity(), d.e.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.clV.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = f;
        }
        int f2 = l.f(tbPageContext.getPageActivity(), d.e.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.clX.getLayoutParams();
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
            a(aVar.aeR(), true);
            a(aVar.aeS(), false);
            b(aVar.aeR(), true);
            b(aVar.aeS(), false);
            aj.k(this.cma, d.C0080d.cp_bg_line_c);
            aj.k(this.cmb, d.C0080d.cp_bg_line_c);
            aj.j(this.clU, d.f.icon_sign);
            aj.j(this.clY, d.f.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.clS : this.clW;
            TextView textView = z ? this.clT : this.clX;
            ImageView imageView = z ? this.clU : this.clY;
            ImageView imageView2 = z ? this.clV : this.clZ;
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
                        imageView.setVisibility(fVar.aeX() == 0 ? 8 : 0);
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
            view = this.clS;
        } else {
            view = this.clW;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cjP != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.cjP != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.cjP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
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
