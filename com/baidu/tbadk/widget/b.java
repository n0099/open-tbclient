package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
/* loaded from: classes.dex */
public class b extends TbImageView {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView
    public com.baidu.adp.widget.ImageView.b getImage() {
        return super.getImage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public void f() {
        setTag(null);
        a listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.a(this);
        }
    }

    public a getListViewActivity() {
        Context context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }
}
