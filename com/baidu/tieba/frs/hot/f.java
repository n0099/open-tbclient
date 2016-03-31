package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bsY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bsY = dVar;
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
        fr frVar;
        fr frVar2;
        fr frVar3;
        fr frVar4;
        ArrayList arrayList;
        fp fpVar;
        boolean z;
        boolean z2;
        fp fpVar2;
        fr frVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        fr frVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            ac page = frsHotThreadResponseCacheMessage.getPage();
            frVar = this.bsY.bsV;
            frVar.errCode = frsHotThreadResponseCacheMessage.getError();
            frVar2 = this.bsY.bsV;
            frVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            frVar3 = this.bsY.bsV;
            frVar3.pn = page.so();
            this.bsY.bsT = page.so();
            if (threadList == null || threadList.size() == 0) {
                frVar4 = this.bsY.bsV;
                frVar4.bru = false;
            } else {
                frVar6 = this.bsY.bsV;
                frVar6.bru = true;
            }
            arrayList = this.bsY.bsW;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bsY.bsW;
                arrayList3.addAll(threadList);
            }
            fpVar = this.bsY.bsU;
            if (fpVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bsY.bhD;
                }
                fpVar2 = this.bsY.bsU;
                frVar5 = this.bsY.bsV;
                arrayList2 = this.bsY.bsW;
                fpVar2.a(2, 0, frVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bsY.bhD;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bsY.c(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
