package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aGF = tbImageView;
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
            com.baidu.adp.lib.g.c eA = com.baidu.adp.lib.g.c.eA();
            str = this.aGF.mUrl;
            i = this.aGF.mType;
            String f = eA.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aGF.destroyDrawingCache();
                HJ();
                method = TbImageView.aGB;
                com.baidu.adp.lib.a.a.a.a(method, this.aGF, TbImageView.class);
                method2 = TbImageView.aGC;
                com.baidu.adp.lib.a.a.a.a(method2, this.aGF, TbImageView.class, false);
                method3 = TbImageView.aGD;
                com.baidu.adp.lib.a.a.a.a(method3, this.aGF, TbImageView.class);
                method4 = TbImageView.aGE;
                com.baidu.adp.lib.a.a.a.a(method4, this.aGF, TbImageView.class);
                this.aGF.invalidate();
            }
        }
    }

    private void HJ() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aGB;
        if (method == null) {
            TbImageView.aGB = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aGC;
        if (method2 == null) {
            TbImageView.aGC = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aGD;
        if (method3 == null) {
            TbImageView.aGD = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aGE;
        if (method4 == null) {
            TbImageView.aGE = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
