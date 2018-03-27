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
    private ViewEventCenter doM;
    private View dqP;
    private TextView dqQ;
    private ImageView dqR;
    private ImageView dqS;
    private View dqT;
    private TextView dqU;
    private ImageView dqV;
    private ImageView dqW;
    private ImageView dqX;
    private ImageView dqY;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.doM = viewEventCenter;
        this.dqP = view.findViewById(d.g.left_container);
        this.dqQ = (TextView) this.dqP.findViewById(d.g.name);
        this.dqR = (ImageView) this.dqP.findViewById(d.g.sign);
        this.dqS = (ImageView) this.dqP.findViewById(d.g.grade);
        this.dqT = view.findViewById(d.g.right_container);
        this.dqU = (TextView) this.dqT.findViewById(d.g.name);
        this.dqV = (ImageView) this.dqT.findViewById(d.g.sign);
        this.dqW = (ImageView) this.dqT.findViewById(d.g.grade);
        this.dqX = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.dqY = (ImageView) view.findViewById(d.g.divide_line);
        int t = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dqS.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = t;
        }
        int t2 = l.t(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dqU.getLayoutParams();
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
            aj.t(this.dqX, d.C0141d.cp_bg_line_c);
            aj.t(this.dqY, d.C0141d.cp_bg_line_c);
            aj.s(this.dqR, d.f.icon_ba_sign_n);
            aj.s(this.dqV, d.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.dqP : this.dqT;
            TextView textView = z ? this.dqQ : this.dqU;
            ImageView imageView = z ? this.dqR : this.dqV;
            ImageView imageView2 = z ? this.dqS : this.dqW;
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
                    aj.r(textView, d.C0141d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.dqP;
        } else {
            view = this.dqT;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.doM != null) {
                    switch (eVar.getType()) {
                        case 0:
                            c.this.doM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            c.this.doM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (c.this.doM != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return c.this.doM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(c.this.position), null, null));
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.n.a.a(tbPageContext, getRootView());
        return true;
    }
}
