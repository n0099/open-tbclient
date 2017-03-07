package com.baidu.tieba.frs;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsActivity frsActivity, int i) {
        super(i);
        this.bNU = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        if (customResponsedMessage != null && this.bNU.bMN != null && this.bNU.bMN.Zr() != null && (l = (Long) customResponsedMessage.getData()) != null && b.uo().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L) == l.longValue()) {
            this.bNU.bMN.Zs().setVisibility(4);
            ImageView imageView = (ImageView) this.bNU.bMN.Zr();
            if (this.bNU.YL()) {
                com.baidu.tbadk.core.util.aq.b(imageView, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
            } else {
                com.baidu.tbadk.core.util.aq.b(imageView, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
            }
            this.bNU.bMN.dK(false);
        }
    }
}
