package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.aKG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            dVar = this.aKG.aKt;
            List<D> Dj = dVar.Dj();
            if (Dj != 0 && !Dj.isEmpty()) {
                for (D d : Dj) {
                    if (d != null && "discover_game_center".equals(d.HJ())) {
                        d.bH(booleanValue);
                        dVar2 = this.aKG.aKt;
                        dVar2.A(d);
                        return;
                    }
                }
            }
        }
    }
}
