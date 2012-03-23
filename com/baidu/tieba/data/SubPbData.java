package com.baidu.tieba.data;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SubPbData {
    private AntiData mAntiData;
    private int mCurrentPage;
    private ForumData mForumData;
    private int mPageSize;
    private PostData mPostData = null;
    private List<PostData> mSubPbList = new ArrayList();
    private ThreadData mThreadData;
    private int mTotalCount;
    private int mTotalPage;

    public PostData getPostData() {
        return this.mPostData;
    }

    public void setPostData(PostData data) {
        this.mPostData = data;
    }

    public List<PostData> getSubPbList() {
        return this.mSubPbList;
    }

    public void setSubPbList(List<PostData> list) {
        this.mSubPbList = list;
    }

    public int getTotalPage() {
        return this.mTotalPage;
    }

    public void setTotalPage(int totalPage) {
        this.mTotalPage = totalPage;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public void setTotalCount(int totalCount) {
        this.mTotalCount = totalCount;
    }

    public int getPageSize() {
        return this.mPageSize;
    }

    public void setPageSize(int pageSize) {
        this.mPageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.mCurrentPage = currentPage;
    }

    public void setForumData(ForumData data) {
        this.mForumData = data;
    }

    public ForumData getForumData() {
        return this.mForumData;
    }

    public void setAntiData(AntiData data) {
        this.mAntiData = data;
    }

    public AntiData getAntiData() {
        return this.mAntiData;
    }

    public void setThreadData(ThreadData data) {
        this.mThreadData = data;
    }

    public ThreadData getThreadData() {
        return this.mThreadData;
    }
}
