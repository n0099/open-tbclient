package com.baidu.tieba.frs.e;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p cgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.cgJ = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk)) {
            bk bkVar = (bk) customResponsedMessage.getData();
            this.cgJ.ccp = bkVar.getId();
            str = this.cgJ.ccp;
            if (!TextUtils.isEmpty(str) && bkVar.rH() != null) {
                this.cgJ.im(bkVar.rH().getIsLike());
            }
        }
    }
}
