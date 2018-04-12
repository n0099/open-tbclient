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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter cGR;
    private View cJA;
    private ImageView cJB;
    private ImageView cJC;
    private ImageView cJD;
    private ImageView cJE;
    private View cJr;
    private TextView cJs;
    private TextView cJt;
    private View cJu;
    private ImageView cJv;
    private ImageView cJw;
    private View cJx;
    private TextView cJy;
    private TextView cJz;

    public b(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.cGR = viewEventCenter;
        this.cJr = view2.findViewById(d.g.left_container);
        this.cJs = (TextView) this.cJr.findViewById(d.g.name);
        this.cJt = (TextView) this.cJr.findViewById(d.g.live_label);
        this.cJu = this.cJr.findViewById(d.g.live_divider);
        this.cJv = (ImageView) this.cJr.findViewById(d.g.sign);
        this.cJw = (ImageView) this.cJr.findViewById(d.g.grade);
        this.cJx = view2.findViewById(d.g.right_container);
        this.cJy = (TextView) this.cJx.findViewById(d.g.name);
        this.cJz = (TextView) this.cJx.findViewById(d.g.live_label);
        this.cJA = this.cJx.findViewById(d.g.live_divider);
        this.cJB = (ImageView) this.cJx.findViewById(d.g.sign);
        this.cJC = (ImageView) this.cJx.findViewById(d.g.grade);
        this.cJD = (ImageView) view2.findViewById(d.g.divide_line_middle);
        this.cJE = (ImageView) view2.findViewById(d.g.divide_line);
        int e = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cJw.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = e;
        }
        int e2 = l.e(tbPageContext.getPageActivity(), d.e.tbds44);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cJy.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = e2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(com.baidu.tieba.enterForum.data.a aVar) {
        super.D(aVar);
        if (aVar != null) {
            a(aVar.akr(), true);
            a(aVar.aks(), false);
            b(aVar.akr(), true);
            b(aVar.aks(), false);
            ak.j(this.cJD, d.C0126d.cp_bg_line_c);
            ak.j(this.cJE, d.C0126d.cp_bg_line_c);
            ak.i(this.cJv, d.f.icon_ba_sign_n);
            ak.i(this.cJB, d.f.icon_ba_sign_n);
        }
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            View view2 = z ? this.cJr : this.cJx;
            TextView textView = z ? this.cJs : this.cJy;
            ImageView imageView = z ? this.cJv : this.cJB;
            ImageView imageView2 = z ? this.cJw : this.cJC;
            TextView textView2 = z ? this.cJt : this.cJz;
            View view3 = z ? this.cJu : this.cJA;
            ak.i(view2, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view2.setVisibility(0);
                    textView.setText(d.k.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    ak.h(textView, d.C0126d.cp_link_tip_a);
                    return;
                case 2:
                    view2.setVisibility(4);
                    return;
                default:
                    view2.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof f) {
                        f fVar = (f) eVar;
                        textView.setText(fVar.getName());
                        imageView.setVisibility(fVar.akx() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            ak.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                        if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                            textView2.setVisibility(0);
                            view3.setVisibility(0);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams.weight = 0.0f;
                            textView.setLayoutParams(layoutParams);
                            ak.i(textView2, d.f.enter_forum_live_label_bg_shape);
                            ak.h(textView2, d.C0126d.cp_cont_g);
                        } else {
                            textView2.setVisibility(8);
                            view3.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams2.weight = 1.0f;
                            textView.setLayoutParams(layoutParams2);
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new al("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (((Boolean) MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(((i) eVar).getForumId())).getData()).booleanValue()) {
                            view3.setVisibility(0);
                            textView2.setVisibility(0);
                            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams3.weight = 0.0f;
                            textView.setLayoutParams(layoutParams3);
                            ak.i(textView2, d.f.enter_forum_live_label_bg_shape);
                            ak.h(textView2, d.C0126d.cp_cont_g);
                        } else {
                            view3.setVisibility(8);
                            textView2.setVisibility(8);
                            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                            layoutParams4.weight = 1.0f;
                            textView.setLayoutParams(layoutParams4);
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new al("c12887"));
                        }
                    }
                    ak.h(textView, d.C0126d.cp_cont_b);
                    return;
            }
        }
    }

    private void b(final e eVar, boolean z) {
        View view2;
        if (z) {
            view2 = this.cJr;
        } else {
            view2 = this.cJx;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (b.this.cGR != null) {
                    switch (eVar.getType()) {
                        case 0:
                            b.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            b.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        view2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.b.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view3) {
                if (b.this.cGR != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return b.this.cGR.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(b.this.position), null, null));
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
