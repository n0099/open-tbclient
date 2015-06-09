package com.baidu.tieba.addresslist.im.searchfriend;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.data.SearchFriendResult;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ SearchFriendActivity aAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.aAR = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SearchFriendResult.UserInfo userInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ArrayList) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
            CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
            if ((customMessage.getData() instanceof SearchFriendResult.UserInfo) && (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) != null) {
                ArrayList arrayList = (ArrayList) customResponsedMessage.getData();
                if (arrayList == null || arrayList.size() == 0) {
                    this.aAR.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aAR.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, AddFriendActivityConfig.TYPE_SEARCH)));
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof com.baidu.tbadk.coreExtra.relationship.a) && userInfo.getUserId() == ((com.baidu.tbadk.coreExtra.relationship.a) next).getUserId()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aAR.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                        return;
                    }
                }
                this.aAR.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.aAR.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, AddFriendActivityConfig.TYPE_SEARCH)));
            }
        }
    }
}
