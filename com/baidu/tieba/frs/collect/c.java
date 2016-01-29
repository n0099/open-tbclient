package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyCollectFrsActivity myCollectFrsActivity, int i, int i2) {
        super(i, i2);
        this.bmY = myCollectFrsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        l lVar;
        l lVar2;
        o oVar;
        a aVar;
        a aVar2;
        l lVar3;
        l lVar4;
        a aVar3;
        a aVar4;
        o oVar2;
        l lVar5;
        l lVar6;
        l lVar7;
        o oVar3;
        l lVar8;
        o oVar4;
        boolean z;
        boolean z2;
        a aVar5;
        a aVar6;
        a aVar7;
        l lVar9;
        lVar = this.bmY.bmT;
        lVar.nr();
        MyCollectFrsActivity myCollectFrsActivity = this.bmY;
        lVar2 = this.bmY.bmT;
        myCollectFrsActivity.hideLoadingView(lVar2.getRootView());
        if (responsedMessage.getError() != 0) {
            String string = TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.bmY.getResources().getString(t.j.neterror) : responsedMessage.getErrorString();
            this.bmY.mHasMore = false;
            lVar9 = this.bmY.bmT;
            lVar9.Qp();
            this.bmY.showToast(string);
            this.bmY.hv(string);
            return;
        }
        com.baidu.tieba.tbadkCore.m mVar = null;
        int i = -1;
        if (responsedMessage instanceof GetUserForumStoreSocketResponseMessage) {
            GetUserForumStoreSocketResponseMessage getUserForumStoreSocketResponseMessage = (GetUserForumStoreSocketResponseMessage) responsedMessage;
            mVar = getUserForumStoreSocketResponseMessage.getResponseData();
            this.bmY.mHasMore = getUserForumStoreSocketResponseMessage.isHasMore();
            i = getUserForumStoreSocketResponseMessage.getType();
        } else if (responsedMessage instanceof GetUserForumStoreHttpResponseMessage) {
            GetUserForumStoreHttpResponseMessage getUserForumStoreHttpResponseMessage = (GetUserForumStoreHttpResponseMessage) responsedMessage;
            mVar = getUserForumStoreHttpResponseMessage.getResponseData();
            this.bmY.mHasMore = getUserForumStoreHttpResponseMessage.isHasMore();
            i = getUserForumStoreHttpResponseMessage.getType();
        }
        oVar = this.bmY.bfF;
        oVar.d(mVar);
        if (mVar != null) {
            ArrayList<u> threadList = mVar.getThreadList();
            if (threadList != null && !threadList.isEmpty()) {
                if (i == 0) {
                    aVar6 = this.bmY.bmS;
                    aVar6.gD(0);
                    aVar7 = this.bmY.bmS;
                    aVar7.clearData();
                }
                aVar = this.bmY.bmS;
                int QL = aVar.QL();
                aVar2 = this.bmY.bmS;
                aVar2.gD(QL + threadList.size());
                lVar3 = this.bmY.bmT;
                if (lVar3 != null) {
                    lVar4 = this.bmY.bmT;
                    Set QC = lVar4.QO().QC();
                    if (QC != null && !QC.isEmpty()) {
                        for (int size = threadList.size() - 1; size >= 0; size--) {
                            u uVar = threadList.get(size);
                            if (!QC.contains(uVar.getType())) {
                                threadList.remove(uVar);
                            }
                        }
                    }
                }
                if (threadList.isEmpty()) {
                    z2 = this.bmY.mHasMore;
                    if (z2) {
                        aVar5 = this.bmY.bmS;
                        aVar5.QN();
                        return;
                    }
                    this.bmY.hv(this.bmY.getResources().getString(t.j.no_data_text));
                    return;
                }
                aVar3 = this.bmY.bmS;
                aVar3.setData(threadList);
                aVar4 = this.bmY.bmS;
                ArrayList<u> qN = aVar4.qN();
                oVar2 = this.bmY.bfF;
                oVar2.an(qN);
                lVar5 = this.bmY.bmT;
                if (lVar5 != null) {
                    lVar6 = this.bmY.bmT;
                    lVar6.hideNoDataView();
                    lVar7 = this.bmY.bmT;
                    fg QO = lVar7.QO();
                    oVar3 = this.bmY.bfF;
                    QO.setFromCDN(oVar3.aoK() == 1);
                    lVar8 = this.bmY.bmT;
                    oVar4 = this.bmY.bfF;
                    z = this.bmY.mHasMore;
                    lVar8.a(qN, oVar4, z);
                }
                this.bmY.Pp();
                return;
            }
            this.bmY.hv(this.bmY.getResources().getString(t.j.no_data_text));
            return;
        }
        this.bmY.hv(this.bmY.getResources().getString(t.j.no_data_text));
    }
}
