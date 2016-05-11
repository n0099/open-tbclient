package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView arf;
    private final /* synthetic */ SpannableStringBuilder arg;
    private final /* synthetic */ EmotionGroupType arh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.arf = inputView;
        this.arg = spannableStringBuilder;
        this.arh = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.arf.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.arf.a(this.arf, this.arg, selectionStart, aVar, this.arh);
        }
    }
}
