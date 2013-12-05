package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
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
    private static String g = "tb_divider";
    private static String h = "tb_drawableTop";
    private static String i = "tb_drawableLeft";
    private static String j = "tb_progressDrawable";
    private static String l = "_1";
    private Resources m;
    private boolean k = false;

    /* renamed from: a  reason: collision with root package name */
    Map<String, d> f1267a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a2;
        int a3;
        boolean z = false;
        try {
            this.m = context.getResources();
            int attributeCount = attributeSet.getAttributeCount();
            d dVar = new d();
            dVar.c(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals(b)) {
                    dVar.b(attributeValue);
                } else if (attributeName.equals(c)) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        dVar.g(a4[0]);
                        dVar.h(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(e)) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.k(a5[0]);
                        dVar.l(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(d)) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        dVar.i(a6[0]);
                        dVar.j(a6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(f)) {
                    int[] a7 = a(attributeValue);
                    if (a7 != null) {
                        dVar.n(a7[0]);
                        dVar.m(a7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(g)) {
                    int[] a8 = a(attributeValue);
                    if (a8 != null) {
                        dVar.e(a8[0]);
                        dVar.f(a8[1]);
                        z = true;
                    }
                } else if (attributeName.equals(h)) {
                    int[] a9 = a(attributeValue);
                    if (a9 != null) {
                        dVar.c(a9[0]);
                        dVar.d(a9[1]);
                        z = true;
                    }
                } else if (attributeName.equals(i)) {
                    int[] a10 = a(attributeValue);
                    if (a10 != null) {
                        dVar.a(a10[0]);
                        dVar.b(a10[1]);
                        z = true;
                    }
                } else if (attributeName.equals(j) && (a2 = a(attributeValue)) != null) {
                    dVar.o(a2[0]);
                    dVar.p(a2[1]);
                    z = true;
                }
                if (z && com.baidu.tieba.data.h.s() && (a3 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    dVar.a(attributeName + "=" + this.m.getResourceName(a3));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(dVar.g()) && this.f1267a != null && !this.f1267a.containsKey(dVar.g())) {
                    this.f1267a.put(dVar.g(), dVar);
                } else if (TextUtils.isEmpty(dVar.g())) {
                    com.baidu.adp.lib.h.e.a(dVar.toString() + " PLEASE SET ID!!!");
                } else if (this.f1267a.containsKey(dVar.g())) {
                }
            }
        } catch (Resources.NotFoundException e2) {
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private final int[] a(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.m, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, int i2) {
        String resourceName = resources.getResourceName(i2);
        if (resourceName != null) {
            int identifier = resources.getIdentifier(resourceName + l, null, null);
            if (identifier == 0) {
                com.baidu.adp.lib.h.e.a(resourceName + " 缺少夜间资源,使用了日间资源");
                return i2;
            }
            return identifier;
        }
        com.baidu.adp.lib.h.e.a(i2 + " cann't find name");
        return i2;
    }

    public void a(View view) {
        if (view != null) {
            String str = "@" + view.getId();
            if (this.f1267a != null && this.f1267a.containsKey(str)) {
                d dVar = this.f1267a.get(str);
                if (view instanceof TextView) {
                    if (dVar.k() != 0) {
                        ((TextView) view).setTextColor(this.m.getColorStateList(this.k ? dVar.k() : dVar.j()));
                    }
                    if (dVar.n() != 0) {
                        ((TextView) view).setTextAppearance(view.getContext(), this.k ? dVar.n() : dVar.o());
                    }
                    if (dVar.d() != 0) {
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.m.getDrawable(this.k ? dVar.d() : dVar.c()), (Drawable) null, (Drawable) null);
                    }
                    if (dVar.b() != 0) {
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(this.m.getDrawable(this.k ? dVar.b() : dVar.a()), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                } else if (view instanceof ImageButton) {
                    if (dVar.l() != 0) {
                        Drawable drawable = this.m.getDrawable(this.k ? dVar.l() : dVar.m());
                        if (drawable != null) {
                            ((ImageView) view).setImageDrawable(drawable);
                        }
                    }
                } else if (view instanceof ImageView) {
                    if (dVar.l() != 0) {
                        Drawable drawable2 = this.m.getDrawable(this.k ? dVar.l() : dVar.m());
                        if (drawable2 != null) {
                            ((ImageView) view).setImageDrawable(drawable2);
                        }
                    }
                } else if (view instanceof AdapterView) {
                    if ((view instanceof ListView) && dVar.f() != 0) {
                        ListView listView = (ListView) view;
                        int dividerHeight = listView.getDividerHeight();
                        listView.setDivider(this.m.getDrawable(this.k ? dVar.f() : dVar.e()));
                        listView.setDividerHeight(dividerHeight);
                    }
                    Adapter adapter = ((AdapterView) view).getAdapter();
                    if (adapter != null && (adapter instanceof BaseAdapter)) {
                        ((BaseAdapter) adapter).notifyDataSetChanged();
                    }
                } else if ((view instanceof ProgressBar) && dVar.q() != 0) {
                    Drawable drawable3 = this.m.getDrawable(this.k ? dVar.q() : dVar.p());
                    if (drawable3 != null) {
                        ((ProgressBar) view).setProgressDrawable(drawable3);
                    }
                }
                if (dVar.i() != 0) {
                    int paddingLeft = view.getPaddingLeft();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingBottom = view.getPaddingBottom();
                    view.setBackgroundResource(this.k ? dVar.i() : dVar.h());
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(((ViewGroup) view).getChildAt(i2));
                }
            }
        }
    }

    public boolean a() {
        return this.k;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public void b() {
        if (this.f1267a != null) {
            this.f1267a.clear();
            this.f1267a = null;
        }
    }
}
