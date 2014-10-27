package com.baidu.tbadk.coreExtra.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.lib.g.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.d;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        String format = String.format(TbadkApplication.m251getInst().getString(y.url_notify), str);
        String string = TbadkApplication.m251getInst().getString(y.del_post_tip);
        AlertDialog create = new AlertDialog.Builder(context).setTitle(string).setMessage(format).setPositiveButton(TbadkApplication.m251getInst().getString(y.alert_yes_button), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.alert_no_button), onClickListener2).create();
        if (context instanceof Activity) {
            j.a(create, (Activity) context);
        }
        return create;
    }

    public static com.baidu.tbadk.core.dialog.a a(Activity activity, int i, d dVar, d dVar2, boolean z) {
        String string = TbadkApplication.m251getInst().getString(y.setup);
        String string2 = TbadkApplication.m251getInst().getString(y.alert_no_button);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.bg(TbadkApplication.m251getInst().getString(i));
        aVar.a(string, dVar);
        aVar.b(string2, dVar2);
        aVar.kT();
        if (z) {
            aVar.kV();
        } else {
            aVar.kW();
        }
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(Activity activity, int i, d dVar, d dVar2) {
        return a(activity, i, dVar, dVar2, false);
    }
}
