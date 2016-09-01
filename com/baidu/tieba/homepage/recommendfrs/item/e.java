package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cIi;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cIi = cVar;
        this.cIj = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HC() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cIi.cIg;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cIi.cIf;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cIi.cIh;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cIi.cIh;
                textView2.setMaxLines(1);
            }
        }
        this.cIi.cIf = lineCount;
        textView = this.cIi.cIh;
        textView.setText(this.cIj.getDesc());
    }
}
