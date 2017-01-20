package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView auQ;
    private final /* synthetic */ SpannableStringBuilder auR;
    private final /* synthetic */ EmotionGroupType auS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.auQ = inputView;
        this.auR = spannableStringBuilder;
        this.auS = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.auQ.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.auQ.a(this.auQ, this.auR, selectionStart, aVar, this.auS);
        }
    }
}
