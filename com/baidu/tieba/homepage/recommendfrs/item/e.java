package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c ctO;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e ctP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.ctO = cVar;
        this.ctP = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Gf() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.ctO.ctM;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.ctO.ctL;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.ctO.ctN;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.ctO.ctN;
                textView2.setMaxLines(1);
            }
        }
        this.ctO.ctL = lineCount;
        textView = this.ctO.ctN;
        textView.setText(this.ctP.getDesc());
    }
}
