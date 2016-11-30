package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cOp;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cOp = cVar;
        this.cOq = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HE() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cOp.cOn;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cOp.cOm;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cOp.cOo;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cOp.cOo;
                textView2.setMaxLines(1);
            }
        }
        this.cOp.cOm = lineCount;
        textView = this.cOp.cOo;
        textView.setText(this.cOq.getDesc());
    }
}
