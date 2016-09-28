package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends CustomMessageListener {
    final /* synthetic */ bp bbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(bp bpVar, int i) {
        super(i);
        this.bbs = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean NW;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bbs.bbe;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bbs.bbe;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bbs.aMI;
                    if (textView != null) {
                        textView2 = this.bbs.bbl;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bbs.bbe;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                NW = this.bbs.NW();
                                if (!NW) {
                                    textView3 = this.bbs.aMI;
                                    cardPersonDynamicThreadData4 = this.bbs.bbe;
                                    an.a(textView3, cardPersonDynamicThreadData4.threadId, r.d.cp_cont_b, r.d.cp_cont_d);
                                    textView4 = this.bbs.bbl;
                                    cardPersonDynamicThreadData5 = this.bbs.bbe;
                                    an.a(textView4, cardPersonDynamicThreadData5.threadId, r.d.cp_cont_j, r.d.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
