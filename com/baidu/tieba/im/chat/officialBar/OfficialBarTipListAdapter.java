package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.s.d.d;
import d.b.j0.e1.f.i.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class OfficialBarTipListAdapter extends c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // d.b.j0.e1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return false;
    }

    @Override // d.b.j0.e1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.b.j0.e1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f55632b.setVisibility(8);
        aVar.f55634d.setVisibility(0);
        aVar.f55634d.setShowOval(true);
        aVar.f55634d.setAutoChangeStyle(true);
        aVar.f55634d.setStrokeWith(l.g(this.f55628e, R.dimen.tbds1));
        aVar.f55634d.setStrokeColorResId(R.color.CAM_X0401);
        aVar.f55634d.setTag(null);
        aVar.f55634d.setPlaceHolder(1);
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            return;
        }
        aVar.f55634d.setTag(imMessageCenterShowItemData.getFriendPortrait());
        aVar.f55634d.W(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
    }

    @Override // d.b.j0.e1.f.i.c
    public void i(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f55635e.setText(this.f55628e.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // d.b.j0.e1.f.i.c
    public void m(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f55638h.setVisibility(8);
        SkinManager.setViewTextColor(aVar.f55635e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(aVar.f55636f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(aVar.f55637g, R.color.CAM_X0109, 1);
    }

    @Override // d.b.j0.e1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        String str2 = "";
        int i2 = 0;
        if (!d.d().l()) {
            str = "";
            i = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i2 = i;
            str2 = str;
        }
        return new BasicNameValuePair(String.valueOf(i2), str2);
    }
}
