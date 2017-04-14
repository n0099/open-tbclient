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
    private TbPageContext<?> ajT;
    private o.a akc;
    private cf bSf;
    public BdUniqueId baI;
    private bk cxM;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akc = null;
        this.bSf = new c(this);
        this.ajT = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxM = new bk(this.ajT);
        this.cxM.SQ();
        this.cxM.i(this.baI);
        return new com.baidu.tieba.card.b.a(this.cxM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.b.a<bk> aVar) {
        if (aVar == null || aVar.Tz() == null) {
            return null;
        }
        if (oVar != null) {
            oVar.gL(i + 1);
            oVar.b(b(oVar));
            oVar.c(c(oVar));
            oVar.d(e(oVar));
            oVar.e(d(oVar));
        }
        aVar.Tz().onBindDataToView(oVar);
        aVar.Tz().a(this.akc);
        if (oVar != null) {
            cc.ST().a(oVar.Tt());
        }
        aVar.Tz().setOnSubCardOnClickListenner(this.bSf);
        return aVar.getView();
    }

    private as b(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10732").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.SV()).s("obj_type", oVar.Tr());
    }

    private as c(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10707").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.SV()).s("obj_type", oVar.Tr());
    }

    private as d(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10733").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.SV()).s("obj_type", oVar.Tr());
    }

    private as e(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Kn() == null) {
            return null;
        }
        return new as("c10706").aa("fid", String.valueOf(oVar.Kn().getFid())).aa("tid", String.valueOf(oVar.Kn().getTid())).aa("obj_param1", oVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.SV()).s("obj_type", oVar.Tr());
    }

    public void setEventCallback(o.a aVar) {
        this.akc = aVar;
    }
}
