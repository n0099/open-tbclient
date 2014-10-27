package com.baidu.tieba.im.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.live.message.RequestHotLiveListLocalMessage;
import com.baidu.tbadk.live.message.RequestHotLiveListMessage;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class HotLiveListModel extends e {
    public static final int CARD_FORESHOW = 3;
    public static final int CARD_LIVING = 1;
    public static final int CARD_REVIEW = 2;
    private static final String CARD_TYPE = "card_type";
    public static final int IMAGE_HEIGHT = 70;
    public static final int IMAGE_WIDTH = 70;
    public static final int PAGE_LEN = 20;
    private static final String PAGE_NUM = "page_num";
    private static final String START_POSITION = "start_position";
    private final Map<String, Boolean> loaded;
    private BaseFragmentActivity mActivity;
    private int mCardType;
    private int mImageHeight;
    private int mImageWidth;
    private int mPageNum;
    private int mStart;
    private final Map<String, Boolean> useCache;

    public HotLiveListModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity);
        this.loaded = new HashMap();
        this.useCache = new HashMap();
        this.mActivity = baseFragmentActivity;
    }

    public void loaded(String str, boolean z) {
        this.loaded.put(str, true);
    }

    public boolean isLoad(String str) {
        Boolean bool = this.loaded.get(str);
        return bool != null && bool.booleanValue();
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public boolean isUseCache(String str) {
        Boolean bool = this.useCache.get(str);
        return bool != null && bool.booleanValue();
    }

    public void setUseCache(String str) {
        this.useCache.put(str, true);
    }

    public void setImageSize(Activity activity) {
        this.mImageWidth = m.dip2px(activity, 70.0f);
        this.mImageHeight = m.dip2px(activity, 70.0f);
    }

    public int getCardType() {
        return this.mCardType;
    }

    public void setCardType(int i) {
        this.mCardType = i;
    }

    public boolean isFirstLoad() {
        return this.mPageNum == 0;
    }

    public int getRequestType() {
        return this.mCardType;
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

    public void initWithIntent(Intent intent) {
        this.mCardType = 1;
    }

    public void initWithBundle(Bundle bundle) {
        this.mCardType = bundle.getInt(CARD_TYPE);
        this.mStart = bundle.getInt(START_POSITION);
        this.mPageNum = bundle.getInt(PAGE_NUM);
    }

    private RequestHotLiveListMessage createMessage(int i, int i2, int i3, int i4, int i5) {
        RequestHotLiveListMessage requestHotLiveListMessage = new RequestHotLiveListMessage();
        requestHotLiveListMessage.setType(i);
        requestHotLiveListMessage.setOffset(i2);
        requestHotLiveListMessage.setRn(i3);
        requestHotLiveListMessage.setWidth(i4);
        requestHotLiveListMessage.setHeight(i5);
        return requestHotLiveListMessage;
    }

    private RequestHotLiveListLocalMessage createLocalMessage(int i, int i2, int i3, int i4, int i5) {
        RequestHotLiveListLocalMessage requestHotLiveListLocalMessage = new RequestHotLiveListLocalMessage();
        requestHotLiveListLocalMessage.setType(i);
        requestHotLiveListLocalMessage.setOffset(i2);
        requestHotLiveListLocalMessage.setRn(i3);
        requestHotLiveListLocalMessage.setWidth(i4);
        requestHotLiveListLocalMessage.setHeight(i5);
        return requestHotLiveListLocalMessage;
    }

    public void sendMessage(int i, int i2, int i3, int i4, int i5) {
        this.mActivity.sendMessage(createMessage(i, i2, i3, i4, i5));
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        this.mActivity.registerListener(messageListener);
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }

    public void sendGetCacheMessage(int i, int i2, int i3, int i4, int i5) {
        this.mActivity.sendMessage(createLocalMessage(i, i2, i3, i4, i5));
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putInt(CARD_TYPE, this.mCardType);
        bundle.putInt(START_POSITION, this.mStart);
        bundle.putInt(PAGE_NUM, this.mPageNum);
    }
}
