package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
    private Resources i;
    private boolean g = false;
    private String h = "_1";

    /* renamed from: a  reason: collision with root package name */
    Map<String, d> f1052a = new HashMap();

    public void a(String str, Context context, AttributeSet attributeSet) {
        int[] a2;
        boolean z = false;
        try {
            this.i = context.getResources();
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
                        dVar.a(a3[0]);
                        dVar.b(a3[1]);
                        z = true;
                    }
                } else if (attributeName.equals(e)) {
                    int[] a4 = a(attributeValue);
                    if (a4 != null) {
                        dVar.e(a4[0]);
                        dVar.f(a4[1]);
                        z = true;
                    }
                } else if (attributeName.equals(d)) {
                    int[] a5 = a(attributeValue);
                    if (a5 != null) {
                        dVar.c(a5[0]);
                        dVar.d(a5[1]);
                        z = true;
                    }
                } else if (attributeName.equals(f) && (a2 = a(attributeValue)) != null) {
                    dVar.h(a2[0]);
                    dVar.g(a2[1]);
                    z = true;
                }
            }
            if (z && !TextUtils.isEmpty(dVar.a()) && this.f1052a != null && !this.f1052a.containsKey(dVar.a())) {
                this.f1052a.put(dVar.a(), dVar);
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
        if (!TextUtils.isDigitsOnly(str.substring(1)) || (parseInt = Integer.parseInt(str.substring(1))) == 0 || (resourceName = this.i.getResourceName(parseInt)) == null || (identifier = this.i.getIdentifier(String.valueOf(resourceName) + this.h, null, null)) == 0) {
            return null;
        }
        return new int[]{parseInt, identifier};
    }

    public void a(View view) {
        Adapter adapter;
        if (view != null) {
            String str = "@" + view.getId();
            if (this.f1052a != null && this.f1052a.containsKey(str)) {
                d dVar = this.f1052a.get(str);
                if (view instanceof TextView) {
                    if (dVar.e() != 0) {
                        ((TextView) view).setTextColor(this.i.getColor(this.g ? dVar.e() : dVar.d()));
                    }
                    if (dVar.h() != 0) {
                        ((TextView) view).setTextAppearance(view.getContext(), this.g ? dVar.h() : dVar.i());
                    }
                } else if (view instanceof ImageButton) {
                    if (dVar.f() != 0) {
                        ((ImageButton) view).setImageResource(this.g ? dVar.f() : dVar.g());
                    }
                } else if (view instanceof ImageView) {
                    if (dVar.f() != 0) {
                        ((ImageView) view).setImageResource(this.g ? dVar.f() : dVar.g());
                    }
                } else if ((view instanceof AdapterView) && (adapter = ((AdapterView) view).getAdapter()) != null && (adapter instanceof BaseAdapter)) {
                    ((BaseAdapter) adapter).notifyDataSetChanged();
                }
                if (dVar.c() != 0) {
                    int paddingLeft = view.getPaddingLeft();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingBottom = view.getPaddingBottom();
                    view.setBackgroundResource(this.g ? dVar.c() : dVar.b());
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
        this.g = z;
    }

    public void a() {
        if (this.f1052a != null) {
            this.f1052a.clear();
            this.f1052a = null;
        }
    }
}
