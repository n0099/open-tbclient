package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.n;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.baq = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        n nVar;
        ArrayList<u> arrayList;
        eb ebVar;
        ArrayList arrayList2;
        ee eeVar;
        eb ebVar2;
        ee eeVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        ee eeVar3;
        ee eeVar4;
        ee eeVar5;
        ee eeVar6;
        ee eeVar7;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i3;
        boolean z;
        ArrayList arrayList7;
        String str = null;
        if ((responsedMessage instanceof ResponsedFrsHotHttpMessage) || (responsedMessage instanceof ResponsedFrsHotSocketMessage)) {
            if (responsedMessage instanceof ResponsedFrsHotHttpMessage) {
                ResponsedFrsHotHttpMessage responsedFrsHotHttpMessage = (ResponsedFrsHotHttpMessage) responsedMessage;
                arrayList = responsedFrsHotHttpMessage.getThreadList();
                nVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                nVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                nVar = null;
                arrayList = null;
            }
            if (nVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int rJ = nVar.rJ();
                    i2 = this.baq.bal;
                    if (rJ > i2) {
                        i3 = this.baq.bal;
                        if (i3 > 0) {
                            z = this.baq.aQZ;
                            if (!z) {
                                arrayList7 = this.baq.bao;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (nVar.rJ() > 0) {
                        arrayList5 = this.baq.bao;
                        arrayList5.clear();
                        arrayList6 = this.baq.bao;
                        arrayList6.addAll(arrayList);
                    }
                }
                eeVar4 = this.baq.ban;
                eeVar4.errCode = i;
                eeVar5 = this.baq.ban;
                eeVar5.errMsg = str;
                eeVar6 = this.baq.ban;
                eeVar6.pn = nVar.rJ();
                eeVar7 = this.baq.ban;
                eeVar7.hasMore = nVar.rL() == 1;
                this.baq.bal = nVar.rJ();
            }
            this.baq.aQZ = false;
            ebVar = this.baq.bam;
            if (ebVar != null) {
                arrayList2 = this.baq.bao;
                if (arrayList2 != null) {
                    arrayList4 = this.baq.bao;
                    if (arrayList4.size() != 0) {
                        eeVar3 = this.baq.ban;
                        eeVar3.aYQ = true;
                        ebVar2 = this.baq.bam;
                        eeVar2 = this.baq.ban;
                        arrayList3 = this.baq.bao;
                        ebVar2.a(2, 0, eeVar2, arrayList3);
                    }
                }
                eeVar = this.baq.ban;
                eeVar.aYQ = false;
                ebVar2 = this.baq.bam;
                eeVar2 = this.baq.ban;
                arrayList3 = this.baq.bao;
                ebVar2.a(2, 0, eeVar2, arrayList3);
            }
        }
    }
}
