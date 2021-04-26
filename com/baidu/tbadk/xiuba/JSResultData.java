package com.baidu.tbadk.xiuba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class JSResultData extends OrmObject implements Serializable {
    public static final String AUTH_KEY = "Bk87E*iWaZ4ORmQrCxVGOq+]-i!S*v";
    public static final int DOWNLOAD_FAIL = 0;
    public static final int DOWNLOAD_FINISH = 2;
    public static final int DOWNLOAD_START = 1;
    public static final String ERRORCODE_NO = "0";
    public static final String ERRORMSG_NO = "";
    public static final int INSTALL_SUCCESS = 1;
    public static final int IN_INSTALL_NO = 0;
    public static final int IN_INSTALL_YES = 1;
    public static final int STATUS_FAIL = 0;
    public static final int STATUS_SUCCESS = 1;
    public static final long serialVersionUID = -3999492409273265508L;
    public String errorCode;
    public String errorMsg;
    public Result result;
    public int status;

    /* loaded from: classes3.dex */
    public static final class Result extends OrmObject implements Serializable {
        public static final long serialVersionUID = 678301888552831958L;
        public String apkVersion;
        public int download;
        public int install;
        public int isInstall;

        public String getApkVersion() {
            return this.apkVersion;
        }

        public int getDownload() {
            return this.download;
        }

        public int getInstall() {
            return this.install;
        }

        public int getIsInstall() {
            return this.isInstall;
        }

        public void setApkVersion(String str) {
            this.apkVersion = str;
        }

        public void setDownload(int i2) {
            this.download = i2;
        }

        public void setInstall(int i2) {
            this.install = i2;
        }

        public void setIsInstall(int i2) {
            this.isInstall = i2;
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Result getResult() {
        return this.result;
    }

    public int getStatus() {
        return this.status;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }
}
