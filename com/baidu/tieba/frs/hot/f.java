package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bob = dVar;
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
        fi fiVar;
        fi fiVar2;
        fi fiVar3;
        fi fiVar4;
        ArrayList arrayList;
        ff ffVar;
        boolean z;
        boolean z2;
        ff ffVar2;
        fi fiVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        fi fiVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            com.baidu.tbadk.core.data.u page = frsHotThreadResponseCacheMessage.getPage();
            fiVar = this.bob.bnY;
            fiVar.errCode = frsHotThreadResponseCacheMessage.getError();
            fiVar2 = this.bob.bnY;
            fiVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            fiVar3 = this.bob.bnY;
            fiVar3.pn = page.st();
            this.bob.bnW = page.st();
            if (threadList == null || threadList.size() == 0) {
                fiVar4 = this.bob.bnY;
                fiVar4.bmf = false;
            } else {
                fiVar6 = this.bob.bnY;
                fiVar6.bmf = true;
            }
            arrayList = this.bob.bnZ;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bob.bnZ;
                arrayList3.addAll(threadList);
            }
            ffVar = this.bob.bnX;
            if (ffVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bob.bcS;
                }
                ffVar2 = this.bob.bnX;
                fiVar5 = this.bob.bnY;
                arrayList2 = this.bob.bnZ;
                ffVar2.a(2, 0, fiVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bob.bcS;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bob.c(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
