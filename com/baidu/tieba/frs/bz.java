package com.baidu.tieba.frs;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends CustomMessageListener {
    final /* synthetic */ bq aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(bq bqVar, int i) {
        super(i);
        this.aFg = bqVar;
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
            this.aFg.aEM = (com.baidu.tbadk.coreExtra.view.q) customResponsedMessage.getData();
            qVar = this.aFg.aEM;
            ImageView view = qVar.getView();
            view.setVisibility(8);
            view.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TbadkCoreApplication.m255getInst().getApp().getResources().getDimension(com.baidu.tieba.u.navi_item_width), -1);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            z = this.aFg.aEX;
            if (!z) {
                linearLayout = this.aFg.aEN;
                linearLayout.addView(view);
                this.aFg.aEX = true;
            }
            qVar2 = this.aFg.aEM;
            qVar2.setStatisticsKey("frs_live_icon");
            qVar3 = this.aFg.aEM;
            qVar3.setVisibleChangeCallback(new ca(this));
            qVar4 = this.aFg.aEM;
            qVar4.tr();
        }
    }
}
