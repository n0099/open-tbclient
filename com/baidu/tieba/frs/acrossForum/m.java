package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CustomMessageListener {
    final /* synthetic */ j bDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(j jVar, int i) {
        super(i);
        this.bDe = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        View view;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            if (((com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData()).isLike() == 1) {
                viewGroup = this.bDe.bCZ;
                if (viewGroup != null) {
                    viewGroup2 = this.bDe.bCZ;
                    view = this.bDe.mView;
                    viewGroup2.removeView(view);
                    this.bDe.mView = null;
                    this.bDe.bDa = true;
                }
            }
        }
    }
}
