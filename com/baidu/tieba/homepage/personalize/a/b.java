package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    public BdUniqueId aSv;
    private c.a aYN;
    private v buV;
    private com.baidu.tieba.card.m dqB;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.buV = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                s.abU().cB(true);
                if (view != null && b.this.dqB != null && b.this.dqB.getView() != null && b.this.dqB.caT != null && mVar != null && mVar.Ox() != null && !StringUtils.isNull(mVar.Ox().getTid())) {
                    if (view.getId() != b.this.dqB.getView().getId()) {
                        if (b.this.dqB.abO() == null || view.getId() != b.this.dqB.abO().getId()) {
                            if (b.this.dqB.getHeaderImg() == null || view.getId() != b.this.dqB.getHeaderImg().getId()) {
                                if (b.this.dqB.abv() != null && b.this.dqB.abv().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.aco());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.aco());
                            return;
                        }
                        TiebaStatic.log(mVar.acn());
                        return;
                    }
                    TiebaStatic.log(mVar.acl());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.dqB = new com.baidu.tieba.card.m(this.mPageContext);
        this.dqB.abL();
        this.dqB.h(this.aSv);
        this.dqB.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.dqB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        if (aVar == null || aVar.acs() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.iE(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.acs().a(mVar);
        aVar.acs().a(this.aYN);
        if (mVar != null) {
            s.abU().a(mVar.acm());
        }
        aVar.acs().b(this.buV);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10732").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.abV()).r("obj_type", mVar.ack()).ac("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        ak ac = new ak("c10707").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.abV()).r("obj_type", mVar.ack()).ac("obj_id", mVar.getExtra());
        if (mVar.Ox() != null) {
            bd Ox = mVar.Ox();
            ac.r("obj_name", Ox.sO() != null && (Ox.sO().bwr() != null || Ox.sO().Jy() != null) ? 1 : 0);
            if (Ox.rx() != null) {
                ac.r("ab_type", Ox.rx().hadConcerned() ? 1 : 0);
            }
        }
        return ac;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10733").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.abV()).r("obj_type", mVar.ack()).ac("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.Ox() == null) {
            return null;
        }
        return new ak("c10706").ac(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.Ox().getFid())).ac("tid", String.valueOf(mVar.Ox().getTid())).ac("obj_param1", mVar.getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).r("obj_locate", mVar.abV()).r("obj_type", mVar.ack()).ac("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }
}
