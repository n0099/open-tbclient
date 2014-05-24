package com.baidu.tieba.im.chat.officialBar;

import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
/* loaded from: classes.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView k;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_officialInfo);
        if (string != null) {
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.k = (TextView) this.b.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.k.setText(string);
        }
    }
}
