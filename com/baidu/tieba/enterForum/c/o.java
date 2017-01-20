package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter bxK;
    private View bze;
    private TextView bzf;
    private TextView bzg;
    private TextView bzh;
    private ImageView bzi;
    private View bzj;
    private TextView bzk;
    private TextView bzl;
    private TextView bzm;
    private ImageView bzn;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bxK = viewEventCenter;
        this.bze = view.findViewById(r.h.left_container);
        this.bzf = (TextView) this.bze.findViewById(r.h.sign);
        this.bzg = (TextView) this.bze.findViewById(r.h.name);
        this.bzh = (TextView) this.bze.findViewById(r.h.grade);
        this.bzi = (ImageView) this.bze.findViewById(r.h.add);
        this.bzj = view.findViewById(r.h.right_container);
        this.bzk = (TextView) this.bzj.findViewById(r.h.sign);
        this.bzl = (TextView) this.bzj.findViewById(r.h.name);
        this.bzm = (TextView) this.bzj.findViewById(r.h.grade);
        this.bzn = (ImageView) this.bzj.findViewById(r.h.add);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(com.baidu.tieba.enterForum.b.a aVar) {
        super.E(aVar);
        if (aVar != null) {
            a(aVar.TZ(), true);
            a(aVar.Ua(), false);
            b(aVar.TZ(), true);
            b(aVar.Ua(), false);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        if (uVar != null) {
            View view = z ? this.bze : this.bzj;
            TextView textView = z ? this.bzf : this.bzk;
            TextView textView2 = z ? this.bzg : this.bzl;
            TextView textView3 = z ? this.bzh : this.bzm;
            ImageView imageView = z ? this.bzi : this.bzn;
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
                    if (uVar.bgY() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (uVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    ap.j((View) textView3, BitmapHelper.getGradeResourceIdNew(uVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.u uVar, boolean z) {
        View view;
        if (z) {
            view = this.bze;
        } else {
            view = this.bzj;
        }
        view.setOnClickListener(new p(this, uVar));
        view.setOnLongClickListener(new q(this, uVar));
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getRootView());
        this.bze.setBackgroundDrawable(ap.getDrawable(r.g.home_like_item_bg));
        this.bzj.setBackgroundDrawable(ap.getDrawable(r.g.home_like_item_bg));
        if (getData() != null && getData().TZ() != null) {
            ap.j((View) this.bzh, BitmapHelper.getGradeResourceIdNew(getData().TZ().getLevel()));
        }
        if (getData() != null && getData().Ua() != null) {
            ap.j((View) this.bzm, BitmapHelper.getGradeResourceIdNew(getData().Ua().getLevel()));
            return true;
        }
        return true;
    }
}
