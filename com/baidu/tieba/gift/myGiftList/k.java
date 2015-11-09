package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bnI = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        if (com.baidu.adp.lib.util.i.iN()) {
            myGiftListActivity2 = this.bnI.bnF;
            myGiftListActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(i.f.tag_first)), (String) view.getTag(i.f.tag_second))));
            return;
        }
        myGiftListActivity = this.bnI.bnF;
        myGiftListActivity.showToast(i.h.neterror);
    }
}
