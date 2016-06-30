package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.af;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bPp = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        af afVar;
        ArrayList<v> arrayList;
        dm dmVar;
        ArrayList arrayList2;
        dv dvVar;
        dm dmVar2;
        dv dvVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        dv dvVar3;
        dv dvVar4;
        dv dvVar5;
        dv dvVar6;
        dv dvVar7;
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
                afVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                afVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                afVar = null;
                arrayList = null;
            }
            if (afVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int pC = afVar.pC();
                    i2 = this.bPp.bPk;
                    if (pC > i2) {
                        i3 = this.bPp.bPk;
                        if (i3 > 0) {
                            z = this.bPp.bzB;
                            if (!z) {
                                arrayList7 = this.bPp.bPn;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (afVar.pC() > 0) {
                        arrayList5 = this.bPp.bPn;
                        arrayList5.clear();
                        arrayList6 = this.bPp.bPn;
                        arrayList6.addAll(arrayList);
                    }
                }
                dvVar4 = this.bPp.bPm;
                dvVar4.errCode = i;
                dvVar5 = this.bPp.bPm;
                dvVar5.errMsg = str;
                dvVar6 = this.bPp.bPm;
                dvVar6.pn = afVar.pC();
                dvVar7 = this.bPp.bPm;
                dvVar7.hasMore = afVar.pE() == 1;
                this.bPp.bPk = afVar.pC();
            }
            this.bPp.bzB = false;
            dmVar = this.bPp.bPl;
            if (dmVar != null) {
                arrayList2 = this.bPp.bPn;
                if (arrayList2 != null) {
                    arrayList4 = this.bPp.bPn;
                    if (arrayList4.size() != 0) {
                        dvVar3 = this.bPp.bPm;
                        dvVar3.bHk = true;
                        dmVar2 = this.bPp.bPl;
                        dvVar2 = this.bPp.bPm;
                        arrayList3 = this.bPp.bPn;
                        dmVar2.a(2, 0, dvVar2, arrayList3);
                    }
                }
                dvVar = this.bPp.bPm;
                dvVar.bHk = false;
                dmVar2 = this.bPp.bPl;
                dvVar2 = this.bPp.bPm;
                arrayList3 = this.bPp.bPn;
                dmVar2.a(2, 0, dvVar2, arrayList3);
            }
        }
    }
}
