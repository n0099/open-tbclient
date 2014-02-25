package com.baidu.tieba.data;

import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteData implements Serializable {
    public static final int NEW = 0;
    public static final int REPLY = 1;
    public static final int REPLY_FLOOR = 2;
    public static final String THREAD_TYPE_LBS = "7";
    private boolean isAd;
    private String mContent;
    private int mDuringTime;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private boolean mHaveDraft;
    private String mThreadId;
    private String mTitle;
    private int mType;
    private String mVcode;
    private String mVcodeMD5;
    private String mVcodeUrl;
    private String mVoiceMd5;
    private WriteImagesInfo writeImagesInfo;

    public WriteData() {
        this.mType = 0;
        this.mForumId = null;
        this.mForumName = null;
        this.mThreadId = null;
        this.mFloor = null;
        this.mFloorNum = 0;
        this.mTitle = null;
        this.mContent = null;
        this.mVcode = null;
        this.mVcodeMD5 = null;
        this.mVcodeUrl = null;
        this.mVoiceMd5 = null;
        this.mHaveDraft = false;
        setIsAd(false);
    }

    public WriteData(int i) {
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
    }

    public boolean hasContentToSave() {
        if (com.baidu.adp.lib.util.h.b(this.mContent) && com.baidu.adp.lib.util.h.b(this.mTitle)) {
            return this.writeImagesInfo != null && this.writeImagesInfo.size() > 0;
        }
        return true;
    }

    public String toDraftString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mType", this.mType);
            jSONObject.put("mTitle", this.mTitle);
            jSONObject.put("mContent", this.mContent);
            jSONObject.put("mThreadId", this.mThreadId);
            if (this.writeImagesInfo != null) {
                jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public static WriteData fromDraftString(String str) {
        if (com.baidu.adp.lib.util.h.b(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WriteData writeData = new WriteData();
            writeData.mType = jSONObject.optInt("mType");
            writeData.mTitle = jSONObject.optString("mTitle", null);
            writeData.mContent = jSONObject.optString("mContent", null);
            writeData.mThreadId = jSONObject.optString("mThreadId", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("writeImagesInfo");
            if (optJSONObject != null) {
                writeData.writeImagesInfo = new WriteImagesInfo();
                writeData.writeImagesInfo.parseJson(optJSONObject);
            }
            return writeData;
        } catch (Exception e) {
            return null;
        }
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void setFloor(String str) {
        this.mFloor = str;
    }

    public String getFloor() {
        return this.mFloor;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumName(String str) {
        this.mForumName = str;
    }

    public String getForumName() {
        return this.mForumName;
    }

    public void setFloorNum(int i) {
        this.mFloorNum = i;
    }

    public int getFloorNum() {
        return this.mFloorNum;
    }

    public void setVcode(String str) {
        this.mVcode = str;
    }

    public String getVcode() {
        return this.mVcode;
    }

    public void setVcodeMD5(String str) {
        this.mVcodeMD5 = str;
    }

    public String getVcodeMD5() {
        return this.mVcodeMD5;
    }

    public String getVcodeUrl() {
        return this.mVcodeUrl;
    }

    public void setVcodeUrl(String str) {
        this.mVcodeUrl = str;
    }

    public void setHaveDraft(boolean z) {
        this.mHaveDraft = z;
    }

    public boolean getHaveDraft() {
        return this.mHaveDraft;
    }

    public boolean getIsAd() {
        return this.isAd;
    }

    public void setIsAd(boolean z) {
        this.isAd = z;
    }

    public void setVoice(String str) {
        this.mVoiceMd5 = str;
    }

    public String getVoice() {
        return this.mVoiceMd5;
    }

    public void setVoiceDuringTime(int i) {
        this.mDuringTime = i;
    }

    public int getVoiceDuringTime() {
        return this.mDuringTime;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.writeImagesInfo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.writeImagesInfo = writeImagesInfo;
    }

    public boolean isSubFloor() {
        return this.mType == 2;
    }

    public boolean isHasImages() {
        return (isSubFloor() || this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) ? false : true;
    }

    public void deleteUploadedTempImages() {
        if (isHasImages()) {
            LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !com.baidu.adp.lib.util.h.b(imageFileInfo.getFilePath())) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    if (imageFileInfo.isAlreadyUploadedToServer()) {
                        chosedFiles.remove(i2);
                        i2--;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public String getImagesCodeForPost() {
        if (!isHasImages()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(this.writeImagesInfo.size() * 50);
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < chosedFiles.size()) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                if (imageFileInfo.isAlreadyUploadedToServer()) {
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    sb.append(imageFileInfo.getServerImageCode());
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }
}
