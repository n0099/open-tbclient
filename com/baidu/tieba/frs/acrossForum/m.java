package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ j bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, int i) {
        super(i);
        this.bWU = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        View view;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            if (((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData()).isLike() == 1) {
                viewGroup = this.bWU.bWP;
                if (viewGroup != null) {
                    viewGroup2 = this.bWU.bWP;
                    view = this.bWU.mView;
                    viewGroup2.removeView(view);
                    this.bWU.mView = null;
                    this.bWU.bWQ = true;
                }
            }
        }
    }
}
