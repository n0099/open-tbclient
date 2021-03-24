package com.baidu.tbadk.task;

import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes3.dex */
public class TbHttpMessageTask extends HttpMessageTask {
    public boolean mIsBDImage;
    public boolean mIsBaiduServer;
    public boolean mIsFromCDN;
    public boolean mIsNeedAddCommenParam;
    public boolean mIsNeedAddStatisticsParam;
    public boolean mIsNeedLogin;
    public boolean mIsNeedTbs;
    public boolean mIsUseCurrentBDUSS;

    public TbHttpMessageTask(int i, String str) {
        super(i, str);
        this.mIsNeedTbs = false;
        this.mIsUseCurrentBDUSS = true;
        this.mIsNeedAddStatisticsParam = true;
        this.mIsNeedAddCommenParam = true;
        this.mIsBaiduServer = true;
        this.mIsNeedLogin = false;
    }

    public boolean isBDImage() {
        return this.mIsBDImage;
    }

    public boolean isBaiduServer() {
        return this.mIsBaiduServer;
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public boolean isNeedAddCommenParam() {
        return this.mIsNeedAddCommenParam;
    }

    public boolean isNeedAddStatisticsParam() {
        return this.mIsNeedAddStatisticsParam;
    }

    public boolean isNeedLogin() {
        return this.mIsNeedLogin;
    }

    public boolean isNeedTbs() {
        return this.mIsNeedTbs;
    }

    public boolean isUseCurrentBDUSS() {
        return this.mIsUseCurrentBDUSS;
    }

    public void setIsBDImage(boolean z) {
        this.mIsBDImage = z;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setIsNeedAddCommenParam(boolean z) {
        this.mIsNeedAddCommenParam = z;
    }

    public void setIsNeedAddStatisticsParam(boolean z) {
        this.mIsNeedAddStatisticsParam = z;
    }

    public void setIsNeedLogin(boolean z) {
        this.mIsNeedLogin = z;
    }

    public void setIsNeedTbs(boolean z) {
        this.mIsNeedTbs = z;
    }

    public void setIsUseCurrentBDUSS(boolean z) {
        this.mIsUseCurrentBDUSS = z;
    }

    public void setmIsNBaiduServer(boolean z) {
        this.mIsBaiduServer = z;
    }
}
