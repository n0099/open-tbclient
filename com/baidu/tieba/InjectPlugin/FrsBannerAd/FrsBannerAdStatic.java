package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.p;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.InjectPlugin.a.c;
import com.baidu.tieba.InjectPlugin.a.d;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.InjectPlugin.a.h;
/* loaded from: classes7.dex */
public class FrsBannerAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* loaded from: classes7.dex */
    static class a extends CustomMessageListener {
        public a() {
            super(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.InjectPlugin.b.a aVar;
            TbPageContext pageContext;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.InjectPlugin.b.a) && (pageContext = (aVar = (com.baidu.tieba.InjectPlugin.b.a) customResponsedMessage.getData()).getPageContext()) != null && (pageContext.getPageActivity() instanceof b)) {
                b bVar = (b) pageContext.getPageActivity();
                com.baidu.tieba.InjectPlugin.a.a sH = bVar.sH(2);
                if (sH == null) {
                    d sI = e.bJc().sI(2);
                    if (sI != null) {
                        sH = sI.bJb();
                        bVar.a(2, sH);
                        sH.init(new c(pageContext));
                        if (sH instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                            ((com.baidu.tieba.InjectPlugin.FrsBannerAd.a) sH).a(new a.InterfaceC0592a() { // from class: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic.a.1
                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0592a
                                public void a(c cVar, View view) {
                                    b a2 = h.a(cVar);
                                    if (a2 != null) {
                                        com.baidu.tieba.InjectPlugin.b bVar2 = new com.baidu.tieba.InjectPlugin.b();
                                        bVar2.what = 2;
                                        bVar2.setView(view);
                                        a2.a(bVar2);
                                    }
                                }

                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0592a
                                public void b(c cVar, View view) {
                                    b a2 = h.a(cVar);
                                    if (a2 != null) {
                                        com.baidu.tieba.InjectPlugin.b bVar2 = new com.baidu.tieba.InjectPlugin.b();
                                        bVar2.what = 3;
                                        bVar2.setView(view);
                                        a2.a(bVar2);
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
                com.baidu.tieba.InjectPlugin.a.a aVar2 = sH;
                if (aVar2 instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                    com.baidu.tieba.InjectPlugin.FrsBannerAd.a aVar3 = (com.baidu.tieba.InjectPlugin.FrsBannerAd.a) aVar2;
                    if (aVar.bJe() == 1) {
                        aVar3.setParams(aVar.getParams());
                        aVar3.setData(aVar.bJg());
                        aVar3.bIV();
                    } else if (aVar.bJe() == 2) {
                        aVar3.setBannerMaskColor(aVar.getMaskColor());
                    } else if (aVar.bJe() == 3) {
                        p bJf = aVar.bJf();
                        if (bJf != null && aVar3.getView() != null) {
                            bJf.removeHeaderView(aVar3.getView());
                        }
                    } else if (aVar.bJe() == 4) {
                        aVar3.changeSkinType(aVar.getSkinType());
                    }
                }
            }
        }
    }
}
