package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.af;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bPp = dVar;
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
            af page = frsHotThreadResponseCacheMessage.getPage();
            dvVar = this.bPp.bPm;
            dvVar.errCode = frsHotThreadResponseCacheMessage.getError();
            dvVar2 = this.bPp.bPm;
            dvVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            dvVar3 = this.bPp.bPm;
            dvVar3.pn = page.pC();
            this.bPp.bPk = page.pC();
            if (threadList == null || threadList.size() == 0) {
                dvVar4 = this.bPp.bPm;
                dvVar4.bHk = false;
            } else {
                dvVar6 = this.bPp.bPm;
                dvVar6.bHk = true;
            }
            arrayList = this.bPp.bPn;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bPp.bPn;
                arrayList3.addAll(threadList);
            }
            dmVar = this.bPp.bPl;
            if (dmVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bPp.bzB;
                }
                dmVar2 = this.bPp.bPl;
                dvVar5 = this.bPp.bPm;
                arrayList2 = this.bPp.bPn;
                dmVar2.a(2, 0, dvVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bPp.bzB;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bPp.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
