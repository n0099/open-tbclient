package com.baidu.tieba.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a fdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.fdZ = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            if (booleanValue) {
                if (TbadkCoreApplication.isLogin()) {
                    if (TbadkCoreApplication.m9getInst().getLastUpdateMemberCenterTime() <= com.baidu.tbadk.core.sharedPref.b.uo().getLong("maintab_member_center_red_tip_" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        booleanValue = false;
                    }
                } else {
                    booleanValue = false;
                }
            }
            this.fdZ.fdP = true;
            this.fdZ.fdE = booleanValue;
            this.fdZ.bae();
        }
    }
}
