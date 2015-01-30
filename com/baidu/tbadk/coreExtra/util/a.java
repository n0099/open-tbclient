package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.lib.g.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class a {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        String format = String.format(TbadkCoreApplication.m255getInst().getContext().getString(z.url_notify), str);
        String string = TbadkCoreApplication.m255getInst().getContext().getString(z.del_post_tip);
        AlertDialog create = new AlertDialog.Builder(context).setTitle(string).setMessage(format).setPositiveButton(TbadkCoreApplication.m255getInst().getContext().getString(z.alert_yes_button), onClickListener).setNegativeButton(TbadkCoreApplication.m255getInst().getContext().getString(z.alert_no_button), onClickListener2).create();
        if (context instanceof Activity) {
            k.a(create, (Activity) context);
        }
        return create;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2, boolean z) {
        String string = TbadkCoreApplication.m255getInst().getContext().getString(z.setup);
        String string2 = TbadkCoreApplication.m255getInst().getContext().getString(z.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.bW(TbadkCoreApplication.m255getInst().getContext().getString(i));
        aVar.a(string, dVar);
        aVar.b(string2, dVar2);
        aVar.b(tbPageContext);
        if (z) {
            aVar.nW();
        } else {
            aVar.nX();
        }
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(TbPageContext<?> tbPageContext, int i, d dVar, d dVar2) {
        return a(tbPageContext, i, dVar, dVar2, false);
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(TbadkCoreApplication.m255getInst().getString(z.operation));
        builder.setItems(new String[]{TbadkCoreApplication.m255getInst().getString(z.delete_user_chat)}, onClickListener);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        if (context instanceof Activity) {
            k.a(create, (Activity) context);
        }
        return create;
    }
}
