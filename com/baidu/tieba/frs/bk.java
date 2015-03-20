package com.baidu.tieba.frs;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends CustomMessageListener {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(bf bfVar, int i) {
        super(i);
        this.aLR = bfVar;
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
            this.aLR.aLD = (com.baidu.tbadk.coreExtra.view.q) customResponsedMessage.getData();
            qVar = this.aLR.aLD;
            ImageView view = qVar.getView();
            view.setVisibility(8);
            view.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TbadkCoreApplication.m411getInst().getApp().getResources().getDimension(com.baidu.tieba.t.navi_item_width), -1);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            z = this.aLR.aLK;
            if (!z) {
                linearLayout = this.aLR.aLE;
                linearLayout.addView(view);
                this.aLR.aLK = true;
            }
            qVar2 = this.aLR.aLD;
            qVar2.setStatisticsKey("frs_live_icon");
            qVar3 = this.aLR.aLD;
            qVar3.setVisibleChangeCallback(new bl(this));
            qVar4 = this.aLR.aLD;
            qVar4.wV();
        }
    }
}
