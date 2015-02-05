package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.v;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends b {
    private g aTG;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.aTG = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.aTG.cw(true);
            } else {
                this.aTG.cw(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fz = getItem(i);
        if (fz != null && String.valueOf(String.valueOf(2)).equals(fz.getOwnerName())) {
            if (fz.getUnReadCount() >= 30) {
                if (this.aTG != null) {
                    this.aTG.cv(true);
                }
            } else if (this.aTG != null) {
                this.aTG.cv(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(g gVar) {
        this.aTG = gVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected BasicNameValuePair a(ImMessageCenterShowItemData imMessageCenterShowItemData, int i, String str) {
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            str = "";
            i = 0;
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkCoreApplication.m255getInst().isStrangerChatOn()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.l.Tq().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkCoreApplication.m255getInst().isGroupMsgOn()) {
                str = "";
                i = 0;
            } else {
                GroupSettingItemData groupSettingItemData = (GroupSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (groupSettingItemData != null && !groupSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
            }
        } else if (String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                str = "";
                i = 0;
            } else {
                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
            }
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                str = "";
                i = 0;
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkCoreApplication.m255getInst().isMsgChatOn()) {
                str = "";
                i = 0;
            } else if (!com.baidu.tieba.im.settingcache.g.Tn().isAcceptNotify()) {
                str = "";
                i = 0;
            }
        }
        return new BasicNameValuePair(String.valueOf(i), str);
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected boolean b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData == null) {
            return false;
        }
        return String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName()) || String.valueOf(4).equals(imMessageCenterShowItemData.getOwnerName());
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    protected void f(c cVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        cVar.zG.setDrawerType(1);
        cVar.zG.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(false);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setTag(imMessageCenterShowItemData.getOwnerName());
            bc.c(cVar.zG, v.icon_new_test);
            cVar.zG.setUserName(String.valueOf(2));
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(false);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zG.setUserName(String.valueOf(3));
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            bc.c(cVar.zG, v.icon_new_trends);
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(false);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zG.setUserName(String.valueOf(6));
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            bc.c(cVar.zG, v.icon_new_live);
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(true);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zG.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.zG.d(String.valueOf(v.icon_default_avatar100), 24, false);
            } else {
                cVar.zG.d(friendPortrait, 10, false);
            }
            cVar.zG.setClickable(false);
            cVar.zG.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zG.setUserName(String.valueOf(1));
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(false);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zG.setUserName(String.valueOf(5));
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            bc.c(cVar.zG, v.icon_im_subscribe);
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(true);
            cVar.zG.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zG.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.zG.d(friendPortrait2, 12, false);
            } else {
                cVar.zG.d(String.valueOf(v.icon_im_tie), 24, false);
            }
            cVar.zG.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zG.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zG.setDrawBorder(false);
            cVar.zG.setAutoChangeStyle(true);
            cVar.zG.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zG.setUserName(String.valueOf(7));
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            bc.c(cVar.zG, v.icon_new_stranger);
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        } else {
            cVar.zG.setDrawBorder(true);
            cVar.zG.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zG.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                cVar.zG.d(friendPortrait3, 12, false);
            } else {
                cVar.zG.d(String.valueOf(v.person_photo), 24, false);
            }
            cVar.zG.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zG.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zG.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.zG.setIsRound(false);
            cVar.zG.invalidate();
        }
    }
}
