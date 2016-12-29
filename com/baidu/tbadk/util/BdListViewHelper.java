package com.baidu.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class BdListViewHelper {
    public static final int aEq = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getContext(), r.e.ds320);
    private static /* synthetic */ int[] aEr;

    /* loaded from: classes.dex */
    public enum HeadType {
        DEFAULT,
        HASTAB,
        HAS_NO_NETWORK_BAR;

        /* JADX DEBUG: Replace access to removed values field (aEs) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HeadType[] valuesCustom() {
            HeadType[] valuesCustom = values();
            int length = valuesCustom.length;
            HeadType[] headTypeArr = new HeadType[length];
            System.arraycopy(valuesCustom, 0, headTypeArr, 0, length);
            return headTypeArr;
        }
    }

    static /* synthetic */ int[] Gq() {
        int[] iArr = aEr;
        if (iArr == null) {
            iArr = new int[HeadType.valuesCustom().length];
            try {
                iArr[HeadType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HeadType.HASTAB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HeadType.HAS_NO_NETWORK_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            aEr = iArr;
        }
        return iArr;
    }

    public static int a(HeadType headType) {
        Context context = TbadkCoreApplication.m9getInst().getContext();
        switch (Gq()[headType.ordinal()]) {
            case 1:
                return com.baidu.adp.lib.util.k.e(context, r.e.ds98) + UtilHelper.getLightStatusBarHeight();
            case 2:
                return com.baidu.adp.lib.util.k.e(context, r.e.ds176) + UtilHelper.getLightStatusBarHeight();
            case 3:
                return com.baidu.adp.lib.util.k.e(context, r.e.ds168) + UtilHelper.getLightStatusBarHeight();
            default:
                return com.baidu.adp.lib.util.k.e(context, r.e.ds98) + UtilHelper.getLightStatusBarHeight();
        }
    }

    public static View a(Context context, BdListView bdListView, HeadType headType) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, a(headType)));
        bdListView.f(textView, 0);
        return textView;
    }

    public static void a(View view, HeadType headType, boolean z) {
        if (view != null && headType != null) {
            Context context = TbadkCoreApplication.m9getInst().getContext();
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (z) {
                layoutParams.height = a(headType);
            } else if (HeadType.DEFAULT == headType) {
                layoutParams.height = com.baidu.adp.lib.util.k.e(context, r.e.ds170) + UtilHelper.getLightStatusBarHeight();
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.e(context, r.e.ds240) + UtilHelper.getLightStatusBarHeight();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static int a(HeadType headType, boolean z) {
        Context context = TbadkCoreApplication.m9getInst().getContext();
        if (z) {
            return a(headType);
        }
        if (HeadType.DEFAULT == headType) {
            return com.baidu.adp.lib.util.k.e(context, r.e.ds170) + UtilHelper.getLightStatusBarHeight();
        }
        return com.baidu.adp.lib.util.k.e(context, r.e.ds240) + UtilHelper.getLightStatusBarHeight();
    }
}
