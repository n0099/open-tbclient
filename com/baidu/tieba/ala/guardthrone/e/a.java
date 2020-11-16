package com.baidu.tieba.ala.guardthrone.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a {
    public static void c(ListView listView) {
        try {
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                int count = adapter.getCount();
                int i = 0;
                for (int i2 = 0; i2 < count; i2++) {
                    View view = adapter.getView(i2, null, listView);
                    view.measure(0, 0);
                    i += view.getMeasuredHeight();
                }
                ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
                layoutParams.height = i + ((adapter.getCount() - 1) * listView.getDividerHeight());
                listView.setLayoutParams(layoutParams);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int a(Context context, HListView hListView) {
        int dip2px = BdUtilHelper.dip2px(context, 20.0f);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(context);
        try {
            ListAdapter adapter = hListView.getAdapter();
            if (adapter != null) {
                View view = adapter.getView(0, null, hListView);
                view.measure(0, 0);
                int measuredWidth = view.getMeasuredWidth();
                if (equipmentWidth - (adapter.getCount() * measuredWidth) > 0) {
                    return (equipmentWidth - (measuredWidth * adapter.getCount())) / (adapter.getCount() + 1);
                }
                return dip2px;
            }
            return dip2px;
        } catch (Exception e) {
            e.printStackTrace();
            return dip2px;
        }
    }

    public static String f(Long l) {
        SimpleDateFormat simpleDateFormat;
        if (l.longValue() > 3600) {
            simpleDateFormat = new SimpleDateFormat("HH时mm分ss秒");
        } else {
            simpleDateFormat = new SimpleDateFormat("mm分ss秒");
        }
        return simpleDateFormat.format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String GW(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong >= 10000000) {
                return y((parseLong * 1.0d) / 10000.0d) + "万";
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    private static double y(double d) {
        return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), 1, 4).doubleValue();
    }
}
