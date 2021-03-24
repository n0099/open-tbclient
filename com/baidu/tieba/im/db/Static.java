package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import d.b.i0.d1.h.g;
/* loaded from: classes4.dex */
public class Static {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.im.db.Static$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0197a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f17908a;

            public C0197a(a aVar, CustomResponsedMessage customResponsedMessage) {
                this.f17908a = customResponsedMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (this.f17908a.getData() instanceof String) {
                    g.a((String) this.f17908a.getData());
                    return null;
                }
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements n<Void> {
            public b(a aVar) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r3) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008016));
            }
        }

        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2008015 || customResponsedMessage.getData() == null) {
                return;
            }
            h0.c(new C0197a(this, customResponsedMessage), new b(this));
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a(2008015));
    }
}
