package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ TbImageView aKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbImageView tbImageView, int i) {
        super(i);
        this.aKS = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str = (String) customResponsedMessage.getData();
            String f = com.baidu.adp.lib.f.c.fM().f(this.aKS.mUrl, this.aKS.mType);
            if (f != null && f.equals(str)) {
                this.aKS.destroyDrawingCache();
                HX();
                method = TbImageView.aKO;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aKS, TbImageView.class);
                method2 = TbImageView.aKP;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aKS, TbImageView.class, false);
                method3 = TbImageView.aKQ;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aKS, TbImageView.class);
                method4 = TbImageView.aKR;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aKS, TbImageView.class);
                this.aKS.invalidate();
            }
        }
    }

    private void HX() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aKO;
        if (method == null) {
            TbImageView.aKO = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aKP;
        if (method2 == null) {
            TbImageView.aKP = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aKQ;
        if (method3 == null) {
            TbImageView.aKQ = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aKR;
        if (method4 == null) {
            TbImageView.aKR = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
