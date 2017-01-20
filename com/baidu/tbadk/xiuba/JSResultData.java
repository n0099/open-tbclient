package com.baidu.tbadk.xiuba;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
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
    private static final long serialVersionUID = -3999492409273265508L;
    private String errorCode;
    private String errorMsg;
    private Result result;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    /* loaded from: classes.dex */
    public static final class Result extends OrmObject implements Serializable {
        private static final long serialVersionUID = 678301888552831958L;
        private String apkVersion;
        private int download;
        private int install;
        private int isInstall;

        public int getIsInstall() {
            return this.isInstall;
        }

        public void setIsInstall(int i) {
            this.isInstall = i;
        }

        public String getApkVersion() {
            return this.apkVersion;
        }

        public void setApkVersion(String str) {
            this.apkVersion = str;
        }

        public int getInstall() {
            return this.install;
        }

        public void setInstall(int i) {
            this.install = i;
        }

        public int getDownload() {
            return this.download;
        }

        public void setDownload(int i) {
            this.download = i;
        }
    }
}
