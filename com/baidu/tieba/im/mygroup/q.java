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
    final /* synthetic */ m bjB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(m mVar, int i) {
        super(i);
        this.bjB = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        x xVar;
        x xVar2;
        PersonGroupActivity RA = this.bjB.RA();
        if (this.bjB.getActivity() != null && this.bjB.bjs != null && RA != null && RA.Rw() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.bjB.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (RA.Rv()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.bjB.bjw;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                RA.X(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
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
            }
            if (RA.Rw() != null) {
                RA.Rw().update();
            }
        }
    }
}
