package com.baidu.tieba.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ a fmo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.fmo = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        if (customResponsedMessage != null && com.baidu.tbadk.core.sharedPref.b.um().getLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L) < TbadkCoreApplication.m9getInst().getLastUpdateThemeTime()) {
            this.fmo.fmc = true;
            a aVar = this.fmo;
            z = this.fmo.fmc;
            aVar.flV = z ? true : this.fmo.flV;
            com.baidu.tbadk.core.sharedPref.b.um().putLong("left_nav_dressup_center_" + TbadkCoreApplication.getCurrentAccount(), 0L);
            this.fmo.beQ();
        }
    }
}
