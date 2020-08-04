package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes16.dex */
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
                if (zVar.lMj != null) {
                    com.baidu.tieba.aiapps.a.b(zVar.lMj.id, zVar.lMj.link, "1191003700000000", zVar.lMj.dGy);
                } else {
                    bd.baV().b(tbPageContext, new String[]{zVar.link});
                }
                if (zVar.hiL) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    zVar.hiL = false;
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("frs_service_version_" + zVar.forumName + zVar.name, zVar.version);
                }
            }
        }
    }

    public static void b(z zVar) {
        if (zVar != null) {
            ap apVar = new ap("c13627");
            apVar.dn("fid", zVar.forumId);
            apVar.ah("obj_type", zVar.lMj == null ? 1 : 2);
            apVar.ah("obj_locate", zVar.index);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("obj_name", zVar.name);
            TiebaStatic.log(apVar);
        }
    }

    public static void c(z zVar) {
        if (zVar != null) {
            ap apVar = new ap("c13626");
            apVar.dn("fid", zVar.forumId);
            apVar.ah("obj_type", zVar.lMj == null ? 1 : 2);
            apVar.ah("obj_locate", zVar.index);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("obj_name", zVar.name);
            TiebaStatic.log(apVar);
        }
    }
}
