package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends CustomMessageListener {
    final /* synthetic */ br bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(br brVar, int i) {
        super(i);
        this.bwI = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean TN;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bwI.bwv;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bwI.bwv;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bwI.mTitle;
                    if (textView != null) {
                        textView2 = this.bwI.bwC;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bwI.bwv;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                TN = this.bwI.TN();
                                if (!TN) {
                                    textView3 = this.bwI.mTitle;
                                    cardPersonDynamicThreadData4 = this.bwI.bwv;
                                    at.a(textView3, cardPersonDynamicThreadData4.threadId, w.e.cp_cont_b, w.e.cp_cont_d);
                                    textView4 = this.bwI.bwC;
                                    cardPersonDynamicThreadData5 = this.bwI.bwv;
                                    at.a(textView4, cardPersonDynamicThreadData5.threadId, w.e.cp_cont_j, w.e.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
