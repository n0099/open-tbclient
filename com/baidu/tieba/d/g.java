package com.baidu.tieba.d;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.CustomTextView;
import com.slidingmenu.lib.R;
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
    private int g = -16777216;

    public g(Context context) {
        this.a = context;
        TextView textView = new TextView(this.a);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(com.baidu.tieba.a.i.n());
        this.b = textView.getLineHeight();
        this.c = (int) textView.getTextSize();
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void a(TextView textView, LinearLayout linearLayout, List list, boolean z) {
        TextView textView2;
        int i;
        if (textView != null && linearLayout != null && list != null) {
            if (list != null && list.size() > 0) {
                if (this.f) {
                    list = a(list);
                }
                com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) list.get(0);
                if (kVar == null || !(kVar.a() == 0 || kVar.a() == 2)) {
                    textView2 = null;
                    i = 0;
                } else {
                    textView.setTextSize(com.baidu.tieba.a.i.n());
                    textView.setVisibility(0);
                    a(textView, kVar);
                    i = 1;
                    textView2 = textView;
                }
                if (linearLayout != null) {
                    int i2 = -1;
                    linearLayout.setVisibility(8);
                    while (true) {
                        int i3 = i;
                        TextView textView3 = textView2;
                        int i4 = i2;
                        if (i3 < list.size()) {
                            linearLayout.setVisibility(0);
                            com.baidu.tieba.a.k kVar2 = (com.baidu.tieba.a.k) list.get(i3);
                            if (kVar2.a() == 3) {
                                if (z) {
                                    int i5 = i4 + 1;
                                    linearLayout.addView(a(list, kVar2, i5));
                                    i2 = i5;
                                    textView2 = null;
                                } else {
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else if (textView3 != null) {
                                if (kVar2.a() == 2) {
                                    textView3.append(kVar2.a(this.a, this.b, this.c));
                                    i2 = i4;
                                    textView2 = textView3;
                                } else {
                                    textView3.append(kVar2.e());
                                    i2 = i4;
                                    textView2 = textView3;
                                }
                            } else {
                                TextView a = a(kVar2);
                                linearLayout.addView(a);
                                i2 = i4;
                                textView2 = a;
                            }
                            i = i3 + 1;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                textView.setVisibility(0);
                textView.setText((CharSequence) null);
            }
        }
    }

    private List a(List list) {
        boolean z;
        int length;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            com.baidu.tieba.a.k kVar = (com.baidu.tieba.a.k) list.get(i);
            int a = kVar.a();
            if (a == 0 || a == 4 || a == 1) {
                length = kVar.e() != null ? kVar.e().length() + i2 : i2;
            } else {
                length = i2 + 1;
            }
            if (length > 50) {
                if (a == 0 || a == 4 || a == 1) {
                    SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(kVar.e().subSequence(0, 50 - i2));
                    com.baidu.tieba.a.k kVar2 = new com.baidu.tieba.a.k();
                    kVar2.a(valueOf);
                    kVar2.a(a);
                    arrayList.add(kVar2);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                arrayList.add(kVar);
                i++;
                i2 = length;
            }
        }
        if (z) {
            com.baidu.tieba.a.k kVar3 = new com.baidu.tieba.a.k();
            kVar3.a(SpannableStringBuilder.valueOf("..."));
            kVar3.a(0);
            arrayList.add(kVar3);
            return arrayList;
        }
        return list;
    }

    private void a(TextView textView, com.baidu.tieba.a.k kVar) {
        if (textView != null && kVar != null) {
            if (kVar.a() == 2) {
                textView.setText(kVar.a(this.a, this.b, this.c));
            } else {
                textView.setText(kVar.e());
            }
        }
    }

    private TextView a(com.baidu.tieba.a.k kVar) {
        CustomTextView customTextView = new CustomTextView(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int a = ag.a(this.a, 15.0f);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = a;
        layoutParams.bottomMargin = 0;
        customTextView.setLineSpacing(0.0f, 1.2f);
        customTextView.setTextSize(com.baidu.tieba.a.i.n());
        if (TiebaApplication.e().as() == 1) {
            customTextView.setTextColor(ac.a(1));
        } else {
            customTextView.setTextColor(this.g);
        }
        a(customTextView, kVar);
        customTextView.setMovementMethod(LinkMovementMethod.getInstance());
        customTextView.setFocusable(false);
        customTextView.setLayoutParams(layoutParams);
        return customTextView;
    }

    private ImageView a(List list, com.baidu.tieba.a.k kVar, int i) {
        ImageView imageView = new ImageView(this.a);
        int a = ag.a(this.a, 105.0f);
        int a2 = ag.a(this.a, 105.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, a);
        layoutParams.topMargin = ag.a(this.a, 15.0f);
        layoutParams.bottomMargin = 0;
        com.baidu.adp.widget.a.b c = this.d.c(kVar.f());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setMaxWidth(a2);
        if (c != null) {
            imageView.setTag(null);
            c.b(imageView);
        } else {
            imageView.setTag(kVar.f());
            imageView.setImageBitmap(d.a((int) R.drawable.image_default));
        }
        imageView.setClickable(true);
        imageView.setFocusable(false);
        imageView.setOnClickListener(this.e);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void a(int i) {
        this.g = i;
    }
}
