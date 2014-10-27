package com.baidu.tieba.im.mygroup;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    public long friendUid;
    private boolean isHaveReadCache;
    public int mImageHeight;
    public int mImageWidth;
    private RequestUserPermissionMessage sendUserMsg;

    public k(Context context) {
        super(context);
        this.isHaveReadCache = false;
        this.mImageWidth = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        this.mImageHeight = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    public k(Context context, long j) {
        super(context);
        this.isHaveReadCache = false;
        this.mImageWidth = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        this.mImageHeight = com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getContext(), 70.0f);
        this.friendUid = j;
    }

    public void update() {
        if (this.friendUid == 0) {
            if (this.isHaveReadCache) {
                super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                return;
            }
            this.isHaveReadCache = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
    }

    public void sendUserPermissionMessage(long j) {
        this.sendUserMsg = createUserPermissionMessage(j);
        super.sendMessage(this.sendUserMsg);
    }

    private RequestUserPermissionMessage createUserPermissionMessage(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.sendUserMsg = null;
    }
}
