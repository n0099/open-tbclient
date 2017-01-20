package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cAA;
    final /* synthetic */ c cAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cAz = cVar;
        this.cAA = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void GS() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cAz.cAx;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cAz.cAw;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cAz.cAy;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cAz.cAy;
                textView2.setMaxLines(1);
            }
        }
        this.cAz.cAw = lineCount;
        textView = this.cAz.cAy;
        textView.setText(this.cAA.getDesc());
    }
}
