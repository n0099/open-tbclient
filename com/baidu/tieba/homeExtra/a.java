package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.homepage.framework.c;
/* loaded from: classes9.dex */
class a extends CustomMessageTask {
    public a() {
        super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL, new C0509a());
        setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
    }

    /* renamed from: com.baidu.tieba.homeExtra.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0509a implements CustomMessageTask.CustomRunnable<c> {
        private C0509a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            com.baidu.tieba.lego.model.a b;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.bLR() == null && (b = com.baidu.tieba.lego.d.b.cbH().b(data.bLQ(), data.getUniqueId())) != null) {
                    b.a(new b(data.bLS()));
                    data.a(b);
                }
            }
            return null;
        }
    }
}
