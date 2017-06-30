package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends CustomMessageListener {
    final /* synthetic */ bu bDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(bu buVar, int i) {
        super(i);
        this.bDl = buVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Vw;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bDl.bDa;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bDl.bDa;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bDl.mTitle;
                    if (textView != null) {
                        textView2 = this.bDl.bDf;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bDl.bDa;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Vw = this.bDl.Vw();
                                if (!Vw) {
                                    textView3 = this.bDl.mTitle;
                                    cardPersonDynamicThreadData4 = this.bDl.bDa;
                                    at.a(textView3, cardPersonDynamicThreadData4.threadId, w.e.cp_cont_b, w.e.cp_cont_d);
                                    textView4 = this.bDl.bDf;
                                    cardPersonDynamicThreadData5 = this.bDl.bDa;
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
