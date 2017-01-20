package com.baidu.tieba.frs;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsActivity frsActivity, int i) {
        super(i);
        this.bGL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        if (customResponsedMessage != null && this.bGL.bFF != null && this.bGL.bFF.Ys() != null && (l = (Long) customResponsedMessage.getData()) != null && b.tQ().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L) == l.longValue()) {
            this.bGL.bFF.Yt().setVisibility(4);
            ImageView imageView = (ImageView) this.bGL.bFF.Ys();
            if (this.bGL.XM()) {
                com.baidu.tbadk.core.util.ap.b(imageView, r.g.btn_bottle_selector, r.g.btn_bottle_selector);
            } else {
                com.baidu.tbadk.core.util.ap.b(imageView, r.g.d_btn_bottle_selector, r.g.d_btn_bottle_selector);
            }
            this.bGL.bFF.dK(false);
        }
    }
}
