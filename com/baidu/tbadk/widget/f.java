package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ TbImageView aKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbImageView tbImageView, int i) {
        super(i);
        this.aKA = tbImageView;
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
            com.baidu.adp.lib.f.c fG = com.baidu.adp.lib.f.c.fG();
            str = this.aKA.mUrl;
            i = this.aKA.mType;
            String f = fG.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aKA.destroyDrawingCache();
                Hy();
                method = TbImageView.aKw;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aKA, TbImageView.class);
                method2 = TbImageView.aKx;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aKA, TbImageView.class, false);
                method3 = TbImageView.aKy;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aKA, TbImageView.class);
                method4 = TbImageView.aKz;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aKA, TbImageView.class);
                this.aKA.invalidate();
            }
        }
    }

    private void Hy() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aKw;
        if (method == null) {
            TbImageView.aKw = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aKx;
        if (method2 == null) {
            TbImageView.aKx = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aKy;
        if (method3 == null) {
            TbImageView.aKy = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aKz;
        if (method4 == null) {
            TbImageView.aKz = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
