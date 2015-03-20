package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements AdapterView.OnItemClickListener {
    final /* synthetic */ OfficialBarTipActivity aZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(OfficialBarTipActivity officialBarTipActivity) {
        this.aZE = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ap apVar;
        apVar = this.aZE.aZB;
        ImMessageCenterShowItemData fA = apVar.Of().getItem(i);
        if (fA != null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = fA;
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, new StringBuilder(String.valueOf(parseLong)).toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aZE.getPageContext().getContext(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getUserType())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
