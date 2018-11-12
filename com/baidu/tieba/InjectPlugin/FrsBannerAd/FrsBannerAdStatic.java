package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.InjectPlugin.a.c;
import com.baidu.tieba.InjectPlugin.a.d;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.InjectPlugin.a.h;
/* loaded from: classes3.dex */
public class FrsBannerAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* loaded from: classes3.dex */
    static class a extends CustomMessageListener {
        public a() {
            super(2016516);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.a aVar;
            TbPageContext pageContext;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.a) && (pageContext = (aVar = (com.baidu.tieba.InjectPlugin.b.a) customResponsedMessage.getData()).getPageContext()) != null && (pageContext.getPageActivity() instanceof b)) {
                b bVar = (b) pageContext.getPageActivity();
                com.baidu.tieba.InjectPlugin.a.a he = bVar.he(2);
                if (he == null) {
                    d hf = e.SJ().hf(2);
                    if (hf != null) {
                        he = hf.SI();
                        bVar.a(2, he);
                        he.init(new c(pageContext));
                        if (he instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                            ((com.baidu.tieba.InjectPlugin.FrsBannerAd.a) he).a(new a.InterfaceC0171a() { // from class: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic.a.1
                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0171a
                                public void a(c cVar, View view) {
                                    b a = h.a(cVar);
                                    if (a != null) {
                                        com.baidu.tieba.InjectPlugin.b bVar2 = new com.baidu.tieba.InjectPlugin.b();
                                        bVar2.what = 2;
                                        bVar2.setView(view);
                                        a.a(bVar2);
                                    }
                                }

                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0171a
                                public void b(c cVar, View view) {
                                    b a = h.a(cVar);
                                    if (a != null) {
                                        com.baidu.tieba.InjectPlugin.b bVar2 = new com.baidu.tieba.InjectPlugin.b();
                                        bVar2.what = 3;
                                        bVar2.setView(view);
                                        a.a(bVar2);
                                    }
                                }
                            });
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.InjectPlugin.a.a aVar2 = he;
                if (aVar2 instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                    com.baidu.tieba.InjectPlugin.FrsBannerAd.a aVar3 = (com.baidu.tieba.InjectPlugin.FrsBannerAd.a) aVar2;
                    if (aVar.SL() == 1) {
                        aVar3.setParams(aVar.getParams());
                        aVar3.setData(aVar.SN());
                        aVar3.SC();
                    } else if (aVar.SL() == 2) {
                        aVar3.setBannerMaskColor(aVar.getMaskColor());
                    } else if (aVar.SL() == 3) {
                        j SM = aVar.SM();
                        if (SM != null && aVar3.getView() != null) {
                            SM.removeHeaderView(aVar3.getView());
                        }
                    } else if (aVar.SL() == 4) {
                        aVar3.changeSkinType(aVar.getSkinType());
                    }
                }
            }
        }
    }
}
