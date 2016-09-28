package com.baidu.tieba.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a feW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.feW = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.uh().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
            this.feW.feK = true;
            a aVar = this.feW;
            z = this.feW.feK;
            aVar.feD = z ? true : this.feW.feD;
            com.baidu.tbadk.core.sharedPref.b.uh().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            this.feW.bcp();
        }
    }
}
