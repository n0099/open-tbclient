package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d brM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.brM = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        ad adVar;
        ArrayList<v> arrayList;
        fi fiVar;
        ArrayList arrayList2;
        fq fqVar;
        fi fiVar2;
        fq fqVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        fq fqVar3;
        fq fqVar4;
        fq fqVar5;
        fq fqVar6;
        fq fqVar7;
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
                adVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                adVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                adVar = null;
                arrayList = null;
            }
            if (adVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int pI = adVar.pI();
                    i2 = this.brM.brH;
                    if (pI > i2) {
                        i3 = this.brM.brH;
                        if (i3 > 0) {
                            z = this.brM.bdy;
                            if (!z) {
                                arrayList7 = this.brM.brK;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (adVar.pI() > 0) {
                        arrayList5 = this.brM.brK;
                        arrayList5.clear();
                        arrayList6 = this.brM.brK;
                        arrayList6.addAll(arrayList);
                    }
                }
                fqVar4 = this.brM.brJ;
                fqVar4.errCode = i;
                fqVar5 = this.brM.brJ;
                fqVar5.errMsg = str;
                fqVar6 = this.brM.brJ;
                fqVar6.pn = adVar.pI();
                fqVar7 = this.brM.brJ;
                fqVar7.hasMore = adVar.pK() == 1;
                this.brM.brH = adVar.pI();
            }
            this.brM.bdy = false;
            fiVar = this.brM.brI;
            if (fiVar != null) {
                arrayList2 = this.brM.brK;
                if (arrayList2 != null) {
                    arrayList4 = this.brM.brK;
                    if (arrayList4.size() != 0) {
                        fqVar3 = this.brM.brJ;
                        fqVar3.bmV = true;
                        fiVar2 = this.brM.brI;
                        fqVar2 = this.brM.brJ;
                        arrayList3 = this.brM.brK;
                        fiVar2.a(2, 0, fqVar2, arrayList3);
                    }
                }
                fqVar = this.brM.brJ;
                fqVar.bmV = false;
                fiVar2 = this.brM.brI;
                fqVar2 = this.brM.brJ;
                arrayList3 = this.brM.brK;
                fiVar2.a(2, 0, fqVar2, arrayList3);
            }
        }
    }
}
