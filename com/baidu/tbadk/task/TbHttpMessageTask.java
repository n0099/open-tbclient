package com.baidu.tbadk.task;

import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes.dex */
public class TbHttpMessageTask extends HttpMessageTask {
    private boolean mIsBDImage;
    private boolean mIsBaiduServer;
    private boolean mIsFromCDN;
    private boolean mIsNeedAddCommenParam;
    private boolean mIsNeedLogin;
    private boolean mIsNeedTbs;
    private boolean mIsUseCurrentBDUSS;

    public TbHttpMessageTask(int i, String str) {
        super(i, str);
        this.mIsNeedTbs = false;
        this.mIsUseCurrentBDUSS = true;
        this.mIsNeedAddCommenParam = true;
        this.mIsBaiduServer = true;
        this.mIsNeedLogin = false;
    }

    public boolean isBDImage() {
        return this.mIsBDImage;
    }

    public boolean isFromCDN() {
        return this.mIsFromCDN;
    }

    public boolean isNeedTbs() {
        return this.mIsNeedTbs;
    }

    public void setIsNeedTbs(boolean z) {
        this.mIsNeedTbs = z;
    }

    public boolean isUseCurrentBDUSS() {
        return this.mIsUseCurrentBDUSS;
    }

    public void setIsUseCurrentBDUSS(boolean z) {
        this.mIsUseCurrentBDUSS = z;
    }

    public boolean isNeedAddCommenParam() {
        return this.mIsNeedAddCommenParam;
    }

    public void setIsNeedAddCommenParam(boolean z) {
        this.mIsNeedAddCommenParam = z;
    }

    public boolean isBaiduServer() {
        return this.mIsBaiduServer;
    }

    public boolean isNeedLogin() {
        return this.mIsNeedLogin;
    }

    public void setIsNeedLogin(boolean z) {
        this.mIsNeedLogin = z;
    }
}
