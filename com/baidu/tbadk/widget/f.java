package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ TbImageView aAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbImageView tbImageView, int i) {
        super(i);
        this.aAR = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str2 = (String) customResponsedMessage.getData();
            com.baidu.adp.lib.f.c ha = com.baidu.adp.lib.f.c.ha();
            str = this.aAR.mUrl;
            i = this.aAR.mType;
            String f = ha.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aAR.destroyDrawingCache();
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aAR, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aAR, TbImageView.class, false);
                com.baidu.adp.lib.a.a.a.a("clearDisplayList", this.aAR, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("resetDisplayList", this.aAR, TbImageView.class);
                this.aAR.invalidate();
            }
        }
    }
}
