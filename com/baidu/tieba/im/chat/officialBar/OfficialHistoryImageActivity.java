package com.baidu.tieba.im.chat.officialBar;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tieba.im.chat.AbsMsgImageActivity;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public class OfficialHistoryImageActivity extends AbsMsgImageActivity {
    @Override // com.baidu.tieba.im.chat.AbsMsgImageActivity
    protected void a(String str, com.baidu.tieba.im.c.ad adVar) {
        adVar.a(new LinkedHashMap<>());
    }

    static {
        TbadkApplication.getInst().RegisterIntent(OfficialHistoryImageActivityConfig.class, OfficialHistoryImageActivity.class);
    }
}
