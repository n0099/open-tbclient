package com.baidu.tieba.gift.myGiftList;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import tbclient.GetGiftMyList.GiftList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ m bof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bof = mVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z;
        j jVar;
        MyGiftListActivity myGiftListActivity;
        MyGiftListActivity myGiftListActivity2;
        a aVar;
        z = this.bof.mIsHost;
        if (!z) {
            jVar = this.bof.boa;
            GiftList item = jVar.getItem(i);
            if (item != null && item.sender != null && item.sender.id.longValue() > 0) {
                if (com.baidu.adp.lib.util.i.iN()) {
                    myGiftListActivity2 = this.bof.bnF;
                    myGiftListActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.sender.id), item.sender.name_show)));
                    return;
                }
                myGiftListActivity = this.bof.bnF;
                myGiftListActivity.showToast(i.h.neterror);
                return;
            }
            return;
        }
        aVar = this.bof.boe;
        aVar.hq((String) view.getTag(i.f.tag_second));
    }
}
