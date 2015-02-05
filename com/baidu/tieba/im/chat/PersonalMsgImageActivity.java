package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
import com.baidu.tieba.im.c.ad;
/* loaded from: classes.dex */
public class PersonalMsgImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, ad adVar) {
        com.baidu.tieba.im.c.a.Tj().c(str, adVar);
    }

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonalMsgImageActivityConfig.class, PersonalMsgImageActivity.class);
    }
}
