package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.e.e.c;
import d.a.n0.e.e.d;
import d.a.n0.e.e.e;
import d.a.n0.e.f.b;
import d.a.n0.t2.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFeedAdStatic {

    /* loaded from: classes4.dex */
    public static final class a extends CustomMessageListener {
        public a() {
            super(2016515);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bVar;
            d.a.n0.e.e.b c2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b) || (c2 = (bVar = (b) customResponsedMessage.getData()).c()) == null || !(c2 instanceof u)) {
                return;
            }
            u uVar = (u) c2;
            d.a.n0.e.e.a injectPlugin = c2.getInjectPlugin(1);
            if (injectPlugin == null) {
                d a2 = e.b().a(1);
                if (a2 == null) {
                    return;
                }
                injectPlugin = a2.a();
                c2.setInjectPlugin(1, injectPlugin);
                injectPlugin.o(new c(uVar));
            }
            if (injectPlugin instanceof d.a.n0.e.b.d) {
                d.a.n0.e.b.d dVar = (d.a.n0.e.b.d) injectPlugin;
                if (bVar.a() == 1) {
                    List list = (List) bVar.f();
                    d.a.n0.e.b.b.c(dVar.d());
                    for (BdUniqueId bdUniqueId : d.a.n0.e.b.b.e()) {
                        d.a.n0.e.b.a aVar = new d.a.n0.e.b.a(uVar, bdUniqueId);
                        aVar.e0(uVar.p());
                        list.add(aVar);
                    }
                } else if (bVar.a() == 2) {
                    dVar.j(bVar.d());
                } else if (bVar.a() == 3) {
                    List<n> n = bVar.n();
                    List<d.a.n0.e.b.c> d2 = FrsFeedAdStatic.d(n);
                    if (bVar.p()) {
                        dVar.n(d2, FrsFeedAdStatic.d(bVar.k()), bVar.o(), bVar.e());
                    } else {
                        dVar.h(d2, bVar.e());
                    }
                    n.clear();
                    n.addAll(FrsFeedAdStatic.c(d2));
                } else if (bVar.a() == 4) {
                    dVar.a(bVar.m());
                } else if (bVar.a() == 5) {
                    dVar.e(FrsFeedAdStatic.d(bVar.n()), bVar.h(), bVar.g(), bVar.l(), bVar.i(), bVar.q(), bVar.j());
                }
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a());
    }

    public static List<n> c(List<d.a.n0.e.b.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.n0.e.b.c cVar : list) {
            if (cVar.c() == 3) {
                d.a.n0.e.b.b bVar = new d.a.n0.e.b.b();
                bVar.i(cVar.a());
                bVar.k(cVar.b());
                arrayList.add(bVar);
            } else if (cVar.a() instanceof n) {
                arrayList.add((n) cVar.a());
            }
        }
        return arrayList;
    }

    public static List<d.a.n0.e.b.c> d(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            d.a.n0.e.b.c cVar = new d.a.n0.e.b.c();
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.y0() == 1) {
                    cVar.f(1);
                } else if (a2Var.y0() == 0) {
                    cVar.f(2);
                } else {
                    cVar.f(4);
                }
                cVar.d(nVar);
            } else if (nVar instanceof d.a.n0.e.b.b) {
                cVar.f(3);
                d.a.n0.e.b.b bVar = (d.a.n0.e.b.b) nVar;
                cVar.e(bVar.g());
                cVar.d(bVar.b());
            } else {
                cVar.f(4);
                cVar.d(nVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
