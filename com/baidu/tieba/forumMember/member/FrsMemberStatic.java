package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import d.b.j0.o0.b.c;
import d.b.j0.o0.b.d;
import d.b.j0.o0.c.f;
import d.b.j0.o0.c.g;
import d.b.j0.o0.c.h;
import d.b.j0.o0.c.i;
import d.b.j0.o0.c.j;
import d.b.j0.o0.c.k;
import d.b.j0.o0.c.l;
import d.b.j0.q0.f0;
import d.b.j0.q0.g0;
import d.b.j0.q0.n;
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
                absDelegateAdapterList.add(new g(null, h.f59156h));
                absDelegateAdapterList.add(new i(null, j.f59161g));
                absDelegateAdapterList.add(new f(null, n.f60024g));
                absDelegateAdapterList.add(new d.b.j0.o0.b.a(null, d.b.j0.o0.b.b.f59134f));
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
                d.b.j0.o0.c.d dVar = new d.b.j0.o0.c.d();
                dVar.E(f0Var.f59614e);
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
