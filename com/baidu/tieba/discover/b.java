package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a asV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.asV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mvc.j.c cVar;
        com.baidu.tbadk.mvc.j.c cVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            cVar = this.asV.asM;
            List<D> yw = cVar.yw();
            if (yw != 0 && !yw.isEmpty()) {
                for (D d : yw) {
                    if (d != null && "discover_game_center".equals(d.CS())) {
                        d.bs(booleanValue);
                        cVar2 = this.asV.asM;
                        cVar2.x((com.baidu.tbadk.mvc.j.c) d);
                        return;
                    }
                }
            }
        }
    }
}
