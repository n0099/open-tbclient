package com.baidu.tieba.frs.collect;

import android.text.TextUtils;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyCollectFrsActivity myCollectFrsActivity, int i, int i2) {
        super(i, i2);
        this.bkc = myCollectFrsActivity;
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
        lVar = this.bkc.bjX;
        lVar.completePullRefresh();
        MyCollectFrsActivity myCollectFrsActivity = this.bkc;
        lVar2 = this.bkc.bjX;
        myCollectFrsActivity.hideLoadingView(lVar2.getRootView());
        if (responsedMessage.getError() != 0) {
            String string = TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.bkc.getResources().getString(n.j.neterror) : responsedMessage.getErrorString();
            this.bkc.mHasMore = false;
            lVar9 = this.bkc.bjX;
            lVar9.Om();
            this.bkc.showToast(string);
            this.bkc.hu(string);
            return;
        }
        com.baidu.tieba.tbadkCore.n nVar = null;
        int i = -1;
        if (responsedMessage instanceof GetUserForumStoreSocketResponseMessage) {
            GetUserForumStoreSocketResponseMessage getUserForumStoreSocketResponseMessage = (GetUserForumStoreSocketResponseMessage) responsedMessage;
            nVar = getUserForumStoreSocketResponseMessage.getResponseData();
            this.bkc.mHasMore = getUserForumStoreSocketResponseMessage.isHasMore();
            i = getUserForumStoreSocketResponseMessage.getType();
        } else if (responsedMessage instanceof GetUserForumStoreHttpResponseMessage) {
            GetUserForumStoreHttpResponseMessage getUserForumStoreHttpResponseMessage = (GetUserForumStoreHttpResponseMessage) responsedMessage;
            nVar = getUserForumStoreHttpResponseMessage.getResponseData();
            this.bkc.mHasMore = getUserForumStoreHttpResponseMessage.isHasMore();
            i = getUserForumStoreHttpResponseMessage.getType();
        }
        pVar = this.bkc.bdo;
        pVar.d(nVar);
        if (nVar != null) {
            ArrayList<u> threadList = nVar.getThreadList();
            if (threadList != null && !threadList.isEmpty()) {
                if (i == 0) {
                    aVar6 = this.bkc.bjW;
                    aVar6.gg(0);
                    aVar7 = this.bkc.bjW;
                    aVar7.clearData();
                }
                aVar = this.bkc.bjW;
                int OJ = aVar.OJ();
                aVar2 = this.bkc.bjW;
                aVar2.gg(OJ + threadList.size());
                lVar3 = this.bkc.bjX;
                if (lVar3 != null) {
                    lVar4 = this.bkc.bjX;
                    Set OA = lVar4.OL().OA();
                    if (OA != null && !OA.isEmpty()) {
                        for (int size = threadList.size() - 1; size >= 0; size--) {
                            u uVar = threadList.get(size);
                            if (!OA.contains(uVar.getType())) {
                                threadList.remove(uVar);
                            }
                        }
                    }
                }
                if (threadList.isEmpty()) {
                    z2 = this.bkc.mHasMore;
                    if (z2) {
                        aVar5 = this.bkc.bjW;
                        aVar5.OK();
                        return;
                    }
                    this.bkc.hu(this.bkc.getResources().getString(n.j.no_data_text));
                    return;
                }
                aVar3 = this.bkc.bjW;
                aVar3.setData(threadList);
                aVar4 = this.bkc.bjW;
                ArrayList<u> qs = aVar4.qs();
                pVar2 = this.bkc.bdo;
                pVar2.am(qs);
                lVar5 = this.bkc.bjX;
                if (lVar5 != null) {
                    lVar6 = this.bkc.bjX;
                    lVar6.hideNoDataView();
                    lVar7 = this.bkc.bjX;
                    ew OL = lVar7.OL();
                    pVar3 = this.bkc.bdo;
                    OL.setFromCDN(pVar3.akM() == 1);
                    lVar8 = this.bkc.bjX;
                    pVar4 = this.bkc.bdo;
                    z = this.bkc.mHasMore;
                    lVar8.a(qs, pVar4, z);
                }
                this.bkc.Ns();
                return;
            }
            this.bkc.hu(this.bkc.getResources().getString(n.j.no_data_text));
            return;
        }
        this.bkc.hu(this.bkc.getResources().getString(n.j.no_data_text));
    }
}
