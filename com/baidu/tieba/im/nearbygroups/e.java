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
    final /* synthetic */ NearbyGroupsActivity bgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(NearbyGroupsActivity nearbyGroupsActivity, int i) {
        super(i);
        this.bgc = nearbyGroupsActivity;
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
                    nearbyGroupsModel4 = this.bgc.bga;
                    nearbyGroupsModel4.sendMessage();
                }
            }
        } else if (socketResponsedMessage.getCmd() != 103009) {
            if (socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                    if (responseUserPermissionMessage.getError() > 0) {
                        this.bgc.showToast(responseUserPermissionMessage.getErrorString());
                        return;
                    }
                    GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                    if (groupPermData != null) {
                        if (groupPermData.isCreatePersonal()) {
                            CreateGroupStepActivity.a(this.bgc, 2, 0, 1011, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                        } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                            this.bgc.showToast(groupPermData.getCreatePersonalTip());
                        }
                    }
                } catch (Exception e) {
                } finally {
                    this.bgc.hideProgressBar();
                }
            }
        } else {
            nearbyGroupsModel = this.bgc.bga;
            nearbyGroupsModel.setIsLoading(false);
            if (!(socketResponsedMessage instanceof ResponseNearbyGroupsMessage)) {
                mVar4 = this.bgc.bfZ;
                mVar4.Rb();
                return;
            }
            com.baidu.tieba.im.c.Je().C(System.currentTimeMillis());
            ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) socketResponsedMessage;
            if (responseNearbyGroupsMessage.getError() > 0) {
                this.bgc.showToast(responseNearbyGroupsMessage.getErrorString());
            } else {
                NearbyGroupsData nearbyGroups = responseNearbyGroupsMessage.getNearbyGroups();
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
}
