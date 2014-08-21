package com.baidu.tieba.im.live.livelist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.am;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.coreExtra.view.ad {
    final /* synthetic */ HotLiveListAdapter a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(HotLiveListAdapter hotLiveListAdapter) {
        this.a = hotLiveListAdapter;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ad
    public void onClick(LiveBroadcastCard liveBroadcastCard) {
        HotLiveListActivity hotLiveListActivity;
        HotLiveListActivity hotLiveListActivity2;
        HotLiveListActivity hotLiveListActivity3;
        HotLiveListActivity hotLiveListActivity4;
        Object tag = liveBroadcastCard.getTag();
        if (tag instanceof LiveCardData) {
            LiveCardData liveCardData = (LiveCardData) tag;
            hotLiveListActivity = this.a.a;
            if (hotLiveListActivity != null) {
                hotLiveListActivity2 = this.a.a;
                if (hotLiveListActivity2.g().c() == 2) {
                    MessageManager messageManager = MessageManager.getInstance();
                    hotLiveListActivity4 = this.a.a;
                    messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.aj(hotLiveListActivity4, new StringBuilder(String.valueOf(liveCardData.getGroupId())).toString())));
                    return;
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                hotLiveListActivity3 = this.a.a;
                messageManager2.sendMessage(new CustomMessage(2002001, new am(hotLiveListActivity3, liveCardData.getGroupId())));
            }
        }
    }
}
