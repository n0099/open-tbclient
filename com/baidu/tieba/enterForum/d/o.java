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
    private ViewEventCenter aLM;
    private View aNf;
    private TextView aNg;
    private TextView aNh;
    private TextView aNi;
    private ImageView aNj;
    private View aNk;
    private TextView aNl;
    private TextView aNm;
    private TextView aNn;
    private ImageView aNo;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLM = viewEventCenter;
        this.aNf = view.findViewById(i.f.left_container);
        this.aNg = (TextView) this.aNf.findViewById(i.f.sign);
        this.aNh = (TextView) this.aNf.findViewById(i.f.name);
        this.aNi = (TextView) this.aNf.findViewById(i.f.grade);
        this.aNj = (ImageView) this.aNf.findViewById(i.f.add);
        this.aNk = view.findViewById(i.f.right_container);
        this.aNl = (TextView) this.aNk.findViewById(i.f.sign);
        this.aNm = (TextView) this.aNk.findViewById(i.f.name);
        this.aNn = (TextView) this.aNk.findViewById(i.f.grade);
        this.aNo = (ImageView) this.aNk.findViewById(i.f.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.HU(), true);
            a(aVar.HV(), false);
            b(aVar.HU(), true);
            b(aVar.HV(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        if (vVar != null) {
            View view = z ? this.aNf : this.aNk;
            TextView textView = z ? this.aNg : this.aNl;
            TextView textView2 = z ? this.aNh : this.aNm;
            TextView textView3 = z ? this.aNi : this.aNn;
            ImageView imageView = z ? this.aNj : this.aNo;
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
                    if (vVar.awa() == 0) {
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
            view = this.aNf;
        } else {
            view = this.aNk;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        this.aNf.setBackgroundDrawable(an.getDrawable(i.e.home_like_item_bg));
        this.aNk.setBackgroundDrawable(an.getDrawable(i.e.home_like_item_bg));
        if (this.aNi.getVisibility() == 0 && getData() != null && getData().HU() != null) {
            an.i((View) this.aNi, com.baidu.tbadk.core.util.c.ch(getData().HU().getLevel()));
        }
        if (this.aNn.getVisibility() == 0 && getData() != null && getData().HV() != null) {
            an.i((View) this.aNn, com.baidu.tbadk.core.util.c.ch(getData().HV().getLevel()));
            return true;
        }
        return true;
    }
}
