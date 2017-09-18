package com.baidu.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdListViewHelper {
    public static final int aMb = com.baidu.adp.lib.util.k.f(TbadkCoreApplication.getInst().getContext(), d.f.ds320);

    /* loaded from: classes.dex */
    public enum HeadType {
        DEFAULT,
        HASTAB,
        HAS_NO_NETWORK_BAR
    }

    public static int a(HeadType headType) {
        Context context = TbadkCoreApplication.getInst().getContext();
        switch (headType) {
            case DEFAULT:
                return com.baidu.adp.lib.util.k.f(context, d.f.ds98) + UtilHelper.getLightStatusBarHeight();
            case HASTAB:
                return com.baidu.adp.lib.util.k.f(context, d.f.ds176) + UtilHelper.getLightStatusBarHeight();
            case HAS_NO_NETWORK_BAR:
                return com.baidu.adp.lib.util.k.f(context, d.f.ds168) + UtilHelper.getLightStatusBarHeight();
            default:
                return com.baidu.adp.lib.util.k.f(context, d.f.ds98) + UtilHelper.getLightStatusBarHeight();
        }
    }

    public static View a(Context context, BdListView bdListView, HeadType headType) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, a(headType)));
        bdListView.addHeaderView(textView, 0);
        return textView;
    }

    public static void a(View view, HeadType headType, boolean z) {
        if (view != null && headType != null) {
            Context context = TbadkCoreApplication.getInst().getContext();
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (z) {
                layoutParams.height = a(headType);
            } else if (HeadType.DEFAULT == headType) {
                layoutParams.height = com.baidu.adp.lib.util.k.f(context, d.f.ds170) + UtilHelper.getLightStatusBarHeight();
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.f(context, d.f.ds240) + UtilHelper.getLightStatusBarHeight();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static int a(HeadType headType, boolean z) {
        Context context = TbadkCoreApplication.getInst().getContext();
        if (z) {
            return a(headType);
        }
        if (HeadType.DEFAULT == headType) {
            return com.baidu.adp.lib.util.k.f(context, d.f.ds170) + UtilHelper.getLightStatusBarHeight();
        }
        return com.baidu.adp.lib.util.k.f(context, d.f.ds240) + UtilHelper.getLightStatusBarHeight();
    }
}
