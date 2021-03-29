package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.DataRes;
import tbclient.GetForumDetail.GetForumDetailResIdl;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailSocketResponse extends TbSocketReponsedMessage {
    public ManagerApplyInfo applyInfo;
    public BzApplySwitch bzApplySwitch;
    public RecommendForumInfo forumInfo;
    public int isBawuShow;
    public boolean isComplaintShow;
    public ManagerElectionTab managerElectionTab;
    public PriManagerApplyInfo privateApplyInfo;
    public List<SimpleThreadInfo> threadInfoList;

    public ForumDetailSocketResponse() {
        super(303021);
    }

    public ManagerApplyInfo getApplyInfo() {
        return this.applyInfo;
    }

    public BzApplySwitch getBzApplySwitch() {
        return this.bzApplySwitch;
    }

    public RecommendForumInfo getForumInfo() {
        return this.forumInfo;
    }

    public ManagerElectionTab getManagerElectionTab() {
        return this.managerElectionTab;
    }

    public PriManagerApplyInfo getPrivateApplyInfo() {
        return this.privateApplyInfo;
    }

    public List<SimpleThreadInfo> getThreadInfoList() {
        return this.threadInfoList;
    }

    public int isBawuShow() {
        return this.isBawuShow;
    }

    public boolean isComplaintShow() {
        return this.isComplaintShow;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetForumDetailResIdl getForumDetailResIdl = (GetForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumDetailResIdl.class);
        if (getForumDetailResIdl == null) {
            return;
        }
        Error error = getForumDetailResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getForumDetailResIdl.error.usermsg);
        }
        DataRes dataRes = getForumDetailResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.forumInfo = dataRes.forum_info;
        this.threadInfoList = dataRes.thread_list;
        this.isBawuShow = dataRes.is_bawu_show.intValue();
        this.isComplaintShow = getForumDetailResIdl.data.is_complaint_show.intValue() != 0;
        DataRes dataRes2 = getForumDetailResIdl.data;
        this.applyInfo = dataRes2.bz_apply_info;
        this.privateApplyInfo = dataRes2.pribz_apply_info;
        this.managerElectionTab = dataRes2.election_tab;
        this.bzApplySwitch = dataRes2.bz_apply_switch;
    }
}
