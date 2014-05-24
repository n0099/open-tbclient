package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.model.be;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ NearbyGroupsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(i);
        this.a = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [356=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        be beVar;
        m mVar;
        m mVar2;
        be beVar2;
        be beVar3;
        m mVar3;
        m mVar4;
        be beVar4;
        if (socketResponsedMessage == null) {
            return;
        }
        if (socketResponsedMessage.getCmd() == 103105) {
            if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    beVar4 = this.a.c;
                    beVar4.d();
                }
            }
        } else if (socketResponsedMessage.getCmd() != 103009) {
            if (socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                    if (responseUserPermissionMessage.getError() > 0) {
                        this.a.showToast(responseUserPermissionMessage.getErrorString());
                        return;
                    }
                    GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                    if (groupPermData != null) {
                        if (groupPermData.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this.a, 2, 0, 1011, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                        } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                            this.a.showToast(groupPermData.getCreatePersonalTip());
                        }
                    }
                } catch (Exception e) {
                } finally {
                    this.a.hideProgressBar();
                }
            }
        } else {
            beVar = this.a.c;
            beVar.a(false);
            if (!(socketResponsedMessage instanceof ResponseNearbyGroupsMessage)) {
                mVar4 = this.a.b;
                mVar4.e();
                return;
            }
            com.baidu.tieba.im.e.a().a(System.currentTimeMillis());
            ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) socketResponsedMessage;
            if (responseNearbyGroupsMessage.getError() > 0) {
                this.a.showToast(responseNearbyGroupsMessage.getErrorString());
            } else {
                NearbyGroupsData nearbyGroups = responseNearbyGroupsMessage.getNearbyGroups();
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
}
