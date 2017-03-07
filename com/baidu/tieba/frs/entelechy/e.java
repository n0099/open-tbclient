package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a bRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.bRq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String[] strArr;
        com.baidu.tbadk.core.data.s sVar;
        int g;
        com.baidu.tbadk.core.data.s sVar2;
        TextView textView;
        TbPageContext tbPageContext;
        TextView textView2;
        TbPageContext tbPageContext2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String[]) && (strArr = (String[]) customResponsedMessage.getData()) != null && strArr.length == 2 && strArr[0] != null && strArr[1] != null) {
            String str = strArr[0];
            sVar = this.bRq.bRk;
            if (str.equals(sVar.getBookId()) && (g = com.baidu.adp.lib.g.b.g(strArr[1], -1)) > 0) {
                sVar2 = this.bRq.bRk;
                if (sVar2.pM() != 3) {
                    textView = this.bRq.bRh;
                    tbPageContext = this.bRq.aaI;
                    textView.setText(tbPageContext.getString(w.l.continue_read));
                    return;
                }
                this.bRq.bRl = g;
                textView2 = this.bRq.bRh;
                tbPageContext2 = this.bRq.aaI;
                textView2.setText(tbPageContext2.getString(w.l.continue_read));
            }
        }
    }
}
