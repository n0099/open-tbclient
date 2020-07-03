package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes9.dex */
public class e {
    public static void a(Context context, z zVar, View view) {
        if (zVar != null) {
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            if (tbPageContext != null) {
                if (zVar.lES != null) {
                    com.baidu.tieba.aiapps.a.b(zVar.lES.id, zVar.lES.link, "1191003700000000", zVar.lES.dAC);
                } else {
                    bc.aWU().b(tbPageContext, new String[]{zVar.link});
                }
                if (zVar.hdb) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    zVar.hdb = false;
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("frs_service_version_" + zVar.forumName + zVar.name, zVar.version);
                }
            }
        }
    }

    public static void b(z zVar) {
        if (zVar != null) {
            ao aoVar = new ao("c13627");
            aoVar.dk("fid", zVar.forumId);
            aoVar.ag("obj_type", zVar.lES == null ? 1 : 2);
            aoVar.ag("obj_locate", zVar.index);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("obj_name", zVar.name);
            TiebaStatic.log(aoVar);
        }
    }

    public static void c(z zVar) {
        if (zVar != null) {
            ao aoVar = new ao("c13626");
            aoVar.dk("fid", zVar.forumId);
            aoVar.ag("obj_type", zVar.lES == null ? 1 : 2);
            aoVar.ag("obj_locate", zVar.index);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("obj_name", zVar.name);
            TiebaStatic.log(aoVar);
        }
    }
}
