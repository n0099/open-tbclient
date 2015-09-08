package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.o;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ d bay;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, int i2) {
        super(i, i2);
        this.bay = dVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        o oVar;
        ArrayList<u> arrayList;
        di diVar;
        ArrayList arrayList2;
        dl dlVar;
        di diVar2;
        dl dlVar2;
        ArrayList<u> arrayList3;
        ArrayList arrayList4;
        dl dlVar3;
        dl dlVar4;
        dl dlVar5;
        dl dlVar6;
        dl dlVar7;
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
                    int rO = oVar.rO();
                    i2 = this.bay.bat;
                    if (rO > i2) {
                        i3 = this.bay.bat;
                        if (i3 > 0) {
                            z = this.bay.aSd;
                            if (!z) {
                                arrayList7 = this.bay.baw;
                                arrayList7.addAll(arrayList);
                            }
                        }
                    }
                    if (oVar.rO() > 0) {
                        arrayList5 = this.bay.baw;
                        arrayList5.clear();
                        arrayList6 = this.bay.baw;
                        arrayList6.addAll(arrayList);
                    }
                }
                dlVar4 = this.bay.bav;
                dlVar4.errCode = i;
                dlVar5 = this.bay.bav;
                dlVar5.errMsg = str;
                dlVar6 = this.bay.bav;
                dlVar6.pn = oVar.rO();
                dlVar7 = this.bay.bav;
                dlVar7.hasMore = oVar.rQ() == 1;
                this.bay.bat = oVar.rO();
            }
            this.bay.aSd = false;
            diVar = this.bay.bau;
            if (diVar != null) {
                arrayList2 = this.bay.baw;
                if (arrayList2 != null) {
                    arrayList4 = this.bay.baw;
                    if (arrayList4.size() != 0) {
                        dlVar3 = this.bay.bav;
                        dlVar3.aZb = true;
                        diVar2 = this.bay.bau;
                        dlVar2 = this.bay.bav;
                        arrayList3 = this.bay.baw;
                        diVar2.a(2, 0, dlVar2, arrayList3);
                    }
                }
                dlVar = this.bay.bav;
                dlVar.aZb = false;
                diVar2 = this.bay.bau;
                dlVar2 = this.bay.bav;
                arrayList3 = this.bay.baw;
                diVar2.a(2, 0, dlVar2, arrayList3);
            }
        }
    }
}
