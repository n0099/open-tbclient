package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aBq;
    private final /* synthetic */ SpannableStringBuilder aBt;
    private final /* synthetic */ int aBu;
    private final /* synthetic */ int aBv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aBq = inputView;
        this.aBt = spannableStringBuilder;
        this.aBu = i;
        this.aBv = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((e) aVar, str, i);
        if (aVar != null) {
            Bitmap kP = aVar.kP();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kP);
            int width = (int) (0.5d * kP.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(119);
            this.aBt.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.aBu, this.aBv, 33);
        }
    }
}
