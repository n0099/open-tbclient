package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.o, com.baidu.tieba.card.b.a<bk>> {
    private TbPageContext<?> FY;
    public BdUniqueId aUC;
    private o.a aez;
    private cf bLl;
    private bk cxQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aez = null;
        this.bLl = new c(this);
        this.FY = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cxQ = new bk(this.FY);
        this.cxQ.Ru();
        this.cxQ.i(this.aUC);
        return new com.baidu.tieba.card.b.a(this.cxQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.b.a<bk> aVar) {
        if (aVar == null || aVar.Sd() == null) {
            return null;
        }
        if (oVar != null) {
            oVar.gL(i + 1);
            oVar.b(b(oVar));
            oVar.c(c(oVar));
            oVar.d(e(oVar));
            oVar.e(d(oVar));
        }
        aVar.Sd().onBindDataToView(oVar);
        aVar.Sd().a(this.aez);
        if (oVar != null) {
            cc.Rx().a(oVar.RX());
        }
        aVar.Sd().setOnSubCardOnClickListenner(this.bLl);
        return aVar.getView();
    }

    private ar b(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Ji() == null) {
            return null;
        }
        return new ar("c10732").ab("fid", String.valueOf(oVar.Ji().getFid())).ab("tid", String.valueOf(oVar.Ji().getTid())).ab("obj_param1", oVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Rz()).s("obj_type", oVar.RV());
    }

    private ar c(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Ji() == null) {
            return null;
        }
        return new ar("c10707").ab("fid", String.valueOf(oVar.Ji().getFid())).ab("tid", String.valueOf(oVar.Ji().getTid())).ab("obj_param1", oVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Rz()).s("obj_type", oVar.RV());
    }

    private ar d(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Ji() == null) {
            return null;
        }
        return new ar("c10733").ab("fid", String.valueOf(oVar.Ji().getFid())).ab("tid", String.valueOf(oVar.Ji().getTid())).ab("obj_param1", oVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Rz()).s("obj_type", oVar.RV());
    }

    private ar e(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.Ji() == null) {
            return null;
        }
        return new ar("c10706").ab("fid", String.valueOf(oVar.Ji().getFid())).ab("tid", String.valueOf(oVar.Ji().getTid())).ab("obj_param1", oVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Rz()).s("obj_type", oVar.RV());
    }

    public void setEventCallback(o.a aVar) {
        this.aez = aVar;
    }
}
