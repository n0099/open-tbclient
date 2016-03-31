package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends b<com.baidu.tieba.card.a.p> {
    private String aGe;
    private String aGf;
    private List<g> aTb;
    private List<com.baidu.tieba.card.a.g> aTc;
    private int aTd;
    private String aTe;

    public void p(String str, String str2, String str3) {
        this.aGe = str;
        this.aGf = str2;
        this.aTe = str3;
    }

    public ae(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aTd = 0;
        this.aTb = new ArrayList();
        this.aRw.setVisibility(8);
        this.aRr.setVisibility(0);
        this.aRr.setText(getContext().getString(t.j.vcode_refresh));
        this.aRr.setOnClickListener(this);
        this.aTd = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.p pVar) {
        super.a((ae) pVar);
        if (pVar == null || com.baidu.tbadk.core.util.y.p(pVar.FZ()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        this.aTc = pVar.FZ();
        if (this.aTc.size() > 15) {
            this.aTc = this.aTc.subList(0, 15);
        }
        getView().setVisibility(0);
        J(fN(0));
        d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void J(List<com.baidu.tieba.card.a.g> list) {
        if (com.baidu.tbadk.core.util.y.p(list) > 0) {
            for (int i = 0; i < 3; i++) {
                if (i < list.size()) {
                    com.baidu.tieba.card.a.g gVar = list.get(i);
                    g gVar2 = (g) com.baidu.tbadk.core.util.y.b(this.aTb, i);
                    if (gVar2 != null) {
                        gVar2.a(gVar);
                    } else {
                        gVar2 = new g(Lb());
                        gVar2.setTag(getTag());
                        gVar2.a(gVar);
                        this.aRx.addView(gVar2.getView());
                        this.aTb.add(gVar2);
                    }
                    gVar2.setFrom(getFrom());
                    gVar2.at(this.aGe, this.aGf);
                    gVar2.getView().setVisibility(0);
                    gVar2.d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
                } else {
                    g gVar3 = (g) com.baidu.tbadk.core.util.y.b(this.aTb, i);
                    if (gVar3 != null) {
                        gVar3.getView().setVisibility(8);
                    }
                }
            }
        }
    }

    private List<com.baidu.tieba.card.a.g> fN(int i) {
        if (com.baidu.tbadk.core.util.y.p(this.aTc) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.aTd = (i < 0 || i >= this.aTc.size()) ? 0 : 0;
        int i2 = this.aTd;
        int size = this.aTc.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aTc.get(i3) != null && arrayList.size() < 3) {
                arrayList.add(this.aTc.get(i3));
                this.aTd++;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aTb != null) {
            for (g gVar : this.aTb) {
                gVar.d(tbPageContext, i);
            }
        }
        super.d(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aRr == view) {
            J(fN(this.aTd));
            if (!TextUtils.isEmpty(this.aTe)) {
                TiebaStatic.log(this.aTe);
            }
        }
    }
}
