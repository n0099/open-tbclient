package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ TbImageView aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbImageView tbImageView, int i) {
        super(i);
        this.aMh = tbImageView;
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
            String f = com.baidu.adp.lib.f.c.fL().f(this.aMh.mUrl, this.aMh.mType);
            if (f != null && f.equals(str)) {
                this.aMh.destroyDrawingCache();
                Hz();
                method = TbImageView.aMb;
                com.baidu.adp.lib.OrmObject.a.a.a(method, this.aMh, TbImageView.class);
                method2 = TbImageView.aMc;
                com.baidu.adp.lib.OrmObject.a.a.a(method2, this.aMh, TbImageView.class, false);
                method3 = TbImageView.aMd;
                com.baidu.adp.lib.OrmObject.a.a.a(method3, this.aMh, TbImageView.class);
                method4 = TbImageView.aMe;
                com.baidu.adp.lib.OrmObject.a.a.a(method4, this.aMh, TbImageView.class);
                this.aMh.invalidate();
            }
        }
    }

    private void Hz() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        method = TbImageView.aMb;
        if (method == null) {
            TbImageView.aMb = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", new Object[0]);
        }
        method2 = TbImageView.aMc;
        if (method2 == null) {
            TbImageView.aMc = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "destroyLayer", false);
        }
        method3 = TbImageView.aMd;
        if (method3 == null) {
            TbImageView.aMd = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "clearDisplayList", new Object[0]);
        }
        method4 = TbImageView.aMe;
        if (method4 == null) {
            TbImageView.aMe = com.baidu.adp.lib.OrmObject.a.a.b(TbImageView.class, "resetDisplayList", new Object[0]);
        }
    }
}
