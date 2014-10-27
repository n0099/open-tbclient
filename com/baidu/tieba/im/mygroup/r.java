package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CustomMessageListener {
    final /* synthetic */ n bfY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(n nVar, int i) {
        super(i);
        this.bfY = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonGroupActivity QX;
        int i;
        l lVar;
        l lVar2;
        com.baidu.tbadk.core.view.o oVar;
        com.baidu.tbadk.core.view.o oVar2;
        QX = this.bfY.QX();
        if (this.bfY.getActivity() != null && this.bfY.bfQ != null && QX != null && QX.QT() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.bfY.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (QX.Ax()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.bfY.bfT;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                QX.P(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
                if (groups != null) {
                    lVar = this.bfY.bfR;
                    lVar.aa(groups);
                    lVar2 = this.bfY.bfR;
                    lVar2.notifyDataSetChanged();
                    if (groups.size() > 0) {
                        oVar2 = this.bfY.Yj;
                        oVar2.setVisibility(8);
                    } else {
                        oVar = this.bfY.Yj;
                        oVar.setVisibility(0);
                    }
                    this.bfY.bfQ.setVisibility(0);
                }
            }
            if (QX.QT() != null) {
                QX.QT().update();
            }
        }
    }
}
