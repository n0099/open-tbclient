package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.tbadkCore.aa;
/* loaded from: classes22.dex */
public class e {
    public static void a(Context context, aa aaVar, View view) {
        if (aaVar != null) {
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            if (tbPageContext != null) {
                if (aaVar.mVX != null) {
                    com.baidu.tieba.aiapps.a.b(aaVar.mVX.id, aaVar.mVX.link, "1191003700000000", aaVar.mVX.esj);
                } else {
                    be.brr().b(tbPageContext, new String[]{aaVar.link});
                }
                if (aaVar.bfM) {
                    if (view != null) {
                        view.setVisibility(8);
                    }
                    aaVar.bfM = false;
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("frs_service_version_" + aaVar.forumName + aaVar.name, aaVar.version);
                }
            }
        }
    }

    public static void b(aa aaVar) {
        if (aaVar != null) {
            aq aqVar = new aq("c13627");
            aqVar.dR("fid", aaVar.forumId);
            aqVar.al("obj_type", aaVar.mVX == null ? 1 : 2);
            aqVar.al("obj_locate", aaVar.index);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("obj_name", aaVar.name);
            TiebaStatic.log(aqVar);
        }
    }

    public static void c(aa aaVar) {
        if (aaVar != null) {
            aq aqVar = new aq("c13626");
            aqVar.dR("fid", aaVar.forumId);
            aqVar.al("obj_type", aaVar.mVX == null ? 1 : 2);
            aqVar.al("obj_locate", aaVar.index);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("obj_name", aaVar.name);
            TiebaStatic.log(aqVar);
        }
    }
}
