package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bRJ = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        ao aoVar;
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
            this.bRJ.bRF = false;
            if (responsedMessage instanceof ResponsedFrsHotHttpMessage) {
                ResponsedFrsHotHttpMessage responsedFrsHotHttpMessage = (ResponsedFrsHotHttpMessage) responsedMessage;
                arrayList = responsedFrsHotHttpMessage.getThreadList();
                aoVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                aoVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                aoVar = null;
                arrayList = null;
            }
            if (aoVar != null) {
                if (!w.s(arrayList)) {
                    int qv = aoVar.qv();
                    i2 = this.bRJ.mCurrentPage;
                    if (qv > i2) {
                        i3 = this.bRJ.mCurrentPage;
                        if (i3 > 0) {
                            z = this.bRJ.bDQ;
                            if (!z) {
                                arrayList7 = this.bRJ.bRH;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (aoVar.qv() > 0) {
                        arrayList5 = this.bRJ.bRH;
                        arrayList5.clear();
                        arrayList6 = this.bRJ.bRH;
                        arrayList6.addAll(arrayList);
                    }
                }
                cmVar4 = this.bRJ.bRG;
                cmVar4.errCode = i;
                cmVar5 = this.bRJ.bRG;
                cmVar5.errMsg = str;
                cmVar6 = this.bRJ.bRG;
                cmVar6.pn = aoVar.qv();
                cmVar7 = this.bRJ.bRG;
                cmVar7.hasMore = aoVar.qx() == 1;
                this.bRJ.mCurrentPage = aoVar.qv();
            }
            this.bRJ.bDQ = false;
            ccVar = this.bRJ.aUE;
            if (ccVar != null) {
                arrayList2 = this.bRJ.bRH;
                if (arrayList2 != null) {
                    arrayList4 = this.bRJ.bRH;
                    if (arrayList4.size() != 0) {
                        cmVar3 = this.bRJ.bRG;
                        cmVar3.bJl = true;
                        ccVar2 = this.bRJ.aUE;
                        cmVar2 = this.bRJ.bRG;
                        arrayList3 = this.bRJ.bRH;
                        ccVar2.a(2, 0, cmVar2, arrayList3);
                    }
                }
                cmVar = this.bRJ.bRG;
                cmVar.bJl = false;
                ccVar2 = this.bRJ.aUE;
                cmVar2 = this.bRJ.bRG;
                arrayList3 = this.bRJ.bRH;
                ccVar2.a(2, 0, cmVar2, arrayList3);
            }
        }
    }
}
