package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAB;
    private final /* synthetic */ SpannableStringBuilder aAC;
    private final /* synthetic */ EmotionGroupType aAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.aAB = inputView;
        this.aAC = spannableStringBuilder;
        this.aAD = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.aAB.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.aAB.a(this.aAB, this.aAC, selectionStart, aVar, this.aAD);
        }
    }
}
