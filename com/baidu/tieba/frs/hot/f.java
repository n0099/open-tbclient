package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.q;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bhn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bhn = dVar;
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
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        ey eyVar4;
        ArrayList arrayList;
        eu euVar;
        boolean z;
        boolean z2;
        eu euVar2;
        ey eyVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        ey eyVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            q page = frsHotThreadResponseCacheMessage.getPage();
            eyVar = this.bhn.bhk;
            eyVar.errCode = frsHotThreadResponseCacheMessage.getError();
            eyVar2 = this.bhn.bhk;
            eyVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            eyVar3 = this.bhn.bhk;
            eyVar3.pn = page.sd();
            this.bhn.bhi = page.sd();
            if (threadList == null || threadList.size() == 0) {
                eyVar4 = this.bhn.bhk;
                eyVar4.bfs = false;
            } else {
                eyVar6 = this.bhn.bhk;
                eyVar6.bfs = true;
            }
            arrayList = this.bhn.bhl;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bhn.bhl;
                arrayList3.addAll(threadList);
            }
            euVar = this.bhn.bhj;
            if (euVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bhn.aWG;
                }
                euVar2 = this.bhn.bhj;
                eyVar5 = this.bhn.bhk;
                arrayList2 = this.bhn.bhl;
                euVar2.a(2, 0, eyVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bhn.aWG;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bhn.c(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
