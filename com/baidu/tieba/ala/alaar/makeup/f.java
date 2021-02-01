package com.baidu.tieba.ala.alaar.makeup;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.ala.alaar.makeup.a;
import com.xiaomi.mipush.sdk.MiPushClient;
/* loaded from: classes11.dex */
public class f extends CustomMessageTask {
    public f() {
        super(2913246, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.alaar.makeup.f.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (h.isDebug()) {
                    h.d("MakeupDM_TASK", "GetMakeupDataTask run " + customMessage);
                }
                g.bPm().a(new a.b() { // from class: com.baidu.tieba.ala.alaar.makeup.f.1.1
                    @Override // com.baidu.tieba.ala.alaar.makeup.a.b
                    public void c(a aVar) {
                        com.baidu.live.ar.g gVar = new com.baidu.live.ar.g();
                        com.baidu.tieba.ala.alaar.makeup.a.c bPo = g.bPm().bPo();
                        gVar.bf(bPo != null && bPo.zv());
                        if (h.isDebug()) {
                            h.d("MakeupDM_TASK", "GetMakeupDataTask done " + gVar.zv());
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913246, gVar));
                    }
                });
                return null;
            }
        });
    }

    public void register() {
        if (h.isDebug()) {
            h.d("MakeupDM_TASK", MiPushClient.COMMAND_REGISTER);
        }
        MessageManager.getInstance().registerTask(this);
    }
}
