package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static String b = LocaleUtil.INDONESIAN;
    private static String c = "tb_background";
    private static String d = "tb_textColor";
    private static String e = "tb_src";
    private static String f = "tb_style";
    private static String g = "tb_button";
    private static String h = "tb_textColorHint";
    private Resources k;
    private boolean i = false;
    private String j = "_1";

    /* renamed from: a  reason: collision with root package name */
    Map<String, d> f1184a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a2;
        boolean z = false;
        try {
            this.k = context.getResources();
            int attributeCount = attributeSet.getAttributeCount();
            d dVar = new d();
            dVar.b(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals(b)) {
                    dVar.a(attributeValue);
                } else if (attributeName.equals(c)) {
                    int[] a3 = a(attributeValue);
                    if (a3 != null) {
                        dVar.c(a3[0]);
                        dVar.d(a3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(g)) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        dVar.b(a4[0]);
                        dVar.a(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(h)) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.e(a5[0]);
                        dVar.f(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(e)) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        dVar.i(a6[0]);
                        dVar.j(a6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(d)) {
                    int[] a7 = a(attributeValue);
                    if (a7 != null) {
                        dVar.g(a7[0]);
                        dVar.h(a7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(f) && (a2 = a(attributeValue)) != null) {
                    dVar.l(a2[0]);
                    dVar.k(a2[1]);
                    z = true;
                }
            }
            if (z && !TextUtils.isEmpty(dVar.c()) && this.f1184a != null && !this.f1184a.containsKey(dVar.c())) {
                this.f1184a.put(dVar.c(), dVar);
            }
        } catch (Resources.NotFoundException e2) {
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private final int[] a(String str) {
        int parseInt;
        String resourceName;
        int identifier;
        if (!TextUtils.isDigitsOnly(str.substring(1)) || (parseInt = Integer.parseInt(str.substring(1))) == 0 || (resourceName = this.k.getResourceName(parseInt)) == null || (identifier = this.k.getIdentifier(resourceName + this.j, null, null)) == 0) {
            return null;
        }
        return new int[]{parseInt, identifier};
    }

    @SuppressLint({"ResourceAsColor"})
    public void a(View view) {
        Adapter adapter;
        if (view != null) {
            String str = "@" + view.getId();
            if (this.f1184a != null && this.f1184a.containsKey(str)) {
                d dVar = this.f1184a.get(str);
                if ((view instanceof CheckBox) && dVar.a() != 0) {
                    ((CheckBox) view).setButtonDrawable(this.i ? dVar.a() : dVar.b());
                }
                if ((view instanceof EditText) && dVar.g() != 0) {
                    ((EditText) view).setHintTextColor(this.i ? this.k.getColor(dVar.g()) : this.k.getColor(dVar.f()));
                }
                if (view instanceof TextView) {
                    if (dVar.i() != 0) {
                        ((TextView) view).setTextColor(this.k.getColorStateList(this.i ? dVar.i() : dVar.h()));
                    }
                    if (dVar.l() != 0) {
                        ((TextView) view).setTextAppearance(view.getContext(), this.i ? dVar.l() : dVar.m());
                    }
                } else if (view instanceof ImageButton) {
                    if (dVar.j() != 0) {
                        ((ImageButton) view).setImageResource(this.i ? dVar.j() : dVar.k());
                    }
                } else if (view instanceof ImageView) {
                    if (dVar.j() != 0) {
                        ((ImageView) view).setImageResource(this.i ? dVar.j() : dVar.k());
                    }
                } else if ((view instanceof AdapterView) && (adapter = ((AdapterView) view).getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
                if (dVar.e() != 0) {
                    int paddingLeft = view.getPaddingLeft();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingBottom = view.getPaddingBottom();
                    view.setBackgroundResource(this.i ? dVar.e() : dVar.d());
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(((ViewGroup) view).getChildAt(i));
                }
            }
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a() {
        if (this.f1184a != null) {
            this.f1184a.clear();
            this.f1184a = null;
        }
    }
}
