package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.a.aw;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.f b;
    private LayoutInflater c;
    private ColorMatrix f;
    private aw d = null;
    private View.OnClickListener e = null;
    private Canvas g = null;
    private Paint h = null;
    private int[] i = {-8478726, -9647905, -4134843, -1869777, -664502, -3181578, -222752, -4683521};
    private Bitmap[] j = null;
    private float[] k = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    public ai(Context context, com.baidu.tieba.b.f fVar) {
        this.a = null;
        this.b = null;
        this.f = null;
        this.a = context;
        this.b = fVar;
        this.c = LayoutInflater.from(this.a);
        this.f = new ColorMatrix();
        b();
    }

    private void b() {
        this.j = new Bitmap[8];
        Bitmap decodeResource = BitmapFactory.decodeResource(this.a.getResources(), R.drawable.tag_layer_tag);
        for (int i = 0; i < 8; i++) {
            int i2 = this.i[i];
            this.k[0] = ((i2 >> 16) & 255) / 255.0f;
            this.k[6] = ((i2 >> 8) & 255) / 255.0f;
            this.k[12] = (i2 & 255) / 255.0f;
            this.f.set(this.k);
            ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(this.f);
            this.j[i] = decodeResource.copy(Bitmap.Config.ARGB_8888, true);
            this.h = new Paint();
            this.h.setColorFilter(colorMatrixColorFilter);
            this.g = new Canvas(this.j[i]);
            this.g.drawBitmap(this.j[i], 0.0f, 0.0f, this.h);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.h().size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || i < 0 || i >= this.b.h().size()) {
            return null;
        }
        return this.b.h().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        aj ajVar;
        int c;
        if (view == null) {
            view = this.c.inflate(R.layout.tag_setting_item, (ViewGroup) null);
            ajVar = new aj();
            ajVar.a = (ImageView) view.findViewById(R.id.tag_setting_item_bg);
            ajVar.b = (TextView) view.findViewById(R.id.tag_setting_item_name);
            ajVar.c = (ImageButton) view.findViewById(R.id.tag_setting_item_del);
            view.setTag(ajVar);
        } else {
            ajVar = (aj) view.getTag();
        }
        this.d = (aw) getItem(i);
        if (this.d.c() == -1) {
            c = (int) (Math.random() * this.i.length);
            this.d.a(c);
        } else {
            c = this.d.c();
        }
        ajVar.a.setImageBitmap(this.j[c]);
        ajVar.b.setText(this.d.b());
        ajVar.c.setOnClickListener(this.e);
        ajVar.c.setTag(this.d);
        return view;
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void a() {
        for (int i = 0; i < 8; i++) {
            this.j[i].recycle();
        }
        this.j = null;
    }
}
