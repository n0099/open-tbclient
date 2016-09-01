package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bg;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.n, a> {
    private TbPageContext<?> GM;
    public BdUniqueId aYu;
    private cf bVU;
    private bg cFz;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bVU = new d(this);
        this.GM = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public a a(ViewGroup viewGroup) {
        this.cFz = new bg(this.GM);
        this.cFz.i(this.aYu);
        return new a(this.cFz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.n nVar, a aVar) {
        if (aVar == null || aVar.cFB == null) {
            return null;
        }
        if (nVar != null) {
            nVar.gf(i + 1);
            nVar.c(b(nVar));
            nVar.d(c(nVar));
            nVar.e(e(nVar));
            nVar.f(d(nVar));
        }
        aVar.cFB.onBindDataToView(nVar);
        if (nVar != null) {
            cd.NI().b(nVar.Og());
        }
        aVar.cFB.setOnSubCardOnClickListenner(this.bVU);
        return aVar.getView();
    }

    private ay b(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Kw() == null) {
            return null;
        }
        return new ay("c10732").ab("fid", String.valueOf(nVar.Kw().getFid())).ab("tid", String.valueOf(nVar.Kw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.NJ()).s("obj_type", nVar.Oe());
    }

    private ay c(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Kw() == null) {
            return null;
        }
        return new ay("c10707").ab("fid", String.valueOf(nVar.Kw().getFid())).ab("tid", String.valueOf(nVar.Kw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.NJ()).s("obj_type", nVar.Oe());
    }

    private ay d(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Kw() == null) {
            return null;
        }
        return new ay("c10733").ab("fid", String.valueOf(nVar.Kw().getFid())).ab("tid", String.valueOf(nVar.Kw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.NJ()).s("obj_type", nVar.Oe());
    }

    private ay e(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || nVar.Kw() == null) {
            return null;
        }
        return new ay("c10706").ab("fid", String.valueOf(nVar.Kw().getFid())).ab("tid", String.valueOf(nVar.Kw().getTid())).ab("obj_param1", nVar.getWeight()).ab("obj_source", nVar.getSource()).s("obj_locate", nVar.NJ()).s("obj_type", nVar.Oe());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends y.a {
        public bg cFB;

        public a(bg bgVar) {
            super(bgVar.getView());
            this.cFB = bgVar;
        }
    }
}
