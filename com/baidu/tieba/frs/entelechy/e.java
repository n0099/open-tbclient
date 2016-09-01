package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a bUW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.bUW = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String[] strArr;
        com.baidu.tbadk.core.data.q qVar;
        int g;
        com.baidu.tbadk.core.data.q qVar2;
        TextView textView;
        TbPageContext tbPageContext;
        TextView textView2;
        TbPageContext tbPageContext2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String[]) && (strArr = (String[]) customResponsedMessage.getData()) != null && strArr.length == 2 && strArr[0] != null && strArr[1] != null) {
            String str = strArr[0];
            qVar = this.bUW.bUQ;
            if (str.equals(qVar.getBookId()) && (g = com.baidu.adp.lib.h.b.g(strArr[1], -1)) > 0) {
                qVar2 = this.bUW.bUQ;
                if (qVar2.px() != 3) {
                    textView = this.bUW.bUN;
                    tbPageContext = this.bUW.Gd;
                    textView.setText(tbPageContext.getString(t.j.book_continue_read));
                    return;
                }
                this.bUW.bUR = g;
                textView2 = this.bUW.bUN;
                tbPageContext2 = this.bUW.Gd;
                textView2.setText(tbPageContext2.getString(t.j.book_continue_read));
            }
        }
    }
}
