package com.baidu.tieba.frs.mc;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ s bYt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.bYt = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bi)) {
            bi biVar = (bi) customResponsedMessage.getData();
            this.bYt.bVg = biVar.getId();
            str = this.bYt.bVg;
            if (!TextUtils.isEmpty(str) && biVar.se() != null) {
                this.bYt.ii(biVar.se().getIsLike());
            }
        }
    }
}
