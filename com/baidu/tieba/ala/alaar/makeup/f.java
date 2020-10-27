package com.baidu.tieba.ala.alaar.makeup;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.ala.alaar.makeup.a;
/* loaded from: classes4.dex */
public class f extends CustomMessageTask {
    public f() {
        super(2913246, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.alaar.makeup.f.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (h.isDebug()) {
                    h.d("MakeupDM_TASK", "GetMakeupDataTask run " + customMessage);
                }
                g.bKv().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.makeup.f.1.1
                    @Override // com.baidu.tieba.ala.alaar.makeup.a.b
                    public void c(a aVar) {
                        com.baidu.live.ar.e eVar = new com.baidu.live.ar.e();
                        com.baidu.tieba.ala.alaar.makeup.a.c bKx = g.bKv().bKx();
                        eVar.aZ(bKx != null && bKx.Ca());
                        if (h.isDebug()) {
                            h.d("MakeupDM_TASK", "GetMakeupDataTask done " + eVar.Ca());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913246, eVar));
                    }
                });
                return null;
            }
        });
    }

    public void register() {
        if (h.isDebug()) {
            h.d("MakeupDM_TASK", "register");
        }
        MessageManager.getInstance().registerTask(this);
    }
}
