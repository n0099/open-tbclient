package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    public boolean a;
    View.OnClickListener b;
    private String c;
    private String d;
    private Button e;
    private Context f;
    private com.baidu.tbadk.core.util.b g;
    private boolean h;
    private float i;
    private String j;
    private c k;

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.c = str;
            this.d = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = "";
        this.d = "";
        this.g = null;
        this.h = false;
        this.i = 0.1388889f;
        this.a = false;
        this.b = new a(this);
        a(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.bannerview, this);
        this.e = (Button) findViewById(com.baidu.tieba.v.btn_close);
        this.e.setOnClickListener(this.b);
        setOnClickListener(this.b);
    }

    public void b(String str, String str2) {
        this.j = str2;
        if (!TextUtils.isEmpty(str)) {
            this.a = true;
        } else {
            this.a = false;
        }
        if (this.h) {
            setVisibility(8);
            return;
        }
        setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.k.b(getContext()) * this.i) + 0.5d);
            setLayoutParams(layoutParams);
            setImageUrl(str);
        }
    }

    public void setData(String str) {
        b(str, "");
    }

    private void setImageUrl(String str) {
        if (this.g == null) {
            this.g = new com.baidu.tbadk.core.util.b(this.f);
            this.g.a(720, 100);
            this.g.d(true);
        }
        this.g.b(str, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.a.a aVar) {
        Bitmap h;
        if (aVar != null && (h = aVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }

    public void a() {
        if (this.g != null) {
            this.g.d();
            this.g = null;
        }
    }

    public void setBannerViewClickListener(c cVar) {
        this.k = cVar;
    }

    public void b() {
        this.h = false;
        this.a = false;
    }
}
