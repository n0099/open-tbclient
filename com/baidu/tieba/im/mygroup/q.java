package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ m bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(m mVar, int i) {
        super(i);
        this.bkX = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        x xVar;
        x xVar2;
        PersonGroupActivity RR = this.bkX.RR();
        if (this.bkX.getActivity() != null && this.bkX.bkO != null && RR != null && RR.RN() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.bkX.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (RR.RM()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.bkX.bkS;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                RR.Z(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
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
            }
            if (RR.RN() != null) {
                RR.RN().update();
            }
        }
    }
}
