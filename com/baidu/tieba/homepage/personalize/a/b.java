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
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    public BdUniqueId bGE;
    private c.a bMW;
    private v ciH;
    private com.baidu.tieba.card.m efz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMW = null;
        this.ciH = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                s.akK().dg(true);
                if (view != null && b.this.efz != null && b.this.efz.getView() != null && b.this.efz.cUE != null && mVar != null && mVar.VM() != null && !StringUtils.isNull(mVar.VM().getTid())) {
                    if (view.getId() != b.this.efz.getView().getId()) {
                        if (b.this.efz.akE() == null || view.getId() != b.this.efz.akE().getId()) {
                            if (b.this.efz.getHeaderImg() == null || view.getId() != b.this.efz.getHeaderImg().getId()) {
                                if (b.this.efz.akj() != null && b.this.efz.akj().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.all());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.all());
                            return;
                        }
                        TiebaStatic.log(mVar.alk());
                        return;
                    }
                    TiebaStatic.log(mVar.ali());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.efz = new com.baidu.tieba.card.m(this.mPageContext);
        this.efz.akB();
        this.efz.h(this.bGE);
        this.efz.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.efz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        if (aVar == null || aVar.alp() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.lH(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.alp().a(mVar);
        aVar.alp().a(this.bMW);
        if (mVar != null) {
            s.akK().a(mVar.alj());
        }
        aVar.alp().b(this.ciH);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.VM() == null) {
            return null;
        }
        return new ak("c10732").aa(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VM().getFid())).aa("tid", String.valueOf(mVar.VM().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akS()).s("obj_type", mVar.alh()).aa("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.VM() == null) {
            return null;
        }
        ak aa = new ak("c10707").aa(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VM().getFid())).aa("tid", String.valueOf(mVar.VM().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akS()).s("obj_type", mVar.alh()).aa("obj_id", mVar.getExtra());
        if (mVar.VM() != null) {
            bd VM = mVar.VM();
            aa.s("obj_name", VM.Ah() != null && (VM.Ah().bvM() != null || VM.Ah().QL() != null) ? 1 : 0);
            if (VM.yT() != null) {
                aa.s("ab_type", VM.yT().hadConcerned() ? 1 : 0);
            }
        }
        return aa;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.VM() == null) {
            return null;
        }
        return new ak("c10733").aa(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VM().getFid())).aa("tid", String.valueOf(mVar.VM().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akS()).s("obj_type", mVar.alh()).aa("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.VM() == null) {
            return null;
        }
        return new ak("c10706").aa(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VM().getFid())).aa("tid", String.valueOf(mVar.VM().getTid())).aa("obj_param1", mVar.getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.akS()).s("obj_type", mVar.alh()).aa("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }
}
