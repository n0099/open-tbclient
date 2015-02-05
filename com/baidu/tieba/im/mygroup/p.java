package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ m bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(m mVar, int i) {
        super(i);
        this.bkX = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        x xVar;
        x xVar2;
        PersonGroupActivity RR = this.bkX.RR();
        if (this.bkX.getActivity() != null && this.bkX.bkO != null && RR != null && RR.RN() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bkX.bkO.jB();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrorString())) {
                    this.bkX.showToast(responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.bkX.bkS;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!RR.RM()) {
                RR.setGroups(responseGroupsByUidMessage.getGroups());
                RR.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            RR.Z(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                kVar = this.bkX.bkP;
                kVar.aA(groups);
                kVar2 = this.bkX.bkP;
                kVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    xVar2 = this.bkX.afq;
                    xVar2.setVisibility(8);
                } else {
                    xVar = this.bkX.afq;
                    xVar.setVisibility(0);
                }
                this.bkX.bkO.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bkX.bkR = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && RR.RN() != null) {
                RR.RN().update();
            }
        }
    }
}
