package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class o extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.enterForum.b.a, com.baidu.tbadk.mvc.d.b> {
    private ViewEventCenter aLB;
    private View aMU;
    private TextView aMV;
    private TextView aMW;
    private TextView aMX;
    private ImageView aMY;
    private View aMZ;
    private TextView aNa;
    private TextView aNb;
    private TextView aNc;
    private ImageView aNd;

    public o(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aLB = viewEventCenter;
        this.aMU = view.findViewById(i.f.left_container);
        this.aMV = (TextView) this.aMU.findViewById(i.f.sign);
        this.aMW = (TextView) this.aMU.findViewById(i.f.name);
        this.aMX = (TextView) this.aMU.findViewById(i.f.grade);
        this.aMY = (ImageView) this.aMU.findViewById(i.f.add);
        this.aMZ = view.findViewById(i.f.right_container);
        this.aNa = (TextView) this.aMZ.findViewById(i.f.sign);
        this.aNb = (TextView) this.aMZ.findViewById(i.f.name);
        this.aNc = (TextView) this.aMZ.findViewById(i.f.grade);
        this.aNd = (ImageView) this.aMZ.findViewById(i.f.add);
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
            View view = z ? this.aMU : this.aMZ;
            TextView textView = z ? this.aMV : this.aNa;
            TextView textView2 = z ? this.aMW : this.aNb;
            TextView textView3 = z ? this.aMX : this.aNc;
            ImageView imageView = z ? this.aMY : this.aNd;
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
                    if (vVar.avS() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                    if (vVar.getLevel() == 0) {
                        textView3.setVisibility(4);
                        return;
                    }
                    textView3.setVisibility(0);
                    am.i((View) textView3, com.baidu.tbadk.core.util.c.ch(vVar.getLevel()));
                    return;
            }
        }
    }

    private void b(com.baidu.tieba.tbadkCore.v vVar, boolean z) {
        View view;
        if (z) {
            view = this.aMU;
        } else {
            view = this.aMZ;
        }
        view.setOnClickListener(new p(this, vVar));
        view.setOnLongClickListener(new q(this));
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
        this.aMU.setBackgroundDrawable(am.getDrawable(i.e.home_like_item_bg));
        this.aMZ.setBackgroundDrawable(am.getDrawable(i.e.home_like_item_bg));
        if (this.aMX.getVisibility() == 0 && getData() != null && getData().HU() != null) {
            am.i((View) this.aMX, com.baidu.tbadk.core.util.c.ch(getData().HU().getLevel()));
        }
        if (this.aNc.getVisibility() == 0 && getData() != null && getData().HV() != null) {
            am.i((View) this.aNc, com.baidu.tbadk.core.util.c.ch(getData().HV().getLevel()));
            return true;
        }
        return true;
    }
}
