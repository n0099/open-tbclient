package com.baidu.tieba.frs;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends CustomMessageListener {
    final /* synthetic */ bl aXC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(bl blVar, int i) {
        super(i);
        this.aXC = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.coreExtra.view.j jVar;
        boolean z;
        com.baidu.tbadk.coreExtra.view.j jVar2;
        com.baidu.tbadk.coreExtra.view.j jVar3;
        com.baidu.tbadk.coreExtra.view.j jVar4;
        LinearLayout linearLayout;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.coreExtra.view.j)) {
            this.aXC.aXo = (com.baidu.tbadk.coreExtra.view.j) customResponsedMessage.getData();
            jVar = this.aXC.aXo;
            ImageView view = jVar.getView();
            view.setVisibility(8);
            view.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TbadkCoreApplication.m411getInst().getApp().getResources().getDimension(i.d.navi_item_width), -1);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            z = this.aXC.aXt;
            if (!z) {
                linearLayout = this.aXC.aXp;
                linearLayout.addView(view);
                this.aXC.aXt = true;
            }
            jVar2 = this.aXC.aXo;
            jVar2.setStatisticsKey("frs_live_icon");
            jVar3 = this.aXC.aXo;
            jVar3.setVisibleChangeCallback(new bq(this));
            jVar4 = this.aXC.aXo;
            jVar4.yX();
        }
    }
}
