package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.be;
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
        be beVar;
        m mVar;
        m mVar2;
        be beVar2;
        be beVar3;
        m mVar3;
        boolean a;
        be beVar4;
        be beVar5;
        m mVar4;
        beVar = this.a.c;
        beVar.a(false);
        if (!(customResponsedMessage instanceof ResponseNearbyGroupsLocalMessage)) {
            mVar4 = this.a.b;
            mVar4.e();
            return;
        }
        if (customResponsedMessage.getCmd() == 2003115 && UtilHelper.isNetOk()) {
            a = this.a.a(com.baidu.tieba.im.e.a().e());
            if (a) {
                beVar5 = this.a.c;
                beVar5.h();
                return;
            }
            beVar4 = this.a.c;
            beVar4.g();
        }
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage;
        if (responseNearbyGroupsLocalMessage.getError() > 0) {
            this.a.showToast(responseNearbyGroupsLocalMessage.getErrorString());
        } else {
            NearbyGroupsData nearbyGroups = responseNearbyGroupsLocalMessage.getNearbyGroups();
            if (nearbyGroups != null) {
                beVar2 = this.a.c;
                beVar2.b(nearbyGroups.getHasMore());
                beVar3 = this.a.c;
                beVar3.a(nearbyGroups.getGeo());
            } else {
                nearbyGroups = new NearbyGroupsData();
            }
            mVar = this.a.b;
            mVar.a(nearbyGroups);
            if (nearbyGroups != null && nearbyGroups.size() > 0) {
                mVar2 = this.a.b;
                mVar2.a();
            }
        }
        mVar3 = this.a.b;
        mVar3.e();
    }
}
