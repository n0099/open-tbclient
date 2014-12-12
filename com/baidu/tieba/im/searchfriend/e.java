package com.baidu.tieba.im.searchfriend;

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
    final /* synthetic */ SearchFriendActivity bmC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SearchFriendActivity searchFriendActivity, int i) {
        super(i);
        this.bmC = searchFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ArrayList arrayList;
        SearchFriendResult.UserInfo userInfo;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ArrayList) && (arrayList = (ArrayList) customResponsedMessage.getData()) != null && arrayList.size() != 0 && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
            CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
            if ((customMessage.getData() instanceof SearchFriendResult.UserInfo) && (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof com.baidu.tbadk.coreExtra.relationship.b) && userInfo.getUserId() == ((com.baidu.tbadk.coreExtra.relationship.b) next).getUserId()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.bmC.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                        return;
                    }
                }
                this.bmC.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.bmC.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, AddFriendActivityConfig.TYPE_SEARCH)));
            }
        }
    }
}
