package com.baidu.tieba.face.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private ImageView ceQ;
    private int mImageWidth;

    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundResource(d.g.bg_expression_bubble);
        int f = l.f(getContext(), d.f.ds20);
        setPadding(f, f, f, l.f(getContext(), d.f.ds40));
        this.mImageWidth = l.f(getContext(), d.f.ds200);
    }

    public void a(final String str, final String str2, boolean z, int i) {
        if (!TextUtils.isEmpty(str)) {
            removeAllViews();
            if (z || i == 20) {
                this.ceQ = new GifView(getContext());
                ((GifView) this.ceQ).setSupportNoImage(false);
                GifInfo gifInfo = new GifInfo();
                gifInfo.mSharpText = str;
                gifInfo.mDynamicUrl = str;
                gifInfo.mStaticUrl = str2;
                this.ceQ.setTag(gifInfo.mSharpText);
                ((GifView) this.ceQ).a(gifInfo);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mImageWidth, this.mImageWidth);
                layoutParams.gravity = 17;
                addView(this.ceQ, layoutParams);
                return;
            }
            c.fJ().a(str, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.view.a.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str3, int i2) {
                    if (aVar != null) {
                        if (aVar.isGif()) {
                            a.this.ceQ = new GifView(a.this.getContext());
                            ((GifView) a.this.ceQ).setSupportNoImage(false);
                            GifInfo gifInfo2 = new GifInfo();
                            gifInfo2.mSharpText = str;
                            gifInfo2.mDynamicUrl = str;
                            gifInfo2.mStaticUrl = str2;
                            a.this.ceQ.setTag(gifInfo2.mSharpText);
                            ((GifView) a.this.ceQ).a(gifInfo2);
                        } else {
                            a.this.ceQ = new TbImageView(a.this.getContext());
                            ((TbImageView) a.this.ceQ).setGifIconSupport(false);
                            aVar.a(a.this.ceQ);
                        }
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a.this.mImageWidth, a.this.mImageWidth);
                        layoutParams2.gravity = 17;
                        a.this.addView(a.this.ceQ, layoutParams2);
                    }
                }
            }, null);
        }
    }
}
