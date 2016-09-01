package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dq;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d ccl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.ccl = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        ak akVar;
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
                akVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                akVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                akVar = null;
                arrayList = null;
            }
            if (akVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int qo = akVar.qo();
                    i2 = this.ccl.ccg;
                    if (qo > i2) {
                        i3 = this.ccl.ccg;
                        if (i3 > 0) {
                            z = this.ccl.bNs;
                            if (!z) {
                                arrayList7 = this.ccl.ccj;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (akVar.qo() > 0) {
                        arrayList5 = this.ccl.ccj;
                        arrayList5.clear();
                        arrayList6 = this.ccl.ccj;
                        arrayList6.addAll(arrayList);
                    }
                }
                dqVar4 = this.ccl.cci;
                dqVar4.errCode = i;
                dqVar5 = this.ccl.cci;
                dqVar5.errMsg = str;
                dqVar6 = this.ccl.cci;
                dqVar6.pn = akVar.qo();
                dqVar7 = this.ccl.cci;
                dqVar7.hasMore = akVar.qq() == 1;
                this.ccl.ccg = akVar.qo();
            }
            this.ccl.bNs = false;
            dhVar = this.ccl.cch;
            if (dhVar != null) {
                arrayList2 = this.ccl.ccj;
                if (arrayList2 != null) {
                    arrayList4 = this.ccl.ccj;
                    if (arrayList4.size() != 0) {
                        dqVar3 = this.ccl.cci;
                        dqVar3.bTI = true;
                        dhVar2 = this.ccl.cch;
                        dqVar2 = this.ccl.cci;
                        arrayList3 = this.ccl.ccj;
                        dhVar2.a(2, 0, dqVar2, arrayList3);
                    }
                }
                dqVar = this.ccl.cci;
                dqVar.bTI = false;
                dhVar2 = this.ccl.cch;
                dqVar2 = this.ccl.cci;
                arrayList3 = this.ccl.ccj;
                dhVar2.a(2, 0, dqVar2, arrayList3);
            }
        }
    }
}
