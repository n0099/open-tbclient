package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cBV;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cBV = cVar;
        this.cBW = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Hr() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cBV.cBT;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cBV.cBS;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cBV.cBU;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cBV.cBU;
                textView2.setMaxLines(1);
            }
        }
        this.cBV.cBS = lineCount;
        textView = this.cBV.cBU;
        textView.setText(this.cBW.getDesc());
    }
}
