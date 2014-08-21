package com.baidu.tbadk.coreExtra.c;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.adp.lib.e.e;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class a {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.del_post_tip).setMessage(String.format(context.getString(x.url_notify), str)).setPositiveButton(x.alert_yes_button, onClickListener).setNegativeButton(x.alert_no_button, onClickListener2).create();
        if (context instanceof Activity) {
            e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.bar_code_result).setMessage(str).setPositiveButton(x.alert_yes_button, onClickListener).create();
        if (context instanceof Activity) {
            e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.anti_title).setMessage(x.msg_album_bug).setPositiveButton(x.alert_yes_button, onClickListener).create();
        if (context instanceof Activity) {
            e.a(create, (Activity) context);
        }
        return create;
    }

    public static com.baidu.tbadk.core.dialog.a a(Activity activity, int i, com.baidu.tbadk.core.dialog.d dVar, com.baidu.tbadk.core.dialog.d dVar2, boolean z) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.b(activity.getString(i));
        aVar.a(x.setup, dVar);
        aVar.b(x.alert_no_button, dVar2);
        aVar.a();
        if (z) {
            aVar.b();
        } else {
            aVar.c();
        }
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a a(Activity activity, int i, com.baidu.tbadk.core.dialog.d dVar, com.baidu.tbadk.core.dialog.d dVar2) {
        return a(activity, i, dVar, dVar2, false);
    }
}
