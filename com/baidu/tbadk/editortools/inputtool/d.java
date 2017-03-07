package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAl;
    private final /* synthetic */ SpannableStringBuilder aAm;
    private final /* synthetic */ EmotionGroupType aAn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.aAl = inputView;
        this.aAm = spannableStringBuilder;
        this.aAn = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.aAl.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.aAl.a(this.aAl, this.aAm, selectionStart, aVar, this.aAn);
        }
    }
}
