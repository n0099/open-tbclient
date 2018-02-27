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
    private ViewEventCenter doJ;
    private View dqM;
    private TextView dqN;
    private ImageView dqO;
    private ImageView dqP;
    private View dqQ;
    private TextView dqR;
    private ImageView dqS;
    private ImageView dqT;
    private ImageView dqU;
    private ImageView dqV;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.doJ = viewEventCenter;
        this.dqM = view.findViewById(d.g.left_container);
        this.dqN = (TextView) this.dqM.findViewById(d.g.name);
        this.dqO = (ImageView) this.dqM.findViewById(d.g.sign);
        this.dqP = (ImageView) this.dqM.findViewById(d.g.grade);
        this.dqQ = view.findViewById(d.g.right_container);
        this.dqR = (TextView) this.dqQ.findViewById(d.g.name);
        this.dqS = (ImageView) this.dqQ.findViewById(d.g.sign);
        this.dqT = (ImageView) this.dqQ.findViewById(d.g.grade);
        this.dqU = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.dqV = (ImageView) view.findViewById(d.g.divide_line);
        int t = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dqP.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = t;
        }
        int t2 = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dqR.getLayoutParams();
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
            a(aVar.aqh(), true);
            a(aVar.aqi(), false);
            b(aVar.aqh(), true);
            b(aVar.aqi(), false);
            aj.t(this.dqU, d.C0141d.cp_bg_line_c);
            aj.t(this.dqV, d.C0141d.cp_bg_line_c);
            aj.s(this.dqO, d.f.icon_ba_sign_n);
            aj.s(this.dqS, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dqM : this.dqQ;
            TextView textView = z ? this.dqN : this.dqR;
            ImageView imageView = z ? this.dqO : this.dqS;
            ImageView imageView2 = z ? this.dqP : this.dqT;
            aj.s(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    aj.r(textView, d.C0141d.cp_link_tip_a);
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
                        imageView.setVisibility(fVar.aqn() == 0 ? 8 : 0);
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
                    aj.r(textView, d.C0141d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.dqM;
        } else {
            view = this.dqQ;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.doJ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.doJ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.doJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
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
