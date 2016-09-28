package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.am;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d ccn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.ccn = dVar;
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
        dq dqVar;
        dq dqVar2;
        dq dqVar3;
        dq dqVar4;
        ArrayList arrayList;
        dh dhVar;
        boolean z;
        boolean z2;
        dh dhVar2;
        dq dqVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        dq dqVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            am page = frsHotThreadResponseCacheMessage.getPage();
            dqVar = this.ccn.cck;
            dqVar.errCode = frsHotThreadResponseCacheMessage.getError();
            dqVar2 = this.ccn.cck;
            dqVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            dqVar3 = this.ccn.cck;
            dqVar3.pn = page.qz();
            this.ccn.cci = page.qz();
            if (threadList == null || threadList.size() == 0) {
                dqVar4 = this.ccn.cck;
                dqVar4.bTB = false;
            } else {
                dqVar6 = this.ccn.cck;
                dqVar6.bTB = true;
            }
            arrayList = this.ccn.ccl;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.ccn.ccl;
                arrayList3.addAll(threadList);
            }
            dhVar = this.ccn.ccj;
            if (dhVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.ccn.bNp;
                }
                dhVar2 = this.ccn.ccj;
                dqVar5 = this.ccn.cck;
                arrayList2 = this.ccn.ccl;
                dhVar2.a(2, 0, dqVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.ccn.bNp;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.ccn.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
