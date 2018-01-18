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
    private ViewEventCenter dlJ;
    private View dnJ;
    private TextView dnK;
    private ImageView dnL;
    private ImageView dnM;
    private View dnN;
    private TextView dnO;
    private ImageView dnP;
    private ImageView dnQ;
    private ImageView dnR;
    private ImageView dnS;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dlJ = viewEventCenter;
        this.dnJ = view.findViewById(d.g.left_container);
        this.dnK = (TextView) this.dnJ.findViewById(d.g.name);
        this.dnL = (ImageView) this.dnJ.findViewById(d.g.sign);
        this.dnM = (ImageView) this.dnJ.findViewById(d.g.grade);
        this.dnN = view.findViewById(d.g.right_container);
        this.dnO = (TextView) this.dnN.findViewById(d.g.name);
        this.dnP = (ImageView) this.dnN.findViewById(d.g.sign);
        this.dnQ = (ImageView) this.dnN.findViewById(d.g.grade);
        this.dnR = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.dnS = (ImageView) view.findViewById(d.g.divide_line);
        int s = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dnM.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = s;
        }
        int s2 = l.s(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dnO.getLayoutParams();
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
            a(aVar.apo(), true);
            a(aVar.app(), false);
            b(aVar.apo(), true);
            b(aVar.app(), false);
            aj.t(this.dnR, d.C0107d.cp_bg_line_c);
            aj.t(this.dnS, d.C0107d.cp_bg_line_c);
            aj.s(this.dnL, d.f.icon_ba_sign_n);
            aj.s(this.dnP, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dnJ : this.dnN;
            TextView textView = z ? this.dnK : this.dnO;
            ImageView imageView = z ? this.dnL : this.dnP;
            ImageView imageView2 = z ? this.dnM : this.dnQ;
            aj.s(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.r(textView, d.C0107d.cp_link_tip_a);
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
                        imageView.setVisibility(fVar.apu() == 0 ? 8 : 0);
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
                    aj.r(textView, d.C0107d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.dnJ;
        } else {
            view = this.dnN;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.dlJ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.dlJ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.dlJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
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
