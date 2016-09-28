package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aGe = tbImageView;
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
            str = this.aGe.mUrl;
            i = this.aGe.mType;
            String f = eA.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aGe.destroyDrawingCache();
                HI();
                method = TbImageView.aGa;
                com.baidu.adp.lib.a.a.a.a(method, this.aGe, TbImageView.class);
                method2 = TbImageView.aGb;
                com.baidu.adp.lib.a.a.a.a(method2, this.aGe, TbImageView.class, false);
                method3 = TbImageView.aGc;
                com.baidu.adp.lib.a.a.a.a(method3, this.aGe, TbImageView.class);
                method4 = TbImageView.aGd;
                com.baidu.adp.lib.a.a.a.a(method4, this.aGe, TbImageView.class);
                this.aGe.invalidate();
            }
        }
    }

    private void HI() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aGa;
        if (method == null) {
            TbImageView.aGa = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aGb;
        if (method2 == null) {
            TbImageView.aGb = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aGc;
        if (method3 == null) {
            TbImageView.aGc = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aGd;
        if (method4 == null) {
            TbImageView.aGd = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
