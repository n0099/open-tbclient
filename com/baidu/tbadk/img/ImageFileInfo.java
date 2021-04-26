package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.a;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.facebook.imagepipeline.producers.ProducerConstants;
import d.a.c.e.l.d;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ImageFileInfo extends MediaFileInfo {
    public static final int IMAGE_TYPE_EMOTION = 1;
    public static final int IMAGE_TYPE_NORMAL = 0;
    public String _cacheKey_all;
    public String _cacheKey_page;
    public String albumId;
    public String contentUriStr;
    public String extra;
    public String filePath;
    public boolean hasAddPostQualityAction;
    public int height;
    public boolean isFromCamera;
    public boolean isGif;
    public boolean isLong;
    public boolean isOrginalBitmapShared;
    public boolean isTempFile;
    public String modifyTime;
    public Bitmap orginalBitmap;
    public LinkedList<ImageOperation> pageActionsList;
    public LinkedList<ImageOperation> persistActionsList;
    public String serverImageCode;
    public ImageUploadResult.picInfo serverPicInfo;
    public int width;
    public int mCount = 0;
    public int mImageType = 0;
    public boolean isFromMoreForum = false;

    public void addPageAction(ImageOperation imageOperation) {
        if (this.pageActionsList == null) {
            this.pageActionsList = new LinkedList<>();
        }
        this.pageActionsList.add(imageOperation);
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void addPersistAction(ImageOperation imageOperation) {
        if (this.persistActionsList == null) {
            this.persistActionsList = new LinkedList<>();
        }
        this.persistActionsList.add(imageOperation);
        this.serverImageCode = null;
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void applayRotatePageActionToPersistAction(ImageFileInfo imageFileInfo) {
        if (getPageActionsList() != null) {
            Iterator<ImageOperation> it = getPageActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("rotate".equals(next.actionName)) {
                    if (imageFileInfo != null) {
                        imageFileInfo.setIsGif(false);
                    }
                    addPersistAction(next);
                }
            }
        }
    }

    public void clearAllActions() {
        LinkedList<ImageOperation> linkedList = this.persistActionsList;
        if (linkedList != null) {
            linkedList.clear();
            this.serverImageCode = null;
        }
        LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
        if (linkedList2 != null) {
            linkedList2.clear();
        }
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void clearPageActions() {
        LinkedList<ImageOperation> linkedList = this.pageActionsList;
        if (linkedList != null) {
            linkedList.clear();
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public ImageFileInfo cloneWithoutFilterAction(boolean z) {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(getFilePath());
        imageFileInfo.setContentUriStr(getContentUriStr());
        imageFileInfo.setModifyTime(getModifyTime());
        if (getPageActionsList() != null) {
            Iterator<ImageOperation> it = getPageActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if (!CloudControlRequest.REQUEST_KEY_FILTER.equals(next.actionName) && (!z || !"resize".equals(next.actionName))) {
                    imageFileInfo.addPageAction(next);
                }
            }
        }
        if (getPersistActionsList() != null) {
            Iterator<ImageOperation> it2 = getPersistActionsList().iterator();
            while (it2.hasNext()) {
                ImageOperation next2 = it2.next();
                if (!CloudControlRequest.REQUEST_KEY_FILTER.equals(next2.actionName) && (!z || !"resize".equals(next2.actionName))) {
                    imageFileInfo.addPageAction(next2);
                }
            }
        }
        imageFileInfo.setIsGif(isGif());
        imageFileInfo.setIsLong(isLong());
        imageFileInfo.setIsFromCamera(isFromCamera());
        imageFileInfo.setImageType(getImageType());
        return imageFileInfo;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public String getContentUriStr() {
        return this.contentUriStr;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getImageType() {
        return this.mImageType;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public Bitmap getOrginalBitmap() {
        return this.orginalBitmap;
    }

    public LinkedList<ImageOperation> getPageActionsList() {
        return this.pageActionsList;
    }

    public LinkedList<ImageOperation> getPersistActionsList() {
        return this.persistActionsList;
    }

    public String getServerImageCode() {
        return this.serverImageCode;
    }

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        return 0;
    }

    public boolean hasActions(boolean z) {
        LinkedList<ImageOperation> linkedList;
        if (this.persistActionsList == null && this.pageActionsList == null) {
            return false;
        }
        if (!z || (linkedList = this.persistActionsList) == null || linkedList.isEmpty()) {
            LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
            if (linkedList2 == null) {
                return false;
            }
            return !linkedList2.isEmpty();
        }
        return true;
    }

    public boolean hasActionsWithoutResize() {
        if (this.persistActionsList == null && this.pageActionsList == null) {
            return false;
        }
        LinkedList<ImageOperation> linkedList = this.persistActionsList;
        if (linkedList != null && !linkedList.isEmpty()) {
            Iterator<ImageOperation> it = this.persistActionsList.iterator();
            while (it.hasNext()) {
                if (!"resize".equals(it.next().actionName)) {
                    return true;
                }
            }
        }
        LinkedList<ImageOperation> linkedList2 = this.pageActionsList;
        if (linkedList2 != null && !linkedList2.isEmpty()) {
            Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
            while (it2.hasNext()) {
                if (!"resize".equals(it2.next().actionName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAlreadyUploadedToServer() {
        return !k.isEmpty(this.serverImageCode);
    }

    public boolean isFromCamera() {
        return this.isFromCamera;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public boolean isHasAddPostQualityAction() {
        return this.hasAddPostQualityAction;
    }

    public boolean isLong() {
        return this.isLong;
    }

    public boolean isOrginalBitmapShared() {
        return this.isOrginalBitmapShared;
    }

    public boolean isTempFile() {
        return this.isTempFile;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.filePath = jSONObject.optString("filePath", "");
        this.albumId = jSONObject.optString("albumId", null);
        this.contentUriStr = jSONObject.optString("contentUriStr", null);
        this.isTempFile = jSONObject.optBoolean("isTempFile", false);
        this.serverImageCode = jSONObject.optString("serverImageCode", null);
        this.modifyTime = jSONObject.optString("modifyTime");
        JSONArray optJSONArray = jSONObject.optJSONArray("actionsList");
        this.persistActionsList = new LinkedList<>();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                ImageOperation imageOperation = new ImageOperation();
                imageOperation.parseJson(optJSONArray.optJSONObject(i2));
                this.persistActionsList.add(imageOperation);
            }
        }
        this.hasAddPostQualityAction = jSONObject.optBoolean("hasAddPostQualityAction", false);
        this._cacheKey_all = null;
        this._cacheKey_page = null;
        ImageUploadResult.picInfo picinfo = new ImageUploadResult.picInfo();
        this.serverPicInfo = picinfo;
        picinfo.parseJson(jSONObject.optJSONObject("serverPicInfo"));
        this.isGif = jSONObject.optBoolean("isGif", false);
        this.isLong = jSONObject.optBoolean("isLong", false);
        this.isFromCamera = jSONObject.optBoolean("isFromCamera", false);
        this.mImageType = jSONObject.optInt(ProducerConstants.EXTRA_IMAGE_TYPE, 0);
    }

    public void setAlbumnId(String str) {
        this.albumId = str;
    }

    public void setContentUriStr(String str) {
        this.contentUriStr = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setHasAddPostQualityAction(boolean z) {
        this.hasAddPostQualityAction = z;
    }

    public void setImageType(int i2) {
        this.mImageType = i2;
    }

    public void setIsFromCamera(boolean z) {
        this.isFromCamera = z;
    }

    public void setIsGif(boolean z) {
        this.isGif = z;
    }

    public void setIsLong(boolean z) {
        this.isLong = z;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public void setOrginalBitmap(Bitmap bitmap, boolean z) {
        this.orginalBitmap = bitmap;
        this.isOrginalBitmapShared = z;
    }

    public void setPageActionsList(LinkedList<ImageOperation> linkedList) {
        this.pageActionsList = linkedList;
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void setPersistActionsList(LinkedList<ImageOperation> linkedList) {
        this.persistActionsList = linkedList;
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void setServerImageCode(String str) {
        this.serverImageCode = str;
    }

    public void setTempFile(boolean z) {
        this.isTempFile = z;
    }

    public String toCachedKey(boolean z) {
        if (getImageType() == 1) {
            return d.h().g(this.filePath, 20);
        }
        if (z) {
            if (this._cacheKey_all == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("persist_");
                sb.append(this.filePath);
                if (ListUtils.getCount(this.persistActionsList) > 0) {
                    Iterator<ImageOperation> it = this.persistActionsList.iterator();
                    while (it.hasNext()) {
                        ImageOperation next = it.next();
                        if (next != null) {
                            sb.append(':');
                            sb.append(next.actionName);
                            sb.append(a.f1873h);
                            sb.append(next.actionParam);
                        }
                    }
                }
                if (ListUtils.getCount(this.pageActionsList) > 0) {
                    Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
                    while (it2.hasNext()) {
                        ImageOperation next2 = it2.next();
                        if (next2 != null) {
                            sb.append(':');
                            sb.append(next2.actionName);
                            sb.append(a.f1873h);
                            sb.append(next2.actionParam);
                        }
                    }
                }
                this._cacheKey_all = sb.toString();
            }
            return this._cacheKey_all;
        }
        if (this._cacheKey_page == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("page_");
            sb2.append(this.filePath);
            if (this.pageActionsList != null) {
                for (int i2 = 0; i2 < this.pageActionsList.size(); i2++) {
                    ImageOperation imageOperation = this.pageActionsList.get(i2);
                    sb2.append(':');
                    sb2.append(imageOperation.actionName);
                    sb2.append(a.f1873h);
                    sb2.append(imageOperation.actionParam);
                }
            }
            this._cacheKey_page = sb2.toString();
        }
        return this._cacheKey_page;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filePath", this.filePath);
            if (this.albumId != null) {
                jSONObject.put("albumId", this.albumId);
            }
            if (!TextUtils.isEmpty(this.contentUriStr)) {
                jSONObject.put("contentUriStr", this.contentUriStr);
            }
            jSONObject.put("isTempFile", this.isTempFile);
            if (this.serverImageCode != null) {
                jSONObject.put("serverImageCode", this.serverImageCode);
            }
            if (!StringUtils.isNull(this.modifyTime)) {
                jSONObject.put("modifyTime", this.modifyTime);
            }
            if (this.persistActionsList != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.persistActionsList.size(); i2++) {
                    jSONArray.put(this.persistActionsList.get(i2).toJson());
                }
                jSONObject.put("actionsList", jSONArray);
            }
            jSONObject.put("hasAddPostQualityAction", this.hasAddPostQualityAction);
            if (this.serverPicInfo != null) {
                jSONObject.put("serverPicInfo", this.serverPicInfo.toJson());
            }
            jSONObject.put("isGif", this.isGif);
            jSONObject.put("isLong", this.isLong);
            jSONObject.put("isFromCamera", this.isFromCamera);
            jSONObject.put(ProducerConstants.EXTRA_IMAGE_TYPE, this.mImageType);
            return jSONObject;
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }
}
