package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aGo = tbImageView;
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
            str = this.aGo.mUrl;
            i = this.aGo.mType;
            String f = eA.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aGo.destroyDrawingCache();
                Hh();
                method = TbImageView.aGk;
                com.baidu.adp.lib.a.a.a.a(method, this.aGo, TbImageView.class);
                method2 = TbImageView.aGl;
                com.baidu.adp.lib.a.a.a.a(method2, this.aGo, TbImageView.class, false);
                method3 = TbImageView.aGm;
                com.baidu.adp.lib.a.a.a.a(method3, this.aGo, TbImageView.class);
                method4 = TbImageView.aGn;
                com.baidu.adp.lib.a.a.a.a(method4, this.aGo, TbImageView.class);
                this.aGo.invalidate();
            }
        }
    }

    private void Hh() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aGk;
        if (method == null) {
            TbImageView.aGk = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aGl;
        if (method2 == null) {
            TbImageView.aGl = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aGm;
        if (method3 == null) {
            TbImageView.aGm = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aGn;
        if (method4 == null) {
            TbImageView.aGn = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
