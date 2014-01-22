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
import java.util.Stack;
/* loaded from: classes.dex */
public class e {
    private Resources c;
    private boolean b = false;
    Map<String, d> a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a;
        int a2;
        boolean z = false;
        try {
            this.c = context.getResources();
            int attributeCount = attributeSet.getAttributeCount();
            d dVar = new d();
            dVar.c(str);
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                String attributeValue = attributeSet.getAttributeValue(i);
                if (attributeName.equals("id")) {
                    dVar.b(attributeValue);
                } else if (attributeName.equals("tb_background")) {
                    int[] a3 = a(attributeValue);
                    if (a3 != null) {
                        dVar.i(a3[0]);
                        dVar.j(a3[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_src")) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        dVar.m(a4[0]);
                        dVar.n(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.k(a5[0]);
                        dVar.l(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        dVar.p(a6[0]);
                        dVar.o(a6[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_divider")) {
                    int[] a7 = a(attributeValue);
                    if (a7 != null) {
                        dVar.e(a7[0]);
                        dVar.f(a7[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableTop")) {
                    int[] a8 = a(attributeValue);
                    if (a8 != null) {
                        dVar.c(a8[0]);
                        dVar.d(a8[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableLeft")) {
                    int[] a9 = a(attributeValue);
                    if (a9 != null) {
                        dVar.a(a9[0]);
                        dVar.b(a9[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_drawableRight")) {
                    int[] a10 = a(attributeValue);
                    if (a10 != null) {
                        dVar.g(a10[0]);
                        dVar.h(a10[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_progressDrawable") && (a = a(attributeValue)) != null) {
                    dVar.q(a[0]);
                    dVar.r(a[1]);
                    z = true;
                }
                if (z && com.baidu.tieba.data.h.u() && (a2 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    dVar.a(attributeName + "=" + this.c.getResourceName(a2));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(dVar.g()) && this.a != null && !this.a.containsKey(dVar.g())) {
                    this.a.put(dVar.g(), dVar);
                } else if (TextUtils.isEmpty(dVar.g())) {
                    com.baidu.adp.lib.g.e.a(dVar.toString() + " PLEASE SET ID!!!");
                } else if (this.a.containsKey(dVar.g())) {
                }
            }
        } catch (Resources.NotFoundException e) {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final int[] a(String str) {
        int parseInt;
        if (TextUtils.isDigitsOnly(str.substring(1)) && (parseInt = Integer.parseInt(str.substring(1))) != 0) {
            return new int[]{parseInt, a(this.c, parseInt)};
        }
        return null;
    }

    public static int a(Resources resources, int i) {
        String resourceName = resources.getResourceName(i);
        if (resourceName != null) {
            int identifier = resources.getIdentifier(resourceName + "_1", null, null);
            if (identifier == 0) {
                com.baidu.adp.lib.g.e.a(resourceName + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return identifier;
        }
        com.baidu.adp.lib.g.e.a(i + " cann't find name");
        return i;
    }

    public void a(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    a((ViewGroup) view2);
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    b(view2);
                }
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        String str = "@" + viewGroup.getId();
        if (this.a != null && this.a.containsKey(str)) {
            d dVar = this.a.get(str);
            if (viewGroup instanceof AdapterView) {
                if ((viewGroup instanceof ListView) && dVar.f() != 0) {
                    ListView listView = (ListView) viewGroup;
                    int dividerHeight = listView.getDividerHeight();
                    listView.setDivider(this.c.getDrawable(this.b ? dVar.f() : dVar.e()));
                    listView.setDividerHeight(dividerHeight);
                }
                Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                if (adapter != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
            }
            if (dVar.l() != 0) {
                int paddingLeft = viewGroup.getPaddingLeft();
                int paddingTop = viewGroup.getPaddingTop();
                int paddingRight = viewGroup.getPaddingRight();
                int paddingBottom = viewGroup.getPaddingBottom();
                int l = this.b ? dVar.l() : dVar.k();
                String resourceTypeName = this.c.getResourceTypeName(l);
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    int color = this.c.getColor(l);
                    viewGroup.setBackgroundColor(color);
                    com.baidu.adp.lib.g.e.d("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                    if (color == 0) {
                        com.baidu.adp.lib.g.e.a("name = " + dVar.j() + " background color is missing");
                    }
                } else {
                    viewGroup.setBackgroundResource(l);
                    com.baidu.adp.lib.g.e.d("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                }
                viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private void b(View view) {
        String str = "@" + view.getId();
        if (this.a != null && this.a.containsKey(str)) {
            d dVar = this.a.get(str);
            if (view instanceof TextView) {
                if (dVar.n() != 0) {
                    ((TextView) view).setTextColor(this.c.getColorStateList(this.b ? dVar.n() : dVar.m()));
                }
                if (dVar.q() != 0) {
                    ((TextView) view).setTextAppearance(view.getContext(), this.b ? dVar.q() : dVar.r());
                }
                if (dVar.d() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.c.getDrawable(this.b ? dVar.d() : dVar.c()), (Drawable) null, (Drawable) null);
                }
                if (dVar.b() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(this.c.getDrawable(this.b ? dVar.b() : dVar.a()), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (dVar.i() != 0) {
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getDrawable(this.b ? dVar.i() : dVar.h()), (Drawable) null);
                }
            } else if (view instanceof ImageButton) {
                if (dVar.o() != 0) {
                    Drawable drawable = this.c.getDrawable(this.b ? dVar.o() : dVar.p());
                    if (drawable != null) {
                        ((ImageView) view).setImageDrawable(drawable);
                    }
                }
            } else if (view instanceof ImageView) {
                if (dVar.o() != 0) {
                    Drawable drawable2 = this.c.getDrawable(this.b ? dVar.o() : dVar.p());
                    if (drawable2 != null) {
                        ((ImageView) view).setImageDrawable(drawable2);
                    }
                }
            } else if ((view instanceof ProgressBar) && dVar.t() != 0) {
                Drawable drawable3 = this.c.getDrawable(this.b ? dVar.t() : dVar.s());
                if (drawable3 != null) {
                    ((ProgressBar) view).setProgressDrawable(drawable3);
                }
            }
            if (dVar.l() != 0) {
                int paddingLeft = view.getPaddingLeft();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingBottom = view.getPaddingBottom();
                int l = this.b ? dVar.l() : dVar.k();
                String resourceTypeName = this.c.getResourceTypeName(l);
                if (resourceTypeName != null && resourceTypeName.equals("color")) {
                    view.setBackgroundColor(this.c.getColor(l));
                    com.baidu.adp.lib.g.e.d("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                } else {
                    view.setBackgroundResource(l);
                    com.baidu.adp.lib.g.e.d("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }
}
