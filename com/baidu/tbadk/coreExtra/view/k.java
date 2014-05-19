package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class k extends HorizontalScrollView {
    private int a;
    private int b;
    private Runnable c;
    private Context d;
    private ImageView[] e;
    private View f;
    private View g;
    private n h;
    private boolean i;
    private String j;

    public k(Context context, n nVar, String str) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.c = new l(this);
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = true;
        this.j = "normal";
        this.d = context;
        this.h = nVar;
        if (str != null) {
            this.j = str;
        }
        a();
    }

    private void a() {
        this.a = (int) this.d.getResources().getDimension(com.baidu.tieba.p.ds4);
        this.b = (int) this.d.getResources().getDimension(com.baidu.tieba.p.ds30);
        LinearLayout linearLayout = new LinearLayout(this.d);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(this.b, linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        addView(linearLayout);
        String[] stringArray = this.d.getResources().getStringArray(com.baidu.tieba.m.fiter_name);
        this.e = new ImageView[stringArray.length];
        LayoutInflater from = LayoutInflater.from(this.d);
        int length = stringArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = stringArray[i];
            String substring = str.substring(0, str.indexOf("|"));
            String substring2 = str.substring(str.indexOf("|") + 1);
            View inflate = from.inflate(com.baidu.tieba.s.filter_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.r.filter_text);
            textView.setText(substring2);
            textView.setTag(substring);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.r.filter_immage);
            imageView.setPadding(this.a, this.a, this.a, this.a);
            imageView.setTag(textView);
            imageView.setOnClickListener(new m(this));
            if (substring.equals(this.j)) {
                this.f = inflate;
                this.g = imageView;
                imageView.setBackgroundResource(com.baidu.tieba.q.bg_choose_filter);
                textView.setSelected(true);
            }
            imageView.setImageResource(a(substring));
            this.e[i2] = imageView;
            linearLayout.addView(inflate);
            i++;
            i2++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f != null) {
            post(this.c);
        }
    }

    public String getSelectedFilter() {
        return this.g != null ? (String) ((View) this.g.getTag()).getTag() : "normal";
    }

    public void setCanbeClick(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.i && view != this.g) {
            if (this.g != null) {
                this.g.setBackgroundDrawable(null);
                ((TextView) this.g.getTag()).setSelected(false);
            }
            this.g = view;
            view.setBackgroundResource(com.baidu.tieba.q.bg_choose_filter);
            TextView textView = (TextView) view.getTag();
            textView.setSelected(true);
            this.j = (String) textView.getTag();
            if (this.h != null) {
                this.h.a(this.j);
            }
        }
    }

    public static int a(String str) {
        if (str == null) {
            return com.baidu.tieba.q.motu_filter_normal;
        }
        if (str.equals("normal")) {
            return com.baidu.tieba.q.motu_filter_normal;
        }
        if (str.equals("clvivid")) {
            return com.baidu.tieba.q.motu_filter_skin;
        }
        if (str.equals("cllomoscenery")) {
            return com.baidu.tieba.q.motu_filter_lomo;
        }
        if (str.equals("clcaisefupian")) {
            return com.baidu.tieba.q.motu_filter_classichdr;
        }
        if (str.equals("clm3")) {
            return com.baidu.tieba.q.motu_filter_nashiv;
        }
        if (str.equals("cqiuse")) {
            return com.baidu.tieba.q.motu_filter_fleeting;
        }
        if (str.equals("clzaoan")) {
            return com.baidu.tieba.q.motu_filter_bluetone;
        }
        if (str.equals("clfuguscenery")) {
            return com.baidu.tieba.q.motu_filter_elegant;
        }
        if (str.equals("clheibai")) {
            return com.baidu.tieba.q.motu_filter_gray;
        }
        return com.baidu.tieba.q.motu_filter_normal;
    }
}
