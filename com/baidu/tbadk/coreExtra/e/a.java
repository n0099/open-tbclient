package com.baidu.tbadk.coreExtra.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.m9getInst().getContext().getString(r.j.url_notify), str);
        String string = TbadkCoreApplication.m9getInst().getContext().getString(r.j.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cE(string).cF(format).a(TbadkCoreApplication.m9getInst().getContext().getString(r.j.alert_yes_button), bVar).b(TbadkCoreApplication.m9getInst().getContext().getString(r.j.alert_no_button), bVar2).b(tbPageContext);
        b.tq();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m9getInst().getContext().getString(r.j.setup);
        String string2 = TbadkCoreApplication.m9getInst().getContext().getString(r.j.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cF(TbadkCoreApplication.m9getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.to();
            return aVar;
        }
        aVar.tq();
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
        cVar.cG(TbadkCoreApplication.m9getInst().getString(r.j.operation));
        cVar.a(new String[]{TbadkCoreApplication.m9getInst().getString(r.j.delete_user_chat)}, bVar);
        cVar.d(l.C(context));
        if (context instanceof Activity) {
            cVar.tt();
            return cVar;
        }
        return cVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, a.b bVar, a.b bVar2) {
        String str = null;
        if (i >= 0) {
            str = TbadkCoreApplication.m9getInst().getContext().getString(i);
        }
        return a(tbPageContext, str, TbadkCoreApplication.m9getInst().getContext().getString(i2), TbadkCoreApplication.m9getInst().getContext().getString(i3), TbadkCoreApplication.m9getInst().getContext().getString(i4), bVar, bVar2);
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.b bVar, a.b bVar2) {
        if (tbPageContext == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cE(str);
        aVar.cF(str2);
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
        aVar.cE(str);
        aVar.cF(str2);
        aVar.a(r.j.dialog_ok, bVar);
        aVar.b(r.j.dialog_cancel, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static c a(TbPageContext<?> tbPageContext, int i, CharSequence[] charSequenceArr, c.b bVar) {
        if (tbPageContext == null) {
            return null;
        }
        c cVar = new c(tbPageContext.getPageActivity());
        cVar.cd(i);
        cVar.a(charSequenceArr, bVar);
        cVar.d(tbPageContext);
        return cVar;
    }
}
