package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends CustomMessageListener {
    final /* synthetic */ br bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(br brVar, int i) {
        super(i);
        this.bnD = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Rp;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bnD.bnq;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bnD.bnq;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bnD.aNb;
                    if (textView != null) {
                        textView2 = this.bnD.bnx;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bnD.bnq;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Rp = this.bnD.Rp();
                                if (!Rp) {
                                    textView3 = this.bnD.aNb;
                                    cardPersonDynamicThreadData4 = this.bnD.bnq;
                                    at.a(textView3, cardPersonDynamicThreadData4.threadId, r.e.cp_cont_b, r.e.cp_cont_d);
                                    textView4 = this.bnD.bnx;
                                    cardPersonDynamicThreadData5 = this.bnD.bnq;
                                    at.a(textView4, cardPersonDynamicThreadData5.threadId, r.e.cp_cont_j, r.e.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
