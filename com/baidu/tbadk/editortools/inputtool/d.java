package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView awo;
    private final /* synthetic */ SpannableStringBuilder awp;
    private final /* synthetic */ EmotionGroupType awq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.awo = inputView;
        this.awp = spannableStringBuilder;
        this.awq = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.awo.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.awo.a(this.awo, this.awp, selectionStart, aVar, this.awq);
        }
    }
}
