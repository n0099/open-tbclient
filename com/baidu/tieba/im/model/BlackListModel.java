package com.baidu.tieba.im.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestCheckUserMaskMessage;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes3.dex */
public class BlackListModel extends BdBaseModel {
    public static final int ISMASK_FALSE_FROM_SERVER = 0;
    public static final int ISMASK_TRUE_FROM_SERVER = 1;
    public static final int MASK_TYPE = 10;
    public static final int MASK_TYPE_NOT_FROM_SERVER = 2;
    public RequestCheckUserMaskMessage mCheckMessage;
    public RequestGetMaskInfoMessage mGetMessage;
    public int mMaskType;
    public RequestUpdateMaskInfoMessage mUpdateMessage;

    public BlackListModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mMaskType = 2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void addToBlackList(long j) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage = requestUpdateMaskInfoMessage;
        requestUpdateMaskInfoMessage.setIsMask(1);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void checkUserMask(long j) {
        RequestCheckUserMaskMessage requestCheckUserMaskMessage = new RequestCheckUserMaskMessage();
        this.mCheckMessage = requestCheckUserMaskMessage;
        requestCheckUserMaskMessage.setUserId(j);
        super.sendMessage(this.mCheckMessage);
    }

    public int getMaskType() {
        return this.mMaskType;
    }

    public void loadBlackList() {
        RequestGetMaskInfoMessage requestGetMaskInfoMessage = new RequestGetMaskInfoMessage();
        this.mGetMessage = requestGetMaskInfoMessage;
        requestGetMaskInfoMessage.setMaskType(10);
        super.sendMessage(this.mGetMessage);
    }

    public void removeFromBlackList(long j) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage = requestUpdateMaskInfoMessage;
        requestUpdateMaskInfoMessage.setIsMask(0);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    public void setMaskType(int i) {
        this.mMaskType = i;
    }

    public BlackListModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mMaskType = 2;
        setUniqueId(bdUniqueId);
    }
}
