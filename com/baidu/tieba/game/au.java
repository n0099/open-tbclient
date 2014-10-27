package com.baidu.tieba.game;

import android.content.Context;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e {
    private boolean mHasMore;
    private int mPageNum;

    public au(Context context) {
        super(context);
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGameCenterMessage fc(int i) {
        RequestGameCenterMessage requestGameCenterMessage = new RequestGameCenterMessage();
        requestGameCenterMessage.setPageNum(i);
        return requestGameCenterMessage;
    }

    private RequestGameCenterLocalMessage fd(int i) {
        RequestGameCenterLocalMessage requestGameCenterLocalMessage = new RequestGameCenterLocalMessage();
        requestGameCenterLocalMessage.setPageNum(i);
        return requestGameCenterLocalMessage;
    }

    public void sendMessage(int i) {
        sendMessage(fc(i));
    }

    public void fe(int i) {
        sendMessage(fd(i));
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
