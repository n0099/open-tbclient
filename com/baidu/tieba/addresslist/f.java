package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ AddressListActivity axz;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(AddressListActivity addressListActivity) {
        super(2001180);
        this.axz = addressListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.a.a aVar;
        int i;
        com.baidu.tieba.addresslist.a.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001180 && (customResponsedMessage instanceof ResponseUnreadPointNum)) {
            if (customResponsedMessage.getError() != 0) {
                this.axz.showToast(customResponsedMessage.getErrorString());
                return;
            }
            this.axz.axy = ((ResponseUnreadPointNum) customResponsedMessage).getNum();
            aVar = this.axz.axv;
            i = this.axz.axy;
            aVar.en(i);
            aVar2 = this.axz.axv;
            aVar2.notifyDataSetChanged();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001189));
        }
    }
}
