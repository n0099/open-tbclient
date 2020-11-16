package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.aa;
/* loaded from: classes21.dex */
public class e {
    public static void a(Context context, aa aaVar) {
        if (aaVar != null) {
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            if (tbPageContext != null) {
                if (aaVar.mWQ != null) {
                    com.baidu.tieba.aiapps.a.b(aaVar.mWQ.id, aaVar.mWQ.link, "1191003700000000", aaVar.mWQ.eqD);
                } else {
                    bf.bqF().b(tbPageContext, new String[]{aaVar.link});
                }
            }
        }
    }

    public static void b(aa aaVar) {
        if (aaVar != null) {
            ar arVar = new ar("c13627");
            arVar.dR("fid", aaVar.forumId);
            arVar.ak("obj_type", aaVar.mWQ == null ? 1 : 2);
            arVar.ak("obj_locate", aaVar.index);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_name", aaVar.name);
            TiebaStatic.log(arVar);
        }
    }

    public static void c(aa aaVar) {
        if (aaVar != null) {
            ar arVar = new ar("c13626");
            arVar.dR("fid", aaVar.forumId);
            arVar.ak("obj_type", aaVar.mWQ == null ? 1 : 2);
            arVar.ak("obj_locate", aaVar.index);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_name", aaVar.name);
            TiebaStatic.log(arVar);
        }
    }
}
