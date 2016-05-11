package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView arf;
    private final /* synthetic */ SpannableStringBuilder ari;
    private final /* synthetic */ int arj;
    private final /* synthetic */ int ark;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.arf = inputView;
        this.ari = spannableStringBuilder;
        this.arj = i;
        this.ark = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((e) aVar, str, i);
        if (aVar != null) {
            Bitmap iY = aVar.iY();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(iY);
            int width = (int) (0.5d * iY.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.ari.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.arj, this.ark, 33);
        }
    }
}
