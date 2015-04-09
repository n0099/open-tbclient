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
    final /* synthetic */ m bmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(m mVar, int i) {
        super(i);
        this.bmc = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        com.baidu.tbadk.core.view.s sVar;
        com.baidu.tbadk.core.view.s sVar2;
        PersonGroupActivity Tj = this.bmc.Tj();
        if (this.bmc.getActivity() != null && this.bmc.blT != null && Tj != null && Tj.Tf() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bmc.blT.mW();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0) {
                    this.bmc.showToast(StringUtils.isNull(responseGroupsByUidMessage.getErrorString()) ? this.bmc.getResources().getString(y.neterror) : responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.bmc.blX;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!Tj.Te()) {
                Tj.setGroups(responseGroupsByUidMessage.getGroups());
                Tj.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            Tj.R(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                kVar = this.bmc.blU;
                kVar.aJ(groups);
                kVar2 = this.bmc.blU;
                kVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    sVar2 = this.bmc.anU;
                    sVar2.setVisibility(8);
                } else {
                    sVar = this.bmc.anU;
                    sVar.setVisibility(0);
                }
                this.bmc.blT.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bmc.blW = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && Tj.Tf() != null) {
                Tj.Tf().update();
            }
        }
    }
}
