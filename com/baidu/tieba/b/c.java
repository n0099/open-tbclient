package com.baidu.tieba.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.data.a, com.baidu.tbadk.i.a> {
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: j */
    public com.baidu.tbadk.i.a onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.i.a(LayoutInflater.from(this.mContext).inflate(d.i.ala_follow_live_common_item_view, viewGroup, false), this.mPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.data.a aVar, com.baidu.tbadk.i.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar2.a(i, aVar);
            a(aVar2, aVar);
        }
        return view;
    }

    private void a(com.baidu.tbadk.i.a aVar, final com.baidu.tbadk.data.a aVar2) {
        aVar.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.b.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar2.aJB == -100) {
                    TiebaStatic.log("c12679");
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask == null || StringUtils.isNull((String) runTask.getData())) {
                        com.baidu.tbadk.core.e.b.b(c.this.mPageContext.getPageActivity(), 15, true);
                        return;
                    } else {
                        ay.zG().a(c.this.mPageContext, new String[]{(String) runTask.getData()}, true);
                        return;
                    }
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = aVar2.aJA;
                if (alaLiveInfoCoreData != null) {
                    TiebaStatic.log("c12677");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(c.this.mPageContext.getPageActivity(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_CONCERN_TAB_TOP_LIVE, TbadkCoreApplication.getCurrentAccount(), false, "")));
                }
            }
        });
    }
}
