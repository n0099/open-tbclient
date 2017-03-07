package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends CustomMessageListener {
    final /* synthetic */ br buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(br brVar, int i) {
        super(i);
        this.buz = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Sn;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.buz.bul;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.buz.bul;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.buz.aSO;
                    if (textView != null) {
                        textView2 = this.buz.bus;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.buz.bul;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Sn = this.buz.Sn();
                                if (!Sn) {
                                    textView3 = this.buz.aSO;
                                    cardPersonDynamicThreadData4 = this.buz.bul;
                                    at.a(textView3, cardPersonDynamicThreadData4.threadId, w.e.cp_cont_b, w.e.cp_cont_d);
                                    textView4 = this.buz.bus;
                                    cardPersonDynamicThreadData5 = this.buz.bul;
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
