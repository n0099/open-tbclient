package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.p;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.tieba.card.a.a<p>> {
    public BdUniqueId aPk;
    private c.a aVu;
    private x bmv;
    private p cZc;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVu = null;
        this.bmv = new x<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                u.XN().cA(true);
                if (view != null && b.this.cZc != null && b.this.cZc.getView() != null && b.this.cZc.bLw != null && mVar != null && mVar.Nd() != null && !StringUtils.isNull(mVar.Nd().getTid())) {
                    if (view.getId() != b.this.cZc.getView().getId()) {
                        if (b.this.cZc.XK() == null || view.getId() != b.this.cZc.XK().getId()) {
                            if (b.this.cZc.getHeaderImg() == null || view.getId() != b.this.cZc.getHeaderImg().getId()) {
                                if (b.this.cZc.Xq() != null && b.this.cZc.Xq().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.Yj());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.Yj());
                            return;
                        }
                        TiebaStatic.log(mVar.Yi());
                        return;
                    }
                    TiebaStatic.log(mVar.Yg());
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.cZc = new p(this.mH);
        this.cZc.XH();
        this.cZc.h(this.aPk);
        return new com.baidu.tieba.card.a.a(this.cZc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.tieba.card.a.a<p> aVar) {
        if (aVar == null || aVar.Yn() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.hQ(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.Yn().a(mVar);
        aVar.Yn().a(this.aVu);
        if (mVar != null) {
            u.XN().a(mVar.Yh());
        }
        aVar.Yn().b(this.bmv);
        return aVar.getView();
    }

    private ak b(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nd() == null) {
            return null;
        }
        return new ak("c10732").ac("fid", String.valueOf(mVar.Nd().getFid())).ac("tid", String.valueOf(mVar.Nd().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XQ()).r("obj_type", mVar.Yf()).ac("obj_id", mVar.getExtra());
    }

    private ak c(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nd() == null) {
            return null;
        }
        ak ac = new ak("c10707").ac("fid", String.valueOf(mVar.Nd().getFid())).ac("tid", String.valueOf(mVar.Nd().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XQ()).r("obj_type", mVar.Yf()).ac("obj_id", mVar.getExtra());
        if (mVar.Nd() != null) {
            bh Nd = mVar.Nd();
            ac.r("obj_name", Nd.sE() != null && (Nd.sE().aBY() != null || Nd.sE().IF() != null) ? 1 : 0);
        }
        return ac;
    }

    private ak d(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nd() == null) {
            return null;
        }
        return new ak("c10733").ac("fid", String.valueOf(mVar.Nd().getFid())).ac("tid", String.valueOf(mVar.Nd().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XQ()).r("obj_type", mVar.Yf()).ac("obj_id", mVar.getExtra());
    }

    private ak e(com.baidu.tieba.card.data.m mVar) {
        if (mVar == null || mVar.Nd() == null) {
            return null;
        }
        return new ak("c10706").ac("fid", String.valueOf(mVar.Nd().getFid())).ac("tid", String.valueOf(mVar.Nd().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.XQ()).r("obj_type", mVar.Yf()).ac("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }
}
