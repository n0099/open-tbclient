package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aDy = tbImageView;
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
            com.baidu.adp.lib.g.c dF = com.baidu.adp.lib.g.c.dF();
            str = this.aDy.mUrl;
            i = this.aDy.mType;
            String f = dF.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aDy.destroyDrawingCache();
                Gp();
                method = TbImageView.aDu;
                com.baidu.adp.lib.a.a.a.a(method, this.aDy, TbImageView.class);
                method2 = TbImageView.aDv;
                com.baidu.adp.lib.a.a.a.a(method2, this.aDy, TbImageView.class, false);
                method3 = TbImageView.aDw;
                com.baidu.adp.lib.a.a.a.a(method3, this.aDy, TbImageView.class);
                method4 = TbImageView.aDx;
                com.baidu.adp.lib.a.a.a.a(method4, this.aDy, TbImageView.class);
                this.aDy.invalidate();
            }
        }
    }

    private void Gp() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aDu;
        if (method == null) {
            TbImageView.aDu = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aDv;
        if (method2 == null) {
            TbImageView.aDv = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aDw;
        if (method3 == null) {
            TbImageView.aDw = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aDx;
        if (method4 == null) {
            TbImageView.aDx = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
