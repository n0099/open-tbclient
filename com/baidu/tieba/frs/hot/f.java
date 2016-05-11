package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d brM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.brM = dVar;
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
        fq fqVar;
        fq fqVar2;
        fq fqVar3;
        fq fqVar4;
        ArrayList arrayList;
        fi fiVar;
        boolean z;
        boolean z2;
        fi fiVar2;
        fq fqVar5;
        ArrayList<v> arrayList2;
        ArrayList arrayList3;
        fq fqVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<v> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            ad page = frsHotThreadResponseCacheMessage.getPage();
            fqVar = this.brM.brJ;
            fqVar.errCode = frsHotThreadResponseCacheMessage.getError();
            fqVar2 = this.brM.brJ;
            fqVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            fqVar3 = this.brM.brJ;
            fqVar3.pn = page.pI();
            this.brM.brH = page.pI();
            if (threadList == null || threadList.size() == 0) {
                fqVar4 = this.brM.brJ;
                fqVar4.bmV = false;
            } else {
                fqVar6 = this.brM.brJ;
                fqVar6.bmV = true;
            }
            arrayList = this.brM.brK;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.brM.brK;
                arrayList3.addAll(threadList);
            }
            fiVar = this.brM.brI;
            if (fiVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.brM.bdy;
                }
                fiVar2 = this.brM.brI;
                fqVar5 = this.brM.brJ;
                arrayList2 = this.brM.brK;
                fiVar2.a(2, 0, fqVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.brM.bdy;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.brM.b(com.baidu.adp.lib.h.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
