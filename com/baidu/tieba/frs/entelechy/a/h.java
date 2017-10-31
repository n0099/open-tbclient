package com.baidu.tieba.frs.entelechy.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.frs.d<CardHListViewData, com.baidu.tieba.card.a.a<com.baidu.tieba.card.h>> implements v, com.baidu.tieba.frs.e.c {
    private x cEb;
    private String mForumName;

    public static void bh(long j) {
        if (j > 0 && cPd != null && !TextUtils.isEmpty(cPd.cOV)) {
            ak akVar = new ak("c11958");
            akVar.f("tid", j);
            akVar.ac(ImageViewerConfig.FORUM_ID, cPd.cOV);
            TiebaStatic.log(akVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.cEb = new x<CardHListViewData>() { // from class: com.baidu.tieba.frs.entelechy.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, CardHListViewData cardHListViewData, Object obj) {
                if (h.this.mPageContext != null) {
                    if (view.getId() == d.g.hlistview_item_layout_root) {
                        if (obj instanceof CardHListViewNormalItemData) {
                            CardHListViewNormalItemData cardHListViewNormalItemData = (CardHListViewNormalItemData) obj;
                            PbActivityConfig createNormalCfg = new PbActivityConfig(h.this.mPageContext.getPageActivity()).createNormalCfg(String.valueOf(cardHListViewNormalItemData.threadId), null, "frs_page");
                            createNormalCfg.setForumId(String.valueOf(cardHListViewNormalItemData.forumId));
                            createNormalCfg.setStartFrom(1);
                            h.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            h.bh(cardHListViewNormalItemData.threadId);
                        }
                    } else if (view.getId() == d.g.fourm_name && (obj instanceof CardHListViewNormalItemData)) {
                        h.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(h.this.mContext).createNormalCfg(String.valueOf(((CardHListViewNormalItemData) obj).forumName), FrsActivityConfig.FRS_TO_PB)));
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tieba.card.a.a(new com.baidu.tieba.card.h(this.mPageContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.d, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewData cardHListViewData, com.baidu.tieba.card.a.a aVar) {
        if (aVar == null || aVar.aax() == null) {
            return null;
        }
        aVar.aax().a((com.baidu.tieba.card.a) cardHListViewData);
        aVar.aax().b(this.cEb);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.card.v
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
