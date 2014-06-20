package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements AdapterView.OnItemClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ax axVar;
        axVar = this.a.b;
        Object item = axVar.b().getItem(i);
        if (item != null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) item;
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, new StringBuilder(String.valueOf(parseLong)).toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2003006, new com.baidu.tbadk.core.atomData.aq(this.a, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
