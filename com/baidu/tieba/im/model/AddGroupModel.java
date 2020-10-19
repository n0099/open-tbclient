package com.baidu.tieba.im.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes23.dex */
public class AddGroupModel extends BdBaseModel<Object> {
    private String business;
    private int flag;
    private int forumId;
    private int groupType;
    private String intro;
    private String lat;
    private String lng;
    private String name;
    private String portrait;
    private String position;
    private ResponseAddGroupMessage sentLocalMsg;
    private RequestAddGroupMessage sentMsg;
    private int sourceFrom;

    public AddGroupModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.sentMsg = null;
        this.sentLocalMsg = null;
        this.sourceFrom = -1;
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

    public int getSourceFrom() {
        return this.sourceFrom;
    }

    public void setSourceFrom(int i) {
        this.sourceFrom = i;
    }

    private RequestAddGroupMessage createMessage() {
        RequestAddGroupMessage requestAddGroupMessage = new RequestAddGroupMessage();
        requestAddGroupMessage.setForumId(this.forumId);
        requestAddGroupMessage.setName(this.name);
        requestAddGroupMessage.setIntro(this.intro);
        requestAddGroupMessage.setPortrait(this.portrait);
        requestAddGroupMessage.setPosition(this.position);
        requestAddGroupMessage.setBusiness(this.business);
        requestAddGroupMessage.setLng(this.lng);
        requestAddGroupMessage.setLat(this.lat);
        requestAddGroupMessage.setGroupType(this.groupType);
        requestAddGroupMessage.setFlag(this.flag);
        switch (this.sourceFrom) {
            case 1011:
                requestAddGroupMessage.setPage_from_dim(TbEnum.CreateGroupSource.FROM_NEAR_GROUP);
                break;
            case 1012:
                requestAddGroupMessage.setPage_from_dim(TbEnum.CreateGroupSource.FROM_MY_GROUP);
                break;
            case 1013:
                requestAddGroupMessage.setPage_from_dim(TbEnum.CreateGroupSource.FROM_BAR_GROUP);
                break;
            case 1014:
                requestAddGroupMessage.setPage_from_dim("");
                break;
            default:
                requestAddGroupMessage.setPage_from_dim("");
                break;
        }
        return requestAddGroupMessage;
    }

    public void sendMessage() {
        this.sentMsg = createMessage();
        super.sendMessage(this.sentMsg);
    }

    public void sendLocalMessage(ResponseAddGroupMessage responseAddGroupMessage) {
        this.sentLocalMsg = responseAddGroupMessage;
        MessageManager.getInstance().dispatchResponsedMessageToUI(this.sentLocalMsg);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
    }
}
