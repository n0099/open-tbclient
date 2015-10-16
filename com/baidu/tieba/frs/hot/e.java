package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.baC = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        o oVar;
        ArrayList<u> arrayList;
        eb ebVar;
        ArrayList arrayList2;
        ee eeVar;
        eb ebVar2;
        ee eeVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        ee eeVar3;
        ee eeVar4;
        ee eeVar5;
        ee eeVar6;
        ee eeVar7;
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
                    int rJ = oVar.rJ();
                    i2 = this.baC.bax;
                    if (rJ > i2) {
                        i3 = this.baC.bax;
                        if (i3 > 0) {
                            z = this.baC.aRk;
                            if (!z) {
                                arrayList7 = this.baC.baA;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (oVar.rJ() > 0) {
                        arrayList5 = this.baC.baA;
                        arrayList5.clear();
                        arrayList6 = this.baC.baA;
                        arrayList6.addAll(arrayList);
                    }
                }
                eeVar4 = this.baC.baz;
                eeVar4.errCode = i;
                eeVar5 = this.baC.baz;
                eeVar5.errMsg = str;
                eeVar6 = this.baC.baz;
                eeVar6.pn = oVar.rJ();
                eeVar7 = this.baC.baz;
                eeVar7.hasMore = oVar.rL() == 1;
                this.baC.bax = oVar.rJ();
            }
            this.baC.aRk = false;
            ebVar = this.baC.bay;
            if (ebVar != null) {
                arrayList2 = this.baC.baA;
                if (arrayList2 != null) {
                    arrayList4 = this.baC.baA;
                    if (arrayList4.size() != 0) {
                        eeVar3 = this.baC.baz;
                        eeVar3.aZb = true;
                        ebVar2 = this.baC.bay;
                        eeVar2 = this.baC.baz;
                        arrayList3 = this.baC.baA;
                        ebVar2.a(2, 0, eeVar2, arrayList3);
                    }
                }
                eeVar = this.baC.baz;
                eeVar.aZb = false;
                ebVar2 = this.baC.bay;
                eeVar2 = this.baC.baz;
                arrayList3 = this.baC.baA;
                ebVar2.a(2, 0, eeVar2, arrayList3);
            }
        }
    }
}
