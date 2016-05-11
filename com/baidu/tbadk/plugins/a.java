package com.baidu.tbadk.plugins;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static boolean EZ() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(HotTopicActivityConfig.class);
    }

    public static boolean f(TbPageContext<?> tbPageContext) {
        if (EZ()) {
            return false;
        }
        BdToast.a(tbPageContext.getPageActivity(), tbPageContext.getResources().getString(t.j.plugin_hottopic_not_install_tip)).sc();
        return true;
    }
}
