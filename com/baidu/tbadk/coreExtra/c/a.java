package com.baidu.tbadk.coreExtra.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, a.b bVar, a.b bVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.getInst().getContext().getString(R.string.url_notify), str);
        String string = TbadkCoreApplication.getInst().getContext().getString(R.string.confirm_title);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).sB(string).sC(format).a(TbadkCoreApplication.getInst().getContext().getString(R.string.alert_yes_button), bVar).b(TbadkCoreApplication.getInst().getContext().getString(R.string.cancel), bVar2).b(tbPageContext);
        b.aCp();
        return b;
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
        aVar.sB(str);
        aVar.sC(str2);
        aVar.a(str3, bVar);
        aVar.b(str4, bVar2);
        aVar.b(tbPageContext);
        return aVar;
    }
}
