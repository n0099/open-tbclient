package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bRJ = dVar;
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
        cm cmVar;
        cm cmVar2;
        cm cmVar3;
        cm cmVar4;
        ArrayList arrayList;
        cc ccVar;
        boolean z;
        boolean z2;
        cc ccVar2;
        cm cmVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        cm cmVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            ao page = frsHotThreadResponseCacheMessage.getPage();
            cmVar = this.bRJ.bRG;
            cmVar.errCode = frsHotThreadResponseCacheMessage.getError();
            cmVar2 = this.bRJ.bRG;
            cmVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            cmVar3 = this.bRJ.bRG;
            cmVar3.pn = page.qv();
            this.bRJ.mCurrentPage = page.qv();
            if (threadList == null || threadList.size() == 0) {
                cmVar4 = this.bRJ.bRG;
                cmVar4.bJl = false;
            } else {
                cmVar6 = this.bRJ.bRG;
                cmVar6.bJl = true;
            }
            arrayList = this.bRJ.bRH;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bRJ.bRH;
                arrayList3.addAll(threadList);
            }
            ccVar = this.bRJ.aUE;
            if (ccVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bRJ.bDQ;
                }
                ccVar2 = this.bRJ.aUE;
                cmVar5 = this.bRJ.bRG;
                arrayList2 = this.bRJ.bRH;
                ccVar2.a(2, 0, cmVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bRJ.bDQ;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bRJ.b(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
