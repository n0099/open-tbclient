package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c ctv;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e ctw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.ctv = cVar;
        this.ctw = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void Ha() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.ctv.ctt;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.ctv.cts;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.ctv.ctu;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.ctv.ctu;
                textView2.setMaxLines(1);
            }
        }
        this.ctv.cts = lineCount;
        textView = this.ctv.ctu;
        textView.setText(this.ctw.getDesc());
    }
}
