package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import d.b.c.j.e.p;
import d.b.i0.e.a.a;
import d.b.i0.e.d;
import d.b.i0.e.e.b;
import d.b.i0.e.e.c;
import d.b.i0.e.e.e;
import d.b.i0.e.e.h;
/* loaded from: classes4.dex */
public class FrsBannerAdStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0181a implements a.InterfaceC1249a {
            public C0181a(a aVar) {
            }

            @Override // d.b.i0.e.a.a.InterfaceC1249a
            public void a(c cVar, View view) {
                b a2 = h.a(cVar);
                if (a2 != null) {
                    d dVar = new d();
                    dVar.f55074a = 2;
                    dVar.b(view);
                    a2.dispatchInjectPluginMessage(dVar);
                }
            }

            @Override // d.b.i0.e.a.a.InterfaceC1249a
            public void b(c cVar, View view) {
                b a2 = h.a(cVar);
                if (a2 != null) {
                    d dVar = new d();
                    dVar.f55074a = 3;
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
            d.b.i0.e.f.a aVar;
            TbPageContext b2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.b.i0.e.f.a) || (b2 = (aVar = (d.b.i0.e.f.a) customResponsedMessage.getData()).b()) == null || !(b2.getPageActivity() instanceof b)) {
                return;
            }
            b bVar = (b) b2.getPageActivity();
            d.b.i0.e.e.a injectPlugin = bVar.getInjectPlugin(2);
            if (injectPlugin == null) {
                d.b.i0.e.e.d a2 = e.b().a(2);
                if (a2 == null) {
                    return;
                }
                injectPlugin = a2.a();
                bVar.setInjectPlugin(2, injectPlugin);
                injectPlugin.n(new c(b2));
                if (!(injectPlugin instanceof d.b.i0.e.a.a)) {
                    return;
                }
                ((d.b.i0.e.a.a) injectPlugin).d(new C0181a(this));
            }
            if (injectPlugin instanceof d.b.i0.e.a.a) {
                d.b.i0.e.a.a aVar2 = (d.b.i0.e.a.a) injectPlugin;
                if (aVar.a() == 1) {
                    aVar2.b(aVar.g());
                    aVar2.c(aVar.d());
                    aVar2.g();
                } else if (aVar.a() == 2) {
                    aVar2.j(aVar.f());
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
