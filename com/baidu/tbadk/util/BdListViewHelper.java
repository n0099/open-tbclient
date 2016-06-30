package com.baidu.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class BdListViewHelper {
    public static final int aAL = com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m9getInst().getContext(), u.e.ds320);
    private static /* synthetic */ int[] aAM;

    /* loaded from: classes.dex */
    public enum HeadType {
        DEFAULT,
        HASTAB;

        /* JADX DEBUG: Replace access to removed values field (aAN) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static HeadType[] valuesCustom() {
            HeadType[] valuesCustom = values();
            int length = valuesCustom.length;
            HeadType[] headTypeArr = new HeadType[length];
            System.arraycopy(valuesCustom, 0, headTypeArr, 0, length);
            return headTypeArr;
        }
    }

    static /* synthetic */ int[] Fx() {
        int[] iArr = aAM;
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
            aAM = iArr;
        }
        return iArr;
    }

    public static int a(HeadType headType) {
        Context context = TbadkCoreApplication.m9getInst().getContext();
        switch (Fx()[headType.ordinal()]) {
            case 1:
                return com.baidu.adp.lib.util.k.c(context, u.e.ds98) + UtilHelper.getLightStatusBarHeight();
            case 2:
                return com.baidu.adp.lib.util.k.c(context, u.e.ds176) + UtilHelper.getLightStatusBarHeight();
            default:
                return com.baidu.adp.lib.util.k.c(context, u.e.ds98) + UtilHelper.getLightStatusBarHeight();
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
                layoutParams.height = com.baidu.adp.lib.util.k.c(context, u.e.ds170) + UtilHelper.getLightStatusBarHeight();
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.c(context, u.e.ds240) + UtilHelper.getLightStatusBarHeight();
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
            return com.baidu.adp.lib.util.k.c(context, u.e.ds170) + UtilHelper.getLightStatusBarHeight();
        }
        return com.baidu.adp.lib.util.k.c(context, u.e.ds240) + UtilHelper.getLightStatusBarHeight();
    }
}
