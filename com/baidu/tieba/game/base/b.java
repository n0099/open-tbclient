package com.baidu.tieba.game.base;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ AbsGameClassifyActivity aJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AbsGameClassifyActivity absGameClassifyActivity, int i, boolean z) {
        super(i, z);
        this.aJz = absGameClassifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        View abS;
        if (customResponsedMessage instanceof CacheReadResponse) {
            CacheReadResponse cacheReadResponse = (CacheReadResponse) customResponsedMessage;
            if (cacheReadResponse.getData() != null && cacheReadResponse.getData().length > 0) {
                AbsGameClassifyActivity absGameClassifyActivity = this.aJz;
                abS = this.aJz.abS();
                absGameClassifyActivity.hideLoadingView(abS);
                this.aJz.B(cacheReadResponse.getData());
            }
            this.aJz.HX();
        }
    }
}
