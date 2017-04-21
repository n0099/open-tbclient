package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAD;
    private final /* synthetic */ SpannableStringBuilder aAG;
    private final /* synthetic */ int aAH;
    private final /* synthetic */ int aAI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aAD = inputView;
        this.aAG = spannableStringBuilder;
        this.aAH = i;
        this.aAI = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((e) aVar, str, i);
        if (aVar != null) {
            Bitmap kS = aVar.kS();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kS);
            int width = (int) (0.5d * kS.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            this.aAG.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.aAH, this.aAI, 33);
        }
    }
}
