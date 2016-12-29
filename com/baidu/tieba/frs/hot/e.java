package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bLt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bLt = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        an anVar;
        ArrayList<v> arrayList;
        ce ceVar;
        ArrayList arrayList2;
        co coVar;
        ce ceVar2;
        co coVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        co coVar3;
        co coVar4;
        co coVar5;
        co coVar6;
        co coVar7;
        int i2;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i3;
        boolean z;
        ArrayList arrayList7;
        String str = null;
        if ((responsedMessage instanceof ResponsedFrsHotHttpMessage) || (responsedMessage instanceof ResponsedFrsHotSocketMessage)) {
            this.bLt.bLm = false;
            if (responsedMessage instanceof ResponsedFrsHotHttpMessage) {
                ResponsedFrsHotHttpMessage responsedFrsHotHttpMessage = (ResponsedFrsHotHttpMessage) responsedMessage;
                arrayList = responsedFrsHotHttpMessage.getThreadList();
                anVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                anVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                anVar = null;
                arrayList = null;
            }
            if (anVar != null) {
                if (!x.t(arrayList)) {
                    int qC = anVar.qC();
                    i2 = this.bLt.bLo;
                    if (qC > i2) {
                        i3 = this.bLt.bLo;
                        if (i3 > 0) {
                            z = this.bLt.bwm;
                            if (!z) {
                                arrayList7 = this.bLt.bLr;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (anVar.qC() > 0) {
                        arrayList5 = this.bLt.bLr;
                        arrayList5.clear();
                        arrayList6 = this.bLt.bLr;
                        arrayList6.addAll(arrayList);
                    }
                }
                coVar4 = this.bLt.bLq;
                coVar4.errCode = i;
                coVar5 = this.bLt.bLq;
                coVar5.errMsg = str;
                coVar6 = this.bLt.bLq;
                coVar6.pn = anVar.qC();
                coVar7 = this.bLt.bLq;
                coVar7.hasMore = anVar.qE() == 1;
                this.bLt.bLo = anVar.qC();
            }
            this.bLt.bwm = false;
            ceVar = this.bLt.bLp;
            if (ceVar != null) {
                arrayList2 = this.bLt.bLr;
                if (arrayList2 != null) {
                    arrayList4 = this.bLt.bLr;
                    if (arrayList4.size() != 0) {
                        coVar3 = this.bLt.bLq;
                        coVar3.bBT = true;
                        ceVar2 = this.bLt.bLp;
                        coVar2 = this.bLt.bLq;
                        arrayList3 = this.bLt.bLr;
                        ceVar2.a(2, 0, coVar2, arrayList3);
                    }
                }
                coVar = this.bLt.bLq;
                coVar.bBT = false;
                ceVar2 = this.bLt.bLp;
                coVar2 = this.bLt.bLq;
                arrayList3 = this.bLt.bLr;
                ceVar2.a(2, 0, coVar2, arrayList3);
            }
        }
    }
}
