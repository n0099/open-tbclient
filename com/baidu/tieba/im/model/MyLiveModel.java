package com.baidu.tieba.im.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.live.message.RequestMyLiveListLocalMessage;
import com.baidu.tbadk.live.message.RequestMyLiveListMessage;
/* loaded from: classes.dex */
public class MyLiveModel extends e {
    private static final String CARD_TYPE = "card_type";
    public static final int PAGE_LEN = 20;
    private static final String PAGE_NUM = "page_num";
    private static final String START_POSITION = "start_position";
    private boolean mFirstLoaded;
    private boolean mIsFirstLoad;
    private int mPageNum;
    private int mStart;
    private int mTabType;

    public MyLiveModel(Context context, int i) {
        super(context);
        this.mFirstLoaded = false;
        this.mIsFirstLoad = true;
        this.mTabType = i;
    }

    public boolean ismIsFirstLoad() {
        return this.mIsFirstLoad;
    }

    public void setmIsFirstLoad(boolean z) {
        this.mIsFirstLoad = z;
    }

    public boolean hasFirstLoaded() {
        return this.mFirstLoaded;
    }

    public void setFirstLoaded(boolean z) {
        this.mFirstLoaded = z;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setStart(int i) {
        this.mStart = i;
    }

    public void addStart(int i) {
        this.mStart += i;
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

    public void initWithBundle(Bundle bundle) {
        this.mTabType = bundle.getInt(CARD_TYPE);
        this.mStart = bundle.getInt(START_POSITION);
        this.mPageNum = bundle.getInt(PAGE_NUM);
    }

    private RequestMyLiveListMessage createMessage(int i, int i2) {
        RequestMyLiveListMessage requestMyLiveListMessage = new RequestMyLiveListMessage();
        requestMyLiveListMessage.setType(this.mTabType);
        requestMyLiveListMessage.setOffset(i);
        requestMyLiveListMessage.setRn(i2);
        return requestMyLiveListMessage;
    }

    private RequestMyLiveListLocalMessage createLocalMessage(int i, int i2) {
        RequestMyLiveListLocalMessage requestMyLiveListLocalMessage = new RequestMyLiveListLocalMessage();
        requestMyLiveListLocalMessage.setType(this.mTabType);
        requestMyLiveListLocalMessage.setOffset(i);
        requestMyLiveListLocalMessage.setRn(i2);
        return requestMyLiveListLocalMessage;
    }

    public void sendMessage(int i, int i2) {
        MessageManager.getInstance().sendMessage(createMessage(i, i2));
    }

    public void sendGetCacheMessage(int i, int i2) {
        MessageManager.getInstance().sendMessage(createLocalMessage(i, i2));
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putInt(CARD_TYPE, this.mTabType);
        bundle.putInt(START_POSITION, this.mStart);
        bundle.putInt(PAGE_NUM, this.mPageNum);
    }
}
