package com.baidu.tieba.im.forum.detail;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetForumDetail.GetForumDetailResIdl;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
import tbclient.SimpleThreadInfo;
/* loaded from: classes3.dex */
public class ForumDetailSocketResponse extends TbSocketReponsedMessage {
    private ManagerApplyInfo applyInfo;
    private RecommendForumInfo forumInfo;
    private int isBawuShow;
    private List<SimpleThreadInfo> threadInfoList;

    public ForumDetailSocketResponse() {
        super(303021);
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
                this.applyInfo = getForumDetailResIdl.data.bz_apply_info;
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

    public ManagerApplyInfo getApplyInfo() {
        return this.applyInfo;
    }
}
