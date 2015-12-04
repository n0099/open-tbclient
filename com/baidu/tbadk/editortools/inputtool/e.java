package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView ask;
    private final /* synthetic */ SpannableStringBuilder asn;
    private final /* synthetic */ int aso;
    private final /* synthetic */ int asp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.ask = inputView;
        this.asn = spannableStringBuilder;
        this.aso = i;
        this.asp = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((e) aVar, str, i);
        if (aVar != null) {
            Bitmap ng = aVar.ng();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(ng);
            int width = (int) (0.5d * ng.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.asn.setSpan(new ImageSpan(bitmapDrawable, 0), this.aso, this.asp, 33);
        }
    }
}
