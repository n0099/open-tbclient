package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a bDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.bDL = aVar;
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
            qVar = this.bDL.bDF;
            if (str.equals(qVar.getBookId()) && (g = com.baidu.adp.lib.h.b.g(strArr[1], -1)) > 0) {
                qVar2 = this.bDL.bDF;
                if (qVar2.pB() != 3) {
                    textView = this.bDL.bDC;
                    tbPageContext = this.bDL.Gf;
                    textView.setText(tbPageContext.getString(r.j.book_continue_read));
                    return;
                }
                this.bDL.bDG = g;
                textView2 = this.bDL.bDC;
                tbPageContext2 = this.bDL.Gf;
                textView2.setText(tbPageContext2.getString(r.j.book_continue_read));
            }
        }
    }
}
