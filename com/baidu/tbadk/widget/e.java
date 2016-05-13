package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aCi = tbImageView;
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
            str = this.aCi.mUrl;
            i = this.aCi.mType;
            String f = dF.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aCi.destroyDrawingCache();
                Gl();
                method = TbImageView.aCe;
                com.baidu.adp.lib.a.a.a.a(method, this.aCi, TbImageView.class);
                method2 = TbImageView.aCf;
                com.baidu.adp.lib.a.a.a.a(method2, this.aCi, TbImageView.class, false);
                method3 = TbImageView.aCg;
                com.baidu.adp.lib.a.a.a.a(method3, this.aCi, TbImageView.class);
                method4 = TbImageView.aCh;
                com.baidu.adp.lib.a.a.a.a(method4, this.aCi, TbImageView.class);
                this.aCi.invalidate();
            }
        }
    }

    private void Gl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aCe;
        if (method == null) {
            TbImageView.aCe = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aCf;
        if (method2 == null) {
            TbImageView.aCf = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aCg;
        if (method3 == null) {
            TbImageView.aCg = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aCh;
        if (method4 == null) {
            TbImageView.aCh = com.baidu.adp.lib.a.a.a.a((Class<?>) TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
