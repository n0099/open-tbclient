package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends CustomMessageListener {
    final /* synthetic */ bu bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(bu buVar, int i) {
        super(i);
        this.bCs = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Uh;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bCs.bCh;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bCs.bCh;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bCs.mTitle;
                    if (textView != null) {
                        textView2 = this.bCs.bCm;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bCs.bCh;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Uh = this.bCs.Uh();
                                if (!Uh) {
                                    textView3 = this.bCs.mTitle;
                                    cardPersonDynamicThreadData4 = this.bCs.bCh;
                                    at.a(textView3, cardPersonDynamicThreadData4.threadId, w.e.cp_cont_b, w.e.cp_cont_d);
                                    textView4 = this.bCs.bCm;
                                    cardPersonDynamicThreadData5 = this.bCs.bCh;
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
