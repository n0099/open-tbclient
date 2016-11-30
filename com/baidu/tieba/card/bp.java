package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends CustomMessageListener {
    final /* synthetic */ bl bey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(bl blVar, int i) {
        super(i);
        this.bey = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Pa;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bey.bej;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bey.bej;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bey.aOH;
                    if (textView != null) {
                        textView2 = this.bey.beq;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bey.bej;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Pa = this.bey.Pa();
                                if (!Pa) {
                                    textView3 = this.bey.aOH;
                                    cardPersonDynamicThreadData4 = this.bey.bej;
                                    an.a(textView3, cardPersonDynamicThreadData4.threadId, r.d.cp_cont_b, r.d.cp_cont_d);
                                    textView4 = this.bey.beq;
                                    cardPersonDynamicThreadData5 = this.bey.bej;
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
