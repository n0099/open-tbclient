package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private List<a> apX;
    private String aqb;
    private WriteImagesInfo aqi;
    private List<ImageFileInfo> aqj;
    private List<ImageFileInfo> aqk;
    private String aql;
    private int mCurrentIndex;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aqi == null) {
            this.aqi = new WriteImagesInfo();
        }
        this.aqi.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aqi != null) {
            this.aqi.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aqi == null) {
            return false;
        }
        return this.aqi.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> BH() {
        if (this.aqi != null) {
            return this.aqi.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.aqi;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.aqi = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aqi != null) {
            return this.aqi.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aqi == null) {
            this.aqi = new WriteImagesInfo();
        }
        this.aqi.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aqi != null) {
            return this.aqi.getMaxImagesAllowed();
        }
        return 0;
    }

    public String BI() {
        return this.aqb;
    }

    public void eU(String str) {
        this.aqb = str;
    }

    public List<ImageFileInfo> BJ() {
        return this.aqj;
    }

    public void D(List<ImageFileInfo> list) {
        this.aqj = list;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
    }

    public List<a> BK() {
        return this.apX;
    }

    public void E(List<a> list) {
        this.apX = list;
    }

    public List<ImageFileInfo> BL() {
        return this.aqk;
    }

    public void F(List<ImageFileInfo> list) {
        this.aqk = list;
    }

    public int size() {
        if (this.aqi == null) {
            return 0;
        }
        return this.aqi.size();
    }

    public String BM() {
        return this.aql;
    }

    public void eV(String str) {
        this.aql = str;
    }
}
