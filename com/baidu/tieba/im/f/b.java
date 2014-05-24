package com.baidu.tieba.im.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b {
    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(y.del_post_tip).setMessage(y.members_dialog_remove_one_message).setPositiveButton(y.alert_yes_button, onClickListener).setNegativeButton(y.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(y.del_post_tip).setMessage(y.members_dialog_remove_more_message).setPositiveButton(y.alert_yes_button, onClickListener).setNegativeButton(y.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(y.members_order).setItems(com.baidu.tieba.q.members_order_by, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.del_post_tip).setMessage(y.rand_chat_waiting_quit_message).setPositiveButton(y.rand_chat_waiting_quit_yes, onClickListener).setNegativeButton(y.rand_chat_waiting_quit_no, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        if (z) {
            i = y.group_activity_edit_quit;
        } else {
            i = y.group_activity_create_quit;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.quit).setMessage(i).setPositiveButton(y.confirm, onClickListener).setNegativeButton(y.cancel, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.delete).setMessage(y.group_activity_delete_tip).setPositiveButton(y.confirm, onClickListener).setNegativeButton(y.cancel, new c()).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setMessage(y.rand_chat_waiting_change_dialog).setPositiveButton(y.alert_yes_btn, onClickListener).setNeutralButton(y.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(y.operation);
        builder.setItems(new String[]{context.getString(y.delete_user_chat)}, onClickListener);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        return create;
    }

    public static AlertDialog c(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(y.del_post_tip).setMessage(y.live_chat_room_mute_msg).setPositiveButton(y.confirm, onClickListener).setNegativeButton(y.cancel, new d()).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setItems(charSequenceArr, onClickListener).create();
        create.show();
        return create;
    }
}
