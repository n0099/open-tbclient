package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.q;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bhn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bhn = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        q qVar;
        ArrayList<u> arrayList;
        eu euVar;
        ArrayList arrayList2;
        ey eyVar;
        eu euVar2;
        ey eyVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        ey eyVar3;
        ey eyVar4;
        ey eyVar5;
        ey eyVar6;
        ey eyVar7;
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
                qVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                qVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                qVar = null;
                arrayList = null;
            }
            if (qVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int sd = qVar.sd();
                    i2 = this.bhn.bhi;
                    if (sd > i2) {
                        i3 = this.bhn.bhi;
                        if (i3 > 0) {
                            z = this.bhn.aWG;
                            if (!z) {
                                arrayList7 = this.bhn.bhl;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (qVar.sd() > 0) {
                        arrayList5 = this.bhn.bhl;
                        arrayList5.clear();
                        arrayList6 = this.bhn.bhl;
                        arrayList6.addAll(arrayList);
                    }
                }
                eyVar4 = this.bhn.bhk;
                eyVar4.errCode = i;
                eyVar5 = this.bhn.bhk;
                eyVar5.errMsg = str;
                eyVar6 = this.bhn.bhk;
                eyVar6.pn = qVar.sd();
                eyVar7 = this.bhn.bhk;
                eyVar7.hasMore = qVar.sf() == 1;
                this.bhn.bhi = qVar.sd();
            }
            this.bhn.aWG = false;
            euVar = this.bhn.bhj;
            if (euVar != null) {
                arrayList2 = this.bhn.bhl;
                if (arrayList2 != null) {
                    arrayList4 = this.bhn.bhl;
                    if (arrayList4.size() != 0) {
                        eyVar3 = this.bhn.bhk;
                        eyVar3.bfs = true;
                        euVar2 = this.bhn.bhj;
                        eyVar2 = this.bhn.bhk;
                        arrayList3 = this.bhn.bhl;
                        euVar2.a(2, 0, eyVar2, arrayList3);
                    }
                }
                eyVar = this.bhn.bhk;
                eyVar.bfs = false;
                euVar2 = this.bhn.bhj;
                eyVar2 = this.bhn.bhk;
                arrayList3 = this.bhn.bhl;
                euVar2.a(2, 0, eyVar2, arrayList3);
            }
        }
    }
}
