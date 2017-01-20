package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aFd = tbImageView;
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
            com.baidu.adp.lib.f.c ey = com.baidu.adp.lib.f.c.ey();
            str = this.aFd.mUrl;
            i = this.aFd.mType;
            String f = ey.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aFd.destroyDrawingCache();
                GZ();
                method = TbImageView.aEZ;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aFd, TbImageView.class);
                method2 = TbImageView.aFa;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aFd, TbImageView.class, false);
                method3 = TbImageView.aFb;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aFd, TbImageView.class);
                method4 = TbImageView.aFc;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aFd, TbImageView.class);
                this.aFd.invalidate();
            }
        }
    }

    private void GZ() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aEZ;
        if (method == null) {
            TbImageView.aEZ = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aFa;
        if (method2 == null) {
            TbImageView.aFa = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aFb;
        if (method3 == null) {
            TbImageView.aFb = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aFc;
        if (method4 == null) {
            TbImageView.aFc = com.baidu.adp.lib.OrmObject.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
