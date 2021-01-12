package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
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
                if (abVar.nlQ != null) {
                    com.baidu.tieba.aiapps.a.b(abVar.nlQ.id, abVar.nlQ.link, "1191003700000000", abVar.nlQ.eCi);
                } else {
                    be.bsB().b(tbPageContext, new String[]{abVar.link});
                }
            }
        }
    }

    public static void b(ab abVar) {
        if (abVar != null) {
            aq aqVar = new aq("c13627");
            aqVar.dW("fid", abVar.forumId);
            aqVar.an("obj_type", abVar.nlQ == null ? 1 : 2);
            aqVar.an("obj_locate", abVar.index);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("obj_name", abVar.name);
            TiebaStatic.log(aqVar);
        }
    }

    public static void c(ab abVar) {
        if (abVar != null) {
            aq aqVar = new aq("c13626");
            aqVar.dW("fid", abVar.forumId);
            aqVar.an("obj_type", abVar.nlQ == null ? 1 : 2);
            aqVar.an("obj_locate", abVar.index);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("obj_name", abVar.name);
            TiebaStatic.log(aqVar);
        }
    }
}
