package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aRS;
    private View bLp;
    private TextView bLq;
    private TextView bLr;
    private TextView bLs;
    private ImageView bLt;
    private View bLu;
    private TextView bLv;
    private TextView bLw;
    private TextView bLx;
    private ImageView bLy;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aRS = viewEventCenter;
        this.bLp = view.findViewById(r.g.left_container);
        this.bLq = (TextView) this.bLp.findViewById(r.g.sign);
        this.bLr = (TextView) this.bLp.findViewById(r.g.name);
        this.bLs = (TextView) this.bLp.findViewById(r.g.grade);
        this.bLt = (ImageView) this.bLp.findViewById(r.g.add);
        this.bLu = view.findViewById(r.g.right_container);
        this.bLv = (TextView) this.bLu.findViewById(r.g.sign);
        this.bLw = (TextView) this.bLu.findViewById(r.g.name);
        this.bLx = (TextView) this.bLu.findViewById(r.g.grade);
        this.bLy = (ImageView) this.bLu.findViewById(r.g.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.Yt(), true);
            a(aVar.Yu(), false);
            b(aVar.Yt(), true);
            b(aVar.Yu(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.w wVar, boolean z) {
        if (wVar != null) {
            View view = z ? this.bLp : this.bLu;
            TextView textView = z ? this.bLq : this.bLv;
            TextView textView2 = z ? this.bLr : this.bLw;
            TextView textView3 = z ? this.bLs : this.bLx;
            ImageView imageView = z ? this.bLt : this.bLy;
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
                    if (wVar.blt() == 0) {
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
            view = this.bLp;
        } else {
            view = this.bLu;
        }
        view.setOnClickListener(new p(this, wVar));
        view.setOnLongClickListener(new q(this, wVar));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.bLp.setBackgroundDrawable(at.getDrawable(r.f.home_like_item_bg));
        this.bLu.setBackgroundDrawable(at.getDrawable(r.f.home_like_item_bg));
        if (getData() != null && getData().Yt() != null) {
            at.k(this.bLs, BitmapHelper.getGradeResourceIdNew(getData().Yt().getLevel()));
        }
        if (getData() != null && getData().Yu() != null) {
            at.k(this.bLx, BitmapHelper.getGradeResourceIdNew(getData().Yu().getLevel()));
            return true;
        }
        return true;
    }
}
