package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cp;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d cfK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.cfK = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        ao aoVar;
        ArrayList<v> arrayList;
        cf cfVar;
        ArrayList arrayList2;
        cp cpVar;
        cf cfVar2;
        cp cpVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        cp cpVar3;
        cp cpVar4;
        cp cpVar5;
        cp cpVar6;
        cp cpVar7;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i3;
        boolean z;
        ArrayList arrayList7;
        String str = null;
        if ((responsedMessage instanceof ResponsedFrsHotHttpMessage) || (responsedMessage instanceof ResponsedFrsHotSocketMessage)) {
            this.cfK.cfD = false;
            if (responsedMessage instanceof ResponsedFrsHotHttpMessage) {
                ResponsedFrsHotHttpMessage responsedFrsHotHttpMessage = (ResponsedFrsHotHttpMessage) responsedMessage;
                arrayList = responsedFrsHotHttpMessage.getThreadList();
                aoVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                aoVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                aoVar = null;
                arrayList = null;
            }
            if (aoVar != null) {
                if (!x.t(arrayList)) {
                    int qB = aoVar.qB();
                    i2 = this.cfK.cfF;
                    if (qB > i2) {
                        i3 = this.cfK.cfF;
                        if (i3 > 0) {
                            z = this.cfK.bQi;
                            if (!z) {
                                arrayList7 = this.cfK.cfI;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (aoVar.qB() > 0) {
                        arrayList5 = this.cfK.cfI;
                        arrayList5.clear();
                        arrayList6 = this.cfK.cfI;
                        arrayList6.addAll(arrayList);
                    }
                }
                cpVar4 = this.cfK.cfH;
                cpVar4.errCode = i;
                cpVar5 = this.cfK.cfH;
                cpVar5.errMsg = str;
                cpVar6 = this.cfK.cfH;
                cpVar6.pn = aoVar.qB();
                cpVar7 = this.cfK.cfH;
                cpVar7.hasMore = aoVar.qD() == 1;
                this.cfK.cfF = aoVar.qB();
            }
            this.cfK.bQi = false;
            cfVar = this.cfK.cfG;
            if (cfVar != null) {
                arrayList2 = this.cfK.cfI;
                if (arrayList2 != null) {
                    arrayList4 = this.cfK.cfI;
                    if (arrayList4.size() != 0) {
                        cpVar3 = this.cfK.cfH;
                        cpVar3.bVL = true;
                        cfVar2 = this.cfK.cfG;
                        cpVar2 = this.cfK.cfH;
                        arrayList3 = this.cfK.cfI;
                        cfVar2.a(2, 0, cpVar2, arrayList3);
                    }
                }
                cpVar = this.cfK.cfH;
                cpVar.bVL = false;
                cfVar2 = this.cfK.cfG;
                cpVar2 = this.cfK.cfH;
                arrayList3 = this.cfK.cfI;
                cfVar2.a(2, 0, cpVar2, arrayList3);
            }
        }
    }
}
