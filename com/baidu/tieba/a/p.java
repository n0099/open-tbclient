package com.baidu.tieba.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends b<com.baidu.tieba.a.a.i> {
    private String aCl;
    private String aCm;
    private List<c> aMs;
    private List<com.baidu.tieba.a.a.d> aMt;
    private int aMu;
    private String aMv;

    public void n(String str, String str2, String str3) {
        this.aCl = str;
        this.aCm = str2;
        this.aMv = str3;
    }

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMu = 0;
        this.aMs = new ArrayList();
        this.aLU.setVisibility(8);
        this.aLP.setVisibility(0);
        this.aLP.setText(getContext().getString(n.i.vcode_refresh));
        this.aLP.setOnClickListener(this);
        this.aMu = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a.b
    public void a(com.baidu.tieba.a.a.i iVar) {
        super.a((p) iVar);
        if (iVar == null || y.k(iVar.Ed()) <= 0) {
            getView().setVisibility(8);
            return;
        }
        this.aMt = iVar.Ed();
        if (this.aMt.size() > 15) {
            this.aMt = this.aMt.subList(0, 15);
        }
        getView().setVisibility(0);
        B(fh(0));
        onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
    }

    private void B(List<com.baidu.tieba.a.a.d> list) {
        if (y.k(list) > 0) {
            for (int i = 0; i < 3; i++) {
                if (i < list.size()) {
                    com.baidu.tieba.a.a.d dVar = list.get(i);
                    c cVar = (c) y.b(this.aMs, i);
                    if (cVar != null) {
                        cVar.a(dVar);
                    } else {
                        cVar = new c(Io());
                        cVar.a(dVar);
                        this.aLV.addView(cVar.getView());
                        this.aMs.add(cVar);
                    }
                    cVar.setFrom(getFrom());
                    cVar.ao(this.aCl, this.aCm);
                    cVar.getView().setVisibility(0);
                    cVar.onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
                } else {
                    c cVar2 = (c) y.b(this.aMs, i);
                    if (cVar2 != null) {
                        cVar2.getView().setVisibility(8);
                    }
                }
            }
        }
    }

    private List<com.baidu.tieba.a.a.d> fh(int i) {
        if (y.k(this.aMt) <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.aMu = (i < 0 || i >= this.aMt.size()) ? 0 : 0;
        int i2 = this.aMu;
        int size = this.aMt.size();
        for (int i3 = i2; i3 < size; i3++) {
            if (this.aMt.get(i3) != null && arrayList.size() < 3) {
                arrayList.add(this.aMt.get(i3));
                this.aMu++;
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.a.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.aMs != null) {
            for (c cVar : this.aMs) {
                cVar.onChangeSkinType(tbPageContext, i);
            }
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aLP == view) {
            B(fh(this.aMu));
            if (!TextUtils.isEmpty(this.aMv)) {
                TiebaStatic.log(this.aMv);
            }
        }
    }
}
