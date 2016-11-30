package com.baidu.tieba.frs.entelechy;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a bXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.bXX = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        String[] strArr;
        com.baidu.tbadk.core.data.r rVar;
        int g;
        com.baidu.tbadk.core.data.r rVar2;
        TextView textView;
        TbPageContext tbPageContext;
        TextView textView2;
        TbPageContext tbPageContext2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String[]) && (strArr = (String[]) customResponsedMessage.getData()) != null && strArr.length == 2 && strArr[0] != null && strArr[1] != null) {
            String str = strArr[0];
            rVar = this.bXX.bXR;
            if (str.equals(rVar.getBookId()) && (g = com.baidu.adp.lib.h.b.g(strArr[1], -1)) > 0) {
                rVar2 = this.bXX.bXR;
                if (rVar2.pB() != 3) {
                    textView = this.bXX.bXO;
                    tbPageContext = this.bXX.Gf;
                    textView.setText(tbPageContext.getString(r.j.book_continue_read));
                    return;
                }
                this.bXX.bXS = g;
                textView2 = this.bXX.bXO;
                tbPageContext2 = this.bXX.Gf;
                textView2.setText(tbPageContext2.getString(r.j.book_continue_read));
            }
        }
    }
}
