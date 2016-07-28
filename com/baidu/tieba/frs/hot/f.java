package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bRc = dVar;
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
        dv dvVar;
        dv dvVar2;
        dv dvVar3;
        dv dvVar4;
        ArrayList arrayList;
        dm dmVar;
        boolean z;
        boolean z2;
        dm dmVar2;
        dv dvVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        dv dvVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            aj page = frsHotThreadResponseCacheMessage.getPage();
            dvVar = this.bRc.bQZ;
            dvVar.errCode = frsHotThreadResponseCacheMessage.getError();
            dvVar2 = this.bRc.bQZ;
            dvVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            dvVar3 = this.bRc.bQZ;
            dvVar3.pn = page.pl();
            this.bRc.bQX = page.pl();
            if (threadList == null || threadList.size() == 0) {
                dvVar4 = this.bRc.bQZ;
                dvVar4.bIG = false;
            } else {
                dvVar6 = this.bRc.bQZ;
                dvVar6.bIG = true;
            }
            arrayList = this.bRc.bRa;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bRc.bRa;
                arrayList3.addAll(threadList);
            }
            dmVar = this.bRc.bQY;
            if (dmVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bRc.bBP;
                }
                dmVar2 = this.bRc.bQY;
                dvVar5 = this.bRc.bQZ;
                arrayList2 = this.bRc.bRa;
                dmVar2.a(2, 0, dvVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bRc.bBP;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bRc.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
