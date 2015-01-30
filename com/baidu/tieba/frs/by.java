package com.baidu.tieba.frs;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends CustomMessageListener {
    final /* synthetic */ bp aGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by(bp bpVar, int i) {
        super(i);
        this.aGj = bpVar;
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
            this.aGj.aFP = (com.baidu.tbadk.coreExtra.view.q) customResponsedMessage.getData();
            qVar = this.aGj.aFP;
            ImageView view = qVar.getView();
            view.setVisibility(8);
            view.setScaleType(ImageView.ScaleType.CENTER);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) TbadkCoreApplication.m255getInst().getApp().getResources().getDimension(com.baidu.tieba.u.navi_item_width), -1);
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            z = this.aGj.aGa;
            if (!z) {
                linearLayout = this.aGj.aFQ;
                linearLayout.addView(view);
                this.aGj.aGa = true;
            }
            qVar2 = this.aGj.aFP;
            qVar2.setStatisticsKey("frs_live_icon");
            qVar3 = this.aGj.aFP;
            qVar3.setVisibleChangeCallback(new bz(this));
            qVar4 = this.aGj.aFP;
            qVar4.tI();
        }
    }
}
