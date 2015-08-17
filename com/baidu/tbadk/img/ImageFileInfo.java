package com.baidu.tbadk.img;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.img.effect.ImageOperation;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageFileInfo implements Serializable {
    private String _cacheKey_all;
    private String _cacheKey_page;
    private String albumId;
    private String filePath;
    private boolean hasAddPostQualityAction;
    private boolean isOrginalBitmapShared;
    private boolean isTempFile;
    private Bitmap orginalBitmap;
    private LinkedList<ImageOperation> pageActionsList;
    private LinkedList<ImageOperation> persistActionsList;
    private String serverImageCode;

    public String toCachedKey(boolean z) {
        int i = 0;
        if (z) {
            if (this._cacheKey_all == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("persist_");
                sb.append(this.filePath);
                if (this.persistActionsList != null) {
                    for (int i2 = 0; i2 < this.persistActionsList.size(); i2++) {
                        ImageOperation imageOperation = this.persistActionsList.get(i2);
                        sb.append(':').append(imageOperation.actionName).append('=').append(imageOperation.actionParam);
                    }
                }
                if (this.pageActionsList != null) {
                    while (i < this.pageActionsList.size()) {
                        ImageOperation imageOperation2 = this.pageActionsList.get(i);
                        sb.append(':').append(imageOperation2.actionName).append('=').append(imageOperation2.actionParam);
                        i++;
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
                while (i < this.pageActionsList.size()) {
                    ImageOperation imageOperation3 = this.pageActionsList.get(i);
                    sb2.append(':').append(imageOperation3.actionName).append('=').append(imageOperation3.actionParam);
                    i++;
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

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.filePath = jSONObject.optString("filePath", "");
            this.albumId = jSONObject.optString("albumId", null);
            this.isTempFile = jSONObject.optBoolean("isTempFile", false);
            this.serverImageCode = jSONObject.optString("serverImageCode", null);
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
            if (this.persistActionsList != null) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.persistActionsList.size()) {
                        break;
                    }
                    jSONArray.put(this.persistActionsList.get(i2).toJson());
                    i = i2 + 1;
                }
                jSONObject.put("actionsList", jSONArray);
            }
            jSONObject.put("hasAddPostQualityAction", this.hasAddPostQualityAction);
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
            return (this.pageActionsList == null || this.pageActionsList.isEmpty()) ? false : true;
        }
        return true;
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
        return !j.isEmpty(this.serverImageCode);
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

    public void applayRotatePageActionToPersistAction() {
        if (getPageActionsList() != null) {
            Iterator<ImageOperation> it = getPageActionsList().iterator();
            while (it.hasNext()) {
                ImageOperation next = it.next();
                if ("rotate".equals(next.actionName)) {
                    addPersistAction(next);
                }
            }
        }
    }

    public ImageFileInfo cloneWithoutFilterAction(boolean z) {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(getFilePath());
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
        return imageFileInfo;
    }
}
