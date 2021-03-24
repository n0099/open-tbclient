package com.baidu.tieba.im.mygroup;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class PersonGroupModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public RequestUserPermissionMessage f18081e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18082f;
    public long friendUid;
    public int mImageHeight;
    public int mImageWidth;

    public PersonGroupModel(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        this.f18082f = false;
        this.mImageWidth = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.f18081e = null;
    }

    public final RequestUserPermissionMessage s(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    public void t(long j) {
        RequestUserPermissionMessage s = s(j);
        this.f18081e = s;
        super.sendMessage(s);
    }

    public void u() {
        if (this.friendUid == 0) {
            if (this.f18082f) {
                super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                return;
            }
            this.f18082f = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
    }

    public PersonGroupModel(PersonGroupActivity personGroupActivity, long j) {
        super(personGroupActivity.getPageContext());
        this.f18082f = false;
        this.mImageWidth = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j;
    }
}
