package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ap;
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
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.boy().boS()) {
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
        aVar.jgQ.setVisibility(8);
        aVar.jgS.setVisibility(0);
        aVar.jgS.setShowOval(true);
        aVar.jgS.setAutoChangeStyle(true);
        aVar.jgS.setStrokeWith(l.getDimens(this.mContext, R.dimen.tbds1));
        aVar.jgS.setStrokeColorResId(R.color.cp_border_a);
        aVar.jgS.setTag(null);
        aVar.jgS.setPlaceHolder(1);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            aVar.jgS.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.jgS.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
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
        aVar.jgT.setText(this.mContext.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void f(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.jgW.setVisibility(8);
        ap.setViewTextColor(aVar.jgT, R.color.cp_cont_b, 1);
        ap.setViewTextColor(aVar.jgU, R.color.cp_cont_d, 1);
        ap.setViewTextColor(aVar.jgV, R.color.cp_cont_d, 1);
    }
}
