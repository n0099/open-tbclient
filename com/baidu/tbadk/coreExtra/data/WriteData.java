package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
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
    private WriteImagesInfo baobaoImagesInfo;
    private boolean isAd;
    private boolean isBabaoPosted;
    private LiveCardData liveCardData;
    private String mBaobaoContent;
    private String mContent;
    private int mDuringTime;
    private String mFloor;
    private int mFloorNum;
    private String mForumId;
    private String mForumName;
    private boolean mHaveDraft;
    private boolean mIsAddition;
    private boolean mIsBaobao;
    private boolean mIsFrsReply;
    private boolean mIsNoTitle;
    private String mThreadId;
    private String mTitle;
    private int mType;
    private String mVcode;
    private String mVcodeMD5;
    private String mVcodeUrl;
    private String mVoiceMd5;
    private WriteImagesInfo writeImagesInfo;

    public boolean isBabaoPosted() {
        return this.isBabaoPosted;
    }

    public void setBabaoPosted(boolean z) {
        this.isBabaoPosted = z;
    }

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
        this.liveCardData = null;
        this.mIsBaobao = false;
        setIsAd(false);
    }

    public WriteData(int i) {
        this.mType = i;
        this.mTitle = null;
        this.mContent = null;
    }

    public boolean hasContentToSave() {
        if (i.b(this.mContent) && i.b(this.mTitle)) {
            if (this.writeImagesInfo == null || this.writeImagesInfo.size() <= 0) {
                if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
                    return this.liveCardData != null && this.liveCardData.isModifyTime();
                }
                return true;
            }
            return true;
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
            jSONObject.put("mIsBaobao", this.mIsBaobao);
            if (this.liveCardData != null) {
                jSONObject.put("livePostInfo", this.liveCardData.toDraftJson());
            }
            if (this.writeImagesInfo != null) {
                jSONObject.put("writeImagesInfo", this.writeImagesInfo.toJson());
            }
            if (this.baobaoImagesInfo != null) {
                jSONObject.put("baobaoImagesInfo", this.baobaoImagesInfo.toJson());
            }
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    public static WriteData fromDraftString(String str) {
        if (i.b(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WriteData writeData = new WriteData();
            writeData.mType = jSONObject.optInt("mType");
            writeData.mTitle = jSONObject.optString("mTitle", null);
            writeData.mContent = jSONObject.optString("mContent", null);
            writeData.mThreadId = jSONObject.optString("mThreadId", null);
            writeData.mIsBaobao = jSONObject.optBoolean("mIsBaobao");
            JSONObject optJSONObject = jSONObject.optJSONObject("livePostInfo");
            if (optJSONObject != null) {
                writeData.liveCardData = new LiveCardData();
                writeData.liveCardData.parseDraftJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("writeImagesInfo");
            if (optJSONObject2 != null) {
                writeData.writeImagesInfo = new WriteImagesInfo();
                writeData.writeImagesInfo.parseJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("baobaoImagesInfo");
            if (optJSONObject3 != null) {
                writeData.baobaoImagesInfo = new WriteImagesInfo();
                writeData.baobaoImagesInfo.parseJson(optJSONObject3);
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

    public void setIsBaobao(boolean z) {
        this.mIsBaobao = z;
    }

    public boolean getIsBaobaoImageUploaded() {
        if (getIsBaobao()) {
            LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
            for (int i = 0; i < chosedFiles.size(); i++) {
                if (chosedFiles.get(i).isAlreadyUploadedToServer()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean getIsBaobao() {
        if (this.baobaoImagesInfo == null || this.baobaoImagesInfo.size() <= 0) {
            return false;
        }
        return this.mIsBaobao;
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

    public WriteImagesInfo getBaobaoImagesInfo() {
        return this.baobaoImagesInfo;
    }

    public void setBaobaoImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.baobaoImagesInfo = writeImagesInfo;
    }

    public boolean isSubFloor() {
        return this.mType == 2;
    }

    public boolean isHasImages() {
        boolean z;
        if (isAddition()) {
            z = true;
        } else {
            z = !isSubFloor();
        }
        return z && this.writeImagesInfo != null && this.writeImagesInfo.size() > 0;
    }

    public void deleteUploadedTempImages() {
        int i;
        int i2;
        try {
            if (isHasImages()) {
                LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
                int i3 = 0;
                while (i3 < chosedFiles.size()) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i3);
                    if (imageFileInfo.isTempFile() && imageFileInfo.isAlreadyUploadedToServer() && !i.b(imageFileInfo.getFilePath())) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                    if (imageFileInfo.isAlreadyUploadedToServer()) {
                        chosedFiles.remove(i3);
                        i2 = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2 + 1;
                }
            }
            if (this.mIsBaobao && this.baobaoImagesInfo != null) {
                LinkedList<ImageFileInfo> chosedFiles2 = this.baobaoImagesInfo.getChosedFiles();
                int i4 = 0;
                while (i4 < chosedFiles2.size()) {
                    ImageFileInfo imageFileInfo2 = chosedFiles2.get(i4);
                    if (imageFileInfo2.isAlreadyUploadedToServer() && !i.b(imageFileInfo2.getFilePath())) {
                        File file2 = new File(imageFileInfo2.getFilePath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                    if (imageFileInfo2.isAlreadyUploadedToServer()) {
                        chosedFiles2.remove(i4);
                        i = i4 - 1;
                    } else {
                        i = i4;
                    }
                    i4 = i + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getImagesCodeForPost() {
        if (!isHasImages() && !this.mIsBaobao) {
            return "";
        }
        LinkedList linkedList = new LinkedList();
        if (isHasImages() && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null) {
            linkedList.addAll(this.writeImagesInfo.getChosedFiles());
        }
        if (this.mIsBaobao && this.baobaoImagesInfo != null && this.baobaoImagesInfo.getChosedFiles() != null) {
            linkedList.addAll(this.baobaoImagesInfo.getChosedFiles());
        }
        StringBuilder sb = new StringBuilder(linkedList.size() * 50);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) linkedList.get(i2);
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

    public boolean isAddition() {
        return this.mIsAddition;
    }

    public void setIsAddition(boolean z) {
        this.mIsAddition = z;
    }

    public boolean isNoTitle() {
        return this.mIsNoTitle;
    }

    public void setIsNoTitle(boolean z) {
        this.mIsNoTitle = z;
    }

    public boolean isFrsReply() {
        return this.mIsFrsReply;
    }

    public void setIsFrsReply(boolean z) {
        this.mIsFrsReply = z;
    }

    public LiveCardData getLiveCardData() {
        return this.liveCardData;
    }

    public void setLiveCardData(LiveCardData liveCardData) {
        this.liveCardData = liveCardData;
    }

    public String getBaobaoContent() {
        return this.mBaobaoContent;
    }

    public void setBaobaoContent(String str) {
        this.mBaobaoContent = str;
    }
}
