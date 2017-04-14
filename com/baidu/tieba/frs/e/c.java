package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b bYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.bYT = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        HashSet hashSet;
        HashSet hashSet2;
        if (customResponsedMessage == null) {
            return;
        }
        hashSet = this.bYT.bYR;
        if (hashSet == null) {
            return;
        }
        hashSet2 = this.bYT.bYR;
        hashSet2.clear();
    }
}
