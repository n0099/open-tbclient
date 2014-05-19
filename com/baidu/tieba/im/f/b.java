package com.baidu.tieba.im.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b {
    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(u.del_post_tip).setMessage(u.members_dialog_remove_one_message).setPositiveButton(u.alert_yes_button, onClickListener).setNegativeButton(u.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(u.del_post_tip).setMessage(u.members_dialog_remove_more_message).setPositiveButton(u.alert_yes_button, onClickListener).setNegativeButton(u.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(u.members_order).setItems(com.baidu.tieba.m.members_order_by, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.del_post_tip).setMessage(u.rand_chat_waiting_quit_message).setPositiveButton(u.rand_chat_waiting_quit_yes, onClickListener).setNegativeButton(u.rand_chat_waiting_quit_no, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        if (z) {
            i = u.group_activity_edit_quit;
        } else {
            i = u.group_activity_create_quit;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.quit).setMessage(i).setPositiveButton(u.confirm, onClickListener).setNegativeButton(u.cancel, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.delete).setMessage(u.group_activity_delete_tip).setPositiveButton(u.confirm, onClickListener).setNegativeButton(u.cancel, new c()).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setMessage(u.rand_chat_waiting_change_dialog).setPositiveButton(u.alert_yes_btn, onClickListener).setNeutralButton(u.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(u.operation);
        builder.setItems(new String[]{context.getString(u.delete_user_chat)}, onClickListener);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
        return create;
    }

    public static AlertDialog c(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(u.del_post_tip).setMessage(u.live_chat_room_mute_msg).setPositiveButton(u.confirm, onClickListener).setNegativeButton(u.cancel, new d()).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setItems(charSequenceArr, onClickListener).create();
        create.show();
        return create;
    }
}
