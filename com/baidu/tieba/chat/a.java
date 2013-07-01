package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.tieba.view.PbImageView;
/* loaded from: classes.dex */
class a implements com.baidu.adp.lib.a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatActivity chatActivity) {
        this.f713a = chatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    /* renamed from: b */
    public ImageView a() {
        return new PbImageView(this.f713a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public void a(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public ImageView b(ImageView imageView) {
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.a.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        return imageView;
    }
}
