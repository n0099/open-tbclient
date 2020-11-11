package com.baidu.tieba.InjectPlugin.FrsBannerAd;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.InjectPlugin.FrsBannerAd.a;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.InjectPlugin.a.c;
import com.baidu.tieba.InjectPlugin.a.d;
import com.baidu.tieba.InjectPlugin.a.e;
import com.baidu.tieba.InjectPlugin.a.h;
/* loaded from: classes21.dex */
public class FrsBannerAdStatic {
    static {
        MessageManager.getInstance().registerListener(new a());
    }

    /* loaded from: classes21.dex */
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
                com.baidu.tieba.InjectPlugin.a.a ta = bVar.ta(2);
                if (ta == null) {
                    d tb = e.bHI().tb(2);
                    if (tb != null) {
                        ta = tb.bHH();
                        bVar.a(2, ta);
                        ta.init(new c(pageContext));
                        if (ta instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                            ((com.baidu.tieba.InjectPlugin.FrsBannerAd.a) ta).a(new a.InterfaceC0606a() { // from class: com.baidu.tieba.InjectPlugin.FrsBannerAd.FrsBannerAdStatic.a.1
                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0606a
                                public void a(c cVar, View view) {
                                    b a2 = h.a(cVar);
                                    if (a2 != null) {
                                        com.baidu.tieba.InjectPlugin.b bVar2 = new com.baidu.tieba.InjectPlugin.b();
                                        bVar2.what = 2;
                                        bVar2.setView(view);
                                        a2.a(bVar2);
                                    }
                                }

                                @Override // com.baidu.tieba.InjectPlugin.FrsBannerAd.a.InterfaceC0606a
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
                com.baidu.tieba.InjectPlugin.a.a aVar2 = ta;
                if (aVar2 instanceof com.baidu.tieba.InjectPlugin.FrsBannerAd.a) {
                    com.baidu.tieba.InjectPlugin.FrsBannerAd.a aVar3 = (com.baidu.tieba.InjectPlugin.FrsBannerAd.a) aVar2;
                    if (aVar.bHK() == 1) {
                        aVar3.setParams(aVar.getParams());
                        aVar3.setData(aVar.bHM());
                        aVar3.bHB();
                    } else if (aVar.bHK() == 2) {
                        aVar3.setBannerMaskColor(aVar.getMaskColor());
                    } else if (aVar.bHK() == 3) {
                        s bHL = aVar.bHL();
                        if (bHL != null && aVar3.getView() != null) {
                            bHL.removeHeaderView(aVar3.getView());
                        }
                    } else if (aVar.bHK() == 4) {
                        aVar3.changeSkinType(aVar.getSkinType());
                    }
                }
            }
        }
    }
}
