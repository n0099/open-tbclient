package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageFileInfo extends MediaFileInfo {
    private String _cacheKey_all;
    private String _cacheKey_page;
    private String albumId;
    public String extra;
    private String filePath;
    private boolean hasAddPostQualityAction;
    public int height;
    private boolean isFromCamera;
    private boolean isGif;
    private boolean isLong;
    private boolean isOrginalBitmapShared;
    private boolean isTempFile;
    public int mCount = 0;
    public long mRotateType = 0;
    private String modifyTime;
    private Bitmap orginalBitmap;
    private LinkedList<ImageOperation> pageActionsList;
    private LinkedList<ImageOperation> persistActionsList;
    private String serverImageCode;
    public ImageUploadResult.picInfo serverPicInfo;
    public int width;

    public String toCachedKey(boolean z) {
        if (z) {
            if (this._cacheKey_all == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("persist_");
                sb.append(this.filePath);
                if (v.v(this.persistActionsList) > 0) {
                    Iterator<ImageOperation> it = this.persistActionsList.iterator();
                    while (it.hasNext()) {
                        ImageOperation next = it.next();
                        if (next != null) {
                            sb.append(':').append(next.actionName).append('=').append(next.actionParam);
                        }
                    }
                }
                if (v.v(this.pageActionsList) > 0) {
                    Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
                    while (it2.hasNext()) {
                        ImageOperation next2 = it2.next();
                        if (next2 != null) {
                            sb.append(':').append(next2.actionName).append('=').append(next2.actionParam);
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
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.pageActionsList.size()) {
                        break;
                    }
                    ImageOperation imageOperation = this.pageActionsList.get(i2);
                    sb2.append(':').append(imageOperation.actionName).append('=').append(imageOperation.actionParam);
                    i = i2 + 1;
                }
            }
            this._cacheKey_page = sb2.toString();
        }
        return this._cacheKey_page;
    }

    public void setOrginalBitmap(Bitmap bitmap, boolean z) {
        this.orginalBitmap = bitmap;
        this.isOrginalBitmapShared = z;
    }

    public void setModifyTime(String str) {
        this.modifyTime = str;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.filePath = jSONObject.optString("filePath", "");
            this.albumId = jSONObject.optString("albumId", null);
            this.isTempFile = jSONObject.optBoolean("isTempFile", false);
            this.serverImageCode = jSONObject.optString("serverImageCode", null);
            this.modifyTime = jSONObject.optString("modifyTime");
            JSONArray optJSONArray = jSONObject.optJSONArray("actionsList");
            this.persistActionsList = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ImageOperation imageOperation = new ImageOperation();
                    imageOperation.parseJson(optJSONArray.optJSONObject(i));
                    this.persistActionsList.add(imageOperation);
                }
            }
            this.hasAddPostQualityAction = jSONObject.optBoolean("hasAddPostQualityAction", false);
            this._cacheKey_all = null;
            this._cacheKey_page = null;
            this.serverPicInfo = new ImageUploadResult.picInfo();
            this.serverPicInfo.parseJson(jSONObject.optJSONObject("serverPicInfo"));
            this.isGif = jSONObject.optBoolean("isGif", false);
            this.isLong = jSONObject.optBoolean("isLong", false);
            this.isFromCamera = jSONObject.optBoolean("isFromCamera", false);
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("filePath", this.filePath);
            if (this.albumId != null) {
                jSONObject.put("albumId", this.albumId);
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
                for (int i = 0; i < this.persistActionsList.size(); i++) {
                    jSONArray.put(this.persistActionsList.get(i).toJson());
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
            return jSONObject;
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public void setAlbumnId(String str) {
        this.albumId = str;
    }

    public boolean isTempFile() {
        return this.isTempFile;
    }

    public void setTempFile(boolean z) {
        this.isTempFile = z;
    }

    public boolean hasActions(boolean z) {
        if (this.persistActionsList == null && this.pageActionsList == null) {
            return false;
        }
        if (!z || this.persistActionsList == null || this.persistActionsList.isEmpty()) {
            if (this.pageActionsList != null) {
                return this.pageActionsList.isEmpty() ? false : true;
            }
            return false;
        }
        return true;
    }

    public boolean hasActionsWithoutResize() {
        if (this.persistActionsList == null && this.pageActionsList == null) {
            return false;
        }
        if (this.persistActionsList != null && !this.persistActionsList.isEmpty()) {
            Iterator<ImageOperation> it = this.persistActionsList.iterator();
            while (it.hasNext()) {
                if (!"resize".equals(it.next().actionName)) {
                    return true;
                }
            }
        }
        if (this.pageActionsList != null && !this.pageActionsList.isEmpty()) {
            Iterator<ImageOperation> it2 = this.pageActionsList.iterator();
            while (it2.hasNext()) {
                if (!"resize".equals(it2.next().actionName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public LinkedList<ImageOperation> getPageActionsList() {
        return this.pageActionsList;
    }

    public void setPageActionsList(LinkedList<ImageOperation> linkedList) {
        this.pageActionsList = linkedList;
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public LinkedList<ImageOperation> getPersistActionsList() {
        return this.persistActionsList;
    }

    public void setPersistActionsList(LinkedList<ImageOperation> linkedList) {
        this.persistActionsList = linkedList;
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

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

    public void clearAllActions() {
        if (this.persistActionsList != null) {
            this.persistActionsList.clear();
            this.serverImageCode = null;
        }
        if (this.pageActionsList != null) {
            this.pageActionsList.clear();
        }
        this._cacheKey_all = null;
        this._cacheKey_page = null;
    }

    public void clearPageActions() {
        if (this.pageActionsList != null) {
            this.pageActionsList.clear();
            this._cacheKey_all = null;
            this._cacheKey_page = null;
        }
    }

    public String getServerImageCode() {
        return this.serverImageCode;
    }

    public void setServerImageCode(String str) {
        this.serverImageCode = str;
    }

    public boolean isAlreadyUploadedToServer() {
        return !k.isEmpty(this.serverImageCode);
    }

    public Bitmap getOrginalBitmap() {
        return this.orginalBitmap;
    }

    public boolean isOrginalBitmapShared() {
        return this.isOrginalBitmapShared;
    }

    public boolean isHasAddPostQualityAction() {
        return this.hasAddPostQualityAction;
    }

    public void setHasAddPostQualityAction(boolean z) {
        this.hasAddPostQualityAction = z;
    }

    public void setIsGif(boolean z) {
        this.isGif = z;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public long getRotateType() {
        return this.mRotateType;
    }

    public void setRotateType(long j) {
        this.mRotateType = j;
    }

    public void setIsLong(boolean z) {
        this.isLong = z;
    }

    public boolean isLong() {
        return this.isLong;
    }

    public void setIsFromCamera(boolean z) {
        this.isFromCamera = z;
    }

    public boolean isFromCamera() {
        return this.isFromCamera;
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

    public ImageFileInfo cloneWithoutFilterAction(boolean z) {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(getFilePath());
        imageFileInfo.setModifyTime(getModifyTime());
        if (getPageActionsList() != null) {
            Iterator<ImageOperation> it = getPageActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if (!"filter".equals(next.actionName) && (!z || !"resize".equals(next.actionName))) {
                    imageFileInfo.addPageAction(next);
                }
            }
        }
        if (getPersistActionsList() != null) {
            Iterator<ImageOperation> it2 = getPersistActionsList().iterator();
            while (it2.hasNext()) {
                ImageOperation next2 = it2.next();
                if (!"filter".equals(next2.actionName) && (!z || !"resize".equals(next2.actionName))) {
                    imageFileInfo.addPageAction(next2);
                }
            }
        }
        imageFileInfo.setIsGif(isGif());
        imageFileInfo.setIsLong(isLong());
        imageFileInfo.setIsFromCamera(isFromCamera());
        return imageFileInfo;
    }

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        return 0;
    }
}
