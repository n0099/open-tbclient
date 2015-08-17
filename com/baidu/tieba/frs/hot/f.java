package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.p;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bad = dVar;
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
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        ArrayList arrayList;
        dc dcVar;
        boolean z;
        boolean z2;
        dc dcVar2;
        df dfVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        df dfVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            p page = frsHotThreadResponseCacheMessage.getPage();
            dfVar = this.bad.baa;
            dfVar.errCode = frsHotThreadResponseCacheMessage.getError();
            dfVar2 = this.bad.baa;
            dfVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            dfVar3 = this.bad.baa;
            dfVar3.pn = page.rR();
            this.bad.aZY = page.rR();
            if (threadList == null || threadList.size() == 0) {
                dfVar4 = this.bad.baa;
                dfVar4.aYJ = false;
            } else {
                dfVar6 = this.bad.baa;
                dfVar6.aYJ = true;
            }
            arrayList = this.bad.bab;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bad.bab;
                arrayList3.addAll(threadList);
            }
            dcVar = this.bad.aZZ;
            if (dcVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bad.aRP;
                }
                dcVar2 = this.bad.aZZ;
                dfVar5 = this.bad.baa;
                arrayList2 = this.bad.bab;
                dcVar2.a(2, 0, dfVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bad.aRP;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bad.a(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
