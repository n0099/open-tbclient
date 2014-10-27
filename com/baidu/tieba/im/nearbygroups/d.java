package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.NearbyGroupsModel;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ NearbyGroupsActivity bgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(i);
        this.bgc = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        NearbyGroupsModel nearbyGroupsModel;
        NearbyGroupsModel nearbyGroupsModel2;
        NearbyGroupsModel nearbyGroupsModel3;
        m mVar;
        m mVar2;
        m mVar3;
        boolean T;
        NearbyGroupsModel nearbyGroupsModel4;
        NearbyGroupsModel nearbyGroupsModel5;
        m mVar4;
        nearbyGroupsModel = this.bgc.bga;
        nearbyGroupsModel.setIsLoading(false);
        if (!(customResponsedMessage instanceof ResponseNearbyGroupsLocalMessage)) {
            mVar4 = this.bgc.bfZ;
            mVar4.Rb();
            return;
        }
        if (customResponsedMessage.getCmd() == 2001115 && com.baidu.adp.lib.util.j.fh()) {
            T = this.bgc.T(com.baidu.tieba.im.c.Je().Ji());
            if (T) {
                nearbyGroupsModel5 = this.bgc.bga;
                nearbyGroupsModel5.update();
                return;
            }
            nearbyGroupsModel4 = this.bgc.bga;
            nearbyGroupsModel4.setNextPage();
        }
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage;
        if (responseNearbyGroupsLocalMessage.getError() > 0) {
            this.bgc.showToast(responseNearbyGroupsLocalMessage.getErrorString());
        } else {
            NearbyGroupsData nearbyGroups = responseNearbyGroupsLocalMessage.getNearbyGroups();
            if (nearbyGroups != null) {
                nearbyGroupsModel2 = this.bgc.bga;
                nearbyGroupsModel2.setHasMore(nearbyGroups.getHasMore());
                nearbyGroupsModel3 = this.bgc.bga;
                nearbyGroupsModel3.setGeo(nearbyGroups.getGeo());
                mVar = this.bgc.bfZ;
                mVar.a(nearbyGroups);
            }
        }
        mVar2 = this.bgc.bfZ;
        mVar2.Rb();
        mVar3 = this.bgc.bfZ;
        mVar3.DG();
    }
}
