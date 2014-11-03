package com.baidu.tieba.im.chat;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.live.message.RequestDismissGroupMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.base.e {
    private RequestRemoveMembersMessage aOE;
    private RequestDismissGroupMessage aOF;
    private int flag;
    private String groupId;
    private String groupName;
    private BaseActivity mActivity;

    public bm(BaseActivity baseActivity) {
        super(baseActivity);
        this.mActivity = null;
        this.mActivity = baseActivity;
    }

    public void d(String str, String str2, int i) {
        setGroupId(str);
        setGroupName(str2);
        setFlag(i);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        if (this.aOE != null) {
            this.aOE = null;
        }
    }

    public void cx(boolean z) {
        new bn(this, z).execute(new Void[0]);
    }

    public void a(com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new bo(this), aVar);
    }

    public void D(long j) {
        this.aOE = new RequestRemoveMembersMessage();
        this.aOE.setGroupId(j);
        this.aOE.setUserIds(TbadkApplication.getCurrentAccountObj().getID());
        if (this.mActivity != null) {
            this.mActivity.sendMessage(this.aOE);
        } else {
            sendMessage(this.aOE);
        }
    }

    public void fp(int i) {
        this.aOF = new RequestDismissGroupMessage();
        this.aOF.setGroupId(i);
        if (this.mActivity != null) {
            this.mActivity.sendMessage(this.aOF);
        } else {
            sendMessage(this.aOF);
        }
    }

    public String getGroupId() {
        return this.groupId;
    }

    public int JD() {
        return com.baidu.adp.lib.g.c.f(this.groupId, 0);
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }
}
