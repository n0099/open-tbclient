package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.homepage.framework.c;
/* loaded from: classes7.dex */
class a extends CustomMessageTask {
    public a() {
        super(CmdConfigCustom.CMD_RECOMMEND_FRS_INIT_CONTROL_MODEL, new C0742a());
        setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
    }

    /* renamed from: com.baidu.tieba.homeExtra.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0742a implements CustomMessageTask.CustomRunnable<c> {
        private C0742a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            com.baidu.tieba.lego.model.a b2;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.cNv() == null && (b2 = com.baidu.tieba.lego.d.b.daV().b(data.cNu(), data.getUniqueId())) != null) {
                    b2.a(new b(data.cNw()));
                    data.a(b2);
                }
            }
            return null;
        }
    }
}
