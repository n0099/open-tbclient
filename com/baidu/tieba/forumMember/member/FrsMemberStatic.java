package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import d.a.n0.p0.b.c;
import d.a.n0.p0.b.d;
import d.a.n0.p0.c.f;
import d.a.n0.p0.c.g;
import d.a.n0.p0.c.h;
import d.a.n0.p0.c.i;
import d.a.n0.p0.c.j;
import d.a.n0.p0.c.k;
import d.a.n0.p0.c.l;
import d.a.n0.r0.f0;
import d.a.n0.r0.g0;
import d.a.n0.r0.n;
/* loaded from: classes4.dex */
public class FrsMemberStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                absDelegateAdapterList.add(new g(null, h.f57999h));
                absDelegateAdapterList.add(new i(null, j.f58004g));
                absDelegateAdapterList.add(new f(null, n.f58986g));
                absDelegateAdapterList.add(new d.a.n0.p0.b.a(null, d.a.n0.p0.b.b.f57975f));
                absDelegateAdapterList.add(new c(null, d.k));
                absDelegateAdapterList.add(new k(null, l.f58008i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003011 && (customResponsedMessage.getData() instanceof f0)) {
                f0 f0Var = (f0) customResponsedMessage.getData();
                d.a.n0.p0.c.d dVar = new d.a.n0.p0.c.d();
                dVar.E(f0Var.f58554e);
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
