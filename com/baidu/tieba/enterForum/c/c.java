package com.baidu.tieba.enterForum.c;

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
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.enterForum.b.i;
import com.baidu.tieba.enterForum.b.j;
/* loaded from: classes.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cbZ;
    private View ceg;
    private TextView ceh;
    private ImageView cei;
    private ImageView cej;
    private View cek;
    private TextView cel;
    private ImageView cem;
    private ImageView cen;
    private ImageView ceo;
    private ImageView cep;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cbZ = viewEventCenter;
        this.ceg = view.findViewById(d.h.left_container);
        this.ceh = (TextView) this.ceg.findViewById(d.h.name);
        this.cei = (ImageView) this.ceg.findViewById(d.h.sign);
        this.cej = (ImageView) this.ceg.findViewById(d.h.grade);
        this.cek = view.findViewById(d.h.right_container);
        this.cel = (TextView) this.cek.findViewById(d.h.name);
        this.cem = (ImageView) this.cek.findViewById(d.h.sign);
        this.cen = (ImageView) this.cek.findViewById(d.h.grade);
        this.ceo = (ImageView) view.findViewById(d.h.divide_line_middle);
        this.cep = (ImageView) view.findViewById(d.h.divide_line);
        int f = l.f(tbPageContext.getPageActivity(), d.f.ds20);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cej.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = f;
        }
        int f2 = l.f(tbPageContext.getPageActivity(), d.f.ds32);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cel.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = f2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(com.baidu.tieba.enterForum.b.a aVar) {
        super.D(aVar);
        if (aVar != null) {
            a(aVar.acw(), true);
            a(aVar.acx(), false);
            b(aVar.acw(), true);
            b(aVar.acx(), false);
            aj.k(this.ceo, d.e.cp_bg_line_c);
            aj.k(this.cep, d.e.cp_bg_line_c);
            aj.j(this.cei, d.g.icon_sign);
            aj.j(this.cem, d.g.icon_sign);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.ceg : this.cek;
            TextView textView = z ? this.ceh : this.cel;
            ImageView imageView = z ? this.cei : this.cem;
            ImageView imageView2 = z ? this.cej : this.cen;
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
                        imageView.setVisibility(gVar.acD() == 0 ? 8 : 0);
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
            view = this.ceg;
        } else {
            view = this.cek;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.cbZ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.cbZ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.cbZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new i(c.this.position), null, null));
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
