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
    final /* synthetic */ m bjB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(m mVar, int i) {
        super(i);
        this.bjB = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        x xVar;
        x xVar2;
        PersonGroupActivity RA = this.bjB.RA();
        if (this.bjB.getActivity() != null && this.bjB.bjs != null && RA != null && RA.Rw() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bjB.bjs.jJ();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrorString())) {
                    this.bjB.showToast(responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.bjB.bjw;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!RA.Rv()) {
                RA.setGroups(responseGroupsByUidMessage.getGroups());
                RA.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            RA.X(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                kVar = this.bjB.bjt;
                kVar.ax(groups);
                kVar2 = this.bjB.bjt;
                kVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    xVar2 = this.bjB.aeW;
                    xVar2.setVisibility(8);
                } else {
                    xVar = this.bjB.aeW;
                    xVar.setVisibility(0);
                }
                this.bjB.bjs.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bjB.bjv = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && RA.Rw() != null) {
                RA.Rw().update();
            }
        }
    }
}
