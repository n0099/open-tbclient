package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.cfj = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        HashSet hashSet;
        HashSet hashSet2;
        if (customResponsedMessage == null) {
            return;
        }
        hashSet = this.cfj.cfh;
        if (hashSet == null) {
            return;
        }
        hashSet2 = this.cfj.cfh;
        hashSet2.clear();
    }
}
