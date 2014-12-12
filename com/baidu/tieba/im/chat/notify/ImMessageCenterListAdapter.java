package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.v;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends b {
    private g aSx;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.aSx = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkCoreApplication.isLogin()) {
            if (this.mList.size() <= 0) {
                this.aSx.cs(true);
            } else {
                this.aSx.cs(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fu = getItem(i);
        if (fu != null && String.valueOf(String.valueOf(2)).equals(fu.getOwnerName())) {
            if (fu.getUnReadCount() >= 30) {
                if (this.aSx != null) {
                    this.aSx.cr(true);
                }
            } else if (this.aSx != null) {
                this.aSx.cr(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(g gVar) {
        this.aSx = gVar;
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
            } else if (!com.baidu.tieba.im.settingcache.l.SZ().isAcceptNotify()) {
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
            } else if (!com.baidu.tieba.im.settingcache.g.SW().isAcceptNotify()) {
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
        cVar.zJ.setDrawerType(1);
        cVar.zJ.setRadius(com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(false);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setTag(imMessageCenterShowItemData.getOwnerName());
            ax.c(cVar.zJ, v.icon_new_test);
            cVar.zJ.setUserName(String.valueOf(2));
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(false);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zJ.setUserName(String.valueOf(3));
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            ax.c(cVar.zJ, v.icon_new_trends);
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(false);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zJ.setUserName(String.valueOf(6));
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            ax.c(cVar.zJ, v.icon_new_live);
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(true);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zJ.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.zJ.d(String.valueOf(v.icon_default_avatar100), 24, false);
            } else {
                cVar.zJ.d(friendPortrait, 10, false);
            }
            cVar.zJ.setClickable(false);
            cVar.zJ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zJ.setUserName(String.valueOf(1));
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(false);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zJ.setUserName(String.valueOf(5));
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            ax.c(cVar.zJ, v.icon_im_subscribe);
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(8).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(true);
            cVar.zJ.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zJ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.zJ.d(friendPortrait2, 12, false);
            } else {
                cVar.zJ.d(String.valueOf(v.icon_im_tie), 24, false);
            }
            cVar.zJ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zJ.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.zJ.setDrawBorder(false);
            cVar.zJ.setAutoChangeStyle(true);
            cVar.zJ.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.zJ.setUserName(String.valueOf(7));
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            ax.c(cVar.zJ, v.icon_new_stranger);
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        } else {
            cVar.zJ.setDrawBorder(true);
            cVar.zJ.setAutoChangeStyle(true);
            String friendPortrait3 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.zJ.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait3)) {
                cVar.zJ.d(friendPortrait3, 12, false);
            } else {
                cVar.zJ.d(String.valueOf(v.person_photo), 24, false);
            }
            cVar.zJ.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.zJ.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.zJ.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.zJ.setIsRound(false);
            cVar.zJ.invalidate();
        }
    }
}
