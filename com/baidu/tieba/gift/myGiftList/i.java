package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bwE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bwE = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        if (com.baidu.adp.lib.util.i.iP()) {
            myGiftListActivity2 = this.bwE.bwC;
            myGiftListActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(n.f.tag_first)), (String) view.getTag(n.f.tag_second))));
            return;
        }
        myGiftListActivity = this.bwE.bwC;
        myGiftListActivity.showToast(n.i.neterror);
    }
}
