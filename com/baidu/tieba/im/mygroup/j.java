package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<BaseFragmentActivity> {
    private RequestUserPermissionMessage bkG;
    private boolean bkH;
    public long friendUid;
    public int mImageHeight;
    public int mImageWidth;

    public j(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        this.bkH = false;
        this.mImageWidth = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    public j(PersonGroupActivity personGroupActivity, long j) {
        super(personGroupActivity.getPageContext());
        this.bkH = false;
        this.mImageWidth = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = com.baidu.adp.lib.util.l.dip2px(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j;
    }

    public void update() {
        if (this.friendUid == 0) {
            if (this.bkH) {
                super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                return;
            }
            this.bkH = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
    }

    public void ab(long j) {
        this.bkG = ac(j);
        super.sendMessage(this.bkG);
    }

    private RequestUserPermissionMessage ac(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public void cancelMessage() {
        super.cancelMessage();
        this.bkG = null;
    }
}
