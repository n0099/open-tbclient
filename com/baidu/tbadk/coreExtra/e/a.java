package com.baidu.tbadk.coreExtra.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.m11getInst().getContext().getString(t.j.url_notify), str);
        String string = TbadkCoreApplication.m11getInst().getContext().getString(t.j.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cz(string).cA(format).a(TbadkCoreApplication.m11getInst().getContext().getString(t.j.alert_yes_button), bVar).b(TbadkCoreApplication.m11getInst().getContext().getString(t.j.alert_no_button), bVar2).b(tbPageContext);
        b.rV();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m11getInst().getContext().getString(t.j.setup);
        String string2 = TbadkCoreApplication.m11getInst().getContext().getString(t.j.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cA(TbadkCoreApplication.m11getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.rU();
            return aVar;
        }
        aVar.rV();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2) {
        return a(tbPageContext, i, bVar, bVar2, false);
    }

    public static c a(Context context, c.b bVar) {
        if (l.s(context) == null) {
            return null;
        }
        c cVar = new c(l.s(context).getPageActivity());
        cVar.cB(TbadkCoreApplication.m11getInst().getString(t.j.operation));
        cVar.a(new String[]{TbadkCoreApplication.m11getInst().getString(t.j.delete_user_chat)}, bVar);
        cVar.d(l.s(context));
        if (context instanceof Activity) {
            cVar.rY();
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, a.b bVar, a.b bVar2) {
        String str = null;
        if (i >= 0) {
            str = TbadkCoreApplication.m11getInst().getContext().getString(i);
        }
        return a(tbPageContext, str, TbadkCoreApplication.m11getInst().getContext().getString(i2), TbadkCoreApplication.m11getInst().getContext().getString(i3), TbadkCoreApplication.m11getInst().getContext().getString(i4), bVar, bVar2);
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.b bVar, a.b bVar2) {
        if (tbPageContext == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cz(str);
        aVar.cA(str2);
        aVar.a(str3, bVar);
        aVar.b(str4, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, String str, String str2, a.b bVar, a.b bVar2) {
        if (tbPageContext == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cz(str);
        aVar.cA(str2);
        aVar.a(t.j.dialog_ok, bVar);
        aVar.b(t.j.dialog_cancel, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static c a(TbPageContext<?> tbPageContext, int i, CharSequence[] charSequenceArr, c.b bVar) {
        if (tbPageContext == null) {
            return null;
        }
        c cVar = new c(tbPageContext.getPageActivity());
        cVar.bO(i);
        cVar.a(charSequenceArr, bVar);
        cVar.d(tbPageContext);
        return cVar;
    }
}
