package com.baidu.tieba.frs;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(FrsActivity frsActivity, int i) {
        super(i);
        this.bNJ = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        if (customResponsedMessage != null && this.bNJ.bMD != null && this.bNJ.bMD.ZP() != null && (l = (Long) customResponsedMessage.getData()) != null && b.uL().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L) == l.longValue()) {
            this.bNJ.bMD.ZQ().setVisibility(4);
            ImageView imageView = (ImageView) this.bNJ.bMD.ZP();
            if (this.bNJ.Zh()) {
                com.baidu.tbadk.core.util.aq.b(imageView, w.g.btn_bottle_selector, w.g.btn_bottle_selector);
            } else {
                com.baidu.tbadk.core.util.aq.b(imageView, w.g.d_btn_bottle_selector, w.g.d_btn_bottle_selector);
            }
            this.bNJ.bMD.dM(false);
        }
    }
}
