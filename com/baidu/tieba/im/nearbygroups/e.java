package com.baidu.tieba.im.nearbygroups;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.data.NearbyGroupsData;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.model.NearbyGroupsModel;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ NearbyGroupsActivity bgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(i);
        this.bgq = nearbyGroupsActivity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [347=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        NearbyGroupsModel nearbyGroupsModel;
        NearbyGroupsModel nearbyGroupsModel2;
        NearbyGroupsModel nearbyGroupsModel3;
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        NearbyGroupsModel nearbyGroupsModel4;
        if (socketResponsedMessage == null) {
            return;
        }
        if (socketResponsedMessage.getCmd() == 103105) {
            if (socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) {
                ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage;
                if (responseUpgradeMemberGroupMessage.getError() == 0 || responseUpgradeMemberGroupMessage.getError() == 2230110) {
                    nearbyGroupsModel4 = this.bgq.bgo;
                    nearbyGroupsModel4.sendMessage();
                }
            }
        } else if (socketResponsedMessage.getCmd() != 103009) {
            if (socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                    if (responseUserPermissionMessage.getError() > 0) {
                        this.bgq.showToast(responseUserPermissionMessage.getErrorString());
                        return;
                    }
                    GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                    if (groupPermData != null) {
                        if (groupPermData.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this.bgq, 2, 0, 1011, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                        } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                            this.bgq.showToast(groupPermData.getCreatePersonalTip());
                        }
                    }
                } catch (Exception e) {
                } finally {
                    this.bgq.hideProgressBar();
                }
            }
        } else {
            nearbyGroupsModel = this.bgq.bgo;
            nearbyGroupsModel.setIsLoading(false);
            if (!(socketResponsedMessage instanceof ResponseNearbyGroupsMessage)) {
                mVar4 = this.bgq.bgn;
                mVar4.Re();
                return;
            }
            com.baidu.tieba.im.c.Ji().C(System.currentTimeMillis());
            ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) socketResponsedMessage;
            if (responseNearbyGroupsMessage.getError() > 0) {
                this.bgq.showToast(responseNearbyGroupsMessage.getErrorString());
            } else {
                NearbyGroupsData nearbyGroups = responseNearbyGroupsMessage.getNearbyGroups();
                if (nearbyGroups != null) {
                    nearbyGroupsModel2 = this.bgq.bgo;
                    nearbyGroupsModel2.setHasMore(nearbyGroups.getHasMore());
                    nearbyGroupsModel3 = this.bgq.bgo;
                    nearbyGroupsModel3.setGeo(nearbyGroups.getGeo());
                    mVar = this.bgq.bgn;
                    mVar.a(nearbyGroups);
                }
            }
            mVar2 = this.bgq.bgn;
            mVar2.Re();
            mVar3 = this.bgq.bgn;
            mVar3.DI();
        }
    }
}
