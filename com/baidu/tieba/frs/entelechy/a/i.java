package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.entelechy.c.au;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<ax, a> {
    private BaseActivity<?> boS;
    private au boT;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.widget.layout.c> boU;
    private com.baidu.adp.lib.f.b<TbImageView> boV;

    public i(BaseActivity<?> baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity.getActivity(), bdUniqueId);
        this.boU = new com.baidu.adp.lib.f.b<>(new j(this), 6, 0);
        this.boV = new com.baidu.adp.lib.f.b<>(new k(this), 12, 0);
        this.boS = baseActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: H */
    public a b(ViewGroup viewGroup) {
        this.boT = new au(this.boS);
        this.boT.setConstrainLayoutPool(this.boU);
        this.boT.setConstrainImagePool(this.boV);
        this.boT.j(this.boS.getUniqueId());
        return new a(this.boT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ax axVar, a aVar) {
        aVar.boX.h(axVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends y.a {
        au boX;

        public a(au auVar) {
            super(auVar.getView());
            this.boX = auVar;
        }
    }
}
