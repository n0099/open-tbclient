package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.card.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.b.a<bj>> {
    public BdUniqueId aMp;
    private TbPageContext<?> ajP;
    private o.a akb;
    private ci bgj;
    private bj cJC;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akb = null;
        this.bgj = new c(this);
        this.ajP = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: n */
    public com.baidu.tieba.card.b.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cJC = new bj(this.ajP);
        this.cJC.VJ();
        this.cJC.i(this.aMp);
        return new com.baidu.tieba.card.b.a(this.cJC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.b.a<bj> aVar) {
        if (aVar == null || aVar.Wp() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.ho(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Wp().a(mVar);
        aVar.Wp().a(this.akb);
        if (mVar != null) {
            cf.VN().a(mVar.Wj());
        }
        aVar.Wp().a(this.bgj);
        return aVar.getView();
    }

    private au b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Mv() == null) {
            return null;
        }
        return new au("c10732").Z("fid", String.valueOf(mVar.Mv().getFid())).Z("tid", String.valueOf(mVar.Mv().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.VS()).r("obj_type", mVar.Wh());
    }

    private au c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Mv() == null) {
            return null;
        }
        au r = new au("c10707").Z("fid", String.valueOf(mVar.Mv().getFid())).Z("tid", String.valueOf(mVar.Mv().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.VS()).r("obj_type", mVar.Wh());
        if (mVar.Mv() != null) {
            bm Mv = mVar.Mv();
            r.r("obj_name", Mv.sE() != null && (Mv.sE().azb() != null || Mv.sE().Ic() != null) ? 1 : 0);
        }
        return r;
    }

    private au d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Mv() == null) {
            return null;
        }
        return new au("c10733").Z("fid", String.valueOf(mVar.Mv().getFid())).Z("tid", String.valueOf(mVar.Mv().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.VS()).r("obj_type", mVar.Wh());
    }

    private au e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Mv() == null) {
            return null;
        }
        return new au("c10706").Z("fid", String.valueOf(mVar.Mv().getFid())).Z("tid", String.valueOf(mVar.Mv().getTid())).Z("obj_param1", mVar.getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.VS()).r("obj_type", mVar.Wh());
    }

    public void setEventCallback(o.a aVar) {
        this.akb = aVar;
    }
}
