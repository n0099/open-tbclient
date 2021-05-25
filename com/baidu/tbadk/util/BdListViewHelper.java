package com.baidu.tbadk.util;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class BdListViewHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12948a = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);

    /* loaded from: classes3.dex */
    public enum HeadType {
        DEFAULT,
        HASTAB,
        HAS_NO_NETWORK_BAR,
        TIP
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12949a;

        static {
            int[] iArr = new int[HeadType.values().length];
            f12949a = iArr;
            try {
                iArr[HeadType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12949a[HeadType.HASTAB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12949a[HeadType.HAS_NO_NETWORK_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12949a[HeadType.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(HeadType headType) {
        Context context = TbadkCoreApplication.getInst().getContext();
        int i2 = a.f12949a[headType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds88);
                    }
                    return l.g(context, R.dimen.ds56);
                }
                return UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds168);
            }
            return UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds176);
        }
        return UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds88);
    }

    public static int b(HeadType headType, boolean z) {
        int lightStatusBarHeight;
        int g2;
        Context context = TbadkCoreApplication.getInst().getContext();
        if (z) {
            return a(headType);
        }
        if (HeadType.DEFAULT == headType) {
            lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            g2 = l.g(context, R.dimen.ds170);
        } else {
            lightStatusBarHeight = UtilHelper.getLightStatusBarHeight();
            g2 = l.g(context, R.dimen.ds240);
        }
        return lightStatusBarHeight + g2;
    }

    public static void c(View view, HeadType headType, boolean z) {
        if (view == null || headType == null) {
            return;
        }
        Context context = TbadkCoreApplication.getInst().getContext();
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (z) {
            layoutParams.height = a(headType);
        } else if (HeadType.DEFAULT == headType) {
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds170);
        } else {
            layoutParams.height = UtilHelper.getLightStatusBarHeight() + l.g(context, R.dimen.ds240);
        }
        view.setLayoutParams(layoutParams);
    }

    public static View d(Context context, BdListView bdListView, HeadType headType) {
        TextView textView = new TextView(context);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, a(headType)));
        bdListView.x(textView, 0);
        return textView;
    }
}
