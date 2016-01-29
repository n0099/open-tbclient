package com.baidu.tbadk.widget;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ TbImageView aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbImageView tbImageView, int i) {
        super(i);
        this.aEy = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String str;
        int i;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            String str2 = (String) customResponsedMessage.getData();
            com.baidu.adp.lib.g.c hl = com.baidu.adp.lib.g.c.hl();
            str = this.aEy.mUrl;
            i = this.aEy.mType;
            String f = hl.f(str, i);
            if (f != null && f.equals(str2)) {
                this.aEy.destroyDrawingCache();
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aEy, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("destroyLayer", this.aEy, TbImageView.class, false);
                com.baidu.adp.lib.a.a.a.a("clearDisplayList", this.aEy, TbImageView.class);
                com.baidu.adp.lib.a.a.a.a("resetDisplayList", this.aEy, TbImageView.class);
                this.aEy.invalidate();
            }
        }
    }
}
