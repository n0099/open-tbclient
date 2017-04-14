package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cAu;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cAu = cVar;
        this.cAv = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HQ() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cAu.cAs;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cAu.cAr;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cAu.cAt;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cAu.cAt;
                textView2.setMaxLines(1);
            }
        }
        this.cAu.cAr = lineCount;
        textView = this.cAu.cAt;
        textView.setText(this.cAv.getDesc());
    }
}
