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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private static final int cRN = l.e(TbadkCoreApplication.getInst(), d.e.tbds68);
    private static final int cRO = l.e(TbadkCoreApplication.getInst(), d.e.tbds44);
    private ViewEventCenter cOZ;
    private View cRB;
    private TextView cRC;
    private TextView cRD;
    private ImageView cRE;
    private ImageView cRF;
    private View cRG;
    private TextView cRH;
    private TextView cRI;
    private ImageView cRJ;
    private ImageView cRK;
    private ImageView cRL;
    private ImageView cRM;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cOZ = viewEventCenter;
        this.cRB = view.findViewById(d.g.left_container);
        this.cRC = (TextView) this.cRB.findViewById(d.g.name);
        this.cRD = (TextView) this.cRB.findViewById(d.g.live_label);
        this.cRE = (ImageView) this.cRB.findViewById(d.g.sign);
        this.cRF = (ImageView) this.cRB.findViewById(d.g.grade);
        this.cRG = view.findViewById(d.g.right_container);
        this.cRH = (TextView) this.cRG.findViewById(d.g.name);
        this.cRI = (TextView) this.cRG.findViewById(d.g.live_label);
        this.cRJ = (ImageView) this.cRG.findViewById(d.g.sign);
        this.cRK = (ImageView) this.cRG.findViewById(d.g.grade);
        this.cRL = (ImageView) view.findViewById(d.g.divide_line_middle);
        this.cRM = (ImageView) view.findViewById(d.g.divide_line);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cRF.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = cRO;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cRH.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = cRO;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.enterForum.data.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            a(aVar.anR(), true);
            a(aVar.anS(), false);
            b(aVar.anR(), true);
            b(aVar.anS(), false);
            am.j(this.cRL, d.C0142d.cp_bg_line_c);
            am.j(this.cRM, d.C0142d.cp_bg_line_c);
            am.i(this.cRE, d.f.icon_ba_sign_n);
            am.i(this.cRJ, d.f.icon_ba_sign_n);
        }
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.cRB : this.cRG;
            TextView textView = z ? this.cRC : this.cRH;
            ImageView imageView = z ? this.cRE : this.cRJ;
            ImageView imageView2 = z ? this.cRF : this.cRK;
            TextView textView2 = z ? this.cRD : this.cRI;
            am.i(view, d.f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(d.k.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    am.h(textView, d.C0142d.cp_link_tip_a);
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
                        imageView.setVisibility(fVar.anX() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            am.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        if (fVar.anY() == 1) {
                            textView2.setVisibility(0);
                            textView2.setText(d.k.brand_label_text);
                            am.i(textView2, d.f.enter_forum_brand_label_bg_shape);
                            am.h(textView2, d.C0142d.cp_cont_i);
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                            if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                                textView2.setVisibility(0);
                                textView2.setText(d.k.live_label_text);
                                am.i(textView2, d.f.enter_forum_live_label_bg_shape);
                                am.h(textView2, d.C0142d.cp_cont_g);
                            } else {
                                textView2.setVisibility(8);
                            }
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new an("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (((Boolean) MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(((i) eVar).getForumId())).getData()).booleanValue()) {
                            textView2.setVisibility(0);
                            am.i(textView2, d.f.enter_forum_live_label_bg_shape);
                            am.h(textView2, d.C0142d.cp_cont_g);
                        } else {
                            textView2.setVisibility(8);
                        }
                        if (getResources().getString(d.k.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new an("c12887"));
                        }
                    }
                    am.h(textView, d.C0142d.cp_cont_b);
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
                        textView.setMaxWidth(measuredWidth - (z ? b.cRN : b.cRN + b.cRO));
                        textView.postInvalidate();
                        textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    private void b(final e eVar, boolean z) {
        View view;
        if (z) {
            view = this.cRB;
        } else {
            view = this.cRG;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cOZ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            b.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            b.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (b.this.cOZ != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return b.this.cOZ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(b.this.position), null, null));
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
