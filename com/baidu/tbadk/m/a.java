package com.baidu.tbadk.m;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static final boolean a(TbPageContext<?> tbPageContext, View view) {
        if (tbPageContext == null || view == null) {
            return false;
        }
        tbPageContext.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().t(view);
        return true;
    }
}
