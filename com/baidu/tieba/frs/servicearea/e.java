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
/* loaded from: classes22.dex */
public class e {
    public static void a(Context context, ab abVar) {
        if (abVar != null) {
            TbPageContext<BaseFragmentActivity> tbPageContext = null;
            if (context instanceof BaseActivity) {
                tbPageContext = ((BaseActivity) context).getPageContext();
            } else if (context instanceof BaseFragmentActivity) {
                tbPageContext = ((BaseFragmentActivity) context).getPageContext();
            }
            if (tbPageContext != null) {
                if (abVar.nkO != null) {
                    com.baidu.tieba.aiapps.a.b(abVar.nkO.id, abVar.nkO.link, "1191003700000000", abVar.nkO.exF);
                } else {
                    bf.bua().b(tbPageContext, new String[]{abVar.link});
                }
            }
        }
    }

    public static void b(ab abVar) {
        if (abVar != null) {
            ar arVar = new ar("c13627");
            arVar.dY("fid", abVar.forumId);
            arVar.al("obj_type", abVar.nkO == null ? 1 : 2);
            arVar.al("obj_locate", abVar.index);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("obj_name", abVar.name);
            TiebaStatic.log(arVar);
        }
    }

    public static void c(ab abVar) {
        if (abVar != null) {
            ar arVar = new ar("c13626");
            arVar.dY("fid", abVar.forumId);
            arVar.al("obj_type", abVar.nkO == null ? 1 : 2);
            arVar.al("obj_locate", abVar.index);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("obj_name", abVar.name);
            TiebaStatic.log(arVar);
        }
    }
}
