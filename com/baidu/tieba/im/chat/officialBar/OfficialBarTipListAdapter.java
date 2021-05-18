package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.s.d.d;
import d.a.k0.e1.f.i.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
public class OfficialBarTipListAdapter extends c {
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
    }

    @Override // d.a.k0.e1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return false;
    }

    @Override // d.a.k0.e1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        return true;
    }

    @Override // d.a.k0.e1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f54189b.setVisibility(8);
        aVar.f54191d.setVisibility(0);
        aVar.f54191d.setShowOval(true);
        aVar.f54191d.setAutoChangeStyle(true);
        aVar.f54191d.setStrokeWith(l.g(this.f54185e, R.dimen.tbds1));
        aVar.f54191d.setStrokeColorResId(R.color.CAM_X0401);
        aVar.f54191d.setTag(null);
        aVar.f54191d.setPlaceHolder(1);
        if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
            return;
        }
        aVar.f54191d.setTag(imMessageCenterShowItemData.getFriendPortrait());
        aVar.f54191d.V(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
    }

    @Override // d.a.k0.e1.f.i.c
    public void i(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f54192e.setText(this.f54185e.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
    }

    @Override // d.a.k0.e1.f.i.c
    public void m(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        aVar.f54195h.setVisibility(8);
        SkinManager.setViewTextColor(aVar.f54192e, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(aVar.f54193f, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(aVar.f54194g, R.color.CAM_X0109, 1);
    }

    @Override // d.a.k0.e1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        String str2 = "";
        int i3 = 0;
        if (!d.d().l()) {
            str = "";
            i2 = 0;
        }
        if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
            i3 = i2;
            str2 = str;
        }
        return new BasicNameValuePair(String.valueOf(i3), str2);
    }
}
