package com.baidu.tieba.im.chat.officialBar;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes13.dex */
public class OfficialBarTipListAdapter extends com.baidu.tieba.im.chat.a.c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        int i2 = 0;
        if (!com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcp()) {
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
        aVar.iLM.setTag(null);
        aVar.iLM.setDrawBorder(true);
        aVar.iLM.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        aVar.iLM.setPlaceHolder(1);
        if (!TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            aVar.iLM.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.iLM.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // com.baidu.tieba.im.chat.a.c
    protected void a(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.iLN.setText(this.mContext.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
        if (imMessageCenterShowItemData.getUserType() == 1) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) an.getDrawable(R.drawable.icon_v);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            aVar.iLN.setCompoundDrawables(null, null, bitmapDrawable, null);
            aVar.iLN.setCompoundDrawablePadding(l.dip2px(this.mContext, this.mContext.getResources().getDimension(R.dimen.ds8)));
            return;
        }
        aVar.iLN.setCompoundDrawables(null, null, null, null);
    }
}
