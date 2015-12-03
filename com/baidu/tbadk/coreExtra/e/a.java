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
        String format = String.format(TbadkCoreApplication.m411getInst().getContext().getString(n.i.url_notify), str);
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.i.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cB(string).cC(format).a(TbadkCoreApplication.m411getInst().getContext().getString(n.i.alert_yes_button), bVar).b(TbadkCoreApplication.m411getInst().getContext().getString(n.i.alert_no_button), bVar2).b(tbPageContext);
        b.tv();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, a.b bVar, String str) {
        if (l.C(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.i.bar_code_result);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(l.C(context).getPageActivity()).cB(string).cC(str).a(TbadkCoreApplication.m411getInst().getContext().getString(n.i.alert_yes_button), bVar).b(l.C(context));
        if (context instanceof Activity) {
            b.tv();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, a.b bVar) {
        if (l.C(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.i.anti_title);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(n.i.msg_album_bug);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(l.C(context).getPageActivity()).cB(string).cC(string2).a(TbadkCoreApplication.m411getInst().getContext().getString(n.i.alert_yes_button), bVar).b(l.C(context));
        if (context instanceof Activity) {
            b.tv();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(n.i.setup);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(n.i.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cC(TbadkCoreApplication.m411getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.tu();
            return aVar;
        }
        aVar.tv();
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
        cVar.cD(TbadkCoreApplication.m411getInst().getString(n.i.operation));
        cVar.a(new String[]{TbadkCoreApplication.m411getInst().getString(n.i.delete_user_chat)}, bVar);
        cVar.d(l.C(context));
        if (context instanceof Activity) {
            cVar.tz();
            return cVar;
        }
        return cVar;
    }
}
