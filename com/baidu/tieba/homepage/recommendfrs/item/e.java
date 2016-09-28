package com.baidu.tieba.homepage.recommendfrs.item;

import android.widget.TextView;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LineCountNotifyTextView.a {
    final /* synthetic */ c cJa;
    private final /* synthetic */ com.baidu.tieba.homepage.recommendfrs.data.e cJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, com.baidu.tieba.homepage.recommendfrs.data.e eVar) {
        this.cJa = cVar;
        this.cJb = eVar;
    }

    @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
    public void HB() {
        LineCountNotifyTextView lineCountNotifyTextView;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        lineCountNotifyTextView = this.cJa.cIY;
        int lineCount = lineCountNotifyTextView.getLineCount();
        i = this.cJa.cIX;
        if (i != lineCount) {
            if (lineCount == 1) {
                textView3 = this.cJa.cIZ;
                textView3.setMaxLines(2);
            } else {
                textView2 = this.cJa.cIZ;
                textView2.setMaxLines(1);
            }
        }
        this.cJa.cIX = lineCount;
        textView = this.cJa.cIZ;
        textView.setText(this.cJb.getDesc());
    }
}
