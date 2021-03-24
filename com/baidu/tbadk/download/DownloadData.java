package com.baidu.tbadk.download;

import com.baidu.tieba.recapp.report.DownloadStaticsData;
import d.b.h0.v.c;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class DownloadData implements Serializable, Cloneable {
    public static final int FILE_DOWNLOAD_STATUS_CANCEL = 4;
    public static final int FILE_DOWNLOAD_STATUS_DOWNLOADING = 1;
    public static final int FILE_DOWNLOAD_STATUS_EXIST = 3;
    public static final int FILE_DOWNLOAD_STATUS_FAILED = 2;
    public static final int FILE_DOWNLOAD_STATUS_INIT = 5;
    public static final int FILE_DOWNLOAD_STATUS_INSTALLED = 8;
    public static final int FILE_DOWNLOAD_STATUS_PAUSE = 7;
    public static final int FILE_DOWNLOAD_STATUS_SUCEED = 0;
    public static final int FILE_DOWNLOAD_STATUS_UNDOWNLOAD = 6;
    public static final int FILE_DOWNLOAD_TYPE_ALA_IM_RECORD = 16;
    public static final int FILE_DOWNLOAD_TYPE_APP = 12;
    public static final int FILE_DOWNLOAD_TYPE_AR_RESOURCE = 20;
    public static final int FILE_DOWNLOAD_TYPE_DYNAMIC = 19;
    public static final int FILE_DOWNLOAD_TYPE_EMOYION_APCKAGE = 11;
    public static final int FILE_DOWNLOAD_TYPE_MANGA = 14;
    public static final int FILE_DOWNLOAD_TYPE_MUSIC = 17;
    public static final int FILE_DOWNLOAD_TYPE_NORMAL = 10;
    public static final int FILE_DOWNLOAD_TYPE_NOVEL = 15;
    public static final int FILE_DOWNLOAD_TYPE_ORIGINAL_IMAGE = 13;
    public static final int FILE_DOWNLOAD_TYPE_PENDANT = 18;
    public static final long serialVersionUID = 1402749061179345930L;
    public String action;
    public String app_icon;
    public transient c callback;
    public String check;
    public String description;
    public DownloadStaticsData downloadStaticsData;
    public int errorCode;
    public int height;
    public String id;
    public boolean isForceDownload;
    public boolean isNeedInvokeApk;
    public boolean isNeedNotify;
    public long length;
    public Object mExtraData;
    public String name;
    public int notifyId;
    public String path;
    public int position;
    public long size;
    public int status;
    public String statusMsg;
    public String[] tag;
    public int type;
    public String url;
    public String user_name;
    public int width;

    public DownloadData() {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
    }

    public Object clone() {
        try {
            return (DownloadData) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getAction() {
        return this.action;
    }

    public String getApp_icon() {
        return this.app_icon;
    }

    public c getCallback() {
        return this.callback;
    }

    public String getCheck() {
        return this.check;
    }

    public String getDescription() {
        return this.description;
    }

    public DownloadStaticsData getDownloadStaticsData() {
        return this.downloadStaticsData;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public Object getExtra() {
        return this.mExtraData;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public long getLength() {
        return this.length;
    }

    public String getName() {
        return this.name;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }

    public int getProcess() {
        if (getLength() > 0 && getSize() > 0) {
            return (int) ((getLength() * 100) / getSize());
        }
        return 0;
    }

    public long getSize() {
        return this.size;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public String[] getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isForceDownload() {
        return this.isForceDownload;
    }

    public boolean isNeedInvokeApk() {
        return this.isNeedInvokeApk;
    }

    public boolean isNeedNotify() {
        return this.isNeedNotify;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setApp_icon(String str) {
        this.app_icon = str;
    }

    public void setCallback(c cVar) {
        this.callback = cVar;
    }

    public void setCheck(String str) {
        this.check = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public void setExtra(Object obj) {
        this.mExtraData = obj;
    }

    public void setForceDownload(boolean z) {
        this.isForceDownload = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedInvokeApk(boolean z) {
        this.isNeedInvokeApk = z;
    }

    public void setNeedNotify(boolean z) {
        this.isNeedNotify = z;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }

    public void setTag(String[] strArr) {
        this.tag = strArr;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public DownloadData(String str) {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
    }

    public DownloadData(String str, String str2) {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.url = str2;
    }

    public DownloadData(String str, String str2, String str3, c cVar) {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.callback = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.callback = cVar;
        this.status = 5;
    }
}
