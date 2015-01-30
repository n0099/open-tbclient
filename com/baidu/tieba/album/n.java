package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private List<a> aqa;
    private String aqe;
    private WriteImagesInfo aql;
    private List<ImageFileInfo> aqm;
    private List<ImageFileInfo> aqn;
    private String aqo;
    private int mCurrentIndex;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aql == null) {
            this.aql = new WriteImagesInfo();
        }
        this.aql.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aql != null) {
            this.aql.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aql == null) {
            return false;
        }
        return this.aql.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> BN() {
        if (this.aql != null) {
            return this.aql.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.aql;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.aql = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aql != null) {
            return this.aql.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aql == null) {
            this.aql = new WriteImagesInfo();
        }
        this.aql.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aql != null) {
            return this.aql.getMaxImagesAllowed();
        }
        return 0;
    }

    public String BO() {
        return this.aqe;
    }

    public void eX(String str) {
        this.aqe = str;
    }

    public List<ImageFileInfo> BP() {
        return this.aqm;
    }

    public void D(List<ImageFileInfo> list) {
        this.aqm = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public List<a> BQ() {
        return this.aqa;
    }

    public void E(List<a> list) {
        this.aqa = list;
    }

    public List<ImageFileInfo> BR() {
        return this.aqn;
    }

    public void F(List<ImageFileInfo> list) {
        this.aqn = list;
    }

    public int size() {
        if (this.aql == null) {
            return 0;
        }
        return this.aql.size();
    }

    public String BS() {
        return this.aqo;
    }

    public void eY(String str) {
        this.aqo = str;
    }
}
