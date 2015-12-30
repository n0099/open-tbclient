package com.baidu.tieba.discover;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.aRT = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
            boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
            dVar = this.aRT.aRG;
            List<D> DS = dVar.DS();
            if (DS != 0 && !DS.isEmpty()) {
                for (D d : DS) {
                    if (d != null && "discover_game_center".equals(d.Jq())) {
                        d.bV(booleanValue);
                        dVar2 = this.aRT.aRG;
                        dVar2.A(d);
                        return;
                    }
                }
            }
        }
    }
}
