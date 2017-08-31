package com.baidu.tbadk.coreExtra.e;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(d.l.confirm_title);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cL(string).cM(format).a(TbadkCoreApplication.getInst().getContext().getString(d.l.alert_yes_button), bVar).b(TbadkCoreApplication.getInst().getContext().getString(d.l.cancel), bVar2).b(tbPageContext);
        b.to();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.getInst().getContext().getString(d.l.setup);
        String string2 = TbadkCoreApplication.getInst().getContext().getString(d.l.cancel);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cM(TbadkCoreApplication.getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.tm();
            return aVar;
        }
        aVar.to();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2) {
        return a(tbPageContext, i, bVar, bVar2, false);
    }

    public static b a(Context context, b.InterfaceC0047b interfaceC0047b) {
        if (i.X(context) == null) {
            return null;
        }
        b bVar = new b(i.X(context).getPageActivity());
        bVar.cN(TbadkCoreApplication.getInst().getString(d.l.operation));
        bVar.a(new String[]{TbadkCoreApplication.getInst().getString(d.l.delete_user_chat)}, interfaceC0047b);
        bVar.d(i.X(context));
        if (context instanceof Activity) {
            bVar.tr();
            return bVar;
        }
        return bVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, int i2, int i3, int i4, a.b bVar, a.b bVar2) {
        String str = null;
        if (i >= 0) {
            str = TbadkCoreApplication.getInst().getContext().getString(i);
        }
        return a(tbPageContext, str, TbadkCoreApplication.getInst().getContext().getString(i2), TbadkCoreApplication.getInst().getContext().getString(i3), TbadkCoreApplication.getInst().getContext().getString(i4), bVar, bVar2);
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, String str, String str2, String str3, String str4, a.b bVar, a.b bVar2) {
        if (tbPageContext == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cL(str);
        aVar.cM(str2);
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
        aVar.cL(str);
        aVar.cM(str2);
        aVar.a(d.l.dialog_ok, bVar);
        aVar.b(d.l.dialog_cancel, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static b a(TbPageContext<?> tbPageContext, int i, CharSequence[] charSequenceArr, b.InterfaceC0047b interfaceC0047b) {
        if (tbPageContext == null) {
            return null;
        }
        b bVar = new b(tbPageContext.getPageActivity());
        bVar.cf(i);
        bVar.a(charSequenceArr, interfaceC0047b);
        bVar.d(tbPageContext);
        return bVar;
    }
}
