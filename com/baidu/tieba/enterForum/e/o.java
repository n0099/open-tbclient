package com.baidu.tieba.enterForum.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private View aOe;
    private ViewEventCenter aXs;
    private TextView aZa;
    private TextView aZb;
    private TextView aZc;
    private ImageView aZd;
    private View aZe;
    private TextView aZf;
    private TextView aZg;
    private TextView aZh;
    private ImageView aZi;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aXs = viewEventCenter;
        this.aOe = view.findViewById(t.g.left_container);
        this.aZa = (TextView) this.aOe.findViewById(t.g.sign);
        this.aZb = (TextView) this.aOe.findViewById(t.g.name);
        this.aZc = (TextView) this.aOe.findViewById(t.g.grade);
        this.aZd = (ImageView) this.aOe.findViewById(t.g.add);
        this.aZe = view.findViewById(t.g.right_container);
        this.aZf = (TextView) this.aZe.findViewById(t.g.sign);
        this.aZg = (TextView) this.aZe.findViewById(t.g.name);
        this.aZh = (TextView) this.aZe.findViewById(t.g.grade);
        this.aZi = (ImageView) this.aZe.findViewById(t.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.enterForum.b.a aVar) {
        super.B(aVar);
        if (aVar != null) {
            a(aVar.Mb(), true);
            a(aVar.Mc(), false);
            b(aVar.Mb(), true);
            b(aVar.Mc(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.aOe : this.aZe;
            TextView textView = z ? this.aZa : this.aZf;
            TextView textView2 = z ? this.aZb : this.aZg;
            TextView textView3 = z ? this.aZc : this.aZh;
            ImageView imageView = z ? this.aZd : this.aZi;
            switch (wVar.getType()) {
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
                    textView2.setText(wVar.getName());
                    if (wVar.aSV() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (wVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    at.k(textView3, BitmapHelper.getGradeResourceIdNew(wVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        View view;
        if (z) {
            view = this.aOe;
        } else {
            view = this.aZe;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.aOe.setBackgroundDrawable(at.getDrawable(t.f.home_like_item_bg));
        this.aZe.setBackgroundDrawable(at.getDrawable(t.f.home_like_item_bg));
        if (getData() != null && getData().Mb() != null) {
            at.k(this.aZc, BitmapHelper.getGradeResourceIdNew(getData().Mb().getLevel()));
        }
        if (getData() != null && getData().Mc() != null) {
            at.k(this.aZh, BitmapHelper.getGradeResourceIdNew(getData().Mc().getLevel()));
            return true;
        }
        return true;
    }
}
