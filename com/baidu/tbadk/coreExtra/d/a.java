package com.baidu.tbadk.coreExtra.d;

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
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(d.k.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(d.k.confirm_title);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).db(string).dc(format).a(TbadkCoreApplication.getInst().getContext().getString(d.k.alert_yes_button), bVar).b(TbadkCoreApplication.getInst().getContext().getString(d.k.cancel), bVar2).b(tbPageContext);
        b.tD();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.getInst().getContext().getString(d.k.setup);
        String string2 = TbadkCoreApplication.getInst().getContext().getString(d.k.cancel);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.dc(TbadkCoreApplication.getInst().getContext().getString(i));
        aVar.a(string, bVar);
        aVar.b(string2, bVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.tB();
            return aVar;
        }
        aVar.tD();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, a.b bVar, a.b bVar2) {
        return a(tbPageContext, i, bVar, bVar2, false);
    }

    public static b a(Context context, b.InterfaceC0086b interfaceC0086b) {
        if (i.ab(context) == null) {
            return null;
        }
        b bVar = new b(i.ab(context).getPageActivity());
        bVar.dd(TbadkCoreApplication.getInst().getString(d.k.operation));
        bVar.a(new String[]{TbadkCoreApplication.getInst().getString(d.k.delete_user_chat)}, interfaceC0086b);
        bVar.d(i.ab(context));
        if (context instanceof Activity) {
            bVar.tG();
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
        aVar.db(str);
        aVar.dc(str2);
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
        aVar.db(str);
        aVar.dc(str2);
        aVar.a(d.k.dialog_ok, bVar);
        aVar.b(d.k.dialog_cancel, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }

    public static b a(TbPageContext<?> tbPageContext, int i, CharSequence[] charSequenceArr, b.InterfaceC0086b interfaceC0086b) {
        if (tbPageContext == null) {
            return null;
        }
        b bVar = new b(tbPageContext.getPageActivity());
        bVar.cd(i);
        bVar.a(charSequenceArr, interfaceC0086b);
        bVar.d(tbPageContext);
        return bVar;
    }
}
