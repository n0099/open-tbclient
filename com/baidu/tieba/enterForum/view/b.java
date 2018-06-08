package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cRe;
    private View cTD;
    private TextView cTE;
    private TextView cTF;
    private View cTG;
    private ImageView cTH;
    private ImageView cTI;
    private View cTJ;
    private TextView cTK;
    private TextView cTL;
    private View cTM;
    private ImageView cTN;
    private ImageView cTO;
    private ImageView cTP;
    private ImageView cTQ;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cRe = viewEventCenter;
        this.cTD = view.findViewById(d.g.left_container);
        this.cTE = (TextView) this.cTD.findViewById(d.g.name);
        this.cTF = (TextView) this.cTD.findViewById(d.g.live_label);
        this.cTG = this.cTD.findViewById(d.g.live_divider);
        this.cTH = (ImageView) this.cTD.findViewById(d.g.sign);
        this.cTI = (ImageView) this.cTD.findViewById(d.g.grade);
        this.cTJ = view.findViewById(d.g.right_container);
        this.cTK = (TextView) this.cTJ.findViewById(d.g.name);
        this.cTL = (TextView) this.cTJ.findViewById(d.g.live_label);
        this.cTM = this.cTJ.findViewById(d.g.live_divider);
        this.cTN = (ImageView) this.cTJ.findViewById(d.g.sign);
        this.cTO = (ImageView) this.cTJ.findViewById(d.g.grade);
        this.cTP = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.cTQ = (ImageView) view.findViewById(d.g.divide_line);
        int e = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cTI.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = e;
        }
        int e2 = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cTK.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.enterForum.data.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            a(aVar.aox(), true);
            a(aVar.aoy(), false);
            b(aVar.aox(), true);
            b(aVar.aoy(), false);
            al.j(this.cTP, d.C0141d.cp_bg_line_c);
            al.j(this.cTQ, d.C0141d.cp_bg_line_c);
            al.i(this.cTH, d.f.icon_ba_sign_n);
            al.i(this.cTN, d.f.icon_ba_sign_n);
        }
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.cTD : this.cTJ;
            TextView textView = z ? this.cTE : this.cTK;
            ImageView imageView = z ? this.cTH : this.cTN;
            ImageView imageView2 = z ? this.cTI : this.cTO;
            TextView textView2 = z ? this.cTF : this.cTL;
            View view2 = z ? this.cTG : this.cTM;
            al.i(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.k.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    al.h(textView, d.C0141d.cp_link_tip_a);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof f) {
                        f fVar = (f) eVar;
                        textView.setText(fVar.getName());
                        imageView.setVisibility(fVar.aoD() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            al.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                        if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                            textView2.setVisibility(0);
                            view2.setVisibility(0);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams.weight = 0.0f;
                            textView.setLayoutParams(layoutParams);
                            al.i(textView2, d.f.enter_forum_live_label_bg_shape);
                            al.h(textView2, d.C0141d.cp_cont_g);
                        } else {
                            textView2.setVisibility(8);
                            view2.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams2.weight = 1.0f;
                            textView.setLayoutParams(layoutParams2);
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new am("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (((Boolean) MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(((i) eVar).getForumId())).getData()).booleanValue()) {
                            view2.setVisibility(0);
                            textView2.setVisibility(0);
                            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams3.weight = 0.0f;
                            textView.setLayoutParams(layoutParams3);
                            al.i(textView2, d.f.enter_forum_live_label_bg_shape);
                            al.h(textView2, d.C0141d.cp_cont_g);
                        } else {
                            view2.setVisibility(8);
                            textView2.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams4.weight = 1.0f;
                            textView.setLayoutParams(layoutParams4);
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new am("c12887"));
                        }
                    }
                    al.h(textView, d.C0141d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final e eVar, boolean z) {
        View view;
        if (z) {
            view = this.cTD;
        } else {
            view = this.cTJ;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cRe != null) {
                    switch (eVar.getType()) {
                        case 0:
                            b.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            b.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.b.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (b.this.cRe != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return b.this.cRe.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(b.this.position), null, null));
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
