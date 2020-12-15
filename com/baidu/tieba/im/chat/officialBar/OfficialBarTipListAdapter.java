package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes26.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.a.c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bzl().bzF()) {
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
        aVar.klm.setVisibility(8);
        aVar.klo.setVisibility(0);
        aVar.klo.setShowOval(true);
        aVar.klo.setAutoChangeStyle(true);
        aVar.klo.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
        aVar.klo.setStrokeColorResId(R.color.CAM_X0401);
        aVar.klo.setTag(null);
        aVar.klo.setPlaceHolder(1);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            aVar.klo.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.klo.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
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
        aVar.klp.setText(this.mContext.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void f(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.kls.setVisibility(8);
        ap.setViewTextColor(aVar.klp, R.color.CAM_X0105, 1);
        ap.setViewTextColor(aVar.klq, R.color.CAM_X0109, 1);
        ap.setViewTextColor(aVar.klr, R.color.CAM_X0109, 1);
    }
}
