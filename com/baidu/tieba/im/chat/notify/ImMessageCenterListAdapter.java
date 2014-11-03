package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.officialBar.aw;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.u;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImMessageCenterListAdapter extends b {
    private g aQT;

    public ImMessageCenterListAdapter(Context context) {
        super(context);
        this.aQT = null;
    }

    @Override // com.baidu.tieba.im.chat.notify.b
    public void setData(List<ImMessageCenterShowItemData> list) {
        super.setData(list);
        if (TbadkApplication.isLogin()) {
            if (this.WB.size() <= 0) {
                this.aQT.cE(true);
            } else {
                this.aQT.cE(false);
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.im.chat.notify.b, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImMessageCenterShowItemData fr = getItem(i);
        if (fr != null && String.valueOf(String.valueOf(2)).equals(fr.getOwnerName())) {
            if (fr.getUnReadCount() >= 30) {
                if (this.aQT != null) {
                    this.aQT.cD(true);
                }
            } else if (this.aQT != null) {
                this.aQT.cD(false);
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public void g(g gVar) {
        this.aQT = gVar;
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
            str = "";
            i = 0;
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkApplication.m251getInst().isGroupMsgOn()) {
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
            if (!TbadkApplication.m251getInst().isMsgChatOn()) {
                str = "";
                i = 0;
            } else {
                PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) imMessageCenterShowItemData.getGroupSetting();
                if (personalSettingItemData != null && !personalSettingItemData.isAcceptNotify()) {
                    str = "";
                    i = 0;
                }
            }
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            if (!TbadkApplication.m251getInst().isMsgChatOn()) {
                str = "";
                i = 0;
            } else if (!aw.KD().isAcceptNotify()) {
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
        cVar.aHz.setDrawerType(1);
        cVar.aHz.setRadius(com.baidu.adp.lib.util.m.dip2px(this.mContext, 4.0f));
        if (String.valueOf(2).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(false);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setTag(imMessageCenterShowItemData.getOwnerName());
            com.baidu.tbadk.core.util.aw.c(cVar.aHz, u.icon_new_test);
            cVar.aHz.setUserName(String.valueOf(2));
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else if (String.valueOf(3).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(false);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.aHz.setUserName(String.valueOf(3));
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            com.baidu.tbadk.core.util.aw.c(cVar.aHz, u.icon_new_trends);
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else if (String.valueOf(6).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(false);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.aHz.setUserName(String.valueOf(6));
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            com.baidu.tbadk.core.util.aw.c(cVar.aHz, u.icon_new_live);
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else if (String.valueOf(1).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(true);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            String friendPortrait = imMessageCenterShowItemData.getFriendPortrait();
            cVar.aHz.setImageDrawable(null);
            if (TextUtils.isEmpty(friendPortrait)) {
                cVar.aHz.c(String.valueOf(u.icon_default_avatar100), 24, false);
            } else {
                cVar.aHz.c(friendPortrait, 10, false);
            }
            cVar.aHz.setClickable(false);
            cVar.aHz.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.aHz.setUserName(String.valueOf(1));
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else if (String.valueOf(5).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(false);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.aHz.setUserName(String.valueOf(5));
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            com.baidu.tbadk.core.util.aw.c(cVar.aHz, u.icon_new_official);
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else if (String.valueOf(7).equals(imMessageCenterShowItemData.getOwnerName())) {
            cVar.aHz.setDrawBorder(false);
            cVar.aHz.setAutoChangeStyle(true);
            cVar.aHz.setTag(imMessageCenterShowItemData.getOwnerName());
            cVar.aHz.setUserName(String.valueOf(7));
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            com.baidu.tbadk.core.util.aw.c(cVar.aHz, u.icon_new_stranger);
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        } else {
            cVar.aHz.setDrawBorder(true);
            cVar.aHz.setAutoChangeStyle(true);
            String friendPortrait2 = imMessageCenterShowItemData.getFriendPortrait();
            cVar.aHz.setImageDrawable(null);
            if (!TextUtils.isEmpty(friendPortrait2)) {
                cVar.aHz.c(friendPortrait2, 12, false);
            } else {
                cVar.aHz.c(String.valueOf(u.person_photo), 24, false);
            }
            cVar.aHz.setTag(imMessageCenterShowItemData.getFriendPortrait());
            cVar.aHz.setUserId(imMessageCenterShowItemData.getFriendId());
            cVar.aHz.setUserName(imMessageCenterShowItemData.getFriendName());
            cVar.aHz.setIsRound(false);
            cVar.aHz.invalidate();
        }
    }
}
