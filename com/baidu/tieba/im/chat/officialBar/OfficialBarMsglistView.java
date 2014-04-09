package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.dj;
/* loaded from: classes.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView l;
    private AlertDialog m;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.h
    public final void a(dj djVar, boolean z) {
        super.a(djVar, z);
        String string = djVar.getString(com.baidu.tieba.im.j.msglist_officialInfo);
        if (string != null) {
            this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.im.i.group_info_btn, djVar);
            this.l = (TextView) this.c.findViewById(com.baidu.tieba.im.h.group_info_btn_txt);
            this.l.setText(string);
        }
    }

    public final void h(int i) {
        MsglistActivity msglistActivity = this.e;
        if (this.m == null) {
            CharSequence[] charSequenceArr = {msglistActivity.getString(com.baidu.tieba.im.j.msg_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(msglistActivity);
            builder.setTitle(msglistActivity.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, msglistActivity);
            this.m = builder.create();
            this.m.setCanceledOnTouchOutside(true);
        }
        if (this.m != null) {
            this.m.getListView().setTag(Integer.valueOf(i));
            this.m.show();
        }
    }

    public final AlertDialog R() {
        return this.m;
    }
}
