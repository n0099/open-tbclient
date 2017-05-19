package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bf;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.b.a<bf>> {
    public BdUniqueId aLk;
    private o.a ajA;
    private TbPageContext<?> ajr;
    private cd bSq;
    private bf cvn;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajA = null;
        this.bSq = new c(this);
        this.ajr = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: m */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cvn = new bf(this.ajr);
        this.cvn.Tk();
        this.cvn.i(this.aLk);
        return new com.baidu.tieba.card.b.a(this.cvn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.b.a<bf> aVar) {
        if (aVar == null || aVar.TU() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.gN(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.TU().onBindDataToView(mVar);
        aVar.TU().a(this.ajA);
        if (mVar != null) {
            ca.To().a(mVar.TO());
        }
        aVar.TU().setOnSubCardOnClickListenner(this.bSq);
        return aVar.getView();
    }

    private as b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.JB() == null) {
            return null;
        }
        return new as("c10732").aa("fid", String.valueOf(mVar.JB().getFid())).aa("tid", String.valueOf(mVar.JB().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.Tq()).s("obj_type", mVar.TM());
    }

    private as c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.JB() == null) {
            return null;
        }
        return new as("c10707").aa("fid", String.valueOf(mVar.JB().getFid())).aa("tid", String.valueOf(mVar.JB().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.Tq()).s("obj_type", mVar.TM());
    }

    private as d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.JB() == null) {
            return null;
        }
        return new as("c10733").aa("fid", String.valueOf(mVar.JB().getFid())).aa("tid", String.valueOf(mVar.JB().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.Tq()).s("obj_type", mVar.TM());
    }

    private as e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.JB() == null) {
            return null;
        }
        return new as("c10706").aa("fid", String.valueOf(mVar.JB().getFid())).aa("tid", String.valueOf(mVar.JB().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.Tq()).s("obj_type", mVar.TM());
    }

    public void setEventCallback(o.a aVar) {
        this.ajA = aVar;
    }
}
