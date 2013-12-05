package com.baidu.tieba.im.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b {
    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_one_message).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_more_message).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.members_order).setItems(R.array.members_order_by, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.del_post_tip).setMessage(String.format(context.getString(R.string.url_notify), str)).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.bar_code_result).setMessage(str).setPositiveButton(R.string.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.anti_title).setMessage(R.string.msg_album_bug).setPositiveButton(R.string.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }
}
