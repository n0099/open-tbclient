package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.dn;
/* loaded from: classes.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView k;
    private AlertDialog l;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public final void a(dn dnVar, boolean z) {
        super.a(dnVar, z);
        String string = dnVar.getString(com.baidu.tieba.im.j.msglist_officialInfo);
        if (string != null) {
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.group_info_btn, dnVar);
            this.k = (TextView) this.c.findViewById(com.baidu.tieba.im.h.group_info_btn_txt);
            this.k.setText(string);
        }
    }

    public final void g(int i) {
        MsglistActivity msglistActivity = this.e;
        if (this.l == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.l = builder.create();
            this.l.setCanceledOnTouchOutside(true);
        }
        if (this.l != null) {
            this.l.getListView().setTag(Integer.valueOf(i));
            this.l.show();
        }
    }

    public final AlertDialog R() {
        return this.l;
    }
}
