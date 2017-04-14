package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ TbImageView aKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbImageView tbImageView, int i) {
        super(i);
        this.aKQ = tbImageView;
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
            String f = com.baidu.adp.lib.f.c.fL().f(this.aKQ.mUrl, this.aKQ.mType);
            if (f != null && f.equals(str)) {
                this.aKQ.destroyDrawingCache();
                HX();
                method = TbImageView.aKM;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aKQ, TbImageView.class);
                method2 = TbImageView.aKN;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aKQ, TbImageView.class, false);
                method3 = TbImageView.aKO;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aKQ, TbImageView.class);
                method4 = TbImageView.aKP;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aKQ, TbImageView.class);
                this.aKQ.invalidate();
            }
        }
    }

    private void HX() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aKM;
        if (method == null) {
            TbImageView.aKM = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aKN;
        if (method2 == null) {
            TbImageView.aKN = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aKO;
        if (method3 == null) {
            TbImageView.aKO = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aKP;
        if (method4 == null) {
            TbImageView.aKP = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
