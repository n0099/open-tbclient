package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class GroupChatView extends a {
    public GroupChatView(MsglistActivity msglistActivity, boolean z, int i) {
        super(msglistActivity, z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public void a(cp cpVar, boolean z) {
        super.a(cpVar, z);
        String str = null;
        if (this.h == 0) {
            str = cpVar.getString(R.string.msglist_groupinfo);
        } else if (this.h == 1) {
            str = cpVar.getString(R.string.msglist_personInfo);
        }
        if (str != null) {
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, str, cpVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.a
    public void a(cp cpVar) {
        super.a(cpVar);
        if (this.h == 0) {
            this.d.setFrom(3);
        } else {
            this.d.setFrom(2);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void b(cp cpVar) {
        if (this.e == null) {
            CharSequence[] charSequenceArr = {cpVar.getString(R.string.operate_copy), cpVar.getString(R.string.msg_at), cpVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {cpVar.getString(R.string.operate_copy), cpVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
            builder.setTitle(cpVar.getString(R.string.operation));
            if (this.h == 0) {
                builder.setItems(charSequenceArr, cpVar);
            } else {
                builder.setItems(charSequenceArr2, cpVar);
            }
            this.e = builder.create();
            this.e.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void c(cp cpVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {cpVar.getString(R.string.msg_at), cpVar.getString(R.string.msg_img_save), cpVar.getString(R.string.msg_delete)};
            CharSequence[] charSequenceArr2 = {cpVar.getString(R.string.msg_img_save), cpVar.getString(R.string.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
            builder.setTitle(cpVar.getString(R.string.operation));
            if (this.h == 0) {
                builder.setItems(charSequenceArr, cpVar);
            } else {
                builder.setItems(charSequenceArr2, cpVar);
            }
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.a
    protected void d(cp cpVar) {
        if (this.g != null) {
            this.g = null;
        }
        boolean aj = TiebaApplication.h().aj();
        CharSequence[] charSequenceArr = new CharSequence[3];
        charSequenceArr[0] = aj ? cpVar.getString(R.string.group_close_receiver) : cpVar.getString(R.string.group_open_receiver);
        charSequenceArr[1] = cpVar.getString(R.string.msg_at);
        charSequenceArr[2] = cpVar.getString(R.string.msg_delete);
        CharSequence[] charSequenceArr2 = new CharSequence[2];
        charSequenceArr2[0] = aj ? cpVar.getString(R.string.group_close_receiver) : cpVar.getString(R.string.group_open_receiver);
        charSequenceArr2[1] = cpVar.getString(R.string.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(cpVar);
        builder.setTitle(cpVar.getString(R.string.operation));
        if (this.h == 0) {
            builder.setItems(charSequenceArr, cpVar);
        } else {
            builder.setItems(charSequenceArr2, cpVar);
        }
        this.g = builder.create();
        this.g.setCanceledOnTouchOutside(true);
    }
}
