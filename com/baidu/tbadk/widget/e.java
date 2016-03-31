package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aFT = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str2 = (String) customResponsedMessage.getData();
            com.baidu.adp.lib.g.c hr = com.baidu.adp.lib.g.c.hr();
            str = this.aFT.mUrl;
            i = this.aFT.mType;
            String f = hr.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aFT.destroyDrawingCache();
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aFT, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aFT, TbImageView.class, false);
                com.baidu.adp.lib.a.a.a.a("clearDisplayList", this.aFT, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("resetDisplayList", this.aFT, TbImageView.class);
                this.aFT.invalidate();
            }
        }
    }
}
