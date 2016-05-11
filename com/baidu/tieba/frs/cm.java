package com.baidu.tieba.frs;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class cm extends bw<com.baidu.tbadk.core.data.ax, a> {
    public cm(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: o */
    public a b(ViewGroup viewGroup) {
        com.baidu.tieba.frs.entelechy.c.at atVar = new com.baidu.tieba.frs.entelechy.c.at(this.bek.getPageContext());
        atVar.j(this.bek.getUniqueId());
        return new a(atVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bw, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.ax axVar, a aVar) {
        super.a(i, view, viewGroup, (ViewGroup) axVar, (com.baidu.tbadk.core.data.ax) aVar);
        aVar.bjz.d(this.bek.getPageContext(), this.mSkinType);
        aVar.bjz.h(axVar);
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends y.a {
        com.baidu.tieba.frs.entelechy.c.at bjz;

        public a(com.baidu.tieba.frs.entelechy.c.at atVar) {
            super(atVar.getView());
            this.bjz = atVar;
        }
    }
}
