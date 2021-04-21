package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.j0.e.e.c;
import d.b.j0.e.e.d;
import d.b.j0.e.e.e;
import d.b.j0.e.f.b;
import d.b.j0.s2.t;
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
            d.b.j0.e.e.b c2;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof b) || (c2 = (bVar = (b) customResponsedMessage.getData()).c()) == null || !(c2 instanceof t)) {
                return;
            }
            t tVar = (t) c2;
            d.b.j0.e.e.a injectPlugin = c2.getInjectPlugin(1);
            if (injectPlugin == null) {
                d a2 = e.b().a(1);
                if (a2 == null) {
                    return;
                }
                injectPlugin = a2.a();
                c2.setInjectPlugin(1, injectPlugin);
                injectPlugin.n(new c(tVar));
            }
            if (injectPlugin instanceof d.b.j0.e.b.d) {
                d.b.j0.e.b.d dVar = (d.b.j0.e.b.d) injectPlugin;
                if (bVar.a() == 1) {
                    List list = (List) bVar.f();
                    d.b.j0.e.b.b.e(dVar.e());
                    for (BdUniqueId bdUniqueId : d.b.j0.e.b.b.f()) {
                        d.b.j0.e.b.a aVar = new d.b.j0.e.b.a(tVar, bdUniqueId);
                        aVar.h0(tVar.q());
                        list.add(aVar);
                    }
                } else if (bVar.a() == 2) {
                    dVar.i(bVar.d());
                } else if (bVar.a() == 3) {
                    List<n> n = bVar.n();
                    List<d.b.j0.e.b.c> d2 = FrsFeedAdStatic.d(n);
                    if (bVar.p()) {
                        dVar.m(d2, FrsFeedAdStatic.d(bVar.k()), bVar.o(), bVar.e());
                    } else {
                        dVar.f(d2, bVar.e());
                    }
                    n.clear();
                    n.addAll(FrsFeedAdStatic.c(d2));
                } else if (bVar.a() == 4) {
                    dVar.a(bVar.m());
                } else if (bVar.a() == 5) {
                    dVar.h(FrsFeedAdStatic.d(bVar.n()), bVar.h(), bVar.g(), bVar.l(), bVar.i(), bVar.q(), bVar.j());
                }
            }
        }
    }

    static {
        MessageManager.getInstance().registerListener(new a());
    }

    public static List<n> c(List<d.b.j0.e.b.c> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (d.b.j0.e.b.c cVar : list) {
            if (cVar.c() == 3) {
                d.b.j0.e.b.b bVar = new d.b.j0.e.b.b();
                bVar.k(cVar.a());
                bVar.l(cVar.b());
                arrayList.add(bVar);
            } else if (cVar.a() instanceof n) {
                arrayList.add((n) cVar.a());
            }
        }
        return arrayList;
    }

    public static List<d.b.j0.e.b.c> d(List<n> list) {
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            d.b.j0.e.b.c cVar = new d.b.j0.e.b.c();
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x0() == 1) {
                    cVar.f(1);
                } else if (a2Var.x0() == 0) {
                    cVar.f(2);
                } else {
                    cVar.f(4);
                }
                cVar.d(nVar);
            } else if (nVar instanceof d.b.j0.e.b.b) {
                cVar.f(3);
                d.b.j0.e.b.b bVar = (d.b.j0.e.b.b) nVar;
                cVar.e(bVar.g());
                cVar.d(bVar.a());
            } else {
                cVar.f(4);
                cVar.d(nVar);
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
