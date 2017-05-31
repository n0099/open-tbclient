package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ TbImageView aKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbImageView tbImageView, int i) {
        super(i);
        this.aKR = tbImageView;
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
            String f = com.baidu.adp.lib.f.c.fM().f(this.aKR.mUrl, this.aKR.mType);
            if (f != null && f.equals(str)) {
                this.aKR.destroyDrawingCache();
                Hc();
                method = TbImageView.aKL;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aKR, TbImageView.class);
                method2 = TbImageView.aKM;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aKR, TbImageView.class, false);
                method3 = TbImageView.aKN;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aKR, TbImageView.class);
                method4 = TbImageView.aKO;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aKR, TbImageView.class);
                this.aKR.invalidate();
            }
        }
    }

    private void Hc() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aKL;
        if (method == null) {
            TbImageView.aKL = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aKM;
        if (method2 == null) {
            TbImageView.aKM = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aKN;
        if (method3 == null) {
            TbImageView.aKN = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aKO;
        if (method4 == null) {
            TbImageView.aKO = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
