package com.baidu.tbadk.coreExtra.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.del_post_tip).setMessage(String.format(context.getString(u.url_notify), str)).setPositiveButton(u.alert_yes_button, onClickListener).setNegativeButton(u.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.bar_code_result).setMessage(str).setPositiveButton(u.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.anti_title).setMessage(u.msg_album_bug).setPositiveButton(u.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }
}
