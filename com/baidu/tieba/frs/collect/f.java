package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ah;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MyCollectFrsActivity myCollectFrsActivity, int i) {
        super(i);
        this.bmY = myCollectFrsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ah)) {
            ah ahVar = (ah) customResponsedMessage.getData();
            this.bmY.beh = ahVar.getId();
            str = this.bmY.beh;
            if (TextUtils.isEmpty(str) || ahVar.getPraise() == null) {
                return;
            }
            this.bmY.gl(ahVar.getPraise().getIsLike());
        }
    }
}
