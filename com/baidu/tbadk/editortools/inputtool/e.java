package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView avg;
    private final /* synthetic */ SpannableStringBuilder avj;
    private final /* synthetic */ int avk;
    private final /* synthetic */ int avl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.avg = inputView;
        this.avj = spannableStringBuilder;
        this.avk = i;
        this.avl = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((e) aVar, str, i);
        if (aVar != null) {
            Bitmap mK = aVar.mK();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mK);
            int width = (int) (0.5d * mK.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.avj.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.avk, this.avl, 33);
        }
    }
}
