package com.baidu.tieba.im.model;

import android.content.Intent;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.live.message.RequestFrsLiveListMessage;
import com.baidu.tbadk.live.message.RequestOperateFrsLiveListMessage;
/* loaded from: classes.dex */
public class FrsLiveListModel extends f {
    public static final String FORUM_ID = "forum_id";
    public static final String FRS_MANAGER = "frs_manager";
    public static final int PAGE_LEN = 20;
    public static final int TYPE_LIVING = 1;
    public static final int TYPE_REVIEW = 2;
    private String forumId;
    private boolean frsManager;
    private boolean hasMore;
    private int pageNum;
    private int start;

    public FrsLiveListModel(j jVar) {
        super(jVar);
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public boolean isFrsManager() {
        return this.frsManager;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    private RequestFrsLiveListMessage createMessage(String str, int i, int i2, int i3) {
        RequestFrsLiveListMessage requestFrsLiveListMessage = new RequestFrsLiveListMessage();
        requestFrsLiveListMessage.setForumId(c.toInt(str, 0));
        requestFrsLiveListMessage.setType(i3);
        requestFrsLiveListMessage.setOffset(i);
        requestFrsLiveListMessage.setRn(i2);
        return requestFrsLiveListMessage;
    }

    public void sendMessage(String str, int i, int i2, int i3) {
        super.sendMessage(createMessage(str, i, i2, i3));
    }

    public void sendOperateMessage(String str, String str2, int i, int i2) {
        RequestOperateFrsLiveListMessage requestOperateFrsLiveListMessage = new RequestOperateFrsLiveListMessage();
        requestOperateFrsLiveListMessage.setForumId(c.toInt(str, 0));
        requestOperateFrsLiveListMessage.setGroupId(c.toInt(str2, 0));
        requestOperateFrsLiveListMessage.setType(i);
        requestOperateFrsLiveListMessage.setOldType(i2);
        super.sendMessage(requestOperateFrsLiveListMessage);
    }

    public void initWithIntent(Intent intent) {
        this.forumId = intent.getStringExtra("forum_id");
        this.frsManager = intent.getBooleanExtra("frs_manager", false);
    }
}
