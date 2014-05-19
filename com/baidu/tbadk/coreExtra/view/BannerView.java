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
    private String e;
    private Button f;
    private Context g;
    private com.baidu.tbadk.core.util.b h;
    private boolean i;
    private float j;
    private String k;
    private c l;

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
        this.e = "";
        this.h = null;
        this.i = false;
        this.j = 0.1388889f;
        this.a = false;
        this.b = new a(this);
        a(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.g = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.s.bannerview, this);
        this.f = (Button) findViewById(com.baidu.tieba.r.btn_close);
        this.f.setOnClickListener(this.b);
        setOnClickListener(this.b);
    }

    public void a(String str, String str2, String str3, long j) {
        this.e = str3;
        this.k = str2;
        this.a = false;
        if (this.i) {
            setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(this.e) || j == 0) {
            if (System.currentTimeMillis() - com.baidu.tbadk.f.a().a(this.e, 0L) < j) {
                setVisibility(8);
                return;
            }
        }
        setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.a = true;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.h.b(getContext()) * this.j) + 0.5d);
            setLayoutParams(layoutParams);
            setImageUrl(str);
        }
    }

    public void a(String str, String str2, long j) {
        a(str, "", str2, j);
    }

    private void setImageUrl(String str) {
        if (this.h == null) {
            this.h = new com.baidu.tbadk.core.util.b(this.g);
            this.h.a(720, 100);
            this.h.d(true);
        }
        this.h.b(str, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.a.a aVar) {
        Bitmap h;
        if (aVar != null && (h = aVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }

    public void a() {
        if (this.h != null) {
            this.h.d();
            this.h = null;
        }
    }

    public void setBannerViewClickListener(c cVar) {
        this.l = cVar;
    }
}
