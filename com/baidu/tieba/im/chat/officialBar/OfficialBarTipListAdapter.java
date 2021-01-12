package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.a.c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bxM().byg()) {
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
        aVar.ktn.setVisibility(8);
        aVar.ktp.setVisibility(0);
        aVar.ktp.setShowOval(true);
        aVar.ktp.setAutoChangeStyle(true);
        aVar.ktp.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
        aVar.ktp.setStrokeColorResId(R.color.CAM_X0401);
        aVar.ktp.setTag(null);
        aVar.ktp.setPlaceHolder(1);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            aVar.ktp.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.ktp.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
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
        aVar.ktq.setText(this.mContext.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void f(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.ktt.setVisibility(8);
        ao.setViewTextColor(aVar.ktq, R.color.CAM_X0105, 1);
        ao.setViewTextColor(aVar.ktr, R.color.CAM_X0109, 1);
        ao.setViewTextColor(aVar.kts, R.color.CAM_X0109, 1);
    }
}
