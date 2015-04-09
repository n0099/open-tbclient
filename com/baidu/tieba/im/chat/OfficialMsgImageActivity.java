package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public class OfficialMsgImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, com.baidu.tieba.im.c.ad adVar) {
        com.baidu.tieba.im.c.a.Tx().d(str, adVar);
    }
}
