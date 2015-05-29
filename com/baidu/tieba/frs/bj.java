package com.baidu.tieba.frs;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends CustomMessageListener {
    final /* synthetic */ bf aOm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bf bfVar, int i) {
        super(i);
        this.aOm = bfVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.coreExtra.view.q qVar;
        boolean z;
        com.baidu.tbadk.coreExtra.view.q qVar2;
        com.baidu.tbadk.coreExtra.view.q qVar3;
        com.baidu.tbadk.coreExtra.view.q qVar4;
        LinearLayout linearLayout;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.view.q)) {
            this.aOm.aNX = (com.baidu.tbadk.coreExtra.view.q) customResponsedMessage.getData();
            qVar = this.aOm.aNX;
            ImageView view = qVar.getView();
            view.setVisibility(8);
            view.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TbadkCoreApplication.m411getInst().getApp().getResources().getDimension(com.baidu.tieba.o.navi_item_width), -1);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            z = this.aOm.aOe;
            if (!z) {
                linearLayout = this.aOm.aNY;
                linearLayout.addView(view);
                this.aOm.aOe = true;
            }
            qVar2 = this.aOm.aNX;
            qVar2.setStatisticsKey("frs_live_icon");
            qVar3 = this.aOm.aNX;
            qVar3.setVisibleChangeCallback(new bk(this));
            qVar4 = this.aOm.aNX;
            qVar4.xN();
        }
    }
}
