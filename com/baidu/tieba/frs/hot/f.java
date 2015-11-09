package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d baV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.baV = dVar;
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
        eg egVar;
        eg egVar2;
        eg egVar3;
        eg egVar4;
        ArrayList arrayList;
        ed edVar;
        boolean z;
        boolean z2;
        ed edVar2;
        eg egVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        eg egVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            o page = frsHotThreadResponseCacheMessage.getPage();
            egVar = this.baV.baS;
            egVar.errCode = frsHotThreadResponseCacheMessage.getError();
            egVar2 = this.baV.baS;
            egVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            egVar3 = this.baV.baS;
            egVar3.pn = page.rI();
            this.baV.baQ = page.rI();
            if (threadList == null || threadList.size() == 0) {
                egVar4 = this.baV.baS;
                egVar4.aZn = false;
            } else {
                egVar6 = this.baV.baS;
                egVar6.aZn = true;
            }
            arrayList = this.baV.baT;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.baV.baT;
                arrayList3.addAll(threadList);
            }
            edVar = this.baV.baR;
            if (edVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.baV.aRs;
                }
                edVar2 = this.baV.baR;
                egVar5 = this.baV.baS;
                arrayList2 = this.baV.baT;
                edVar2.a(2, 0, egVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.baV.aRs;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.baV.a(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
