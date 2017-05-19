package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ TbImageView aLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbImageView tbImageView, int i) {
        super(i);
        this.aLc = tbImageView;
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
            String f = com.baidu.adp.lib.f.c.fM().f(this.aLc.mUrl, this.aLc.mType);
            if (f != null && f.equals(str)) {
                this.aLc.destroyDrawingCache();
                Hi();
                method = TbImageView.aKX;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aLc, TbImageView.class);
                method2 = TbImageView.aKY;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aLc, TbImageView.class, false);
                method3 = TbImageView.aKZ;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aLc, TbImageView.class);
                method4 = TbImageView.aLa;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aLc, TbImageView.class);
                this.aLc.invalidate();
            }
        }
    }

    private void Hi() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aKX;
        if (method == null) {
            TbImageView.aKX = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aKY;
        if (method2 == null) {
            TbImageView.aKY = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aKZ;
        if (method3 == null) {
            TbImageView.aKZ = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aLa;
        if (method4 == null) {
            TbImageView.aLa = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
