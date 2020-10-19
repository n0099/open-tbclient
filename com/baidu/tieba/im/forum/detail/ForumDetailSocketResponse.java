package com.baidu.tieba.im.forum.detail;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetForumDetail.BzApplySwitch;
import tbclient.GetForumDetail.GetForumDetailResIdl;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes26.dex */
public class ForumDetailSocketResponse extends TbSocketReponsedMessage {
    private ManagerApplyInfo applyInfo;
    private BzApplySwitch bzApplySwitch;
    private RecommendForumInfo forumInfo;
    private int isBawuShow;
    private boolean isComplaintShow;
    private ManagerElectionTab managerElectionTab;
    private PriManagerApplyInfo privateApplyInfo;
    private List<SimpleThreadInfo> threadInfoList;

    public ForumDetailSocketResponse() {
        super(CmdConfigSocket.CMD_FORUM_DETAIL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetForumDetailResIdl getForumDetailResIdl = (GetForumDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumDetailResIdl.class);
        if (getForumDetailResIdl != null) {
            if (getForumDetailResIdl.error != null) {
                setError(getForumDetailResIdl.error.errorno.intValue());
                setErrorString(getForumDetailResIdl.error.usermsg);
            }
            if (getForumDetailResIdl.data != null) {
                this.forumInfo = getForumDetailResIdl.data.forum_info;
                this.threadInfoList = getForumDetailResIdl.data.thread_list;
                this.isBawuShow = getForumDetailResIdl.data.is_bawu_show.intValue();
                this.isComplaintShow = getForumDetailResIdl.data.is_complaint_show.intValue() != 0;
                this.applyInfo = getForumDetailResIdl.data.bz_apply_info;
                this.privateApplyInfo = getForumDetailResIdl.data.pribz_apply_info;
                this.managerElectionTab = getForumDetailResIdl.data.election_tab;
                this.bzApplySwitch = getForumDetailResIdl.data.bz_apply_switch;
            }
        }
    }

    public RecommendForumInfo getForumInfo() {
        return this.forumInfo;
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

    public ManagerApplyInfo getApplyInfo() {
        return this.applyInfo;
    }

    public PriManagerApplyInfo getPrivateApplyInfo() {
        return this.privateApplyInfo;
    }

    public BzApplySwitch getBzApplySwitch() {
        return this.bzApplySwitch;
    }

    public ManagerElectionTab getManagerElectionTab() {
        return this.managerElectionTab;
    }
}
