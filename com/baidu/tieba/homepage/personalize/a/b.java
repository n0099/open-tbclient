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
    public BdUniqueId bIv;
    private c.a bOQ;
    private v clL;
    private com.baidu.tieba.card.l ejz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bOQ = null;
        this.clL = new v<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                r.als().dk(true);
                if (view != null && b.this.ejz != null && b.this.ejz.getView() != null && b.this.ejz.cXb != null && lVar != null && lVar.WD() != null && !StringUtils.isNull(lVar.WD().getTid())) {
                    if (view.getId() != b.this.ejz.getView().getId()) {
                        if (b.this.ejz.alm() == null || view.getId() != b.this.ejz.alm().getId()) {
                            if (b.this.ejz.getHeaderImg() == null || view.getId() != b.this.ejz.getHeaderImg().getId()) {
                                if (b.this.ejz.akR() != null && b.this.ejz.akR().getId() == view.getId()) {
                                    TiebaStatic.log(lVar.alT());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.alT());
                            return;
                        }
                        TiebaStatic.log(lVar.alS());
                        return;
                    }
                    TiebaStatic.log(lVar.alQ());
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
        this.ejz = new com.baidu.tieba.card.l(this.mPageContext);
        this.ejz.alj();
        this.ejz.h(this.bIv);
        this.ejz.currentPageType = 2;
        return new com.baidu.tieba.card.a.a(this.ejz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (aVar == null || aVar.alX() == null) {
            return null;
        }
        if (lVar != null) {
            lVar.lD(i + 1);
            lVar.b(b(lVar));
            lVar.c(c(lVar));
            lVar.d(e(lVar));
            lVar.e(d(lVar));
        }
        aVar.alX().a(lVar);
        aVar.alX().a(this.bOQ);
        if (lVar != null) {
            r.als().a(lVar.alR());
        }
        aVar.alX().b(this.clL);
        return aVar.getView();
    }

    private ak b(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WD() == null) {
            return null;
        }
        return new ak("c10732").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WD().getFid())).ab("tid", String.valueOf(lVar.WD().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alA()).s("obj_type", lVar.alP()).ab("obj_id", lVar.getExtra());
    }

    private ak c(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WD() == null) {
            return null;
        }
        ak ab = new ak("c10707").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WD().getFid())).ab("tid", String.valueOf(lVar.WD().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alA()).s("obj_type", lVar.alP()).ab("obj_id", lVar.getExtra());
        if (lVar.WD() != null) {
            bd WD = lVar.WD();
            ab.s("obj_name", WD.AA() != null && (WD.AA().bwW() != null || WD.AA().Rp() != null) ? 1 : 0);
            if (WD.zn() != null) {
                ab.s("ab_type", WD.zn().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    private ak d(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WD() == null) {
            return null;
        }
        return new ak("c10733").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WD().getFid())).ab("tid", String.valueOf(lVar.WD().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alA()).s("obj_type", lVar.alP()).ab("obj_id", lVar.getExtra());
    }

    private ak e(com.baidu.tieba.card.data.l lVar) {
        if (lVar == null || lVar.WD() == null) {
            return null;
        }
        return new ak("c10706").ab(ImageViewerConfig.FORUM_ID, String.valueOf(lVar.WD().getFid())).ab("tid", String.valueOf(lVar.WD().getTid())).ab("obj_param1", lVar.getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, lVar.getSource()).s("obj_locate", lVar.alA()).s("obj_type", lVar.alP()).ab("obj_id", lVar.getExtra());
    }

    public void setEventCallback(c.a aVar) {
        this.bOQ = aVar;
    }
}
