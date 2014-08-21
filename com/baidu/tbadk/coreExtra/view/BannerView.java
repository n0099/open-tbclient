package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class BannerView extends RelativeLayout {
    public boolean a;
    View.OnClickListener b;
    private String c;
    private String d;
    private Button e;
    private Context f;
    private boolean g;
    private float h;
    private String i;
    private c j;

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
        this.g = false;
        this.h = 0.1388889f;
        this.a = false;
        this.b = new a(this);
        a(context);
    }

    public BannerView(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        this.f = context;
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.bannerview, this);
        this.e = (Button) findViewById(com.baidu.tieba.u.btn_close);
        this.e.setOnClickListener(this.b);
        setOnClickListener(this.b);
    }

    public void b(String str, String str2) {
        this.i = str2;
        if (!TextUtils.isEmpty(str)) {
            this.a = true;
        } else {
            this.a = false;
        }
        if (this.g) {
            setVisibility(8);
            return;
        }
        setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = (int) ((com.baidu.adp.lib.util.j.b(getContext()) * this.h) + 0.5d);
            setLayoutParams(layoutParams);
            setImageUrl(str);
        }
    }

    public void setData(String str) {
        b(str, "");
    }

    private void setImageUrl(String str) {
        b bVar = new b(this);
        BdUniqueId bdUniqueId = null;
        if (this.f instanceof com.baidu.adp.base.i) {
            bdUniqueId = ((com.baidu.adp.base.i) this.f).getUniqueId();
        }
        com.baidu.adp.lib.resourceLoader.d.a().a(str, 10, bVar, 720, 100, bdUniqueId, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImg(com.baidu.adp.widget.a.a aVar) {
        Bitmap h;
        if (aVar != null && (h = aVar.h()) != null) {
            setBackgroundDrawable(new BitmapDrawable(h));
        }
    }

    public void setBannerViewClickListener(c cVar) {
        this.j = cVar;
    }

    public void a() {
        this.g = false;
        this.a = false;
    }
}
