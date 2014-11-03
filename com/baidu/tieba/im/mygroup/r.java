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
    final /* synthetic */ n bgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(n nVar, int i) {
        super(i);
        this.bgm = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        PersonGroupActivity Ra;
        int i;
        l lVar;
        l lVar2;
        com.baidu.tbadk.core.view.o oVar;
        com.baidu.tbadk.core.view.o oVar2;
        Ra = this.bgm.Ra();
        if (this.bgm.getActivity() != null && this.bgm.bge != null && Ra != null && Ra.QW() != null) {
            ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = (ResponseGroupsByUidLocalMessage) customResponsedMessage;
            if (responseGroupsByUidLocalMessage.getError() != 0) {
                if (responseGroupsByUidLocalMessage.getError() != 0 && !TextUtils.isEmpty(responseGroupsByUidLocalMessage.getErrorString())) {
                    this.bgm.showToast(responseGroupsByUidLocalMessage.getErrorString());
                    return;
                }
                return;
            }
            if (Ra.Az()) {
                List<GroupInfoData> groups = responseGroupsByUidLocalMessage.getGroups();
                i = this.bgm.bgh;
                if (i == 1) {
                    groups = responseGroupsByUidLocalMessage.getCommonGroups();
                }
                Ra.P(responseGroupsByUidLocalMessage.getGroupNum(), responseGroupsByUidLocalMessage.getCommonGroupNum());
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
            }
            if (Ra.QW() != null) {
                Ra.QW().update();
            }
        }
    }
}
