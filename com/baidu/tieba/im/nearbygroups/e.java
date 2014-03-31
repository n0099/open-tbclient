package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.model.ax;
import com.baidu.tieba.im.p;
/* loaded from: classes.dex */
final class e extends com.baidu.adp.framework.c.g {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(0);
        this.a = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        ax axVar;
        m mVar;
        m mVar2;
        ax axVar2;
        ax axVar3;
        m mVar3;
        m mVar4;
        ax axVar4;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.g() == 103105) {
                if (socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) {
                    ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage2;
                    if (responseUpgradeMemberGroupMessage.e() == 0 || responseUpgradeMemberGroupMessage.e() == 2230110) {
                        axVar4 = this.a.c;
                        axVar4.d();
                    }
                }
            } else if (socketResponsedMessage2.g() != 103009) {
                if (socketResponsedMessage2.g() == 103008 && (socketResponsedMessage2 instanceof ResponseUserPermissionMessage)) {
                    try {
                        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage2;
                        if (responseUserPermissionMessage.e() > 0) {
                            this.a.showToast(responseUserPermissionMessage.f());
                            return;
                        }
                        GroupPermData d = responseUserPermissionMessage.d();
                        if (d != null) {
                            if (d.isCreatePersonal()) {
                                CreateGroupStepActivity.a(this.a, 2, 0, 1011, d.getCanCreateNormalNum(), d.getCanCreateOfficialNum(), d.getCanCreatePersonalNum());
                            } else if (!TextUtils.isEmpty(d.getCreatePersonalTip())) {
                                this.a.showToast(d.getCreatePersonalTip());
                            }
                        }
                    } catch (Exception e) {
                    } finally {
                        this.a.hideProgressBar();
                    }
                }
            } else {
                axVar = this.a.c;
                axVar.a(false);
                if (!(socketResponsedMessage2 instanceof ResponseNearbyGroupsMessage)) {
                    mVar4 = this.a.b;
                    mVar4.g();
                    return;
                }
                p.a();
                p.a(System.currentTimeMillis());
                ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) socketResponsedMessage2;
                if (responseNearbyGroupsMessage.e() > 0) {
                    this.a.showToast(responseNearbyGroupsMessage.f());
                } else {
                    NearbyGroupsData d2 = responseNearbyGroupsMessage.d();
                    if (d2 != null) {
                        axVar2 = this.a.c;
                        axVar2.b(d2.getHasMore());
                        axVar3 = this.a.c;
                        axVar3.a(d2.getGeo());
                    } else {
                        d2 = new NearbyGroupsData();
                    }
                    mVar = this.a.b;
                    mVar.a(d2);
                    if (d2 != null && d2.size() > 0) {
                        mVar2 = this.a.b;
                        mVar2.a();
                    }
                }
                mVar3 = this.a.b;
                mVar3.g();
            }
        }
    }
}
