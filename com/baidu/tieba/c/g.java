package com.baidu.tieba.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.CustomTextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private Context a;
    private int b;
    private int c;
    private a d;
    private View.OnClickListener e;
    private boolean f = false;

    public g(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.h.k());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    private ImageView a(List list, com.baidu.tieba.a.j jVar, int i) {
        ImageView imageView = new ImageView(this.a);
        int a = ag.a(this.a, 105.0f);
        int a2 = ag.a(this.a, 105.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
        layoutParams.topMargin = ag.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        Bitmap c = this.d.c(jVar.f());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(a2);
        if (c != null) {
            imageView.setTag(null);
            imageView.setImageBitmap(c);
        } else {
            imageView.setTag(jVar.f());
            imageView.setImageBitmap(e.a((int) R.drawable.image_default));
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.e);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private TextView a(com.baidu.tieba.a.j jVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = ag.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.a.h.k());
        customTextView.setTextColor(-11974584);
        a(customTextView, jVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private List a(List list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            com.baidu.tieba.a.j jVar = (com.baidu.tieba.a.j) list.get(i);
            int a = jVar.a();
            int length = (a == 0 || a == 4 || a == 1) ? jVar.e() != null ? jVar.e().length() + i2 : i2 : i2 + 1;
            if (length <= 50) {
                arrayList.add(jVar);
                i++;
                i2 = length;
            } else if (a == 0 || a == 4 || a == 1) {
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(jVar.e().subSequence(0, 50 - i2));
                com.baidu.tieba.a.j jVar2 = new com.baidu.tieba.a.j();
                jVar2.a(valueOf);
                jVar2.a(a);
                arrayList.add(jVar2);
                z = true;
            } else {
                z = true;
            }
        }
        if (z) {
            com.baidu.tieba.a.j jVar3 = new com.baidu.tieba.a.j();
            jVar3.a(SpannableStringBuilder.valueOf("..."));
            jVar3.a(0);
            arrayList.add(jVar3);
            return arrayList;
        }
        return list;
    }

    private void a(TextView textView, com.baidu.tieba.a.j jVar) {
        if (textView == null || jVar == null) {
            return;
        }
        if (jVar.a() == 2) {
            textView.setText(jVar.a(this.a, this.b, this.c));
        } else {
            textView.setText(jVar.e());
        }
    }

    public void a(TextView textView, LinearLayout linearLayout, List list, boolean z) {
        TextView textView2;
        int i;
        if (textView == null || linearLayout == null || list == null) {
            return;
        }
        if (list == null || list.size() <= 0) {
            textView.setVisibility(0);
            textView.setText((CharSequence) null);
            return;
        }
        if (this.f) {
            list = a(list);
        }
        com.baidu.tieba.a.j jVar = (com.baidu.tieba.a.j) list.get(0);
        if (jVar == null || !(jVar.a() == 0 || jVar.a() == 2)) {
            textView2 = null;
            i = 0;
        } else {
            textView.setTextSize(com.baidu.tieba.a.h.k());
            textView.setVisibility(0);
            a(textView, jVar);
            i = 1;
            textView2 = textView;
        }
        if (linearLayout == null) {
            return;
        }
        int i2 = -1;
        linearLayout.setVisibility(8);
        while (true) {
            int i3 = i;
            TextView textView3 = textView2;
            int i4 = i2;
            if (i3 >= list.size()) {
                return;
            }
            linearLayout.setVisibility(0);
            com.baidu.tieba.a.j jVar2 = (com.baidu.tieba.a.j) list.get(i3);
            if (jVar2.a() == 3) {
                if (z) {
                    int i5 = i4 + 1;
                    linearLayout.addView(a(list, jVar2, i5));
                    i2 = i5;
                    textView2 = null;
                } else {
                    i2 = i4;
                    textView2 = textView3;
                }
            } else if (textView3 == null) {
                TextView a = a(jVar2);
                linearLayout.addView(a);
                i2 = i4;
                textView2 = a;
            } else if (jVar2.a() == 2) {
                textView3.append(jVar2.a(this.a, this.b, this.c));
                i2 = i4;
                textView2 = textView3;
            } else {
                textView3.append(jVar2.e());
                i2 = i4;
                textView2 = textView3;
            }
            i = i3 + 1;
        }
    }

    public void a(boolean z) {
        this.f = z;
    }
}
