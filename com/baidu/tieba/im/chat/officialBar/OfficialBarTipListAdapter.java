package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes20.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.a.c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bfO().bgi()) {
            str = "";
            i = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i2 = i;
        } else {
            str = "";
        }
        return new BasicNameValuePair(String.valueOf(i2), str);
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.iRR.setVisibility(8);
        aVar.iRT.setVisibility(0);
        aVar.iRT.setShowOval(true);
        aVar.iRT.setAutoChangeStyle(true);
        aVar.iRT.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
        aVar.iRT.setStrokeColorResId(R.color.cp_border_a);
        aVar.iRT.setTag(null);
        aVar.iRT.setPlaceHolder(1);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            aVar.iRT.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.iRT.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return false;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void a(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.iRU.setText(this.mContext.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void f(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.iRX.setVisibility(8);
        ao.setViewTextColor(aVar.iRU, R.color.cp_cont_b, 1);
        ao.setViewTextColor(aVar.iRV, R.color.cp_cont_d, 1);
        ao.setViewTextColor(aVar.iRW, R.color.cp_cont_d, 1);
    }
}
