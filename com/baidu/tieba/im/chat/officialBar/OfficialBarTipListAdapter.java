package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.notify.b {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity);
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!TbadkApplication.m251getInst().isMsgChatOn()) {
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

    @Override // com.baidu.tieba.im.chat.notify.b
    protected void f(com.baidu.tieba.im.chat.notify.c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.aHp.setTag(null);
        cVar.aHp.setDrawBorder(true);
        cVar.aHp.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        cVar.aHp.setDefaultResource(com.baidu.tieba.u.icon_default_ba_120);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            cVar.aHp.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.aHp.c(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected void a(com.baidu.tieba.im.chat.notify.c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.aHq.setText(this.mContext.getString(com.baidu.tieba.y.official_msg_list_name, imMessageCenterShowItemData.getFriendName()));
    }
}
