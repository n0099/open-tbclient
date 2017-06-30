package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class f extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aBq;
    private final /* synthetic */ SpannableStringBuilder aBt;
    private final /* synthetic */ int aBu;
    private final /* synthetic */ int aBv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aBq = inputView;
        this.aBt = spannableStringBuilder;
        this.aBu = i;
        this.aBv = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((f) aVar, str, i);
        if (aVar != null) {
            Bitmap kP = aVar.kP();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kP);
            int dimensionPixelSize = this.aBq.getResources().getDimensionPixelSize(w.f.ds80);
            int width = (int) (kP.getWidth() * ((dimensionPixelSize * 1.0d) / kP.getHeight()));
            if (width > k.af(this.aBq.getContext()) * 0.6d) {
                width = (int) (kP.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
            bitmapDrawable.setGravity(119);
            this.aBt.setSpan(new ImageSpan(bitmapDrawable, 0), this.aBu, this.aBv, 33);
        }
    }
}
