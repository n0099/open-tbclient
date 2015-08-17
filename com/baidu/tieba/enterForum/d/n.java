package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class n extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aMt;
    private View aNM;
    private TextView aNN;
    private TextView aNO;
    private TextView aNP;
    private ImageView aNQ;
    private View aNR;
    private TextView aNS;
    private TextView aNT;
    private TextView aNU;
    private ImageView aNV;

    public n(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aMt = viewEventCenter;
        this.aNM = view.findViewById(i.f.left_container);
        this.aNN = (TextView) this.aNM.findViewById(i.f.sign);
        this.aNO = (TextView) this.aNM.findViewById(i.f.name);
        this.aNP = (TextView) this.aNM.findViewById(i.f.grade);
        this.aNQ = (ImageView) this.aNM.findViewById(i.f.add);
        this.aNR = view.findViewById(i.f.right_container);
        this.aNS = (TextView) this.aNR.findViewById(i.f.sign);
        this.aNT = (TextView) this.aNR.findViewById(i.f.name);
        this.aNU = (TextView) this.aNR.findViewById(i.f.grade);
        this.aNV = (ImageView) this.aNR.findViewById(i.f.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.enterForum.b.a aVar) {
        super.A(aVar);
        if (aVar != null) {
            a(aVar.Im(), true);
            a(aVar.In(), false);
            b(aVar.Im(), true);
            b(aVar.In(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        if (uVar != null) {
            View view = z ? this.aNM : this.aNR;
            TextView textView = z ? this.aNN : this.aNS;
            TextView textView2 = z ? this.aNO : this.aNT;
            TextView textView3 = z ? this.aNP : this.aNU;
            ImageView imageView = z ? this.aNQ : this.aNV;
            switch (uVar.getType()) {
                case 1:
                    view.setVisibility(0);
                    imageView.setVisibility(0);
                    textView2.setVisibility(8);
                    textView.setVisibility(8);
                    textView3.setVisibility(8);
                    return;
                case 2:
                    view.setVisibility(4);
                    return;
                default:
                    view.setVisibility(0);
                    imageView.setVisibility(8);
                    textView2.setVisibility(0);
                    textView2.setText(uVar.getName());
                    if (uVar.app() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (uVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    al.i((View) textView3, com.baidu.tbadk.core.util.c.cb(uVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        View view;
        if (z) {
            view = this.aNM;
        } else {
            view = this.aNR;
        }
        view.setOnClickListener(new o(this, uVar));
        view.setOnLongClickListener(new p(this));
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        this.aNM.setBackgroundDrawable(al.getDrawable(i.e.home_like_item_bg));
        this.aNR.setBackgroundDrawable(al.getDrawable(i.e.home_like_item_bg));
        if (this.aNP.getVisibility() == 0 && getData() != null && getData().Im() != null) {
            al.i((View) this.aNP, com.baidu.tbadk.core.util.c.cb(getData().Im().getLevel()));
        }
        if (this.aNU.getVisibility() == 0 && getData() != null && getData().In() != null) {
            al.i((View) this.aNU, com.baidu.tbadk.core.util.c.cb(getData().In().getLevel()));
            return true;
        }
        return true;
    }
}
