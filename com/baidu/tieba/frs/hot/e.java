package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.u;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bob;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bob = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        u uVar;
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList;
        ff ffVar;
        ArrayList arrayList2;
        fi fiVar;
        ff ffVar2;
        fi fiVar2;
        ArrayList<com.baidu.adp.widget.ListView.u> arrayList3;
        ArrayList arrayList4;
        fi fiVar3;
        fi fiVar4;
        fi fiVar5;
        fi fiVar6;
        fi fiVar7;
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
                uVar = responsedFrsHotHttpMessage.getPage();
                i = responsedFrsHotHttpMessage.getError();
                str = responsedFrsHotHttpMessage.getErrorString();
            } else if (responsedMessage instanceof ResponsedFrsHotSocketMessage) {
                ResponsedFrsHotSocketMessage responsedFrsHotSocketMessage = (ResponsedFrsHotSocketMessage) responsedMessage;
                arrayList = responsedFrsHotSocketMessage.getThreadList();
                uVar = responsedFrsHotSocketMessage.getPage();
                i = responsedFrsHotSocketMessage.getError();
                str = responsedFrsHotSocketMessage.getErrorString();
            } else {
                i = 0;
                uVar = null;
                arrayList = null;
            }
            if (uVar != null) {
                if (arrayList != null && arrayList.size() != 0) {
                    int st = uVar.st();
                    i2 = this.bob.bnW;
                    if (st > i2) {
                        i3 = this.bob.bnW;
                        if (i3 > 0) {
                            z = this.bob.bcS;
                            if (!z) {
                                arrayList7 = this.bob.bnZ;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (uVar.st() > 0) {
                        arrayList5 = this.bob.bnZ;
                        arrayList5.clear();
                        arrayList6 = this.bob.bnZ;
                        arrayList6.addAll(arrayList);
                    }
                }
                fiVar4 = this.bob.bnY;
                fiVar4.errCode = i;
                fiVar5 = this.bob.bnY;
                fiVar5.errMsg = str;
                fiVar6 = this.bob.bnY;
                fiVar6.pn = uVar.st();
                fiVar7 = this.bob.bnY;
                fiVar7.hasMore = uVar.sv() == 1;
                this.bob.bnW = uVar.st();
            }
            this.bob.bcS = false;
            ffVar = this.bob.bnX;
            if (ffVar != null) {
                arrayList2 = this.bob.bnZ;
                if (arrayList2 != null) {
                    arrayList4 = this.bob.bnZ;
                    if (arrayList4.size() != 0) {
                        fiVar3 = this.bob.bnY;
                        fiVar3.bmf = true;
                        ffVar2 = this.bob.bnX;
                        fiVar2 = this.bob.bnY;
                        arrayList3 = this.bob.bnZ;
                        ffVar2.a(2, 0, fiVar2, arrayList3);
                    }
                }
                fiVar = this.bob.bnY;
                fiVar.bmf = false;
                ffVar2 = this.bob.bnX;
                fiVar2 = this.bob.bnY;
                arrayList3 = this.bob.bnZ;
                ffVar2.a(2, 0, fiVar2, arrayList3);
            }
        }
    }
}
