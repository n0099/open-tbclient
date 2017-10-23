package com.baidu.tbadk.download;

import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.io.Serializable;
/* loaded from: classes.dex */
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
    public static final int FILE_DOWNLOAD_TYPE_EMOYION_APCKAGE = 11;
    public static final int FILE_DOWNLOAD_TYPE_MANGA = 14;
    public static final int FILE_DOWNLOAD_TYPE_MUSIC = 17;
    public static final int FILE_DOWNLOAD_TYPE_NORMAL = 10;
    public static final int FILE_DOWNLOAD_TYPE_NOVEL = 15;
    public static final int FILE_DOWNLOAD_TYPE_ORIGINAL_IMAGE = 13;
    private static final long serialVersionUID = 1402749061179345930L;
    private String action;
    private String app_icon;
    private transient d azQ;
    private String check;
    private String description;
    private DownloadStaticsData downloadStaticsData;
    private int errorCode;
    private int height;
    private String id;
    private boolean isForceDownload;
    private boolean isNeedInvokeApk;
    private boolean isNeedNotify;
    private long length;
    private Object mExtraData;
    private String name;
    private int notifyId;
    private String path;
    private int position;
    private long size;
    private int status;
    private String statusMsg;
    private String[] tag;
    private int type;
    private String url;
    private String user_name;
    private int width;

    public DownloadStaticsData getDownloadStaticsData() {
        return this.downloadStaticsData;
    }

    public void setDownloadStaticsData(DownloadStaticsData downloadStaticsData) {
        this.downloadStaticsData = downloadStaticsData;
    }

    public Object getExtra() {
        return this.mExtraData;
    }

    public void setExtra(Object obj) {
        this.mExtraData = obj;
    }

    public String getApp_icon() {
        return this.app_icon;
    }

    public void setApp_icon(String str) {
        this.app_icon = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String[] getTag() {
        return this.tag;
    }

    public void setTag(String[] strArr) {
        this.tag = strArr;
    }

    public DownloadData() {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.azQ = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
    }

    public DownloadData(String str) {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.azQ = null;
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
        this.azQ = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.url = str2;
    }

    public DownloadData(String str, String str2, String str3, d dVar) {
        this.status = 5;
        this.type = 10;
        this.length = 0L;
        this.size = 1L;
        this.width = 0;
        this.height = 0;
        this.statusMsg = null;
        this.azQ = null;
        this.position = 0;
        this.notifyId = 0;
        this.isNeedInvokeApk = true;
        this.isForceDownload = false;
        this.isNeedNotify = true;
        this.id = str;
        this.name = str2;
        this.url = str3;
        this.azQ = dVar;
        this.status = 5;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String getCheck() {
        return this.check;
    }

    public void setCheck(String str) {
        this.check = str;
    }

    public d getCallback() {
        return this.azQ;
    }

    public void setCallback(d dVar) {
        this.azQ = dVar;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setStatusMsg(String str) {
        this.statusMsg = str;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public void setNotifyId(int i) {
        this.notifyId = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public int getProcess() {
        if (getLength() > 0 && getSize() > 0) {
            return (int) ((getLength() * 100) / getSize());
        }
        return 0;
    }

    public boolean isNeedInvokeApk() {
        return this.isNeedInvokeApk;
    }

    public void setNeedInvokeApk(boolean z) {
        this.isNeedInvokeApk = z;
    }

    public boolean isForceDownload() {
        return this.isForceDownload;
    }

    public void setForceDownload(boolean z) {
        this.isForceDownload = z;
    }

    public boolean isNeedNotify() {
        return this.isNeedNotify;
    }

    public void setNeedNotify(boolean z) {
        this.isNeedNotify = z;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public Object clone() {
        try {
            return (DownloadData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
