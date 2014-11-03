package com.baidu.tbadk.mvc.g;

import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.mvc.c.b;
import com.baidu.tbadk.mvc.e.c;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a {
    public static final void a(View view, int i, Object obj) {
        if (view != null && obj != null) {
            if ((i >>> 24) < 2) {
                if (TbadkApplication.m251getInst().isDebugMode()) {
                    throw new InvalidParameterException("The key must be an application-specific resource id.");
                }
                return;
            }
            view.setTag(i, obj);
        }
    }

    public static final void a(b bVar, View view) {
        if (bVar != null && view != null) {
            int tr = bVar.tr();
            BdUniqueId uniqueId = bVar.getUniqueId();
            com.baidu.tbadk.mvc.b.a ts = bVar.ts();
            c tt = bVar.tt();
            com.baidu.tbadk.mvc.a.a tu = bVar.tu();
            Object extra = bVar.getExtra();
            boolean tv = bVar.tv();
            int tw = bVar.tw();
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(50331648, Integer.valueOf(tr));
            sparseArray.put(51380224, uniqueId);
            sparseArray.put(52428800, ts);
            sparseArray.put(53477376, tt);
            sparseArray.put(54525952, tu);
            sparseArray.put(58720256, extra);
            sparseArray.put(59768832, Boolean.valueOf(tv));
            sparseArray.put(67108864, Integer.valueOf(tw));
            a(sparseArray, view);
        }
    }

    public static final b t(View view) {
        if (view != null) {
            Object tag = view.getTag(50331648);
            Object tag2 = view.getTag(51380224);
            Object tag3 = view.getTag(52428800);
            Object tag4 = view.getTag(53477376);
            Object tag5 = view.getTag(54525952);
            Object tag6 = view.getTag(58720256);
            Object tag7 = view.getTag(59768832);
            Object tag8 = view.getTag(67108864);
            if ((tag instanceof Integer) && ((tag2 == null || (tag2 instanceof BdUniqueId)) && ((tag3 == null || (tag3 instanceof com.baidu.tbadk.mvc.b.a)) && ((tag4 == null || (tag4 instanceof c)) && ((tag5 == null || (tag5 instanceof com.baidu.tbadk.mvc.a.a)) && ((tag7 == null || (tag7 instanceof Boolean)) && (tag8 == null || (tag8 instanceof Integer)))))))) {
                int intValue = ((Integer) tag).intValue();
                BdUniqueId bdUniqueId = (BdUniqueId) tag2;
                boolean booleanValue = ((Boolean) tag7).booleanValue();
                int intValue2 = ((Integer) tag8).intValue();
                b bVar = new b(intValue, (com.baidu.tbadk.mvc.b.a) tag3, (c) tag4, (com.baidu.tbadk.mvc.a.a) tag5);
                bVar.setUniqueId(bdUniqueId);
                bVar.setExtra(tag6);
                bVar.az(booleanValue);
                bVar.di(intValue2);
                return bVar;
            }
        }
        return null;
    }

    public static final void a(b bVar, Dialog dialog) {
        if (bVar != null && dialog != null && dialog.getWindow() != null && dialog.getWindow().getDecorView() != null) {
            a(bVar, dialog.getWindow().getDecorView());
        }
    }

    public static final b a(Dialog dialog) {
        if (dialog == null || dialog.getWindow() == null || dialog.getWindow().getDecorView() == null) {
            return null;
        }
        return t(dialog.getWindow().getDecorView());
    }

    public static final void a(SparseArray<Object> sparseArray, View view) {
        if (sparseArray != null && view != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                a(view, keyAt, sparseArray.get(keyAt));
            }
        }
    }
}
