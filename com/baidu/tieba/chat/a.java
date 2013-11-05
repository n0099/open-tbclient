package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class a implements com.baidu.adp.lib.d.c<ImageView> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatActivity chatActivity) {
        this.f1085a = chatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public ImageView a() {
        return new TbImageView(this.f1085a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView b(ImageView imageView) {
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        return imageView;
    }
}
