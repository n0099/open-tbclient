package com.baidu.tieba.chat;

import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class a implements com.baidu.adp.lib.b.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f935a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChatActivity chatActivity) {
        this.f935a = chatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    /* renamed from: b */
    public ImageView a() {
        return new TbImageView(this.f935a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public void a(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public ImageView b(ImageView imageView) {
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        return imageView;
    }
}
