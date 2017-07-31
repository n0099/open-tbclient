package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aOM;
    private TbPageContext<?> alI;
    private h.a amc;
    private x bkz;
    private p cTE;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amc = null;
        this.bkz = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.WB().cA(true);
                if (view != null && b.this.cTE != null && b.this.cTE.getView() != null && b.this.cTE.bHQ != null && mVar != null && mVar.MF() != null && !StringUtils.isNull(mVar.MF().getTid())) {
                    if (view.getId() != b.this.cTE.getView().getId()) {
                        if (b.this.cTE.Wy() == null || view.getId() != b.this.cTE.Wy().getId()) {
                            if (b.this.cTE.getHeaderImg() == null || view.getId() != b.this.cTE.getHeaderImg().getId()) {
                                if (b.this.cTE.Wh() != null && b.this.cTE.Wh().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.WY());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.WY());
                            return;
                        }
                        TiebaStatic.log(mVar.WX());
                        return;
                    }
                    TiebaStatic.log(mVar.WV());
                }
            }
        };
        this.alI = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cTE = new p(this.alI);
        this.cTE.Wv();
        this.cTE.i(this.aOM);
        return new com.baidu.tieba.card.a.a(this.cTE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.Xc() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hv(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Xc().a(mVar);
        aVar.Xc().a(this.amc);
        if (mVar != null) {
            u.WB().a(mVar.WW());
        }
        aVar.Xc().a(this.bkz);
        return aVar.getView();
    }

    private aj b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10732").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WF()).r("obj_type", mVar.WU());
    }

    private aj c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        aj r = new aj("c10707").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WF()).r("obj_type", mVar.WU());
        if (mVar.MF() != null) {
            bl MF = mVar.MF();
            r.r("obj_name", MF.sU() != null && (MF.sU().aAP() != null || MF.sU().Iv() != null) ? 1 : 0);
        }
        return r;
    }

    private aj d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10733").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WF()).r("obj_type", mVar.WU());
    }

    private aj e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MF() == null) {
            return null;
        }
        return new aj("c10706").aa("fid", String.valueOf(mVar.MF().getFid())).aa("tid", String.valueOf(mVar.MF().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WF()).r("obj_type", mVar.WU());
    }

    public void setEventCallback(h.a aVar) {
        this.amc = aVar;
    }
}
