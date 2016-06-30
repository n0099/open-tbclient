package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aCI = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        int i;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str2 = (String) customResponsedMessage.getData();
            com.baidu.adp.lib.g.c dG = com.baidu.adp.lib.g.c.dG();
            str = this.aCI.mUrl;
            i = this.aCI.mType;
            String f = dG.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aCI.destroyDrawingCache();
                Gm();
                method = TbImageView.aCE;
                com.baidu.adp.lib.a.a.a.a(method, this.aCI, TbImageView.class);
                method2 = TbImageView.aCF;
                com.baidu.adp.lib.a.a.a.a(method2, this.aCI, TbImageView.class, false);
                method3 = TbImageView.aCG;
                com.baidu.adp.lib.a.a.a.a(method3, this.aCI, TbImageView.class);
                method4 = TbImageView.aCH;
                com.baidu.adp.lib.a.a.a.a(method4, this.aCI, TbImageView.class);
                this.aCI.invalidate();
            }
        }
    }

    private void Gm() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aCE;
        if (method == null) {
            TbImageView.aCE = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aCF;
        if (method2 == null) {
            TbImageView.aCF = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aCG;
        if (method3 == null) {
            TbImageView.aCG = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aCH;
        if (method4 == null) {
            TbImageView.aCH = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
