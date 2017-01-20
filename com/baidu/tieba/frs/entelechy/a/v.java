package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends cf<CardHListViewData> {
    final /* synthetic */ u bLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bLJ = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, CardHListViewData cardHListViewData, Object obj) {
        TbPageContext tbPageContext;
        Context context;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        tbPageContext = this.bLJ.FY;
        if (tbPageContext != null) {
            if (view.getId() == r.h.hlistview_item_layout_root) {
                if (obj instanceof CardHListViewNormalItemData) {
                    CardHListViewNormalItemData cardHListViewNormalItemData = (CardHListViewNormalItemData) obj;
                    String valueOf = String.valueOf(cardHListViewNormalItemData.threadId);
                    tbPageContext3 = this.bLJ.FY;
                    PbActivityConfig createNormalCfg = new PbActivityConfig(tbPageContext3.getPageActivity()).createNormalCfg(valueOf, null, null);
                    tbPageContext4 = this.bLJ.FY;
                    tbPageContext4.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    u.aW(cardHListViewNormalItemData.threadId);
                }
            } else if (view.getId() == r.h.fourm_name && (obj instanceof CardHListViewNormalItemData)) {
                String valueOf2 = String.valueOf(((CardHListViewNormalItemData) obj).forumName);
                context = this.bLJ.mContext;
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(context).createNormalCfg(valueOf2, "tb_frslist");
                tbPageContext2 = this.bLJ.FY;
                tbPageContext2.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            }
        }
    }
}
