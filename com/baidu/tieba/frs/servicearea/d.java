package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.ab;
/* loaded from: classes2.dex */
public class d {
    public static void a(Context context, ab abVar) {
        if (abVar != null) {
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            if (tbPageContext != null) {
                if (abVar.nvA != null) {
                    com.baidu.tieba.aiapps.a.b(abVar.nvA.id, abVar.nvA.link, "1191003700000000", abVar.nvA.eEp);
                } else {
                    bf.bsV().b(tbPageContext, new String[]{abVar.link});
                }
            }
        }
    }

    public static void b(ab abVar) {
        if (abVar != null) {
            ar arVar = new ar("c13627");
            arVar.dR("fid", abVar.forumId);
            arVar.ap("obj_type", abVar.nvA == null ? 1 : 2);
            arVar.ap("obj_locate", abVar.index);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_name", abVar.name);
            TiebaStatic.log(arVar);
        }
    }

    public static void c(ab abVar) {
        if (abVar != null) {
            ar arVar = new ar("c13626");
            arVar.dR("fid", abVar.forumId);
            arVar.ap("obj_type", abVar.nvA == null ? 1 : 2);
            arVar.ap("obj_locate", abVar.index);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("obj_name", abVar.name);
            TiebaStatic.log(arVar);
        }
    }
}
