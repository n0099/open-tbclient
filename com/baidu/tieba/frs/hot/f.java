package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cp;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d cfK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.cfK = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r0 == false) goto L21;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cp cpVar;
        cp cpVar2;
        cp cpVar3;
        cp cpVar4;
        ArrayList arrayList;
        cf cfVar;
        boolean z;
        boolean z2;
        cf cfVar2;
        cp cpVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        cp cpVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            ao page = frsHotThreadResponseCacheMessage.getPage();
            cpVar = this.cfK.cfH;
            cpVar.errCode = frsHotThreadResponseCacheMessage.getError();
            cpVar2 = this.cfK.cfH;
            cpVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            cpVar3 = this.cfK.cfH;
            cpVar3.pn = page.qB();
            this.cfK.cfF = page.qB();
            if (threadList == null || threadList.size() == 0) {
                cpVar4 = this.cfK.cfH;
                cpVar4.bVL = false;
            } else {
                cpVar6 = this.cfK.cfH;
                cpVar6.bVL = true;
            }
            arrayList = this.cfK.cfI;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.cfK.cfI;
                arrayList3.addAll(threadList);
            }
            cfVar = this.cfK.cfG;
            if (cfVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.cfK.bQi;
                }
                cfVar2 = this.cfK.cfG;
                cpVar5 = this.cfK.cfH;
                arrayList2 = this.cfK.cfI;
                cfVar2.a(2, 0, cpVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.cfK.bQi;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.cfK.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
