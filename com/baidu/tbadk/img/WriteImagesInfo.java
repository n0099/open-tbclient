package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.l;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteImagesInfo extends OrmObject implements Serializable {
    private LinkedList<ImageFileInfo> chosedFiles;
    private boolean isEnableChooseOriginalImg;
    private boolean isOriginalImg;
    private String lastAlbumId;
    public boolean mIsFromIm;
    private int maxImagesAllowed;

    public WriteImagesInfo() {
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.maxImagesAllowed = 1;
        this.mIsFromIm = false;
    }

    public WriteImagesInfo(int i) {
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.maxImagesAllowed = i;
    }

    public void addChooseFileFromAlbum(String str, String str2) {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str2);
        imageFileInfo.setTempFile(false);
        imageFileInfo.setAlbumnId(str);
        addChooseFile(imageFileInfo);
    }

    public void addChooseFileFromCamera(String str) {
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.setAlbumnId(null);
        imageFileInfo.setIsFromCamera(true);
        addChooseFile(imageFileInfo);
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.chosedFiles != null && imageFileInfo != null && imageFileInfo.getFilePath() != null) {
            Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && next.getFilePath() != null && next.getFilePath().equals(imageFileInfo.getFilePath())) {
                    this.chosedFiles.remove(next);
                    return;
                }
            }
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || TextUtils.isEmpty(imageFileInfo.getFilePath())) {
            return false;
        }
        if (this.chosedFiles == null || this.chosedFiles.size() == 0) {
            return false;
        }
        Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getFilePath()) && imageFileInfo.getFilePath().equals(next.getFilePath())) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<ImageFileInfo> getChosedFiles() {
        return this.chosedFiles;
    }

    public void setChosedFiles(LinkedList<ImageFileInfo> linkedList) {
        this.chosedFiles = linkedList;
    }

    public int getMaxImagesAllowed() {
        return this.maxImagesAllowed;
    }

    public void setMaxImagesAllowed(int i) {
        this.maxImagesAllowed = i;
    }

    public String getLastAlbumId() {
        return this.lastAlbumId;
    }

    public void setLastAlbumId(String str) {
        this.lastAlbumId = str;
    }

    public int size() {
        if (this.chosedFiles == null) {
            return 0;
        }
        return this.chosedFiles.size();
    }

    public void copyFrom(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo != null) {
            this.lastAlbumId = writeImagesInfo.lastAlbumId;
            this.maxImagesAllowed = writeImagesInfo.maxImagesAllowed;
            this.mIsFromIm = writeImagesInfo.mIsFromIm;
            this.chosedFiles = writeImagesInfo.chosedFiles;
            this.isOriginalImg = writeImagesInfo.isOriginalImg;
            this.isEnableChooseOriginalImg = writeImagesInfo.isEnableChooseOriginalImg;
        }
    }

    public void clear() {
        if (this.chosedFiles != null) {
            this.chosedFiles.clear();
        }
        this.isOriginalImg = false;
    }

    public void parseJson(String str) {
        if (!k.isEmpty(str)) {
            try {
                parseJson(new JSONObject(str));
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        if (json != null) {
            return json.toString();
        }
        return null;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lastAlbumId = jSONObject.optString("lastAlbumId", null);
            this.mIsFromIm = jSONObject.optBoolean("isIm", false);
            this.maxImagesAllowed = jSONObject.optInt("maxImagesAllowed");
            this.isOriginalImg = jSONObject.optBoolean("isOriginalImg");
            this.isEnableChooseOriginalImg = jSONObject.optBoolean("isEnableChooseOriginalImg");
            JSONArray optJSONArray = jSONObject.optJSONArray("chosedFiles");
            this.chosedFiles = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.parseJson(optJSONArray.optJSONObject(i));
                    imageFileInfo.setIsLong(l.eN(imageFileInfo.getFilePath()));
                    this.chosedFiles.add(imageFileInfo);
                }
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("maxImagesAllowed", this.maxImagesAllowed);
            jSONObject.put("isOriginalImg", this.isOriginalImg);
            jSONObject.put("isEnableChooseOriginalImg", this.isEnableChooseOriginalImg);
            if (this.lastAlbumId != null) {
                jSONObject.put("lastAlbumId", this.lastAlbumId);
            }
            jSONObject.put("isIm", this.mIsFromIm);
            if (this.chosedFiles != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
                while (it.hasNext()) {
                    ImageFileInfo next = it.next();
                    if (next != null) {
                        jSONArray.put(next.toJson());
                    }
                }
                jSONObject.put("chosedFiles", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void updateQuality() {
        LinkedList<ImageFileInfo> chosedFiles = getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() != 0) {
            Iterator<ImageFileInfo> descendingIterator = chosedFiles.descendingIterator();
            while (descendingIterator.hasNext()) {
                ImageFileInfo next = descendingIterator.next();
                if (next != null && !next.isHasAddPostQualityAction()) {
                    next.addPersistAction(com.baidu.tbadk.img.effect.d.K(aq.CG().CM(), aq.CG().CN()));
                    next.setHasAddPostQualityAction(true);
                }
            }
        }
    }

    public void setOriginalImg(boolean z) {
        this.isOriginalImg = z;
    }

    public boolean isOriginalImg() {
        return this.isOriginalImg;
    }

    public boolean isEnableChooseOriginalImg() {
        return this.isEnableChooseOriginalImg;
    }

    public void setEnableChooseOriginalImg(boolean z) {
        this.isEnableChooseOriginalImg = z;
    }

    public boolean hasActionsWithoutResize() {
        LinkedList<ImageFileInfo> chosedFiles = getChosedFiles();
        if (chosedFiles == null) {
            return false;
        }
        Iterator<ImageFileInfo> it = chosedFiles.iterator();
        while (it.hasNext()) {
            if (it.next().hasActionsWithoutResize()) {
                return true;
            }
        }
        return false;
    }
}
