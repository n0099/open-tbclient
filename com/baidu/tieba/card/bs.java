package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends CustomMessageListener {
    final /* synthetic */ bp bwH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(bp bpVar, int i) {
        super(i);
        this.bwH = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Te;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bwH.bww;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bwH.bww;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bwH.mTitle;
                    if (textView != null) {
                        textView2 = this.bwH.bwB;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bwH.bww;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Te = this.bwH.Te();
                                if (!Te) {
                                    textView3 = this.bwH.mTitle;
                                    cardPersonDynamicThreadData4 = this.bwH.bww;
                                    ap.a(textView3, cardPersonDynamicThreadData4.threadId, w.e.cp_cont_b, w.e.cp_cont_d);
                                    textView4 = this.bwH.bwB;
                                    cardPersonDynamicThreadData5 = this.bwH.bww;
                                    ap.a(textView4, cardPersonDynamicThreadData5.threadId, w.e.cp_cont_j, w.e.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
