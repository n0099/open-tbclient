package com.baidu.tieba.im.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.channelrtc.medialivesender.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e {
    private final List<ImMessageCenterShowItemData> a;

    public p(Context context) {
        super(context);
        this.a = new LinkedList();
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public List<ImMessageCenterShowItemData> a() {
        return this.a;
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.chat.notify.a aVar) {
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            int size = this.a.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    imMessageCenterShowItemData = null;
                    break;
                }
                ImMessageCenterShowItemData imMessageCenterShowItemData2 = this.a.get(i);
                if (a(imMessageCenterShowItemData2) != imMessageCenterPojo.getCustomGroupType() || !imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData2.getFriendId())) {
                    i++;
                } else {
                    imMessageCenterShowItemData = this.a.remove(i);
                    break;
                }
            }
            i(imMessageCenterPojo, imMessageCenterShowItemData);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo, com.baidu.tieba.im.chat.notify.a aVar) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            int size = this.a.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = this.a.get(i);
                    if (a(imMessageCenterShowItemData) != imMessageCenterPojo.getCustomGroupType() || !imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId())) {
                        i++;
                    } else {
                        this.a.remove(i);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(List<ImMessageCenterPojo> list, com.baidu.tieba.im.chat.notify.a aVar) {
        this.a.clear();
        if (list == null) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        for (ImMessageCenterPojo imMessageCenterPojo : list) {
            if (a(imMessageCenterPojo)) {
                i(imMessageCenterPojo, null);
            }
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData h;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && (h = h(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            h.setSendStatus(imMessageCenterPojo.getSend_status());
            h.setOwnerName(String.valueOf(1));
            GroupSettingItemData b = com.baidu.tieba.im.groupInfo.y.a().b(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (b != null) {
                h.setGroupSetting(b);
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                if (TextUtils.isEmpty(h.getMsgContent())) {
                    h.setMsgContent("");
                } else {
                    h.setMsgContent(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + h.getMsgContent());
                }
            }
            a(h, this.a);
        }
    }

    private void b(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && imMessageCenterPojo.getIsFriend() != 0) {
            BdLog.i("send message status " + imMessageCenterPojo.getSend_status());
            ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
            if (h != null) {
                h.setSendStatus(imMessageCenterPojo.getSend_status());
                h.setOwnerName(String.valueOf(4));
                PersonalSettingItemData b = com.baidu.tieba.im.chat.personaltalk.a.a().b(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                if (b != null) {
                    h.setGroupSetting(b);
                }
                a(h, this.a);
            }
        }
    }

    private void c(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.official_message_activity_title));
        ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
        if (h != null) {
            h.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                h.setMsgContent(String.valueOf(TbadkApplication.m252getInst().getContext().getString(com.baidu.tieba.x.official_msg_list_name, imMessageCenterPojo.getLast_user_name())) + ":" + h.getMsgContent());
            }
            a(h, this.a);
        }
    }

    private void d(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.stranger_message_activity_title));
        ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
        if (h != null) {
            h.setOwnerName(String.valueOf(7));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                h.setMsgContent(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + h.getMsgContent());
            }
            a(h, this.a);
        }
    }

    private void e(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.updates_activity_title));
        ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
        if (h != null) {
            h.setOwnerName(String.valueOf(3));
            a(h, this.a);
        }
    }

    private void f(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.validate));
        ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
        if (h != null) {
            h.setOwnerName(String.valueOf(2));
            a(h, this.a);
        }
    }

    private void g(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.live_chat_room_more_livenotify));
        ImMessageCenterShowItemData h = h(imMessageCenterPojo, imMessageCenterShowItemData);
        if (h != null) {
            h.setOwnerName(String.valueOf(6));
            a(h, this.a);
        }
    }

    private ImMessageCenterShowItemData h(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo == null) {
            return null;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() == 0) {
            return null;
        }
        if (imMessageCenterShowItemData == null) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        }
        imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
        imMessageCenterShowItemData.setOwnerId(TbadkApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
        imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
        if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
            imMessageCenterPojo.setLast_content("");
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
        return imMessageCenterShowItemData;
    }

    private void a(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        if (imMessageCenterShowItemData != null && list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                ImMessageCenterShowItemData imMessageCenterShowItemData2 = list.get(i);
                if (imMessageCenterShowItemData2 != null && imMessageCenterShowItemData2.getServerTime() < imMessageCenterShowItemData.getServerTime()) {
                    break;
                }
                i++;
            }
            list.add(i, imMessageCenterShowItemData);
        }
    }

    private boolean a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() != 1 && imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5 && imMessageCenterPojo.getCustomGroupType() != -8 && imMessageCenterPojo.getCustomGroupType() != -7) {
            return imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1;
        }
        return true;
    }

    public void a(ImMessageCenterShowItemData imMessageCenterShowItemData, boolean z, com.baidu.tieba.im.chat.notify.a aVar) {
        String friendId = imMessageCenterShowItemData.getFriendId();
        String ownerName = imMessageCenterShowItemData.getOwnerName();
        if (!TextUtils.isEmpty(ownerName) && !TextUtils.isEmpty(friendId) && this.a != null && this.a.size() != 0) {
            Iterator<ImMessageCenterShowItemData> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ImMessageCenterShowItemData next = it.next();
                if (next != null && friendId.equals(next.getFriendId()) && ownerName.equals(next.getOwnerName())) {
                    if (!z) {
                        this.a.remove(next);
                    }
                }
            }
            if (aVar != null) {
                aVar.a();
            }
            if (a(imMessageCenterShowItemData) == -8) {
                com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new com.baidu.tieba.im.message.h(friendId, a(imMessageCenterShowItemData), z)));
        }
    }

    private int a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
            return 1;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
            return -3;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
            return -4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(6))) {
            return -5;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
            return -8;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
            return 2;
        }
        if (!imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
            return 0;
        }
        return -7;
    }

    private void i(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        switch (imMessageCenterPojo.getCustomGroupType()) {
            case Constants.ERROR_OPEN_CONNECTION /* -8 */:
                c(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -7:
                d(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -6:
            case -2:
            case -1:
            case 0:
            default:
                return;
            case -5:
                g(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -4:
                f(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -3:
                e(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 1:
                a(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 2:
                b(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
        }
    }
}
