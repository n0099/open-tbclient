package com.baidu.tieba.im.nearbygroups;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
import com.baidu.tieba.im.model.ay;
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
        ay ayVar;
        m mVar;
        m mVar2;
        m mVar3;
        ay ayVar2;
        ay ayVar3;
        boolean a;
        ay ayVar4;
        ay ayVar5;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        ayVar = this.a.c;
        ayVar.a(false);
        if (customResponsedMessage2 instanceof ResponseNearbyGroupsLocalMessage) {
            if (customResponsedMessage2.g() == 2001115 && UtilHelper.a()) {
                p.a();
                long f = p.f();
                NearbyGroupsActivity nearbyGroupsActivity = this.a;
                a = NearbyGroupsActivity.a(f);
                if (a) {
                    ayVar5 = this.a.c;
                    ayVar5.h();
                    return;
                }
                ayVar4 = this.a.c;
                ayVar4.g();
            }
            ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = (ResponseNearbyGroupsLocalMessage) customResponsedMessage2;
            if (responseNearbyGroupsLocalMessage.e() > 0) {
                this.a.showToast(responseNearbyGroupsLocalMessage.f());
            } else {
                NearbyGroupsData b = responseNearbyGroupsLocalMessage.b();
                if (b != null) {
                    ayVar2 = this.a.c;
                    ayVar2.b(b.getHasMore());
                    ayVar3 = this.a.c;
                    ayVar3.a(b.getGeo());
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
