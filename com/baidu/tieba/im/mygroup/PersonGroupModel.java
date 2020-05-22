package com.baidu.tieba.im.mygroup;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes13.dex */
public class PersonGroupModel extends BdBaseModel<BaseFragmentActivity> {
    public long friendUid;
    private RequestUserPermissionMessage iHW;
    private boolean iHX;
    public int mImageHeight;
    public int mImageWidth;

    public PersonGroupModel(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        this.iHX = false;
        this.mImageWidth = l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    public PersonGroupModel(PersonGroupActivity personGroupActivity, long j) {
        super(personGroupActivity.getPageContext());
        this.iHX = false;
        this.mImageWidth = l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j;
    }

    public void update() {
        if (this.friendUid == 0) {
            if (this.iHX) {
                super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                return;
            }
            this.iHX = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
    }

    public void eD(long j) {
        this.iHW = eE(j);
        super.sendMessage(this.iHW);
    }

    private RequestUserPermissionMessage eE(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.iHW = null;
    }
}
