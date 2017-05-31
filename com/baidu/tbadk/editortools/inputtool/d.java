package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAn;
    private final /* synthetic */ SpannableStringBuilder aAo;
    private final /* synthetic */ EmotionGroupType aAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.aAn = inputView;
        this.aAo = spannableStringBuilder;
        this.aAp = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.aAn.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.aAn.a(this.aAn, this.aAo, selectionStart, aVar, this.aAp);
        }
    }
}
