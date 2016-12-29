package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.an;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bLt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bLt = dVar;
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
        co coVar;
        co coVar2;
        co coVar3;
        co coVar4;
        ArrayList arrayList;
        ce ceVar;
        boolean z;
        boolean z2;
        ce ceVar2;
        co coVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        co coVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            an page = frsHotThreadResponseCacheMessage.getPage();
            coVar = this.bLt.bLq;
            coVar.errCode = frsHotThreadResponseCacheMessage.getError();
            coVar2 = this.bLt.bLq;
            coVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            coVar3 = this.bLt.bLq;
            coVar3.pn = page.qC();
            this.bLt.bLo = page.qC();
            if (threadList == null || threadList.size() == 0) {
                coVar4 = this.bLt.bLq;
                coVar4.bBT = false;
            } else {
                coVar6 = this.bLt.bLq;
                coVar6.bBT = true;
            }
            arrayList = this.bLt.bLr;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bLt.bLr;
                arrayList3.addAll(threadList);
            }
            ceVar = this.bLt.bLp;
            if (ceVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bLt.bwm;
                }
                ceVar2 = this.bLt.bLp;
                coVar5 = this.bLt.bLq;
                arrayList2 = this.bLt.bLr;
                ceVar2.a(2, 0, coVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bLt.bwm;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bLt.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
