package com.baidu.tieba.im.model;

import com.baidu.adp.base.f;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.message.RequestCheckUserMaskMessage;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class BlackListModel extends f {
    public static final int ISMASK_FALSE_FROM_SERVER = 0;
    public static final int ISMASK_TRUE_FROM_SERVER = 1;
    public static final int MASK_TYPE = 10;
    public static final int MASK_TYPE_NOT_FROM_SERVER = 2;
    private RequestCheckUserMaskMessage mCheckMessage;
    private RequestGetMaskInfoMessage mGetMessage;
    private int mMaskType;
    private RequestUpdateMaskInfoMessage mUpdateMessage;

    public BlackListModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mMaskType = 2;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void loadBlackList() {
        this.mGetMessage = new RequestGetMaskInfoMessage();
        this.mGetMessage.setMaskType(10);
        super.sendMessage(this.mGetMessage);
    }

    public void addToBlackList(long j) {
        this.mUpdateMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage.setIsMask(1);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    public void checkUserMask(int i) {
        this.mCheckMessage = new RequestCheckUserMaskMessage();
        this.mCheckMessage.setUserId(i);
        super.sendMessage(this.mCheckMessage);
    }

    public void removeFromBlackList(long j) {
        this.mUpdateMessage = new RequestUpdateMaskInfoMessage();
        this.mUpdateMessage.setIsMask(0);
        this.mUpdateMessage.setMaskType(10);
        this.mUpdateMessage.setList(String.valueOf(j));
        super.sendMessage(this.mUpdateMessage);
    }

    public int getMaskType() {
        return this.mMaskType;
    }

    public void setMaskType(int i) {
        this.mMaskType = i;
    }
}
