package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private ImageView cbz;
    private int mImageWidth;

    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundResource(d.g.bg_expression_bubble);
        int g = k.g(getContext(), d.f.ds20);
        setPadding(g, g, g, k.g(getContext(), d.f.ds40));
        this.mImageWidth = k.g(getContext(), d.f.ds200);
    }

    public void a(final String str, final String str2, boolean z, int i) {
        if (!TextUtils.isEmpty(str)) {
            removeAllViews();
            if (z || i == 20) {
                this.cbz = new GifView(getContext());
                ((GifView) this.cbz).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = str;
                gifInfo.mDynamicUrl = str;
                gifInfo.mStaticUrl = str2;
                this.cbz.setTag(gifInfo.mSharpText);
                ((GifView) this.cbz).a(gifInfo);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageWidth);
                layoutParams.gravity = 17;
                addView(this.cbz, layoutParams);
                return;
            }
            c.fU().a(str, 10, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.face.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str3, int i2) {
                    if (aVar != null) {
                        if (aVar.isGif()) {
                            a.this.cbz = new GifView(a.this.getContext());
                            ((GifView) a.this.cbz).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = str;
                            gifInfo2.mDynamicUrl = str;
                            gifInfo2.mStaticUrl = str2;
                            a.this.cbz.setTag(gifInfo2.mSharpText);
                            ((GifView) a.this.cbz).a(gifInfo2);
                        } else {
                            a.this.cbz = new TbImageView(a.this.getContext());
                            ((TbImageView) a.this.cbz).setGifIconSupport(false);
                            aVar.e(a.this.cbz);
                        }
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a.this.mImageWidth, a.this.mImageWidth);
                        layoutParams2.gravity = 17;
                        a.this.addView(a.this.cbz, layoutParams2);
                    }
                }
            }, null);
        }
    }
}
