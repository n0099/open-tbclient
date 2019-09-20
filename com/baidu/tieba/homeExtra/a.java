package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.homepage.framework.c;
/* loaded from: classes6.dex */
class a extends CustomMessageTask {
    public a() {
        super(2001406, new C0334a());
        setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
    }

    /* renamed from: com.baidu.tieba.homeExtra.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0334a implements CustomMessageTask.CustomRunnable<c> {
        private C0334a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            com.baidu.tieba.lego.model.a b;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.bwu() == null && (b = com.baidu.tieba.lego.d.b.bME().b(data.bwt(), data.getUniqueId())) != null) {
                    b.a(new b(data.bwv()));
                    data.a(b);
                }
            }
            return null;
        }
    }
}
