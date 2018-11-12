package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes4.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private static final int djH = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds68);
    private static final int djI = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds44);
    private ViewEventCenter dgT;
    private View djA;
    private TextView djB;
    private TextView djC;
    private ImageView djD;
    private ImageView djE;
    private ImageView djF;
    private ImageView djG;
    private View djv;
    private TextView djw;
    private TextView djx;
    private ImageView djy;
    private ImageView djz;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dgT = viewEventCenter;
        this.djv = view.findViewById(e.g.left_container);
        this.djw = (TextView) this.djv.findViewById(e.g.name);
        this.djx = (TextView) this.djv.findViewById(e.g.live_label);
        this.djy = (ImageView) this.djv.findViewById(e.g.sign);
        this.djz = (ImageView) this.djv.findViewById(e.g.grade);
        this.djA = view.findViewById(e.g.right_container);
        this.djB = (TextView) this.djA.findViewById(e.g.name);
        this.djC = (TextView) this.djA.findViewById(e.g.live_label);
        this.djD = (ImageView) this.djA.findViewById(e.g.sign);
        this.djE = (ImageView) this.djA.findViewById(e.g.grade);
        this.djF = (ImageView) view.findViewById(e.g.divide_line_middle);
        this.djG = (ImageView) view.findViewById(e.g.divide_line);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.djz.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = djI;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.djB.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = djI;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(com.baidu.tieba.enterForum.data.a aVar) {
        super.L(aVar);
        if (aVar != null) {
            a(aVar.atb(), true);
            a(aVar.atc(), false);
            b(aVar.atb(), true);
            b(aVar.atc(), false);
            al.j(this.djF, e.d.cp_bg_line_c);
            al.j(this.djG, e.d.cp_bg_line_c);
            al.i(this.djy, e.f.icon_ba_sign_n);
            al.i(this.djD, e.f.icon_ba_sign_n);
        }
    }

    private void a(com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.djv : this.djA;
            TextView textView = z ? this.djw : this.djB;
            ImageView imageView = z ? this.djy : this.djD;
            ImageView imageView2 = z ? this.djz : this.djE;
            TextView textView2 = z ? this.djx : this.djC;
            al.i(view, e.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(e.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    al.h(textView, e.d.cp_link_tip_a);
                    break;
                case 2:
                    view.setVisibility(4);
                    break;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof f) {
                        f fVar = (f) eVar;
                        textView.setText(fVar.getName());
                        imageView.setVisibility(fVar.ath() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            al.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        if (fVar.ati() == 1) {
                            textView2.setVisibility(0);
                            textView2.setText(e.j.brand_label_text);
                            al.i(textView2, e.f.enter_forum_brand_label_bg_shape);
                            al.h(textView2, e.d.cp_cont_i);
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.d(fVar.getId(), 0L)));
                            if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                                textView2.setVisibility(0);
                                textView2.setText(e.j.live_label_text);
                                al.i(textView2, e.f.enter_forum_live_label_bg_shape);
                                al.h(textView2, e.d.cp_cont_g);
                            } else {
                                textView2.setVisibility(8);
                            }
                        }
                        if (getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new am("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (((Boolean) MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(((i) eVar).getForumId())).getData()).booleanValue()) {
                            textView2.setVisibility(0);
                            al.i(textView2, e.f.enter_forum_live_label_bg_shape);
                            al.h(textView2, e.d.cp_cont_g);
                        } else {
                            textView2.setVisibility(8);
                        }
                        if (getResources().getString(e.j.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new am("c12887"));
                        }
                    }
                    al.h(textView, e.d.cp_cont_b);
                    break;
            }
            b(textView, z);
        }
    }

    private void b(final TextView textView, final boolean z) {
        if (textView != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.enterForum.view.b.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int measuredWidth;
                    if ((textView.getParent() instanceof ViewGroup) && (measuredWidth = ((ViewGroup) textView.getParent()).getMeasuredWidth()) != 0) {
                        textView.setMaxWidth(measuredWidth - (z ? b.djH : b.djH + b.djI));
                        textView.postInvalidate();
                        textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.e eVar, boolean z) {
        View view;
        if (z) {
            view = this.djv;
        } else {
            view = this.djA;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.dgT != null) {
                    switch (eVar.getType()) {
                        case 0:
                            b.this.dgT.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            b.this.dgT.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                if (b.this.dgT != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return b.this.dgT.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(b.this.position), null, null));
                    }
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.o.a.a(tbPageContext, getRootView());
        return true;
    }
}
