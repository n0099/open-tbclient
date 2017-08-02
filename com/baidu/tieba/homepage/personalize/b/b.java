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
    public BdUniqueId aNy;
    private h.a akI;
    private TbPageContext<?> ako;
    private x bjp;
    private p cSl;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akI = null;
        this.bjp = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.Ww().cA(true);
                if (view != null && b.this.cSl != null && b.this.cSl.getView() != null && b.this.cSl.bGG != null && mVar != null && mVar.MA() != null && !StringUtils.isNull(mVar.MA().getTid())) {
                    if (view.getId() != b.this.cSl.getView().getId()) {
                        if (b.this.cSl.Wt() == null || view.getId() != b.this.cSl.Wt().getId()) {
                            if (b.this.cSl.getHeaderImg() == null || view.getId() != b.this.cSl.getHeaderImg().getId()) {
                                if (b.this.cSl.Wc() != null && b.this.cSl.Wc().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.WT());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.WT());
                            return;
                        }
                        TiebaStatic.log(mVar.WS());
                        return;
                    }
                    TiebaStatic.log(mVar.WQ());
                }
            }
        };
        this.ako = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cSl = new p(this.ako);
        this.cSl.Wq();
        this.cSl.i(this.aNy);
        return new com.baidu.tieba.card.a.a(this.cSl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.WX() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hu(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.WX().a(mVar);
        aVar.WX().a(this.akI);
        if (mVar != null) {
            u.Ww().a(mVar.WR());
        }
        aVar.WX().a(this.bjp);
        return aVar.getView();
    }

    private aj b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MA() == null) {
            return null;
        }
        return new aj("c10732").aa("fid", String.valueOf(mVar.MA().getFid())).aa("tid", String.valueOf(mVar.MA().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WA()).r("obj_type", mVar.WP());
    }

    private aj c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MA() == null) {
            return null;
        }
        aj r = new aj("c10707").aa("fid", String.valueOf(mVar.MA().getFid())).aa("tid", String.valueOf(mVar.MA().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WA()).r("obj_type", mVar.WP());
        if (mVar.MA() != null) {
            bl MA = mVar.MA();
            r.r("obj_name", MA.sK() != null && (MA.sK().aAE() != null || MA.sK().Io() != null) ? 1 : 0);
        }
        return r;
    }

    private aj d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MA() == null) {
            return null;
        }
        return new aj("c10733").aa("fid", String.valueOf(mVar.MA().getFid())).aa("tid", String.valueOf(mVar.MA().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WA()).r("obj_type", mVar.WP());
    }

    private aj e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.MA() == null) {
            return null;
        }
        return new aj("c10706").aa("fid", String.valueOf(mVar.MA().getFid())).aa("tid", String.valueOf(mVar.MA().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.WA()).r("obj_type", mVar.WP());
    }

    public void setEventCallback(h.a aVar) {
        this.akI = aVar;
    }
}
