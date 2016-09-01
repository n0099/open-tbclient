package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends CustomMessageListener {
    final /* synthetic */ br bbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(br brVar, int i) {
        super(i);
        this.bbb = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        CardPersonDynamicThreadData cardPersonDynamicThreadData;
        CardPersonDynamicThreadData cardPersonDynamicThreadData2;
        TextView textView;
        TextView textView2;
        CardPersonDynamicThreadData cardPersonDynamicThreadData3;
        boolean Nv;
        TextView textView3;
        CardPersonDynamicThreadData cardPersonDynamicThreadData4;
        TextView textView4;
        CardPersonDynamicThreadData cardPersonDynamicThreadData5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            cardPersonDynamicThreadData = this.bbb.baN;
            if (cardPersonDynamicThreadData != null) {
                cardPersonDynamicThreadData2 = this.bbb.baN;
                if (cardPersonDynamicThreadData2.threadId != null) {
                    textView = this.bbb.aYh;
                    if (textView != null) {
                        textView2 = this.bbb.baU;
                        if (textView2 != null) {
                            cardPersonDynamicThreadData3 = this.bbb.baN;
                            if (((String) customResponsedMessage.getData()).equals(cardPersonDynamicThreadData3.threadId)) {
                                Nv = this.bbb.Nv();
                                if (!Nv) {
                                    textView3 = this.bbb.aYh;
                                    cardPersonDynamicThreadData4 = this.bbb.baN;
                                    ap.a(textView3, cardPersonDynamicThreadData4.threadId, t.d.cp_cont_b, t.d.cp_cont_d);
                                    textView4 = this.bbb.baU;
                                    cardPersonDynamicThreadData5 = this.bbb.baN;
                                    ap.a(textView4, cardPersonDynamicThreadData5.threadId, t.d.cp_cont_j, t.d.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
