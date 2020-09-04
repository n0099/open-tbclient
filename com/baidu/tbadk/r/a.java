package com.baidu.tbadk.r;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c;
/* loaded from: classes.dex */
public class a {
    public static final boolean a(TbPageContext<?> tbPageContext, View view) {
        boolean z = false;
        if (tbPageContext == null || view == null) {
            return false;
        }
        c layoutMode = tbPageContext.getLayoutMode();
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            z = true;
        }
        layoutMode.setNightMode(z);
        tbPageContext.getLayoutMode().onModeChanged(view);
        return true;
    }
}
