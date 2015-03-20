package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ m blM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(m mVar, int i) {
        super(i);
        this.blM = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        com.baidu.tbadk.core.view.s sVar;
        com.baidu.tbadk.core.view.s sVar2;
        PersonGroupActivity SW = this.blM.SW();
        if (this.blM.getActivity() != null && this.blM.blD != null && SW != null && SW.SS() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.blM.blD.mW();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0) {
                    this.blM.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.blM.getResources().getString(y.neterror) : responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.blM.blH;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!SW.SR()) {
                SW.setGroups(responseGroupsByUidMessage.getGroups());
                SW.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            SW.R(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                kVar = this.blM.blE;
                kVar.aH(groups);
                kVar2 = this.blM.blE;
                kVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    sVar2 = this.blM.anM;
                    sVar2.setVisibility(8);
                } else {
                    sVar = this.blM.anM;
                    sVar.setVisibility(0);
                }
                this.blM.blD.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.blM.blG = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && SW.SS() != null) {
                SW.SS().update();
            }
        }
    }
}
