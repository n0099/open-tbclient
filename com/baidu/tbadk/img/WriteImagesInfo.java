package com.baidu.tbadk.img;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.bb;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WriteImagesInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<WriteImagesInfo> CREATOR = new j();
    private LinkedList<ImageFileInfo> chosedFiles;
    private String lastAlbumId;
    private int maxImagesAllowed;

    public WriteImagesInfo() {
        this.maxImagesAllowed = 1;
    }

    public WriteImagesInfo(int i) {
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
            this.chosedFiles = writeImagesInfo.chosedFiles;
        }
    }

    public void clear() {
        if (this.chosedFiles != null) {
            this.chosedFiles.clear();
        }
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
            this.maxImagesAllowed = jSONObject.optInt("maxImagesAllowed");
            JSONArray optJSONArray = jSONObject.optJSONArray("chosedFiles");
            this.chosedFiles = new LinkedList<>();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.parseJson(optJSONArray.optJSONObject(i));
                    this.chosedFiles.add(imageFileInfo);
                }
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("maxImagesAllowed", this.maxImagesAllowed);
            if (this.lastAlbumId != null) {
                jSONObject.put("lastAlbumId", this.lastAlbumId);
            }
            if (this.chosedFiles != null) {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.chosedFiles.size()) {
                        break;
                    }
                    jSONArray.put(this.chosedFiles.get(i2).toJson());
                    i = i2 + 1;
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
            for (int size = chosedFiles.size() - 1; size >= 0; size--) {
                ImageFileInfo imageFileInfo = chosedFiles.get(size);
                if (!imageFileInfo.isHasAddPostQualityAction()) {
                    imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.z(bb.px().pD(), bb.px().pD()));
                    imageFileInfo.setHasAddPostQualityAction(true);
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String jsonString = toJsonString();
        if (jsonString == null) {
            jsonString = "";
        }
        parcel.writeString(jsonString);
    }
}
