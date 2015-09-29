package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.n;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.baq = dVar;
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
        ee eeVar;
        ee eeVar2;
        ee eeVar3;
        ee eeVar4;
        ArrayList arrayList;
        eb ebVar;
        boolean z;
        boolean z2;
        eb ebVar2;
        ee eeVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        ee eeVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            n page = frsHotThreadResponseCacheMessage.getPage();
            eeVar = this.baq.ban;
            eeVar.errCode = frsHotThreadResponseCacheMessage.getError();
            eeVar2 = this.baq.ban;
            eeVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            eeVar3 = this.baq.ban;
            eeVar3.pn = page.rJ();
            this.baq.bal = page.rJ();
            if (threadList == null || threadList.size() == 0) {
                eeVar4 = this.baq.ban;
                eeVar4.aYQ = false;
            } else {
                eeVar6 = this.baq.ban;
                eeVar6.aYQ = true;
            }
            arrayList = this.baq.bao;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.baq.bao;
                arrayList3.addAll(threadList);
            }
            ebVar = this.baq.bam;
            if (ebVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.baq.aQZ;
                }
                ebVar2 = this.baq.bam;
                eeVar5 = this.baq.ban;
                arrayList2 = this.baq.bao;
                ebVar2.a(2, 0, eeVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.baq.aQZ;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.baq.c(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
