package com.baidu.tieba.im.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.channelrtc.medialivesender.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.chat.personaltalk.c;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.groupInfo.aa;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImMessageCenterModel extends ImBaseMessageCenterModel {
    public static final int TYPE_GROUP_MSG = 1;
    public static final int TYPE_GROUP_UPDATES = 3;
    public static final int TYPE_GROUP_VALIDATE = 2;
    public static final int TYPE_LIVE_NOTIFY_MESSAGE = 6;
    public static final int TYPE_OFFICIAL_MESSAGE_MERGE = 5;
    public static final int TYPE_PERSONAL_MSG = 4;
    public static final int TYPE_STRANGER_MESSAGE_MERGE = 7;

    public ImMessageCenterModel(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel, com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private void processGroup(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(1));
            GroupSettingItemData am = aa.Pe().am(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (am != null) {
                buildNormalItem.setGroupSetting(am);
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                if (TextUtils.isEmpty(buildNormalItem.getMsgContent())) {
                    buildNormalItem.setMsgContent("");
                } else {
                    buildNormalItem.setMsgContent(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + buildNormalItem.getMsgContent());
                }
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void processPrivate(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && imMessageCenterPojo.getIsFriend() != 0) {
            BdLog.i("send message status " + imMessageCenterPojo.getSend_status());
            ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
            if (buildNormalItem != null) {
                buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
                buildNormalItem.setOwnerName(String.valueOf(4));
                PersonalSettingItemData am = c.KJ().am(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                if (am != null) {
                    buildNormalItem.setGroupSetting(am);
                }
                insertShowData(buildNormalItem, this.mList);
            }
        }
    }

    private void processOfficialMerge(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m251getInst().getApp().getString(y.official_message_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(5));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                buildNormalItem.setMsgContent(String.valueOf(TbadkApplication.m251getInst().getContext().getString(y.official_msg_list_name, imMessageCenterPojo.getLast_user_name())) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void processStrangeMerge(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m251getInst().getApp().getString(y.stranger_message_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(7));
            if (!TextUtils.isEmpty(imMessageCenterPojo.getLast_user_name()) && !imMessageCenterPojo.getLast_user_name().equals(TbadkApplication.getCurrentAccountName())) {
                buildNormalItem.setMsgContent(String.valueOf(imMessageCenterPojo.getLast_user_name()) + ":" + buildNormalItem.getMsgContent());
            }
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void processGroupUpdate(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m251getInst().getApp().getString(y.updates_activity_title));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(3));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void processGroupValidation(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m251getInst().getApp().getString(y.validate));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(2));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private void processLiveNotify(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        imMessageCenterPojo.setGroup_name(TbadkApplication.m251getInst().getApp().getString(y.live_chat_room_more_livenotify));
        ImMessageCenterShowItemData buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData);
        if (buildNormalItem != null) {
            buildNormalItem.setOwnerName(String.valueOf(6));
            insertShowData(buildNormalItem, this.mList);
        }
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return false;
        }
        if (imMessageCenterPojo.getCustomGroupType() == 1) {
            return (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
        }
        if (imMessageCenterPojo.getCustomGroupType() != -3 && imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -5 && imMessageCenterPojo.getCustomGroupType() != -8 && imMessageCenterPojo.getCustomGroupType() != -7) {
            return imMessageCenterPojo.getCustomGroupType() == 2 && imMessageCenterPojo.getIsFriend() == 1 && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name());
        }
        return true;
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected void processMsg(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        switch (imMessageCenterPojo.getCustomGroupType()) {
            case Constants.ERROR_OPEN_CONNECTION /* -8 */:
                processOfficialMerge(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -7:
                processStrangeMerge(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -6:
            case -2:
            case -1:
            case 0:
            default:
                return;
            case -5:
                processLiveNotify(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -4:
                processGroupValidation(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case -3:
                processGroupUpdate(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 1:
                processGroup(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
            case 2:
                processPrivate(imMessageCenterPojo, imMessageCenterShowItemData);
                return;
        }
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
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

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isAccept(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }

    @Override // com.baidu.tieba.im.model.ImBaseMessageCenterModel
    protected boolean isToShow(ImMessageCenterPojo imMessageCenterPojo) {
        return isNeed(imMessageCenterPojo);
    }
}
