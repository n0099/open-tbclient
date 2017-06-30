package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends ci<CardHListViewData> {
    final /* synthetic */ r cgN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.cgN = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, CardHListViewData cardHListViewData, Object obj) {
        TbPageContext tbPageContext;
        Context context;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        tbPageContext = this.cgN.ajP;
        if (tbPageContext != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (obj instanceof CardHListViewNormalItemData) {
                    CardHListViewNormalItemData cardHListViewNormalItemData = (CardHListViewNormalItemData) obj;
                    String valueOf = String.valueOf(cardHListViewNormalItemData.threadId);
                    tbPageContext3 = this.cgN.ajP;
                    PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(valueOf, null, null);
                    createNormalCfg.setForumId(String.valueOf(cardHListViewNormalItemData.forumId));
                    createNormalCfg.setStartFrom(1);
                    tbPageContext4 = this.cgN.ajP;
                    tbPageContext4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    r.bh(cardHListViewNormalItemData.threadId);
                }
            } else if (view.getId() == w.h.fourm_name && (obj instanceof CardHListViewNormalItemData)) {
                String valueOf2 = String.valueOf(((CardHListViewNormalItemData) obj).forumName);
                context = this.cgN.mContext;
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(valueOf2, "tb_frslist");
                tbPageContext2 = this.cgN.ajP;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            }
        }
    }
}
