package com.baidu.tieba.im.mygroup;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class PersonGroupModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public RequestUserPermissionMessage f17394e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17395f;
    public long friendUid;
    public int mImageHeight;
    public int mImageWidth;

    public PersonGroupModel(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        this.f17395f = false;
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
        this.f17394e = null;
    }

    public final RequestUserPermissionMessage w(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    public void x(long j) {
        RequestUserPermissionMessage w = w(j);
        this.f17394e = w;
        super.sendMessage(w);
    }

    public void y() {
        if (this.friendUid == 0) {
            if (this.f17395f) {
                super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                return;
            }
            this.f17395f = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
    }

    public PersonGroupModel(PersonGroupActivity personGroupActivity, long j) {
        super(personGroupActivity.getPageContext());
        this.f17395f = false;
        this.mImageWidth = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = l.e(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j;
    }
}
