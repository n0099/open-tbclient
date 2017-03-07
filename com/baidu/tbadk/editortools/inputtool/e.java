package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView aAl;
    private final /* synthetic */ SpannableStringBuilder aAo;
    private final /* synthetic */ int aAp;
    private final /* synthetic */ int aAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.aAl = inputView;
        this.aAo = spannableStringBuilder;
        this.aAp = i;
        this.aAq = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((e) aVar, str, i);
        if (aVar != null) {
            Bitmap kN = aVar.kN();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(kN);
            int width = (int) (0.5d * kN.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.aAo.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.aAp, this.aAq, 33);
        }
    }
}
