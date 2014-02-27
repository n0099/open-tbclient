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
public final class e {
    private Resources c;
    private boolean b = false;
    Map<String, d> a = new HashMap();

    public final void a(String str, Context context, AttributeSet attributeSet) {
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
                        dVar.o(a4[0]);
                        dVar.p(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColor")) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.m(a5[0]);
                        dVar.n(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_style")) {
                    int[] a6 = a(attributeValue);
                    if (a6 != null) {
                        dVar.r(a6[0]);
                        dVar.q(a6[1]);
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
                } else if (attributeName.equals("tb_progressDrawable")) {
                    int[] a11 = a(attributeValue);
                    if (a11 != null) {
                        dVar.s(a11[0]);
                        dVar.t(a11[1]);
                        z = true;
                    }
                } else if (attributeName.equals("tb_textColorHint") && (a = a(attributeValue)) != null) {
                    dVar.k(a[0]);
                    dVar.l(a[1]);
                    z = true;
                }
                if (z && com.baidu.tieba.data.i.F() && (a2 = com.baidu.adp.lib.f.b.a(attributeValue.substring(1), 0)) != 0) {
                    dVar.a(String.valueOf(attributeName) + "=" + this.c.getResourceName(a2));
                }
            }
            if (z) {
                if (!TextUtils.isEmpty(dVar.g()) && this.a != null && !this.a.containsKey(dVar.g())) {
                    this.a.put(dVar.g(), dVar);
                } else if (TextUtils.isEmpty(dVar.g())) {
                    com.baidu.adp.lib.util.e.b(String.valueOf(dVar.toString()) + " PLEASE SET ID!!!");
                } else {
                    this.a.containsKey(dVar.g());
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
            int identifier = resources.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
            if (identifier == 0) {
                com.baidu.adp.lib.util.e.b(String.valueOf(resourceName) + " 缺少夜间资源,使用了日间资源");
                return i;
            }
            return identifier;
        }
        com.baidu.adp.lib.util.e.b(String.valueOf(i) + " cann't find name");
        return i;
    }

    public final void a(View view) {
        if (view != null) {
            Stack stack = new Stack();
            stack.push(view);
            while (!stack.isEmpty()) {
                View view2 = (View) stack.pop();
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
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
                            if (resourceTypeName == null || !resourceTypeName.equals("color")) {
                                viewGroup.setBackgroundResource(l);
                                com.baidu.adp.lib.util.e.e("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                            } else {
                                int color = this.c.getColor(l);
                                viewGroup.setBackgroundColor(color);
                                com.baidu.adp.lib.util.e.e("type:" + resourceTypeName + ",id:" + dVar.g() + ",name:" + dVar.j());
                                if (color == 0) {
                                    com.baidu.adp.lib.util.e.b("name = " + dVar.j() + " background color is missing");
                                }
                            }
                            viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                        }
                    }
                    if (!(view2 instanceof AdapterView)) {
                        int childCount = ((ViewGroup) view2).getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            stack.push(((ViewGroup) view2).getChildAt(i));
                        }
                    }
                } else {
                    String str2 = "@" + view2.getId();
                    if (this.a != null && this.a.containsKey(str2)) {
                        d dVar2 = this.a.get(str2);
                        if (view2 instanceof TextView) {
                            if (dVar2.p() != 0) {
                                ((TextView) view2).setTextColor(this.c.getColorStateList(this.b ? dVar2.p() : dVar2.o()));
                            }
                            if (dVar2.n() != 0) {
                                ((TextView) view2).setHintTextColor(this.c.getColorStateList(this.b ? dVar2.n() : dVar2.m()));
                            }
                            if (dVar2.s() != 0) {
                                ((TextView) view2).setTextAppearance(view2.getContext(), this.b ? dVar2.s() : dVar2.t());
                            }
                            if (dVar2.d() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.c.getDrawable(this.b ? dVar2.d() : dVar2.c()), (Drawable) null, (Drawable) null);
                            }
                            if (dVar2.b() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(this.c.getDrawable(this.b ? dVar2.b() : dVar2.a()), (Drawable) null, (Drawable) null, (Drawable) null);
                            }
                            if (dVar2.i() != 0) {
                                ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.c.getDrawable(this.b ? dVar2.i() : dVar2.h()), (Drawable) null);
                            }
                        } else if (view2 instanceof ImageButton) {
                            if (dVar2.q() != 0) {
                                Drawable drawable = this.c.getDrawable(this.b ? dVar2.q() : dVar2.r());
                                if (drawable != null) {
                                    ((ImageView) view2).setImageDrawable(drawable);
                                }
                            }
                        } else if (view2 instanceof ImageView) {
                            if (dVar2.q() != 0) {
                                Drawable drawable2 = this.c.getDrawable(this.b ? dVar2.q() : dVar2.r());
                                if (drawable2 != null) {
                                    ((ImageView) view2).setImageDrawable(drawable2);
                                }
                            }
                        } else if ((view2 instanceof ProgressBar) && dVar2.v() != 0) {
                            Drawable drawable3 = this.c.getDrawable(this.b ? dVar2.v() : dVar2.u());
                            if (drawable3 != null) {
                                ((ProgressBar) view2).setProgressDrawable(drawable3);
                            }
                        }
                        if (dVar2.l() != 0) {
                            int paddingLeft2 = view2.getPaddingLeft();
                            int paddingTop2 = view2.getPaddingTop();
                            int paddingRight2 = view2.getPaddingRight();
                            int paddingBottom2 = view2.getPaddingBottom();
                            int l2 = this.b ? dVar2.l() : dVar2.k();
                            String resourceTypeName2 = this.c.getResourceTypeName(l2);
                            if (resourceTypeName2 == null || !resourceTypeName2.equals("color")) {
                                view2.setBackgroundResource(l2);
                                com.baidu.adp.lib.util.e.e("type:" + resourceTypeName2 + ",id:" + dVar2.g() + ",name:" + dVar2.j());
                            } else {
                                view2.setBackgroundColor(this.c.getColor(l2));
                                com.baidu.adp.lib.util.e.e("type:" + resourceTypeName2 + ",id:" + dVar2.g() + ",name:" + dVar2.j());
                            }
                            view2.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                        }
                    }
                }
            }
        }
    }

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final void b() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }
}
