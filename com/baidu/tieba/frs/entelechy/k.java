package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ j bKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, int i) {
        super(i);
        this.bKz = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        View view;
        View view2;
        View view3;
        View view4;
        view = this.bKz.bWM;
        if (view != null && customResponsedMessage != null) {
            boolean booleanValue = (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) ? false : ((Boolean) customResponsedMessage.getData()).booleanValue();
            j jVar = this.bKz;
            view2 = this.bKz.bWM;
            jVar.bfZ = view2.findViewById(r.h.divider_bottom);
            if (booleanValue) {
                view4 = this.bKz.bfZ;
                view4.setVisibility(8);
                return;
            }
            view3 = this.bKz.bfZ;
            view3.setVisibility(0);
        }
    }
}
