package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.gift.myGiftList.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bxd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bxd = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        boolean z;
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        MyGiftListActivity myGiftListActivity3;
        hVar = this.bxd.bwZ;
        a.C0063a item = hVar.getItem(i);
        if (item != null && item.bwi > 0 && !StringUtils.isNull(item.bwj)) {
            z = this.bxd.mIsHost;
            if (z) {
                myGiftListActivity3 = this.bxd.bwC;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(myGiftListActivity3.getPageContext().getPageActivity(), item.bwi, item.bwj, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (com.baidu.adp.lib.util.i.iP()) {
                myGiftListActivity2 = this.bxd.bwC;
                myGiftListActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.bwi), item.bwj)));
            } else {
                myGiftListActivity = this.bxd.bwC;
                myGiftListActivity.showToast(n.i.neterror);
            }
        }
    }
}
