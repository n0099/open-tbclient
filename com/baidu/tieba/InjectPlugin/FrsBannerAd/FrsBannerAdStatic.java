package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import d.a.c.k.e.p;
import d.a.o0.e.a.a;
import d.a.o0.e.d;
import d.a.o0.e.e.b;
import d.a.o0.e.e.c;
import d.a.o0.e.e.e;
import d.a.o0.e.e.h;
/* loaded from: classes4.dex */
public class FrsBannerAdStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0169a implements a.InterfaceC1307a {
            public C0169a(a aVar) {
            }

            @Override // d.a.o0.e.a.a.InterfaceC1307a
            public void a(c cVar, View view) {
                b a2 = h.a(cVar);
                if (a2 != null) {
                    d dVar = new d();
                    dVar.f56557a = 2;
                    dVar.b(view);
                    a2.dispatchInjectPluginMessage(dVar);
                }
            }

            @Override // d.a.o0.e.a.a.InterfaceC1307a
            public void b(c cVar, View view) {
                b a2 = h.a(cVar);
                if (a2 != null) {
                    d dVar = new d();
                    dVar.f56557a = 3;
                    dVar.b(view);
                    a2.dispatchInjectPluginMessage(dVar);
                }
            }
        }

        public a() {
            super(2016516);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.o0.e.f.a aVar;
            TbPageContext b2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.o0.e.f.a) || (b2 = (aVar = (d.a.o0.e.f.a) customResponsedMessage.getData()).b()) == null || !(b2.getPageActivity() instanceof b)) {
                return;
            }
            b bVar = (b) b2.getPageActivity();
            d.a.o0.e.e.a injectPlugin = bVar.getInjectPlugin(2);
            if (injectPlugin == null) {
                d.a.o0.e.e.d a2 = e.b().a(2);
                if (a2 == null) {
                    return;
                }
                injectPlugin = a2.a();
                bVar.setInjectPlugin(2, injectPlugin);
                injectPlugin.o(new c(b2));
                if (!(injectPlugin instanceof d.a.o0.e.a.a)) {
                    return;
                }
                ((d.a.o0.e.a.a) injectPlugin).g(new C0169a(this));
            }
            if (injectPlugin instanceof d.a.o0.e.a.a) {
                d.a.o0.e.a.a aVar2 = (d.a.o0.e.a.a) injectPlugin;
                if (aVar.a() == 1) {
                    aVar2.b(aVar.g());
                    aVar2.c(aVar.d());
                    aVar2.i();
                } else if (aVar.a() == 2) {
                    aVar2.k(aVar.f());
                } else if (aVar.a() == 3) {
                    p e2 = aVar.e();
                    if (e2 == null || aVar2.getView() == null) {
                        return;
                    }
                    e2.removeHeaderView(aVar2.getView());
                } else if (aVar.a() == 4) {
                    aVar2.a(aVar.h());
                }
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a());
    }
}
