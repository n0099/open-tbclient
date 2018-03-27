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
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> {
    public BdUniqueId bIy;
    private c.a bOT;
    private v clO;
    private com.baidu.tieba.card.l ejP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOT = null;
        this.clO = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                r.alt().dk(true);
                if (view != null && b.this.ejP != null && b.this.ejP.getView() != null && b.this.ejP.cXe != null && lVar != null && lVar.WE() != null && !StringUtils.isNull(lVar.WE().getTid())) {
                    if (view.getId() != b.this.ejP.getView().getId()) {
                        if (b.this.ejP.aln() == null || view.getId() != b.this.ejP.aln().getId()) {
                            if (b.this.ejP.getHeaderImg() == null || view.getId() != b.this.ejP.getHeaderImg().getId()) {
                                if (b.this.ejP.akS() != null && b.this.ejP.akS().getId() == view.getId()) {
                                    TiebaStatic.log(lVar.alU());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.alU());
                            return;
                        }
                        TiebaStatic.log(lVar.alT());
                        return;
                    }
                    TiebaStatic.log(lVar.alR());
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        this.ejP = new com.baidu.tieba.card.l(this.mPageContext);
        this.ejP.alk();
        this.ejP.h(this.bIy);
        this.ejP.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.ejP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (aVar == null || aVar.alY() == null) {
            return null;
        }
        if (lVar != null) {
            lVar.lD(i + 1);
            lVar.b(b(lVar));
            lVar.c(c(lVar));
            lVar.d(e(lVar));
            lVar.e(d(lVar));
        }
        aVar.alY().a(lVar);
        aVar.alY().a(this.bOT);
        if (lVar != null) {
            r.alt().a(lVar.alS());
        }
        aVar.alY().b(this.clO);
        return aVar.getView();
    }

    private ak b(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WE() == null) {
            return null;
        }
        return new ak("c10732").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WE().getFid())).ab("tid", String.valueOf(lVar.WE().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alB()).s("obj_type", lVar.alQ()).ab("obj_id", lVar.getExtra());
    }

    private ak c(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WE() == null) {
            return null;
        }
        ak ab = new ak("c10707").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WE().getFid())).ab("tid", String.valueOf(lVar.WE().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alB()).s("obj_type", lVar.alQ()).ab("obj_id", lVar.getExtra());
        if (lVar.WE() != null) {
            bd WE = lVar.WE();
            ab.s("obj_name", WE.AA() != null && (WE.AA().bxb() != null || WE.AA().Rq() != null) ? 1 : 0);
            if (WE.zn() != null) {
                ab.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    private ak d(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WE() == null) {
            return null;
        }
        return new ak("c10733").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WE().getFid())).ab("tid", String.valueOf(lVar.WE().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alB()).s("obj_type", lVar.alQ()).ab("obj_id", lVar.getExtra());
    }

    private ak e(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WE() == null) {
            return null;
        }
        return new ak("c10706").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WE().getFid())).ab("tid", String.valueOf(lVar.WE().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alB()).s("obj_type", lVar.alQ()).ab("obj_id", lVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.bOT = aVar;
    }
}
