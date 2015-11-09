package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLU;
    private View aNn;
    private TextView aNo;
    private TextView aNp;
    private TextView aNq;
    private ImageView aNr;
    private View aNs;
    private TextView aNt;
    private TextView aNu;
    private TextView aNv;
    private ImageView aNw;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLU = viewEventCenter;
        this.aNn = view.findViewById(i.f.left_container);
        this.aNo = (TextView) this.aNn.findViewById(i.f.sign);
        this.aNp = (TextView) this.aNn.findViewById(i.f.name);
        this.aNq = (TextView) this.aNn.findViewById(i.f.grade);
        this.aNr = (ImageView) this.aNn.findViewById(i.f.add);
        this.aNs = view.findViewById(i.f.right_container);
        this.aNt = (TextView) this.aNs.findViewById(i.f.sign);
        this.aNu = (TextView) this.aNs.findViewById(i.f.name);
        this.aNv = (TextView) this.aNs.findViewById(i.f.grade);
        this.aNw = (ImageView) this.aNs.findViewById(i.f.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.Ig(), true);
            a(aVar.Ih(), false);
            b(aVar.Ig(), true);
            b(aVar.Ih(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.aNn : this.aNs;
            TextView textView = z ? this.aNo : this.aNt;
            TextView textView2 = z ? this.aNp : this.aNu;
            TextView textView3 = z ? this.aNq : this.aNv;
            ImageView imageView = z ? this.aNr : this.aNw;
            switch (vVar.getType()) {
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
                    textView2.setText(vVar.getName());
                    if (vVar.awE() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (vVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    an.i((View) textView3, com.baidu.tbadk.core.util.c.ch(vVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        View view;
        if (z) {
            view = this.aNn;
        } else {
            view = this.aNs;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        this.aNn.setBackgroundDrawable(an.getDrawable(i.e.home_like_item_bg));
        this.aNs.setBackgroundDrawable(an.getDrawable(i.e.home_like_item_bg));
        if (this.aNq.getVisibility() == 0 && getData() != null && getData().Ig() != null) {
            an.i((View) this.aNq, com.baidu.tbadk.core.util.c.ch(getData().Ig().getLevel()));
        }
        if (this.aNv.getVisibility() == 0 && getData() != null && getData().Ih() != null) {
            an.i((View) this.aNv, com.baidu.tbadk.core.util.c.ch(getData().Ih().getLevel()));
            return true;
        }
        return true;
    }
}
