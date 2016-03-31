package com.baidu.tieba.godSquare.model;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.godSquare.model.b;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b bKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.bKp = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        b.a aVar;
        b.a aVar2;
        List<u> a;
        boolean z;
        aVar = this.bKp.bKk;
        if (aVar != null) {
            if (!(customResponsedMessage instanceof GodSquareCacheResponsedMsg)) {
                this.bKp.il(1);
                return;
            }
            GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = (GodSquareCacheResponsedMsg) customResponsedMessage;
            if (godSquareCacheResponsedMsg.getResult() != null && !y.q(godSquareCacheResponsedMsg.getResult().user_list)) {
                aVar2 = this.bKp.bKk;
                a = this.bKp.a(godSquareCacheResponsedMsg.getResult());
                z = this.bKp.bKl;
                aVar2.a(a, z, true, godSquareCacheResponsedMsg.getErrorString());
                return;
            }
            this.bKp.il(1);
        }
    }
}
