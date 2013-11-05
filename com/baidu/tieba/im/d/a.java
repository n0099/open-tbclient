package com.baidu.tieba.im.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class a {
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
}
