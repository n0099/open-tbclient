package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cCL;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cCM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cCL = cVar;
        this.cCM = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HQ() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cCL.cCJ;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cCL.cCI;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cCL.cCK;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cCL.cCK;
                textView2.setMaxLines(1);
            }
        }
        this.cCL.cCI = lineCount;
        textView = this.cCL.cCK;
        textView.setText(this.cCM.getDesc());
    }
}
