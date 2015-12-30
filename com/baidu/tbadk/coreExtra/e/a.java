package com.baidu.tbadk.coreExtra.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.m411getInst().getContext().getString(n.j.url_notify), str);
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.j.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cE(string).cF(format).a(TbadkCoreApplication.m411getInst().getContext().getString(n.j.alert_yes_button), bVar).b(TbadkCoreApplication.m411getInst().getContext().getString(n.j.alert_no_button), bVar2).b(tbPageContext);
        b.tf();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, a.b bVar, String str) {
        if (l.C(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.j.bar_code_result);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(l.C(context).getPageActivity()).cE(string).cF(str).a(TbadkCoreApplication.m411getInst().getContext().getString(n.j.alert_yes_button), bVar).b(l.C(context));
        if (context instanceof Activity) {
            b.tf();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, a.b bVar) {
        if (l.C(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.j.anti_title);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(n.j.msg_album_bug);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(l.C(context).getPageActivity()).cE(string).cF(string2).a(TbadkCoreApplication.m411getInst().getContext().getString(n.j.alert_yes_button), bVar).b(l.C(context));
        if (context instanceof Activity) {
            b.tf();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.j.setup);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(n.j.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cF(TbadkCoreApplication.m411getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.te();
            return aVar;
        }
        aVar.tf();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2) {
        return a(tbPageContext, i, bVar, bVar2, false);
    }

    public static c a(Context context, c.b bVar) {
        if (l.C(context) == null) {
            return null;
        }
        c cVar = new c(l.C(context).getPageActivity());
        cVar.cG(TbadkCoreApplication.m411getInst().getString(n.j.operation));
        cVar.a(new String[]{TbadkCoreApplication.m411getInst().getString(n.j.delete_user_chat)}, bVar);
        cVar.d(l.C(context));
        if (context instanceof Activity) {
            cVar.tj();
            return cVar;
        }
        return cVar;
    }
}
