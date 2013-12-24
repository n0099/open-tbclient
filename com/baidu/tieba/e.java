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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class e {
    private static String b = "id";
    private static String c = "tb_background";
    private static String d = "tb_textColor";
    private static String e = "tb_src";
    private static String f = "tb_style";
    private static String g = "tb_divider";
    private static String h = "tb_drawableTop";
    private static String i = "tb_drawableLeft";
    private static String j = "tb_drawableRight";
    private static String k = "tb_progressDrawable";
    private static String m = "_1";
    private Resources n;
    private boolean l = false;
    Map<String, d> a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a;
        int a2;
        boolean z = false;
        try {
            this.n = context.getResources();
            int attributeCount = attributeSet.getAttributeCount();
            d dVar = new d();
            dVar.c(str);
            for (int i2 = 0; i2 < attributeCount; i2++) {
                String attributeName = attributeSet.getAttributeName(i2);
                String attributeValue = attributeSet.getAttributeValue(i2);
                if (attributeName.equals(b)) {
                    dVar.b(attributeValue);
                } else if (attributeName.equals(c)) {
                    int[] a3 = a(attributeValue);
                    if (a3 != null) {
                        dVar.i(a3[0]);
                        dVar.j(a3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(e)) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        dVar.m(a4[0]);
                        dVar.n(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(d)) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.k(a5[0]);
                        dVar.l(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(f)) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        dVar.p(a6[0]);
                        dVar.o(a6[1]);
                        z = true;
                    }
                } else if (attributeName.equals(g)) {
                    int[] a7 = a(attributeValue);
                    if (a7 != null) {
                        dVar.e(a7[0]);
                        dVar.f(a7[1]);
                        z = true;
                    }
                } else if (attributeName.equals(h)) {
                    int[] a8 = a(attributeValue);
                    if (a8 != null) {
                        dVar.c(a8[0]);
                        dVar.d(a8[1]);
                        z = true;
                    }
                } else if (attributeName.equals(i)) {
                    int[] a9 = a(attributeValue);
                    if (a9 != null) {
                        dVar.a(a9[0]);
                        dVar.b(a9[1]);
                        z = true;
                    }
                } else if (attributeName.equals(j)) {
                    int[] a10 = a(attributeValue);
                    if (a10 != null) {
                        dVar.g(a10[0]);
                        dVar.h(a10[1]);
                        z = true;
                    }
                } else if (attributeName.equals(k) && (a = a(attributeValue)) != null) {
                    dVar.q(a[0]);
                    dVar.r(a[1]);
                    z = true;
                }
                if (z && com.baidu.tieba.data.h.u() && (a2 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    dVar.a(attributeName + "=" + this.n.getResourceName(a2));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(dVar.g()) && this.a != null && !this.a.containsKey(dVar.g())) {
                    this.a.put(dVar.g(), dVar);
                } else if (TextUtils.isEmpty(dVar.g())) {
                    com.baidu.adp.lib.h.e.a(dVar.toString() + " PLEASE SET ID!!!");
                } else if (this.a.containsKey(dVar.g())) {
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
            return new int[]{parseInt, a(this.n, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, int i2) {
        String resourceName = resources.getResourceName(i2);
        if (resourceName != null) {
            int identifier = resources.getIdentifier(resourceName + m, null, null);
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
            if (this.a != null && this.a.containsKey(str)) {
                d dVar = this.a.get(str);
                if (view instanceof TextView) {
                    if (dVar.m() != 0) {
                        ((TextView) view).setTextColor(this.n.getColorStateList(this.l ? dVar.m() : dVar.l()));
                    }
                    if (dVar.p() != 0) {
                        ((TextView) view).setTextAppearance(view.getContext(), this.l ? dVar.p() : dVar.q());
                    }
                    if (dVar.d() != 0) {
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.n.getDrawable(this.l ? dVar.d() : dVar.c()), (Drawable) null, (Drawable) null);
                    }
                    if (dVar.b() != 0) {
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(this.n.getDrawable(this.l ? dVar.b() : dVar.a()), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                    if (dVar.i() != 0) {
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.n.getDrawable(this.l ? dVar.i() : dVar.h()), (Drawable) null);
                    }
                } else if (view instanceof ImageButton) {
                    if (dVar.n() != 0) {
                        Drawable drawable = this.n.getDrawable(this.l ? dVar.n() : dVar.o());
                        if (drawable != null) {
                            ((ImageView) view).setImageDrawable(drawable);
                        }
                    }
                } else if (view instanceof ImageView) {
                    if (dVar.n() != 0) {
                        Drawable drawable2 = this.n.getDrawable(this.l ? dVar.n() : dVar.o());
                        if (drawable2 != null) {
                            ((ImageView) view).setImageDrawable(drawable2);
                        }
                    }
                } else if (view instanceof AdapterView) {
                    if ((view instanceof ListView) && dVar.f() != 0) {
                        ListView listView = (ListView) view;
                        int dividerHeight = listView.getDividerHeight();
                        listView.setDivider(this.n.getDrawable(this.l ? dVar.f() : dVar.e()));
                        listView.setDividerHeight(dividerHeight);
                    }
                    Adapter adapter = ((AdapterView) view).getAdapter();
                    if (adapter != null && (adapter instanceof BaseAdapter)) {
                        ((BaseAdapter) adapter).notifyDataSetChanged();
                    }
                } else if ((view instanceof ProgressBar) && dVar.s() != 0) {
                    Drawable drawable3 = this.n.getDrawable(this.l ? dVar.s() : dVar.r());
                    if (drawable3 != null) {
                        ((ProgressBar) view).setProgressDrawable(drawable3);
                    }
                }
                if (dVar.k() != 0) {
                    int paddingLeft = view.getPaddingLeft();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingBottom = view.getPaddingBottom();
                    view.setBackgroundResource(this.l ? dVar.k() : dVar.j());
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    try {
                        a(((ViewGroup) view).getChildAt(i2));
                    } catch (Exception e2) {
                        com.baidu.adp.lib.h.e.b(e.class.getName(), "onModeChanged", e2.getMessage());
                        return;
                    }
                }
            }
        }
    }

    public boolean a() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }
}
