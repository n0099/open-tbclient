package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import d.b.i0.n0.b.c;
import d.b.i0.n0.b.d;
import d.b.i0.n0.c.f;
import d.b.i0.n0.c.g;
import d.b.i0.n0.c.h;
import d.b.i0.n0.c.i;
import d.b.i0.n0.c.j;
import d.b.i0.n0.c.k;
import d.b.i0.n0.c.l;
import d.b.i0.p0.f0;
import d.b.i0.p0.g0;
import d.b.i0.p0.n;
/* loaded from: classes4.dex */
public class FrsMemberStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new g(null, h.f57036h));
                absDelegateAdapterList.add(new i(null, j.f57041g));
                absDelegateAdapterList.add(new f(null, n.f57932g));
                absDelegateAdapterList.add(new d.b.i0.n0.b.a(null, d.b.i0.n0.b.b.f57014f));
                absDelegateAdapterList.add(new c(null, d.k));
                absDelegateAdapterList.add(new k(null, l.i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof f0)) {
                f0 f0Var = (f0) customResponsedMessage.getData();
                d.b.i0.n0.c.d dVar = new d.b.i0.n0.c.d();
                dVar.E(f0Var.f57494e);
                f0Var.a(3, dVar);
            }
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(ForumMemberActivityConfig.class, ForumMemberActivity.class);
        g0.a().c(3);
        MessageManager.getInstance().registerListener(new a(2003008));
        MessageManager.getInstance().registerListener(new b(2003011));
    }
}
