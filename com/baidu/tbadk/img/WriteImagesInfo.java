package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import d.a.c.e.p.k;
import d.a.j0.b0.g.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WriteImagesInfo extends OrmObject implements Serializable {
    public LinkedList<ImageFileInfo> chosedFiles;
    public boolean isEnableChooseOriginalImg;
    public boolean isFromQRCode;
    public boolean isOriginalImg;
    public String lastAlbumId;
    public boolean mIsFromIm;
    public int maxImagesAllowed;

    public WriteImagesInfo() {
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.isFromQRCode = false;
        this.maxImagesAllowed = 1;
        this.mIsFromIm = false;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.chosedFiles == null) {
            this.chosedFiles = new LinkedList<>();
        }
        this.chosedFiles.add(imageFileInfo);
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

    public void clear() {
        LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
        if (linkedList != null) {
            linkedList.clear();
        }
        this.isOriginalImg = false;
    }

    public void copyFrom(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo == null) {
            return;
        }
        this.lastAlbumId = writeImagesInfo.lastAlbumId;
        this.maxImagesAllowed = writeImagesInfo.maxImagesAllowed;
        this.mIsFromIm = writeImagesInfo.mIsFromIm;
        this.chosedFiles = writeImagesInfo.chosedFiles;
        this.isOriginalImg = writeImagesInfo.isOriginalImg;
        this.isEnableChooseOriginalImg = writeImagesInfo.isEnableChooseOriginalImg;
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.chosedFiles == null || imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return;
        }
        Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next != null && next.getFilePath() != null && next.getFilePath().equals(imageFileInfo.getFilePath())) {
                this.chosedFiles.remove(next);
                return;
            }
        }
    }

    public LinkedList<ImageFileInfo> getChosedFiles() {
        return this.chosedFiles;
    }

    public ArrayList<String> getChosedUriStr() {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
        if (linkedList != null) {
            Iterator<ImageFileInfo> it = linkedList.iterator();
            while (it.hasNext()) {
                String contentUriStr = it.next().getContentUriStr();
                if (!TextUtils.isEmpty(contentUriStr)) {
                    arrayList.add(contentUriStr);
                }
            }
        }
        return arrayList;
    }

    public ImageFileInfo getImageInfoAt(int i2) {
        LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
        if (linkedList == null || i2 < 0 || i2 >= linkedList.size()) {
            return null;
        }
        return this.chosedFiles.get(i2);
    }

    public String getLastAlbumId() {
        return this.lastAlbumId;
    }

    public int getMaxImagesAllowed() {
        return this.maxImagesAllowed;
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

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        LinkedList<ImageFileInfo> linkedList;
        if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (linkedList = this.chosedFiles) != null && linkedList.size() != 0) {
            Iterator<ImageFileInfo> it = this.chosedFiles.iterator();
            while (it.hasNext()) {
                ImageFileInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.getFilePath()) && imageFileInfo.getFilePath().equals(next.getFilePath())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEnableChooseOriginalImg() {
        return this.isEnableChooseOriginalImg;
    }

    public boolean isFromQRCode() {
        return this.isFromQRCode;
    }

    public boolean isOriginalImg() {
        return this.isOriginalImg;
    }

    public void parseJson(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        try {
            parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setChosedFiles(LinkedList<ImageFileInfo> linkedList) {
        this.chosedFiles = linkedList;
    }

    public void setEnableChooseOriginalImg(boolean z) {
        this.isEnableChooseOriginalImg = z;
    }

    public void setFromQRCode(boolean z) {
        this.isFromQRCode = z;
    }

    public void setLastAlbumId(String str) {
        this.lastAlbumId = str;
    }

    public void setMaxImagesAllowed(int i2) {
        this.maxImagesAllowed = i2;
    }

    public void setOriginalImg(boolean z) {
        this.isOriginalImg = z;
    }

    public int size() {
        LinkedList<ImageFileInfo> linkedList = this.chosedFiles;
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
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
            jSONObject.put("isFromQRCode", this.isFromQRCode);
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
        } catch (JSONException e2) {
            BdLog.e(e2.getMessage());
            return null;
        }
    }

    public String toJsonString() {
        JSONObject json = toJson();
        if (json != null) {
            return json.toString();
        }
        return null;
    }

    public void updateQuality() {
        LinkedList<ImageFileInfo> chosedFiles = getChosedFiles();
        if (chosedFiles == null || chosedFiles.size() == 0) {
            return;
        }
        Iterator<ImageFileInfo> descendingIterator = chosedFiles.descendingIterator();
        while (descendingIterator.hasNext()) {
            ImageFileInfo next = descendingIterator.next();
            if (next != null && !next.isHasAddPostQualityAction()) {
                next.addPersistAction(d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                next.setHasAddPostQualityAction(true);
            }
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.lastAlbumId = jSONObject.optString("lastAlbumId", null);
        this.mIsFromIm = jSONObject.optBoolean("isIm", false);
        this.isFromQRCode = jSONObject.optBoolean("isFromQRCode", false);
        this.maxImagesAllowed = jSONObject.optInt("maxImagesAllowed");
        this.isOriginalImg = jSONObject.optBoolean("isOriginalImg");
        this.isEnableChooseOriginalImg = jSONObject.optBoolean("isEnableChooseOriginalImg");
        JSONArray optJSONArray = jSONObject.optJSONArray("chosedFiles");
        this.chosedFiles = new LinkedList<>();
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.parseJson(optJSONArray.optJSONObject(i2));
                imageFileInfo.setIsLong(FileHelper.checkIsLongImage(imageFileInfo.getFilePath()));
                this.chosedFiles.add(imageFileInfo);
            }
        }
    }

    public WriteImagesInfo(int i2) {
        this.mIsFromIm = false;
        this.isOriginalImg = false;
        this.isEnableChooseOriginalImg = true;
        this.isFromQRCode = false;
        this.maxImagesAllowed = i2;
    }
}
