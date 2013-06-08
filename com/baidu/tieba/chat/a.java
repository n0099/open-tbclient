package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.tieba.view.PbImageView;
/* loaded from: classes.dex */
class a implements com.baidu.adp.lib.c.c {
    final /* synthetic */ ChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatActivity chatActivity) {
        this.a = chatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.c
    /* renamed from: b */
    public ImageView a() {
        return new PbImageView(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.c
    public void a(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.c
    public ImageView b(ImageView imageView) {
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        return imageView;
    }
}
