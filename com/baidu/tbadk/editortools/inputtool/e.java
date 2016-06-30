package com.baidu.tbadk.editortools.inputtool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ InputView arV;
    private final /* synthetic */ SpannableStringBuilder arY;
    private final /* synthetic */ int arZ;
    private final /* synthetic */ int asa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        this.arV = inputView;
        this.arY = spannableStringBuilder;
        this.arZ = i;
        this.asa = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((e) aVar, str, i);
        if (aVar != null) {
            Bitmap jb = aVar.jb();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(jb);
            int width = (int) (0.5d * jb.getWidth());
            bitmapDrawable.setBounds(0, 0, width, width);
            bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
            this.arY.setSpan(new com.baidu.adp.widget.d(bitmapDrawable, 1), this.arZ, this.asa, 33);
        }
    }
}
