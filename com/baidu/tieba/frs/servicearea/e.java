package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
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
                if (zVar.ljP != null) {
                    com.baidu.tieba.aiapps.a.b(zVar.ljP.id, zVar.ljP.link, "1191003700000000", zVar.ljP.dvQ);
                } else {
                    ba.aUZ().b(tbPageContext, new String[]{zVar.link});
                }
                if (zVar.gQh) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    zVar.gQh = false;
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("frs_service_version_" + zVar.forumName + zVar.name, zVar.version);
                }
            }
        }
    }

    public static void b(z zVar) {
        if (zVar != null) {
            an anVar = new an("c13627");
            anVar.dh("fid", zVar.forumId);
            anVar.ag("obj_type", zVar.ljP == null ? 1 : 2);
            anVar.ag("obj_locate", zVar.index);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("obj_name", zVar.name);
            TiebaStatic.log(anVar);
        }
    }

    public static void c(z zVar) {
        if (zVar != null) {
            an anVar = new an("c13626");
            anVar.dh("fid", zVar.forumId);
            anVar.ag("obj_type", zVar.ljP == null ? 1 : 2);
            anVar.ag("obj_locate", zVar.index);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("obj_name", zVar.name);
            TiebaStatic.log(anVar);
        }
    }
}
