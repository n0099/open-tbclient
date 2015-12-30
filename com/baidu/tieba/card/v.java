package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends b<com.baidu.tieba.card.a.l> {
    private String aDT;
    private String aDU;
    private List<d> aOd;
    private List<com.baidu.tieba.card.a.f> aOe;
    private int aOf;
    private String aOg;

    public void n(String str, String str2, String str3) {
        this.aDT = str;
        this.aDU = str2;
        this.aOg = str3;
    }

    public v(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aOf = 0;
        this.aOd = new ArrayList();
        this.aNt.setVisibility(8);
        this.aNo.setVisibility(0);
        this.aNo.setText(getContext().getString(n.j.vcode_refresh));
        this.aNo.setOnClickListener(this);
        this.aOf = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.l lVar) {
        super.a((v) lVar);
        if (lVar == null || com.baidu.tbadk.core.util.y.l(lVar.DS()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        this.aOe = lVar.DS();
        if (this.aOe.size() > 15) {
            this.aOe = this.aOe.subList(0, 15);
        }
        getView().setVisibility(0);
        C(fb(0));
        onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void C(List<com.baidu.tieba.card.a.f> list) {
        if (com.baidu.tbadk.core.util.y.l(list) > 0) {
            for (int i = 0; i < 3; i++) {
                if (i < list.size()) {
                    com.baidu.tieba.card.a.f fVar = list.get(i);
                    d dVar = (d) com.baidu.tbadk.core.util.y.b(this.aOd, i);
                    if (dVar != null) {
                        dVar.a(fVar);
                    } else {
                        dVar = new d(Ie());
                        dVar.setTag(getTag());
                        dVar.a(fVar);
                        this.aNu.addView(dVar.getView());
                        this.aOd.add(dVar);
                    }
                    dVar.setFrom(getFrom());
                    dVar.an(this.aDT, this.aDU);
                    dVar.getView().setVisibility(0);
                    dVar.onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
                } else {
                    d dVar2 = (d) com.baidu.tbadk.core.util.y.b(this.aOd, i);
                    if (dVar2 != null) {
                        dVar2.getView().setVisibility(8);
                    }
                }
            }
        }
    }

    private List<com.baidu.tieba.card.a.f> fb(int i) {
        if (com.baidu.tbadk.core.util.y.l(this.aOe) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.aOf = (i < 0 || i >= this.aOe.size()) ? 0 : 0;
        int i2 = this.aOf;
        int size = this.aOe.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aOe.get(i3) != null && arrayList.size() < 3) {
                arrayList.add(this.aOe.get(i3));
                this.aOf++;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aOd != null) {
            for (d dVar : this.aOd) {
                dVar.onChangeSkinType(tbPageContext, i);
            }
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aNo == view) {
            C(fb(this.aOf));
            if (!TextUtils.isEmpty(this.aOg)) {
                TiebaStatic.log(this.aOg);
            }
        }
    }
}
