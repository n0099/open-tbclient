package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bsY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bsY = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        ac acVar;
        ArrayList<u> arrayList;
        fp fpVar;
        ArrayList arrayList2;
        fr frVar;
        fp fpVar2;
        fr frVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        fr frVar3;
        fr frVar4;
        fr frVar5;
        fr frVar6;
        fr frVar7;
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
                acVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                acVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                acVar = null;
                arrayList = null;
            }
            if (acVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int so = acVar.so();
                    i2 = this.bsY.bsT;
                    if (so > i2) {
                        i3 = this.bsY.bsT;
                        if (i3 > 0) {
                            z = this.bsY.bhD;
                            if (!z) {
                                arrayList7 = this.bsY.bsW;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (acVar.so() > 0) {
                        arrayList5 = this.bsY.bsW;
                        arrayList5.clear();
                        arrayList6 = this.bsY.bsW;
                        arrayList6.addAll(arrayList);
                    }
                }
                frVar4 = this.bsY.bsV;
                frVar4.errCode = i;
                frVar5 = this.bsY.bsV;
                frVar5.errMsg = str;
                frVar6 = this.bsY.bsV;
                frVar6.pn = acVar.so();
                frVar7 = this.bsY.bsV;
                frVar7.hasMore = acVar.sq() == 1;
                this.bsY.bsT = acVar.so();
            }
            this.bsY.bhD = false;
            fpVar = this.bsY.bsU;
            if (fpVar != null) {
                arrayList2 = this.bsY.bsW;
                if (arrayList2 != null) {
                    arrayList4 = this.bsY.bsW;
                    if (arrayList4.size() != 0) {
                        frVar3 = this.bsY.bsV;
                        frVar3.bru = true;
                        fpVar2 = this.bsY.bsU;
                        frVar2 = this.bsY.bsV;
                        arrayList3 = this.bsY.bsW;
                        fpVar2.a(2, 0, frVar2, arrayList3);
                    }
                }
                frVar = this.bsY.bsV;
                frVar.bru = false;
                fpVar2 = this.bsY.bsU;
                frVar2 = this.bsY.bsV;
                arrayList3 = this.bsY.bsW;
                fpVar2.a(2, 0, frVar2, arrayList3);
            }
        }
    }
}
