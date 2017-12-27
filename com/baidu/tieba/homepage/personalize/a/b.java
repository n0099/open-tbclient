package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m>> {
    public BdUniqueId bGo;
    private c.a bMG;
    private v cis;
    private com.baidu.tieba.card.m edQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.cis = new v<m>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, m mVar) {
                s.ajC().df(true);
                if (view != null && b.this.edQ != null && b.this.edQ.getView() != null && b.this.edQ.cPH != null && mVar != null && mVar.VW() != null && !StringUtils.isNull(mVar.VW().getTid())) {
                    if (view.getId() != b.this.edQ.getView().getId()) {
                        if (b.this.edQ.ajw() == null || view.getId() != b.this.edQ.ajw().getId()) {
                            if (b.this.edQ.getHeaderImg() == null || view.getId() != b.this.edQ.getHeaderImg().getId()) {
                                if (b.this.edQ.ajb() != null && b.this.edQ.ajb().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.akd());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(mVar.akd());
                            return;
                        }
                        TiebaStatic.log(mVar.akc());
                        return;
                    }
                    TiebaStatic.log(mVar.aka());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.edQ = new com.baidu.tieba.card.m(this.mPageContext);
        this.edQ.ajt();
        this.edQ.h(this.bGo);
        this.edQ.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.edQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.m> aVar) {
        if (aVar == null || aVar.akh() == null) {
            return null;
        }
        if (mVar != null) {
            mVar.lE(i + 1);
            mVar.b(b(mVar));
            mVar.c(c(mVar));
            mVar.d(e(mVar));
            mVar.e(d(mVar));
        }
        aVar.akh().a(mVar);
        aVar.akh().a(this.bMG);
        if (mVar != null) {
            s.ajC().a(mVar.akb());
        }
        aVar.akh().b(this.cis);
        return aVar.getView();
    }

    private ak b(m mVar) {
        if (mVar == null || mVar.VW() == null) {
            return null;
        }
        return new ak("c10732").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VW().getFid())).ab("tid", String.valueOf(mVar.VW().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.ajK()).s("obj_type", mVar.ajZ()).ab("obj_id", mVar.getExtra());
    }

    private ak c(m mVar) {
        if (mVar == null || mVar.VW() == null) {
            return null;
        }
        ak ab = new ak("c10707").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VW().getFid())).ab("tid", String.valueOf(mVar.VW().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.ajK()).s("obj_type", mVar.ajZ()).ab("obj_id", mVar.getExtra());
        if (mVar.VW() != null) {
            be VW = mVar.VW();
            ab.s("obj_name", VW.Ao() != null && (VW.Ao().bCo() != null || VW.Ao().QV() != null) ? 1 : 0);
            if (VW.yX() != null) {
                ab.s("ab_type", VW.yX().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    private ak d(m mVar) {
        if (mVar == null || mVar.VW() == null) {
            return null;
        }
        return new ak("c10733").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VW().getFid())).ab("tid", String.valueOf(mVar.VW().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.ajK()).s("obj_type", mVar.ajZ()).ab("obj_id", mVar.getExtra());
    }

    private ak e(m mVar) {
        if (mVar == null || mVar.VW() == null) {
            return null;
        }
        return new ak("c10706").ab(ImageViewerConfig.FORUM_ID, String.valueOf(mVar.VW().getFid())).ab("tid", String.valueOf(mVar.VW().getTid())).ab("obj_param1", mVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, mVar.getSource()).s("obj_locate", mVar.ajK()).s("obj_type", mVar.ajZ()).ab("obj_id", mVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }
}
