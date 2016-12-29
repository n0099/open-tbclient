package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bg;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, com.baidu.tieba.card.a.a<bg>> {
    private TbPageContext<?> GO;
    private o.a afo;
    private cb bES;
    public BdUniqueId bbl;
    private bg cqP;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afo = null;
        this.bES = new c(this);
        this.GO = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: i */
    public com.baidu.tieba.card.a.a a(ViewGroup viewGroup) {
        this.cqP = new bg(this.GO);
        this.cqP.OE();
        this.cqP.i(this.bbl);
        return new com.baidu.tieba.card.a.a(this.cqP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, com.baidu.tieba.card.a.a<bg> aVar) {
        if (aVar == null || aVar.Po() == null) {
            return null;
        }
        if (nVar != null) {
            nVar.gj(i + 1);
            nVar.b(b(nVar));
            nVar.c(c(nVar));
            nVar.d(e(nVar));
            nVar.e(d(nVar));
        }
        aVar.Po().onBindDataToView(nVar);
        aVar.Po().a(this.afo);
        if (nVar != null) {
            bz.OH().a(nVar.Ph());
        }
        aVar.Po().setOnSubCardOnClickListenner(this.bES);
        return aVar.getView();
    }

    private at b(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.IU() == null) {
            return null;
        }
        return new at("c10732").ab("fid", String.valueOf(nVar.IU().getFid())).ab("tid", String.valueOf(nVar.IU().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.OJ()).s("obj_type", nVar.Pf());
    }

    private at c(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.IU() == null) {
            return null;
        }
        return new at("c10707").ab("fid", String.valueOf(nVar.IU().getFid())).ab("tid", String.valueOf(nVar.IU().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.OJ()).s("obj_type", nVar.Pf());
    }

    private at d(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.IU() == null) {
            return null;
        }
        return new at("c10733").ab("fid", String.valueOf(nVar.IU().getFid())).ab("tid", String.valueOf(nVar.IU().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.OJ()).s("obj_type", nVar.Pf());
    }

    private at e(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.IU() == null) {
            return null;
        }
        return new at("c10706").ab("fid", String.valueOf(nVar.IU().getFid())).ab("tid", String.valueOf(nVar.IU().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.OJ()).s("obj_type", nVar.Pf());
    }

    public void setEventCallback(o.a aVar) {
        this.afo = aVar;
    }
}
