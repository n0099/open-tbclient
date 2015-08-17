package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.p;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bad = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        p pVar;
        ArrayList<u> arrayList;
        dc dcVar;
        ArrayList arrayList2;
        df dfVar;
        dc dcVar2;
        df dfVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        df dfVar3;
        df dfVar4;
        df dfVar5;
        df dfVar6;
        df dfVar7;
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
                pVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                pVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                pVar = null;
                arrayList = null;
            }
            if (pVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int rR = pVar.rR();
                    i2 = this.bad.aZY;
                    if (rR > i2) {
                        i3 = this.bad.aZY;
                        if (i3 > 0) {
                            z = this.bad.aRP;
                            if (!z) {
                                arrayList7 = this.bad.bab;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (pVar.rR() > 0) {
                        arrayList5 = this.bad.bab;
                        arrayList5.clear();
                        arrayList6 = this.bad.bab;
                        arrayList6.addAll(arrayList);
                    }
                }
                dfVar4 = this.bad.baa;
                dfVar4.errCode = i;
                dfVar5 = this.bad.baa;
                dfVar5.errMsg = str;
                dfVar6 = this.bad.baa;
                dfVar6.pn = pVar.rR();
                dfVar7 = this.bad.baa;
                dfVar7.hasMore = pVar.rT() == 1;
                this.bad.aZY = pVar.rR();
            }
            this.bad.aRP = false;
            dcVar = this.bad.aZZ;
            if (dcVar != null) {
                arrayList2 = this.bad.bab;
                if (arrayList2 != null) {
                    arrayList4 = this.bad.bab;
                    if (arrayList4.size() != 0) {
                        dfVar3 = this.bad.baa;
                        dfVar3.aYJ = true;
                        dcVar2 = this.bad.aZZ;
                        dfVar2 = this.bad.baa;
                        arrayList3 = this.bad.bab;
                        dcVar2.a(2, 0, dfVar2, arrayList3);
                    }
                }
                dfVar = this.bad.baa;
                dfVar.aYJ = false;
                dcVar2 = this.bad.aZZ;
                dfVar2 = this.bad.baa;
                arrayList3 = this.bad.bab;
                dcVar2.a(2, 0, dfVar2, arrayList3);
            }
        }
    }
}
