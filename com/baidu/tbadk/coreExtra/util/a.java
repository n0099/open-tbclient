package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, d dVar, d dVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.m411getInst().getContext().getString(t.url_notify), str);
        String string = TbadkCoreApplication.m411getInst().getContext().getString(t.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).cm(string).cn(format).a(TbadkCoreApplication.m411getInst().getContext().getString(t.alert_yes_button), dVar).b(TbadkCoreApplication.m411getInst().getContext().getString(t.alert_no_button), dVar2).b(tbPageContext);
        b.rL();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, d dVar, String str) {
        if (n.D(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(t.bar_code_result);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity()).cm(string).cn(str).a(TbadkCoreApplication.m411getInst().getContext().getString(t.alert_yes_button), dVar).b(n.D(context));
        if (context instanceof Activity) {
            b.rL();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, d dVar) {
        if (n.D(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(t.anti_title);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(t.msg_album_bug);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity()).cm(string).cn(string2).a(TbadkCoreApplication.m411getInst().getContext().getString(t.alert_yes_button), dVar).b(n.D(context));
        if (context instanceof Activity) {
            b.rL();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(t.setup);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(t.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.cn(TbadkCoreApplication.m411getInst().getContext().getString(i));
        aVar.a(string, dVar);
        aVar.b(string2, dVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.rK();
            return aVar;
        }
        aVar.rL();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2) {
        return a(tbPageContext, i, dVar, dVar2, false);
    }

    public static e a(Context context, h hVar) {
        if (n.D(context) == null) {
            return null;
        }
        e eVar = new e(n.D(context).getPageActivity());
        eVar.co(TbadkCoreApplication.m411getInst().getString(t.operation));
        eVar.a(new String[]{TbadkCoreApplication.m411getInst().getString(t.delete_user_chat)}, hVar);
        eVar.d(n.D(context));
        if (context instanceof Activity) {
            eVar.rN();
            return eVar;
        }
        return eVar;
    }
}
