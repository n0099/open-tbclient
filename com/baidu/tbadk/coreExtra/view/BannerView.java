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
    View.OnClickListener a;
    private String b;
    private String c;
    private String d;
    private Button e;
    private Context f;
    private com.baidu.tbadk.core.util.b g;
    private boolean h;
    private float i;
    private String j;

    public final void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.b = str;
            this.c = str2;
        }
    }

    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.c = "";
        this.d = "";
        this.g = null;
        this.h = false;
        this.i = 0.1388889f;
        this.a = new a(this);
        a(context);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.c = "";
        this.d = "";
        this.g = null;
        this.h = false;
        this.i = 0.1388889f;
        this.a = new a(this);
        a(context);
    }

    public BannerView(Context context) {
        super(context);
        this.b = "";
        this.c = "";
        this.d = "";
        this.g = null;
        this.h = false;
        this.i = 0.1388889f;
        this.a = new a(this);
        a(context);
    }

    private void a(Context context) {
        this.f = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tbadk.k.bannerview, this);
        this.e = (Button) findViewById(com.baidu.tbadk.j.btn_close);
        this.e.setOnClickListener(this.a);
        setOnClickListener(this.a);
    }

    public final void a(String str, String str2, String str3, long j) {
        this.d = str3;
        this.j = str2;
        if (this.h) {
            setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(this.d) || 259200000 == 0) {
            com.baidu.tbadk.s.a();
            if (System.currentTimeMillis() - com.baidu.tbadk.s.a(this.d, 0L) < 259200000) {
                setVisibility(8);
                return;
            }
        }
        setVisibility(8);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.i.b(getContext()) * this.i) + 0.5d);
            setLayoutParams(layoutParams);
            setImageUrl(str);
        }
    }

    private void setImageUrl(String str) {
        if (this.g == null) {
            this.g = new com.baidu.tbadk.core.util.b(this.f);
            this.g.a(720, 100);
            this.g.a(true);
        }
        this.g.b(str, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.ImageView.b bVar) {
        Bitmap h;
        if (bVar != null && (h = bVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }
}
