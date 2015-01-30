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
    final /* synthetic */ m bkY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(m mVar, int i) {
        super(i);
        this.bkY = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        x xVar;
        x xVar2;
        PersonGroupActivity RW = this.bkY.RW();
        if (this.bkY.getActivity() != null && this.bkY.bkP != null && RW != null && RW.RS() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bkY.bkP.jI();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrorString())) {
                    this.bkY.showToast(responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.bkY.bkT;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!RW.RR()) {
                RW.setGroups(responseGroupsByUidMessage.getGroups());
                RW.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            RW.Y(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                kVar = this.bkY.bkQ;
                kVar.aA(groups);
                kVar2 = this.bkY.bkQ;
                kVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    xVar2 = this.bkY.aft;
                    xVar2.setVisibility(8);
                } else {
                    xVar = this.bkY.aft;
                    xVar.setVisibility(0);
                }
                this.bkY.bkP.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bkY.bkS = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && RW.RS() != null) {
                RW.RS().update();
            }
        }
    }
}
