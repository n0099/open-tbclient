package com.baidu.tieba.album;

import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private int RO;
    private WriteImagesInfo aib;
    private String aic;
    private List<ImageFileInfo> aid;

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aib == null) {
            this.aib = new WriteImagesInfo();
        }
        this.aib.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aib != null) {
            this.aib.delChooseFile(imageFileInfo);
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aib == null) {
            return false;
        }
        return this.aib.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> xV() {
        if (this.aib != null) {
            return this.aib.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.aib;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.aib = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aib != null) {
            return this.aib.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aib == null) {
            this.aib = new WriteImagesInfo();
        }
        this.aib.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aib != null) {
            return this.aib.getMaxImagesAllowed();
        }
        return 0;
    }

    public String xW() {
        return this.aic;
    }

    public void eo(String str) {
        this.aic = str;
    }

    public List<ImageFileInfo> xX() {
        return this.aid;
    }

    public void y(List<ImageFileInfo> list) {
        this.aid = list;
    }

    public int getCurrentIndex() {
        return this.RO;
    }

    public void dP(int i) {
        this.RO = i;
    }

    public int size() {
        if (this.aib == null) {
            return 0;
        }
        return this.aib.size();
    }
}
