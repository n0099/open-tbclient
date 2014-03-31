package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class a extends RelativeLayout {
    private static ArrayList<a> b = new ArrayList<>();
    private static final Pattern i = Pattern.compile("(/p/){1}(\\d+)");
    View.OnClickListener a;
    private TextView c;
    private Context d;
    private com.baidu.tbadk.core.util.b e;
    private com.baidu.tbadk.core.data.f f;
    private boolean g;
    private d h;

    public a(Context context) {
        super(context);
        this.e = null;
        this.f = null;
        this.g = false;
        this.a = new b(this);
        this.d = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.a.i.frs_bannerview, this);
        this.c = (TextView) findViewById(com.baidu.tieba.a.h.btn_close);
        this.c.setOnClickListener(this.a);
        setOnClickListener(this.a);
    }

    public final void setBannerCloseListener(d dVar) {
        this.h = dVar;
    }

    public final void setData(com.baidu.tbadk.core.data.f fVar) {
        this.f = fVar;
        if (this.g) {
            setVisibility(8);
            return;
        }
        setVisibility(8);
        if (fVar != null && !TextUtils.isEmpty(fVar.b())) {
            setImageUrl(fVar.b());
        }
    }

    public final void setImageUrl(String str) {
        if (this.e == null) {
            this.e = new com.baidu.tbadk.core.util.b(this.d);
            this.e.a(720, 100);
            this.e.a(true);
        }
        this.e.b(str, new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h;
        if (bVar != null && (h = bVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
            setVisibility(0);
        }
    }

    public final void a() {
        if (this.e != null) {
            this.e.c();
            this.e = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.add(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.remove(this);
    }
}
