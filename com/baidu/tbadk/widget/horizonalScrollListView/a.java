package com.baidu.tbadk.widget.horizonalScrollListView;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends CustomMessageListener {
    final /* synthetic */ HorizonalScrollListView aCr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(HorizonalScrollListView horizonalScrollListView, int i) {
        super(i);
        this.aCr = horizonalScrollListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
            return;
        }
        this.aCr.a(((Long) customResponsedMessage.getData()).longValue(), false);
    }
}
