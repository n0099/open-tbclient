package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView auQ;
    private final /* synthetic */ SpannableStringBuilder auT;
    private final /* synthetic */ int auU;
    private final /* synthetic */ int auV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.auQ = inputView;
        this.auT = spannableStringBuilder;
        this.auU = i;
        this.auV = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((e) aVar, str, i);
        if (aVar != null) {
            Bitmap jT = aVar.jT();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(jT);
            int width = (int) (0.5d * jT.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.auT.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.auU, this.auV, 33);
        }
    }
}
