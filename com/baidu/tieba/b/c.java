package com.baidu.tieba.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.a, com.baidu.tbadk.l.a> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public com.baidu.tbadk.l.a b(ViewGroup viewGroup) {
        return new com.baidu.tbadk.l.a(LayoutInflater.from(this.mContext).inflate(R.layout.ala_follow_live_common_item_view, viewGroup, false), this.mPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.a aVar, com.baidu.tbadk.l.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar2.a(i, aVar);
            a(aVar2, aVar);
        }
        return view;
    }

    private void a(com.baidu.tbadk.l.a aVar, final com.baidu.tbadk.data.a aVar2) {
        aVar.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar2.cDK == -100) {
                    TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_SQUARE_ITEM_CLICK);
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_GET_LIVE_FORUM_URL, String.class);
                    if (runTask == null || StringUtils.isNull((String) runTask.getData())) {
                        com.baidu.tbadk.core.f.b.b(c.this.mPageContext.getPageActivity(), 15, true);
                        return;
                    } else {
                        ba.amQ().a(c.this.mPageContext, new String[]{(String) runTask.getData()}, true);
                        return;
                    }
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = aVar2.cDJ;
                if (alaLiveInfoCoreData != null) {
                    TiebaStatic.log(TbadkCoreStatisticKey.ALA_FOLLOW_LIVE_LIVE_ITEM_CLICK);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(c.this.mPageContext.getPageActivity(), alaLiveInfoCoreData, "ala_concern_tab_top_live", TbadkCoreApplication.getCurrentAccount(), false, "")));
                }
            }
        });
    }
}
