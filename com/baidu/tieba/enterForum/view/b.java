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
import com.baidu.tieba.enterForum.data.e;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.i;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.a, com.baidu.tbadk.mvc.d.b> {
    private static final int cUw = l.f(TbadkCoreApplication.getInst(), f.e.tbds68);
    private static final int cUx = l.f(TbadkCoreApplication.getInst(), f.e.tbds44);
    private ViewEventCenter cRF;
    private View cUk;
    private TextView cUl;
    private TextView cUm;
    private ImageView cUn;
    private ImageView cUo;
    private View cUp;
    private TextView cUq;
    private TextView cUr;
    private ImageView cUs;
    private ImageView cUt;
    private ImageView cUu;
    private ImageView cUv;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cRF = viewEventCenter;
        this.cUk = view.findViewById(f.g.left_container);
        this.cUl = (TextView) this.cUk.findViewById(f.g.name);
        this.cUm = (TextView) this.cUk.findViewById(f.g.live_label);
        this.cUn = (ImageView) this.cUk.findViewById(f.g.sign);
        this.cUo = (ImageView) this.cUk.findViewById(f.g.grade);
        this.cUp = view.findViewById(f.g.right_container);
        this.cUq = (TextView) this.cUp.findViewById(f.g.name);
        this.cUr = (TextView) this.cUp.findViewById(f.g.live_label);
        this.cUs = (ImageView) this.cUp.findViewById(f.g.sign);
        this.cUt = (ImageView) this.cUp.findViewById(f.g.grade);
        this.cUu = (ImageView) view.findViewById(f.g.divide_line_middle);
        this.cUv = (ImageView) view.findViewById(f.g.divide_line);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cUo.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.rightMargin = cUx;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.cUq.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.leftMargin = cUx;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void G(com.baidu.tieba.enterForum.data.a aVar) {
        super.G(aVar);
        if (aVar != null) {
            a(aVar.aoq(), true);
            a(aVar.aor(), false);
            b(aVar.aoq(), true);
            b(aVar.aor(), false);
            am.j(this.cUu, f.d.cp_bg_line_c);
            am.j(this.cUv, f.d.cp_bg_line_c);
            am.i(this.cUn, f.C0146f.icon_ba_sign_n);
            am.i(this.cUs, f.C0146f.icon_ba_sign_n);
        }
    }

    private void a(e eVar, boolean z) {
        if (eVar != null) {
            View view = z ? this.cUk : this.cUp;
            TextView textView = z ? this.cUl : this.cUq;
            ImageView imageView = z ? this.cUn : this.cUs;
            ImageView imageView2 = z ? this.cUo : this.cUt;
            TextView textView2 = z ? this.cUm : this.cUr;
            am.i(view, f.C0146f.forum_item_bg);
            switch (eVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    textView.setText(f.j.default_personalized_name);
                    textView.setVisibility(0);
                    imageView.setVisibility(8);
                    imageView2.setVisibility(8);
                    am.h(textView, f.d.cp_link_tip_a);
                    break;
                case 2:
                    view.setVisibility(4);
                    break;
                default:
                    view.setVisibility(0);
                    textView.setVisibility(0);
                    if (eVar instanceof com.baidu.tieba.enterForum.data.f) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) eVar;
                        textView.setText(fVar.getName());
                        imageView.setVisibility(fVar.aow() == 0 ? 8 : 0);
                        if (fVar.getLevel() == 0) {
                            imageView2.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            am.c(imageView2, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                        }
                        if (fVar.aox() == 1) {
                            textView2.setVisibility(0);
                            textView2.setText(f.j.brand_label_text);
                            am.i(textView2, f.C0146f.enter_forum_brand_label_bg_shape);
                            am.h(textView2, f.d.cp_cont_i);
                        } else {
                            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                            if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                                textView2.setVisibility(0);
                                textView2.setText(f.j.live_label_text);
                                am.i(textView2, f.C0146f.enter_forum_live_label_bg_shape);
                                am.h(textView2, f.d.cp_cont_g);
                            } else {
                                textView2.setVisibility(8);
                            }
                        }
                        if (getResources().getString(f.j.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                            TiebaStatic.log(new an("c12887"));
                        }
                    } else if (eVar instanceof i) {
                        textView.setText(((i) eVar).getForumName());
                        imageView.setVisibility(8);
                        imageView2.setVisibility(8);
                        if (((Boolean) MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(((i) eVar).getForumId())).getData()).booleanValue()) {
                            textView2.setVisibility(0);
                            am.i(textView2, f.C0146f.enter_forum_live_label_bg_shape);
                            am.h(textView2, f.d.cp_cont_g);
                        } else {
                            textView2.setVisibility(8);
                        }
                        if (getResources().getString(f.j.ala_follow_live_enter_live_square_txt).equals(((i) eVar).getForumName())) {
                            TiebaStatic.log(new an("c12887"));
                        }
                    }
                    am.h(textView, f.d.cp_cont_b);
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
                        textView.setMaxWidth(measuredWidth - (z ? b.cUw : b.cUw + b.cUx));
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
            view = this.cUk;
        } else {
            view = this.cUp;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.cRF != null) {
                    switch (eVar.getType()) {
                        case 0:
                            b.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, eVar, null, null));
                            return;
                        case 1:
                            b.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
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
                if (b.this.cRF != null) {
                    switch (eVar.getType()) {
                        case 0:
                            return b.this.cRF.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new h(b.this.position), null, null));
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
