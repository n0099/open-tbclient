package com.baidu.tieba.homepage.listview;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.homepage.fragment.data.UserModuleData;
/* loaded from: classes.dex */
class d implements c.b {
    final /* synthetic */ c byO;
    private final /* synthetic */ long byP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, long j) {
        this.byO = cVar;
        this.byP = j;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        cVar.dismiss();
        switch (i) {
            case 0:
                String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("home_page_user_module_config", null);
                if (string != null) {
                    UserModuleData userModuleData = (UserModuleData) i.objectWithJsonStr(string, UserModuleData.class);
                    userModuleData.moveModuleItemDataToPosition(this.byP, 0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_PAGE_SEND_USER_MODULE, userModuleData));
                    com.baidu.tbadk.core.sharedPref.b.tZ().putString("home_page_user_module_config", i.jsonStrWithObject(userModuleData));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
