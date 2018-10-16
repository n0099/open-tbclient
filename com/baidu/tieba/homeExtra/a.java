package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.homepage.framework.c;
/* loaded from: classes3.dex */
class a extends CustomMessageTask {
    public a() {
        super(2001406, new C0198a());
        setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
    }

    /* renamed from: com.baidu.tieba.homeExtra.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0198a implements CustomMessageTask.CustomRunnable<c> {
        private C0198a() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            com.baidu.tieba.lego.model.a b;
            if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof c)) {
                c data = customMessage.getData();
                if (data.aJp() == null && (b = com.baidu.tieba.lego.d.b.aYg().b(data.aJo(), data.getUniqueId())) != null) {
                    b.a(new b(data.aJq()));
                    data.a(b);
                }
            }
            return null;
        }
    }
}
