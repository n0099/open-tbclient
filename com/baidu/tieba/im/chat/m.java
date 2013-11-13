package com.baidu.tieba.im.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class m extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1555a;
    private int b;
    private int c;
    private int d;

    public m(Context context, int i, int i2, int i3) {
        this.f1555a = null;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.f1555a = context;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if ((i + 1) / (((this.b * this.d) + this.b) - this.d) == 1 || TbFaceManager.a().b(i) == null) {
            return null;
        }
        return TbFaceManager.a().b(i).f();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        int i2 = i + this.c;
        if (view == null) {
            ImageView imageView2 = new ImageView(this.f1555a);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int a2 = UtilHelper.a(this.f1555a, 50.0f);
            imageView2.setLayoutParams(new AbsListView.LayoutParams(a2, a2));
            imageView = imageView2;
            view = imageView2;
        } else {
            imageView = (ImageView) view;
        }
        imageView.setFocusable(false);
        if (getItem(i2) != null) {
            imageView.setImageBitmap((Bitmap) getItem(i2));
        }
        if ((i2 + 1) / (((this.b * this.d) + this.b) - this.d) == 1) {
            imageView.setImageResource(R.drawable.but_face_close);
        }
        return view;
    }

    public String a(int i) {
        return TbFaceManager.a().c(i);
    }

    public Bitmap b(int i) {
        if (TbFaceManager.a().b(i) != null) {
            return TbFaceManager.a().b(i).f();
        }
        return null;
    }
}
