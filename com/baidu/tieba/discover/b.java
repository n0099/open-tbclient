package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.aDS = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mvc.j.d dVar;
        com.baidu.tbadk.mvc.j.d dVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            dVar = this.aDS.aDF;
            List<D> CM = dVar.CM();
            if (CM != 0 && !CM.isEmpty()) {
                for (D d : CM) {
                    if (d != null && "discover_game_center".equals(d.Hp())) {
                        d.bD(booleanValue);
                        dVar2 = this.aDS.aDF;
                        dVar2.y(d);
                        return;
                    }
                }
            }
        }
    }
}
