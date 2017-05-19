package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends cd<CardHListViewData> {
    final /* synthetic */ u bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bSO = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, CardHListViewData cardHListViewData, Object obj) {
        TbPageContext tbPageContext;
        Context context;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        tbPageContext = this.bSO.ajr;
        if (tbPageContext != null) {
            if (view.getId() == w.h.hlistview_item_layout_root) {
                if (obj instanceof CardHListViewNormalItemData) {
                    CardHListViewNormalItemData cardHListViewNormalItemData = (CardHListViewNormalItemData) obj;
                    String valueOf = String.valueOf(cardHListViewNormalItemData.threadId);
                    tbPageContext3 = this.bSO.ajr;
                    PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(valueOf, null, null);
                    createNormalCfg.setForumId(String.valueOf(cardHListViewNormalItemData.forumId));
                    createNormalCfg.setStartFrom(1);
                    tbPageContext4 = this.bSO.ajr;
                    tbPageContext4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    u.aQ(cardHListViewNormalItemData.threadId);
                }
            } else if (view.getId() == w.h.fourm_name && (obj instanceof CardHListViewNormalItemData)) {
                String valueOf2 = String.valueOf(((CardHListViewNormalItemData) obj).forumName);
                context = this.bSO.mContext;
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(valueOf2, "tb_frslist");
                tbPageContext2 = this.bSO.ajr;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            }
        }
    }
}
