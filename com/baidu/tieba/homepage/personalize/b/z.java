package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.homepage.personalize.b.y;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y.a cyz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y.a aVar) {
        this.cyz = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10984");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_NEW_USER_GUIDE));
    }
}
