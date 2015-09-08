package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ d bay;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, int i) {
        super(i);
        this.bay = dVar;
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
        dl dlVar;
        dl dlVar2;
        dl dlVar3;
        dl dlVar4;
        ArrayList arrayList;
        di diVar;
        boolean z;
        boolean z2;
        di diVar2;
        dl dlVar5;
        ArrayList<u> arrayList2;
        ArrayList arrayList3;
        dl dlVar6;
        boolean z3 = false;
        if (customResponsedMessage != null && (customResponsedMessage instanceof FrsHotThreadResponseCacheMessage)) {
            FrsHotThreadResponseCacheMessage frsHotThreadResponseCacheMessage = (FrsHotThreadResponseCacheMessage) customResponsedMessage;
            ArrayList<u> threadList = frsHotThreadResponseCacheMessage.getThreadList();
            o page = frsHotThreadResponseCacheMessage.getPage();
            dlVar = this.bay.bav;
            dlVar.errCode = frsHotThreadResponseCacheMessage.getError();
            dlVar2 = this.bay.bav;
            dlVar2.errMsg = frsHotThreadResponseCacheMessage.getErrorString();
            dlVar3 = this.bay.bav;
            dlVar3.pn = page.rO();
            this.bay.bat = page.rO();
            if (threadList == null || threadList.size() == 0) {
                dlVar4 = this.bay.bav;
                dlVar4.aZb = false;
            } else {
                dlVar6 = this.bay.bav;
                dlVar6.aZb = true;
            }
            arrayList = this.bay.baw;
            if (arrayList.size() == 0 && threadList != null && threadList.size() != 0) {
                arrayList3 = this.bay.baw;
                arrayList3.addAll(threadList);
            }
            diVar = this.bay.bau;
            if (diVar != null) {
                if (threadList == null || threadList.size() == 0) {
                    z2 = this.bay.aSd;
                }
                diVar2 = this.bay.bau;
                dlVar5 = this.bay.bav;
                arrayList2 = this.bay.baw;
                diVar2.a(2, 0, dlVar5, arrayList2);
            }
            FrsHotThreadRequestCacheMessage frsHotThreadRequestCacheMessage = (FrsHotThreadRequestCacheMessage) frsHotThreadResponseCacheMessage.getOrginalMessage();
            z = this.bay.aSd;
            if (z) {
                if (threadList == null || threadList.size() == 0) {
                    z3 = true;
                }
                this.bay.a(com.baidu.adp.lib.g.b.c(frsHotThreadRequestCacheMessage.getData(), 0L), z3);
            }
        }
    }
}
