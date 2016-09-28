package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.am;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d ccn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.ccn = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        am amVar;
        ArrayList<v> arrayList;
        dh dhVar;
        ArrayList arrayList2;
        dq dqVar;
        dh dhVar2;
        dq dqVar2;
        ArrayList<v> arrayList3;
        ArrayList arrayList4;
        dq dqVar3;
        dq dqVar4;
        dq dqVar5;
        dq dqVar6;
        dq dqVar7;
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
                amVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                amVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                amVar = null;
                arrayList = null;
            }
            if (amVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int qz = amVar.qz();
                    i2 = this.ccn.cci;
                    if (qz > i2) {
                        i3 = this.ccn.cci;
                        if (i3 > 0) {
                            z = this.ccn.bNp;
                            if (!z) {
                                arrayList7 = this.ccn.ccl;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (amVar.qz() > 0) {
                        arrayList5 = this.ccn.ccl;
                        arrayList5.clear();
                        arrayList6 = this.ccn.ccl;
                        arrayList6.addAll(arrayList);
                    }
                }
                dqVar4 = this.ccn.cck;
                dqVar4.errCode = i;
                dqVar5 = this.ccn.cck;
                dqVar5.errMsg = str;
                dqVar6 = this.ccn.cck;
                dqVar6.pn = amVar.qz();
                dqVar7 = this.ccn.cck;
                dqVar7.hasMore = amVar.qB() == 1;
                this.ccn.cci = amVar.qz();
            }
            this.ccn.bNp = false;
            dhVar = this.ccn.ccj;
            if (dhVar != null) {
                arrayList2 = this.ccn.ccl;
                if (arrayList2 != null) {
                    arrayList4 = this.ccn.ccl;
                    if (arrayList4.size() != 0) {
                        dqVar3 = this.ccn.cck;
                        dqVar3.bTB = true;
                        dhVar2 = this.ccn.ccj;
                        dqVar2 = this.ccn.cck;
                        arrayList3 = this.ccn.ccl;
                        dhVar2.a(2, 0, dqVar2, arrayList3);
                    }
                }
                dqVar = this.ccn.cck;
                dqVar.bTB = false;
                dhVar2 = this.ccn.ccj;
                dqVar2 = this.ccn.cck;
                arrayList3 = this.ccn.ccl;
                dhVar2.a(2, 0, dqVar2, arrayList3);
            }
        }
    }
}
