package com.baidu.tieba.im.f;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
/* loaded from: classes.dex */
public final class b {
    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(com.baidu.tieba.im.j.delete).setMessage(com.baidu.tieba.im.j.group_activity_delete_tip).setPositiveButton(com.baidu.tieba.im.j.confirm, onClickListener).setNegativeButton(com.baidu.tieba.im.j.cancel, new c()).create();
        create.show();
        return create;
    }
}
