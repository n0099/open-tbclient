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
    private TbPageContext<?> ajF;
    private o.a ajO;
    private cf bSr;
    public BdUniqueId baP;
    private bk czm;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajO = null;
        this.bSr = new c(this);
        this.ajF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: k */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.czm = new bk(this.ajF);
        this.czm.Ss();
        this.czm.i(this.baP);
        return new com.baidu.tieba.card.b.a(this.czm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.o oVar, com.baidu.tieba.card.b.a<bk> aVar) {
        if (aVar == null || aVar.Tb() == null) {
            return null;
        }
        if (oVar != null) {
            oVar.gI(i + 1);
            oVar.b(b(oVar));
            oVar.c(c(oVar));
            oVar.d(e(oVar));
            oVar.e(d(oVar));
        }
        aVar.Tb().onBindDataToView(oVar);
        aVar.Tb().a(this.ajO);
        if (oVar != null) {
            cc.Sv().a(oVar.SV());
        }
        aVar.Tb().setOnSubCardOnClickListenner(this.bSr);
        return aVar.getView();
    }

    private as b(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.JN() == null) {
            return null;
        }
        return new as("c10732").Z("fid", String.valueOf(oVar.JN().getFid())).Z("tid", String.valueOf(oVar.JN().getTid())).Z("obj_param1", oVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Sx()).s("obj_type", oVar.ST());
    }

    private as c(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.JN() == null) {
            return null;
        }
        return new as("c10707").Z("fid", String.valueOf(oVar.JN().getFid())).Z("tid", String.valueOf(oVar.JN().getTid())).Z("obj_param1", oVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Sx()).s("obj_type", oVar.ST());
    }

    private as d(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.JN() == null) {
            return null;
        }
        return new as("c10733").Z("fid", String.valueOf(oVar.JN().getFid())).Z("tid", String.valueOf(oVar.JN().getTid())).Z("obj_param1", oVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Sx()).s("obj_type", oVar.ST());
    }

    private as e(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || oVar.JN() == null) {
            return null;
        }
        return new as("c10706").Z("fid", String.valueOf(oVar.JN().getFid())).Z("tid", String.valueOf(oVar.JN().getTid())).Z("obj_param1", oVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, oVar.getSource()).s("obj_locate", oVar.Sx()).s("obj_type", oVar.ST());
    }

    public void setEventCallback(o.a aVar) {
        this.ajO = aVar;
    }
}
