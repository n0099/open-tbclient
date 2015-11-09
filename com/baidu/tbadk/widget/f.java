package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ TbImageView azQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbImageView tbImageView, int i) {
        super(i);
        this.azQ = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str2 = (String) customResponsedMessage.getData();
            com.baidu.adp.lib.f.c hb = com.baidu.adp.lib.f.c.hb();
            str = this.azQ.mUrl;
            i = this.azQ.mType;
            String f = hb.f(str, i);
            if (f != null && f.equals(str2)) {
                this.azQ.destroyDrawingCache();
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.azQ, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.azQ, TbImageView.class, false);
                com.baidu.adp.lib.a.a.a.a("clearDisplayList", this.azQ, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("resetDisplayList", this.azQ, TbImageView.class);
                this.azQ.invalidate();
            }
        }
    }
}
