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
    final /* synthetic */ OfficialBarTipActivity aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(OfficialBarTipActivity officialBarTipActivity) {
        this.aTB = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ao aoVar;
        aoVar = this.aTB.aTA;
        ImMessageCenterShowItemData fu = aoVar.KK().getItem(i);
        if (fu != null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = fu;
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, new StringBuilder(String.valueOf(parseLong)).toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.aTB.getPageContext().getContext(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getUserType())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
