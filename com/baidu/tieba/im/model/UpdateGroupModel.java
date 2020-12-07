package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.RequestUpdateGroupAlbumMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupFlagMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupInfoMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupNameMessage;
import com.baidu.tieba.im.message.RequestUpdateGroupPortraitMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
/* loaded from: classes23.dex */
public class UpdateGroupModel extends BdBaseModel {
    public static final int TYPE_UPDATE_ALBUM = 3;
    public static final int TYPE_UPDATE_FLAG = 5;
    public static final int TYPE_UPDATE_INTRO = 1;
    public static final int TYPE_UPDATE_NAME = 2;
    public static final int TYPE_UPDATE_PORTRAIT = 4;
    private String album;
    private String business;
    private int flag;
    private int forumId;
    private long groupId;
    private int groupType;
    private String intro;
    private String lat;
    private String lng;
    private ResponseUpdateGroupMessage localMsg;
    private String name;
    private String portrait;
    private String position;
    private RequestUpdateGroupMessage sentMsg;

    public UpdateGroupModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.album = null;
        this.flag = 0;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getForumId() {
        return this.forumId;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getBusiness() {
        return this.business;
    }

    public void setBusiness(String str) {
        this.business = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int i) {
        this.groupType = i;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private RequestUpdateGroupMessage createMessage(int i) {
        RequestUpdateGroupMessage requestUpdateGroupMessage = null;
        switch (i) {
            case 1:
                requestUpdateGroupMessage = new RequestUpdateGroupInfoMessage(getIntro());
                break;
            case 2:
                requestUpdateGroupMessage = new RequestUpdateGroupNameMessage(getName());
                break;
            case 3:
                requestUpdateGroupMessage = new RequestUpdateGroupAlbumMessage(getAlbum());
                break;
            case 4:
                requestUpdateGroupMessage = new RequestUpdateGroupPortraitMessage(getPortrait());
                break;
            case 5:
                requestUpdateGroupMessage = new RequestUpdateGroupFlagMessage(getFlag(), getPosition(), getBusiness());
                break;
        }
        if (requestUpdateGroupMessage != null) {
            requestUpdateGroupMessage.setGroupId(getGroupId());
            requestUpdateGroupMessage.setType(i);
        }
        return requestUpdateGroupMessage;
    }

    public void sendMessage(int i) {
        this.sentMsg = createMessage(i);
        super.sendMessage(this.sentMsg);
    }

    public void sendLocalMessage(ResponseUpdateGroupMessage responseUpdateGroupMessage) {
        this.localMsg = responseUpdateGroupMessage;
        MessageManager.getInstance().dispatchResponsedMessageToUI(this.localMsg);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        this.sentMsg = null;
        this.localMsg = null;
        super.cancelMessage();
    }
}
