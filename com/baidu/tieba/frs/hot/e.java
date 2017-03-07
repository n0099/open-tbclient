package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bYR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bYR = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        aq aqVar;
        ArrayList<v> arrayList;
        cc ccVar;
        ArrayList arrayList2;
        cm cmVar;
        cc ccVar2;
        cm cmVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        cm cmVar3;
        cm cmVar4;
        cm cmVar5;
        cm cmVar6;
        cm cmVar7;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i3;
        boolean z;
        ArrayList arrayList7;
        String str = null;
        if ((responsedMessage instanceof ResponsedFrsHotHttpMessage) || (responsedMessage instanceof ResponsedFrsHotSocketMessage)) {
            this.bYR.bYN = false;
            if (responsedMessage instanceof ResponsedFrsHotHttpMessage) {
                ResponsedFrsHotHttpMessage responsedFrsHotHttpMessage = (ResponsedFrsHotHttpMessage) responsedMessage;
                arrayList = responsedFrsHotHttpMessage.getThreadList();
                aqVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                aqVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                aqVar = null;
                arrayList = null;
            }
            if (aqVar != null) {
                if (!x.q(arrayList)) {
                    int qO = aqVar.qO();
                    i2 = this.bYR.mCurrentPage;
                    if (qO > i2) {
                        i3 = this.bYR.mCurrentPage;
                        if (i3 > 0) {
                            z = this.bYR.bKX;
                            if (!z) {
                                arrayList7 = this.bYR.bYP;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (aqVar.qO() > 0) {
                        arrayList5 = this.bYR.bYP;
                        arrayList5.clear();
                        arrayList6 = this.bYR.bYP;
                        arrayList6.addAll(arrayList);
                    }
                }
                cmVar4 = this.bYR.bYO;
                cmVar4.errCode = i;
                cmVar5 = this.bYR.bYO;
                cmVar5.errMsg = str;
                cmVar6 = this.bYR.bYO;
                cmVar6.pn = aqVar.qO();
                cmVar7 = this.bYR.bYO;
                cmVar7.hasMore = aqVar.qQ() == 1;
                this.bYR.mCurrentPage = aqVar.qO();
            }
            this.bYR.bKX = false;
            ccVar = this.bYR.baR;
            if (ccVar != null) {
                arrayList2 = this.bYR.bYP;
                if (arrayList2 != null) {
                    arrayList4 = this.bYR.bYP;
                    if (arrayList4.size() != 0) {
                        cmVar3 = this.bYR.bYO;
                        cmVar3.bQu = true;
                        ccVar2 = this.bYR.baR;
                        cmVar2 = this.bYR.bYO;
                        arrayList3 = this.bYR.bYP;
                        ccVar2.a(2, 0, cmVar2, arrayList3);
                    }
                }
                cmVar = this.bYR.bYO;
                cmVar.bQu = false;
                ccVar2 = this.bYR.baR;
                cmVar2 = this.bYR.bYO;
                arrayList3 = this.bYR.bYP;
                ccVar2.a(2, 0, cmVar2, arrayList3);
            }
        }
    }
}
