package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d baV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.baV = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        o oVar;
        ArrayList<u> arrayList;
        ed edVar;
        ArrayList arrayList2;
        eg egVar;
        ed edVar2;
        eg egVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        eg egVar3;
        eg egVar4;
        eg egVar5;
        eg egVar6;
        eg egVar7;
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
                oVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                oVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                oVar = null;
                arrayList = null;
            }
            if (oVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int rI = oVar.rI();
                    i2 = this.baV.baQ;
                    if (rI > i2) {
                        i3 = this.baV.baQ;
                        if (i3 > 0) {
                            z = this.baV.aRs;
                            if (!z) {
                                arrayList7 = this.baV.baT;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (oVar.rI() > 0) {
                        arrayList5 = this.baV.baT;
                        arrayList5.clear();
                        arrayList6 = this.baV.baT;
                        arrayList6.addAll(arrayList);
                    }
                }
                egVar4 = this.baV.baS;
                egVar4.errCode = i;
                egVar5 = this.baV.baS;
                egVar5.errMsg = str;
                egVar6 = this.baV.baS;
                egVar6.pn = oVar.rI();
                egVar7 = this.baV.baS;
                egVar7.hasMore = oVar.rK() == 1;
                this.baV.baQ = oVar.rI();
            }
            this.baV.aRs = false;
            edVar = this.baV.baR;
            if (edVar != null) {
                arrayList2 = this.baV.baT;
                if (arrayList2 != null) {
                    arrayList4 = this.baV.baT;
                    if (arrayList4.size() != 0) {
                        egVar3 = this.baV.baS;
                        egVar3.aZn = true;
                        edVar2 = this.baV.baR;
                        egVar2 = this.baV.baS;
                        arrayList3 = this.baV.baT;
                        edVar2.a(2, 0, egVar2, arrayList3);
                    }
                }
                egVar = this.baV.baS;
                egVar.aZn = false;
                edVar2 = this.baV.baR;
                egVar2 = this.baV.baS;
                arrayList3 = this.baV.baT;
                edVar2.a(2, 0, egVar2, arrayList3);
            }
        }
    }
}
