package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.ax;
import com.baidu.tieba.im.p;
/* loaded from: classes.dex */
final class d extends com.baidu.adp.framework.c.a {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(2001115);
        this.a = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        m mVar;
        m mVar2;
        m mVar3;
        ax axVar2;
        ax axVar3;
        boolean a;
        ax axVar4;
        ax axVar5;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        axVar = this.a.c;
        axVar.a(false);
        if (customResponsedMessage2 instanceof ResponseNearbyGroupsLocalMessage) {
            if (customResponsedMessage2.g() == 2001115 && UtilHelper.a()) {
                p.a();
                long g = p.g();
                NearbyGroupsActivity nearbyGroupsActivity = this.a;
                a = NearbyGroupsActivity.a(g);
                if (a) {
                    axVar5 = this.a.c;
                    axVar5.h();
                    return;
                }
                axVar4 = this.a.c;
                axVar4.g();
            }
            ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage2;
            if (responseNearbyGroupsLocalMessage.e() > 0) {
                this.a.showToast(responseNearbyGroupsLocalMessage.f());
            } else {
                NearbyGroupsData b = responseNearbyGroupsLocalMessage.b();
                if (b != null) {
                    axVar2 = this.a.c;
                    axVar2.b(b.getHasMore());
                    axVar3 = this.a.c;
                    axVar3.a(b.getGeo());
                } else {
                    b = new NearbyGroupsData();
                }
                mVar2 = this.a.b;
                mVar2.a(b);
                if (b != null && b.size() > 0) {
                    mVar3 = this.a.b;
                    mVar3.a();
                }
            }
        }
        mVar = this.a.b;
        mVar.g();
    }
}
