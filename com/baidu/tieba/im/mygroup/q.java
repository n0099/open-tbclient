package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ n bgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(n nVar, int i) {
        super(i);
        this.bgm = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonGroupActivity Ra;
        int i;
        l lVar;
        l lVar2;
        com.baidu.tbadk.core.view.o oVar;
        com.baidu.tbadk.core.view.o oVar2;
        Ra = this.bgm.Ra();
        if (this.bgm.getActivity() != null && this.bgm.bge != null && Ra != null && Ra.QW() != null) {
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bgm.bge.hN();
            }
            ResponseGroupsByUidMessage responseGroupsByUidMessage = (ResponseGroupsByUidMessage) socketResponsedMessage;
            if (responseGroupsByUidMessage.getError() != 0) {
                if (responseGroupsByUidMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidMessage.getErrorString())) {
                    this.bgm.showToast(responseGroupsByUidMessage.getErrorString());
                    return;
                }
                return;
            }
            List<GroupInfoData> groups = responseGroupsByUidMessage.getGroups();
            i = this.bgm.bgh;
            if (i == 1) {
                groups = responseGroupsByUidMessage.getCommonGroups();
            }
            if (!Ra.Az()) {
                Ra.setGroups(responseGroupsByUidMessage.getGroups());
                Ra.setCommonGroups(responseGroupsByUidMessage.getCommonGroups());
            }
            Ra.P(responseGroupsByUidMessage.getGroupNum(), responseGroupsByUidMessage.getCommonGroupNum());
            if (groups != null) {
                lVar = this.bgm.bgf;
                lVar.aa(groups);
                lVar2 = this.bgm.bgf;
                lVar2.notifyDataSetChanged();
                if (groups.size() > 0) {
                    oVar2 = this.bgm.Yn;
                    oVar2.setVisibility(8);
                } else {
                    oVar = this.bgm.Yn;
                    oVar.setVisibility(0);
                }
                this.bgm.bge.setVisibility(0);
            }
            if (socketResponsedMessage.getCmd() == 103003) {
                this.bgm.bcG = false;
            } else if (socketResponsedMessage.getCmd() == 2001106 && Ra.QW() != null) {
                Ra.QW().update();
            }
        }
    }
}
