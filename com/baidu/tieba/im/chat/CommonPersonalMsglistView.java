package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class CommonPersonalMsglistView extends h {
    public CommonPersonalMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public final void a(dj djVar) {
        super.a(djVar);
        this.d.setFrom(2);
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void b(dj djVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {djVar.getString(com.baidu.tieba.im.j.operate_copy), djVar.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(djVar);
            builder.setTitle(djVar.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, djVar);
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void c(dj djVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {djVar.getString(com.baidu.tieba.im.j.msg_img_save), djVar.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(djVar);
            builder.setTitle(djVar.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, djVar);
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void d(dj djVar) {
        if (this.h != null) {
            this.h = null;
        }
        CharSequence[] charSequenceArr = new CharSequence[2];
        charSequenceArr[0] = TbadkApplication.j().V() ? djVar.getString(com.baidu.tieba.im.j.group_close_receiver) : djVar.getString(com.baidu.tieba.im.j.group_open_receiver);
        charSequenceArr[1] = djVar.getString(com.baidu.tieba.im.j.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(djVar);
        builder.setTitle(djVar.getString(com.baidu.tieba.im.j.operation));
        builder.setItems(charSequenceArr, djVar);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void e(dj djVar) {
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void e() {
        this.k = false;
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void f(dj djVar) {
        if (this.j == null) {
            CharSequence[] charSequenceArr = {djVar.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(djVar);
            builder.setTitle(djVar.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, djVar);
            this.j = builder.create();
            this.j.setCancelable(true);
        }
    }
}
