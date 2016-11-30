package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aGU = tbImageView;
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
            str = this.aGU.mUrl;
            i = this.aGU.mType;
            String f = eA.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aGU.destroyDrawingCache();
                HL();
                method = TbImageView.aGQ;
                com.baidu.adp.lib.a.a.a.a(method, this.aGU, TbImageView.class);
                method2 = TbImageView.aGR;
                com.baidu.adp.lib.a.a.a.a(method2, this.aGU, TbImageView.class, false);
                method3 = TbImageView.aGS;
                com.baidu.adp.lib.a.a.a.a(method3, this.aGU, TbImageView.class);
                method4 = TbImageView.aGT;
                com.baidu.adp.lib.a.a.a.a(method4, this.aGU, TbImageView.class);
                this.aGU.invalidate();
            }
        }
    }

    private void HL() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aGQ;
        if (method == null) {
            TbImageView.aGQ = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aGR;
        if (method2 == null) {
            TbImageView.aGR = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aGS;
        if (method3 == null) {
            TbImageView.aGS = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aGT;
        if (method4 == null) {
            TbImageView.aGT = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
