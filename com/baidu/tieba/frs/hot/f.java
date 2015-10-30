package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.baC = dVar;
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
            o page = frsHotThreadResponseCacheMessage.getPage();
            eeVar = this.baC.baz;
            eeVar.errCode = frsHotThreadResponseCacheMessage.getError();
            eeVar2 = this.baC.baz;
            eeVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            eeVar3 = this.baC.baz;
            eeVar3.pn = page.rG();
            this.baC.bax = page.rG();
            if (threadList == null || threadList.size() == 0) {
                eeVar4 = this.baC.baz;
                eeVar4.aZb = false;
            } else {
                eeVar6 = this.baC.baz;
                eeVar6.aZb = true;
            }
            arrayList = this.baC.baA;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.baC.baA;
                arrayList3.addAll(threadList);
            }
            ebVar = this.baC.bay;
            if (ebVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.baC.aRk;
                }
                ebVar2 = this.baC.bay;
                eeVar5 = this.baC.baz;
                arrayList2 = this.baC.baA;
                ebVar2.a(2, 0, eeVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.baC.aRk;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.baC.a(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
