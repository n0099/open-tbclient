package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, d dVar, d dVar2, String str) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return null;
        }
        String format = String.format(TbadkCoreApplication.m411getInst().getContext().getString(y.url_notify), str);
        String string = TbadkCoreApplication.m411getInst().getContext().getString(y.del_post_tip);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity()).bZ(string).ca(format).a(TbadkCoreApplication.m411getInst().getContext().getString(y.alert_yes_button), dVar).b(TbadkCoreApplication.m411getInst().getContext().getString(y.alert_no_button), dVar2).b(tbPageContext);
        b.re();
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, d dVar, String str) {
        if (m.D(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(y.bar_code_result);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(m.D(context).getPageActivity()).bZ(string).ca(str).a(TbadkCoreApplication.m411getInst().getContext().getString(y.alert_yes_button), dVar).b(m.D(context));
        if (context instanceof Activity) {
            b.re();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, d dVar) {
        if (m.D(context) == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(y.anti_title);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(y.msg_album_bug);
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(m.D(context).getPageActivity()).bZ(string).ca(string2).a(TbadkCoreApplication.m411getInst().getContext().getString(y.alert_yes_button), dVar).b(m.D(context));
        if (context instanceof Activity) {
            b.re();
            return b;
        }
        return b;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2, boolean z) {
        if (tbPageContext == null) {
            return null;
        }
        String string = TbadkCoreApplication.m411getInst().getContext().getString(y.setup);
        String string2 = TbadkCoreApplication.m411getInst().getContext().getString(y.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.ca(TbadkCoreApplication.m411getInst().getContext().getString(i));
        aVar.a(string, dVar);
        aVar.b(string2, dVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.rd();
            return aVar;
        }
        aVar.re();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2) {
        return a(tbPageContext, i, dVar, dVar2, false);
    }

    public static e a(Context context, h hVar) {
        if (m.D(context) == null) {
            return null;
        }
        e eVar = new e(m.D(context).getPageActivity());
        eVar.cb(TbadkCoreApplication.m411getInst().getString(y.operation));
        eVar.a(new String[]{TbadkCoreApplication.m411getInst().getString(y.delete_user_chat)}, hVar);
        eVar.d(m.D(context));
        if (context instanceof Activity) {
            eVar.rg();
            return eVar;
        }
        return eVar;
    }
}
