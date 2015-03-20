package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ m blM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(m mVar, int i) {
        super(i);
        this.blM = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        k kVar;
        k kVar2;
        com.baidu.tbadk.core.view.s sVar;
        com.baidu.tbadk.core.view.s sVar2;
        PersonGroupActivity SW = this.blM.SW();
        if (this.blM.getActivity() != null && this.blM.blD != null && SW != null && SW.SS() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.blM.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (SW.SR()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.blM.blH;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                SW.R(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
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
            }
            if (SW.SS() != null) {
                SW.SS().update();
            }
        }
    }
}
