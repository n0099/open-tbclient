package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.q;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d ble;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.ble = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        q qVar;
        ArrayList<u> arrayList;
        ev evVar;
        ArrayList arrayList2;
        ey eyVar;
        ev evVar2;
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
                    int rM = qVar.rM();
                    i2 = this.ble.bkZ;
                    if (rM > i2) {
                        i3 = this.ble.bkZ;
                        if (i3 > 0) {
                            z = this.ble.baH;
                            if (!z) {
                                arrayList7 = this.ble.blc;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (qVar.rM() > 0) {
                        arrayList5 = this.ble.blc;
                        arrayList5.clear();
                        arrayList6 = this.ble.blc;
                        arrayList6.addAll(arrayList);
                    }
                }
                eyVar4 = this.ble.blb;
                eyVar4.errCode = i;
                eyVar5 = this.ble.blb;
                eyVar5.errMsg = str;
                eyVar6 = this.ble.blb;
                eyVar6.pn = qVar.rM();
                eyVar7 = this.ble.blb;
                eyVar7.hasMore = qVar.rO() == 1;
                this.ble.bkZ = qVar.rM();
            }
            this.ble.baH = false;
            evVar = this.ble.bla;
            if (evVar != null) {
                arrayList2 = this.ble.blc;
                if (arrayList2 != null) {
                    arrayList4 = this.ble.blc;
                    if (arrayList4.size() != 0) {
                        eyVar3 = this.ble.blb;
                        eyVar3.bjk = true;
                        evVar2 = this.ble.bla;
                        eyVar2 = this.ble.blb;
                        arrayList3 = this.ble.blc;
                        evVar2.a(2, 0, eyVar2, arrayList3);
                    }
                }
                eyVar = this.ble.blb;
                eyVar.bjk = false;
                evVar2 = this.ble.bla;
                eyVar2 = this.ble.blb;
                arrayList3 = this.ble.blc;
                evVar2.a(2, 0, eyVar2, arrayList3);
            }
        }
    }
}
