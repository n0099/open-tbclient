package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bv;
import com.baidu.tieba.card.bw;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.r, a> {
    private TbPageContext<?> Ea;

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.r.aVM);
        this.Ea = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: au */
    public a a(ViewGroup viewGroup) {
        bv bvVar = new bv(this.Ea);
        bvVar.u("c10718", "c10719", "c10742");
        return new a(bvVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.r rVar, a aVar) {
        aVar.csa.d(this.Ea, TbadkCoreApplication.m9getInst().getSkinType());
        aVar.csa.a(rVar);
        bw.Lg().a(new ay("c10718").ab("obj_id", String.valueOf(rVar.aVN)));
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bv csa;

        public a(bv bvVar) {
            super(bvVar.getView());
            this.csa = bvVar;
        }
    }
}
