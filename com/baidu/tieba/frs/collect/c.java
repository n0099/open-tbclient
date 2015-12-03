package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyCollectFrsActivity myCollectFrsActivity, int i, int i2) {
        super(i, i2);
        this.bgk = myCollectFrsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        l lVar;
        l lVar2;
        p pVar;
        a aVar;
        a aVar2;
        l lVar3;
        l lVar4;
        a aVar3;
        a aVar4;
        p pVar2;
        l lVar5;
        l lVar6;
        l lVar7;
        p pVar3;
        l lVar8;
        p pVar4;
        boolean z;
        boolean z2;
        a aVar5;
        a aVar6;
        a aVar7;
        l lVar9;
        lVar = this.bgk.bgf;
        lVar.completePullRefresh();
        MyCollectFrsActivity myCollectFrsActivity = this.bgk;
        lVar2 = this.bgk.bgf;
        myCollectFrsActivity.hideLoadingView(lVar2.getRootView());
        if (responsedMessage.getError() != 0) {
            String string = TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.bgk.getResources().getString(n.i.neterror) : responsedMessage.getErrorString();
            this.bgk.mHasMore = false;
            lVar9 = this.bgk.bgf;
            lVar9.NT();
            this.bgk.showToast(string);
            this.bgk.hj(string);
            return;
        }
        com.baidu.tieba.tbadkCore.n nVar = null;
        int i = -1;
        if (responsedMessage instanceof GetUserForumStoreSocketResponseMessage) {
            GetUserForumStoreSocketResponseMessage getUserForumStoreSocketResponseMessage = (GetUserForumStoreSocketResponseMessage) responsedMessage;
            nVar = getUserForumStoreSocketResponseMessage.getResponseData();
            this.bgk.mHasMore = getUserForumStoreSocketResponseMessage.isHasMore();
            i = getUserForumStoreSocketResponseMessage.getType();
        } else if (responsedMessage instanceof GetUserForumStoreHttpResponseMessage) {
            GetUserForumStoreHttpResponseMessage getUserForumStoreHttpResponseMessage = (GetUserForumStoreHttpResponseMessage) responsedMessage;
            nVar = getUserForumStoreHttpResponseMessage.getResponseData();
            this.bgk.mHasMore = getUserForumStoreHttpResponseMessage.isHasMore();
            i = getUserForumStoreHttpResponseMessage.getType();
        }
        pVar = this.bgk.aZs;
        pVar.d(nVar);
        if (nVar != null) {
            ArrayList<u> threadList = nVar.getThreadList();
            if (threadList != null && !threadList.isEmpty()) {
                if (i == 0) {
                    aVar6 = this.bgk.bge;
                    aVar6.gn(0);
                    aVar7 = this.bgk.bge;
                    aVar7.clearData();
                }
                aVar = this.bgk.bge;
                int Or = aVar.Or();
                aVar2 = this.bgk.bge;
                aVar2.gn(Or + threadList.size());
                lVar3 = this.bgk.bgf;
                if (lVar3 != null) {
                    lVar4 = this.bgk.bgf;
                    Set Oh = lVar4.Ot().Oh();
                    if (Oh != null && !Oh.isEmpty()) {
                        for (int size = threadList.size() - 1; size >= 0; size--) {
                            u uVar = threadList.get(size);
                            if (!Oh.contains(uVar.getType())) {
                                threadList.remove(uVar);
                            }
                        }
                    }
                }
                if (threadList.isEmpty()) {
                    z2 = this.bgk.mHasMore;
                    if (z2) {
                        aVar5 = this.bgk.bge;
                        aVar5.Os();
                        return;
                    }
                    this.bgk.hj(this.bgk.getResources().getString(n.i.no_data_text));
                    return;
                }
                aVar3 = this.bgk.bge;
                aVar3.setData(threadList);
                aVar4 = this.bgk.bge;
                ArrayList<u> qJ = aVar4.qJ();
                pVar2 = this.bgk.aZs;
                pVar2.am(qJ);
                lVar5 = this.bgk.bgf;
                if (lVar5 != null) {
                    lVar6 = this.bgk.bgf;
                    lVar6.hideNoDataView();
                    lVar7 = this.bgk.bgf;
                    ev Ot = lVar7.Ot();
                    pVar3 = this.bgk.aZs;
                    Ot.setFromCDN(pVar3.ajE() == 1);
                    lVar8 = this.bgk.bgf;
                    pVar4 = this.bgk.aZs;
                    z = this.bgk.mHasMore;
                    lVar8.a(qJ, pVar4, z);
                }
                this.bgk.MY();
                return;
            }
            this.bgk.hj(this.bgk.getResources().getString(n.i.no_data_text));
            return;
        }
        this.bgk.hj(this.bgk.getResources().getString(n.i.no_data_text));
    }
}
