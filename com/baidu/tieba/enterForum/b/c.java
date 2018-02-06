package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter doV;
    private View dqY;
    private TextView dqZ;
    private ImageView dra;
    private ImageView drb;
    private View drc;
    private TextView drd;
    private ImageView dre;
    private ImageView drf;
    private ImageView drg;
    private ImageView drh;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.doV = viewEventCenter;
        this.dqY = view.findViewById(d.g.left_container);
        this.dqZ = (TextView) this.dqY.findViewById(d.g.name);
        this.dra = (ImageView) this.dqY.findViewById(d.g.sign);
        this.drb = (ImageView) this.dqY.findViewById(d.g.grade);
        this.drc = view.findViewById(d.g.right_container);
        this.drd = (TextView) this.drc.findViewById(d.g.name);
        this.dre = (ImageView) this.drc.findViewById(d.g.sign);
        this.drf = (ImageView) this.drc.findViewById(d.g.grade);
        this.drg = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.drh = (ImageView) view.findViewById(d.g.divide_line);
        int t = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.drb.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = t;
        }
        int t2 = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.drd.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = t2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(com.baidu.tieba.enterForum.data.a aVar) {
        super.aI(aVar);
        if (aVar != null) {
            a(aVar.aqi(), true);
            a(aVar.aqj(), false);
            b(aVar.aqi(), true);
            b(aVar.aqj(), false);
            aj.t(this.drg, d.C0140d.cp_bg_line_c);
            aj.t(this.drh, d.C0140d.cp_bg_line_c);
            aj.s(this.dra, d.f.icon_ba_sign_n);
            aj.s(this.dre, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dqY : this.drc;
            TextView textView = z ? this.dqZ : this.drd;
            ImageView imageView = z ? this.dra : this.dre;
            ImageView imageView2 = z ? this.drb : this.drf;
            aj.s(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.r(textView, d.C0140d.cp_link_tip_a);
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
                        imageView.setVisibility(fVar.aqo() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            aj.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new ak("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new ak("c12887"));
                        }
                    }
                    aj.r(textView, d.C0140d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.dqY;
        } else {
            view = this.drc;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.doV != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.doV != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.doV.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
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
