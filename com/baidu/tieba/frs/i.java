package com.baidu.tieba.frs;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(FrsActivity frsActivity, int i) {
        super(i);
        this.bzl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Long l;
        if (customResponsedMessage != null && this.bzl.byg != null && this.bzl.byg.Xd() != null && (l = (Long) customResponsedMessage.getData()) != null && com.baidu.tbadk.core.sharedPref.b.tW().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L) == l.longValue()) {
            this.bzl.byg.Xe().setVisibility(4);
            ImageView imageView = (ImageView) this.bzl.byg.Xd();
            if (this.bzl.Wv()) {
                com.baidu.tbadk.core.util.ar.b(imageView, r.f.btn_bottle_selector, r.f.btn_bottle_selector);
            } else {
                com.baidu.tbadk.core.util.ar.b(imageView, r.f.d_btn_bottle_selector, r.f.d_btn_bottle_selector);
            }
            this.bzl.byg.dE(false);
        }
    }
}
