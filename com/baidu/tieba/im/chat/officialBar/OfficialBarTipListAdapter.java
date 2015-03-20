package com.baidu.tieba.im.chat.officialBar;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ba;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.notify.b {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!com.baidu.tbadk.coreExtra.messageCenter.c.vq().vy()) {
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
        cVar.Ml.setTag(null);
        cVar.Ml.setDrawBorder(true);
        cVar.Ml.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        cVar.Ml.setDefaultResource(com.baidu.tieba.u.icon_default_ba_120);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            cVar.Ml.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.Ml.c(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
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
        cVar.Mm.setText(this.mContext.getString(com.baidu.tieba.y.official_msg_list_name, imMessageCenterShowItemData.getFriendName()));
        if (imMessageCenterShowItemData.getUserType() == 1) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ba.getDrawable(com.baidu.tieba.u.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            cVar.Mm.setCompoundDrawables(null, null, bitmapDrawable, null);
            cVar.Mm.setCompoundDrawablePadding(com.baidu.adp.lib.util.n.dip2px(this.mContext, this.mContext.getResources().getDimension(com.baidu.tieba.t.ds8)));
            return;
        }
        cVar.Mm.setCompoundDrawables(null, null, null, null);
    }
}
