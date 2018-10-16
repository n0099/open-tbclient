package com.baidu.tieba.frs.worldcup;

import android.graphics.Color;
import android.util.Pair;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.List;
import tbclient.FrsPage.TabSkin;
/* loaded from: classes6.dex */
public class b {
    public static void a(NavigationBar navigationBar, Pair<Integer, Integer> pair) {
        if (pair != null && navigationBar != null) {
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            if (!(TbadkCoreApplication.getInst().getSkinType() == 1)) {
                intValue2 = intValue;
            }
            if (intValue != 0) {
                navigationBar.getBackground().mutate().setAlpha(0);
                navigationBar.getBarBgView().setBackgroundColor(intValue2);
            }
        }
    }

    public static void a(View view, Pair<Integer, Integer> pair) {
        if (pair != null && view != null) {
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            if (!(TbadkCoreApplication.getInst().getSkinType() == 1)) {
                intValue2 = intValue;
            }
            if (intValue != 0) {
                view.setBackgroundColor(intValue2);
            }
        }
    }

    public static int oq(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static TabSkin k(List<TabSkin> list, int i) {
        if (list == null) {
            return null;
        }
        for (TabSkin tabSkin : list) {
            if (tabSkin != null && i == tabSkin.tab_id.intValue()) {
                return tabSkin;
            }
        }
        return nh(i);
    }

    public static TabSkin nh(int i) {
        TabSkin.Builder builder = new TabSkin.Builder();
        builder.tab_id = Integer.valueOf(i);
        builder.icon = "";
        builder.icon_night = "";
        return builder.build(false);
    }
}
