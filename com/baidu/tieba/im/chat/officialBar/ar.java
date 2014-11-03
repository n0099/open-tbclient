package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements AdapterView.OnItemClickListener {
    final /* synthetic */ OfficialBarTipActivity aSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(OfficialBarTipActivity officialBarTipActivity) {
        this.aSi = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        au auVar;
        auVar = this.aSi.aSh;
        ImMessageCenterShowItemData fr = auVar.KC().getItem(i);
        if (fr != null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = fr;
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, new StringBuilder(String.valueOf(parseLong)).toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aSi, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
