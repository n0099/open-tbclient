package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.bd;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(i);
        this.a = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        m mVar;
        m mVar2;
        m mVar3;
        boolean a;
        bd bdVar4;
        bd bdVar5;
        m mVar4;
        bdVar = this.a.c;
        bdVar.a(false);
        if (!(customResponsedMessage instanceof ResponseNearbyGroupsLocalMessage)) {
            mVar4 = this.a.b;
            mVar4.f();
            return;
        }
        if (customResponsedMessage.getCmd() == 2001115 && UtilHelper.isNetOk()) {
            a = this.a.a(com.baidu.tieba.im.e.a().e());
            if (a) {
                bdVar5 = this.a.c;
                bdVar5.h();
                return;
            }
            bdVar4 = this.a.c;
            bdVar4.g();
        }
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage;
        if (responseNearbyGroupsLocalMessage.getError() > 0) {
            this.a.showToast(responseNearbyGroupsLocalMessage.getErrorString());
        } else {
            NearbyGroupsData nearbyGroups = responseNearbyGroupsLocalMessage.getNearbyGroups();
            if (nearbyGroups != null) {
                bdVar2 = this.a.c;
                bdVar2.b(nearbyGroups.getHasMore());
                bdVar3 = this.a.c;
                bdVar3.a(nearbyGroups.getGeo());
                mVar = this.a.b;
                mVar.a(nearbyGroups);
            }
        }
        mVar2 = this.a.b;
        mVar2.f();
        mVar3 = this.a.b;
        mVar3.c();
    }
}
