package com.baidu.tbadk.editortools.inputtool;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView ask;
    private final /* synthetic */ SpannableStringBuilder asl;
    private final /* synthetic */ EmotionGroupType asm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(InputView inputView, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.ask = inputView;
        this.asl = spannableStringBuilder;
        this.asm = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((d) aVar, str, i);
        if (aVar != null) {
            int selectionStart = this.ask.getSelectionStart();
            if (selectionStart < 0) {
                selectionStart = 0;
            }
            this.ask.a(this.ask, this.asl, selectionStart, aVar, this.asm);
        }
    }
}
