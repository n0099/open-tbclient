package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.b.a<bj>> {
    public BdUniqueId aKZ;
    private TbPageContext<?> ajh;
    private o.a ajq;
    private ci bdp;
    private bj cBF;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajq = null;
        this.bdp = new c(this);
        this.ajh = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: l */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cBF = new bj(this.ajh);
        this.cBF.Us();
        this.cBF.i(this.aKZ);
        return new com.baidu.tieba.card.b.a(this.cBF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.b.a<bj> aVar) {
        if (aVar == null || aVar.UY() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hl(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.UY().a(mVar);
        aVar.UY().a(this.ajq);
        if (mVar != null) {
            cf.Uw().a(mVar.US());
        }
        aVar.UY().a(this.bdp);
        return aVar.getView();
    }

    private as b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.LH() == null) {
            return null;
        }
        return new as("c10732").Z("fid", String.valueOf(mVar.LH().getFid())).Z("tid", String.valueOf(mVar.LH().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.UB()).r("obj_type", mVar.UQ());
    }

    private as c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.LH() == null) {
            return null;
        }
        as r = new as("c10707").Z("fid", String.valueOf(mVar.LH().getFid())).Z("tid", String.valueOf(mVar.LH().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.UB()).r("obj_type", mVar.UQ());
        if (mVar.LH() != null) {
            r.r("obj_name", mVar.LH().sG() != null && mVar.LH().sG().avd() != null && !au.isEmpty(mVar.LH().sG().bU(TbadkCoreApplication.m9getInst())) ? 1 : 0);
        }
        return r;
    }

    private as d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.LH() == null) {
            return null;
        }
        return new as("c10733").Z("fid", String.valueOf(mVar.LH().getFid())).Z("tid", String.valueOf(mVar.LH().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.UB()).r("obj_type", mVar.UQ());
    }

    private as e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.LH() == null) {
            return null;
        }
        return new as("c10706").Z("fid", String.valueOf(mVar.LH().getFid())).Z("tid", String.valueOf(mVar.LH().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.UB()).r("obj_type", mVar.UQ());
    }

    public void setEventCallback(o.a aVar) {
        this.ajq = aVar;
    }
}
