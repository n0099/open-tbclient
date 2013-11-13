package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import com.baidu.adp.widget.ImageView.e;
/* loaded from: classes.dex */
public class b extends TbImageView {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a
    public e getImage() {
        return super.getImage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.widget.ImageView.a, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!getIsLoaded() && g()) {
            e();
            return;
        }
        f();
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public void d() {
        setTag(null);
        a listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.b(this);
        }
    }

    public a getListViewActivity() {
        Context context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }

    public void e() {
        a listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.a(this);
        }
    }

    public void f() {
        a listViewActivity = getListViewActivity();
        if (listViewActivity != null) {
            listViewActivity.b(this);
        }
    }

    public boolean g() {
        Context context = getContext();
        if (!(context instanceof a)) {
            return false;
        }
        return ((a) context).d_();
    }
}
