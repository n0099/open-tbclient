package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.n, a> {
    private TbPageContext<?> EA;
    public BdUniqueId aTm;
    private bx bKK;
    private bk ctV;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bKK = new e(this);
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: al */
    public a a(ViewGroup viewGroup) {
        this.ctV = new bk(this.EA);
        this.ctV.i(this.aTm);
        return new a(this.ctV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.n nVar, a aVar) {
        if (aVar == null || aVar.ctX == null) {
            return null;
        }
        if (nVar != null) {
            nVar.fH(i + 1);
            nVar.c(b(nVar));
            nVar.d(c(nVar));
            nVar.e(e(nVar));
            nVar.f(d(nVar));
        }
        aVar.ctX.a(nVar);
        if (nVar != null) {
            bw.Lf().b(nVar.LC());
        }
        aVar.ctX.a(this.bKK);
        return aVar.getView();
    }

    private ay b(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Iw() == null) {
            return null;
        }
        return new ay("c10732").ab("fid", String.valueOf(nVar.Iw().getFid())).ab("tid", String.valueOf(nVar.Iw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lg()).s("obj_type", nVar.LA());
    }

    private ay c(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Iw() == null) {
            return null;
        }
        return new ay("c10707").ab("fid", String.valueOf(nVar.Iw().getFid())).ab("tid", String.valueOf(nVar.Iw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lg()).s("obj_type", nVar.LA());
    }

    private ay d(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Iw() == null) {
            return null;
        }
        return new ay("c10733").ab("fid", String.valueOf(nVar.Iw().getFid())).ab("tid", String.valueOf(nVar.Iw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lg()).s("obj_type", nVar.LA());
    }

    private ay e(com.baidu.tieba.card.a.n nVar) {
        if (nVar == null || nVar.Iw() == null) {
            return null;
        }
        return new ay("c10706").ab("fid", String.valueOf(nVar.Iw().getFid())).ab("tid", String.valueOf(nVar.Iw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.Lg()).s("obj_type", nVar.LA());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bk ctX;

        public a(bk bkVar) {
            super(bkVar.getView());
            this.ctX = bkVar;
        }
    }
}
