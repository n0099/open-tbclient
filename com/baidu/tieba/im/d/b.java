package com.baidu.tieba.im.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tieba.p;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class b {
    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(x.del_post_tip).setMessage(x.members_dialog_remove_one_message).setPositiveButton(x.alert_yes_button, onClickListener).setNegativeButton(x.alert_no_button, onClickListener2).create();
        com.baidu.adp.lib.e.e.a(create, activity);
        return create;
    }

    public static AlertDialog b(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(x.del_post_tip).setMessage(x.members_dialog_remove_more_message).setPositiveButton(x.alert_yes_button, onClickListener).setNegativeButton(x.alert_no_button, onClickListener2).create();
        com.baidu.adp.lib.e.e.a(create, activity);
        return create;
    }

    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(x.members_order).setItems(p.members_order_by, onClickListener).create();
        com.baidu.adp.lib.e.e.a(create, activity);
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.del_post_tip).setMessage(x.rand_chat_waiting_quit_message).setPositiveButton(x.rand_chat_waiting_quit_yes, onClickListener).setNegativeButton(x.rand_chat_waiting_quit_no, onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog a(Context context, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        if (z) {
            i = x.group_activity_edit_quit;
        } else {
            i = x.group_activity_create_quit;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.quit).setMessage(i).setPositiveButton(x.confirm, onClickListener).setNegativeButton(x.cancel, onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.delete).setMessage(x.group_activity_delete_tip).setPositiveButton(x.confirm, onClickListener).setNegativeButton(x.cancel, new c()).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setMessage(x.rand_chat_waiting_change_dialog).setPositiveButton(x.alert_yes_btn, onClickListener).setNeutralButton(x.alert_no_button, onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(x.operation);
        builder.setItems(new String[]{context.getString(x.delete_user_chat)}, onClickListener);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog c(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(x.del_post_tip).setMessage(x.live_chat_room_mute_msg).setPositiveButton(x.confirm, onClickListener).setNegativeButton(x.cancel, new d()).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog a(Context context, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setItems(charSequenceArr, onClickListener).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.e.a(create, (Activity) context);
        }
        return create;
    }
}
