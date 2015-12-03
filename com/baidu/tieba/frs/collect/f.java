package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.z;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MyCollectFrsActivity myCollectFrsActivity, int i) {
        super(i);
        this.bgk = myCollectFrsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof z)) {
            z zVar = (z) customResponsedMessage.getData();
            this.bgk.aXW = zVar.getId();
            str = this.bgk.aXW;
            if (TextUtils.isEmpty(str) || zVar.getPraise() == null) {
                return;
            }
            this.bgk.fU(zVar.getPraise().getIsLike());
        }
    }
}
