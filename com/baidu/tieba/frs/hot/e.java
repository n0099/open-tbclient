package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bRc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bRc = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        aj ajVar;
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
                ajVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                ajVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                ajVar = null;
                arrayList = null;
            }
            if (ajVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int pl = ajVar.pl();
                    i2 = this.bRc.bQX;
                    if (pl > i2) {
                        i3 = this.bRc.bQX;
                        if (i3 > 0) {
                            z = this.bRc.bBP;
                            if (!z) {
                                arrayList7 = this.bRc.bRa;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (ajVar.pl() > 0) {
                        arrayList5 = this.bRc.bRa;
                        arrayList5.clear();
                        arrayList6 = this.bRc.bRa;
                        arrayList6.addAll(arrayList);
                    }
                }
                dvVar4 = this.bRc.bQZ;
                dvVar4.errCode = i;
                dvVar5 = this.bRc.bQZ;
                dvVar5.errMsg = str;
                dvVar6 = this.bRc.bQZ;
                dvVar6.pn = ajVar.pl();
                dvVar7 = this.bRc.bQZ;
                dvVar7.hasMore = ajVar.pn() == 1;
                this.bRc.bQX = ajVar.pl();
            }
            this.bRc.bBP = false;
            dmVar = this.bRc.bQY;
            if (dmVar != null) {
                arrayList2 = this.bRc.bRa;
                if (arrayList2 != null) {
                    arrayList4 = this.bRc.bRa;
                    if (arrayList4.size() != 0) {
                        dvVar3 = this.bRc.bQZ;
                        dvVar3.bIG = true;
                        dmVar2 = this.bRc.bQY;
                        dvVar2 = this.bRc.bQZ;
                        arrayList3 = this.bRc.bRa;
                        dmVar2.a(2, 0, dvVar2, arrayList3);
                    }
                }
                dvVar = this.bRc.bQZ;
                dvVar.bIG = false;
                dmVar2 = this.bRc.bQY;
                dvVar2 = this.bRc.bQZ;
                arrayList3 = this.bRc.bRa;
                dmVar2.a(2, 0, dvVar2, arrayList3);
            }
        }
    }
}
