package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ j bDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(j jVar, int i) {
        super(i);
        this.bDe = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        View view;
        View view2;
        View view3;
        tbPageContext = this.bDe.Gf;
        if (tbPageContext != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId)) {
            tbPageContext2 = this.bDe.Gf;
            if (tbPageContext2.getUniqueId().equals((BdUniqueId) customResponsedMessage.getData())) {
                view = this.bDe.mView;
                if (view != null) {
                    view2 = this.bDe.mView;
                    if (view2.getVisibility() == 0) {
                        view3 = this.bDe.mView;
                        view3.setVisibility(8);
                    }
                }
            }
        }
    }
}
