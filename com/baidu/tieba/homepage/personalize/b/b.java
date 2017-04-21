package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, com.baidu.tieba.card.b.a<bk>> {
    private TbPageContext<?> ajU;
    private o.a akd;
    private cf bUw;
    public BdUniqueId bbE;
    private bk cAd;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akd = null;
        this.bUw = new c(this);
        this.ajU = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cAd = new bk(this.ajU);
        this.cAd.TS();
        this.cAd.i(this.bbE);
        return new com.baidu.tieba.card.b.a(this.cAd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.b.a<bk> aVar) {
        if (aVar == null || aVar.UB() == null) {
            return null;
        }
        if (oVar != null) {
            oVar.gR(i + 1);
            oVar.b(b(oVar));
            oVar.c(c(oVar));
            oVar.d(e(oVar));
            oVar.e(d(oVar));
        }
        aVar.UB().onBindDataToView(oVar);
        aVar.UB().a(this.akd);
        if (oVar != null) {
            cc.TV().a(oVar.Uv());
        }
        aVar.UB().setOnSubCardOnClickListenner(this.bUw);
        return aVar.getView();
    }

    private as b(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10732").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.TX()).s("obj_type", oVar.Ut());
    }

    private as c(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10707").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.TX()).s("obj_type", oVar.Ut());
    }

    private as d(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10733").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.TX()).s("obj_type", oVar.Ut());
    }

    private as e(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10706").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.TX()).s("obj_type", oVar.Ut());
    }

    public void setEventCallback(o.a aVar) {
        this.akd = aVar;
    }
}
