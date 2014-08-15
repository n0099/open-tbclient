package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.an;
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
        an anVar;
        an anVar2;
        an anVar3;
        m mVar;
        m mVar2;
        m mVar3;
        boolean a;
        an anVar4;
        an anVar5;
        m mVar4;
        anVar = this.a.c;
        anVar.a(false);
        if (!(customResponsedMessage instanceof ResponseNearbyGroupsLocalMessage)) {
            mVar4 = this.a.b;
            mVar4.f();
            return;
        }
        if (customResponsedMessage.getCmd() == 2001115 && UtilHelper.isNetOk()) {
            a = this.a.a(com.baidu.tieba.im.c.a().e());
            if (a) {
                anVar5 = this.a.c;
                anVar5.h();
                return;
            }
            anVar4 = this.a.c;
            anVar4.g();
        }
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage;
        if (responseNearbyGroupsLocalMessage.getError() > 0) {
            this.a.showToast(responseNearbyGroupsLocalMessage.getErrorString());
        } else {
            NearbyGroupsData nearbyGroups = responseNearbyGroupsLocalMessage.getNearbyGroups();
            if (nearbyGroups != null) {
                anVar2 = this.a.c;
                anVar2.b(nearbyGroups.getHasMore());
                anVar3 = this.a.c;
                anVar3.a(nearbyGroups.getGeo());
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
