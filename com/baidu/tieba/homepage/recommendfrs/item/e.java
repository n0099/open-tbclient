package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cwD;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cwD = cVar;
        this.cwE = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Gi() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cwD.cwB;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cwD.cwA;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cwD.cwC;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cwD.cwC;
                textView2.setMaxLines(1);
            }
        }
        this.cwD.cwA = lineCount;
        textView = this.cwD.cwC;
        textView.setText(this.cwE.getDesc());
    }
}
