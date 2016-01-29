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
public class ac extends b<com.baidu.tieba.card.a.o> {
    private String aEJ;
    private String aEK;
    private List<g> aQg;
    private List<com.baidu.tieba.card.a.g> aQh;
    private int aQi;
    private String aQj;

    public void n(String str, String str2, String str3) {
        this.aEJ = str;
        this.aEK = str2;
        this.aQj = str3;
    }

    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQi = 0;
        this.aQg = new ArrayList();
        this.aOH.setVisibility(8);
        this.aOC.setVisibility(0);
        this.aOC.setText(getContext().getString(t.j.vcode_refresh));
        this.aOC.setOnClickListener(this);
        this.aQi = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.o oVar) {
        super.a((ac) oVar);
        if (oVar == null || com.baidu.tbadk.core.util.x.o(oVar.Fm()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        this.aQh = oVar.Fm();
        if (this.aQh.size() > 15) {
            this.aQh = this.aQh.subList(0, 15);
        }
        getView().setVisibility(0);
        G(fz(0));
        d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void G(List<com.baidu.tieba.card.a.g> list) {
        if (com.baidu.tbadk.core.util.x.o(list) > 0) {
            for (int i = 0; i < 3; i++) {
                if (i < list.size()) {
                    com.baidu.tieba.card.a.g gVar = list.get(i);
                    g gVar2 = (g) com.baidu.tbadk.core.util.x.b(this.aQg, i);
                    if (gVar2 != null) {
                        gVar2.a(gVar);
                    } else {
                        gVar2 = new g(JK());
                        gVar2.setTag(getTag());
                        gVar2.a(gVar);
                        this.aOI.addView(gVar2.getView());
                        this.aQg.add(gVar2);
                    }
                    gVar2.setFrom(getFrom());
                    gVar2.an(this.aEJ, this.aEK);
                    gVar2.getView().setVisibility(0);
                    gVar2.d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
                } else {
                    g gVar3 = (g) com.baidu.tbadk.core.util.x.b(this.aQg, i);
                    if (gVar3 != null) {
                        gVar3.getView().setVisibility(8);
                    }
                }
            }
        }
    }

    private List<com.baidu.tieba.card.a.g> fz(int i) {
        if (com.baidu.tbadk.core.util.x.o(this.aQh) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.aQi = (i < 0 || i >= this.aQh.size()) ? 0 : 0;
        int i2 = this.aQi;
        int size = this.aQh.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aQh.get(i3) != null && arrayList.size() < 3) {
                arrayList.add(this.aQh.get(i3));
                this.aQi++;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aQg != null) {
            for (g gVar : this.aQg) {
                gVar.d(tbPageContext, i);
            }
        }
        super.d(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aOC == view) {
            G(fz(this.aQi));
            if (!TextUtils.isEmpty(this.aQj)) {
                TiebaStatic.log(this.aQj);
            }
        }
    }
}
