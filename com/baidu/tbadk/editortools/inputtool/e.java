package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAn;
    private final /* synthetic */ SpannableStringBuilder aAq;
    private final /* synthetic */ int aAr;
    private final /* synthetic */ int aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aAn = inputView;
        this.aAq = spannableStringBuilder;
        this.aAr = i;
        this.aAs = i2;
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
            this.aAq.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.aAr, this.aAs, 33);
        }
    }
}
