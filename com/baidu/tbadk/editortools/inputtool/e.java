package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAB;
    private final /* synthetic */ SpannableStringBuilder aAE;
    private final /* synthetic */ int aAF;
    private final /* synthetic */ int aAG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aAB = inputView;
        this.aAE = spannableStringBuilder;
        this.aAF = i;
        this.aAG = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((e) aVar, str, i);
        if (aVar != null) {
            Bitmap kR = aVar.kR();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
            int width = (int) (0.5d * kR.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            this.aAE.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.aAF, this.aAG, 33);
        }
    }
}
