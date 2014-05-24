package com.baidu.tbadk.coreExtra.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class a {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.del_post_tip).setMessage(String.format(context.getString(y.url_notify), str)).setPositiveButton(y.alert_yes_button, onClickListener).setNegativeButton(y.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.bar_code_result).setMessage(str).setPositiveButton(y.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.anti_title).setMessage(y.msg_album_bug).setPositiveButton(y.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }
}
