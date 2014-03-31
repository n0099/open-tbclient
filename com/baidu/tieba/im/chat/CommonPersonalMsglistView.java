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
    public final void a(dn dnVar) {
        super.a(dnVar);
        this.d.setFrom(2);
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void b(dn dnVar) {
        if (this.f == null) {
            CharSequence[] charSequenceArr = {dnVar.getString(com.baidu.tieba.im.j.operate_copy), dnVar.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(dnVar);
            builder.setTitle(dnVar.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, dnVar);
            this.f = builder.create();
            this.f.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void c(dn dnVar) {
        if (this.g == null) {
            CharSequence[] charSequenceArr = {dnVar.getString(com.baidu.tieba.im.j.msg_img_save), dnVar.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(dnVar);
            builder.setTitle(dnVar.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, dnVar);
            this.g = builder.create();
            this.g.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void d(dn dnVar) {
        if (this.h != null) {
            this.h = null;
        }
        CharSequence[] charSequenceArr = new CharSequence[2];
        charSequenceArr[0] = TbadkApplication.j().V() ? dnVar.getString(com.baidu.tieba.im.j.group_close_receiver) : dnVar.getString(com.baidu.tieba.im.j.group_open_receiver);
        charSequenceArr[1] = dnVar.getString(com.baidu.tieba.im.j.msg_delete);
        AlertDialog.Builder builder = new AlertDialog.Builder(dnVar);
        builder.setTitle(dnVar.getString(com.baidu.tieba.im.j.operation));
        builder.setItems(charSequenceArr, dnVar);
        this.h = builder.create();
        this.h.setCanceledOnTouchOutside(true);
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void e(dn dnVar) {
    }

    @Override // com.baidu.tieba.im.chat.h
    protected final void e() {
        this.j = false;
    }
}
